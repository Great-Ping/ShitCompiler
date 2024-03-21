package lexicon

import lexicon.tokens.Token

interface Lexer {
    fun nextToken(): Result<Token>
}