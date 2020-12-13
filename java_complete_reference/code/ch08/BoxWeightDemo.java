class Box {
    double width;
    double height;
    double depth;

    // Clone an object
    Box (Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    // Constructor with all dimensions specified
    Box (double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // Constructor with no dimensions specified
    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    // Constructor used to create cube
    Box(double len) {
        width = len;
        height = len;
        depth = len;
    }

    // Compute and return volume
    double volume() {
        return width * height * depth;
    }
}


// Box is extened to also include weight
class BoxWeight extends Box {
    double weight;

    BoxWeight(double w, double h, double d, double m) {
        width = w;
        height = h;
        depth = d;
        weight = m;
    }
}


class BoxWeightDemo {
    public static void main(String args[]) {
        BoxWeight bw = new BoxWeight(5, 10, 12, 24.5);
        System.out.println("Volume: " + bw.volume());
        System.out.println("Weight: " + bw.weight);
    }
}