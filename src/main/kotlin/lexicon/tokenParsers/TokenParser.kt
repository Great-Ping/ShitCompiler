package lexicon.tokenParsers

import lexicon.tokens.Token

interface TokenParser {
    fun parse(str: String): Token
}