package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import kotlinx.android.synthetic.main.fragment_exit.*
import kotlin.system.exitProcess

class ExitFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnYes.setOnClickListener {
            activity?.finish()
        }
        btnNo.setOnClickListener {
            val action = ExitFragmentDirections.actionBackHome()
            Navigation.findNavController(it).navigate(action)
        }
    }
}