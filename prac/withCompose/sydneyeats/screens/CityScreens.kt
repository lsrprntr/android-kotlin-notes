@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.sydneyeats.screens

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sydneyeats.R
import com.example.sydneyeats.model.AppUiState
import com.example.sydneyeats.model.AppViewModel
import com.example.sydneyeats.model.Area
import com.example.sydneyeats.model.ContentType
import com.example.sydneyeats.model.NavType
import com.example.sydneyeats.model.NavigationItemContent
import com.example.sydneyeats.model.Restaurant


@Composable
fun MainScreen(
    windowSize: WindowWidthSizeClass,
) {
    val navigationType: NavType
    val contentType: ContentType
    val viewModel: AppViewModel = viewModel()
    val appUiState = viewModel.uiState.collectAsState().value
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            contentType = ContentType.LIST_ONLY
            navigationType = NavType.NAVIGATION_RAIL
        }

        WindowWidthSizeClass.Medium -> {
            contentType = ContentType.LIST_ONLY
            navigationType = NavType.NAVIGATION_RAIL
        }

        WindowWidthSizeClass.Expanded -> {
            contentType = ContentType.LIST_AND_DETAIL
            navigationType = NavType.PERMANENT_NAVIGATION_DRAWER
        }

        else -> {
            contentType = ContentType.LIST_ONLY
            navigationType = NavType.NAVIGATION_RAIL
        }
    }

    HomeScreen(
        navigationType = navigationType,
        contentType = contentType,
        appUiState = appUiState,
        onTabPressed = { area: Area ->
            viewModel.updateCurrentArea(area)
            viewModel.resetHomeScreenStates()
        },
        onRestaurantCardPressed = { restaurant: Restaurant ->
            viewModel.updateDetailScreen(restaurant)
        },
        onDetailScreenBackPressed = { viewModel.resetHomeScreenStates() })
}

@Composable
fun HomeScreen(
    navigationType: NavType,
    contentType: ContentType,
    appUiState: AppUiState,
    onTabPressed: (Area) -> Unit,
    onRestaurantCardPressed: (Restaurant) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            category = Area.Inner,
            icon = Icons.Default.LocationOn,
            text = stringResource(id = R.string.inner)
        ),
        NavigationItemContent(
            category = Area.North,
            icon = Icons.Default.KeyboardArrowUp,
            text = stringResource(id = R.string.north)
        ),
        NavigationItemContent(
            category = Area.South,
            icon = Icons.Default.KeyboardArrowDown,
            text = stringResource(id = R.string.south)
        ),
        NavigationItemContent(
            category = Area.West,
            icon = Icons.Default.KeyboardArrowLeft,
            text = stringResource(id = R.string.west)
        )
    )

    if (navigationType == NavType.PERMANENT_NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(Modifier.width(dimensionResource(R.dimen.drawer_width))) {
                    NavigationDrawerContent(
                        selectedDestination = appUiState.currentArea,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,
                        modifier = Modifier
                            .wrapContentWidth()
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                            .padding(dimensionResource(R.dimen.drawer_padding_content))
                    )
                }
            },
        ) {
            AppContent(
                navigationType = navigationType,
                contentType = contentType,
                appUiState = appUiState,
                onTabPressed = onTabPressed,
                onRestaurantCardPressed = onRestaurantCardPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier
            )
        }
    } else {
        if (appUiState.isShowingHomeScreen) {
            AppContent(
                navigationType = navigationType,
                contentType = contentType,
                appUiState = appUiState,
                onTabPressed = onTabPressed,
                onRestaurantCardPressed = onRestaurantCardPressed,
                navigationItemContentList = navigationItemContentList,
                modifier = modifier
            )
        } else {
            DetailScreen(
                appUiState = appUiState,
                onBackPressed = onDetailScreenBackPressed,
                modifier = modifier,
            )
        }
    }


}

@Composable
fun NavigationDrawerContent(
    selectedDestination: Area,
    onTabPressed: (Area) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier,
) {
    Column(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                selected = selectedDestination == navItem.category,
                label = {
                    Text(
                        text = navItem.text,
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.drawer_padding_header))
                    )
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                onClick = { onTabPressed(navItem.category) }
            )
        }
    }
}

