package com.example.lemonadecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadecompose.ui.theme.LemonadeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonScreen()
                }
            }
        }
    }
}

@Composable
fun LemonScreen(modifier: Modifier = Modifier) {
    var img by remember { mutableStateOf(R.drawable.lemon_tree) }
    val desc = stringResource(
        when (img) {
            R.drawable.lemon_tree -> R.string.lemon1
            R.drawable.lemon_squeeze -> R.string.lemon2
            R.drawable.lemon_drink -> R.string.lemon3
            else -> R.string.lemon4
        }
    )
    var taps by remember { mutableStateOf(0) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                //if squeeze lower taps only if taps 0
                if (taps > 0) {
                    taps--
                } else {
                    // Proceed to change picture
                    img = when (img) {
                        R.drawable.lemon_tree -> R.drawable.lemon_squeeze
                        R.drawable.lemon_restart -> R.drawable.lemon_tree
                        R.drawable.lemon_squeeze -> R.drawable.lemon_drink
                        else -> R.drawable.lemon_restart
                    }
                    if (img == R.drawable.lemon_squeeze) {
                        taps = (4..10).random()

                    }
                }
            },
            shape = RoundedCornerShape(10),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            )
        ) {
            Image(painter = painterResource(img), contentDescription = desc)
        }
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Text(text = desc, fontSize = 18.sp)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LemonadeComposeTheme {
        LemonScreen()
    }
}