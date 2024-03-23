package lexicon

import lexicon.tokenParsers.*
import lexicon.tokens.Token
import toolkit.enumerators.CharEnumerator
import toolkit.results.Result
import toolkit.results.ResultState

class SimpleLexer(iterator: CharEnumerator) : Lexer {

    constructor(string: String): this(
        CharEnumerator(string)
    ) {}

    private var _iterator: CharEnumerator = iterator
    private val _parsers : Array<TokenParser> = arrayOf(
        CommentTokenParser(),
        OperatorOrPunctuatorTokenParser(),
        RealLiteralTokenParser(),
        IntegerLiteralTokenParser(),
        CharacterLiteralTokenParser(),
        StringLiteralTokenParser(),
        IdentifierOrKeywordTokenParser(),
    )

    override fun nextToken(): Result<Token> {
        for (parser in _parsers) {
            _iterator = sckipWhitespaces(_iterator)
            val parseResult = parser.parse(_iterator.clone());
            if (parseResult.state == ResultState.FAILED)
                continue

            val parsingInfo = parseResult.unwrap()
            _iterator = parsingInfo.Iterator
            return Result.ok(parsingInfo.Token);
        }

        return Result.fail(Exception("TODO"));
    }
}
