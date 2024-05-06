package lexicon.tokens.operatorOrPunctuatorTokens

import lexicon.tokenParsers.OperatorOrPunctuatorTokenParser

class Operators(
    val flag:Int
) {
    companion object {
        val EQUALLY =               Operators(0b1)
        val OPEN_BRACE =            Operators(0b10)
        val CLOSE_BRACE =           Operators(0b100)
        val SEMICOLON =             Operators(0b1000)
        val COLON =                 Operators(0b10000)
        val OPEN_CURLY_BRACE =      Operators(0b100000)
        val CLOSE_CURLY_BRACE =     Operators(0b1000000)
    }

    operator fun contains(operators: Operators): Boolean {
        return hasFlag(operators);
    }

    infix fun and(names: Operators) : Operators {
        return Operators(this.flag and names.flag)
    }

    infix fun or(operators: Operators) : Operators {
        return Operators(this.flag or operators.flag)
    }

    fun hasFlag(operators: Operators): Boolean {
        return (this and operators).flag != 0;
    }

    override fun toString(): String {
        val operators = OperatorOrPunctuatorTokenParser.operators;
        val usedOperatros = operators.filterValues {
            value -> value.hasFlag(this)
        }

        return usedOperatros.keys.joinToString(" | ")
    }
}
