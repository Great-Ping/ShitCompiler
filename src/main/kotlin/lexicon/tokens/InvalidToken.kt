package lexicon.tokens

class InvalidToken(
    val errorMessage: String
) : Token(TokenTypes.INVALID){
    override fun toString(): String {
        return "InvalidToken: $errorMessage"
    }
}