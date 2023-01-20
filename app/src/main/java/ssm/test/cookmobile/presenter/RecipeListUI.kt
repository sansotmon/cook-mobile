package ssm.test.cookmobile.presenter

interface RecipeListUI: BaseUI {
    fun showRecipe(recipeJson: String)
    fun refreshRecycler()
}