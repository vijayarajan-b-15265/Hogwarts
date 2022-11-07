package com.example.mailjet


import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.mailjet.data.HogwartsDataHelper
import com.example.mailjet.ui.theme.LocalDrawableResources
import com.example.mailjet.ui.theme.Shapes


@OptIn(ExperimentalGlideComposeApi::class, ExperimentalCoilApi::class)
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
            GlideImage(
                model = hogwartsDataHelper.image,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(height = 100.dp, width = 80.dp),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center
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
                    backgroundColor = MaterialTheme.colors.primary
                )
            },
//            floatingActionButton = {
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
//            },
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