package lesson17Patterns.command;

public class Cancel extends Command  {
    public Cancel(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "CancelCommand";
    }

    @Override
    boolean execute() {

        System.out.println("реализация CancelCommand");
        // Реализация команды


        return false;
    }
}
