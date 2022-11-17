package com.example.mailjet.utils

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.example.mailjet.model.HogwartsDetailsHelper


@Composable
fun StudentsProfileComposition(hogwartsDataHelper: HogwartsDetailsHelper) {
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

            SubcomposeAsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data(hogwartsDataHelper.image).crossfade(true).build(),
                contentDescription = "Profile Image",
                modifier = Modifier.size(height = 100.dp, width = 80.dp),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center,
                loading = {
                    Log.i("Hogwarts", "Loading Image")
                })

            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Box(modifier = Modifier.padding(end = 20.dp)) {
                    Text(
                        text = hogwartsDataHelper.name,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = "Favourite",
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .height(20.dp)
                            .width(20.dp)
                    )
                }


                Text(
                    text = hogwartsDataHelper.house, color = MaterialTheme.colorScheme.onBackground
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