package lesson17Patterns.builder;

public class Director {
    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder cb){
        this.computerBuilder = cb;
    }

    public Computer getComputer(){
        return computerBuilder.getComputer();
    }

    public void constuctorComputer(){
        computerBuilder.createComputer();
        computerBuilder.buildDisplay();
        computerBuilder.buildManipulators();
        computerBuilder.buildSystemBlock();
    }


}
