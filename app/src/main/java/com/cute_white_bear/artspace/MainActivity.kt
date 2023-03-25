package com.cute_white_bear.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cute_white_bear.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceUI()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArtSpaceUI() {
    var art by remember { mutableStateOf(artList[0].image) }
    var title by remember { mutableStateOf(artList[0].title) }
    var author by remember { mutableStateOf(artList[0].author) }
    var id by remember { mutableStateOf(artList[0].id) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ArtImage(art)
        Spacer(modifier = Modifier.height(32.dp))
        ArtAuthorAndTitle(
            title = title,
            author = author,
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            NavigationButton(title = R.string.previous_button, {
                when (id) {
                    2 -> {
                        art = artList[0].image
                        title = artList[0].title
                        author = artList[0].author
                        id = artList[0].id
                    }
                    3 -> {
                        art = artList[1].image
                        title = artList[1].title
                        author = artList[1].author
                        id = artList[1].id
                    }
                    4 -> {
                        art = artList[2].image
                        title = artList[2].title
                        author = artList[2].author
                        id = artList[2].id
                    }
                    5 -> {
                        art = artList[3].image
                        title = artList[3].title
                        author = artList[3].author
                        id = artList[3].id
                    }
                    6 -> {
                        art = artList[4].image
                        title = artList[4].title
                        author = artList[4].author
                        id = artList[4].id
                    }
                }
            })
            NavigationButton(title = R.string.next_button, {
                when (id) {
                    1 -> {
                        art = artList[1].image
                        title = artList[1].title
                        author = artList[1].author
                        id = artList[1].id
                    }
                    2 -> {
                        art = artList[2].image
                        title = artList[2].title
                        author = artList[2].author
                        id = artList[2].id
                    }
                    3 -> {
                        art = artList[3].image
                        title = artList[3].title
                        author = artList[3].author
                        id = artList[3].id
                    }
                    4 -> {
                        art = artList[4].image
                        title = artList[4].title
                        author = artList[4].author
                        id = artList[4].id
                    }
                    5 -> {
                        art = artList[5].image
                        title = artList[5].title
                        author = artList[5].author
                        id = artList[5].id
                    }
                    6 -> {
                        art = artList[0].image
                        title = artList[0].title
                        author = artList[0].author
                        id = artList[0].id
                    }
                }
            })
        }
    }
}

@Composable
fun ArtImage(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier,
) {
    Surface(
        border = BorderStroke(2.dp, Color.Black),
        elevation = 30.dp,
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = modifier
                .padding(32.dp),
        )
    }
}

@Composable
fun ArtAuthorAndTitle(
    @StringRes title: Int,
    @StringRes author: Int,
    modifier: Modifier = Modifier
) {
    Surface(elevation = 10.dp) {
        Column(modifier = modifier.padding(16.dp)) {
            Text(
                text = stringResource(title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 30.sp,
            )
            Text(
                text = stringResource(author),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            )
        }
    }
}

@Composable
fun NavigationButton(
    @StringRes title: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.width(140.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFC3423F),
            contentColor = Color.White,
        ),
        shape = RoundedCornerShape(4.dp),
    ) {
        Text(
            text = stringResource(title),
        )
    }
}

