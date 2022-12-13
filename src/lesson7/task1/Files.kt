@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson7.task1


import ru.spbstu.wheels.out
import java.io.*
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.util.regex.Pattern
import kotlin.math.max

// Урок 7: работа с файлами
// Урок интегральный, поэтому его задачи имеют сильно увеличенную стоимость
// Максимальное количество баллов = 55
// Рекомендуемое количество баллов = 20
// Вместе с предыдущими уроками (пять лучших, 3-7) = 55/103

/**
 * Пример
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Вывести его в выходной файл с именем outputName, выровняв по левому краю,
 * чтобы длина каждой строки не превосходила lineLength.
 * Слова в слишком длинных строках следует переносить на следующую строку.
 * Слишком короткие строки следует дополнять словами из следующей строки.
 * Пустые строки во входном файле обозначают конец абзаца,
 * их следует сохранить и в выходном файле
 */
fun alignFile(inputName: String, lineLength: Int, outputName: String) {
    val writer = File(outputName).bufferedWriter()
    var currentLineLength = 0
    fun append(word: String) {
        if (currentLineLength > 0) {
            if (word.length + currentLineLength >= lineLength) {
                writer.newLine()
                currentLineLength = 0
            } else {
                writer.write(" ")
                currentLineLength++
            }
        }
        writer.write(word)
        currentLineLength += word.length
    }
    for (line in File(inputName).readLines()) {
        if (line.isEmpty()) {
            writer.newLine()
            if (currentLineLength > 0) {
                writer.newLine()
                currentLineLength = 0
            }
            continue
        }
        for (word in line.split(Regex("\\s+"))) {
            append(word)
        }
    }
    writer.close()
}

/**
 * Простая (8 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Некоторые его строки помечены на удаление первым символом _ (подчёркивание).
 * Перенести в выходной файл с именем outputName все строки входного файла, убрав при этом помеченные на удаление.
 * Все остальные строки должны быть перенесены без изменений, включая пустые строки.
 * Подчёркивание в середине и/или в конце строк значения не имеет.
 */
fun deleteMarked(inputName: String, outputName: String) {
    File(outputName).bufferedWriter().use { writer ->
        File(inputName).readLines().asSequence()
            .filter { line -> line.firstOrNull() != '_' }
            .forEach { line ->
                writer.write(line)
                writer.newLine()
            }
    }
}

/**
 * Средняя (14 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * На вход подаётся список строк substrings.
 * Вернуть ассоциативный массив с числом вхождений каждой из строк в текст.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 */
fun countSubstrings(inputName: String, substrings: List<String>): Map<String, Int> {
//    val wordsFromFile = File(inputName).readText().lowercase().split(" ")
//    val countOfEls = mutableMapOf<String, Int>()
//    for (word in wordsFromFile) {
//        for (elem in substrings) {
//            val elemLow = elem.lowercase()
//            if (!countOfEls.containsKey(elem)) countOfEls[elem] = 0
//            if (elemLow in word) {
//                var count = 0
//                var wordBack = word
//                while (wordBack.contains(elemLow)) {
//
//                    count++
//                    wordBack = word.replaceFirst(elemLow[0].toString(),"")
//                }
//                countOfEls[elem] = countOfEls[elem]!! + count
//            }
//        }
//    }
//    return countOfEls
    TODO()
}


/**
 * Средняя (12 баллов)
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст на русском языке.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жюри, брошюра, парашют) в рамках данного задания обрабатывать не нужно
 *
 */
fun sibilants(inputName: String, outputName: String) {
    TODO()
}



/**
 * Средняя (15 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по центру
 * относительно самой длинной строки.
 *
 * Выравнивание следует производить путём добавления пробелов в начало строки.
 *
 *
 * Следующие правила должны быть выполнены:
 * 1) Пробелы в начале и в конце всех строк не следует сохранять.
 * 2) В случае невозможности выравнивания строго по центру, строка должна быть сдвинута в ЛЕВУЮ сторону
 * 3) Пустые строки не являются особым случаем, их тоже следует выравнивать
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых)
 *
 */
