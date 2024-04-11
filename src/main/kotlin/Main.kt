
import lexicon.Lexer
import lexicon.SimpleLexer
import kotlin.time.measureTime

fun main(args: Array<String>) {
    val input = "val name: String = \"SСстринга\""
    val lexer: Lexer = SimpleLexer(input)

    val duration = measureTime{
        while(true) {
            val result= lexer.nextToken()
            println(result)
            if (result.isFailure)
                break;
        }
    }

    println(duration.inWholeNanoseconds)
}