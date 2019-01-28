package homeWork.queue.pizza;

import java.util.concurrent.BlockingQueue;

class Waiter extends Thread {
    private Order orderWaiter;


    private BlockingQueue<Order> clientQueue;
    private BlockingQueue<Order> waiterQueue;

    Waiter(BlockingQueue<Order> clientQueue, BlockingQueue<Order> waiterQueue) {
        this.clientQueue = clientQueue;
        this.waiterQueue = waiterQueue;
    }

    @Override
    public void run() {
        try {
            orderWaiter = clientQueue.take();
            if(orderWaiter.isClient())
                System.out.println("Заказ получен официантом от клиента");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orderWaiter.setWaiter(true);
        try {
            waiterQueue.put(orderWaiter);
            System.out.println("Заказ передан повару");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
