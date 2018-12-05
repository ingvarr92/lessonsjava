package lesson17Patterns.command;

public class Repeat extends Command  {
    public Repeat(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "RepeatCommand";
    }

    @Override
    boolean execute() {
        System.out.println("реализация RepeatCommand");
        // Реализация команды
        return false;
    }
}
