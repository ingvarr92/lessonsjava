package lesson5;

import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class lesson5 {
    public static void main(String[] args) {

        // --------------------------------Регулярные выражения
        // Шаблоны с их помощю можно найти и заменить в строке.
        //

        String string = "Строка 1 для поиска и замены СИМВОЛОВ";
        String pattern = "иск";
        System.out.println(string.replaceAll(pattern,"*!*"));

        pattern = "^Стр"; // начало строки | $ - конец строки
        System.out.println(string.replaceAll(pattern,"*!*"));

        pattern = "[иск]";// перечень символов он ищет все такие символы и заменять их

        System.out.println(string.replaceAll(pattern,"*"));

        pattern = "[^иск]"; // Исключение этих символов из поиска
        System.out.println(string.replaceAll(pattern,"*"));

        pattern = "[\\d]"; // цифровой символ
        System.out.println(string.replaceAll(pattern,"*"));

        pattern = "[\\D]"; // Нецифровой символ
        System.out.println(string.replaceAll(pattern,"*"));

        pattern = "\\[\\]}"; // замена спецсимволов
        System.out.println(string.replaceAll(pattern,"*"));


        // w - буквенно цифровой символ или _
        // W - не w
        // s - любой пробельный символ и перенос строчки и табуляция
        // S - Непробельный символ
        //

        pattern = "[а-я]"; // все руские маленькие буквы от а до я, кроме ё
        pattern = "[А-Я]"; // все руские заглавные буквы от а до я, кроме Ё
        pattern = "[А-Я 0-9]"; // буквы и цифры
        pattern = "[А-Я] [0-9]"; // какая то буква, а зразу полсле цифра
        //pattern = "[А-Я \\d]"; // какая то буква, а зразу полсле цифра
        System.out.println(string.replaceAll(pattern,"*"));


//        Pattern | Matcher
        string = "String B1 to search and replace CHARS";
                // точка - любой символ, скобки - повторение от и до
         Pattern pattern1 = Pattern.compile(".{6,}");
        Matcher matcher = pattern1.matcher (string);
        System.out.println(matcher.find()); // true или false поиск есть или нет
        System.out.println(matcher.matches()); // true или false полное совпадение

        pattern1 = Pattern.compile("(?=.*\\d)(?=.*\\[a-z])(?=.*\\[A-Z]).{8,}");
        // ? = должно быть соответствие
        // () в строке обязательно должны быть
        // * повторение
        // Должно быть число, маленькие и большие буквы и длинна от 8 символов




        //-----------------------Наследование













    }
}
