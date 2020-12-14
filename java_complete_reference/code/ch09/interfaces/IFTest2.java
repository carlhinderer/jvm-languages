class IFTest2 {
    public static void main(String args[]) {
        DynStack myStack = new DynStack(5);

        for(int i=0; i<10; i++) myStack.push(i);

        for(int i=0; i<10; i++) System.out.println(myStack.pop());
    }
}