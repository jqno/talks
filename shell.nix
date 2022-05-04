with import <nixpkgs> {};
let
  gems = bundlerEnv {
    name = "jekyll-website";
    ruby = ruby_3_1;
    gemdir = ./.;
  };
in mkShell {
  name = "nix-talks";

  packages = [ gems gems.wrappedRuby glibcLocales ];

  shellHook = ''
    alias watch-website="${gems}/bin/jekyll serve --watch"
  '';
}
