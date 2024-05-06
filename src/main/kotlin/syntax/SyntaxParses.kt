package syntax

import syntax.nodes.SyntaxNode

//Программа = Функция
//Функция = type Name(**args){
//    [БлокКода]
//}
//БлокКода = [Строки | IF]
//Строка = Выражение EOL
//Строка = Объявление EOL
//
//IfStateMent = if {БлокКода} Option(else {БлокКода})
//
//Объявление = [let|var] Name:Type; //late init
//Объявление = [let|var] Name = Выражение;
//
//Выражение = ОПЕРАТОР Выражение
//Выражение = Выражение ОПЕРАЦИЯ Выражение
//Выражение = ВызовФункции
//
//Операция = [ * | / | + | - ]
//ВызовФункции = FunName()
//
//
//EOL = ;
//EOF = <EOF>

class SyntaxParses {
    fun parse(input: String) : SyntaxNode {
        return parse(TokensQueue(input))
    }

    fun parse(tokens: TokensQueue) : SyntaxNode {
        tokens.getNext()

    TODO()
    }
}