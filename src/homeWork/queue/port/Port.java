package homeWork.queue.port;

import java.util.Random;
import java.util.concurrent.*;
//    Порт. Корабли заходят в порт для разгрузки/загрузки.
//    Работает несколько причалов. У одного причала может стоять один корабль.
//    Корабль может загружаться у причала, разгружаться или выполнять оба действия.
//    (при решении использовать классы из пакета java.util.concurrent)


public class Port {

    private BlockingQueue<Ship> listShips;
    private ExecutorService dockPool;

    public Port(int maxQueueShips, int dockCount) {
        listShips = new ArrayBlockingQueue(maxQueueShips, true);
        dockPool = Executors.newFixedThreadPool(dockCount);
        addDock(dockCount);
    }

    public void addDock(int dockCount) {
        for (int i = 0; i < dockCount; i++)
            dockPool.submit(new DThread("Dock" + (i + 1)));
    }


    public void addShipQueue(Ship ship) {
        if (dockPool.isShutdown()) {
            System.out.println(ship + "не может зайти в порт - порт закрыт!");
            return;
        }
        try {
            listShips.put(ship);
            System.out.println(ship + "зашел в порт");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        dockPool.shutdown();
        while (!dockPool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Порт закончил работу.");
    }


    public static void main(String[] args) {
        Port port = new Port(5, 3);  // 3 причала, очередь в порту из 5и ожидающих кораблей

        for (int i = 1; i < 11; i++) {
            int size = new Random().nextInt(10) * 10 + 10;
            int cargoCount = new Random().nextInt(size);
            Action action = (cargoCount == 0) ? Action.LOAD :
                    (cargoCount == size) ? new Action[]{Action.UNLOAD, Action.BOTH}[new Random().nextInt(2)] :
                            Action.values()[new Random().nextInt(3)];

            Ship ship = new Ship("Ship" + i, size, cargoCount, action);
            port.addShipQueue(ship);
        }

        port.stop();
    }

    class DThread implements Runnable {

        String name;

        public DThread(String name) {
            this.name = name;
        }

        private void loadShip(Ship ship) throws InterruptedException {
            int addCargoCount = new Random().nextInt(ship.size - ship.cargoCount) + 1;
            Thread.sleep(100 * addCargoCount);
            ship.cargoCount += addCargoCount;
            System.out.println(ship + "погружен контейнерами в количестве: " + addCargoCount + " шт");
        }

        private void unloadShip(Ship ship) throws InterruptedException {
            int putCargoCount = new Random().nextInt(ship.cargoCount) + 1;
            Thread.sleep(80 * putCargoCount);
            ship.cargoCount -= putCargoCount;
            System.out.println(ship + "разгрузил контейнеров в клоличестве: " + putCargoCount + " шт");
        }


        @Override
        public void run() {
            Thread.currentThread().setName(name);
            Ship ship;
            try {
                while ((ship = listShips.poll(100, TimeUnit.MILLISECONDS)) != null) {
                    ship = listShips.take();
                    System.out.println(ship + "подошел к причалу " + Thread.currentThread().getName());
                    if (ship.action == Action.UNLOAD || ship.action == Action.BOTH) unloadShip(ship);
                    if (ship.action == Action.LOAD || ship.action == Action.BOTH) loadShip(ship);
                    System.out.println(ship + "покинул причал " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                //
            }
        }
    }

}
    enum Action {LOAD, UNLOAD, BOTH}

