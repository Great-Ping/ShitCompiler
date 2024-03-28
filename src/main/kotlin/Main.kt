
import lexicon.Lexer
import lexicon.SimpleLexer
import toolkit.results.Failed
import kotlin.time.measureTime

fun main(args: Array<String>) {
    val input = "float int notint bool new boat flot"
    val lexer: Lexer = SimpleLexer(input)

    val duration = measureTime{
        while(true) {
            val result= lexer.nextToken()

            if (result is Failed<*, *>)
                break;
        }
    }

    println(duration.inWholeNanoseconds)
}