fun centerFile(inputName: String, outputName: String) {
//    var linesFromFile = File(inputName).readLines().toString().split(" ").toMutableList()
//    val maxLen = linesFromFile.maxOrNull() ?: 0
//    print(maxLen)
//    var i = 0
//    while (linesFromFile[i].length != maxLen) {
//        linesFromFile[i] = " " + linesFromFile[i]
//        if (linesFromFile[i].length != maxLen) linesFromFile[i] = linesFromFile[i] + " "
//    }
//    FileWriter(outputName)

//    // val maxLen = linesFromFile.maxOrNull() ?: 0
//    var mx = 0
//    var ll = 0
//    for (line in linesFromFile) {
//        ll = line.length
//        if (mx < ll) {
//            mx = ll
//        }
//    }
//    for (i in 0..linesFromFile.size-1) {
//        linesFromFile[i] = linesFromFile[i].trim { it <= ' ' }
//        if (linesFromFile[i].length != mx) linesFromFile[i] = " " + linesFromFile[i]
//        if (linesFromFile[i].length != mx) linesFromFile[i] = linesFromFile[i] + " "
//    }
//    //FileWriter(outputName).write()
//     val te = linesFromFile.joinToString(prefix = "",
//         separator ="\r\n",
//         postfix = "")
//     File(outputName).writeText(te)
////    File(outputName).bufferedWriter().use { out ->
////        linesFromFile.forEach {
////            out.write("${it}\r\n")
////        }
////    }
    val linesFromFile = File(inputName).readLines()
    val trimLines = mutableListOf<String>()
    var maxLineLength = 0
    linesFromFile.forEach { line ->
        val trimLine = line.trim()
        maxLineLength = kotlin.math.max(maxLineLength, trimLine.length)
        trimLines.add(trimLine)
    }
    File(outputName).bufferedWriter().use { text ->
        trimLines.forEach { trimLine ->
            val requireSpaceLength = (maxLineLength - trimLine.length) / 2
            text.write(" ".repeat(requireSpaceLength) + trimLine)
            text.newLine()
        }
    }
}

/**
 * Сложная (20 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по левому и правому краю относительно
 * самой длинной строки.
 * Выравнивание производить, вставляя дополнительные пробелы между словами: равномерно по всей строке
 *
 * Слова внутри строки отделяются друг от друга одним или более пробелом.
 *
 * Следующие правила должны быть выполнены:
 * 1) Каждая строка входного и выходного файла не должна начинаться или заканчиваться пробелом.
 * 2) Пустые строки или строки из пробелов трансформируются в пустые строки без пробелов.
 * 3) Строки из одного слова выводятся без пробелов.
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых).
 *
 * Равномерность определяется следующими формальными правилами:
 * 5) Число пробелов между каждыми двумя парами соседних слов не должно отличаться более, чем на 1.
 * 6) Число пробелов между более левой парой соседних слов должно быть больше или равно числу пробелов
 *    между более правой парой соседних слов.
 *
 * Следует учесть, что входной файл может содержать последовательности из нескольких пробелов  между слвоами. Такие
 * последовательности следует учитывать при выравнивании и при необходимости избавляться от лишних пробелов.
 * Из этого следуют следующие правила:
 * 7) В самой длинной строке каждая пара соседних слов должна быть отделена В ТОЧНОСТИ одним пробелом
 * 8) Если входной файл удовлетворяет требованиям 1-7, то он должен быть в точности идентичен выходному файлу
 */
fun alignFileByWidth(inputName: String, outputName: String) {
    val alignLineFromFile = File(inputName).readLines()
    val outLineFromFile = File(outputName).bufferedWriter()
    val text = mutableListOf<Pair<List<String>, Int>>()
    val emptyLine = listOf("")
    var maxLength = 0
    alignLineFromFile.forEach { line ->
        val words = line.trim().split(" ").filter { it != "" }
        var lineLen = 0
        for (word in words) {
            lineLen += word.length
        }
        if (lineLen != 0) {
            lineLen += words.size - 1
        }
        maxLength = max(maxLength, lineLen)
        if (words.isEmpty()) {
            text.add(emptyLine to lineLen)
        } else {
            text.add(words to lineLen)
        }
    }
    outLineFromFile.use { writer ->
        text.forEach { (words, lineLength) ->
            if (words.size == 1) {
                writer.write(words.first())
                writer.newLine()
                return@forEach
            }
            val requireNumSpaces = maxLength - lineLength
            val numSegments = words.size - 1
            val minSpacesLength = requireNumSpaces / numSegments + 1
            var remainingSpaces = requireNumSpaces % numSegments
            for (i in 0..words.size - 2) {
                var spacesNum = minSpacesLength
                if (remainingSpaces > 0) {
                    spacesNum += 1
                    remainingSpaces -= 1
                }
                writer.write(words[i] + " ".repeat(spacesNum))
            }
            writer.write(words.last())
            writer.newLine()
        }
    }
}



