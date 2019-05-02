#!/bin/sh

# My Logitech Spotlight only sends arrow-right and arrow-left which move right and left. We want the Spotlight to move down and up instead. This fixes that:
KEYBOARD_OVERRIDE="\"{39:'next',37:'prev'}\""

chokidar '**/*.md' '**/*.css' -c "pandoc --to=revealjs --standalone --slide-level=2 --template template.html  --variable revealjs-url=../../-revealjs-3.8.0 --css=../theme-modifications.css --variable hlcss=../parallel-highlight.css --variable keyboard=$KEYBOARD_OVERRIDE --no-highlight --output=src/index.html src/talk.md"

