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
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_food_list.*


class RecipesFragment : Fragment() {
    private lateinit var viewModel:ListViewModel
    private lateinit var viewModel2:ListViewModel
    private val foodListAdapter = RecipesListAdapter(arrayListOf())
    private val foodListAdapter2 = RecipesListAdapter2(arrayListOf())

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

        refreshLayout2.setOnRefreshListener {
            recView.visibility =View.GONE
            recView2.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            viewModel2.refresh2()
            refreshLayout2.isRefreshing = false
        }

        viewModel2 = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel2.refresh2()

        recView.layoutManager = LinearLayoutManager(context)
        recView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recView.adapter = foodListAdapter

        recView2.layoutManager = LinearLayoutManager(context)
        recView2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recView2.adapter = foodListAdapter2

        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.recipesLD.observe(viewLifecycleOwner, Observer {
            foodListAdapter.updateFoodList(it)
        })
        viewModel2.recipesLD2.observe(viewLifecycleOwner, Observer {
            foodListAdapter2.updateFoodList2(it)
        })

        viewModel.recipesLoadErrorLD.observe(viewLifecycleOwner, Observer {
            txtError.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel2.recipesLoadErrorLD2.observe(viewLifecycleOwner, Observer {
            txtError.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressLoad.visibility = View.VISIBLE
                recView.visibility = View.GONE
            }else{
                progressLoad.visibility = View.GONE
                recView.visibility = View.VISIBLE
            }
        })
        viewModel2.loadingLD2.observe(viewLifecycleOwner, Observer {
            if(it){
                progressLoad.visibility = View.VISIBLE
                recView2.visibility = View.GONE
            }else{
                progressLoad.visibility = View.GONE
                recView2.visibility = View.VISIBLE
            }
        })
    }
}
