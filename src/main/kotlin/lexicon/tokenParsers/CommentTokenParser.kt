package lexicon.tokenParsers

import lexicon.tokens.CommonToken
import lexicon.tokens.Token
import lexicon.tokens.TokenTypes
import toolkit.enumerators.CharEnumerator
import toolkit.enumerators.moveNext

class CommentTokenParser : TokenParser{

    companion object {
        const val ONE_LINE_COMMENT_START: String = "//"
        const val ONE_LINE_COMMENT_END: String = "\n"
        const val MANY_LINE_COMMENT_START: String = "/*"
        const val MANY_LINE_COMMENT_END: String = "*/"
    }

    private fun parseComment(
        enumerator: CharEnumerator,
        start: String,
        end: String
    ): Token? {
        if (!continuesWith(enumerator, start))
            return null

        do {
            val enumeratorState = enumerator.currentIndex
            if (continuesWith(enumerator, end)) {
                break
            }
            enumerator.moveTo(enumeratorState)
        } while(enumerator.moveNext())

        return CommonToken(TokenTypes.COMMENT)
    }


    override fun parse(enumerator: CharEnumerator): Token? {
        val enumeratorState: Int = enumerator.currentIndex
        
        val parseResult = parseComment(
            enumerator,
            ONE_LINE_COMMENT_START,
            ONE_LINE_COMMENT_END)
        
        if (parseResult != null)
            return parseResult
        
        enumerator.moveTo(enumeratorState)
        return parseComment(
            enumerator,
            MANY_LINE_COMMENT_START,
            MANY_LINE_COMMENT_END)
    }
}