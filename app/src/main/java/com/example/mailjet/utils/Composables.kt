@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.mailjet.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AddCircle
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mailjet.R
import com.example.mailjet.ui.theme.LocalDrawableResources
import com.example.mailjet.viewmodel.HogwartsState


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun UserProfileList(
    state: HogwartsState, navigationUp: () -> Unit
) {
//    val scrollBehaviour = TopAppBarDefaults.pinnedScrollBehavior()

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.hogwarts)
                        )
                    },
                    navigationIcon = {

                        IconButton(onClick = navigationUp, enabled = true, content = {
                            Image(
                                painter = painterResource(
                                    id = LocalDrawableResources.current.navigationUp
                                ),
                                contentDescription = "Navigation up",
                            )
                        })
                    },
                    actions = {
                        Row {
                            IconButton(onClick = { /* doSomething() */ }) {
                                Icon(
                                    imageVector = Icons.Sharp.Info,
                                    contentDescription = "Localized description"
                                )
                            }
                            IconButton(onClick = { /* doSomething() */ }) {
                                Icon(
                                    imageVector = Icons.Sharp.Notifications,
                                    contentDescription = "Localized description"
                                )
                            }
                            IconButton(onClick = { /* doSomething() */ }) {
                                Icon(
                                    imageVector = Icons.Sharp.Settings,
                                    contentDescription = "Localized description"
                                )
                            }
                        }

                    },
//                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.background)
                )
            },
            floatingActionButton = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Sharp.AddCircle, contentDescription = "Add Item")
                }
            },
            content = { innerPadding ->

                Box {

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        contentPadding = PaddingValues(20.dp),
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .padding(
                                top = innerPadding.calculateTopPadding(),
                                bottom = innerPadding.calculateBottomPadding()
                            )
                    ) {
                        val groupList = state.studentsDetailsList.filter { it.house.isNotEmpty() }
                            .groupBy { it.house }

                        groupList.forEach { (houseName, dataList) ->
                            stickyHeader {
                                AlphabetIndexItem(text = houseName)
                            }
                            items(dataList) { hogwartsHelper ->
                                StudentsProfileComposition(hogwartsDataHelper = hogwartsHelper)
                            }
                        }
                    }

                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.inverseSurface,
                        modifier = Modifier.align(
                            Alignment.Center
                        ),
                        strokeWidth = 3.dp,
                    )
                }


            })
    }
}