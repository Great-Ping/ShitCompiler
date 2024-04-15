package lexicon.tokenParsers

import lexicon.enumerators.CharEnumerator
import lexicon.tokens.Token

interface TokenParser {
    //Работает на упреждение
    fun parse(enumerator: CharEnumerator): Token?
}