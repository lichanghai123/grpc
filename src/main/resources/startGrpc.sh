#!/bin/bash

echo "start grpc"
nohup java -Xdebug -Xrunjdwp:transport=dt_socket,address=25025,server=y,suspend=n -Xms512M -Xmx512M -Xmn256M -Xss256K  -jar grpc-0.0.1-SNAPSHOT.jar >nohup.out 2>&1 &
echo "end start grpc"