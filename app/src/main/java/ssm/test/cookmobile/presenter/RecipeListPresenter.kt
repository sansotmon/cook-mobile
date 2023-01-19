package ssm.test.cookmobile.presenter

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import ssm.test.cookmobile.model.Recipe

class RecipeListPresenter(val context: Context, val ui: RecipeListUI) : BasePresenter(context) {

    private var recipes: ArrayList<Recipe> = arrayListOf()

    fun getRecipes(){
        ui.showToast("Loading recipes...")
        okInteractor.getRecipes({responseBody ->
            ui.showToast(responseBody!!)

            val json: JsonObject = JsonParser().parse(responseBody).asJsonObject
            if(json.get("error")  == null){
                val message = Gson().fromJson(responseBody, Recipe.Recipes::class.java)
                recipes = message.recipes!!
                message.recipes?.forEach { recipe ->
                    val r = Recipe(recipe.id, recipe.name, recipe.description, recipe.image, recipe.latitude, recipe.longitude)
                    r.let {
                        ui.showToast(it.name!!)
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

    fun getTotalRecipes(): Int = recipes.size

    fun getRecipe(index: Int, data: (trip:Recipe) -> Unit) {
        val recipe = recipes[index]
        data(recipe)
    }
}