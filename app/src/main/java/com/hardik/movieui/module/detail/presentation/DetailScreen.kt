package com.hardik.movieui.module.detail.presentation

import android.provider.MediaStore.Audio.Genres
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hardik.movieui.R
import com.hardik.movieui.core.route.AppRoutName
import com.hardik.movieui.module.home.model.MovieModel
import com.hardik.movieui.ui.theme.Gray
import com.hardik.movieui.ui.theme.Yellow

@Composable
fun DetailScreen(navController: NavController, movie: MovieModel) {
    val scrollState = rememberScrollState()

    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            Button(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Yellow,
//                    contentColor = Gray
                ),
                shape = RoundedCornerShape(32.dp), onClick = {
                    navController.navigate("${AppRoutName.SeatSelector}")
                }) {
                Text(text = "Booking Now")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(vertical = 24.dp)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Button",
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Movie Details", style = MaterialTheme.typography.h6)
            }
            Row(
                modifier = Modifier
                    .height(320.dp)
                    .padding(horizontal = 24.dp)
            ) {
                Image(
                    painter = painterResource(id = movie.assetImage),
                    contentDescription = "Movie Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .weight(0.7f)
                        .height(320.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.width(24.dp))
                Column(
                    modifier = Modifier
                        .height(320.dp)
                        .weight(0.3f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    MovieInfo(
                        painterResourceId = R.drawable.baseline_videocam_24,
                        title = "Genre",
                        value = movie.type
                    )
                    MovieInfo(
                        painterResourceId = R.drawable.baseline_access_time_filled_24,
                        title = "Duration",
                        value = movie.duration
                    )
                    MovieInfo(
                        painterResourceId = R.drawable.baseline_stars_24,
                        title = "Rating",
                        value = movie.rating
                    )
                }
            }
            Text(
                text = movie.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
            )
            Text(
                text = "Synopsis",
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Text(
                text = movie.synopsis,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
            )
            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}

@Composable
fun MovieInfo(
    @DrawableRes painterResourceId: Int,
    title: String,
    value: String,
) {
    Column(
        modifier = Modifier
            .border(width = 1.dp, color = Gray, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable { }
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = painterResourceId),
            contentDescription = title
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = title, style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = value, style = MaterialTheme.typography.subtitle1)
    }
}