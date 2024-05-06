package lexicon.tokens.operatorOrPunctuatorTokens

import lexicon.tokens.Token
import lexicon.tokens.TokenTypes

class OperatorOrPunctuatorToken (
    val operator: Operators
): Token (
    TokenTypes.OPERATOR_OR_PUNCTUATOR
) {
    override fun toString(): String {
        return "<$operator, $lexemeTabelIndex>"
    }
}