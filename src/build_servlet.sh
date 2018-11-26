#!/bin/bash


SEPARATOR=":"

if [[ $OS == "Windows_NT" ]] || [[ $OSTYPE == "cygwin" ]]
then
    SEPARATOR=";"
fi

echo "Compiling..."
javac -Xlint:unchecked -cp winstone.jar${SEPARATOR}www/WEB-INF/lib/* www/WEB-INF/classes/com/alming/slumpgen/characters/*.java www/WEB-INF/classes/com/alming/slumpgen/storage/*.java www/WEB-INF/classes/com/web/json/*.java www/WEB-INF/classes/com/web/http/*.java www/WEB-INF/classes/com/web/servlets/*.java
[[ $? = 0 ]] && echo -e "\nCompilation successful!" || echo -e "\n\nError compiling Servlet.java"
