package homeWork.queue.pizza;

import java.util.concurrent.BlockingQueue;

class Client extends Thread {
    private Order order;
    private BlockingQueue<Order> clientQueue;
    private BlockingQueue<Order> cookQueue;

    Client(BlockingQueue<Order> clientQueue, BlockingQueue<Order> cookQueue, Order order) {
        this.clientQueue = clientQueue;
        this.cookQueue = cookQueue;
        this.order = order;
    }

    @Override
    public void run() {
        order.setClient(true);
        try {
            order.setClient(true);
            clientQueue.put(order);
            System.out.println("Заказ создан");
            order = cookQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (order.isCook())
            System.out.println("Заказ готов");
    }
}
