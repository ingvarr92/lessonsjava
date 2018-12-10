package lesson19.annotation;
//описание

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// можно указывать метаАннотации
//@Target() указывает на сферу ответственности аммотации
//METHOD
//CONSTRUCTOR
//FIELD



//@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)// как долго хранить аннотации
public @interface PermissionRequired {
    User.Permission value();

    // методы могу возвращать только примитивы, String, enum и аннотации





}