/**
 * Средняя (14 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * Вернуть ассоциативный массив, содержащий 20 наиболее часто встречающихся слов с их количеством.
 * Если в тексте менее 20 различных слов, вернуть все слова.
 * Вернуть ассоциативный массив с числом слов больше 20, если 20-е, 21-е, ..., последнее слова
 * имеют одинаковое количество вхождений (см. также тест файла input/onegin.txt).
 *
 * Словом считается непрерывная последовательность из букв (кириллических,
 * либо латинских, без знаков препинания и цифр).
 * Цифры, пробелы, знаки препинания считаются разделителями слов:
 * Привет, привет42, привет!!! -привет?!
 * ^ В этой строчке слово привет встречается 4 раза.
 *
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 * Ключи в ассоциативном массиве должны быть в нижнем регистре.
 *
 */
fun top20Words(inputName: String): Map<String, Int> = TODO()

/**
 * Средняя (14 баллов)
 *
 * Реализовать транслитерацию текста из входного файла в выходной файл посредством динамически задаваемых правил.

 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * В ассоциативном массиве dictionary содержится словарь, в котором некоторым символам
 * ставится в соответствие строчка из символов, например
 * mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!")
 *
 * Необходимо вывести в итоговый файл с именем outputName
 * содержимое текста с заменой всех символов из словаря на соответствующие им строки.
 *
 * При этом регистр символов в словаре должен игнорироваться,
 * но при выводе символ в верхнем регистре отображается в строку, начинающуюся с символа в верхнем регистре.
 *
 * Пример.
 * Входной текст: Здравствуй, мир!
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Пример 2.
 *
 * Входной текст: Здравствуй, мир!
 * Словарь: mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!")
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun transliterate(inputName: String, dictionary: Map<Char, String>, outputName: String) {
    TODO()
}

/**
 * Средняя (12 баллов)
 *
 * Во входном файле с именем inputName имеется словарь с одним словом в каждой строчке.
 * Выбрать из данного словаря наиболее длинное слово,
 * в котором все буквы разные, например: Неряшливость, Четырёхдюймовка.
 * Вывести его в выходной файл с именем outputName.
 * Если во входном файле имеется несколько слов с одинаковой длиной, в которых все буквы разные,
 * в выходной файл следует вывести их все через запятую.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 * Пример входного файла:
 * Карминовый
 * Боязливый
 * Некрасивый
 * Остроумный
 * БелогЛазый
 * ФиолетОвый

 * Соответствующий выходной файл:
 * Карминовый, Некрасивый
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun chooseLongestChaoticWord(inputName: String, outputName: String) {
    val wordsFromFile = File(inputName).readText().trim(' ').split("\n")
    var out = ""
    for (w in wordsFromFile) {
        val nw = w.lowercase()
        val we = mutableSetOf<String>()
        we.addAll(nw.split(""))
        val lenW = w.length
        val lenOut = out.split(", ")[0].length
        if (we.size != lenW + 1) {
            continue
        }
        if (lenOut == lenW) {
            out += ", " + w
        } else if (lenOut < lenW) {
            out = w
        }
    }
    println(out)
    File(outputName).bufferedWriter().use { text ->
        text.write(out.trim(','))
    }
}





/**
 * Сложная (22 балла)
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе элементы текстовой разметки следующих типов:
 * - *текст в курсивном начертании* -- курсив
 * - **текст в полужирном начертании** -- полужирный
 * - ~~зачёркнутый текст~~ -- зачёркивание
 *
 * Следует вывести в выходной файл этот же текст в формате HTML:
 * - <i>текст в курсивном начертании</i>
 * - <b>текст в полужирном начертании</b>
 * - <s>зачёркнутый текст</s>
 *
 * Кроме того, все абзацы исходного текста, отделённые друг от друга пустыми строками, следует обернуть в теги <p>...</p>,
 * а весь текст целиком в теги <html><body>...</body></html>.
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 * Отдельно следует заметить, что открывающая последовательность из трёх звёздочек (***) должна трактоваться как "<b><i>"
 * и никак иначе.
 *
 * При решении этой и двух следующих задач полезно прочитать статью Википедии "Стек".
 *
 * Пример входного файла:
Lorem ipsum *dolor sit amet*, consectetur **adipiscing** elit.
Vestibulum lobortis, ~~Est vehicula rutrum *suscipit*~~, ipsum ~~lib~~ero *placerat **tortor***,

Suspendisse ~~et elit in enim tempus iaculis~~.
 *
 * Соответствующий выходной файл:
<html>
    <body>
        <p>
            Lorem ipsum <i>dolor sit amet</i>, consectetur <b>adipiscing</b> elit.
            Vestibulum lobortis. <s>Est vehicula rutrum <i>suscipit</i></s>, ipsum <s>lib</s>ero <i>placerat <b>tortor</b></i>.
        </p>
        <p>
            Suspendisse <s>et elit in enim tempus iaculis</s>.
        </p>
    </body>
</html>
 *
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlSimple(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная (23 балла)
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе набор вложенных друг в друга списков.
 * Списки бывают двух типов: нумерованные и ненумерованные.
 *
 * Каждый элемент ненумерованного списка начинается с новой строки и символа '*', каждый элемент нумерованного списка --
 * с новой строки, числа и точки. Каждый элемент вложенного списка начинается с отступа из пробелов, на 4 пробела большего,
 * чем список-родитель. Максимально глубина вложенности списков может достигать 6. "Верхние" списки файла начинются
 * прямо с начала строки.
 *
 * Следует вывести этот же текст в выходной файл в формате HTML:
 * Нумерованный список:
 * <ol>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ol>
 *
 * Ненумерованный список:
 * <ul>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ul>
 *
 * Кроме того, весь текст целиком следует обернуть в теги <html><body><p>...</p></body></html>
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 *
 * Пример входного файла:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
* Утка по-пекински
    * Утка
    * Соус
* Салат Оливье
    1. Мясо
        * Или колбаса
    2. Майонез
    3. Картофель
    4. Что-то там ещё
* Помидоры
* Фрукты
    1. Бананы
    23. Яблоки
        1. Красные
        2. Зелёные
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 *
 *
 * Соответствующий выходной файл:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
<html>
  <body>
    <p>
      <ul>
        <li>
          Утка по-пекински
          <ul>
            <li>Утка</li>
            <li>Соус</li>
          </ul>
        </li>
        <li>
          Салат Оливье
          <ol>
            <li>Мясо
              <ul>
                <li>Или колбаса</li>
              </ul>
            </li>
            <li>Майонез</li>
            <li>Картофель</li>
            <li>Что-то там ещё</li>
          </ol>
        </li>
        <li>Помидоры</li>
        <li>Фрукты
          <ol>
            <li>Бананы</li>
            <li>Яблоки
              <ol>
                <li>Красные</li>
                <li>Зелёные</li>
              </ol>
            </li>
          </ol>
        </li>
      </ul>
    </p>
  </body>
</html>
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlLists(inputName: String, outputName: String) {
    TODO()
}

/**
 * Очень сложная (30 баллов)
 *
 * Реализовать преобразования из двух предыдущих задач одновременно над одним и тем же файлом.
 * Следует помнить, что:
 * - Списки, отделённые друг от друга пустой строкой, являются разными и должны оказаться в разных параграфах выходного файла.
 *
 */
