#!/bin/sh

echo "Deploying blog post..."
lein run
copy -rf resources/public/* .
git co -am "WIP"
git push
