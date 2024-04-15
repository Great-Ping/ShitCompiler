package lexicon.tokens.chars

import lexicon.tokens.Token
import lexicon.tokens.TokenTypes

class CharacterToken (
    val char: String
) : Token(TokenTypes.CHARACTER_LITERAL) {
    override fun toString(): String {
        return "CharacterToken($char)"
    }
}