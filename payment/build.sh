#!/bin/bash
set -u
APP_VERSION=$(mvn -f pom.xml org.apache.maven.plugins:maven-help-plugin:3.0.0:evaluate -Dexpression=project.version | grep -v '\[')
docker build --no-cache -f ./Dockerfile --build-arg APP_VERSION=${APP_VERSION} -t payment:latest .
