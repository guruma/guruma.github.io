#!/bin/sh

echo "Deploying blog post..."
lein run

echo "Copying resources/public..."
copy -rf resources/public/* .

echo "git push blog post..."
git co -am "WIP"
git push
