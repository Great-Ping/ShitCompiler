package lexicon.tokens

enum class TokenTypes (val flag: Int){
    COMMENT                 (0b00000001),
    IDENTIFIER              (0b00000010),
    KEYWORD                 (0b00000100),
    INTEGER_LITERAL         (0b00001000),
    REAL_LITERAL            (0b00010000),
    CHARACTER_LITERAL       (0b00100000),
    STRING_LITERAL          (0b01000000),
    OPERATOR_OR_PUNCTUATOR  (0b10000000)
}