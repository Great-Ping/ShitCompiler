package lexicon

import lexicon.tokens.Token
import toolkit.results.Result


// 1. Все функции/методы могут изменить состояние енумератора
interface Lexer {
    fun nextToken(): Result<Token>
}