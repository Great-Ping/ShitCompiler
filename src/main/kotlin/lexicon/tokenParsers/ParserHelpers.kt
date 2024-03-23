package lexicon.tokenParsers

import toolkit.enumerators.CharEnumerator
import java.lang.Character.isWhitespace


fun sckipWhitespaces(enumerator: CharEnumerator) : CharEnumerator {
    while (enumerator.moveNext()){
        if (!isWhitespace(enumerator.current))
            return enumerator
    }

    return enumerator
}