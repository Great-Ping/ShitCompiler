package syntax

import lexicon.Lexer
import lexicon.SimpleLexer
import lexicon.tokens.Token
import java.util.*

class TokensQueue(
    private val lexer: Lexer
) {
    private var previousTokens = LinkedList<Token>()
    private var nextTokens = LinkedList<Token>()

    constructor(input: String):
        this(SimpleLexer(input))

    fun getNext(): Token {
        val token = if (nextTokens.isEmpty()){
            lexer.nextToken()
        } else {
            nextTokens.pop();
        }

        previousTokens.push(token)

        return token;
    }

    fun getPrevious(): Token{
        if (previousTokens.isEmpty())
            throw Exception("previous tokens not found");

        val token = previousTokens.pop();

        nextTokens.push(token)

        return token
    }


}