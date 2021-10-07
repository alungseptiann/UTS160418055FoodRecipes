package id.ac.ubaya.informatika.a160418055_septian_foodrecipes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import id.ac.ubaya.informatika.a160418055_septian_foodrecipes.model.RecipesList

class ListViewModel(application: Application): AndroidViewModel(application) {
    val recipesLD = MutableLiveData<List<RecipesList>>()
    val recipesLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val recipesLD2 = MutableLiveData<List<RecipesList>>()
    val recipesLoadErrorLD2 = MutableLiveData<Boolean>()
    val loadingLD2 = MutableLiveData<Boolean>()


    fun refresh() {
        val food1 = RecipesList(
            "Rujak Bali",
                "https://cdn-2.tstatic.net/bali/foto/bank/images/menikmati-rujak-khas-bali-yang-menggoyang-lidah-dan-menarik.jpg",
            "Rujak ini buatan terenak ku",
                "BALI",
            "2 Orang",
            "30 Menit",
            "1. Buah-Buahan \n"+
                            "2. Kacang Tanah",
            "1. Siapkan Alat bahan \n" +
                            "2. Potong Buah \n" +
                            "3. Bikin"
        )
        val food2 = RecipesList(
                "Beef Steak USA",
                "https://www.avcj.com/IMG/799/18799/beef-usa-meat-580x358.jpeg?1500864147",
                "Beef Steak Terwuenaakkk",
                "USA",
                "1 Orang",
                "45  Menit",
                "1. Garam \n" +
                        "2. Lada hitam \n" +
                        "3. Daging Sapi Tenderloin",
                "1. Siapkan Alat Bahan \n"+
                        "2. Campur bumbu dengan Daging\n"+
                        "3. Panggang pakai mentega\n"
        )
        val food3 = RecipesList(
                "ShortPlate Steak Indonesia",
                "https://cf.shopee.co.id/file/00ca0c407c68d6bde549f6e8e7b2c7a4",
                "ShortPlate Steak Terwuenaakkk",
                "Indonesia",
                "1 Orang",
                "45  Menit",
                "1. Garam\n" +
                        "2. Lada hitam\n" +
                        "3. Daging Sapi Tenderloin\n",
                "1. Siapkan Alat Bahan\n"+
                        "2. Campur bumbu dengan Daging\n"+
                        "3. Panggang pakai mentega\n"
        )
        val food7 = RecipesList(
                "Spaghetti Carbonara Indonesia",
                "https://www.resepkuerenyah.com/wp-content/uploads/2020/12/Resep-Spageti-Carbonara.jpg",
                "Spaghetti Carbonara Terwuenaakkk",
                "Indonesia",
                "Porsi : 1 Orang",
                "Waktu Memasak : 45  Menit",
                "Bahan Memasak : \n"+
                        "1. Pasta spageti mentah sebanyak 200 gram\n" +
                        "2. Margarin atau mentega sebanyak 1 sendok makan\n" +
                        "3. Bawang bombay sebanyak ½ buah\n" +
                        "4. Bawang putih sebanyak 3 siung\n" +
                        "5. Daging asap sebanyak 6 lembar\n" +
                        "6. Susu cair full cream sebanyak 300 ml\n" +
                        "7. Keju cheddar parut sebanyak ½ kotak\n" +
                        "8. Tepung maizena sebanyak 1 sendok teh\n" +
                        "9. Merica halus sebanyak 1 sendok teh\n" +
                        "10. Garam halus sebanyak 1 sendok teh\n" +
                        "11. Parsley\n" +
                        "12. Keju cheddar parut",
                "Langkah Memasak : \n"+
                        "1. Masak air hingga mendidih, lalu rebus pasta hingga al dente atau matang-nya pas dan tidak terlalu lembek. Agar pasta tidak melekat satu sama lain, tambahkan sedikit margarin atau minyak goreng saat merebus pasta. Setelah matang, angkat pasta dan tiriskan.\n" +
                        "2. Potong-potong bawang bombay dengan ukuran kecil-kecil. Lalu cincang bawang putih kemudian disisihkan.\n" +
                        "3. Potong-potong pula daging asap dengan bentuk memanjang.\n" +
                        "4. Siapkan wajan, lalu leleh-kan margarin. Masukkan bawang bombay dan bawang putih, tumis kedua bahan tersebut hingga mengeluarkan aroma harum.\n" +
                        "5. Tambahkan daging asap yang telah dipotong-potong, keju cheddar parut, dan tuang susu cair. Aduk-aduk hingga rata.\n" +
                        "6. Jika keju parut telah larut dan susu mendidih, tambahkan tepung maizena yang telah dilarutkan dengan sedikit air. Aduk hingga rata.\n" +
                        "7. Beri perasa seperti merica halus dan garam. Sesuaikan rasanya dengan selera Anda. Lanjutkan memasak hingga saus carbonara menjadi kental tekstur-nya.\n" +
                        "8. Masukkan pasta yang telah matang ke dalam saus carbonara. Aduk-aduk hingga pasta tercampur rata dengan saus carbonara.\n" +
                        "9. Beri taburan berupa parsley dan keju cheddar parut.\n" +
                        "10. Spageti carbonara siap untuk disantap."
        )
        val food10 = RecipesList(
                "Takoyaki Khas Jepang",
                "https://www.resepkuerenyah.com/wp-content/uploads/2015/09/Resep-Membuat-Takoyaki-Khas-Jepang-Enak-Lezat.jpg",
                "Makanan Jepang memang memiliki rasa yang enak dan juga menggugah selera. Tak hanya untuk jenis masakan berat saja, berbagai camilan khas Jepang juga banyak disukai oleh warga dunia termasuk juga orang Indonesia.",
                "Jepang",
                "Porsi : 3 Orang",
                "Waktu Memasak : 2 Jam 30  Menit",
                "Bahan Memasak : \n"+
                        "Minyak salad 1 sendok makan, untuk mengoles\n" +
                        "Kuning telur 2 buah\n" +
                        "Tepung terigu dengan protein sedang 200 gram\n" +
                        "Baking powder 1/2 sendok teh\n" +
                        "Garam 1/4 sendok teh\n" +
                        "Putih telur 1 buah\n" +
                        "Kaldu ikan 400 ml\n" +
                        "Bahan Isi:\n" +
                        "\n" +
                        "Bahan Isi : \n"+
                        "Kol 25 gram, iris dengan tipis\n" +
                        "Cumi kupas 125 gram, rebus dan potong dadu 1 cm\n" +
                        "Jahe 25 gram, cincang\n" +
                        "Daun bawang 25 gram, iris sampai halus\n" +
                        "Bahan pelengkap:\n" +
                        "\n" +
                        "Bahan Pelengkap : \n"+
                        "Katsuo 5 gram\n" +
                        "Mayones 100 gram\n" +
                        "Saus takoyaki 100 gram",
                "Langkah Memasak : \n"+
                        "1. Pertama-tama kocok telur dengan lepas kemudian masukkan kaldu secara perlahan dan aduk kembali hingga merata.\n" +
                        "2. Setelah itu masukkan tepung terigu, garam dan juga baking powder dalam adonan. Aduk kembali hingga semua bahan merata.\n" +
                        "3. Berikutnya panaskan cetakan untuk poffertes oleskan pula minyak salad pada cetakan. Setelah itu, tuangkan adonan takoyaki yang sebelumnya sudah dibuat hingga memenuhi cetakan.\n" +
                        "4. Masukkan kol, cumi, jahe cincang dan juga daun bawang dalam cetakan. Setelah itu, terus panggang hingga bagian tepi takoyaki memiliki kulit.\n" +
                        "5. Terus bolak balik adonan hingga membentuk bola dan terus panggang hingga takoyaki menjadi matang dengan sempurna.\n" +
                        "6. Terakhir tinggal Anda sajikan takoyaki bersama dengan bahan pelengkap yang sudah disiapkan."
        )
        val food12 = RecipesList(
            "Mie Pangsit Ujung Pandang",
            "https://i.ytimg.com/vi/lrjuMcm3CrU/maxresdefault.jpg",
            "Cara Membuat Resep Mie Pangsit Yang Lezat Dan Enak., Semua orang pasti sudah banyak yang tahu kenikmatan dari semangkuk mie, mie tersebut adalah mie pangsit yang sungguh menguggah kenikmatan rasa bagi warga di indonesia.",
            "Ujung Pandang",
            "Porsi : 1 Orang",
            "Waktu Memasak : 1 Jam 15  Menit",
            "Bahan Memasak : \n"+
                    "Mie pangsit 250 gr\n" +
                    "Bawang putih 3 butir\n" +
                    "Serre 4 batang\n" +
                    "Daun bawang 200 gr\n" +
                    "Krupuk pangsit\n" +
                    "Sawi hijau\n" +
                    "Air setengah liter\n" +
                    "Pala 1 buah\n" +
                    "Ayam potong kecil 250 gr\n" +
                    "Minyak wijen 2 sendok teh\n" +
                    "Garam, gula merah secukupnya\n" +
                    "Jari jahe 2 ruas\n" +
                    "Bawang merah 3 butir\n" +
                    "Ketumbar 1 sendok teh\n" +
                    "Ketumbar ½ sendok teh\n" +
                    "Daun salam 3 lembar\n" +
                    "Kaldu ayam\n" +
                    "Daun jeruk 3 lembar\n" +
                    "Kemiri 4 butir",
            "Langkah Memasak : \n"+
                    "1. Ambil daging ayamnya\n" +
                    "\n" +
                    "2. Cuci sampai bersih\n" +
                    "\n" +
                    "3. Lalu potong kecil – kecil\n" +
                    "\n" +
                    "4. Setelah itu potong daun bawangnya\n" +
                    "\n" +
                    "5. Lalu haluskan bumbu bawang putting, merah, pala, merica, kemiri dan juga jahe\n" +
                    "\n" +
                    "6. Kemudian tumis sampai harum\n" +
                    "\n" +
                    "7. Setelah itu tmabahkan sedikit air\n" +
                    "\n" +
                    "8. Kemudian tambahkan juga ayam, daun salam, daun bawang, serei, garam, dan juga jeruk\n" +
                    "\n" +
                    "9. Pastikan proses ini sampai airnya berkurang\n" +
                    "\n" +
                    "10. Masak mienya lalu sawinya juga, setelah itu angksat dan tiriskan\n" +
                    "\n" +
                    "11. Setelah itu mienya tuangkan ke dalam mangkok\n" +
                    "\n" +
                    "12. Kasih minyak wijen dan aduk sampai merata\n" +
                    "\n" +
                    "13. Kasih kuahnya dan krupuk\n" +
                    "\n" +
                    "14. Mie ayam siap dimakan."
        )



        val foodList: ArrayList<RecipesList> = arrayListOf<RecipesList>(food1, food2, food3, food7,food10,food12)
        recipesLD.value = foodList
        recipesLoadErrorLD.value = false
        loadingLD.value = false

    }
    fun refresh2(){
        val food4 = RecipesList(
                "Rujak",
                "https://cdn1-production-images-kly.akamaized.net/WRcmBKaqqCGqSs_xYUOXH7zq5G8=/640x480/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/860464/original/002527900_1429846679-Rujak.jpg",
                "Rujak ini buatan terenak ku",
                "Nusa Tenggara Barat",
                "2 Orang",
                "30 Menit",
                "1. Buah-Buahan \n" +
                        "2. Kacang Tanah",
                "1. Siapkan Alat bahan \n" +
                        "2. Potong Buah \n" +
                        "3. Bikin"
        )
        val food5 = RecipesList(
                "Beef Steak",
                "https://cdn0-production-images-kly.akamaized.net/UBsiiHg-xuCWgbfOQ6MBDwjf-7w=/673x379/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/2473554/original/052037200_1543293317-resep-beef-steak-ala-restoran.jpg",
                "Beef Steak Terwuenaakkk",
                "Jawa Timur",
                "1 Orang",
                "45  Menit",
                "1. Garam\n" +
                        "2. Lada hitam\n" +
                        "3. Daging Sapi Tenderloin",
                "1. Siapkan Alat Bahan\n"+
                        "2. Campur bumbu dengan Daging\n"+
                        "3. Panggang pakai mentega"
        )
        val food6 = RecipesList(
                "ShortPlate Steak",
                "https://img-global.cpcdn.com/recipes/510db3ef524859b0/751x532cq70/beef-slice-ala-yoshinoya-foto-resep-utama.jpg",
                "ShortPlate Steak Terwuenaakkk",
                "Italia",
                "1 Orang",
                "45  Menit",
                "1. Garam\n" +
                        "2. Lada hitam\n" +
                        "3. Daging Sapi Tenderloin",
                "1. Siapkan Alat Bahan\n"+
                        "2. Campur bumbu dengan Daging\n"+
                        "3. Panggang pakai mentega\n"
        )
        val food8 = RecipesList(
                "Spaghetti Carbonara Italia",
                "https://piknikdong.com/wp-content/uploads/2020/06/Resep-Spaghetti-Carbonara.jpg",
                "Spaghetti Carbonara Terwuenaakkk di Italia",
                "Italia",
                "Porsi : 2 Orang",
                "Waktu Memasak : 1 Jam 30  Menit",
                "Bahan Memasak : \n"+
                        "1. Pasta spageti mentah sebanyak 200 gram\n" +
                        "2. Margarin atau mentega sebanyak 1 sendok makan\n" +
                        "3. Bawang bombay sebanyak ½ buah\n" +
                        "4. Bawang putih sebanyak 3 siung\n" +
                        "5. Daging asap sebanyak 6 lembar\n" +
                        "6. Susu cair full cream sebanyak 300 ml\n" +
                        "7. Keju cheddar parut sebanyak ½ kotak\n" +
                        "8. Tepung maizena sebanyak 1 sendok teh\n" +
                        "9. Merica halus sebanyak 1 sendok teh\n" +
                        "10. Garam halus sebanyak 1 sendok teh\n" +
                        "11. Parsley\n" +
                        "12. Keju cheddar parut",
                "Langkah Memasak : \n"+
                        "1. Masak air hingga mendidih, lalu rebus pasta hingga al dente atau matang-nya pas dan tidak terlalu lembek. Agar pasta tidak melekat satu sama lain, tambahkan sedikit margarin atau minyak goreng saat merebus pasta. Setelah matang, angkat pasta dan tiriskan.\n" +
                        "2. Potong-potong bawang bombay dengan ukuran kecil-kecil. Lalu cincang bawang putih kemudian disisihkan.\n" +
                        "3. Potong-potong pula daging asap dengan bentuk memanjang.\n" +
                        "4. Siapkan wajan, lalu leleh-kan margarin. Masukkan bawang bombay dan bawang putih, tumis kedua bahan tersebut hingga mengeluarkan aroma harum.\n" +
                        "5. Tambahkan daging asap yang telah dipotong-potong, keju cheddar parut, dan tuang susu cair. Aduk-aduk hingga rata.\n" +
                        "6. Jika keju parut telah larut dan susu mendidih, tambahkan tepung maizena yang telah dilarutkan dengan sedikit air. Aduk hingga rata.\n" +
                        "7. Beri perasa seperti merica halus dan garam. Sesuaikan rasanya dengan selera Anda. Lanjutkan memasak hingga saus carbonara menjadi kental tekstur-nya.\n" +
                        "8. Masukkan pasta yang telah matang ke dalam saus carbonara. Aduk-aduk hingga pasta tercampur rata dengan saus carbonara.\n" +
                        "9. Beri taburan berupa parsley dan keju cheddar parut.\n" +
                        "10. Spageti carbonara siap untuk disantap."
        )
        val food9 = RecipesList(
                "Kimbab ala Korea",
                "https://www.resepkuerenyah.com/wp-content/uploads/2021/05/Kimbab-Korea-setelah-dipotong-dan-ditaburi-wijen.jpg",
                "Saat ini, banyak orang Indonesia yang menyukai berbagai masakan khas Negeri Ginseng, salah satunya kimbab.Bahan-bahan dan cara membuat kimbab ala Korea cukup mudah sehingga menarik untuk dicoba.\n" +
                        "\n" +
                        "Sekilas, kimbab mirip dengan sushi, yaitu berupa nasi yang dibungkus rumput laut dengan isian yang bervariasi. Bedanya, kimbab tidak menggunakan cuka seperti sushi, tetapi minyak wijen.\n" +
                        "\n" +
                        "Jika kamu termasuk penggemar makanan ini, tidak ada salahnya belajar cara membuat kimbab ala Korea sendiri. Selain lebih hemat, isiannya bisa disesuaikan dengan seleramu.",
                "Korea",
                "Porsi : 2 Orang",
                "Waktu Memasak : 1 Jam 30  Menit",
                "Bahan Memasak : \n"+
                        "1 ikat bayam (rebus sebentar, bilas air dingin, dan tiriskan)\n" +
                        "1 wortel besar (kupas dan potong korek api)\n" +
                        "3 butir telur ayam\n" +
                        "1 piring atau 4 cangkir nasi hangat\n" +
                        "3 siung bawang putih\n" +
                        "5 lembar nori\n" +
                        "5 potong acar lobak kuning\n" +
                        "200 gram daging sapi (buang bagian lemak dan iris tipis)\n" +
                        "2 ½ sdm. minyak wijen\n" +
                        "2 sdt. kecap asin\n" +
                        "1 ¼ sdm. gula pasir\n" +
                        "1 ½ sdt. garam\n" +
                        "¼ sdt. merica hitam bubuk\n" +
                        "minyak secukupnya",
                "Langkah Memasak : \n"+
                        "1.Taruh nasi hangat di wadah yang ceper. Campur dengan 2 sendok teh minyak wijen dan ½ sendok teh garam menggunakan centong. Tunggu hingga uap hilang.\n" +
                        "2. Tambahkan ¼ sendok teh garam ke wortel yang sudah dipotong. Aduk rata dan diamkan selama 5–10 menit. Tujuannya untuk mengeluarkan cairan dari sayuran.\n" +
                        "3. Buang air, lalu tumis wortel dengan sedikit minyak sayur selama sekitar 1 menit. Selanjutnya, letakkan tumisan tersebut di piring.\n" +
                        "4. Campur bayam dengan ½ sendok teh garam, 2 siung bawang putih yang sudah dicincang, dan 2 sendok teh minyak wijen memakai tangan. Tata di piring.\n" +
                        "5. Taruh daging sapi iris di mangkuk. Bumbui dengan 1 siung bawang putih yang dicincang, 1 ¼ sdm gula pasir, 2 sdt kecap asin, 2 sdt minyak wijen, dan merica hitam bubuk.\n" +
                        "6. Marinasi selama 10 menit, kemudian masak sampai matang.\n" +
                        "7. Pecahkan telur di mangkuk, kemudian tambahkan ¼ sendok teh garam. Kocok dengan garpu dan buat dadar tipis.\n" +
                        "8. Pastikan warna telur dadar tidak terlalu coklat, lalu potong-potong memanjang.\n" +
                        "9. Taruh nori di atas tikar penggulung kimbab. Ratakan nasi di atasnya. Susun sayuran, daging sapi, acar lobak kuning, dan telur dadar iris.\n" +
                        "10. Gulung secara perlahan sambil sedikit ditekan. Olesi nori dengan sisa minyak wijen. Potong-potong dan kimbab siap disajikan."
        )
        val food11 = RecipesList(
            "Mie Pangsit Makassar",
            "https://img-global.cpcdn.com/recipes/9c1e326492f2ac82/751x532cq70/mie-pangsit-kuah-foto-resep-utama.jpg",
            "Cara Membuat Resep Mie Pangsit Yang Lezat Dan Enak., Semua orang pasti sudah banyak yang tahu kenikmatan dari semangkuk mie, mie tersebut adalah mie pangsit yang sungguh menguggah kenikmatan rasa bagi warga di indonesia.",
            "Makassar",
            "Porsi : 2 Orang",
            "Waktu Memasak : 1 Jam 55  Menit",
            "Bahan Memasak : \n"+
                    "Mie pangsit 250 gr\n" +
                    "Bawang putih 3 butir\n" +
                    "Serre 4 batang\n" +
                    "Daun bawang 200 gr\n" +
                    "Krupuk pangsit\n" +
                    "Sawi hijau\n" +
                    "Air setengah liter\n" +
                    "Pala 1 buah\n" +
                    "Ayam potong kecil 250 gr\n" +
                    "Minyak wijen 2 sendok teh\n" +
                    "Garam, gula merah secukupnya\n" +
                    "Jari jahe 2 ruas\n" +
                    "Bawang merah 3 butir\n" +
                    "Ketumbar 1 sendok teh\n" +
                    "Ketumbar ½ sendok teh\n" +
                    "Daun salam 3 lembar\n" +
                    "Kaldu ayam\n" +
                    "Daun jeruk 3 lembar\n" +
                    "Kemiri 4 butir",
            "Langkah Memasak : \n"+
                    "1. Ambil daging ayamnya\n" +
                    "\n" +
                    "2. Cuci sampai bersih\n" +
                    "\n" +
                    "3. Lalu potong kecil – kecil\n" +
                    "\n" +
                    "4. Setelah itu potong daun bawangnya\n" +
                    "\n" +
                    "5. Lalu haluskan bumbu bawang putting, merah, pala, merica, kemiri dan juga jahe\n" +
                    "\n" +
                    "6. Kemudian tumis sampai harum\n" +
                    "\n" +
                    "7. Setelah itu tmabahkan sedikit air\n" +
                    "\n" +
                    "8. Kemudian tambahkan juga ayam, daun salam, daun bawang, serei, garam, dan juga jeruk\n" +
                    "\n" +
                    "9. Pastikan proses ini sampai airnya berkurang\n" +
                    "\n" +
                    "10. Masak mienya lalu sawinya juga, setelah itu angksat dan tiriskan\n" +
                    "\n" +
                    "11. Setelah itu mienya tuangkan ke dalam mangkok\n" +
                    "\n" +
                    "12. Kasih minyak wijen dan aduk sampai merata\n" +
                    "\n" +
                    "13. Kasih kuahnya dan krupuk\n" +
                    "\n" +
                    "14. Mie ayam siap dimakan."
        )

        val foodList2: ArrayList<RecipesList> = arrayListOf<RecipesList>(food4, food5, food6, food8, food9,food11)
        recipesLD2.value = foodList2
        recipesLoadErrorLD2.value = false
        loadingLD2.value = false
    }
}