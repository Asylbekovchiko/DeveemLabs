package kg.asylbekov.tesat.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.asylbekov.tesat.R
import kg.asylbekov.tesat.view.main.mainviewmodel.MainModel
import kotlinx.android.synthetic.main.main_items.view.*

class MainAdapter(var list: ArrayList<MainModel>) : RecyclerView.Adapter<MainAdapter.MainVH>() {

    class MainVH(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(viemodel: MainModel) {
            itemView.store_open.text = viemodel.openStores
            Glide.with(itemView.context).load(viemodel.imageUrl).centerCrop().placeholder(R.drawable.ic_launcher_background).into(itemView.image_main)
            itemView.title_main.text = viemodel.title
            itemView.status.text = viemodel.status
            itemView.stars.text = viemodel.stars
            itemView.comments.text = viemodel.comments
            itemView.type.text = viemodel.type
            itemView.food_text.text = viemodel.food
            itemView.cook_time.text = viemodel.time
            itemView.distance.text = viemodel.distance
            itemView.delivery_text.text = viemodel.delivery
            itemView.price_text.text = viemodel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.main_items, parent, false)
        return MainVH(view)
    }

    override fun onBindViewHolder(holder: MainVH, position: Int) {
        holder.onBind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }
}