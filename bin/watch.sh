#!/usr/bin/env bash

PRESENTATION=$1
if [ -z "$PRESENTATION" ]; then
  echo "No presentation set"
  exit 1
fi

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
DIR="$SCRIPT_DIR/../_slides/$PRESENTATION"

echo "Watching $DIR"

fd . --extension md --extension css "$DIR" | entr "$SCRIPT_DIR/generate.sh" "$PRESENTATION"
