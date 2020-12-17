class NestedTry {
    public static void main(String args[]) {
        try {
            int a = args.length;
            int b = 42 / a;

            try {
                int c[] = { 1 };
                c[42] = 99;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Array index exception: " + e);
            }
        }
        catch (ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        }
    }
}