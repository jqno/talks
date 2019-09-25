#!/usr/bin/env sh

DIR=$1
[ -z "$DIR" ] && DIR=.live

echo $DIR

mkdir -p $DIR
mkdir -p $DIR/images

cp -R ../-revealjs-3.8.0/* $DIR
cp src/talk.md $DIR
cp -R images/* $DIR/images
cp -R *.css $DIR
cp ../-assets/fonts.css $DIR
cp ../-assets/firacode/FiraCode-Regular.woff $DIR
cp ../-assets/tilburgsans/TilburgsAns-Regular.woff $DIR

KEYBOARD_OVERRIDE="\"{39:'next',37:'prev'}\""
pandoc --to=revealjs --standalone --slide-level=2 --template template.html  --variable revealjs-url=. --css=theme-modifications.css --variable hlcss=parallel-highlight.css --variable keyboard=$KEYBOARD_OVERRIDE --no-highlight --output=$DIR/index.html $DIR/talk.md

echo Open $DIR and run \`npm install\` followed by \`npm start\`

