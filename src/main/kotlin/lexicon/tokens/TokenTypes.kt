package lexicon.tokens

@JvmInline
value class TokenTypes (
    val flag: Int
) {
    companion object{
        val INVALID               = TokenTypes(0b1);
        val COMMENT               = TokenTypes(0b10);
        val IDENTIFIER            = TokenTypes(0b100);
        val KEYWORD               = TokenTypes(0b1000);
        val INTEGER_LITERAL       = TokenTypes(0b10000);
        val REAL_NUMBER_LITERAL   = TokenTypes(0b100000);
        val CHARACTER_LITERAL     = TokenTypes(0b1000000);
        val STRING_LITERAL        = TokenTypes(0b10000000);
        val OPERATOR_OR_PUNCTUATOR= TokenTypes(0b100000000);
        val END                   = TokenTypes(0b1000000000);
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
}