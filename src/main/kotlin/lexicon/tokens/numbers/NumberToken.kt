package lexicon.tokens.numbers

import lexicon.tokens.Token
import lexicon.tokens.TokenTypes

abstract class NumberToken(
    val stringValue: String,
    val numberSystem: NumberSystem,
    numberType: TokenTypes
) : Token(numberType) {

    override fun toString(): String {
        return "NumberToken(${stringValue}, ${numberSystem})"
    }
}