package com.example.mailjet

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.rememberLazyListState
import com.example.mailjet.data.getUsersList
import com.example.mailjet.ui.theme.MailJetTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = rememberLazyListState()

            MailJetTheme {
                UserProfileList(
                    profileList = getUsersList(),
                    state = state,
                    navigationUp = {
                        Toast.makeText(this, "Back clicked", Toast.LENGTH_SHORT).show()
                    })
            }
        }
    }
}

