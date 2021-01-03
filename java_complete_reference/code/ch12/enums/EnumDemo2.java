enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland
}


class EnumDemo2 {

    public static void main(String args[]) {
        Apple ap;

        System.out.println("Here are all the Apple constants:");

        // Use values()
        Apple allApples[] = Apple.values();
        for (Apple a : allApples)
            System.out.println(a);

        System.out.println();

        // Use valueOf
        ap = Apple.valueOf("Winesap");
        System.out.println("ap contains " + ap);
    }
}