package toolkit.enumerators

public final class CharEnumerator(
    private val _charArray: CharArray,
    private var _currentIndex: Int
) : Iterable<Char>{

    public constructor(
        string: String
    ): this(
        string.toCharArray(),
        -1
    ) { }

    val current
        get() = _charArray[_currentIndex]

    fun moveNext(): Boolean{
        val nextIndex = _currentIndex + 1
        if (nextIndex >= _charArray.size)
            return false

        _currentIndex = nextIndex;
        return true;
    }

    fun movePrevious(): Boolean{
        val nextIndex = _currentIndex - 1
        if (nextIndex < 0)
            return false

        _currentIndex = nextIndex;
        return true;
    }

    public fun clone(): CharEnumerator {
        return CharEnumerator(_charArray, _currentIndex)
    }

    override fun iterator(): Iterator<Char> {
        return _charArray
            .drop(_currentIndex - 1)
            .iterator()
    }
}
