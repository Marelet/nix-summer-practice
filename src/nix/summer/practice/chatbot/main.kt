package nix.summer.practice.chatbot

val scanner = java.util.Scanner(System.`in`)

fun checkingAnswers(questionNumber: Int, answer: String, questoinText: String) {
    val answerAllQuestion = arrayOf("1/4", "2/5", "3/4")
    if (answerAllQuestion[questionNumber - 1] == answer) {
        println("Great, you right!")
        if (answer != answerAllQuestion.last()) println("Next question =>")

    } else {
        println("Please, try again\n $questoinText")
        val temp = "$questionNumber/" + scanner.nextInt()
        checkingAnswers(questionNumber, temp, questoinText)
    }

}

fun main() {

    val name = "Mars"
    val yearCreate = "07.07.2022"

    val questoin1 = "QUESTION 1: What is Kotlin built on?\n" +
            "   1 - Based on the Intellij IDEA\n" +
            "   2 - Based on the Python\n" +
            "   3 - Based on the C++\n" +
            "   4 - Based on the Java Virtual Machine\n" +
            "   5 - Based on the Android Studio"
    val questoin2 = "QUESTION 2: What data type does not exist in Kotlin?\n" +
            "   1 - Int\n" +
            "   2 - List\n" +
            "   3 - Array\n" +
            "   4 - Object\n" +
            "   5 - All listed data types exist"
    val questoin3 = "QUESTION 3: What is the difference between var and val?\n" +
            "   1 - There are no differences between them\n" +
            "   2 - val - allows you to set and change the value, var - allows you to set the value without changing it further\n" +
            "   3 - val serves to create arrays, var to create variablesn\n" +
            "   4 - var - allows you to set and change the value, val - allows you to set the value without changing it in the future"


    println("Hello! My name is $name.\n" +
            "I was created in $yearCreate\n" +
            "Please, remind me your name.")

    val nameUser = scanner.nextLine()

    println("What a great name you have,$nameUser\n" +
            "Let me guess your age.\n" +
            "Enter remainders of dividing your age by 3, 5 and 7.")

    val remainder3 = scanner.nextInt()
    val remainder5 = scanner.nextInt()
    val remainder7 = scanner.nextInt()
    val ageUser = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105

    println("Your age is $ageUser; that's a good time to start programming!\n" +
            "I will prove to you that I can count to any number you want:")

    val numberToCount = scanner.nextInt()

    for (i in 1..numberToCount) {
        println("$i!")
    }

    println("           Now let's take the test\n" +
            "Choose the correct answer and enter its number\n" +
            "                   LET'S GO\n" +
            "$questoin1")

    var answer = "1/" + scanner.nextInt()

    checkingAnswers(1, answer, questoin1)
    println(questoin2)
    answer = "2/" + scanner.nextInt()
    checkingAnswers(2, answer, questoin2)
    println(questoin3)
    answer = "3/" + scanner.nextInt()
    checkingAnswers(3, answer, questoin3)
    println("Wow you passed the test\n" +
            "Goodbye, have a nice day!")
}