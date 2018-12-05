package oct_nov.lesson7.nested;

public class OuterClass {
    String value;
    static int intVal = 1;
    public OuterClass (String value){
        this.value = value;
    }
    public InnerClass getInnerClass(){
        return new InnerClass("String");
    }

    static class InnerClass{// вложенный класс

        String val;

        public InnerClass(String val) {
            this.val = val;
        }
        public void  someVoid(){
           intVal +=12;
            System.out.println(intVal);

        }
    }
}
