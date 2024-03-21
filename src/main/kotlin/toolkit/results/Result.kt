package toolkit.results

public interface Result<ResultType> {
    fun unwrap(): ResultType
}