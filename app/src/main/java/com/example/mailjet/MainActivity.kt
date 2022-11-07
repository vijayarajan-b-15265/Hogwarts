package com.example.mailjet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mailjet.data.geUsersList
import com.example.mailjet.ui.theme.MailJetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MailJetTheme {
                UserProfileList(geUsersList())
            }
        }
    }
}

