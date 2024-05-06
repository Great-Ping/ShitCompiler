package lexicon.tokens.numbers

import lexicon.tokens.TokenTypes

class RealNumberToken(
    stringValue: String
): NumberToken(
    stringValue,
    NumberSystem.DECIMAL,
    TokenTypes.REAL_NUMBER_LITERAL
) {
}