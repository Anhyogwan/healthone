package com.secui.healthone.ui.mealplanpage.MealInput

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.secui.healthone.data.MealPlan.Food
import com.secui.healthone.ui.common.AppColors

@Composable
fun MealSearchResults(
    searchResults: List<Food>,
    selectedFoodId: Int?,
    onFoodSelected: (Int) -> Unit
) {
    Column {
        searchResults.forEach { food ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedFoodId == food.id,
                    onClick = { onFoodSelected(food.id) }
                )
                Text(
                    text = food.name,
                    modifier = Modifier.weight(2f),
                    style = TextStyle(fontSize = 16.sp)
                )
                Text(
                    text = "${food.servingSize} g",
                    modifier = Modifier.weight(1f),
                    style = TextStyle(fontSize = 16.sp)
                )
                Text(
                    text = "${food.calories} kcal",
                    modifier = Modifier.weight(1f),
                    style = TextStyle(fontSize = 16.sp)
                )
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(AppColors.mono200)
            )
        }
    }
}
