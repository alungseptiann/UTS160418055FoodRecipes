package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import io.reactivex.rxjava3.core.Observable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.databinding.FragmentAddRecipesBinding
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel.DetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class AddRecipesFragment : Fragment(),ButtonAddRecipesClickListener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var databinding: FragmentAddRecipesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding = DataBindingUtil.inflate<FragmentAddRecipesBinding>(inflater, R.layout.fragment_add_recipes, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        databinding.addrecipelist = this
        databinding.recipelist = RecipesList("","","","","","","","",0)

//        btnAddRecipes.setOnClickListener {
//            var recipes = RecipesList(editJudul.text.toString(), editPhotoUrl.text.toString(),editCerita.text.toString(), editDaerahAsalResep.text.toString(),
//                editPorsi.text.toString(),editWaktuMemasak.text.toString(),editBahan.text.toString(),editLangkahMasak.text.toString(),0)
//            val list = listOf(recipes)
//            viewModel.addRecipes(list)
//            Toast.makeText(it.context, "New Recipes Added!", Toast.LENGTH_SHORT).show()
//            Navigation.findNavController(it).popBackStack()
//        }
    }

    override fun onButtonAddRecipes(v: View, obj: RecipesList) {
        if(obj.judulResep.toString().trim().isEmpty() || obj.photoUrl.toString().trim().isEmpty() || obj.ceritaResep.toString().trim().isEmpty() ||
            obj.daerahAsalResep.toString().trim().isEmpty() || obj.porsi.toString().trim().isEmpty() || obj.waktuMasak.toString().trim().isEmpty() ||
            obj.bahanMemasak.toString().trim().isEmpty() || obj.langkahMemasak.toString().trim().isEmpty()){
            Snackbar.make(
                v,
                "Tolong isi kolom yang kosong!",
                Snackbar.LENGTH_LONG
            ).show()
        }else {
            val recipelist = listOf(obj)
            viewModel.addRecipes(recipelist)
            Snackbar.make(
                v,
                "Resep Telah Dibuat!!",
                Snackbar.LENGTH_LONG
            ).show()
            Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    MainActivity.showNotification(
                        "Recipes Added!",
                        "Your Recipes Has Been Added To System.",
                        R.drawable.ic_baseline_view_list_24
                    )
                }
            Navigation.findNavController(v).popBackStack()
        }
    }
}