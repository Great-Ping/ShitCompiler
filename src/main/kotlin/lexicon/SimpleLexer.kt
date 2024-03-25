package lexicon

import lexicon.tokenParsers.*
import lexicon.tokens.Token
import toolkit.enumerators.CharEnumerator
import toolkit.results.Result

class SimpleLexer   (iterator: CharEnumerator) : Lexer {

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
        skipWhitespaces(_iterator)

        if (!_iterator.hasNext())
            return Result.fail(Error("String ended"))

        for (parser in _parsers) {
            val iteratorState = _iterator.currentIndex
            val parsedToken = parser.parse(
                _iterator
            )

            if (parsedToken == null) {
                _iterator.moveTo(iteratorState)
                continue
            }

            return Result.ok(parsedToken)
        }

        return Result.fail(Exception("TODO"));
    }

    override fun toString(): String {
        return "SimpleLexer: $_iterator"
    }
}