fun markdownToHtml(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (12 баллов)
 *
 * Вывести в выходной файл процесс умножения столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 111):
   19935
*    111
--------
   19935
+ 19935
+19935
--------
 2212785
 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 * Нули в множителе обрабатывать так же, как и остальные цифры:
  235
*  10
-----
    0
+235
-----
 2350
 *
 */
fun printMultiplicationProcess(lhv: Int, rhv: Int, outputName: String) {
    TODO()
}


/**
 * Сложная (25 баллов)
 *
 * Вывести в выходной файл процесс деления столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 22):
  19935 | 22
 -198     906
 ----
    13
    -0
    --
    135
   -132
   ----
      3

 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 *
 */
fun printDivisionProcess(lhv: Int, rhv: Int, outputName: String) {
    TODO()
}


//val linesFromFile = File(inputName).readText().lowercase()
//val a1 = mutableMapOf<String, Int>()
//for (str in substrings) {
//    a1[str.lowercase()] = linesFromFile.count { it.toString() == str.lowercase() }
//}
////return a1


//Во входной строке содержится информация  о прогрессивном  налогообложении для физических лиц в зависимости от их годового доходов в следующем формате 30000
// //  20000 у.е. - 0%; 40000 у.е. - 5%; 60000 y.e. - 10%; else - 25%
// fun main(a: String, b: Int): List<String> {
//     return nalog("20000 у.е. - 0%; 40000 у.е. - 5%; 60000 y.e. - 10%; else - 25%", 50000)
// }



