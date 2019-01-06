package homeWork.patterns.alarms;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private int temp;

    public int getTemp() {
        return temp;
    }

    public Sensor(int temp) {
        this.temp = temp;
    }
    private Alarm[] alarmsList = {new Green(), new Yellow(), new Red()};

    public void tempPlus (int changeAt){
        temp= temp + changeAt;
        System.out.println("Temperature rise to: " + temp + "C*");
        notifyListeners(temp);
    }
    public void tempMinus (int changeAt){
        temp= temp - changeAt;
        System.out.println("Temperature dropped to: " + temp + "C*");
        notifyListeners(temp);
    }


    private void notifyListeners (int t){
        for (Alarm listener : alarmsList){
            listener.tempChanged(t);
        }
    }
}
