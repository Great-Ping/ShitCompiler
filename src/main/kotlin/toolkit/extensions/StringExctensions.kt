package toolkit.extensions

import toolkit.enumerators.CharEnumerator

fun String.toStringIterator(): CharEnumerator {
    return CharEnumerator(this)
}