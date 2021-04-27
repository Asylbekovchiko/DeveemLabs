package kg.asylbekov.joke.ui

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.reactivex.Observable
import kg.asylbekov.joke.R
import kg.asylbekov.joke.adapters.JokesAdapter
import kg.asylbekov.joke.api.ApiInterface
import kg.asylbekov.joke.databinding.ActivityMainBinding
import kg.asylbekov.joke.model.DataJokesItems
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener,
    JokesAdapter.ItemRecycler {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: JokesAdapter
    private var list: List<DataJokesItems> = emptyList()
    private val viewModel: MainViewModel by viewModels()
    private lateinit var media: MediaPlayer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        media = MediaPlayer.create(this, R.raw.smeh)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.refresh.setOnRefreshListener(this)
        binding.refresh.setColorSchemeResources(R.color.purple_500)



        adapter = JokesAdapter(this)
        binding.recycler.adapter = adapter
        RecyclerAnimation.startAnimation(binding.recycler, R.anim.main_anim)
        viewModel.getJokes()
        observer()
    }

    fun observer() {
        viewModel.jokes.observe(this, Observer {
            adapter.setJokes(it)

        })
    }

    override fun onRefresh() {
        binding.refresh.isRefreshing = true
        viewModel.getJokes()
        binding.refresh.isRefreshing = false

    }

    override fun clickRecycler(jokeItem: DataJokesItems) {
        media.start()

    }
}