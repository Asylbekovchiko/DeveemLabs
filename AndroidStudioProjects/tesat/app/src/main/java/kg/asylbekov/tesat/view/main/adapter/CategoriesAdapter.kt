package kg.asylbekov.tesat.view.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kg.asylbekov.tesat.R
import kg.asylbekov.tesat.view.main.mainviewmodel.MainViewModel
import kotlinx.android.synthetic.main.categories_item.view.*


class CategoriesAdapter(var listss: ArrayList<MainViewModel>, val clickCat: clickCateegories) : RecyclerView.Adapter<CategoriesAdapter.CategoriesVH>() {


    class CategoriesVH(val view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("ResourceAsColor")
        fun onBind(main: MainViewModel, clickCat: clickCateegories) {
            itemView.findViewById<TextView>(R.id.text_cat).text = main.name
            itemView.setOnClickListener {
                clickCat.clickCat()



            }
        }
    }

    override fun onBindViewHolder(holder: CategoriesVH, position: Int) {
        holder.onBind(listss[position], clickCat)
        var  row_index: Int = 0

//        holder.view.card.setOnClickListener()
//        row_index==position
//        notifyDataSetChanged()
//        if(row_index == position){
//            holder.view.card.setBackgroundResource(R.color.orange)
//        }else{
//
//            holder.view.card.setBackgroundResource(R.color.white)
//        }

    }

    override fun getItemCount(): Int {
        return listss.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesVH {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.categories_item,
            parent,
            false
        )
        return CategoriesVH(view)
    }
    interface clickCateegories{
        fun clickCat()
    }

}