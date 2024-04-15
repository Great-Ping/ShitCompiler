package lexicon.tokens

enum class TokenTypes (val flag: Int){
    INVALID                 (0b1),
    COMMENT                 (0b10),
    IDENTIFIER              (0b100),
    KEYWORD                 (0b1000),
    INTEGER_LITERAL         (0b10000),
    REAL_LITERAL            (0b100000),
    CHARACTER_LITERAL       (0b1000000),
    STRING_LITERAL          (0b10000000),
    OPERATOR_OR_PUNCTUATOR  (0b100000000),
    END                     (0b1000000000)
}