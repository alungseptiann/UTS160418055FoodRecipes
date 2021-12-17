package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util.loadImage
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel.DetailViewModel
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_food_detail.*
import kotlinx.android.synthetic.main.fragment_food_list.*


class RecipesFragment : Fragment() {
    private lateinit var viewModel:ListViewModel
    private val recipesListAdapter = RecipesListAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recView.adapter = recipesListAdapter

        recView2.layoutManager = LinearLayoutManager(context)
        recView2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recView2.adapter = recipesListAdapter

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.recipesLD.observe(viewLifecycleOwner, Observer {
            recipesListAdapter.updateRecipesList(it)
            with(txtError){
                visibility = if(it.isEmpty()) View.VISIBLE else View.GONE
            }
        })
    }
}
