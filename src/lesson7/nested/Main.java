package lesson7.nested;

public class Main {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("Outer");
        outerClass.getInnerClass().someVoid(); // внутренний класс поменял статическую переменную внешнего
        System.out.println(OuterClass.intVal);
    }
}
