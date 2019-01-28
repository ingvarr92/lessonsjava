package lesson17Patterns.adapter;

public class TstAdapter {

    public static void main(String[] args) {
     //   FirstInterface first = Somefactory.get();
   //     SecondInterface second = new Adapter(first);

      //  SecondUtils.saveData (second);
    }
}

interface FirstInterface{
    void add(int i);
}

interface SecondInterface{
    int get (int i);
}


class SecondUtils{
    public static void saveData(SecondInterface second){

    }
}

//class SomeFactory{
//    public static int get(){
//        return new FirstInterface() {
//            @Override
//            public void add(int i) {
//            }
//            return 1;
//        };
//    }
//}1

class Adapter implements SecondInterface{
    private FirstInterface first;
    public Adapter (FirstInterface first){
        this.first = first;
    }

    @Override
    public int get (int i){
        this.first.add(i);
        return 1;
    }



}