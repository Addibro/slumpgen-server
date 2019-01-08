#!/bin/bash

echo "Running servlet... at $(date)"
echo "pwd: $(pwd)"
java -jar winstone.jar --webroot=www 

