package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.R
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.ItemChat
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList

class LiveChatModel (application: Application): AndroidViewModel(application) {
    val chatLD = MutableLiveData<List<ItemChat>>()
    val chatLoadErrorLD = MutableLiveData<Boolean>()
    val loadingchatLD = MutableLiveData<Boolean>()


    fun chat(){
        val itemChat1 = ItemChat(
            "Peter", "Nice To Meet You Tan!","10.30", "http://www.unkrista.id/wp-content/uploads/2020/05/final-1.png"
        )
        val itemChat2 = ItemChat(
            "Lala", "Hello i'm Lala","11.15", "https://64.media.tumblr.com/20d591f309b7ba315e005424dbd7b22d/tumblr_phdsh6myEy1wjvrgbo1_400.png"
        )
        val itemChat3 = ItemChat(
            "Stephanie", "Stephanie want you!","Yesterday", "https://www.mockofun.com/wp-content/uploads/2019/12/circle-profile-pic.jpg"
        )
        val itemChat4 = ItemChat(
            "Lisa", "Lisa come to mall!","Yesterday", "https://i.pinimg.com/736x/73/e8/21/73e82119845b4432f4e06515d1337521.jpg"
        )
        val itemChat5 = ItemChat(
            "Jennie", "Jennie going to park!","02/02/2021", "https://www.pngarea.com/pngm/53/6195326_vevo-png-girls-profile-picture-circle-transparent-png.png"
        )
        val itemChat6 = ItemChat(
            "Rose", "let's play MLBB!","06/06/2021", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzbSU9WqmP3RHsCGc1dHG1ImzLUtrftoOqlvy2B5oEzr0q__c5jbp-d2QSHktESmZtsEA&usqp=CAU"
        )
        val itemChat7 = ItemChat(
            "Brian", "i'm bored bro!","18.39", "https://www.pngkit.com/png/full/137-1379092_sasha-headshot-circle.png"
        )
        val itemChat8 = ItemChat(
            "Thanos", "you wat to make a joke?!","19.35", "https://sidestream.media/wp-content/uploads/2018/05/Headshot-Circle.jpg"
        )
        val itemChat9 = ItemChat(
            "Grace", "Grace love you so much!","21.00", "https://i2.wp.com/laurakokkarinen.com/wp-content/uploads/2017/09/cropped-profile-circle.png?fit=512%2C512&ssl=1"
        )
        val itemChat10 = ItemChat(
            "Kevin", "Tan, can i borrow your money?","11.11", "https://cdn.shopify.com/s/files/1/0406/5879/6708/t/2/assets/pf-6d60a0b6--LucasHeadshotforEmail.png?v=1602468829"
        )
        val itemChat11 = ItemChat(
            "Jisoo", "Jisoo want to find someone else!","11.23", "https://www.pngkit.com/png/full/41-410311_-kim-jisoo-layouts-packs-blackpink-kim-jisoo.png"
        )
        val itemChat12 = ItemChat(
            "Merry", "i have a good dog!","12.55", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQX0uvrfn-p7Ed2iIM2VczjPWF6WNcb8v5NAyubu_HM1I2ulJTn9QAKUVFB6v8wyUOTC1w&usqp=CAU"
        )
        val itemChat13 = ItemChat(
            "Jocelyn", "Shutup!","13.34", "https://images.squarespace-cdn.com/content/v1/56dfed9140261de4b233f96d/1530872035368-O2EWL8VVTKD91WX8DTFG/Laurence-Fornari-Portrait-Circle.png"
        )
        val itemChat14 = ItemChat(
            "Joelyn", "OMG it's so beautiful!!","22.53", "https://www.pngfind.com/pngs/m/69-692697_paige-face-circle-face-in-a-circle-hd.png"
        )
        val itemChat15 = ItemChat(
            "Kagura", "Try hard baby!","Yesterday", "https://www.seekpng.com/png/detail/627-6279537_circle-invest-welcomes-monero-portrait-circle.png"
        )
        val itemChat16 = ItemChat(
            "TinTin", "Miss you babe!","Yesterday", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtctrQPphKicBXFBxGsqVx4ng8PIaRpX0KNzuw3Dxvmze_zqU1KOVyWZkitb5x7g33PCE&usqp=CAU"
        )
        val itemChat17 = ItemChat(
            "Christine", "i want to buy some drink","27/11/2020", "http://www.carriebloomston.com/wp-content/uploads/2015/10/Portrait-resized-circle.png"
        )
        val itemChat18 = ItemChat(
            "Sheiren", "i want to buy some snacks!","11/2/2019", "https://www.pngjoy.com/pngm/51/1153241_girl-face-headshot-circles-02-hd-png-download.png"
        )
        val itemChat19 = ItemChat(
            "Agnes", "i'm hungry, lets go out!","Yesterday", "https://w7.pngwing.com/pngs/143/442/png-transparent-yoon-bomi-apink-hush-k-pop-others-face-black-hair-circle-logo.png"
        )
        val itemChat20 = ItemChat(
            "Cath", "Want to have a date with me?","23.35", "https://i.pinimg.com/564x/e0/d1/17/e0d117dee1d89040822250376b1aa281.jpg"
        )
        val chatList: ArrayList<ItemChat> = arrayListOf<ItemChat>(itemChat1, itemChat2, itemChat3, itemChat4,
            itemChat5, itemChat6, itemChat7, itemChat8, itemChat9, itemChat10, itemChat11, itemChat12,
            itemChat13, itemChat14, itemChat15, itemChat16, itemChat17, itemChat18, itemChat19, itemChat20)
        chatLD.value = chatList
        chatLoadErrorLD.value = false
        loadingchatLD.value = false
    }
}