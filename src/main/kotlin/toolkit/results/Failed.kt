package toolkit.results

class Failed<ExceptionType : Throwable, ValueType>(
    val exception: ExceptionType
): Result<ValueType> {

    override fun unwrap(): ValueType {
        throw exception
    }

}