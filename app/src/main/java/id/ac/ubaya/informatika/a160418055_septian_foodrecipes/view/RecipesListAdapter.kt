package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.databinding.FoodListItem2Binding
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.databinding.FoodListItemBinding
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util.loadImage
import kotlinx.android.synthetic.main.food_list_item.view.*

class RecipesListAdapter(val recipesList:ArrayList<RecipesList>) : RecyclerView.Adapter<RecipesListAdapter.FoodListViewHolder>(),
    RecipesDetailOnClick{
    class FoodListViewHolder(var view: FoodListItemBinding): RecyclerView.ViewHolder(view.root)

    fun updateRecipesList(newFoodList: List<RecipesList>){
        recipesList.clear()
        recipesList.addAll(newFoodList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val v = inflater.inflate(id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R.layout.food_list_item, parent, false)
        val view = DataBindingUtil.inflate<FoodListItemBinding>(inflater, R.layout.food_list_item, parent, false)
        return FoodListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        holder.view.recipeslist = recipesList[position]
        holder.view.detaillistener1 = this
//        holder.view.recipeslist.uuid
//        holder.view.txtNameHor.text = recipesList[position].judulResep +" "+recipesList[position].uuid
        holder.view.imageViewHor.loadImage(recipesList[position].photoUrl.toString(), holder.view.progressBar1)
        holder.view.progressBar1.visibility = View.GONE

//
//        holder.view.btnDetailHor.setOnClickListener {
//            val action = recipesList[position].judulResep?.let { it1->
//                RecipesFragmentDirections.actionFoodDetail(
//                    it1,recipesList[position].photoUrl, recipesList[position].ceritaResep,recipesList[position].daerahAsalResep,recipesList[position].porsi,
//                    recipesList[position].waktuMasak,recipesList[position].bahanMemasak,recipesList[position].langkahMemasak, recipesList[position].uuid
//                )
//            }
//            if (action != null){
//                Navigation.findNavController(it).navigate(action)
//            }
//        }
    }

    override fun getItemCount(): Int {
        return recipesList.size
    }

    override fun onRecipesDetail(v: View, uuid: Int) {
        val action = RecipesFragmentDirections.actionFoodDetail(v.tag.toString(),"","","","","","","",uuid)
        Navigation.findNavController(v).navigate(action)
    }
}