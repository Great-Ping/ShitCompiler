package lexicon.tokens

class InvalidToken(
    val intendedTypes: TokenTypes?,
    val value: String?,
    val errorMessage: String
) : Token(TokenTypes.INVALID){
    override fun toString(): String {
        return "InvalidToken($intendedTypes, $errorMessage)"
    }
}