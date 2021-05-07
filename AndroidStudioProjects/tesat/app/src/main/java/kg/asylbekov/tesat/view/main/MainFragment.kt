package kg.asylbekov.tesat.view.main

import android.app.ActionBar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.view.iterator
import androidx.databinding.DataBindingUtil
import kg.asylbekov.tesat.R
import kg.asylbekov.tesat.databinding.FragmentMainBinding
import kg.asylbekov.tesat.model.CategoriesModel
import kg.asylbekov.tesat.model.Main
import kg.asylbekov.tesat.model.TypeOfModels
import kg.asylbekov.tesat.view.main.adapter.CategoriesAdapter
import kg.asylbekov.tesat.view.main.adapter.MainAdapter
import kg.asylbekov.tesat.view.main.adapter.TypeAdapter
class MainFragment : Fragment(), CategoriesAdapter.clickCateegories, TypeAdapter.onClickType {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: CategoriesAdapter
    private lateinit var adapterType: TypeAdapter
    private lateinit var adapterMain: MainAdapter

    private lateinit var list: ArrayList<CategoriesModel>
    private lateinit var listType: ArrayList<TypeOfModels>
    private lateinit var listMain: ArrayList<Main>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        list = ArrayList()
        listType = ArrayList()
        listMain = ArrayList()
        adapter = CategoriesAdapter(list, this)
        adapterType = TypeAdapter(listType, this)
        adapterMain = MainAdapter(listMain)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.resCategoryes.adapter = adapter
        binding.typeRec.adapter = adapterType
        binding.recyclerView.adapter = adapterMain
        binding.searchView.queryHint = "Find store by name"





        listMain.add(
            Main(
                "https://assets.website-files.com/5efb74169727e718917b6fed/602b8b743f125ca2addc5276_fastfood.jpg",
                "58 open Stores",
                "Burger Craze",
                "OPEN",
                "4.6",
                "(601)",
                "American",
                "Burgers",
                "Delivery:FREE",
                "Minimum:10$",
                "1.5km away",
                "15-20min",
                "Delivery:FREE"

            )
        )
        listMain.add(
            Main(
                "https://freshwindhotel.ru/images/catalog/images/menu/9.png",
                "",
                "Vegetarian Pizza",
                "OPEN",
                "4.6",
                "(601)",
                "Italian",
                "Burgers",
                "Delivery:FREE",
                "Minimum:10$",
                "1.5km away",
                "15-20min",
                "Delivery:FREE"
            )
        )


        list.add(CategoriesModel("Delivery"))
        list.add(CategoriesModel("PickUp"))
        list.add(CategoriesModel("Catering"))
        list.add(CategoriesModel("Curbside"))
        list.add(CategoriesModel("Curbside"))
        list.add(CategoriesModel("Curbside"))
        list.add(CategoriesModel("Curbside"))
        list.add(CategoriesModel("Curbside"))



        listType.add(
            TypeOfModels(
                "Takeaway",
                "https://22carrots.com/wp-content/uploads/2020/07/amirali-mirhashemian-UH-fIND9svQ-unsplash-1155x770.jpg"
            )
        )
        listType.add(
            TypeOfModels(
                "Grocery",
                "https://scontent.ffru9-1.fna.fbcdn.net/v/t1.6435-9/p960x960/173215511_3841740742600677_1216577823839042941_n.jpg?_nc_cat=103&ccb=1-3&_nc_sid=730e14&_nc_ohc=4i8yB8jT-qwAX9-zGxr&_nc_ht=scontent.ffru9-1.fna&tp=6&oh=09c1f320ecc225b141522de90b5f5e23&oe=60B93699"
            )
        )
        listType.add(
            TypeOfModels(
                "Convince",
                "https://scontent.ffru9-1.fna.fbcdn.net/v/t1.6435-9/121473621_701767833756880_8753318727420226737_n.jpg?_nc_cat=104&ccb=1-3&_nc_sid=973b4a&_nc_ohc=JBngpaxsCVAAX-PZQmG&_nc_ht=scontent.ffru9-1.fna&oh=241773c578a024eaacfc672dec6388a6&oe=60B6ED29"
            )
        )
        listType.add(
            TypeOfModels(
                "Pharmacy",
                "https://novyny.24tv.ua/resources/photos/news/660x371_DIR/202103/1558373.jpg?202103150940&q=65"
            )
        )
        listType.add(
            TypeOfModels(
                "MusicStore",
                "https://www.spottedbylocals.com/cologne/files/music-store-cologne-by-stephan-wehrle.jpg"
            )
        )
        listType.add(
            TypeOfModels(
                "BookShop",
                "https://offloadmedia.feverup.com/secretldn.com/wp-content/uploads/2020/11/04035636/Bookshop.jpg"
            )
        )
        listType.add(
            TypeOfModels(
                "Bakery",
                "https://i.pinimg.com/originals/57/32/f8/5732f82afbd1e250b0b6307ce63dfd4f.jpg"
            )
        )


        return binding.root
    }

    override fun clickCat() {

    }

    override fun clickType() {
    }


}