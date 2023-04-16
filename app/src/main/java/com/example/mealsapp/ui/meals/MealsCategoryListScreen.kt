package com.example.mealsapp.ui.meals

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.mealsapp.model.domain.Meal
import com.example.mealsapp.ui.meals.vm.MealsCategoriesViewModel
import com.example.mealsapp.ui.theme.MealsAppTheme


@Composable
fun MealsCategoryListScreen() {

    val viewModel = hiltViewModel<MealsCategoriesViewModel>()

    val mealList = viewModel.rememberedList.value

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(mealList) { meal: Meal ->
            Meal(meal = meal)
        }
    }

}

@Composable
fun Meal(meal: Meal) {

    Card(
        shape = CutCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Row(Modifier.clickable { }) {
            // Image
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = "Meal Picture",
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.h6
                )
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsAppTheme {
        MealsCategoryListScreen()
    }
}