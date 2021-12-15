package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import kotlinx.android.synthetic.main.fragment_add_recipes.*

class AddRecipesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_recipes, container, false)

        btnAddRecipes.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }
}