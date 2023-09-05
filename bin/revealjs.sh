#!/usr/bin/env bash

PRESENTATION=$1
if [ -z "$PRESENTATION" ]; then
  echo "No presentation set"
  exit 1
fi

PRESENTATION="$PRESENTATION" docker-compose -f docker-compose.revealjs.yml up
