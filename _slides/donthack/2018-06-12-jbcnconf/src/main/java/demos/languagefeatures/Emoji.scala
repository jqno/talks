package demos.languagefeatures

object Emoji extends App {

  type `🎻` = String
  type `🦄` = Unit
  type `🔀`[`😅`,`😘`] = `😅` => `😘`

  val `✋`: `🎻` `🔀` `🦄` = println

  val `👹` = "¡Hola "
  val `🍺` = "Barcelona!"

  `✋`(`👹` ⊕ `🍺`)

  implicit class `ᕕ( ᐛ )ᕗ`(`🎱`: `🎻`) {
    def ⊕(`🎸`: `🎻`): `🎻` = `🎱` + `🎸`
  }
}
