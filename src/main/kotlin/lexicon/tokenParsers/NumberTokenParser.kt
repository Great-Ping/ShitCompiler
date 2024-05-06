package lexicon.tokenParsers

import lexicon.enumerators.CharEnumerator
import lexicon.enumerators.moveNext
import lexicon.enumerators.movePrevious
import lexicon.tokens.InvalidToken
import lexicon.tokens.Token
import lexicon.tokens.TokenTypes
import lexicon.tokens.numbers.IntegerNumberToken
import lexicon.tokens.numbers.NumberSystem
import lexicon.tokens.numbers.RealNumberToken

class NumberTokenParser : TokenParser {
    companion object{
        val separator = '.';
    }

    private fun containsInBinaryAlphabet(
        symbol: Char
    ) : Boolean {
        return symbol in arrayOf('0', '1');
    }

    private fun containsInHexedecimalAlphabet(
        symbol: Char
    ) : Boolean {
        return symbol.isDigit()
            || symbol in 'A'..'F'
            || symbol in 'a'..'f'
    }

    private fun containsInDecimalAlphabet(
        symbol: Char
    ) : Boolean {
        return symbol.isDigit()
    }

    private fun chooseNumberSystem(
        numberValue: StringBuilder,
    ) : NumberSystem {
        if (numberValue.last() == 'x')
            return NumberSystem.HEXADECIMAL
        if (numberValue.last() == 'b')
            return  NumberSystem.BINARY

        return NumberSystem.DECIMAL
    }

    private fun getNumberSystemAlphabet(
        numberSystem: NumberSystem
    ) = when(numberSystem){
            NumberSystem.BINARY -> ::containsInBinaryAlphabet
            NumberSystem.DECIMAL -> ::containsInDecimalAlphabet
            NumberSystem.HEXADECIMAL -> ::containsInHexedecimalAlphabet
        }

    private fun getNumberSystemTail(
        numberSystem: NumberSystem
    ) = when(numberSystem) {
        NumberSystem.DECIMAL -> ::isDecimalTail
        else -> ::isOtherSystemTail
    }

    private fun isDecimalTail(symbol: Char) =
        symbol in setOf('f', 'l')

    private fun isOtherSystemTail(symbol: Char) =
        false

    private fun parseNumberSystem(
        enumerator: CharEnumerator,
        numberValue: StringBuilder,
        numberSystem: NumberSystem
    ) : Token {
        val containsInAlphabet = getNumberSystemAlphabet(numberSystem);
        val isTail = getNumberSystemTail(numberSystem);
        var separatorsCount = if (numberValue.last() == separator) 1 else 0;
        var numberSystemIsValid = true;

        while (enumerator.moveNext()) {
            val symbol = enumerator.current;

            val isAlphabetSymbol = containsInAlphabet(symbol)
            val isDigit = symbol.isDigit()
            val isSparator = symbol == separator

            if (isDigit && !isAlphabetSymbol) {
                numberSystemIsValid = false
            }

            if (!(isAlphabetSymbol || isDigit || isSparator)){
                enumerator.movePrevious()
                break
            }

            if (isSparator) {
                separatorsCount++;
            }

            numberValue.append(symbol)

            if (isTail(symbol)){
                break
            }
        }

        if (separatorsCount == 0 && numberSystemIsValid)
            return IntegerNumberToken(
                numberValue.toString(),
                numberSystem
            )

        if (separatorsCount == 1
            && numberSystem == NumberSystem.DECIMAL
            && numberSystemIsValid)
            return RealNumberToken(numberValue.toString())


        if (!numberSystemIsValid)
            return InvalidToken(
                TokenTypes.REAL_NUMBER_LITERAL or TokenTypes.INTEGER_LITERAL,
                numberValue.toString(),
                "Invalid number system"
            )

        return InvalidToken(
            TokenTypes.REAL_NUMBER_LITERAL or TokenTypes.INTEGER_LITERAL,
            numberValue.toString(),
            "Invalid number"
        )
    }

    override fun parse(enumerator: CharEnumerator): Token? {
        if (!enumerator.moveNext())
            return null

        var symbol = enumerator.current;
        if (!symbol.isDigit())
            return null;

        var numberValue = StringBuilder();
        numberValue.append(symbol);

        if (!enumerator.moveNext())
            return IntegerNumberToken(
                numberValue.toString(),
                NumberSystem.DECIMAL
            )

        symbol = enumerator.current;
        numberValue.append(symbol);

        val numberSystem = chooseNumberSystem(numberValue);
        return parseNumberSystem(enumerator, numberValue, numberSystem);
    }
}