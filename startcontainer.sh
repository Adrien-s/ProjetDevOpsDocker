#!/bin/bash

echo "SPRINGBOOT ON DOCKER initializing configuration"

#Starting JVM
echo "SPRINGBOOT ON DOCKER  : starting JVM"

cd $SPRINGBOOT_SOFTWARE_DIR
java ~Dspring.config.name=application \
    ~Dspring.profiles.active=prd \
    ~jar app.jar