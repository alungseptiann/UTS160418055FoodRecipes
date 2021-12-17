package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.view.View
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList

interface RecipesDetailOnClick{
    fun onRecipesDetail(v:View, uuid:Int)
}

interface ButtonAddRecipesClickListener{
    fun onButtonAddRecipes(v:View, obj:RecipesList)
}