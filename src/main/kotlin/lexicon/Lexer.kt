package lexicon

import lexicon.tokens.Token


// 1. Все функции/методы могут изменить состояние енумератора
interface Lexer {
    fun nextToken(): Result<Token>
}