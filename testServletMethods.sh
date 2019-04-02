#!/bin/bash

if [[ $# -ne 2 ]]
then
    echo "usage: testServletMethods [json] [names/nicknames/creeds]_[sv/en].json"
    exit 1
fi
TYPE=$1
RES=$2
echo -e "\n\n--- Testing doGet using localhost:8080/characters/fetch?type=$TYPE&res=$RES ---\n\n"
sleep 1
# need to quote it since shell sees & as the end of the command
if [[ TYPE -eq "image" ]]
then
    curl -s "http://localhost:8080/characters/fetch?type=$TYPE&res=$RES"
elif [[ TYPE -eq "json" ]]
then
    curl "http://localhost:8080/characters/fetch?type=$TYPE&res=$RES" | jq
fi