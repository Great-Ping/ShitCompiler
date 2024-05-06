package lexicon

import lexicon.tokens.Token
import lexicon.tokens.TokenTypes

class EndToken(absolutePosition: Int) : Token(TokenTypes.END)