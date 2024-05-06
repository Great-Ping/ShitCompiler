package lexicon.tokens.identifiers

import lexicon.tokens.Token
import lexicon.tokens.TokenTypes

class IdentifierToken(
    val name: String
) : Token(TokenTypes.IDENTIFIER) {
    override fun toString(): String {
        return "IdentifierToken($name)"
    }
}