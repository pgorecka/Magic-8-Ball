package com.example.magic8ball

import android.content.Intent
import android.media.MediaPlayer.create
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
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

            sendEmail()

            playSound()


        }

        private fun sendEmail() {
            val sendBtn = findPreference<Preference>("feedback")

            sendBtn?.setOnPreferenceClickListener {

                val emailIntent = Intent(
                    Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "p.gorecka@zoho.com", null
                    )
                )
                emailIntent.putExtra(
                    Intent.EXTRA_SUBJECT,
                    context?.getString(R.string.label_subject_email)
                )
                startActivity(
                    Intent.createChooser(
                        emailIntent,
                        context?.getString(R.string.label_send_email)
                    )
                )
                true
            }
        }


        fun playSound() {
            val musicSwitch = findPreference<Preference>("sound")
            val mediaPlayer = create(context, R.raw.music)
            musicSwitch?.setOnPreferenceChangeListener { preference, newValue ->
                mediaPlayer.start()
                println("hello there")
                true
            }


        }

    }
}
      /*  // 2. Pause playback
        fun pauseSound(view: View) {
            if (mMediaPlayer != null && mMediaPlayer!!.isPlaying) mMediaPlayer!!.pause()
        }

        // 3. {optional} Stops playback
        fun stopSound(view: View) {
            if (mMediaPlayer != null) {
                mMediaPlayer!!.stop()
                mMediaPlayer!!.release()
                mMediaPlayer = null
            }
        }

        // 4. Closes the MediaPlayer when the app is closed
        override fun onStop() {
            super.onStop()
            if (mMediaPlayer != null) {
                mMediaPlayer!!.release()
                mMediaPlayer = null
            }
        }
    }


}
    // 1. Plays the water sound  val sendBtn = findPreference<Preference>("feedback")
*/