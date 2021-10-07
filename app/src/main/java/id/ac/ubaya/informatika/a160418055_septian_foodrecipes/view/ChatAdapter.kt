package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.ItemChat
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.util.loadImage
import kotlinx.android.synthetic.main.conversation_items_fragment.view.*
import kotlinx.android.synthetic.main.fragment_conversation.view.*
import kotlinx.android.synthetic.main.fragment_food_list.*
import kotlinx.android.synthetic.main.fragment_food_list.view.*

class ChatAdapter(val chatList:ArrayList<ItemChat>) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>(){
    class ChatViewHolder(var view: View): RecyclerView.ViewHolder(view)

    fun updateChatList(newChatList: List<ItemChat>){
        chatList.clear()
        chatList.addAll(newChatList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.conversation_items_fragment, parent, false)
        return ChatViewHolder(v)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.view.username.text = chatList[position].username
        holder.view.status.text = chatList[position].status
        holder.view.time.text = chatList[position].time
        Picasso.get()
                .load(chatList[position].image.toString())
                .resize(400, 400)
                .centerCrop()
                .error(R.drawable.ic_baseline_error_24)
                .into(holder.view.image)
    }
}