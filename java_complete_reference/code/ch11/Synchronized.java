// This program is synchronized
// The different threads' calls to 'call' will not interfere with each other

class CallMe {
    synchronized void call (String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    CallMe target;
    Thread t;

    public Caller(CallMe targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
    }

    public void run() {
        target.call(msg);
    }
}

class Synchronized {
    public static void main(String args[]) {
        CallMe target = new CallMe();
        Caller c1 = new Caller(target, "Hello");
        Caller c2 = new Caller(target, "Synchronized");
        Caller c3 = new Caller(target, "World");

        // Start the threads
        c1.t.start();
        c2.t.start();
        c3.t.start();

        // Wait for the threads to end
        try {
            c1.t.join();
            c2.t.join();
            c3.t.join();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}