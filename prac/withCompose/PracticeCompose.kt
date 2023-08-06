package com.example.practicecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecompose.ui.theme.PracticeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //ComposeTutorial("Android")
                    //TickScreen()
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun ComposeTutorial(name: String, modifier: Modifier = Modifier) {
    val img = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = img,
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = stringResource(R.string.heading_tutorial),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp),
        )
        Text(
            text = stringResource(R.string.text_body),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        )
        Text(
            text = stringResource(R.string.text_body2),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp),
        )
    }
}

@Composable
fun TickScreen(modifier: Modifier = Modifier) {
    val img = painterResource(id = R.drawable.ic_task_completed)
    Box(contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = img,
                contentDescription = null,
            )
            Text(
                text = "All Tasks Completed",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = "Nice Work!",
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun Quadrant(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Center) {
            Row(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxSize()
            ) {
                Box (modifier = Modifier
                    .background(color = Color(0xFFEADDFF))
                    .weight(1F)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Text Composable",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "Displays text and follows the recommended Material Design guidelines.",
                            textAlign = TextAlign.Justify
                        )
                    }
                }
                Box (modifier = Modifier
                    .background(color = Color(0xFFD0BCFF))
                    .weight(1F)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Text Composable",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "Displays text and follows the recommended Material Design guidelines.",
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .weight(1F)
                    .fillMaxSize()
            ) {
                Box (modifier = Modifier
                    .background(color = Color(0xFFB69DF8))
                    .weight(1F)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Text Composable",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "Displays text and follows the recommended Material Design guidelines.",
                            textAlign = TextAlign.Justify
                        )
                    }
                }
                Box (modifier = Modifier
                    .background(color = Color(0xFFF6EDFF))
                    .weight(1F)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Text Composable",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "Displays text and follows the recommended Material Design guidelines.",
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PracticeComposeTheme {
        Quadrant()
    }
}