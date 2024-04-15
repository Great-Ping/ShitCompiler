package toolkit.extensions

import lexicon.enumerators.CharEnumerator

fun String.toStringIterator(): CharEnumerator {
    return CharEnumerator(this)
}