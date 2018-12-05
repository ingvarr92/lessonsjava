package lesson17Patterns.builder;

public class Main {
    public static void main(String[] args) {

//        Computer computer = new Computer();
//        computer.setManipulators("Manipulator");
//        computer.setDisplay("Display");
//        computer.setSystemBlock("SystemBlock");


        Director director = new Director();
        ComputerBuilder computerBuilder = new SomeComputerBuilder();
        director.setComputerBuilder(computerBuilder);
        director.constuctorComputer();
        Computer computer1 = director.getComputer();
        System.out.println(computer1);

    }
}
