#!/bin/bash

# ------------------------------------------------------------
#             Automated build & deploy script
# ------------------------------------------------------------

if [ -z "$1" ] || [ -z "$2" ]; then
  echo "Usage: $0 <server_ip> <ssh_private_key>"
  exit 1
fi

SERVER_IP=$1
KEY=$2

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
rsync -avz --progress -e "ssh -i $KEY" "$LATEST_JAR" root@$SERVER_IP:/root/
check_success $? "Failed to upload files."
echo "✅ Files uploaded"

# ------------------------------------------------------------
# Step 4 - Restart systemd service
# ------------------------------------------------------------

echo "🔄 Restarting service on remote server..."

ssh -i "$KEY" root@$SERVER_IP << EOF
systemctl daemon-reload
systemctl restart myapp.service
systemctl status myapp.service --no-pager -l
EOF

check_success $? "Failed to restart application."

echo "✅ Deployment completed successfully"
