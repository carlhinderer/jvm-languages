class IFTest {
    public static void main(String args[]) {
        FixedStack myStack = new FixedStack(5);

        for(int i=0; i<5; i++) myStack.push(i);

        for(int i=0; i<5; i++) System.out.println(myStack.pop());
    }
}