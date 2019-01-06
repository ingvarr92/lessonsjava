package homeWork.patterns.alarms;

public class Red  implements Alarm{
    private int block = 0;

    @Override
    public void tempChanged(int temp) {
        if (block ==0 ) {
            if (temp >= 500) {
                System.out.println("Red Alarm");
                block++;
            }
        }else if (temp < 500){
                block--;
            }

    }
}
