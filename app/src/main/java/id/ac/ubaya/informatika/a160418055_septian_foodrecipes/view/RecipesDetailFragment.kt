package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util.loadImage
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_food_detail.*

class RecipesDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val uuid =RecipesDetailFragmentArgs.fromBundle(requireArguments()).uuid

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(uuid)

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.recipesLD.observe(viewLifecycleOwner, Observer {
            txtNamaResepDetail.setText(viewModel.recipesLD.value?.judulResep)
            textCeritaResepDetail.setText(viewModel.recipesLD.value?.ceritaResep)
            txtAsalResep.setText(viewModel.recipesLD.value?.daerahAsalResep)
            textPorsi.setText(viewModel.recipesLD.value?.porsi)
            txtWaktuMasak.setText(viewModel.recipesLD.value?.waktuMasak)
            txtBahanMasak.setText(viewModel.recipesLD.value?.bahanMemasak)
            txtLangkahMasak.setText(viewModel.recipesLD.value?.langkahMemasak)
            imgFoodDetail.loadImage(viewModel.recipesLD.value?.photoUrl.toString(), progressBar3)
            progressBar3.visibility = View.GONE
        })
    }
}