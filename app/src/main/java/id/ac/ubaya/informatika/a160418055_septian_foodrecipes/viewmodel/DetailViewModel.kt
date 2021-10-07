package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList

class DetailViewModel:ViewModel() {
    val recipesLD = MutableLiveData<RecipesList>()
    val recipesLD2 = MutableLiveData<RecipesList>()

    fun fetch(judulResep: String?, photoUrl:String?, ceritaResep:String?, daerahAsalResep:String?, porsi:String?,waktuMasak:String?, bahanMemasak:String?,langkahMemasak:String?){
        val recipesDetail =RecipesList(judulResep, photoUrl, ceritaResep, daerahAsalResep, porsi, waktuMasak, bahanMemasak, langkahMemasak)
        recipesLD.value = recipesDetail
        recipesLD2.value = recipesDetail
    }
}