package kg.asylbekov.joke.api

import kg.asylbekov.joke.model.DataJokesItems
import retrofit2.Response
import retrofit2.http.GET
import io.reactivex.Observable


interface ApiInterface {
@GET("random_ten")
fun getJokes():Observable<Response<List<DataJokesItems>>>
}