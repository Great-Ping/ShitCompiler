package lexicon.tokens

class StringLiteralToken(
    val value: String
): Token(TokenTypes.STRING_LITERAL) {
    override fun toString(): String {
        return "<id, $lexemeTabelIndex>(StringToken $value)"
    }
}