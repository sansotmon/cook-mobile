package ssm.test.cookmobile.model

import com.google.gson.annotations.SerializedName

class Recipe {

    lateinit var id: String
    var name: String? = null
    var description: String? = null
    var image: String? = null
    var latitude: Double = 0.0
    var longitude: Double = 0.0

    class Recipes {
        @SerializedName("message")
        var recipes: ArrayList<Recipe>? = null
    }

    constructor(
        id: String,
        name: String?,
        description: String?,
        image: String?,
        latitude: Double,
        longitude: Double
    ) {
        this.id = id
        this.name = name
        this.description = description
        this.image = image
        this.latitude = latitude
        this.longitude = longitude
    }
}