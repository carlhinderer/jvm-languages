class ChainExceptionDemo {
    static void demoproc() {
        // Create an exception
        NullPointerException e = new NullPointerException("top layer");

        // Add a cause
        e.initCause(new ArithmeticException("cause"));

        throw e;
    }

    public static void main(String args[]) {
        try {
            demoproc();
        }
        catch (NullPointerException e) {
            // Display top level exception
            System.out.println("Caught: " + e);

            // Display cause exception
            System.out.println("Original cause: " + e.getCause());
        }
    }
}