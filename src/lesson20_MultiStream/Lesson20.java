package lesson20_MultiStream;

public class Lesson20 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());


        Thread thread = new Thread(); // создание потока
        thread.start();// запуск потока


        Thread thread1 = new MyThread();// первый вариант
        thread1.start();

        Thread thread2 = new Thread(new OtherThread()); // второй вариант
        thread2.start();


        for (int i = 0; i< 5 ; i++ ){
            Thread thread3 = new Thread(new OtherThread());
            thread3.setName("T -" + i);
            thread3.start();
        }



//        методы класса Thread
////                currentThread(); - для получения текущего потока
////                setName(str); - дать имя потока
////                getName(); - получить имя потока
        //          join();
//                    isAlive();
//                    isInterrupted();
//                    interrupt();


        Thread thread4 = new Thread(new Runnable() { // запуск потока через аннонимный класс
            @Override
            public void run() {
                System.out.println(Thread.currentThread().isAlive());
                System.out.println(Thread.currentThread().getState());
            }
        });

        System.out.println("Before Start "+thread4.isAlive());
        System.out.println("Before Start "+thread4.getState());
        thread4.start();

        thread4.join();

        System.out.println("After .join "+thread4.isAlive());
        System.out.println("After .join "+thread4.getState());


        // Программа бует работать пока незавершен хотя бы один поток.
        // Это касается ОСНОВНЫХ потоков

        // Потоки можно отметить как deamon (неосновной) они завершаются сразу после завершения всех основных
          /*  Thread thread5 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            thread5.start();*/


        Thread thread6 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000); // такую конструкцию надо использовать хорошо подумав
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        });
        thread6.setDaemon(true);
        thread6.start();



        // Остановка потоков
//        1. Логическое завершение
//        2. В методе run выброшено необработанное исключение
//        3. остановка JVM
//        4. это был deamon и последний основной поток завершился

        // механизм прерывания

        Thread thread7 =  new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    try {
                        System.out.println("thread7");
                        Thread.sleep(1000); // такую конструкцию надо использовать хорошо подумав
                    } catch (InterruptedException e) {
                       // e.printStackTrace();
                        Thread.currentThread().interrupt();
                        System.out.println("InterruptedException");
                    }
                }

            }

        });

        thread7.start();
        thread.sleep(2000);
        System.out.println(thread7.isInterrupted());
        thread7.interrupt();


    }

}

// для создания своего потока необходимо унаследоваться от класса Thread
class MyThread extends Thread{ // первый вариант

    @Override
    public void run() {
        System.out.println("MyThread "+ Thread.currentThread().getName());
    }
}


class OtherThread implements Runnable{ // такой вариант используется чаще. что бы освободить extends. Они равнозначны
    @Override
    public void run() {
        System.out.println("OtherThread "+ Thread.currentThread().getName());
    }
}