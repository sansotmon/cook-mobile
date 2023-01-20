package ssm.test.cookmobile.presenter

import android.content.Context
import com.google.gson.Gson
import ssm.test.cookmobile.model.Recipe

class RecipeDetailPresenter(val context: Context, val ui: RecipeDetailUI){
    private var recipe:Recipe? = null

    fun showRecipe(recipeJson:String){
        recipe = Gson().fromJson(recipeJson, Recipe::class.java)
        recipe?.let {
           ui.showRecipe(it.name!!, it.description!!, it.image!!)
        }
    }
}