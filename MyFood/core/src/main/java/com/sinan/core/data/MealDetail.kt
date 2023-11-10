/*
 * Created by sinan shoukath on 6/11/2023
 * Copyright (c) 2023. All rights reserved.
 */

package com.sinan.core.data

import com.google.gson.annotations.SerializedName

data class MealDetail(
  @SerializedName("idMeal") val mealId: String,
  @SerializedName("strArea") val area: String,
  @SerializedName("strCategory") val category: String,
  @SerializedName("strInstructions") val instructions: String,
  @SerializedName("strMeal") val meal: String,
  @SerializedName("strMealThumb") val mealThumb: String,
  @SerializedName("strYoutube") val youtube: String
)

/*{
      "idMeal": "53081",
      "strMeal": "Potato Salad (Olivier Salad)",
      "strDrinkAlternate": null,
      "strCategory": "Vegetarian",
      "strArea": "Russian",
      "strInstructions": "Cut the potatoes and carrots into small uniform cubes.\r\nPlace them in a large pot and fill with water.\r\nAdd salt and vinegar. Bring it to a boil over medium high heat, and then reduce the heat to medium and continue to cook until the potatoes are cooked through, about 15 minutes. Drain the potatoes and let it cool to room temperature.\r\nMeanwhile, cut the sausage and pickles into small cubes, and chop the green onions.\r\nCut the hard-boiled eggs into small cubes as well.\r\nIf using fresh dill, chop them as well.\r\nIn a large bowl, combine potatoes, carrots, sausage, pickles, peas and green onions.\r\nAdd mayo and dill and mix until well combined.\r\nSalt and pepper to taste. Cover with a plastic wrap and refrigerate for at least 1 hour before serving.",
      "strMealThumb": "https://www.themealdb.com/images/media/meals/ebvuir1699013665.jpg",
      "strTags": "salad",
      "strYoutube": "https://www.youtube.com/watch?v=RnsWwHcpKiY",
      "strIngredient1": "Potatoes",
      "strIngredient2": "Carrots",
      "strIngredient3": "Salt",
      "strIngredient4": "White Wine Vinegar",
      "strIngredient5": "Eggs",
      "strIngredient6": "Sausages",
      "strIngredient7": "Dill",
      "strIngredient8": "Peas",
      "strIngredient9": "Onions",
      "strIngredient10": "Mayonnaise",
      "strIngredient11": "",
      "strIngredient12": "",
      "strIngredient13": "",
      "strIngredient14": "",
      "strIngredient15": "",
      "strIngredient16": "",
      "strIngredient17": "",
      "strIngredient18": "",
      "strIngredient19": "",
      "strIngredient20": "",
      "strMeasure1": "4",
      "strMeasure2": "3",
      "strMeasure3": "1 tbs",
      "strMeasure4": "1/2 tbs",
      "strMeasure5": "4",
      "strMeasure6": "7 oz ",
      "strMeasure7": "4 oz ",
      "strMeasure8": "1 can ",
      "strMeasure9": "4",
      "strMeasure10": "1 cup ",
      "strMeasure11": " ",
      "strMeasure12": " ",
      "strMeasure13": " ",
      "strMeasure14": " ",
      "strMeasure15": " ",
      "strMeasure16": " ",
      "strMeasure17": " ",
      "strMeasure18": " ",
      "strMeasure19": " ",
      "strMeasure20": " ",
      "strSource": "https://www.sweetandsavorybyshinee.com/russian-potato-salad/",
      "strImageSource": null,
      "strCreativeCommonsConfirmed": null,
      "dateModified": null
    }*/