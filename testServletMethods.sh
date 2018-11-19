#!/bin/bash

DATA='{"name": "andy", "nickname": "andypandy"}, {"name": "david", "nickname": "davipady"}'

echo -e "Testing doGet...\n\n"
curl -i http://localhost:8080/characters/get
echo -e "\n\nTesting doPost using ${DATA}\n"
curl -i -d "$DATA" -X POST http://localhost:8080/characters/add