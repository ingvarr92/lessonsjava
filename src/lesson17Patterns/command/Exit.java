package lesson17Patterns.command;

public class Exit extends Command  {
    public Exit(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "ExitCommand";
    }

    @Override
    boolean execute() {
        System.out.println("реализация ExitCommand");
        // Реализация команды
        return false;
    }
}
