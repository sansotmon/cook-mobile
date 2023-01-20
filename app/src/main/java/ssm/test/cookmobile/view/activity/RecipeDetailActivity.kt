package ssm.test.cookmobile.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_recipe_detail.*
import ssm.test.cookmobile.presenter.RecipeDetailUI
import ssm.test.cookmobile.R.layout.activity_recipe_detail
import ssm.test.cookmobile.presenter.RecipeDetailPresenter

class RecipeDetailActivity : BaseActivity(), RecipeDetailUI {
    private var presenter: RecipeDetailPresenter? = null
    companion object {
        val RECIPE = "recipeJson"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_recipe_detail)

        presenter = RecipeDetailPresenter(this, this)

        if(intent.hasExtra(RECIPE)){
            val recipeJson = intent.getStringExtra(RECIPE)
            recipeJson?.let {
                presenter?.showRecipe(it)
            }
        }

        btnLocation.setOnClickListener{
            presenter?.getLocationRecipe()
        }
    }

    override fun showRecipe(name: String, description: String, image: String) {
        Picasso.get().load(image).into(detailImage)
        textName.text = name
        textDescription.text = description
    }

    override fun goToMap(latitude: Double, longitude: Double) {
        val intent = Intent(this, MapActivity::class.java)
        intent.putExtra("latitude", latitude)
        intent.putExtra("longitude", longitude)
        startActivity(intent)
    }
}