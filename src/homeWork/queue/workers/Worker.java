package homeWork.queue.workers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;


public class Worker implements Runnable {
    private Map<String,Integer> maps;
    BlockingQueue<Map<String,Integer>> blockingQueue;
    BlockingQueue<String> strings;
    private final String EXIT;

    public Worker (Main main){
        this.maps = new HashMap<>();
        this.blockingQueue = main.blockingQueue;
        this.strings = main.strings;
        this.EXIT = main.getEXIT();
    }

    @Override
    public void run() {
        while (true){
            String string = null;
            try {
                string = strings.take();
            }catch (Exception e){
                System.out.println(e);
            }

            if(string.equals(EXIT)){
                try {
                    blockingQueue.put(maps);
                }catch (Exception e){
                    System.out.println(e);
                }
                break;
            }

            String[] words = string.toLowerCase().replaceAll("\\p{Punct}", " ").
                    trim().split("\\s");
            for (String s: words){
                if (s.equals(""))
                    continue;
                maps.merge(s, 1, (oldVal, newVal)-> oldVal + newVal);

            }
        }
    }
}
