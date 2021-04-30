package com.example.magic8ball

import android.content.Intent
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
    }
}
