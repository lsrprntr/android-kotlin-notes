package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        name = "Android",
                        email = "blah@gmail.com",
                        phone = "+61 123 123 123",
                        handle = "@tweet.com"
                        )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    email: String,
    phone: String,
    handle: String,
    modifier: Modifier = Modifier
) {
    Column (verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()){
        Row (modifier = Modifier.weight(1F)){
        }
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1F)){
            val img = painterResource(id = R.drawable.dp_dp)
            Image(painter = img, contentDescription = "Profile Picture",
                modifier = Modifier.size(200.dp))
            Text(
                text = "$name",
                fontSize=32.sp,
                modifier = modifier
            )
            Text(
                text = "Developer",
                fontSize=12.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Column (
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1F)){
            ContactRow(R.drawable.ic_email,"$email")
            ContactRow(R.drawable.ic_handle,"$handle")
            ContactRow(R.drawable.baseline_phone_24,"$phone")

        }
    }


}

@Composable
fun ContactRow(img: Int, info: String) {
    val modifier = Modifier.padding(8.dp)
    Row (horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = img), contentDescription = info, modifier = modifier, colorFilter = ColorFilter.tint(color = Color.Green))
        Text(text = info, modifier = modifier)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard(
            name = "Android",
            email = "blah@gmail.com",
            phone = "+61 123 123 123",
            handle = "@tweet.com")
    }
}