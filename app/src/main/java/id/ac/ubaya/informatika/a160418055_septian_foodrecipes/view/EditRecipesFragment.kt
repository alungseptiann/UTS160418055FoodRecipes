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
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_add_recipes.*

class EditRecipesFragment : Fragment() {
    private lateinit var viewModel:DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val uuid = EditRecipesFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)

        textSub.text = "Edit Resep Masakanmu!!!"
        btnAddRecipes.text = "Save Changes"

        btnAddRecipes.setOnClickListener {
            viewModel.update(editJudul.text.toString(), editPhotoUrl.text.toString(),editCerita.text.toString(),
                editDaerahAsalResep.text.toString(), editPorsi.text.toString(),editWaktuMemasak.text.toString(),editBahan.text.toString(),
                editLangkahMasak.text.toString(),uuid)
            Toast.makeText(view.context, "Recipes Updated", Toast.LENGTH_SHORT).show()
        }

        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.recipesLD.observe(viewLifecycleOwner, Observer {
            editJudul.setText(it.judulResep)
            editPhotoUrl.setText(it.photoUrl)
            editCerita.setText(it.ceritaResep)
            editDaerahAsalResep.setText(it.daerahAsalResep)
            editPorsi.setText(it.porsi)
            editWaktuMemasak.setText(it.waktuMasak)
            editBahan.setText(it.bahanMemasak)
            editLangkahMasak.setText(it.langkahMemasak)
        })
    }
}