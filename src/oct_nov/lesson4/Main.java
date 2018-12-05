package oct_nov.lesson4;

public class Main {
    public static void main(String[] args) {
        Good table = new Good();
        table.setTitle("Table");
        table.setPrice(200);
        System.out.println(table.toString());

        Good chair = new Good();
        chair.setTitle("Chair");
        chair.setPrice(100);
        System.out.println(chair.toString());

        System.out.println(table.getTitle());

        Storage storage = new Storage();
        storage.addGood(table);
        storage.addGood(chair);
        storage.addGood(chair);
        storage.addGood(chair);
        storage.addGood(chair);
        storage.showGoods();

        Good door = new Good("Дверь", 250);
        System.out.println(door.toString());

    }
}
