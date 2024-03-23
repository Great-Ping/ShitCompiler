package lexicon

import lexicon.tokens.Token
import toolkit.enumerators.CharEnumerator

data class ParsingInfo (
    val Iterator: CharEnumerator,
    val Token: Token
){
}