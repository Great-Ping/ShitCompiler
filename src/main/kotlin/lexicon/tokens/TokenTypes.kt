package lexicon.tokens

enum class TokenTypes (val flag: Int){
    INVALID                 (0b0),
    COMMENT                 (0b1),
    IDENTIFIER              (0b10),
    KEYWORD                 (0b100),
    INTEGER_LITERAL         (0b1000),
    REAL_LITERAL            (0b10000),
    CHARACTER_LITERAL       (0b100000),
    STRING_LITERAL          (0b1000000),
    OPERATOR_OR_PUNCTUATOR  (0b10000000),
    END                     (0b100000000)
}