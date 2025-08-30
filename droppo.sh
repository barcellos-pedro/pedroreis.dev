#!/bin/bash

# ------------------------------------------------------------
# Automated build & deploy script for Java + SQLite project
# Uses latest JAR automatically and a dedicated workdir structure
# ------------------------------------------------------------

SCRIPT=$0

# Check arguments
if [ -z "$1" ] || [ -z "$2" ]; then
  echo "Usage: $SCRIPT <server_ip> <ssh_private_key>"
  exit 1
fi

SERVER_IP=$1
KEY=$2
WORKDIR="/root/app"           # Base workdir on the server
LOGDIR="$WORKDIR/logs"        # Logs folder
STORAGEDIR="$WORKDIR/storage" # SQLite folder

# Function to check command exit status
check_success() {
  if [ $1 -ne 0 ]; then
    echo "❌ Error: $2"
    exit 1
  fi
}

# 1️⃣ Build & Package locally
echo "📦 Packaging project..."
mvn clean package -q
check_success $? "Maven build failed."
echo "✅ Project packaged"

# 2️⃣ Find the latest JAR in target/
LATEST_JAR=$(ls -t target/*.jar 2>/dev/null | head -n 1)
if [ -z "$LATEST_JAR" ]; then
  echo "❌ No JAR found in target/ folder."
  exit 1
fi
echo "📝 Latest JAR detected: $LATEST_JAR"

# 3️⃣ Upload JAR and SQLite DB in one go using rsync
echo "🚀 Uploading files..."
rsync -avz -e "ssh -i $KEY" "$LATEST_JAR" storage/database.db root@$SERVER_IP:$WORKDIR/
check_success $? "Failed to upload files."
echo "✅ Files uploaded"

# 4️⃣ Run remote commands in one SSH session
echo "▶️ Preparing remote directories and starting app..."

ssh -i "$KEY" root@$SERVER_IP << EOF
# Ensure workdir structure exists
mkdir -p "$WORKDIR"
mkdir -p "$LOGDIR"
mkdir -p "$STORAGEDIR"

# Move SQLite database to storage folder
mv "$WORKDIR/database.db" "$STORAGEDIR/" 2>/dev/null || true

# Start the app with nohup, redirecting logs
nohup java -jar "$WORKDIR/$(basename $LATEST_JAR)" > "$LOGDIR/app.log" 2>&1 &
EOF

check_success $? "Failed to run remote commands."

echo "✅ Remote setup and app start completed"
echo "🎉 Deployment completed successfully!"
