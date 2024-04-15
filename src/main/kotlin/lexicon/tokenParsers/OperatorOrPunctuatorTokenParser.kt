package lexicon.tokenParsers

import lexicon.enumerators.CharEnumerator
import lexicon.enumerators.moveNext
import lexicon.enumerators.movePrevious
import lexicon.tokens.Token
import lexicon.tokens.operatorOrPunctuatorTokens.OperatorOrPunctuatorToken
import lexicon.tokens.operatorOrPunctuatorTokens.Operators

class OperatorOrPunctuatorTokenParser : TokenParser {
    companion object {
        val operators = hashMapOf(
            "=" to Operators.EQUALLY,
            "(" to Operators.OPEN_BRACKET,
            ")" to Operators.CLOSE_BRACKET,
            ";" to Operators.SEMICOLON,
            ":" to Operators.COLON
        )
    }

    fun isPartOfOperator(){

    }

    override fun parse(enumerator: CharEnumerator): Token? {
        val enumeratorState = enumerator.currentIndex
        val operatorStringValue = StringBuilder();
        var operator: Operators? = null;

        while (enumerator.moveNext()) {
            operatorStringValue.append(enumerator.current);
            val newOperator = operators.getOrDefault(
                operatorStringValue.toString(),
                null
            );

            if (newOperator == null) {
                enumerator.movePrevious();
                break;
            }

            operator = newOperator;
        }

        if (operator == null)
            return null;

        return OperatorOrPunctuatorToken(operator)
    }
}