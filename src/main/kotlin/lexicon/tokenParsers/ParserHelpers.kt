package lexicon.tokenParsers

import toolkit.enumerators.CharEnumerator
import java.lang.Character.isWhitespace


fun sckipWhitespaces(enumerator: CharEnumerator) : CharEnumerator {
    while (
        enumerator.moveNext()
        &&
        isWhitespace(enumerator.current)
    ){}

    return enumerator;
}