package lesson23;

import chat.Message;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // java.util.concurrent.Callable - возвращаем данные из потока

        // java.util.concurrent.Future

//        get() get(long l, TimeUnit tu) - позволяют получить из потока результат

//        cancel() - мы можем прервать выполнение действий. Отменяет текущюю задачу

//        isCanceled() -  true/false
//        isDone() true/false

//        FutureTask это обертка над потоком

//        new FutureTask(Callable<T> c);
//        new FutureTask(Runnable r, T result);


//        FutureTask<String> task = new FutureTask<>(new Callable<String>(){
//
//            @Override
//            public String call() throws Exception {
//                int counter = 0;
//                while (!Thread.currentThread().isInterrupted()&& counter < 3 ){
//                    counter++;
//                    Thread.sleep(1000);
//                }
//
//                return "Finished";
//            }
//            } );
//
//        String result = task.get();
//        System.out.println(result);


        FutureTask<String> task1 = new FutureTask<>(new Callable<String>(){

            @Override
            public String call() throws Exception {
                int counter = 0;
                while (!Thread.currentThread().isInterrupted()&& counter < 3 ){
                    counter++;
                    Thread.sleep(1000);
                }

                return "Finished";
            }
        } );

        new Thread(task1).start();
        Thread.sleep(2000);
        task1.cancel(true);

        System.out.println(task1.isCancelled());
        System.out.println(task1.isDone());

//        interface Executor позволяет управлять группой потоков


//        execute (Runnable runnable); передаем поток
//        Указанный поток начинает свое выполнение

//        new Thread(task1).start();
//
//        ExecutorService executorService; // создание объекта
//
//        executorService.execute(new Thread(task1));
//
//        executorService.submit(new Thread(task1)); // добавляет задачу на выполнение и возвращает Future объект


//        класс Executors
//        Executors.newFixedThreadPool(int i); // создает пул потоков с заданным количеством
//        Executors.newSingleThreadExecutor(); // создаст один поток
//        Executors.newCachedThreadPool(); // создаст нужное количество потоков зависит от нагрузки
//        Executor.newScheduledThreadPool(int i); расписание потоков


        ExecutorService pool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5 ; i++){
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("pool: "+ Thread.currentThread().getName());
                }
            });
        }
        // метод submit возращает объект Future
        // соотв. ему доступны все его методы
        pool.submit(new Thread(task1)).get();
        pool.shutdown();



        ExecutorService service = new ThreadPoolExecutor(
                1,
                10,
                2,TimeUnit.MINUTES,
                new LinkedBlockingDeque<>());
        for (int i = 0; i < 3; i++){
            service.submit(new Runnable() {
                @Override
                public void run() {
                    // код
                }
            });
        }




        // объекты синхронизации

//        CountDownLatch(int num) - блокирует выполнение потоков пока не выполнены условия, передаем события, которые должны произойти

//        await(); - блокировка потоков

//        countDown(); уменьшаем счетчик событий на один. Как только счетчик обнуляется потоки будут запущены.

//        Exchanger
//        exchange(T buffer); обмен данными
//        Exchanger<Message> exchanger
//        messages[4] = exchanger.exchange(messages[4]);


        //---------------------ДЗ
//        Создаете классы:
//        Пользователь (Id, email)
//                id должны быть уникальными
//        Аккаунт (Id, Id.Пользователя, количество средств)
//                id должны быть уникальными
//         Банк (Список всех аккаунтов, метод перевода денег,)
//                    transferMoney(Account_src(откуда), Account_dst(куда), int amount (сумма)) Потокобезопасная проверка
//
//        Транзакция(Account_src(откуда), Account_dst(куда), int amount (сумма), Банк, Data date) здесь должен быть поток
//
//

    }
}
