package lexicon.tokens

public open class CommonToken(
   tokenType: TokenTypes
) : Token(tokenType) {
    override fun toString(): String {
        return "CommonToken: $tokenType.name"
    }
}