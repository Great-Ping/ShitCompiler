
import lexicon.EndToken
import lexicon.Lexer
import lexicon.SimpleLexer
import lexicon.tokens.keywords.KeywordNames
import lexicon.tokens.keywords.KeywordToken
import kotlin.time.measureTime


fun main(
    args: Array<String>
) {
    val input = object {}.javaClass
        .getResourceAsStream(
            "TestInput.txt"
        )?.bufferedReader()
        ?.readText() ?: ""

    val lexer = SimpleLexer(input)

    val duration = measureTime {
        while (true) {
            val result = lexer.nextToken()

            println(result)

            if (result is EndToken)
                break
        }
    }

    println(
        duration.inWholeNanoseconds
    )
}