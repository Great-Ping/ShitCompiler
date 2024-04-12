package lexicon.tokens.operatorOrPunctuatorTokens

import lexicon.tokens.keywords.KeywordNames

class Operators(
    val flag:Int
) {
    companion object {
        val EQUALLY = Operators(0b1)
        val OPEN_BRACKET = Operators(0b10)
        val CLOSE_BRACKET = Operators(0b100)
        val SEMICOLON = Operators(0b1000)
        val COLON = Operators(0b10000)
    }

    operator fun contains(names: KeywordNames): Boolean {
        return hasFlag(names);
    }

    infix fun and(names: KeywordNames) : KeywordNames {
        return KeywordNames(this.flag and names.flag)
    }

    infix fun or(names: KeywordNames) : KeywordNames {
        return KeywordNames(this.flag or names.flag)
    }

    fun hasFlag(names: KeywordNames): Boolean {
        return (this and names).flag != 0;
    }
}
