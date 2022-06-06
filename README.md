This repo contains my talks.

# Usage

## Slides

- Requires `pandoc` 2.7+ to generate slides.
- Requires `fd` and `entr` to watch files.
- run `bin/generate.sh <name-of-presentation>` to generate the html file for the presentation located in the `_slides/<name-of-presentation>` folder.
- run `bin/watch.sh <name-of-presentation>` to watch for changes in files for the presentation located in the `_slides/<name-of-presentation>` folder, and re-generate it automatically.

In case assets don't load properly in Firefox, open `about:config` and disable the option `security.fileuri.strict_origin_policy`.

## Website

Start the Jekyll server by running `docker-compose up`.

# Credits

- [Reveal.js](https://revealjs.com/).
- Font [TilburgsAns](https://www.tilburgsans.nl/). See its license [here](assets/tilburgsans/Ans%20Font%20License-AFL.pdf).
- Font [FiraCode](https://github.com/tonsky/FiraCode)
