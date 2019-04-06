#!/bin/sh
pandoc --to=revealjs --standalone --slide-level=2 --variable revealjs-url=../../-revealjs-3.8.0 --css=../theme-modifications.css --highlight-style parallel.theme --output=src/index.html src/talk.md

