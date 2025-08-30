#!/bin/bash

# ------------------------------------------------------------
# This script automates building and deploying a Java project.
#
# Steps:
# 1. Validates that a server IP argument is provided.
# 2. Uses Maven to package the project into a JAR file.
# 3. Uploads the generated JAR to the remote server via `scp`.
# 4. Uploads the SQLite database file to the server as well.
#
# Handy for quick deployments in development or testing
# environments where a simple JAR + SQLite setup is enough.
# ------------------------------------------------------------

# Check for server ip argument
if [ -z "$1" ]; then
  echo "Error: No server IP provided."
  echo "Usage: $0 <server_ip>"
  exit 1
fi

SERVER_IP=$1

# Build & Package the project using Maven
echo "Packaging project..."
mvn clean package -q
echo "Project packaged [OK]"

# Upload the JAR to the remote server
echo "Uploading JAR..."
scp target/dev-1.0.0.jar root@$SERVER_IP:/root/
echo "JAR uploaded [OK]"

# Upload the SQLite database file to the remote server
echo "Uploading Database (sqlite)..."
scp storage/database.db  root@$SERVER_IP:/root/storage/database.db
echo "Database uploaded [OK]"

# Start app with nohup
# nohup → stands for “no hangup" it ignores the SIGHUP signal sent when terminal closes
#
# - `> app.log` → redirects standard output to a file.
# - `2>&1 → redirects standard error to the same file.
# - `&` → runs it in the background.
nohup java -jar dev-1.0.0.jar > app.log 2>&1 &
