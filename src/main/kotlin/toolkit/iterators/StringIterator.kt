package toolkit.iterators

public final class StringIterator(
    private val _charArray: CharArray,
    private var _currentIndex: Int
): CharIterator() {

    public constructor(
        string: String
    ): this(
        string.toCharArray(),
        0
    ) { }


    public override fun hasNext(): Boolean {
        return _currentIndex < _charArray.size - 1
    }

    public override fun nextChar(): Char {
        _currentIndex++
        return  _charArray[_currentIndex]
    }

    public fun hasPrevious(): Boolean {
        return _currentIndex > 0
    }

    public fun previousChar(): Char {
        _currentIndex--
        return  _charArray[_currentIndex]
    }

    public fun clone(): StringIterator {
        return StringIterator(_charArray, _currentIndex)
    }
}
