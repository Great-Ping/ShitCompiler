import lexicon.Lexer
import lexicon.SimpleLexer

fun main(args: Array<String>) {
    val input = "//comment"
    val lexer: Lexer = SimpleLexer(input)
    val result = lexer.nextToken()
    println(result)
}