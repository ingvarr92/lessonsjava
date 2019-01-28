package homeWork.queue.pizza;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {


    public static void main(String[] args) {
        Order order = new Order();
        BlockingQueue<Order> clientQu = new ArrayBlockingQueue<>(1, true);
        BlockingQueue<Order> waiterQu = new ArrayBlockingQueue<>(1, true);
        BlockingQueue<Order> cookQu = new ArrayBlockingQueue<>(1, true);
        Client client = new Client(clientQu, cookQu, order);
        Waiter waiter = new Waiter(clientQu, waiterQu);
        Cook cook = new Cook(waiterQu, cookQu);
        client.start();
        waiter.start();
        cook.start();
    }
}


