#!/bin/sh
pandoc --to=revealjs --standalone --variable revealjs-url=../../_revealjs-3.8.0 --css=../theme-modifications.css --highlight-style zenburn --output=src/index.html src/talk.md

