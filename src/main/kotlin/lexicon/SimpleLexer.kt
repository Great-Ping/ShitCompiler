package lexicon

import lexicon.enumerators.CharEnumerator
import lexicon.enumerators.moveNext
import lexicon.tokenParsers.*
import lexicon.tokens.Token
import lexicon.tokens.UndefinedToken

class SimpleLexer(iterator: CharEnumerator) : Lexer {

    constructor(string: String): this(
        CharEnumerator(string)
    ) {}

    private var _iterator: CharEnumerator = iterator
    private var _buffer: Token? = null;
    private val _parsers : Array<TokenParser> = arrayOf(
        CommentTokenParser(),
        OperatorOrPunctuatorTokenParser(),
        NumberTokenParser(),
        CharacterLiteralTokenParser(),
        StringLiteralTokenParser(),
        IdentifierOrKeywordTokenParser(),
    )

    private fun tryGetToken() : Token?
    {
        skipWhitespaces(_iterator)

        if (!_iterator.hasNext())
            return EndToken(_iterator.currentIndex)

        for (parser in _parsers) {
            val iteratorState = _iterator.currentIndex

            val parsedToken = parser.parse(
                _iterator
            )

            if (parsedToken == null) {
                _iterator.moveTo(iteratorState)
                continue
            }

            return parsedToken;
        }
        return null
    }

    private fun selectUndefinedToken() : Token {
        var token: Token? = null
        val startIndex = _iterator.currentIndex + 1
        var endIndex: Int


        do {
            _iterator.moveNext()
            endIndex = _iterator.currentIndex
            token = tryGetToken()

        } while (token == null)

        _buffer = token

        return UndefinedToken(
            _iterator.getSubstring(startIndex, endIndex)
        )
    }


    override fun nextToken(): Token {
        var token: Token?
        if (_buffer != null) {
            token = _buffer;
            _buffer = null;
            return token as Token;
        }

        token = tryGetToken()
        if (token == null)
            token = selectUndefinedToken();

        return token;
    }

    override fun toString(): String {
        return "SimpleLexer: $_iterator"
    }
}