@Composable
fun AppContent(
    navigationType: NavType,
    contentType: ContentType,
    appUiState: AppUiState,
    onTabPressed: (Area) -> Unit,
    onRestaurantCardPressed: (Restaurant) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier,
) {
    Box(modifier = modifier) {
        Row(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(visible = navigationType == NavType.NAVIGATION_RAIL) {
                AppNavigationRail(
                    currentTab = appUiState.currentArea,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList,
                    modifier = Modifier
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
            ) {
                if (contentType == ContentType.LIST_AND_DETAIL) {
                    AppListAndDetailContent(
                        appUiState = appUiState,
                        onRestaurantCardPressed = onRestaurantCardPressed,
                        modifier = Modifier.weight(1f),
                    )
                } else {
                    AppListOnlyContent(
                        appUiState = appUiState,
                        onRestaurantCardPressed = onRestaurantCardPressed,
                        modifier = Modifier
                            .weight(1f)
                            .padding(
                                horizontal = dimensionResource(R.dimen.email_list_only_horizontal_padding)
                            )
                    )
                }
            }
        }
    }

}

@Composable
fun AppListOnlyContent(
    appUiState: AppUiState,
    onRestaurantCardPressed: (Restaurant) -> Unit,
    modifier: Modifier,
) {
    val restaurants = appUiState.currentList
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.email_list_item_vertical_spacing)
        )
    ) {
        restaurants.forEach {
            item {
                ListedItem(
                    restaurant = it,
                    selected = false,
                    onCardClick = {
                        onRestaurantCardPressed(it)
                    }
                )
            }
        }
    }

}

@Composable
fun ListedItem(
    restaurant: Restaurant,
    selected: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.secondaryContainer
            }
        ),
        onClick = onCardClick
    ) {
        Text(text = stringResource(id = restaurant.name))
    }
}

@Composable
fun AppListAndDetailContent(
    appUiState: AppUiState,
    onRestaurantCardPressed: (Restaurant) -> Unit,
    modifier: Modifier,
) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ){

        val restaurants = appUiState.currentList
        val activity = LocalContext.current as Activity


        Column (
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ){
            LazyColumn(
                modifier = modifier
                    .weight(1f)
                    .padding(
                        end = dimensionResource(R.dimen.list_and_detail_list_padding_end),
                        top = dimensionResource(R.dimen.list_and_detail_list_padding_top)
                    ),
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(R.dimen.email_list_item_vertical_spacing)
                )
            ) {
                restaurants.forEach {
                    item {
                        ListedItem(
                            restaurant = it,
                            selected = false,
                            onCardClick = {
                                onRestaurantCardPressed(it)
                            },
                            modifier = Modifier.padding(12.dp)

                        )
                    }
                }
            }
        }
        Column (modifier = Modifier.weight(1f)) {
            DetailScreen(
                appUiState = appUiState,
                onBackPressed = { activity.finish() },
                modifier = modifier.weight(1f),
            )
        }

    }
}


@Composable
private fun AppNavigationRail(
    currentTab: Area,
    onTabPressed: ((Area) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier,
) {
    NavigationRail(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentTab == navItem.category,
                onClick = { onTabPressed(navItem.category) },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}


@Composable
fun DetailScreen(
    appUiState: AppUiState,
    onBackPressed: () -> Unit,
    modifier: Modifier,
) {
    if (!appUiState.isShowingHomeScreen) {
        BackHandler {
            onBackPressed()
        }
    }
    DetailsCard(
        restaurant = appUiState.currentSelectedRestaurant,
        onBackButtonClicked = onBackPressed,
        modifier = modifier
    )
}

@Composable
fun DetailsCard(
    restaurant: Restaurant,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {

                IconButton(
                    onClick = onBackButtonClicked,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.detail_topbar_back_button_padding_horizontal))
                        .background(MaterialTheme.colorScheme.surface, shape = CircleShape),
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.navigation_back)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = dimensionResource(R.dimen.detail_subject_padding_end))
                ) {
                    Text(
                        text = stringResource(id = restaurant.name),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }


            Card(
                modifier = modifier,
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {

                Image(
                    painter = painterResource(id = restaurant.image),
                    contentDescription = stringResource(id = restaurant.name),
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(id = restaurant.description),
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.detail_content_padding_top)),
                )
            }
        }
    }

}



