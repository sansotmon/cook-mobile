package ssm.test.cookmobile.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_recipe_list.*
import ssm.test.cookmobile.presenter.RecipeListPresenter
import ssm.test.cookmobile.presenter.RecipeListUI

import ssm.test.cookmobile.R.layout.activity_recipe_list
import ssm.test.cookmobile.view.adapter.RecipeListRecyclerAdapter

class RecipeListActivity : BaseActivity(), RecipeListUI {
    private var presenter: RecipeListPresenter? = null
    private var adapter: RecipeListRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_recipe_list)

        presenter = RecipeListPresenter(this, this)
        createRecycleAdapter()
        presenter?.getRecipes()

        recipeSearch.setOnQueryTextListener (object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(text: String?): Boolean {
                text?.let {
                    presenter?.findRecipe(text)
                }
                return false
            }
        })
    }

    private fun createRecycleAdapter(){
        adapter = RecipeListRecyclerAdapter(presenter!!)
        recipeRecycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recipeRecycler.adapter = adapter
        recipeRecycler.setHasFixedSize(true)
    }

    override fun refreshRecycler() {
        runOnUiThread {
            adapter?.notifyDataSetChanged()
        }
    }

    override fun showRecipe(recipeJson: String) {
        val intent = Intent(this, RecipeDetailActivity::class.java)
        intent.putExtra(RecipeDetailActivity.RECIPE, recipeJson)
        startActivity(intent)
    }

}