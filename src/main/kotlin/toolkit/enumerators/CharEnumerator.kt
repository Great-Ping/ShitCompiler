package toolkit.enumerators

class CharEnumerator(
    private val _charArray: CharArray,
    private var _currentIndex: Int
) : CharIterator(){

    public constructor(string: String): this(
        string.toCharArray(),
        0
    ) { }

    val current
        get() = _charArray[_currentIndex]

    fun moveNext(): Boolean{
        val nextIndex = _currentIndex + 1
        if (nextIndex >= _charArray.size) {
            return false
        }

        _currentIndex = nextIndex
        return true;
    }

    override fun hasNext(): Boolean {
        return _currentIndex < _charArray.size
    }

    fun movePrevious(): Boolean{
        if (hasPrevious()) {
            _currentIndex--;
            return true;
        }

        return false;
    }

    fun hasPrevious():Boolean{
        return _currentIndex > 1
    }

    //Todo сохранение состоний мб быстрее постоянного выделения памяти
    public fun clone(): CharEnumerator {
        return CharEnumerator(_charArray, _currentIndex)
    }

    override fun nextChar(): Char {
        moveNext()
        return current
    }

    override fun toString(): String {
        return _charArray
            .drop(_currentIndex)
            .joinToString()
    }
}
