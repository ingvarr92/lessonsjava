package lesson17Patterns.command;

import java.util.Scanner;

public class TextProcessor {
    // перечилслить все команды константами
    enum Commands {process, repeat, cancel, exit };

    private CommandsHistory history = new CommandsHistory();

    //private
    private void executeCommand(Command command){
        if(command.execute()){
            history.add(command);
        }
    }

    public void start(){
        System.out.println("Дратути");
        System.out.println("Вам доступны следующие команды:");
        System.out.println("Process");
        System.out.println("Repeat");
        System.out.println("Cancel");
        System.out.println("Exit");
        Scanner in = new Scanner(System.in);
        while (true){
            switch (in.nextLine()){
                case "process":
                    executeCommand(new ProcessCommand(this));
                break;
                case  "exit":
                    executeCommand(new Exit(this));
                    break;
                case "repeat":
                    executeCommand(new Repeat(this));
                    break;
                case "cancel":
                    executeCommand(new Cancel(this));
                    break;

            }
        }
    }
}
