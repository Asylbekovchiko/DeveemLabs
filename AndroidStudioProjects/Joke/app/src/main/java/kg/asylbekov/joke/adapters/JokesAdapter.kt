package kg.asylbekov.joke.adapters

import android.graphics.drawable.AnimationDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kg.asylbekov.joke.R
import kg.asylbekov.joke.model.DataJokesItems

class JokesAdapter(var clickItemRecycler: ItemRecycler) :
    RecyclerView.Adapter<JokesAdapter.JokesVH>() {

    private var list = emptyList<DataJokesItems>()

    fun setJokes(list: List<DataJokesItems>) {
        this.list = list
        Log.d("ConnectionLog", "setJokes: ${list.size}")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.jokes_item, parent, false)
        return JokesVH(view)
    }

    override fun onBindViewHolder(holder: JokesVH, position: Int) {


        holder.onBind(list[position],clickItemRecycler)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class JokesVH(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(jokeItem: DataJokesItems, clickItemRecycler: ItemRecycler   ) {
            val joke = itemView.findViewById<TextView>(R.id.joke)
            val joke2 = itemView.findViewById<TextView>(R.id.joke2)

            val varconstr = itemView.findViewById<ConstraintLayout>(R.id.ca)
            val animationDrawable: AnimationDrawable = varconstr.getBackground() as AnimationDrawable;
            animationDrawable.setEnterFadeDuration(2000);
            animationDrawable.setExitFadeDuration(4000);
            animationDrawable.start();


            //val jokes = list[position]
            joke.text = jokeItem.setup
            joke2.text = jokeItem.punchline
            itemView.setOnClickListener {
                clickItemRecycler.clickRecycler(jokeItem)
            }
        }
    }
    interface ItemRecycler{
        fun clickRecycler(jokeItem: DataJokesItems)
    }

}