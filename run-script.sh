#!/bin/bash
cd test/src
javac -cp pptx.jar testRectSave.java
java -cp pptx.jar: testRectSave
