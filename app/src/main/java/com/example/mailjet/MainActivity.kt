package com.example.mailjet

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.mailjet.data.HogwartsDataHelper
import com.example.mailjet.data.geUsersList
import com.example.mailjet.ui.theme.MailJetTheme
import com.example.mailjet.ui.theme.Shapes

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

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun Pre() {
    Row(Modifier.background(MaterialTheme.colors.primary)) {
        MailItem(
            HogwartsDataHelper = HogwartsDataHelper(
                name = "Harry Potter",
                house = "Gryffindor",
                actor = "Daniel Radcliffe",
                yearOfBirth = R.drawable.hogwarts_logo
            )
        )
    }
}

@Composable
fun MailItem(HogwartsDataHelper: HogwartsDataHelper) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary, shape = Shapes.medium)
            .border(20.dp, MaterialTheme.colors.primary),
        elevation = 30.dp
    ) {

        Row(
//                modifier = Modifier
//                    .background(MaterialTheme.colors.primary)
//                ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = HogwartsDataHelper.yearOfBirth),
                contentDescription = "Profile Image",
                modifier = Modifier
//                        .border(1.dp, MaterialTheme.colors.primary)
//                        .background(color = MaterialTheme.colors.onBackground)
                    .size(100.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(text = HogwartsDataHelper.name, color = MaterialTheme.colors.onBackground)
                Text(text = HogwartsDataHelper.house, color = MaterialTheme.colors.onBackground)
                Text(
                    text = HogwartsDataHelper.actor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }


    }
}

//}

@Composable
fun UserProfileList(profileList: List<HogwartsDataHelper>) {
    Car
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Hogwarts") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Nav back")
                }
            },
        )
    }, floatingActionButton = {}, bottomBar = {}, content = {

        Row(Modifier.background(MaterialTheme.colors.onPrimary)) {
            LazyGridScope {
                profileList.forEach {
                    item {
                        MailItem(HogwartsDataHelper = it)
                    }
                }
            }
        }
    })
}
