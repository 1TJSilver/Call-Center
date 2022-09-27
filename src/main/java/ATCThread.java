import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ATCThread extends Thread{

    public ConcurrentLinkedQueue<String> callQueue;
    public String[] variation;

    public ATCThread(ConcurrentLinkedQueue<String> callQueue, String name){
        this.callQueue = callQueue;
    }
    public ATCThread(ThreadGroup group, ConcurrentLinkedQueue<String> queue, String name){
        super(group, name);
        this.callQueue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            callQueue.add(generateCall());
        }
    }
    private String generateCall() {

        variation = new String[]{
                "Your internet is very BAD!",
                "He-e-elp", "I want to unsubscribe",
                "Good connection"
        };
        return variation[new Random().nextInt(variation.length)];
    }
}
