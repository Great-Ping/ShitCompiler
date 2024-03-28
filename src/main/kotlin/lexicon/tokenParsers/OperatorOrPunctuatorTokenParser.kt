package lexicon.tokenParsers

import lexicon.tokens.Token
import lexicon.tokens.operatorOrPunctuatorTokens.OperatorOrPunctuatorToken
import lexicon.tokens.operatorOrPunctuatorTokens.Operators
import toolkit.enumerators.CharEnumerator

class OperatorOrPunctuatorTokenParser : TokenParser {
    override fun parse(enumerator: CharEnumerator): Token? {
        val enumeratorState = enumerator.currentIndex

        for (punctuatorType in Operators.entries) {
            if (continuesWith(enumerator, punctuatorType.stringValue))
                return OperatorOrPunctuatorToken(punctuatorType)

            enumerator.moveTo(enumeratorState)
        }
        return null;
    }
}