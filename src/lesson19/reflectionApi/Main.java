package lesson19.reflectionApi;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        // каждый загруженный класс имеет соответствующий java.lang.Class объект,
        // который дает доступ к структуре и полям класса
        // У каждого типа есть свой литерал class
        System.out.println(String.class);
        System.out.println(int.class);


        Child child = new Child("str", 2);
        // строковой литерал объекта
        System.out.println(child.getClass());
        // строковой литерал класса
         Class cls;
         cls = child.getClass();
        System.out.println("child name " + cls.getName());

        cls = cls.getSuperclass();
        System.out.println("child extends "+ cls.getName());

        // доступ к компонентам класса

        // класс объекта

        Class<Child> childClass = Child.class;

        // доступ к полям

        Field[] fields = childClass.getFields(); // доступ ко всем неприватным полям
        System.out.println(Arrays.toString(fields));

        // доступ ко declared полям
        Field[] declaredFields = childClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));


        // доступ к методам
        Method[] methods = childClass.getMethods(); // неприватные методы + методы родителей
        System.out.println(Arrays.toString(methods));

        Method[] declaredMethods = childClass.getDeclaredMethods(); // нет методов родителей, но есть приватные методы
        System.out.println(Arrays.toString(declaredMethods));


        // доступ к конструкторам

        Constructor<?>[] declaredConstructors = childClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        // доступ к конкретному полю, методу, конструктору

        Field field = childClass.getDeclaredField("name");
        // получить доступ к полю
        field.setAccessible(true);
        // задаем значение свойства
        field.set(child, "CHILD");
        System.out.println((String) field.get(child));
        System.out.println(child);


        // получение доступа к методам

        Method method = childClass.getDeclaredMethod("getInfo");
        method.setAccessible(true);
        String data = (String) method.invoke(child);
        System.out.println(data);


        // получение конструктора

//        Constructor<Child> childConstructor = childClass.getConstructor();
//        Child child1 = childConstructor.newInstance();
//        child1.getVersion();
        Constructor<Child> childConstructor = childClass.getConstructor(String.class, int.class);
        Child child1 = childConstructor.newInstance("str2",3);
        System.out.println(child1);


        boolean isFinal = Modifier.isFinal(field.getModifiers());
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());


        Class<?>[] intefaces = childClass.getInterfaces();


    }
}
