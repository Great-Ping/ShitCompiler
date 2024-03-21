package lexicon

import lexicon.tokenParsers.TokenParser
import lexicon.tokens.Token
import toolkit.iterators.StringIterator

final class SimpleLexer(iterator: StringIterator) : Lexer {

    private var _iterator: StringIterator = iterator
    private val _parsers : Array<TokenParser> = TODO()

    override fun nextToken(): Result<Token> {
        for (parser in _parsers) {
            TODO()
        }
        TODO()
    }
}
