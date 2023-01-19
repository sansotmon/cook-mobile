package ssm.test.cookmobile.view.activity

import android.os.Bundle
import ssm.test.cookmobile.presenter.RecipeListPresenter
import ssm.test.cookmobile.presenter.RecipeListUI

import ssm.test.cookmobile.R.layout.activity_recipe_list

class RecipeListActivity : BaseActivity(), RecipeListUI {
    private var presenter: RecipeListPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_recipe_list)

    }
}