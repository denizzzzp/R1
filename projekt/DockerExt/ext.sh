#!/bin/bash
SEDCMD="'s/DOCKERENV/"$1"/g'"
eval sed $SEDCMD /DockerExt/index.text > /usr/share/nginx/html/index.html
exec nginx -g 'daemon off;'