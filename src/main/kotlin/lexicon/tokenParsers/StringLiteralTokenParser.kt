package lexicon.tokenParsers

import lexicon.enumerators.CharEnumerator
import lexicon.enumerators.moveNext
import lexicon.tokens.InvalidToken
import lexicon.tokens.StringLiteralToken
import lexicon.tokens.Token
import lexicon.tokens.TokenTypes

class StringLiteralTokenParser: TokenParser {
    override fun parse(enumerator: CharEnumerator): Token? {
        if (!enumerator.moveNext())
            return null

        if (enumerator.current != '"')
            return null

        val stringLiteral = StringBuilder();

        var completed = false;
        while (enumerator.moveNext()) {
            var symbol = enumerator.current;
            if (symbol == '"') {
                completed = true;
                break;
            }

            if (symbol == '\\') {
                var escapeCharacter = determineEscapeCharacter(enumerator);
                if (escapeCharacter != null)
                    symbol = escapeCharacter;
            }

            stringLiteral.append(symbol);
        }

        val stringToken = StringLiteralToken(
            stringLiteral.toString()
        );

        if (!completed)
            return InvalidToken(
                TokenTypes.STRING_LITERAL,
                stringToken.value,
                "Token is not completed"
            )

        return stringToken;
    }
}