package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import kotlinx.android.synthetic.main.fragment_contact_us.*

class ContactUsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_us, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnGmail.setOnClickListener {
            val intentEmail = Intent(Intent.ACTION_SEND).apply {
                setData(Uri.parse("mailto:"))
                setType("text/plain")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("foodrecipes@unit.ubaya.ac.id"))
                putExtra(Intent.EXTRA_SUBJECT,"LAPORAN MASALAH DI APLIKASI")
                putExtra(Intent.EXTRA_TEXT, "Ada bug di aplikasi Food Recipes")
            }
            startActivity(Intent.createChooser(intentEmail, "Send My Text"))
        }
        btnWa.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_VIEW)
            sendIntent.data = Uri.parse("https://api.whatsapp.com/send?phone=${"+62" + PackageManager.GET_META_DATA}&text=Saya memiliki sedikit masalah di aplikasi!")

            val shareIntent = Intent.createChooser(sendIntent, "Send My Text")
            startActivity(shareIntent)
        }
    }
}