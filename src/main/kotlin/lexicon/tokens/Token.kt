package lexicon.tokens

abstract class Token (
    val type: TokenTypes,
){
    var lexemeTabelIndex: Int = 0;
}