package homeWork.queue.port;

class Ship {
    final String name;
    final int size;
    int cargoCount;
    Action action;

    public Ship(String name, int size, int cargoCount, Action action) {
        this.name = name;
        this.size = size;
        this.cargoCount = cargoCount;
        this.action = action;
    }

    @Override
    public String toString() {
        return "Корабль " + name + " : " + size + " (" + cargoCount + ") ";
    }
}
