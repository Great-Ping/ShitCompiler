package toolkit.results

class Succeed<ValueType> (
    val value: ValueType
): Result<ValueType> {
    override fun unwrap(): ValueType {
        return value
    }
}