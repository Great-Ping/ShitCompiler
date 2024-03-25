package lexicon.tokenParsers

import lexicon.tokens.Token
import toolkit.enumerators.CharEnumerator

interface TokenParser {
    //Работает на упреждение
    fun parse(enumerator: CharEnumerator): Token?
}