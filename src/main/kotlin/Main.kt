
import lexicon.Lexer
import lexicon.SimpleLexer
import lexicon.tokens.TokenTypes
import kotlin.time.measureTime

//<InitialState> ->
//    [<CodeBlock>]
//
//<CodeBlock> ->
//    [
//      IFStatement {<CodeBlock>}
//      <CodeLine>
//    ]
//<CodeLine> ->
//    <VariableDeclaring>
//    | <VariableAssigment>
//    | <FunctionCalling>
//
//<VariableDeclaring> ->
//    (Keyword(var) | Keyword(val)) <VariableAssigment>
//<VariableAssigment> ->
//    Identefier() Operator(=) <FunctionCalling>


fun main(args: Array<String>) {
    var input = "val idName: String = \"SСстринга\\\"hjghj\";chuyu_bag"
    val lexer: Lexer = SimpleLexer(input)

    val duration = measureTime{
        while(true) {
            val result= lexer.nextToken()
            println(result)

            if (result.isFailure)
                break;

            val token = result.getOrThrow()
            if (token.type == TokenTypes.END)
                break;
        }
    }

    println(duration.inWholeNanoseconds)
}