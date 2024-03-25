package toolkit.results

class Warned<WarningType, ResultType>(
    val value: ResultType,
    val warning: WarningType
) : Result<ResultType>(){
    override fun unwrap(): ResultType {
        return value;
    }

    override fun toString(): String {
        return "Warned:\n\tWarning: $warning\n\tResult:$value"
    }
}