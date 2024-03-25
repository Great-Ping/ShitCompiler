package toolkit.results

class Failed<ExceptionType : Throwable, ResultType>(
    val exception: ExceptionType
): Result<ResultType> () {
    override fun unwrap(): ResultType {
        throw exception
    }

    override fun toString(): String {
        return "Failed: $exception"
    }

}