with import <nixpkgs> {};
let
  gems = bundlerEnv {
    name = "jekyll-website";
    ruby = ruby_3_1;
    gemdir = ./.;
  };
in mkShell {
  name = "nix-talks";

  packages = [ gems gems.wrappedRuby glibcLocales pandoc fd entr ];

  shellHook = ''
    alias watch-website="${gems}/bin/jekyll serve --watch"
    alias watch="${builtins.getEnv "PWD"}/bin/watch.sh"
    alias generate="${builtins.getEnv "PWD"}/bin.generate.sh"
    echo "Available commands:"
    echo " * watch-website Watch the website for updates"
    echo " * watch <p>     Watch presentation <p> for updates"
    echo " * generate <p>  Generate presentation <p>"
  '';
}
