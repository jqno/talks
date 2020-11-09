#!/usr/bin/env sh

PRESENTATION=$1
if [ -z "$PRESENTATION" ]; then
  echo "No presentation set"
  exit 1
fi

chokidar "$PRESENTATION/**/*.md" "$PRESENTATION/**/*.css" -c "./generate.sh $PRESENTATION"

