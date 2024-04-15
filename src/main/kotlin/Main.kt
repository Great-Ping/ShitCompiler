
import lexicon.Lexer
import lexicon.SimpleLexer
import lexicon.tokens.TokenTypes
import kotlin.time.measureTime

fun main(args: Array<String>) {
    val input = "val idName: String = \"SСстринга\";chuyu_bag"
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