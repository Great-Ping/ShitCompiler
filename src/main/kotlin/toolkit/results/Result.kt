package toolkit.results

abstract class Result<ResultType> (
    val state: ResultState
) {
    abstract fun unwrap(): ResultType

    companion object {
        fun <ResultType> ok(
            result: ResultType
        ): Succeed<ResultType>{
            return Succeed(result)
        }

        fun <ExceptionType: Throwable, ResultType> fail(
            exception: ExceptionType
        ): Failed<ExceptionType, ResultType>{
            return Failed(exception)
        }
    }
}