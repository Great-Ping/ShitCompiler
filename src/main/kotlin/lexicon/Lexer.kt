package lexicon

import lexicon.tokens.Token
import toolkit.results.Result

interface Lexer {
    fun nextToken(): Result<Token>
}