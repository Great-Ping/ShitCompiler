package lexicon.tokenParsers

import lexicon.enumerators.CharEnumerator
import lexicon.enumerators.moveNext
import lexicon.tokens.InvalidToken
import lexicon.tokens.Token
import lexicon.tokens.chars.CharacterToken

class CharacterLiteralTokenParser : TokenParser {
    override fun parse(enumerator: CharEnumerator): Token? {

        if (!enumerator.moveNext())
            return null;

        if (enumerator.current != '\'')
            return null;

        var char = StringBuilder();
        var completed = false;
        var shielding = false;

        while (enumerator.moveNext()){
            val symbol = enumerator.current
            if (symbol == '\'' && !shielding){
                completed = true;
                break;
            }

            shielding = symbol == '\\'

            char.append(symbol);
        }

        val token = CharacterToken(char.toString());

        if (!completed)
            return InvalidToken(
                token,
                "Token is not completed"
            )

        if (char.length != 1 && !char.startsWith('\\')) {
            return InvalidToken(
                token,
                "Invalid character")
        }

        return CharacterToken(char.toString());
    }
}