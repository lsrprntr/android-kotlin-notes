package com.example.photosappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photosappcompose.ui.theme.PhotosAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotosAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

class AlbumAndDesc(img: Int, words: String)


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    var img by remember { mutableStateOf(R.drawable.beatles_abby_road) }
    val desc: String = when (img) {
        R.drawable.beatles_abby_road -> stringResource(R.string.beatles)
        R.drawable.led_zeppelin -> stringResource(R.string.led_zeppelin)
        R.drawable.pink_floyd -> stringResource(R.string.pink_floyd)
        R.drawable.joy_division -> stringResource(R.string.joy_division)
        R.drawable.lady_gaga -> stringResource(R.string.lady_gaga)
        R.drawable.fleetwood_mac -> stringResource(R.string.fleetwood_mac)
        R.drawable.blink_182 -> stringResource(R.string.blink182)
        else -> stringResource(R.string.outkast)
    }
    //Main column
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // Picture row top
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .weight(3f, fill = true)
        ) {
            Surface(
                shadowElevation = 4.dp,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.padding(16.dp),
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = desc,
                    modifier = modifier
                        .fillMaxHeight()
                        .padding(12.dp)
                )
            }
        }
        // Album desc middle bottom
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .weight(2f)
        ) {
            Surface(
                shadowElevation = 4.dp,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(12.dp),
            ) {
                Text(
                    text = desc,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 36.sp,
                    lineHeight = 36.sp,
                    modifier = Modifier
                        .padding(24.dp)
                )
            }
        }
        // Buttons bottom middle
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)
        ) {
            Button(
                onClick = {
                          img = when (img) {
                              R.drawable.outkast -> R.drawable.blink_182
                              R.drawable.blink_182 -> R.drawable.fleetwood_mac
                              R.drawable.fleetwood_mac -> R.drawable.lady_gaga
                              R.drawable.lady_gaga -> R.drawable.joy_division
                              R.drawable.joy_division -> R.drawable.pink_floyd
                              R.drawable.pink_floyd -> R.drawable.led_zeppelin
                              else -> R.drawable.beatles_abby_road
                          }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Previous",
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 14.sp
                )
            }
            Button(
                onClick = {
                    img = when (img) {
                        R.drawable.beatles_abby_road -> R.drawable.led_zeppelin
                        R.drawable.led_zeppelin -> R.drawable.pink_floyd
                        R.drawable.pink_floyd -> R.drawable.joy_division
                        R.drawable.joy_division -> R.drawable.lady_gaga
                        R.drawable.lady_gaga -> R.drawable.fleetwood_mac
                        R.drawable.fleetwood_mac -> R.drawable.blink_182
                        else -> R.drawable.outkast
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Next",
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 14.sp,
                )
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
fun GreetingPreview() {
    PhotosAppComposeTheme {
        MainScreen()
    }
}