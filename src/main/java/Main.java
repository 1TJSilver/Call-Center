import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Group");
        ConcurrentLinkedQueue <String> queue = new ConcurrentLinkedQueue<>();
        new ATCThread(group, queue, "ATCThread").start();
        new OperatorThread(group, queue, "First Operator").start();
        new OperatorThread(group, queue, "Second Operator").start();
        new OperatorThread(group, queue, "Third Operator").start();
    }
}
