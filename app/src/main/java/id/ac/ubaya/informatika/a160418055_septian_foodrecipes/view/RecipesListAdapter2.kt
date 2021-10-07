package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util.loadImage
import kotlinx.android.synthetic.main.food_list_item2.view.*

class RecipesListAdapter2(val foodList2:ArrayList<RecipesList>) : RecyclerView.Adapter<RecipesListAdapter2.FoodListViewHolder2>(){
    class FoodListViewHolder2(var view2: View): RecyclerView.ViewHolder(view2)

    fun updateFoodList2(newFoodList2: List<RecipesList>){
        foodList2.clear()
        foodList2.addAll(newFoodList2)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder2 {
        val  inflater2 = LayoutInflater.from(parent.context)
        val v2 = inflater2.inflate(id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R.layout.food_list_item2, parent, false)
        return FoodListViewHolder2(v2)
    }

    override fun onBindViewHolder(holder: FoodListViewHolder2, position: Int) {
        holder.view2.txtNameCer.text = foodList2[position].judulResep
        holder.view2.imageViewcer.loadImage(foodList2[position].photoUrl.toString(), holder.view2.progressBar2)
        holder.view2.progressBar2.visibility = View.GONE

        holder.view2.btnDetail.setOnClickListener {
            val action = foodList2[position].judulResep?.let { it1->
                RecipesFragmentDirections.actionFoodDetail(
                        it1,foodList2[position].photoUrl, foodList2[position].ceritaResep,foodList2[position].daerahAsalResep,foodList2[position].porsi,
                        foodList2[position].waktuMasak,foodList2[position].bahanMemasak,foodList2[position].langkahMemasak
                )
            }
            if (action != null){
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return foodList2.size
    }
}