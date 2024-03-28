package lexicon

import lexicon.exceptions.EndOfInputException
import lexicon.exceptions.UndefinedTokenException
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
            return Result.fail(
                EndOfInputException("Input ended"))

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

        return Result.fail(
            UndefinedTokenException("no parser recognized the token"));
    }

    override fun toString(): String {
        return "SimpleLexer: $_iterator"
    }
}
