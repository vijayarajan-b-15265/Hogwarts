package com.example.mailjet


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.mailjet.data.HogwartsDataHelper
import com.example.mailjet.ui.theme.Shapes


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
            modifier = Modifier
                .background(MaterialTheme.colors.primary),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = HogwartsDataHelper.yearOfBirth),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .border(1.dp, MaterialTheme.colors.primary)
                    .background(color = MaterialTheme.colors.onBackground)
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

@Composable
fun AlphabetIndexItem(text: String) {
    Text(text = text, modifier = Modifier.padding(start = 10.dp))
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UserProfileList(profileList: List<HogwartsDataHelper> = emptyList()) {

    Surface {

        Scaffold(topBar = {
            TopAppBar(
                modifier = Modifier.background(MaterialTheme.colors.onError),
                title = {
                    Text(
                        text = "Hogwarts",
                        modifier = Modifier.background(MaterialTheme.colors.onError)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Filled.ArrowBack, contentDescription = "Nav back")
                    }
                },
            )
        }, floatingActionButton = {}, bottomBar = {}, content = {

            Row(Modifier.background(MaterialTheme.colors.onPrimary)) {

                LazyColumn {
                    stickyHeader {
                        AlphabetIndexItem("A")
                    }
                    items(profileList) {
                        MailItem(HogwartsDataHelper = it)
                    }
                    stickyHeader {
                        AlphabetIndexItem("B")
                    }
                    items(profileList) {
                        MailItem(HogwartsDataHelper = it)
                    }
                    stickyHeader {
                        AlphabetIndexItem("C")
                    }
                    items(profileList) {
                        MailItem(HogwartsDataHelper = it)
                    }
                }
            }
        })
    }
}