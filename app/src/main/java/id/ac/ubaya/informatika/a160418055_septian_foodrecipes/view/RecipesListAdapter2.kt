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
import kotlinx.android.synthetic.main.food_list_item2.view.*

class RecipesListAdapter2(val recipesList2:ArrayList<RecipesList>) : RecyclerView.Adapter<RecipesListAdapter2.FoodListViewHolder2>(),
    RecipesDetailOnClick{
    class FoodListViewHolder2(var view2: FoodListItem2Binding): RecyclerView.ViewHolder(view2.root)

    fun updateRecipesList2(newFoodList2: List<RecipesList>){
        recipesList2.clear()
        recipesList2.addAll(newFoodList2)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder2 {
        val  inflater2 = LayoutInflater.from(parent.context)
//        val v2 = inflater2.inflate(id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R.layout.food_list_item2, parent, false)

        val view2 = DataBindingUtil.inflate<FoodListItem2Binding>(inflater2, R.layout.food_list_item2, parent, false)
        return FoodListViewHolder2(view2)
    }

    override fun onBindViewHolder(holder: FoodListViewHolder2, position: Int) {
        holder.view2.recipeslist2 = recipesList2[position]
        holder.view2.detaillistener2 = this

//        holder.view2.recipeslist2.uuid
//        holder.view2.txtNameCer.text = recipesList2[position].judulResep  +" "+recipesList2[position].uuid
        holder.view2.imageViewcer.loadImage(recipesList2[position].photoUrl.toString(), holder.view2.progressBar2)
        holder.view2.progressBar2.visibility = View.GONE
//        holder.view2.btnDetail.setOnClickListener {
//            val action = recipesList2[position].judulResep?.let { it1->
//                RecipesFragmentDirections.actionFoodDetail(
//                    it1,recipesList2[position].photoUrl, recipesList2[position].ceritaResep,recipesList2[position].daerahAsalResep,recipesList2[position].porsi,
//                    recipesList2[position].waktuMasak,recipesList2[position].bahanMemasak,recipesList2[position].langkahMemasak, recipesList2[position].uuid
//                )
//            }
//            if (action != null){
//                Navigation.findNavController(it).navigate(action)
//            }
//        }
    }

    override fun getItemCount(): Int {
        return recipesList2.size
    }

    override fun onRecipesDetail(v: View, uuid: Int) {
        val action = RecipesFragmentDirections.actionFoodDetail(v.tag.toString(),"","","","","","","",uuid)
        Navigation.findNavController(v).navigate(action)
    }
}