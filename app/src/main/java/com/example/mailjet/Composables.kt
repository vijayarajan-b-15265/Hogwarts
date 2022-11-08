package com.example.mailjet


import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.mailjet.data.HogwartsDataHelper
import com.example.mailjet.ui.theme.Shapes


@Composable
fun MailItem(hogwartsDataHelper: HogwartsDataHelper) {

    Card(
        modifier = Modifier
            .background(MaterialTheme.colors.surface, shape = Shapes.medium)
            .clip(RoundedCornerShape(20))
            .fillMaxWidth(),
        elevation = 100.dp
    ) {

        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.primary),
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
                        progress = 0.5F,
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
                Text(text = hogwartsDataHelper.name, color = MaterialTheme.colors.onBackground)
                Text(text = hogwartsDataHelper.house, color = MaterialTheme.colors.onBackground)
                Text(
                    text = hogwartsDataHelper.actor,
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
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(80))
            .padding(0.dp),
        elevation = 100.dp) {
        Text(
            text = text,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(15.dp),
            color = MaterialTheme.colors.onBackground
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.N)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UserProfileList(profileList: List<HogwartsDataHelper> = emptyList(), state: LazyListState) {

    Surface {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Hogwarts",
                            color = MaterialTheme.colors.onBackground,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    },
//                    navigationIcon = {
//                        IconButton(onClick = { }) {
//                            Icon(
//                                imageVector =  ImageVector.vectorResource(id = LocalDrawableResources.current.navigationUp),
//                                contentDescription = "Navigation back")
//                        }
//                    },
//                    backgroundColor = MaterialTheme.colors.primary
                )
            },
            floatingActionButton = {
//                                   Image(
//                                       painter = painterResource(id = LocalDrawableResources.current.fabIcon),
//                                       contentDescription = "Add tag",
//                                       modifier = Modifier.
//                                       padding(bottom = 25.dp, end = 25.dp).
//                                       background(MaterialTheme.colors.onBackground).
//                                       padding(10.dp).
//                                       height(25.dp).
//                                       width(25.dp).
//                                       clickable {})
            },
            bottomBar = {

            },
            content = {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(25.dp),
                    contentPadding = PaddingValues(25.dp),
                    state = state,
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