package com.example.magic8ball

// Returns random response
class MagicBall(private val options: Int) {
    private fun shake(): Int {
        return (1..options).random()
    }

    fun answer(): String {
        return when (shake()) {
            1 -> "As I see it, yes."
            2 -> "Ask again later."
            3 -> "Better\n not tell you\n now."
            4 -> "Cannot predict \nnow."
            5 -> "Concentrate \nand ask \nagain."
            6 -> "Don’t count on it."
            7 -> "It is certain."
            8 -> "It is decidedly so."
            9 -> "Most likely."
            10 -> "My reply is no."
            11 -> "My sources\n say no."
            12 -> "Outlook\n not so good."
            13 -> "Outlook good."
            14 -> "Reply hazy\n try again."
            15 -> "Signs point to yes."
            16 -> "Very doubtful."
            17 -> "Without a doubt."
            18 -> "Yes."
            19 -> "Yes – definitely."
            20 -> "You may rely on it."
            else -> "Error"
        }
    }
}