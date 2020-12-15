// Read a command-line argument
println("Hello, " + args(0) + "!")

// Imperative approach
var i = 0
while (i < args.length) {
    println(args(i))
    i += 1
}

// Functional approach
args.foreach(arg => println(arg))