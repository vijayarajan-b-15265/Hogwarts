package com.example.mailjet


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.mailjet.data.HogwartsDataHelper
import com.example.mailjet.ui.theme.AppbarColor
import com.example.mailjet.ui.theme.LocalDrawableResources
import com.example.mailjet.ui.theme.Shapes


@Composable
fun MailItem(HogwartsDataHelper: HogwartsDataHelper ) {

    Card(
        modifier = Modifier
            .background(MaterialTheme.colors.surface, shape = Shapes.medium)
            .padding(top = 10.dp) ,
        elevation = 10.dp
    ) {

        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.primary),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {


            Image(
                painter = painterResource(id = HogwartsDataHelper.yearOfBirth),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .border(1.dp, MaterialTheme.colors.primary)
                    .background(color = Color.Black)
                    .size(100.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxWidth()
                ,verticalArrangement = Arrangement.SpaceEvenly,
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

@Composable
fun AlphabetIndexItem(text: String) {
    Text(text = text,
        textAlign = TextAlign.Left,
        modifier = Modifier
            .padding(start = 10.dp)
            .background(MaterialTheme.colors.onPrimary)
            .height(100.dp),
        color = MaterialTheme.colors.onBackground
    )
}

@Composable
fun UserProfileList(profileList: List<HogwartsDataHelper> = emptyList()) {

    Surface {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Hogwarts", color = MaterialTheme.colors.onBackground
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector =  ImageVector.vectorResource(id = LocalDrawableResources.current.navigationUp),
                                contentDescription = "Nav back")
                        }
                    }, backgroundColor = AppbarColor
                )
            },
            floatingActionButton = {

            },
            bottomBar = {

            },
            content = {

                LazyColumn (verticalArrangement = Arrangement.spacedBy(10.dp), contentPadding = PaddingValues(20.dp)) {

                    items(profileList) {
                        MailItem(HogwartsDataHelper = it)
                    }

                    items(profileList) {
                        MailItem(HogwartsDataHelper = it)
                    }

                    items(profileList) {
                        MailItem(HogwartsDataHelper = it)
                    }
                }
            }
        )
    }
}