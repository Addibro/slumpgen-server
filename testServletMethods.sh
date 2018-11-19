#!/bin/bash


echo -e "Testing doGet...\n\n"
curl -i http://localhost:8080/characters/get
echo -e "\n\nTesting doPost...\n"
curl -i -d '{"name": "andy"}, {"name": "david"}' -X POST http://localhost:8080/characters/add