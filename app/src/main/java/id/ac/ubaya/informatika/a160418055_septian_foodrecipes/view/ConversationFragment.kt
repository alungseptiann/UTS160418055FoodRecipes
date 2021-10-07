package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel.ListViewModel
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel.LiveChatModel
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.conversation_items_fragment.*
import kotlinx.android.synthetic.main.fragment_conversation.*
import kotlinx.android.synthetic.main.fragment_food_list.*

class ConversationFragment : Fragment() {
    private lateinit var viewModel:LiveChatModel
    private val chatAdapter = ChatAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_conversation, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LiveChatModel::class.java)
        viewModel.chat()


        recViewConversation.layoutManager = LinearLayoutManager(context)
        recViewConversation.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recViewConversation.adapter = chatAdapter

        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.chatLD.observe(viewLifecycleOwner, Observer {
            chatAdapter.updateChatList(it)
        })

        viewModel.loadingchatLD.observe(viewLifecycleOwner, Observer {
            if(it){
                recViewConversation.visibility = View.GONE
            }else{
                recViewConversation.visibility = View.VISIBLE
            }
        })
    }
}
