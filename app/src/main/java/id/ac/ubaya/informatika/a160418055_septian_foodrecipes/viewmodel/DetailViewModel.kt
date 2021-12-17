package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    val recipesLD = MutableLiveData<RecipesList>()

    fun fetch(uuid:Int){
        launch {
            val db = buildDB((getApplication()))
            recipesLD.value = db.recipesDao().selectRecipes(uuid)
        }
    }

    fun update(judulResep: String, photoUrl:String, ceritaResep:String, daerahAsalResep:String, porsi:String,waktuMasak:String, bahanMemasak:String,langkahMemasak:String, uuid: Int){
        launch {
            val db = buildDB(getApplication())
            db.recipesDao().update(judulResep,photoUrl, ceritaResep, daerahAsalResep, porsi, waktuMasak, bahanMemasak, langkahMemasak, uuid)
        }
    }

    fun addRecipes(recipesList: List<RecipesList>){
        launch {
            val db = buildDB(getApplication())
            db.recipesDao().insertAll(*recipesList.toTypedArray())
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}