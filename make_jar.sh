#!/bin/bash

echo "Creating jar file"
cd bin
jar cf com.alming.jar com

mv com.alming.jar ../www/WEB-INF/lib/
