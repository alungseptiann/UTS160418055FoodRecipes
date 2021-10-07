package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util.loadImage
import kotlinx.android.synthetic.main.food_list_item.view.*

class RecipesListAdapter(val foodList:ArrayList<RecipesList>) : RecyclerView.Adapter<RecipesListAdapter.FoodListViewHolder>(){
    class FoodListViewHolder(var view: View): RecyclerView.ViewHolder(view)

    fun updateFoodList(newFoodList: List<RecipesList>){
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R.layout.food_list_item, parent, false)
        return FoodListViewHolder(v)
    }

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        holder.view.txtNameHor.text = foodList[position].judulResep
        holder.view.imageViewHor.loadImage(foodList[position].photoUrl.toString(), holder.view.progressBar1)
        holder.view.progressBar1.visibility = View.GONE

        holder.view.btnDetailHor.setOnClickListener {
            val action = foodList[position].judulResep?.let { it1->
                RecipesFragmentDirections.actionFoodDetail(
                        it1,foodList[position].photoUrl, foodList[position].ceritaResep,foodList[position].daerahAsalResep,foodList[position].porsi,
                        foodList[position].waktuMasak,foodList[position].bahanMemasak,foodList[position].langkahMemasak
                )
            }
            if (action != null){
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}