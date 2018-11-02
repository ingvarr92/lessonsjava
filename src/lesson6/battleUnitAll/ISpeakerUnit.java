package lesson6.battleUnitAll;

public interface ISpeakerUnit {// все свойства здесь надо задавать сразу и поменять их бует нельзя

    void say (String text);
    void sing (String text);
    default  void greeting (){ // можно делать default методы с реализацией
        System.out.println("Hello!");
    }


}
