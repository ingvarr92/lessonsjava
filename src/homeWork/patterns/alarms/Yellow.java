package homeWork.patterns.alarms;

public class Yellow implements Alarm{
    private int block = 0;

    @Override
    public void tempChanged(int temp) {
        if (block ==0 ) {
            if (temp >= 300) {
                System.out.println("Yellow Alarm");
                block++;
            }
        }else if (temp < 300){
                block--;
            }

    }
}
