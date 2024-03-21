package toolkit.extensions

import toolkit.iterators.StringIterator

fun String.toStringIterator(): StringIterator{
    return StringIterator(this)
}