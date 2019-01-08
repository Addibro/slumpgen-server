#!/bin/bash


SEPARATOR=":"

if [[ $OS == "Windows_NT" ]] || [[ $OSTYPE == "cygwin" ]]
then
    SEPARATOR=";"
fi


echo "Compiling..."
javac -Xlint:unchecked -cp winstone.jar${SEPARATOR}www/WEB-INF/classes -d bin src/com/alming/slumpgen/storage/*.java src/com/web/http/*.java src/com/web/servlets/*.java
#javac -Xlint:unchecked -cp winstone.jar${SEPARATOR}www/WEB-INF/classes -d www/WEB-INF/classes src/com/alming/slumpgen/storage/*.java src/com/web/http/*.java src/com/web/servlets/*.java



# [[ $? = 0 ]] && echo -e "\nCompilation successful!" || echo -e "\n\nError compiling Servlet.java"
