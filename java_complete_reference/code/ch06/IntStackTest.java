class Stack {
    int stck[] = new int[10];
    int tos;

    Stack() {
        tos = -1;
    }

    void push(int item) {
        if(tos == 9)
            System.out.println("Stack is full.");
        else
            stck[++tos] = item;
    }

    int pop() {
        if(tos < 0) {
            System.out.println("Stack underflow.");
            return 0;
        }
        else
            return stck[tos--];
    }
}


class IntStackTest {
    public static void main(String args[]) {
        Stack s = new Stack();

        // Should underflow
        int out = s.pop();

        // Push a value onto the stack
        s.push(15);

        // Pop a value off the stack
        int out2 = s.pop();
        System.out.println("Popped value is: " + out2);
    }
}