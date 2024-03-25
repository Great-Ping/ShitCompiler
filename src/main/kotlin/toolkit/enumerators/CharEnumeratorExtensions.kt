package toolkit.enumerators

fun CharEnumerator.movePrevious(): Boolean{
    return moveTo(currentIndex - 1)
}

fun CharEnumerator.moveNext(): Boolean{
    return moveTo(currentIndex + 1)
}
