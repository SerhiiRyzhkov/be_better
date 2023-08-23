#!/bin/bash

TIMESTAMP=$(date +"%Y%m%d_%H%M%S")
BACKUP_DIR="/home/better/backups"
CONTAINER_NAME="mysql"

docker exec -i $CONTAINER_NAME mysqldump -u root -p'rootpassword' my_db > $BACKUP_DIR/db_backup_$TIMESTAMP.sql