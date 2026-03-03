#!/bin/bash

find output -type f -mtime +7 -delete
find logs -type f -mtime +30 -delete

echo "Cleanup Done"