package lexicon.tokenParsers

import lexicon.enumerators.CharEnumerator
import lexicon.enumerators.moveNext
import lexicon.enumerators.movePrevious
import lexicon.tokens.Token
import lexicon.tokens.identifiers.IdentifierToken
import lexicon.tokens.keywords.KeywordNames
import lexicon.tokens.keywords.KeywordToken

class IdentifierOrKeywordTokenParser(
) : TokenParser {

    companion object{
        val keywords: HashMap<String, KeywordNames> = hashMapOf(
            "val" to KeywordNames.VAL,
            "var" to KeywordNames.VAR,
            "if" to KeywordNames.IF,
            "func" to KeywordNames.FUNC,
            "return" to KeywordNames.RETURN
        )
    }

    private fun isFirstAllowedCharacter(symbol: Char): Boolean {
        return (symbol in '@'..'Z')
                || (symbol in 'a'..'z')
                || (symbol == '_')
    }


    private fun isSubsequentAllowedCharacter(symbol: Char): Boolean {
        return (symbol in 'A'..'Z')
                || (symbol in 'a'..'z')
                || (symbol == '_')
                || (symbol in '0'..'9')
    }

    override fun parse(
        enumerator: CharEnumerator
    ): Token? {
        if (!enumerator.moveNext())
            return null;

        var identifierName = StringBuilder();

        identifierName.append(enumerator.current);

        if (!isFirstAllowedCharacter(enumerator.current))
            return null;

        while (enumerator.moveNext()){
            if(!isSubsequentAllowedCharacter(enumerator.current)) {
                enumerator.movePrevious();
                break
            }

            identifierName.append(enumerator.current);
        }

        val strIdentifierName = identifierName.toString();
        val keyword = keywords.getOrDefault(strIdentifierName, null);

        if (keyword != null)
            return KeywordToken(keyword)

        return IdentifierToken(strIdentifierName)
    }
}