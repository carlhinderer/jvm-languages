// Create multiple threads
class MultiThread implements Runnable {
    String name;   // Name of thread
    Thread t;

    MultiThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
    }

    // Entry point for the thread
    public void run() {
        try {
            for (int i=5; i>0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println(name + " Interrupted");
        }

        System.out.println(name + " exiting");
    }
}


class MultiThreadDemo {
    public static void main(String args[]) {
        MultiThread m1 = new MultiThread("One");
        MultiThread m2 = new MultiThread("Two");
        MultiThread m3 = new MultiThread("Three");

        // Start the threads
        m1.t.start();
        m2.t.start();
        m3.t.start();

        try {
            // Wait for other threads to end
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread exiting.");
    }
}