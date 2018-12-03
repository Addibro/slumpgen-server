#!/bin/bash

DATA='{"name": "andy", "kin": "human"}, {"name": "david", "kin": "human"}'
RES='creeds'
TYPE='json'
echo -e "\n\n--- Testing doGet using localhost:8080/characters/fetch?type=$TYPE&res=$RES ---\n\n"
sleep 1

curl -s http://localhost:8080/characters/fetch?type=$TYPE&res=$RES
sleep 1
echo -e "\n\n--- Testing doPost using ${DATA} ---\n\n"
sleep 1
curl -i -d "$DATA" -X POST http://localhost:8080/characters/add