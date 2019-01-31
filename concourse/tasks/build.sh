#!/bin/sh

set -e

demo/mvnw package

echo demo/mvnw org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate \
    -Dexpression=project.version

ls demo/target
#cp demo/target/