package Lesson25StreamApi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class StreamApi{
    public static void main(String[] args) throws IOException {


        Integer[] arr = {23, 48, 5, 6, 7, 8, 100};


        File file = new File("wp.txt");
       // Stream<String> fileStream = File.lines(file.toPath());


        IntStream intStream = IntStream.range(12, 23);

        LongStream longStream = LongStream.builder().add(3).add(23).add(67).build();

        ArrayList list = new ArrayList<>(Arrays.asList(arr));
     //   list.stream().filter(s -> s>20).map(s -> s + 10).sorted().forEach(System.out::println);


        Optional<Integer> optional = Stream.of(1,2,3,6).filter(s->s<5).findFirst();


        Integer i = optional.orElse(0);

        Integer res = Stream.of (1,2,3).reduce(0,(k,j)->k+j);
        System.out.println(res);



        // top 10

        Map<String, Long> map =
                // получаем стрим из файла
                Files.lines(file.toPath())
                // указываем что стрим должен быть параллельным
                .parallel()
                //убрать знаки препинания
                .map((line) ->line.toLowerCase().replaceAll("\\pP", " "))
                // каждую строчку разбиваем на слова
                .flatMap((line)->Arrays.stream(line.split(" ")))
                //обрезаем пробелы
                .map(String::trim)
                //убираем невалидные слова
                .filter(word->!"".equals(word))
                .collect(groupingBy(identity(), counting()))
                .entrySet().parallelStream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                        .limit(10)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(map);

        Stream<String> streamStream1 =  Files.lines(file.toPath()) // делаем стрим на основе кода
                // указываем что стрим должен быть параллельным
                .parallel()
                //убрать знаки препинания
                .map((line) ->line.toLowerCase().replaceAll("\\pP", " "))
                // каждую строчку разбиваем на слова
                .flatMap((line)->Arrays.stream(line.split(" ")))
                //обрезаем пробелы
                .map(String::trim)
                //убираем невалидные слова
                .filter(word->!"".equals(word));


        // the

        Long count = streamStream1
                .filter(("the"):: equals)
                .count();

        System.out.println(count);


                // выбрать все элементы, содержащие the


//        List<String> listRes = streamStream1
//                .filter((s)->s.contains("the"))
//                .collect(Collectors.toList());
//
//        System.out.println(listRes);


        Stream<Integer> arrStream = Arrays.stream(arr);
        IntSummaryStatistics statistics = arrStream
                .collect(Collectors.summarizingInt((p)->p-1));

        System.out.println(statistics);


        //Выбрать пользователей в возрасте от 18 до 40 летт
        //Найти макс. возраст
        //
        // Найти средний возраст
        //
        // добавить в map
        User user1 = new User ("qwe", 23);
        User user2 = new User ("qwe1", 3);
        User user3 = new User ("qwe2", 123);
        User user4 = new User ("qwe3", 12);
        User user5 = new User ("qwe4", 2);
        User user6 = new User ("qwe5", 53);
        User user7 = new User ("qwe6", 63);
        User user8 = new User ("qwe7", 25);
        User user9 = new User ("qwe8", 29);

        List<User> userList = new ArrayList();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);
        userList.add(user9);


        Stream<User> userStream1 = userList.stream();
        IntSummaryStatistics statistics1 = userStream1.collect(Collectors.summarizingInt((s)->s.getAge()));
        System.out.println("MAX: "+ statistics1.getMax());
        System.out.println("AV: "+ statistics1.getAverage());



       // userList.stream().mapToInt(User::getAge).avarage().getAsDouble();


        // сумма всех нечетных чисел
        list = new ArrayList<>(Arrays.asList(arr));

        Stream<Integer> integerStream = list.stream();

        int ii = integerStream.filter((s)->s%2!=0).reduce((j,k)-> j+k).orElse(0);
        System.out.println(ii);




        // проверить, есть ли символ w во всех именах

        System.out.println(userStream1.allMatch((s)->s.getName().contains("w")));





    }

        static class User{
        private String name;
        private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    }
}

// три блоекирующие очереди в задаче про ресторан
//новые заказы, готовящиеся заказы, готовые заказы
// клиенты кладут(put()) заказ в новые, официвнты берут (take()) из очереди новые и кладут в готовящиеся, повара перекладывают в готовые заказы
// клиент берет заказ из готовых



