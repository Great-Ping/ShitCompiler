package lexicon.tokens

import java.util.*

@JvmInline
value class TokenTypes (
    val flag: Int
) {
    companion object {
        val UNDEFINED                   = TokenTypes(0b1)
        val INVALID                     = TokenTypes(0b10);
        val COMMENT                     = TokenTypes(0b100);
        val IDENTIFIER                  = TokenTypes(0b1000);
        val KEYWORD                     = TokenTypes(0b10000);
        val INTEGER_LITERAL             = TokenTypes(0b100000);
        val REAL_NUMBER_LITERAL         = TokenTypes(0b1000000);
        val CHARACTER_LITERAL           = TokenTypes(0b10000000);
        val STRING_LITERAL              = TokenTypes(0b100000000);
        val OPERATOR_OR_PUNCTUATOR      = TokenTypes(0b1000000000);
        val END                         = TokenTypes(0b10000000000);
    }

    operator fun contains(names: TokenTypes): Boolean {
        return hasFlag(names);
    }

    infix fun and(names: TokenTypes) : TokenTypes {
        return TokenTypes(this.flag and names.flag)
    }

    infix fun or(names: TokenTypes) : TokenTypes{
        return TokenTypes(this.flag or names.flag)
    }

    fun hasFlag(names: TokenTypes): Boolean {
        return (this and names).flag != 0;
    }

    private fun flagToString(flag: Int): String
    {
        return when(flag){
            UNDEFINED.flag -> "UNDEFINED"
            INVALID.flag -> "INVALID"
            COMMENT.flag -> "COMMENT"
            IDENTIFIER.flag->"IDENTIFIER"
            KEYWORD.flag->"KEYWORD"
            INTEGER_LITERAL.flag->"INTEGER_LITERAL"
            REAL_NUMBER_LITERAL.flag->"REAL_NUMBER_LITERAL"
            CHARACTER_LITERAL.flag->"CHARACTER_LITERAL"
            STRING_LITERAL.flag->"STRING_LITERAL"
            OPERATOR_OR_PUNCTUATOR.flag->"OPERATOR_OR_PUNCTUATOR"
            END.flag->"END"
            else -> "UNKWONW"
        }
    }

    override fun toString(): String {
        val flags = LinkedList<String>()
        var i = 1;
        while( i < END.flag) {
            if (flag and i > 0)
                flags.add(flagToString(i))
            i = i shl 2;
        }

        return  flags.joinToString(" | ")
    }
}