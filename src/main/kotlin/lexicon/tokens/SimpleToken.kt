package lexicon.tokens

public final class SimpleToken(
    public override val tokenType: TokenTypes
) : Token {
    override fun toString(): String {
        return tokenType.name
    }
}