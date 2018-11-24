#!/bin/bash

DATA='{"name": "andy", "kin": "human"}, {"name": "david", "kin": "human"}'
QUERY='creeds'
echo -e "\n\n--- Testing localhost:8080/characters/fetch?res=$QUERY ---\n\n"
sleep 1

curl -s http://localhost:8080/characters/fetch?res=$QUERY | jq
sleep 1
echo -e "\n\n--- Testing doPost using ${DATA} ---\n\n"
sleep 1
curl -i -d "$DATA" -X POST http://localhost:8080/characters/add