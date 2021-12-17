package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util.MIGRATION_1_2

@Database(entities = arrayOf(RecipesList::class), version = 2)
abstract class RecipesDatabase: RoomDatabase() {
    abstract fun recipesDao():RecipesDao

    companion object{
        @Volatile private var instance:RecipesDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RecipesDatabase::class.java,
            "recipesdb"
        )
            .addMigrations(MIGRATION_1_2)
            .build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
    }
}