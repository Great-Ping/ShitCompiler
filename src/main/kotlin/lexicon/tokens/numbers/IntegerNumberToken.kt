package lexicon.tokens.numbers

import lexicon.tokens.TokenTypes

class IntegerNumberToken(
    stringValue: String,
    numberSystem: NumberSystem
) : NumberToken(stringValue, numberSystem, TokenTypes.INTEGER_LITERAL) {
}