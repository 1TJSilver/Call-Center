import java.util.concurrent.ConcurrentLinkedQueue;

public class OperatorThread extends Thread {
    static int COMING_TO_WORK = 1500;
    static int CALL_PROCESSING = 3000;
    public ConcurrentLinkedQueue<String> callQueue;
    String name;

    public OperatorThread(ConcurrentLinkedQueue<String> callQueue, String name) {
        this.callQueue = callQueue;
        this.name = name;
    }

    public OperatorThread(ThreadGroup group, ConcurrentLinkedQueue<String> queue, String name) {
        super(group, name);
        this.callQueue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(COMING_TO_WORK);
            while (!callQueue.isEmpty()) {
                Thread.sleep(CALL_PROCESSING);
                System.out.println(name + " received the call: " + callQueue.poll());
            }
        } catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
