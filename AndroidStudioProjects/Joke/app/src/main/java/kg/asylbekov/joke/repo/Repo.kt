package kg.asylbekov.joke.repo

import RetrofitService
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kg.asylbekov.joke.api.ApiInterface
import kg.asylbekov.joke.model.DataJokesItems

class Repo() {

    private val subscriptions = CompositeDisposable()

    fun getJokes(onSuccess: (List<DataJokesItems>) -> Unit, onFailure: (String) -> Unit) {
        val api = RetrofitService.builService(ApiInterface::class.java)
        Log.d("ConnectionLog", "getJokes: init")
        subscriptions.add(
            api.getJokes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ answer ->
                    Log.d("ConnectionLog", "getJokes: onResponse")
                    if (answer.isSuccessful) {
                        Log.d("ConnectionLog", "getJokes: Success")
                        answer.body()?.let {
                            onSuccess(it)
                        } ?: onSuccess(emptyList())
                    } else {
                        onFailure("Error connection")
                        Log.d("ConnectionLog", "getJokes: Fail")
                    }

                }, {
                    onFailure(it.localizedMessage)
                    it.printStackTrace()
                    Log.d("ConnectionLog", "getJokes: ERROR  ${it.localizedMessage}")
                })
        )
    }

    fun onDispose() {
        subscriptions.clear()
        subscriptions.dispose()
    }
}