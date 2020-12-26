// Suspending and resuming a thread the modern way

class NewThread implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
    }

    public void run() {
        try {
            for (int i=15; i>0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }

        System.out.println(name + " exiting.");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}

class SuspendResume {
    public static void main(String args[]) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");

        // Start the threads
        ob1.t.start();
        ob2.t.start();

        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Suspending thread one.");

            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Resuming thread one.");

            ob2.mysuspend();
            System.out.println("Suspending thread two.");

            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Resuming thread two.");
        }
        catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
        }
        catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread exiting.");
    }
}