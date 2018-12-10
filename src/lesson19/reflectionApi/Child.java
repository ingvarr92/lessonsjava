package lesson19.reflectionApi;
// reflection api

public class Child extends Parent{
    private String name;
    private int version = 1;
 //   private Parent parent;

    public Child(String name, int version) {
       // this.parent = new Parent();// но так делать плохо из-за свойств объекта
       // this.parent = parent;
        this.name = name;
        this.version = version;
    }


    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    private String getInfo(){
        return "private getInfo()";
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }


}

class Parent {

}
