package lexicon.tokens

class CommentToken(
    val value: String
) : Token(
    TokenTypes.COMMENT
) {

    override fun toString(): String {
        return "CommentToken($value)"
    }
}