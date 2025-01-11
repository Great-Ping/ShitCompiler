
import lexicon.EndToken
import lexicon.Lexer
import lexicon.SimpleLexer
import kotlin.time.measureTime


fun main(args: Array<String>) {
    val resource = object{}.javaClass
        .getResourceAsStream("TestInput.txt")
        ?.bufferedReader()
        ?.readText();

    val input = resource ?: ""

    val lexer: Lexer = SimpleLexer(input)

    val duration = measureTime{
        while(true) {
            val result= lexer.nextToken()
            println(result)

            if (result is EndToken)
                break;
        }
    }

    println(duration.inWholeNanoseconds)
}