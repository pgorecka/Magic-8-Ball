package com.example.magic8ball

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//Allows the user to shake the ball and view the result on the screen
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shakeButton: Button = findViewById(R.id.button)
        shakeButton.setOnClickListener {
            shakeMagicBall()
        }

        val backgroundSwitch: Switch = findViewById(R.id.switch1)
        backgroundSwitch.setOnClickListener {
            backgroundSwitch.run { setBackgroundResource(R.drawable.bg2) }

        }

    }

/*
    fun changeBackground() {
        val backgroundSwitch: Button = findViewById(R.id.switch1)
        backgroundSwitch.setOnClickListener {
            backgroundSwitch.setBackgroundDrawable(R.drawable.bg2)
        }

    }*/

    fun shakeToClick() {
        val shakeButton: Button = findViewById(R.id.button)
        shakeButton.setOnClickListener {
            shakeMagicBall()
        }
    }


    //Vibrates phone on click
    private fun vibratePhone() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            // vibrator.vibrate(200)
            vibrator.run { 200 }
        }
    }

    //Shakes the ball and updates the screen with the result
    private fun shakeMagicBall() {
        //Create new ball object with 20 possibilities and shakes it
        val ball = MagicBall(20)
        val say = ball.answer()
        vibratePhone()

//Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
// resultTextView.text = diceRoll.toString()
        resultTextView.text = say
    }

    class MagicBall(private val options: Int) {
        private fun shake(): Int {
            return (1..options).random()
        }

        fun answer(): String {
            val prophecy: String
            when (shake()) {
                1 -> prophecy = "As I see it, yes."
                2 -> prophecy = "Ask again later."
                3 -> prophecy = "Better\n not tell you\n now."
                4 -> prophecy = "Cannot predict \nnow."
                5 -> prophecy = "Concentrate \nand ask \nagain."
                6 -> prophecy = "Don’t count on it."
                7 -> prophecy = "It is certain."
                8 -> prophecy = "It is decidedly so."
                9 -> prophecy = "Most likely."
                10 -> prophecy = "My reply is no."
                11 -> prophecy = "My sources\n say no."
                12 -> prophecy = "Outlook\n not so good."
                13 -> prophecy = "Outlook good."
                14 -> prophecy = "Reply hazy\n try again."
                15 -> prophecy = "Signs point to yes."
                16 -> prophecy = "Very doubtful."
                17 -> prophecy = "Without a doubt."
                18 -> prophecy = "Yes."
                19 -> prophecy = "Yes – definitely."
                20 -> prophecy = "You may rely on it."
                else -> prophecy = "Error"
            }
            return prophecy
        }
    }

    fun shareIntent(view: View) {
        val shareBtn = findViewById<Button>(R.id.shareButton)
        shareBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Hey Check out this Great app:")
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }
}

   /* private fun setBackgroundDrawable() {
        val backgroundSwitch: Switch = findViewById(R.id.switch1)
        backgroundSwitch.setBackgroundResource(R.drawable.bg2);
    }
        val go = setBackgroundDrawable() */


