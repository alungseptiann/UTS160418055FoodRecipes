package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val recipesLD = MutableLiveData<List<RecipesList>>()
    val recipesLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()

    fun refresh(){
        launch {
            val db = buildDB(getApplication())
            recipesLD.value = db.recipesDao().selectAllRecipes()
            recipesLoadErrorLD.value = false
            loadingLD.value = false
        }
    }
    fun clearRecipes(recipesList: RecipesList){
        launch {
            val db = buildDB(getApplication())
            db.recipesDao().deleteRecipes(recipesList)
            recipesLD.value = db.recipesDao().selectAllRecipes()
        }
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}