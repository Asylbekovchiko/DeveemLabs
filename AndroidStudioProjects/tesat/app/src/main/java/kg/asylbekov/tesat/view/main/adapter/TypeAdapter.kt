package kg.asylbekov.tesat.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.asylbekov.tesat.R
import kg.asylbekov.tesat.model.TypeOfModels
import kotlinx.android.synthetic.main.type_items.view.*

class TypeAdapter (var list: ArrayList<TypeOfModels>, val click: onClickType): RecyclerView.Adapter<TypeAdapter.TypeVH>(){

    class TypeVH(view: View) : RecyclerView.ViewHolder(view){
        fun onBind(model: TypeOfModels, onClickType: onClickType){
            itemView.title_te.text = model.title
            Glide.with(itemView.context).load(model.imageUrl).centerCrop().into(itemView.circle_images)
            itemView.setOnClickListener {
                onClickType.clickType()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeVH {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.type_items, parent, false)
        return TypeVH(view)
    }

    override fun onBindViewHolder(holder: TypeVH, position: Int) {
    holder.onBind(list[position], click)

    }

    override fun getItemCount(): Int {
    return list.size
    }
    interface onClickType{
        fun clickType()
    }
}
