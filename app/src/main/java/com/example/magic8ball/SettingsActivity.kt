package com.example.magic8ball

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }

}
   /* fun sendEmail(View: View) {
        val sendBtn : Preference = findViewById(R.id.send_feedback)
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, "Hey Check out this Great app:")
        intent.type = "text/plain"

        sendBtn.setOnPreferenceClickListener {
            startActivity(intent,"ytr")
        }

           // val intent = Intent()
           // intent.action = Intent.ACTION_SEND
           // intent.data = Uri.parse("mailto:p.gorecka@zoho.com") // only email apps should handle this
          //  intent.putExtra(Intent.EXTRA_EMAIL, emailArrray)
          // intent.putExtra(Intent.EXTRA_SUBJECT, "Inquire about travel agent")

          //  startActivity(Intent.createChooser(intent, "Share To:"))

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




fun sendEmail(View: View) {
        val sendBtn = findViewById<Button>(R.id.send_feedback)
        sendBtn.setOnClickListener{
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("p.gorecka@zoho.com")
            }
            startActivity(emailIntent)

        }
    }*/

