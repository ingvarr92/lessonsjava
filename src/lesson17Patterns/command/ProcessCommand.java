package lesson17Patterns.command;

public class ProcessCommand extends Command {

    public ProcessCommand(TextProcessor processor) {
        super(processor);
    }





    @Override
    String name() {
        return "ProcessCommand";
    }

    @Override
    boolean execute() {
        // Реализация команды


        System.out.println("реализация ProcessCommand");

        return true; // если команда выполнилась. для истории команд
    }
}
