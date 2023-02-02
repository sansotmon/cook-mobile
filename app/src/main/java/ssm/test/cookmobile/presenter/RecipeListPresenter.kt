package ssm.test.cookmobile.presenter

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import ssm.test.cookmobile.R
import ssm.test.cookmobile.model.Recipe

class RecipeListPresenter(val context: Context, val ui: RecipeListUI) : BasePresenter(context) {

    private var recipes: List<Recipe> = arrayListOf()
    private var recipesTempList: List<Recipe> = arrayListOf()

    fun getRecipes(){
        ui.showToast(context.getString(R.string.activity_recipe_list_loading))
        okInteractor.getRecipes({responseBody ->
            val json: JsonObject = JsonParser().parse(responseBody).asJsonObject
            if(json.get("error") == null){
                val message = Gson().fromJson(responseBody, Recipe.Recipes::class.java)
                recipes = message.recipes!!
                recipesTempList = recipes
                message.recipes?.forEach { recipe ->
                    val r = Recipe(recipe.id, recipe.name, recipe.description, recipe.image, recipe.latitude, recipe.longitude)
                    r.let {
                        ui.refreshRecycler()
                    }
                }
            }else{
                ui.showMessageDialog(json.get("ERROR").toString())
            }
        }, {error->
            error?.let {
                ui.showMessageDialog(it)
            }
        })
    }

    fun getTotalRecipes(): Int = recipesTempList.size

    fun getRecipe(index: Int, data: (recipe:Recipe) -> Unit) {
        val recipe = recipesTempList[index]
        data(recipe)
    }

    fun actionRecipe(index: Int) {
        val recipe = recipesTempList[index]
        ui.showRecipe(Gson().toJson(recipe))
    }

    fun findRecipe(text: String) {
        recipesTempList = recipes.filter { s -> s.name!!.contains(text, ignoreCase = true)}
        ui.refreshRecycler()
    }
}