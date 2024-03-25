import lexicon.Lexer
import lexicon.SimpleLexer
import toolkit.results.Failed

fun main(args: Array<String>) {
    val input = "\n" +
            "                \n" +
            "\n          " +
            "\n " +
            "\n " +
            "//comment                               \n()"
    val lexer: Lexer = SimpleLexer(input)
    while(true) {
        val result= lexer.nextToken()

        if(result is Failed<*,*>)
            break;

        println(result)
    }
}