package lexicon.tokens

class InvalidToken(
    val token: Token,
    val errorMessage: String
) : Token(TokenTypes.INVALID){
    override fun toString(): String {
        return "InvalidToken($token, $errorMessage)"
    }
}