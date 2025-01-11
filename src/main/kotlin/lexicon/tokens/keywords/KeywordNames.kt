package lexicon.tokens.keywords

import lexicon.tokenParsers.IdentifierOrKeywordTokenParser

@JvmInline
value class KeywordNames (
    val flag: Int
) {
    companion object{
        private const val VALUE = 0b1
        val VAR = KeywordNames(
            VALUE shl 1
        )

        val VAL = KeywordNames(
            VALUE shl 2
        )

        val IF = KeywordNames(
            VALUE shl 3
        )

        val FUNC = KeywordNames(
            VALUE shl 4
        )

        val RETURN = KeywordNames(
            VALUE shl 5
        )
    }

    operator fun contains(
        names: KeywordNames
    ) = hasFlag(
        names
    )

    infix fun and(
        names: KeywordNames
    ) = KeywordNames(
        this.flag and names.flag
    )

    infix fun or(
        names: KeywordNames
    ) = KeywordNames(
        this.flag or names.flag
    )

    fun hasFlag(
        names: KeywordNames
    ) = (this and names).flag != 0

    override fun toString(): String {
        val keywords = IdentifierOrKeywordTokenParser.keywords;
        val selectedKeywords = keywords.filterValues {
                value -> value.hasFlag(this)
        }

        return selectedKeywords.keys.joinToString(" | ")
    }
}