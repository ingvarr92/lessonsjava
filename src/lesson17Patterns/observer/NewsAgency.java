package lesson17Patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {

    private List<Listener> listeners = new ArrayList<>();

    public void add (Listener listener){
        listeners.add(listener);
    }

    public void deleteListener (Listener listener){
        listeners.remove(listener);
    }

    public void newMessage (String mes){
        System.out.println("Message: " + mes);
        notifyListeners(mes);
    }

    private void notifyListeners (String mes){
        for (Listener listener : listeners){
            listener.publish(mes);
        }
    }




    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        newsAgency.add(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("listener 1 " + str);
            }
        });

        newsAgency.add(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("listener 2 " + str);
            }
        });

        newsAgency.newMessage("some changes");

    }
}
