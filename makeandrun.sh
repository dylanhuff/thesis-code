#!/bin/bash
cd JavaPPTX
Make
cd ..
cd test/src
javac -cp pptx.jar PPOrbitalMechanics.java
java -cp pptx.jar: PPOrbitalMechanics
cd ..
http-server -o
