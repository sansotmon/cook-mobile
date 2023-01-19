package ssm.test.cookmobile.model

import com.google.gson.annotations.SerializedName

class Recipe(
    var id: String,
    var name: String?,
    var description: String?,
    var image: String?,
    var latitude: Double,
    var longitude: Double
) {

    class Recipes {
        @SerializedName("message")
        var recipes: ArrayList<Recipe>? = null
    }

}