package com.example.mailjet

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.mailjet.data.HogwartsDataHelper
import com.example.mailjet.ui.theme.LocalDrawableResources


@Composable
fun MailItem(hogwartsDataHelper: HogwartsDataHelper) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {

        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(hogwartsDataHelper.image)
                    .crossfade(true).build(),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(height = 100.dp, width = 80.dp),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center,
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .height(5.dp)
                            .width(5.dp)
                    )
                }
            )
            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(text = hogwartsDataHelper.name, color = MaterialTheme.colorScheme.onBackground)
                Text(
                    text = hogwartsDataHelper.house,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = hogwartsDataHelper.actor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }


    }
}

@Composable
fun AlphabetIndexItem(text: String) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(25))
            .background(MaterialTheme.colorScheme.primary)
            .padding(10.dp),
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .width(100.dp)
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun UserProfileList(
    profileList: List<HogwartsDataHelper> = emptyList(),
    state: LazyListState,
    navigationUp: () -> Unit
) {

    Surface {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(
                        text = stringResource(R.string.hogwarts),
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.background(MaterialTheme.colorScheme.primary)
                        //                            modifier = MaterialTheme.colorScheme.primary
                    )
                },
                    modifier = Modifier.background(MaterialTheme.colorScheme.primary),
                    navigationIcon = {
                        IconButton(
                            onClick = navigationUp, enabled = true, content = {
                                Image(
                                    painter = painterResource(
                                        id = LocalDrawableResources.current.navigationUp
                                    ),
                                    contentDescription = "Navigation up",
                                    modifier = Modifier.background(MaterialTheme.colorScheme.primary)


                                )
                            })
                    })
            },
            floatingActionButton = {
                Image(
                    painter = painterResource(id = LocalDrawableResources.current.fabIcon),
                    contentDescription = "Add tag",
                    modifier = Modifier
                        .padding(bottom = 5.dp, end = 5.dp)
                        .background(Color.Blue)
                        .padding(1.dp)
                        .height(1.dp)
                        .width(1.dp)
                        .clickable {},
                )
            },
            content = {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(20.dp),
                    state = state,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(top = 70.dp)
                ) {

                    val groupList = profileList.groupBy { it.house }

                    groupList.forEach { (houseName, dataList) ->
                        stickyHeader {
                            AlphabetIndexItem(text = houseName)
                        }
                        items(dataList) { hogwartsHelper ->
                            MailItem(hogwartsDataHelper = hogwartsHelper)
                        }
                    }
                }
            }
        )
    }
}