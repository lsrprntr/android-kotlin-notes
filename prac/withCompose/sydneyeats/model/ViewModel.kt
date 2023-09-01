package com.example.sydneyeats.model

import androidx.lifecycle.ViewModel
import com.example.sydneyeats.data.AllData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class AppUiState(
    val allRestaurants: List<Restaurant> = AllData.allRestaurants,
    val currentList: List<Restaurant> = AllData.innerList,
    val currentArea: Area = Area.Inner,
    val currentSelectedRestaurant: Restaurant = allRestaurants[0],
    val isShowingHomeScreen: Boolean = true,
) {

}

class AppViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState

    fun updateCurrentArea(area: Area){
        _uiState.update {
            it.copy(
                currentArea = area
            )
        }
        updateCategoryList(area)
    }

    fun updateCategoryList(category: Area){
        _uiState.update{
            it.copy(
                currentList = when (category) {
                    Area.Inner -> AllData.innerList
                    Area.North -> AllData.northList
                    Area.West -> AllData.westList
                    Area.South -> AllData.southList
                    else -> AllData.allRestaurants
                }
            )
        }
    }


    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedRestaurant = it.currentList[0],
                isShowingHomeScreen = true
            )
        }
    }

    fun updateDetailScreen(restaurant: Restaurant) {
        _uiState.update {
            it.copy(
                currentSelectedRestaurant = restaurant,
                isShowingHomeScreen = false
            )
        }
    }
}