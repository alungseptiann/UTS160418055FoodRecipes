package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import kotlinx.android.synthetic.main.food_list_item.view.*
import kotlinx.android.synthetic.main.food_list_item2.view.*
import kotlinx.android.synthetic.main.fragment_food_detail.view.*
import java.lang.Exception

fun ImageView.loadImage(url : String, progressLoad: ProgressBar){
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this)
}