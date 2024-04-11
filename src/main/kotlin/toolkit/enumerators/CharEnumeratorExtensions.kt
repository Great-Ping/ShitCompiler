package toolkit.enumerators

fun CharEnumerator.movePrevious(): Boolean{
    if (hasPrevious()){
        moveTo(currentIndex - 1)
        return true;
    }
    return false
}

fun CharEnumerator.moveNext(): Boolean{
    if (hasNext()){
        moveTo(currentIndex + 1)
        return true;
    }
    return false
}
