package homeWork.patterns.alarms;

public class Green implements Alarm{
    private int block = 0;

    @Override
    public void tempChanged(int temp) {
        if (block == 0 ) {
            if (temp >= 100) {
                System.out.println("Green Alarm");
                block++;
            }
        }else if (temp < 100){
                block--;
            }
    }
}
