package toolkit.results

class Succeed<ResultType> (
    val value: ResultType
): Result<ResultType>(ResultState.SUCCEED){
    override fun unwrap(): ResultType {
        return value
    }

    override fun toString(): String {
        return "Succeed: $value"
    }
}