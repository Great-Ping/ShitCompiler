package lexicon

import lexicon.enumerators.CharEnumerator
import lexicon.exceptions.UndefinedTokenException
import lexicon.tokenParsers.*
import lexicon.tokens.CommonToken
import lexicon.tokens.Token
import lexicon.tokens.TokenTypes

class SimpleLexer(iterator: CharEnumerator) : Lexer {

    constructor(string: String): this(
        CharEnumerator(string)
    ) {}

    private var _iterator: CharEnumerator = iterator
    private val _parsers : Array<TokenParser> = arrayOf(
        CommentTokenParser(),
        OperatorOrPunctuatorTokenParser(),
        NumberTokenParser(),
        CharacterLiteralTokenParser(),
        StringLiteralTokenParser(),
        IdentifierOrKeywordTokenParser(),
    )

    override fun nextToken(): Result<Token> {
        skipWhitespaces(_iterator)

        if (!_iterator.hasNext())
            return Result.success(
                CommonToken(TokenTypes.END)
            );

        for (parser in _parsers) {
            val iteratorState = _iterator.currentIndex

            val parsedToken = parser.parse(
                _iterator
            )

            if (parsedToken == null) {
                _iterator.moveTo(iteratorState)
                continue
            }

            return Result.success(
                parsedToken
            )
        }

        return Result.failure(
            UndefinedTokenException("no parser recognized the token"));
    }

    override fun toString(): String {
        return "SimpleLexer: $_iterator"
    }
}
