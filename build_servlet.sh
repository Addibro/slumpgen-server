#!/bin/bash

echo "Compiling Servlet.java..."

SEPARATOR=":"

if [[ $OS == "Windows_NT" ]] || [[ $OSTYPE == "cygwin" ]]
then
    SEPARATOR=";"
fi

javac -Xlint:unchecked -cp winstone.jar${SEPARATOR}www/WEB-INF/lib/* -d ../bin www/WEB-INF/classes/com/web/servlets/Servlet.java
[[ $? = 0 ]] && echo -e "Compilation successful" || echo -e "\n\nError compiling Servlet.java"
