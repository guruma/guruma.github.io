#!/bin/sh

echo "Deploying blog post..."
# lein run

echo "Deleting copyed files..."
rm -rf archives authors css img js pages posts tags

echo "Copying resources/public..."
cp -rf resources/public/* .

echo "git push blog post..."
git add .
git co -am "WIP"
git push
