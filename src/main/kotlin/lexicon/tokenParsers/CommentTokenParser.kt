package lexicon.tokenParsers

import lexicon.ParsingInfo
import lexicon.tokens.CommonToken
import lexicon.tokens.TokenTypes
import toolkit.enumerators.CharEnumerator
import toolkit.results.Result
import toolkit.results.ResultState

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
    ):Result<ParsingInfo>{
        if (!continuesWith(enumerator, start))
            return Result.fail(Exception())

        do {
            if (continuesWith(enumerator, end)) {
                break
            }
        } while (enumerator.moveNext())

        return Result.ok(
            ParsingInfo(
                enumerator,
                CommonToken(TokenTypes.COMMENT)))
    }


    override fun parse(enumerator: CharEnumerator): Result<ParsingInfo> {
        val parseResult = parseComment(
            enumerator.clone(),
            ONE_LINE_COMMENT_START,
            ONE_LINE_COMMENT_END)

        if (parseResult.state != ResultState.FAILED)
            return parseResult

        return parseComment(
            enumerator,
            ONE_LINE_COMMENT_START,
            ONE_LINE_COMMENT_END)
    }
}