package lexicon.tokenParsers

import lexicon.tokens.Token
import lexicon.tokens.identifiers.IdentifierToken
import toolkit.enumerators.CharEnumerator
import toolkit.enumerators.moveNext
import toolkit.enumerators.movePrevious

class IdentifierOrKeywordTokenParser(
) : TokenParser {
    private fun isFirstAllowedCharacter(symbol: Char): Boolean {
        return (symbol >= '@' && symbol <= 'Z')
                || (symbol >= 'a' && symbol <= 'z')
                || (symbol == '_')
    }


    private fun isSubsequentAllowedCharacter(symbol: Char): Boolean {
        return (symbol in 'A'..'Z')
                || (symbol in 'a'..'z')
                || (symbol == '_')
                || (symbol in '0'..'9')
    }

    override fun parse(enumerator: CharEnumerator): Token? {

        if (!enumerator.moveNext())
            return null;

        if (!isFirstAllowedCharacter(enumerator.current))
            return null;

        while (enumerator.moveNext()) {
            if(!isSubsequentAllowedCharacter(enumerator.current)) {
                enumerator.movePrevious();
                break
            }
        }

        return IdentifierToken()
    }
}