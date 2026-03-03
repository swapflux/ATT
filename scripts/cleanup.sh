#!/bin/bash

LOG_DIR="./logs"
EDI_DIR="./output"

RETENTION_DAYS=7

echo "Starting cleanup process..."

if [ -d "$LOG_DIR" ]; then
    find "$LOG_DIR" -type f -mtime +$RETENTION_DAYS -delete
    echo "Old log files cleaned."
else
    echo "Log directory not found."
fi

if [ -d "$EDI_DIR" ]; then
    find "$EDI_DIR" -type f -name "*.txt" -mtime +$RETENTION_DAYS -delete
    echo "Old EDI files cleaned."
else
    echo "EDI directory not found."
fi

echo "Cleanup completed."