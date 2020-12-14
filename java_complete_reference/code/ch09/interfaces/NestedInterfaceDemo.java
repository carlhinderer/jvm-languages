// This class contains a member interface
class A {
    // This is a nested interface
    public interface NestedInterface {
        boolean isNotNegative(int x);
    }
}

// This class implements the nested interface
class B implements A.NestedInterface {
    public boolean isNotNegative(int x) {
        return x < 0 ? false : true;
    }
}

class NestedInterfaceDemo {
    public static void main(String args[]) {
        A.NestedInterface nif = new B();
        if (nif.isNotNegative(10))
            System.out.println("Not negative.");
    }
}