package lexicon.tokens

public final class CommonToken(
    public override val tokenType: TokenTypes
) : Token {
    override fun toString(): String {
        return "CommonToken: $tokenType.name"
    }
}