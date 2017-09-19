#!/bin/sh

echo "Deploying blog post..."
lein run

echo "Copying resources/public..."
cp -rf resources/public/* .

echo "git push blog post..."
git add .
git co -am "WIP"
git push
