#!/bin/bash

DATA='{"name": "andy", "nickname": "andypandy"}, {"name": "david", "nickname": "davipady"}'

echo -e "\n\n--- Testing doGet... ---\n\n"
curl -i http://localhost:8080/characters/get
echo -e "\n\n--- Testing doPost using ${DATA} ---\n\n"
curl -i -d "$DATA" -X POST http://localhost:8080/characters/add