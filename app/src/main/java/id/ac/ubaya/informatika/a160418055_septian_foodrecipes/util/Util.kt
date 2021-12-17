package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesDatabase
import kotlinx.android.synthetic.main.food_list_item.view.*
import kotlinx.android.synthetic.main.food_list_item2.view.*
import kotlinx.android.synthetic.main.fragment_food_detail.view.*
import java.lang.Exception

val DB_NAME = "recipesdb"

fun ImageView.loadImage(url : String, progressLoad: ProgressBar){
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this)
}
@BindingAdapter("android:imageUrl","android:progressBar")
fun loadPhotoUrl(view:ImageView, url:String, pb:ProgressBar){
    view.loadImage(url,pb)
}
fun buildDB(context: Context): RecipesDatabase {
    val db = Room.databaseBuilder(context,
        RecipesDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATION_1_2)
        .build()
    return db
}


val MIGRATION_1_2 = object : Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE recipeslist ADD COLUMN isDone INTEGER DEFAULT 0 NOT NULL")
    }
}

fun createNotificationChannel(context: Context, importance: Int, showBadge:
Boolean, name: String, description: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "${context.packageName}-$name"
        val channel = NotificationChannel(channelId, name, importance)
        channel.description = description
        channel.setShowBadge(showBadge)
        val notificationManager =
            context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}