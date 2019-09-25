#!/usr/bin/env sh

PRESENTATION=$1
if [ -z "$PRESENTATION" ]; then
  echo "No presentation set"
  exit 1
fi

DIR=".live"

mkdir -p $DIR
mkdir -p $DIR/images

cp -R -- -revealjs-3.8.0/* $DIR
cp $PRESENTATION/src/talk.md $DIR
cp -R $PRESENTATION/images/* $DIR/images
cp -R $PRESENTATION/*.css $DIR
cp -- -assets/fonts.css $DIR
cp -- -assets/firacode/FiraCode-Regular.woff $DIR
cp -- -assets/tilburgsans/TilburgsAns-Regular.woff $DIR

KEYBOARD_OVERRIDE="\"{39:'next',37:'prev'}\""
$PRESENTATION/generate.sh $PRESENTATION $DIR . .

echo Open $DIR and run \`npm install\` followed by \`npm start\`

