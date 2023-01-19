package ssm.test.cookmobile.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recipe_list.view.*
import ssm.test.cookmobile.model.Recipe
import ssm.test.cookmobile.presenter.RecipeListPresenter
import ssm.test.cookmobile.R.layout.row_list_recipe

class RecipeListRecyclerAdapter(val presenter: RecipeListPresenter): RecyclerView.Adapter<RecipeListRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(recipe: Recipe) = with(itemView) {
            recipe.name?.let {
                titleText.text = it
            }
        }
    }

    fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(row_list_recipe))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.getRecipe(position) { recipe ->
            holder.bind(recipe)
        }
    }

    override fun getItemCount(): Int = presenter.getTotalRecipes()
}