package lexicon.tokens.keywords

import lexicon.tokens.Token
import lexicon.tokens.TokenTypes

class KeywordToken(
    val keywordName: KeywordNames
): Token(TokenTypes.KEYWORD) {
    override fun toString(): String {
        return "KeywordToken($keywordName)"
    }
}
