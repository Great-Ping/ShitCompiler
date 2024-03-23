package lexicon.tokenParsers

import toolkit.enumerators.CharEnumerator
import java.lang.Character.isWhitespace

//TODO В данной реализации необходимо возвращать итератор

fun sckipWhitespaces(
    enumerator: CharEnumerator
) : CharEnumerator {
    do {
        if (!isWhitespace(enumerator.current))
            return enumerator
    } while (enumerator.moveNext())

    return enumerator
}

fun continuesWith(
    enumerator: CharEnumerator,
    pattern:String
): Boolean {
    val iterator = pattern.iterator()
    do {
        if (enumerator.current != iterator.next())
            return false;
    } while (
        iterator.hasNext()
        && enumerator.moveNext())

    return true
}
