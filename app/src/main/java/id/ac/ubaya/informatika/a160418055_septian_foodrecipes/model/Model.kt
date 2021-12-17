package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecipesList(
    @ColumnInfo(name = "judulResep")
    var judulResep:String?,
    @ColumnInfo(name = "photoUrl")
    var photoUrl:String?,
    @ColumnInfo(name = "ceritaResep")
    var ceritaResep:String?,
    @ColumnInfo(name = "daerahAsalResep")
    var daerahAsalResep:String?,
    @ColumnInfo(name = "porsi")
    var porsi:String?,
    @ColumnInfo(name = "waktuMasak")
    var waktuMasak:String?,
    @ColumnInfo(name = "bahanMemasak")
    var bahanMemasak:String?,
    @ColumnInfo(name = "langkahMemasak")
    var langkahMemasak:String?,
    @ColumnInfo(name = "isDone")
    var isDone:Int = 0,
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}