package lexicon.tokenParsers

import lexicon.ParsingInfo
import toolkit.enumerators.CharEnumerator
import toolkit.results.Result

interface TokenParser {
    fun parse(enumerator: CharEnumerator): Result<ParsingInfo>
}