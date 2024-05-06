package lexicon.tokenParsers

import lexicon.enumerators.CharEnumerator
import lexicon.enumerators.moveNext
import lexicon.tokens.CommentToken
import lexicon.tokens.Token

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

        val startIndex = enumerator.currentIndex + 1;
        var endIndex:Int
        do {
            val enumeratorState = enumerator.currentIndex
            endIndex = enumeratorState;
            if (continuesWith(enumerator, end)) {
                break
            }
            enumerator.moveTo(enumeratorState)
        } while(enumerator.moveNext())

        val value = enumerator.getSubstring(startIndex, endIndex);
        return CommentToken(value)
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