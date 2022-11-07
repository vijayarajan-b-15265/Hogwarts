package com.example.mailjet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import com.example.mailjet.data.getUsersList
import com.example.mailjet.ui.theme.MailJetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = rememberLazyListState()

            val showScrollToTop = remember {
                derivedStateOf {
                    state.firstVisibleItemIndex > 0
                }
            }

            MailJetTheme {
                UserProfileList(profileList = getUsersList(), state = state)
            }
        }
    }
}

