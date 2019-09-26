#!/bin/sh

PRESENTATION=$1
if [ -z "$PRESENTATION" ]; then
  echo "No presentation set"
  exit 1
fi

SOURCES_DIR="$PRESENTATION/src"
REVEAL_DIR="../../-revealjs-3.8.0"
CSS_DIR=".."
[ -n "$2" ] && SOURCES_DIR=$2
[ -n "$3" ] && REVEAL_DIR=$3
[ -n "$4" ] && CSS_DIR=$4

# My Logitech Spotlight only sends arrow-right and arrow-left which move right and left. We want the Spotlight to move down and up instead. This fixes that:
KEYBOARD_OVERRIDE="{39:'next',37:'prev'}"

pandoc \
  --to=revealjs \
  --standalone \
  --slide-level=2 \
  --template $PRESENTATION/template.html \
  --variable revealjs-url=$REVEAL_DIR \
  --css=$CSS_DIR/theme-modifications.css \
  --variable hlcss=$CSS_DIR/parallel-highlight.css \
  --variable keyboard=$KEYBOARD_OVERRIDE \
  --no-highlight \
  --output=$SOURCES_DIR/index.html \
  $SOURCES_DIR/talk.md

