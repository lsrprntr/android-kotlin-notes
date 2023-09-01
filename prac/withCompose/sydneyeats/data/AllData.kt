package com.example.sydneyeats.data

import com.example.sydneyeats.R
import com.example.sydneyeats.model.Area
import com.example.sydneyeats.model.Restaurant

object AllData {
    val allRestaurants =  listOf(
        Restaurant(
            name = R.string.alex_n_rolls,
            description = R.string.lorem,
            image = R.drawable.alexnrolls,
            category = Area.West
        ),
        Restaurant(
            name = R.string.ayam_goreng_99,
            description = R.string.lorem,
            image = R.drawable.ayamgoreng99,
            category = Area.South
        ),
        Restaurant(
            name = R.string.bakers_house,
            description = R.string.lorem,
            image = R.drawable.bakershouse,
            category = Area.North
        ),
        Restaurant(
            name = R.string.chinese_restaurant,
            description = R.string.lorem,
            image = R.drawable.chineserestaurant,
            category = Area.West
        ),
        Restaurant(
            name = R.string.dong_hae_sushi_bar,
            description = R.string.lorem,
            image = R.drawable.donghaesushi,
            category = Area.West
        ),
        Restaurant(
            name = R.string.dos_senoritas,
            description = R.string.lorem,
            image = R.drawable.dossenoritas,
            category = Area.North
        ),
        Restaurant(
            name = R.string.el_jannah,
            description = R.string.lorem,
            image = R.drawable.eljannah,
            category = Area.West
        ),
        Restaurant(
            name = R.string.falafel,
            description = R.string.lorem,
            image = R.drawable.falafel,
            category = Area.Inner
        ),
        Restaurant(
            name = R.string.hurricanes_grill,
            description = R.string.lorem,
            image = R.drawable.hurricanesgrill,
            category = Area.Inner
        ),
        Restaurant(
            name = R.string.jang_ta_bal,
            description = R.string.lorem,
            image = R.drawable.jangtabal,
            category = Area.West
        ),
        Restaurant(
            name = R.string.kowloon_cafe,
            description = R.string.lorem,
            image = R.drawable.kowlooncafe,
            category = Area.Inner
        ),
        Restaurant(
            name = R.string.pancake_on_the_rocks,
            description = R.string.lorem,
            image = R.drawable.pancakeontherocks,
            category = Area.Inner
        ),
        Restaurant(
            name = R.string.pho_song_huong,
            description = R.string.lorem,
            image = R.drawable.phosonghuong,
            category = Area.West
        ),
        Restaurant(
            name = R.string.secret_burger_society,
            description = R.string.lorem,
            image = R.drawable.secretburgersociety,
            category = Area.South
        ),
        Restaurant(
            name = R.string.time_for_thai,
            description = R.string.lorem,
            image = R.drawable.timeforthai,
            category = Area.South
        )
    )
    val innerList = allRestaurants.filter { it.category == Area.Inner }
    val westList = allRestaurants.filter { it.category == Area.West }
    val southList = allRestaurants.filter { it.category == Area.South }
    val northList = allRestaurants.filter { it.category == Area.North }
}

