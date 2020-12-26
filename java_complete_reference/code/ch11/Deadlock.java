// An example of deadlock

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered A.foo");

        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println("A Interrupted");
        }

        System.out.println("Trying to call B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered B.bar");

        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println("B Interrupted");
        }

        System.out.println("Trying to call A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last");
    }
}

class Deadlock implements Runnable {
    A a = new A();
    B b = new B();
    Thread t;

    Deadlock() {
        Thread.currentThread().setName("MainThead");
        t = new Thread(this, "RacingThread");
    }

    void deadlockStart() {
        t.start();
        a.foo(b);      // Get a lock on a in this thread
        System.out.println("Back in main thread");
    }

    public void run() {
        b.bar(a);     // Get a lock on b in this thread
        System.out.println("Back in other thread");
    }

    public static void main(String args[]) {
        Deadlock dl = new Deadlock();
        dl.deadlockStart();
    }
}