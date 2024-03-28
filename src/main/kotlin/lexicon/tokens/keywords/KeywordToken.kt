package lexicon.tokens.keywords

import lexicon.tokens.Token
import lexicon.tokens.TokenTypes

class KeywordToken(
    val keyword: Keyword
): Token(TokenTypes.KEYWORD) {

}
