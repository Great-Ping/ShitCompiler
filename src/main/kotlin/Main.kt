
import lexicon.Lexer
import lexicon.SimpleLexer
import kotlin.time.measureTime
import lexicon.tokens.TokenTypes
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

fun main(args: Array<String>) {
    var input = "void Main () {" +
        "   val idName: String = \"SСстринга\\\"hjghj\";chuyu_bag\n" +
        "   val ind: Int32 = 101012\n" +
        "   val idHex: Int32 = 0x10101\n" +
        "   val idByte: Int32 = 0b12213\n" +
        "   val invalid: Int32 = 0b11.1231\n" +
        "   val invalidRealNumber = 0.000.000\n" +
        "   val validRealNumber = 0.00000" +
        "   val " +
        "}"

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