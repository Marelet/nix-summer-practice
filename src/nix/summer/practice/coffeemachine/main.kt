package nix.summer.practice.coffeemachine

val scanner = java.util.Scanner(System.`in`)

fun options(nameOption: String, cofMash: coffeeMachine) {
    when (nameOption) {
        "buy" -> {
            cofMash.buy()
            println("\nWrite action (buy, fill, take, remaining, exit):")
        }
        "fill" -> {
            cofMash.fill()
        }
        "take" -> {
            cofMash.take()
            println("\nWrite action (buy, fill, take, remaining, exit):")
        }
        "exit" -> return
        "remaining" -> {
            cofMash.remaining()
            println("\nWrite action (buy, fill, take, remaining, exit):")
        }
        else -> {
            println("Write action (buy, fill, take, remaining, exit):")

        }
    }
    val optionNew = scanner.nextLine()
    options(optionNew, cofMash)
}

class coffeeMachine(var waterCof: Int,
                    var milkCof: Int, var coffeCof: Int,
                    var cupCof: Int, var moneyCof: Int) {
    var constituents = arrayOf(waterCof, milkCof, coffeCof, cupCof, moneyCof)
    val wordsCof = arrayOf("water", "milk", "coffe", "cup")
    val limit = arrayOf(8000, 700, 1000, 100)

    init {
        println("Hello, I am a coffee machine TM \"Dr.Coffee\".\n " +
                "       <<  Currently present  >>\n" +
                "   - " + constituents[0] + "/8000 milliliters of water\n" +
                "   - " + constituents[1] + "/700 milliliters of milk\n" +
                "   - " + constituents[2] + "/1000 grams of coffee beans\n" +
                "   - " + constituents[3] + "/100 of disposable cups\n" +
                "                               \$\$\$ " + constituents[4] + " of money\n\n" +
                "Write action (buy, fill, take, remaining, exit):")

    }

    fun buy() {
        val coffeeDrinks: Array<Array<Int>> = Array(3, { Array(4, { 0 }) })
        coffeeDrinks[0] = arrayOf(250, 0, 16, 4)
        coffeeDrinks[1] = arrayOf(350, 75, 20, 7)
        coffeeDrinks[2] = arrayOf(200, 100, 12, 6)
        do {
            println("       What do you want to buy?\n" +
                    "           1 - espresso, 2 - latte, 3 - cappuccino" +
                    "           back – to main menu:")
            val optionNew = scanner.nextLine()
            if (optionNew == "1" || optionNew == "2" || optionNew == "3") {
                var flag = 0
                for (i in 0..2) {
                    if (constituents[i] < coffeeDrinks[optionNew.toInt() - 1][i]) {
                        println("The coffee machine is missing " + wordsCof[i])
                        flag = 1
                    }
                }
                if (flag == 1) return
                println("I have enough resources, making you a coffee!")
                for (i in 0..2) {
                    constituents[i] = constituents[i] - coffeeDrinks[optionNew.toInt() - 1][i]
                }
                constituents[1] -= 1
                constituents[4] += coffeeDrinks[optionNew.toInt() - 1][3]
            }
        } while (optionNew != "1" && optionNew != "2" && optionNew != "3" && optionNew != "back")
    }

    fun fill() {
        for (i in 0..3) {
            do {
                var leftovers = limit[i] - constituents[i]
                println("      At the moment, the coffee machine lacks $leftovers milliliters of " + wordsCof[i] + "\n" +
                        "      Write how many ml of " + wordsCof[i] + " you want to add: ")
                val tempConst = scanner.nextInt()
                if (tempConst > leftovers) {
                    println("Oops! You exceeded the amount of allowed " + wordsCof[i])
                } else {
                    constituents[i] += tempConst
                }
            } while (tempConst > leftovers)
        }
    }

    fun take() {
        println("       Now in the coffee machine  \$\$\$ " + constituents[4])
        if (constituents[4] < 1) {
            println("      Oops! Unable to perform operation in the coffee machine no money")
        } else {
            println("       Take the money")
            constituents[4] = 0
        }
    }

    fun remaining() {
        println("       <<  Currently present  >>\n" +
                "   - " + constituents[0] + "/8000 milliliters of water\n" +
                "   - " + constituents[1] + "/700 milliliters of milk\n" +
                "   - " + constituents[2] + "/1000 grams of coffee beans\n" +
                "   - " + constituents[3] + "/100 of disposable cups\n" +
                "                               \$\$\$ " + constituents[4] + " of money")
    }
}

fun main() {
    var water = 400
    var milk = 540
    var coffe = 120
    var cup = 9
    var money = 550

    var cofMash = coffeeMachine(water, milk, coffe, cup, money)
    val nameOption = scanner.nextLine()

    options(nameOption, cofMash)
}

