package com.example.mailjet

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.mailjet.ui.theme.MailJetTheme
import com.example.mailjet.utils.UserProfileList
import com.example.mailjet.viewmodel.HogwartsStateViewModel

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val hogwartsStateViewModel: HogwartsStateViewModel by viewModels()
        setContent {
            Surface(modifier = Modifier.fillMaxWidth()) {
                MailJetTheme {
                    UserProfileList(
                        state = hogwartsStateViewModel.hogwartsDetailsList.value,
                        navigationUp = {
                            finish()
                        })

                }
                LaunchedEffect(key1 = Unit, block = {
                    hogwartsStateViewModel.getHogwartsDetail()
                })
            }
        }
    }
}

