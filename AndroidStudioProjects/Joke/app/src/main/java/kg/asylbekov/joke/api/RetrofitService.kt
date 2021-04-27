import io.reactivex.schedulers.Schedulers
import kg.asylbekov.joke.api.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

   object RetrofitService {


    private val logger = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }


    private val okHttp: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logger)


    private val retrofitBuilderrr: Retrofit.Builder =
        Retrofit.Builder().baseUrl("https://official-joke-api.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))


    private val retrofit: Retrofit = retrofitBuilderrr.build()

    fun <T> builService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

}