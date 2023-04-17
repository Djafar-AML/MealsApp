package com.example.mealsapp.ui.meals

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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


    var isDescriptionExpanded by remember { mutableStateOf(false) }

    Card(
        shape = CutCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Row(
            Modifier
                .animateContentSize()
                .clickable { }) {
            // Image
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = "Meal Picture",
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop,
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.h6
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = meal.description,
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Start,
                        maxLines = if (isDescriptionExpanded) 6 else 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Icon(
                imageVector =
                if (isDescriptionExpanded) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.ArrowDropDown,
                contentDescription = "Expand row icon",
                modifier = Modifier
                    .padding(16.dp)
                    .size(24.dp)
                    .align(if (isDescriptionExpanded) Alignment.Bottom else Alignment.CenterVertically)
                    .clickable { isDescriptionExpanded = !isDescriptionExpanded }
            )

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