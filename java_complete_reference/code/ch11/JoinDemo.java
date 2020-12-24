class JoinThread implements Runnable {
    String name;
    Thread t;

    JoinThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
    }

    public void run() {
        try {
            for (int i=5; i>0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }

        System.out.println(name + " exiting.");
    }
}


class JoinDemo {
    public static void main(String args[]) {
        JoinThread jt1 = new JoinThread("One");
        JoinThread jt2 = new JoinThread("Two");
        JoinThread jt3 = new JoinThread("Three");

        // Start the threads
        jt1.t.start();
        jt2.t.start();
        jt3.t.start();

        // Verify that threads are running
        System.out.println("Thread One is alive: " + jt1.t.isAlive());
        System.out.println("Thread Two is alive: " + jt2.t.isAlive());
        System.out.println("Thread Three is alive: " + jt3.t.isAlive());

        // Wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            jt1.t.join();
            jt2.t.join();
            jt3.t.join();
        }
        catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Vefiry that threads have stopped
        System.out.println("Thread One is alive: " + jt1.t.isAlive());
        System.out.println("Thread Two is alive: " + jt2.t.isAlive());
        System.out.println("Thread Three is alive: " + jt3.t.isAlive());

        System.out.println("Main thread exiting.");
    }
}