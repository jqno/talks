#!/bin/sh
chokidar '**/*.md' '**/*.css' -c 'pandoc --to=revealjs --standalone --slide-level=2 --template template.html  --variable revealjs-url=../../-revealjs-3.8.0 --css=../theme-modifications.css --variable hlcss=../parallel-highlight.css --no-highlight --output=src/index.html src/talk.md'

