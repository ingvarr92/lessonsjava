package lesson24Lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {

    public static int someVar = 12;


    public static void main(String[] args) {
        int someLocalVal = 12;

        //синтаксис
        // (аргументы)-> тело;
        //()-> тело;

        //()->{
//        тело;
//         на;
//         несколько строк;
//        [return возвращаемое значение;]
//          }


//        лямда должна реализовывать функиональный интерфейс (т.е. с одним методом)


//        new Thread(new Runnable() {
////            @Override
////            public void run() {
////                System.out.println("Hello");
////            }
//        });
//
//        new Thread(()-> System.out.println("Hello"));
//        Runnable runnable = ()-> System.out.println("Hello");


        Operation plus = (a,b) ->a+b;
        Operation minus = (a,b) ->a-b;

        double result = plus.execute(12,23);
        result = minus.execute(12,23);

        Operation operation = (a,b) ->{
            someVar -= a;
           // someLocalVal +=b;// не можем обращаться к локальным переменным
            return someVar;
        };
        // лямда не должна менять окружающюю среду




        ButtonFactory<Button> factory = Button::new; // нотация - ссылка на метод класса, в данном случае на конструктор
        Button button = factory.set("Cancel","pink");
        System.out.println(button);




//        Предикаты
        Predicate<Integer> pos = (num) -> num > 0;

        boolean predicateRes = pos.test(10);

        Predicate<Integer> neg = (num) -> num < 0;
        predicateRes = pos.test(10);


        Button.tstVoid (pos,7);


        // Есть методы по умолчанию

        predicateRes = pos.or(neg).test(2);
        System.out.println(predicateRes);
        predicateRes = pos.and(neg).test(2);
        System.out.println(predicateRes);


        // Функции
        Function<Integer, Integer> plusTen = (a) -> a + 10;
        Function<Integer, Integer> minusTwo = (a) -> a - 2;
        Function<Integer, Integer> plusSix = (a) -> a + 6;

        int functionRes = plusTen.apply(10);
        functionRes = plusSix
                .andThen(plusTen)
                .compose(plusTen)
                .andThen(plusTen)
                .apply(1);

        System.out.println(functionRes);



        // Consumer

//        Он выполняет действия но ничего не возвращает
//

        Consumer<Button> makeResetBtn = (button1) -> button1.setValue("Reset");
        makeResetBtn.accept(button);
        System.out.println(button);

        Button button1 = new Button("First","gray");
        Button button2 = new Button("Second","gray");
        // Компораторы
        Comparator<Button> buttonComparator = Comparator.comparing(Button::getValue);
        int compareRes = buttonComparator.compare(button1,button2);
        System.out.println(compareRes);

        compareRes = buttonComparator.reversed().compare(button1,button2);
        System.out.println(compareRes);


//        Методы коллекций, которые принимают Лямбда

    // forEach (лямда выражение)

        List<Integer> integers = new ArrayList<>(Arrays.asList(23,67,12,-12,0));
        List<Integer> integers1 = new ArrayList<>();
        integers.forEach((s)-> System.out.println(s + " "));
        integers.forEach((s)-> integers1.add(s + 10));
        System.out.println(integers1);


//        removeIf()

        integers.removeIf((s)-> s < 20);
        integers.removeIf(pos);
        System.out.println(integers);


//        Map.forEach()

            Map<String,String> books = new HashMap<>();
            books.put("Идиот", "Достаевский");
            books.put("Бесы", "Достаевский");

            books.forEach((key, value)-> System.out.println("Title: "+ key + " Author: " + value));

            books.compute("Идиот", (key, val) -> val + " и еще один автор");
        System.out.println(books);

//        books.computeIfAbsent()
//        books.computeIfPresent( )


//            Map.getOrDefault
            String author = books.getOrDefault("Идиот 2", "нет автора");
        System.out.println(author);

    }

    @FunctionalInterface // показывает, что у интрефейса должен быть только один метод
    interface Operation{
        double execute (int a, int b);
    }

    interface ButtonFactory <T extends Button>{
        T set (String value, String color);
    }

    static class Button{
        private String value;
        private String color;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Button(String value, String color) {
            this.value = value;
            this.color = color;
        }

        public static void tstVoid(Predicate<Integer> predicate, int i){
            predicate.test(i);
        }

        @Override
        public String toString() {
            return "Button{" +
                    "value='" + value + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

}
