#!/bin/bash

cd ..
HELIUM_HOME=$(pwd)
java -jar $HELIUM_HOME/lib/helium.jar cfg=$HELIUM_HOME/cfg/server.properties


