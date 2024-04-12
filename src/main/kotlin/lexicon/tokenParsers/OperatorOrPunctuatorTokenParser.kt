package lexicon.tokenParsers

import lexicon.tokens.Token
import lexicon.tokens.operatorOrPunctuatorTokens.OperatorOrPunctuatorToken
import lexicon.tokens.operatorOrPunctuatorTokens.Operators
import toolkit.enumerators.CharEnumerator
import toolkit.enumerators.moveNext
import toolkit.enumerators.movePrevious

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

            if (newOperator == null)
                break;

            operator = newOperator;
        }

        if (operator == null)
            return null;

        enumerator.movePrevious()
        return OperatorOrPunctuatorToken(operator)
    }
}