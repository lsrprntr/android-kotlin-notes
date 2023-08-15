package com.example.superhero

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroesRepository.heroes

@Composable
fun SuperheroCard(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    val name = stringResource(id = hero.nameRes)
    val description = stringResource(id = hero.descriptionRes)
    val img = painterResource(id = hero.imageRes)

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(16.dp)
                .height(72.dp)
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .height(72.dp)
                    .weight(1F)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            //Image
            Column(
                modifier = Modifier
                    .width(88.dp)
                    .padding(start = 16.dp, end = 8.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Top,
            ) {
                Card(
                    modifier = Modifier
                        .height(72.dp)
                        .width(88.dp)
                        .weight(1F)
                        ,

                ) {
                    Image(
                        painter = img,
                        contentDescription = null,
                        modifier = Modifier.weight(1F),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroMainScreen(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.displayLarge
                    )
                },
                modifier = Modifier
            )
        }
    ) {
        it ->
        HeroList(it)
    }
}


@Composable
fun HeroList(paddingValues: PaddingValues) {
    LazyColumn(
        contentPadding = paddingValues
    ) {
        items(heroes) { it ->
            SuperheroCard(
                hero = it,
            )
        }
    }
}

@Composable
fun test() {
    SuperheroCard(
        hero = Hero(
            nameRes = R.string.hero1,
            descriptionRes = R.string.description1,
            imageRes = R.drawable.android_superhero1,
        )
    )
}