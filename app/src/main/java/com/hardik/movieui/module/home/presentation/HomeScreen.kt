package com.hardik.movieui.module.home.presentation

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import com.hardik.movieui.R
import com.hardik.movieui.core.route.AppRoutName
import com.hardik.movieui.module.home.model.MovieModel
import com.hardik.movieui.module.home.model.nowPlayingMovie
import com.hardik.movieui.module.home.model.upcomingMovie
import com.hardik.movieui.ui.theme.BlueVariant
import com.hardik.movieui.ui.theme.Gray
import com.hardik.movieui.ui.theme.Yellow
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(
                    top = padding.calculateTopPadding() + 24.dp,
                    bottom = padding.calculateBottomPadding() + 24.dp
                )
        ) {
            Text(
                text = "Welcome back, Hardik!",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Book your Favorite Movie Here!",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Banners()
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "Category",
                    style = MaterialTheme.typography.titleLarge,
                )
                TextButton(onClick = {}) {
                    Text(
                        text = "See More",
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Categories()
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "Now Playing Movie",
                    style = MaterialTheme.typography.titleLarge,
                )
                TextButton(onClick = {}) {
                    Text(
                        text = "See More",
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            NowPlayingMovie { movie ->
                navController.navigate("${AppRoutName.Detail}/${movie.id}")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "Upcoming Movie",
                    style = MaterialTheme.typography.titleLarge,
                )
                TextButton(onClick = {}) {
                    Text(
                        text = "See More",
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            UpcomingMovie { movie ->
                navController.navigate("${AppRoutName.Detail}/${movie.id}")
            }

        }

    }
}

@Composable
fun UpcomingMovie(onMovieClicked: (MovieModel) -> Unit) {
    LazyRow(contentPadding = PaddingValues(start = 24.dp)) {
        items(count = upcomingMovie.size) { index ->
            Box(
                modifier = Modifier
                    .padding(end = 24.dp)
                    .clickable { },
            ) {
                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = upcomingMovie[index].assetImage),
                        contentDescription = "Movie Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size(width = 200.dp, height = 260.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = upcomingMovie[index].title,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NowPlayingMovie(onMovieClicked: (MovieModel) -> Unit) {
    val pagerState = rememberPagerState(pageCount = { nowPlayingMovie.size })
    var pageItem = remember {
        mutableStateOf(0)
    }
    HorizontalPager(
        state = pagerState,
        outOfBoundsPageCount = nowPlayingMovie.size,
        contentPadding = PaddingValues(start = 48.dp, end = 48.dp)
    ) { page ->
        pageItem.value = page
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .graphicsLayer {
//                    val pageOffset = pagerState.currentPageOffsetFraction.absoluteValue
                    val pageOffset = pagerState.getOffsetFractionForPage(page).absoluteValue
                    lerp(
                        start = ScaleFactor(1f, 0.85f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale.scaleX
                        scaleY = scale.scaleY
                    }
                }
                .clickable {
                    onMovieClicked(nowPlayingMovie[page])
                },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier.clip(RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = nowPlayingMovie[page].assetImage),
                    contentDescription = "Movie Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.85f)
                        .height(340.dp),
                )
                Box(
                    modifier = Modifier
                        .graphicsLayer {
                            val pageOffset = pagerState.getOffsetFractionForPage(page).absoluteValue
                            val transition = pageOffset.coerceIn(0f, 1f)
                            translationY = transition * 200
                        }
                        .fillMaxWidth(fraction = 0.85f)
                        .wrapContentHeight()
                        .background(
                            BlueVariant
                        )
                        .padding(vertical = 16.dp), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Buy Ticket", style = MaterialTheme.typography.bodySmall.copy(
                            color = Yellow, fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = nowPlayingMovie[page].title,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}

@Composable
fun Categories() {
    val categories = listOf(
        "Animation",
        "Horror",
        "Action",
        "Comedy",
        "Romance",
        "Sci-fi",
        "Documentary",
        "Drama",
        "Family",
        "History",
        "Adventure",
        "Musical",
        "Thriller",
        "War",
        "Western"
    )

    val scrollState = rememberScrollState()
    Row(modifier = Modifier.horizontalScroll(scrollState)) {
        repeat(categories.size) { index ->
            Surface(
                /// oder matters
                modifier = Modifier
                    .padding(start = if (index == 0) 24.dp else 0.dp, end = 12.dp)
                    .border(width = 1.dp, color = Gray, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { }
                    .padding(12.dp)) {
                Text(text = categories[index], style = MaterialTheme.typography.labelSmall)
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Banners() {
    val banners = listOf(
        R.drawable.banner_1,
        R.drawable.banner_2,
        R.drawable.banner_3,
    )

    val pagerState = rememberPagerState(pageCount = { banners.size })
    val bannerIndex = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            bannerIndex.value = page
        }
    }

    /// auto scroll
    LaunchedEffect(key1 = Unit) {
        while (true) {
            delay(2_000)
            tween<Float>(1000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % pagerState.pageCount
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
            .padding(horizontal = 24.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            outOfBoundsPageCount = banners.size,
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp),
        ) { index ->
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painterResource(id = banners[index]),
                contentDescription = "Banners",
                contentScale = ContentScale.FillBounds
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            repeat(banners.size) { index ->
                val height = 12.dp
                val width = if (index == bannerIndex.value) 28.dp else 12.dp
                val color = if (index == bannerIndex.value) Yellow else Gray

                Surface(
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(width = width, height = height)
                        .clip(
                            RoundedCornerShape(20.dp)
                        ),
                    color = color,
                ) {}
            }

        }
    }
}