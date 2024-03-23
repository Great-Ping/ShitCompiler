package lexicon

import lexicon.tokenParsers.TokenParser
import lexicon.tokenParsers.sckipWhitespaces
import lexicon.tokens.Token
import toolkit.enumerators.CharEnumerator
import toolkit.results.Result
import toolkit.results.ResultState

class SimpleLexer(iterator: CharEnumerator) : Lexer {

    private var _iterator: CharEnumerator = iterator
    private val _parsers : Array<TokenParser> = {}

    override fun nextToken(): Result<Token> {
        for (parser in _parsers) {
            _iterator = sckipWhitespaces(_iterator)

            val parseResult = parser.parse(_iterator);
            if (parseResult.state == ResultState.FAILED)
                continue

            val parsingInfo = parseResult.unwrap()

            return Result.ok(parsingInfo.Token);
        }

        return Result.fail(Exception("TODO"));
    }
}
