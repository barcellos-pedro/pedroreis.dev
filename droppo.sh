#!/bin/bash

# ------------------------------------------------------------
# Automated build & deploy script for Java + SQLite project
# ------------------------------------------------------------

if [ -z "$1" ] || [ -z "$2" ]; then
  echo "Usage: $0 <server_ip> <ssh_private_key>"
  exit 1
fi

# ------------------------------------------------------------
# Variables & Functions
# ------------------------------------------------------------

SERVER_IP=$1
KEY=$2
DB_PATH=database.db

check_success() {
  if [ $1 -ne 0 ]; then
    echo "❌ Error: $2"
    exit 1
  fi
}

# ------------------------------------------------------------
# Step 1 Prepare project package
# ------------------------------------------------------------

echo "📦 Packaging project..."
mvn clean package -q
check_success $? "Maven build failed."
echo "✅ Project packaged"

# ------------------------------------------------------------
# Step 2 - Get Latest Jar
# ------------------------------------------------------------

LATEST_JAR=$(ls -t target/*.jar 2>/dev/null | head -n 1)

if [ -z "$LATEST_JAR" ]; then
  echo "❌ No JAR found in target/ folder."
  exit 1
fi

echo "📝 Latest JAR detected: $LATEST_JAR"

# ------------------------------------------------------------
# Step 3 - Upload files via rsync
# ------------------------------------------------------------

echo "🚀 Uploading files..."
rsync -avz -e "ssh -i $KEY" "$LATEST_JAR" "$DB_PATH" root@$SERVER_IP:/root/
check_success $? "Failed to upload files."
echo "✅ Files uploaded"

# ------------------------------------------------------------
# Step 4 - Access remote server and start app
# ------------------------------------------------------------

echo "▶️ Preparing remote directories and starting app..."

ssh -i "$KEY" root@$SERVER_IP << EOF
# Start the app with nohup, redirecting logs
nohup java -jar /root/$(basename $LATEST_JAR) > /root/app.log 2>&1 &
EOF

check_success $? "Failed to start application."

echo "✅ Deployment completed successfully"
