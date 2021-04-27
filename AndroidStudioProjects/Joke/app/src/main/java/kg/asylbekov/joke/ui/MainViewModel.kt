package kg.asylbekov.joke.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.asylbekov.joke.repo.Repo
import kg.asylbekov.joke.model.DataJokesItems

class MainViewModel() : ViewModel() {
    val repo = Repo()

    val jokes: LiveData<List<DataJokesItems>>
        get() = _jokes
    private val _jokes = MutableLiveData<List<DataJokesItems>>()

    fun getJokes(){
        repo.getJokes ({ list->
            _jokes.value = list
        },{

        })
    }

    override fun onCleared() {
        super.onCleared()
        repo.onDispose()
    }

}