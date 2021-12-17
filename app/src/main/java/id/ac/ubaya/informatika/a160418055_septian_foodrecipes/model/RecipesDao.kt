package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model

import androidx.room.*


@Dao
interface RecipesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipeslist: RecipesList)

    @Query("SELECT * FROM recipeslist WHERE isDone = 0 ORDER BY uuid ASC")
    suspend fun selectAllRecipes():List<RecipesList>

    @Query("SELECT * FROM recipeslist WHERE uuid = :id")
    suspend fun selectRecipes(id:Int):RecipesList

    @Query("UPDATE recipeslist SET judulResep=:judulResep, photoUrl=:photoUrl, ceritaResep=:ceritaResep, daerahAsalResep=:daerahAsalResep,porsi=:porsi,waktuMasak=:waktuMasak,bahanMemasak=:bahanMemasak,langkahMemasak=:langkahMemasak WHERE uuid=:uuid")
    suspend fun update(judulResep:String, photoUrl:String, ceritaResep:String,daerahAsalResep:String,porsi:String,waktuMasak:String,bahanMemasak:String,langkahMemasak:String, uuid:Int)

    @Delete
    suspend fun deleteRecipes(recipesList: RecipesList)
}