// fun nalog(taxes: String, money: Int): List<String> {
//     if (!taxes.matches(Regex("""(\d+ у.е. - \d+%; )+else - 25%"""))) throw IllegalArgumentException()
//     val mapSale = mutableMapOf<String, Int>()
//     val taxes1 = "20000 у.е. - 0%; 40000 у.е. - 5%; 60000 y.e. - 10%; else - 25%"
//     val taxesSplit = taxes1.replace("else - 25%", "").split(Regex(""" у.е. - \d+%; """))
//     val frick = listOf<String>()
//     return frick

// }



fun myFun(carPetrols: Map<String, String>, gasStations: String) : Map<String, String> {
    //if (!gasStations.matches("""([А-яA-z]+:( [А-я]+ (\d+ )?- \d+(.\d+)?;)+\s?)+""".toRegex())) throw IllegalArgumentException()
    //val gasSpl = gasStations.replace(":", "").replace("-","").replace("\\s+".toRegex(), " ").replace(";", "").split(" ").toMutableList()
    //получаем имя заправки сплитя по :
    //получаем все виды бензина с ценой сплитя по

    val linesfromgas = gasStations.split("\n")
    val gasMap = mutableMapOf<String, String>()
    linesfromgas.forEach {
        val tmp = it.split(":")
        //val arrayBenz = tmp[1].trim(';').split(";")
        gasMap.put(tmp[0], tmp[1].trim(';')) }
    val mapRes = mutableMapOf<String, Pair<String, Double>>()
    for ((key, value) in carPetrols) {
        mapRes[key] = Pair("", -1.0)
        for ((keyGas,valueGas) in gasMap) {
//            val a1 = gasSpl[str + 1].toString()
            val xz = valueGas.trim(' ').replace(" - ", "_").replace("; ", "_").split("_")
            if (xz.contains(value)) {
                val zxc = xz[xz.indexOf(value) + 1].toDouble()
//                if (mapRes.containsKey(key)) {
                if (mapRes[key]!!.second > zxc || mapRes[key]!!.second == -1.0) {
                    mapRes[key] = Pair(keyGas, zxc)//xz[xz.indexOf(value)]
                }
//                } else {
//                    mapRes[key] = Pair(keyGas, zxc)
//                }
            }

        }
        if (mapRes[key]!!.second == -1.0 ) throw IllegalStateException()
    }
    val superRes = mutableMapOf<String, String>()
    mapRes.forEach { superRes.put(it.key, it.value.first) }
    return superRes

}





//var linesFromFile = File(inputName).readLines().toString().split("\n").toMutableList()
//// val maxLen = linesFromFile.maxOrNull() ?: 0
//var mx = 0
//var ll = 0
//for (line in File(inputName).readLines())  {
//    ll = line.length
//    if (mx < ll) {
//        mx = ll
//    }
//}
//for (i in 0..linesFromFile.size-1) {
//    linesFromFile[i] = linesFromFile[i].trim { it <= ' ' }
//    if (linesFromFile[i].length != mx) linesFromFile[i] = " " + linesFromFile[i]
//    if (linesFromFile[i].length != mx) linesFromFile[i] = linesFromFile[i] + " "
//}
////FileWriter(outputName)
//// val te = linesFromFile.joinToString(prefix = "",
////     separator ="\r\n",
////     postfix = "")
//// File(outputName).writeText(te)
//File(outputName).bufferedWriter().use { out ->
//    linesFromFile.forEach {
//        out.write("${it}\r\n")
//    }
//}



//    var linesFromFile = File(inputName).readLines().toString().split(" ").toMutableList()
//    val maxLen = linesFromFile.maxOrNull() ?: 0
//    print(maxLen)
//    var i = 0
//    while (linesFromFile[i].length != maxLen) {
//        linesFromFile[i] = " " + linesFromFile[i]
//        if (linesFromFile[i].length != maxLen) linesFromFile[i] = linesFromFile[i] + " "
//    }
//    FileWriter(outputName)