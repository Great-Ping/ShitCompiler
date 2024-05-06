package lexicon.enumerators

class CharEnumerator(
    private val _charArray: CharArray,
    private var _currentIndex: Int
) : CharIterator(){

    constructor(string: String): this(
        string.toCharArray(),
        -1
    ) { }

    val currentIndex
        get() = _currentIndex

    val current
        get() = _charArray[_currentIndex]


    fun moveTo(index: Int){
//        if (index >= _charArray.size || index < -1)
//            return false
        _currentIndex = index;
//        return true
    }

    override fun hasNext(): Boolean {
        return _currentIndex + 1 < _charArray.size
    }

    fun hasPrevious():Boolean{
        return _currentIndex > 0
    }

    //По end включительно
    fun getSubstring(start: Int, end: Int) : String {
        val destArray = CharArray(end - start + 1);
        _charArray.copyInto(
            destArray,
            0,
            start,
            end + 1
        );

        return String(destArray);
    }

    override fun nextChar(): Char {
        moveNext()
        return current
    }

    override fun toString(): String {
        return _charArray
            .drop(
                if (currentIndex < 0)
                    0
                else currentIndex
            )
            .joinToString("")
    }
}
