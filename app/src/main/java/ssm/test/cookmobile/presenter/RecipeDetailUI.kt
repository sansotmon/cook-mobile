package ssm.test.cookmobile.presenter

interface RecipeDetailUI {
    fun showRecipe(name:String, description:String, image:String)
    fun goToMap(latitude: Double, longitude: Double)
}