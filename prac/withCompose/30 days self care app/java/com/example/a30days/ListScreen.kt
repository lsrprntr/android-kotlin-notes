package com.example.a30days

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30days.model.TipDayImage
import com.example.a30days.model.TipDayImageDataSource.tipDayImageData

@Composable
fun BodyList(
    data: List<TipDayImage>,
    modifier: Modifier = Modifier,
) {
    LazyColumn (
        modifier = modifier
    ){
        items(data) { it ->
            DayItem(it, Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        }
    }
}


@Composable
fun DayItem(
    item: TipDayImage,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Day ${item.day}",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,

            )
            Card (
                modifier = Modifier.padding(8.dp)
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                )
            }
            Text(
                text = stringResource(id = item.tip),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}

@Preview
@Composable
fun test() {
    val data = tipDayImageData
    BodyList(data)
}

@Preview
@Composable
fun tester() {
    DayItem(
        TipDayImage(
            day = 1.toInt(),
            imageRes = R.drawable.day_13,
            tip = R.string.tip_1
        ),
    )
}
