package homeWork.queue.pizza;

import java.util.concurrent.BlockingQueue;

class Cook extends Thread {
    private Order cookOrder;

    private BlockingQueue<Order> waiterQueue;
    private BlockingQueue<Order> cookQueue;

    Cook(BlockingQueue<Order> waiterQueue, BlockingQueue<Order> cookQueue) {
        this.waiterQueue = waiterQueue;
        this.cookQueue = cookQueue;
    }

    @Override
    public void run() {
        try {
            cookOrder = waiterQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (cookOrder.isCook())
            if (cookOrder.isWaiter())
                System.out.println("Заказ получен поваром от официанта");
        cookOrder.setCook(true);
        try {
            cookQueue.put(cookOrder);
            System.out.println("Заказ передан клиенту");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
