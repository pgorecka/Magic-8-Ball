package com.example.magic8ball

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


//Allows the user to shake the ball and view the result on the screen
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

       // setTheme(R.style.Theme_Magic8Ball_Bg_1);
        setContentView(R.layout.activity_main)

        toggleDesign()

        val shakeButton: Button = findViewById(R.id.button)
        shakeButton.setOnClickListener {
            shakeMagicBall()
        }
    }





    @SuppressLint("NewApi")
    private fun toggleDesign() {
        val toggleBtn: Switch = this.findViewById(R.id.switch1)
        val ball: ImageView = this.findViewById(R.id.imageView2)
        val text: TextView = this.findViewById(R.id.textView)
        val askBtn: Button = this.findViewById(R.id.button)

       // var appBackground:
        //val bg = toggleBackground()
        toggleBtn.setOnCheckedChangeListener { _, isChecked ->
           //  if (isChecked) toggle.background = this.getDrawable(R.drawable.bg2)
            if (isChecked) {
              //  setTheme(Theme_Magic8Ball_Bg_2)
               // setTheme(R.style.Theme_Magic8Ball_Bg_2);
                ball.setImageResource(R.drawable.magic_ball_2)
                text.setTextColor(Color.parseColor("#000034"))
                askBtn.backgroundTintList = ColorStateList.valueOf(Color.rgb(158, 121, 129))

             //   recreate()

                println("pressed")
            }//AppCompatDelegate.MODE_NIGHT_NO//setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)  //toggle.background = getDrawable(R.drawable.bg2)
            else {
                ball.setImageResource(R.drawable.magic_ball)
                text.setTextColor(Color.parseColor("#FFFFFFFF"))
                askBtn.backgroundTintList = ColorStateList.valueOf(Color.rgb(0, 24, 58))
            }



                //setTheme(R.style.Theme_Magic8Ball_Bg_1)//AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)//toggle.setBackgroundResource(R.drawable.bg1)
            //ConstraintLayout
        }
    }

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
        //Create new ball object with 20 possible answers and shakes it
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
