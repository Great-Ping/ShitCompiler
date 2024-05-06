package lexicon.tokens

class UndefinedToken (
    val value: String
) : Token(TokenTypes.UNDEFINED) {
    override fun toString(): String {
        return "<id, 0>(Лексема: $value)"
    }
}