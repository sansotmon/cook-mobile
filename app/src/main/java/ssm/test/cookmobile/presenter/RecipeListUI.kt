package ssm.test.cookmobile.presenter

interface RecipeListUI: BaseUI {
    fun showRecipe(id: String)
    fun refreshRecycler()
}