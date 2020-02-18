import com.example.rocketsapi.BASE_URL
import com.example.rocketsapi.Client
import com.example.rocketsapi.NetworkClientInterface
import com.example.rocketsapi.PresenterContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient(private val presenter: PresenterContract.Network) : NetworkClientInterface {

    private val compositeDisposable = CompositeDisposable()

    override fun retrieveData(active : Boolean) {

                when(active){

                   true -> {

                       val observable = getRetrofit().getRocketsClient()

                       compositeDisposable.add( //Observable.subscribe() returns a disposable

                           observable
                               .subscribeOn(Schedulers.io())
                               .map{rocketList -> rocketList.filter { rocket -> rocket.active} }
                               .observeOn(AndroidSchedulers.mainThread())
                               .subscribe({ rockets -> presenter.callSuccess(rockets) },
                                   { error -> presenter.callFailure(error) }))
                   }

                    false -> {

                        val observable = getRetrofit().getRocketsClient()

                        compositeDisposable.add( //Observable.subscribe() returns a disposable

                            observable
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe({ rockets -> presenter.callSuccess(rockets) },
                                    { error -> presenter.callFailure(error) }))

                    }
                }
            }

    override fun onDestroyCalled() {

        compositeDisposable.clear()  //clear the disposable links

    }


    private fun getRetrofit() = Retrofit

        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build())
        .build()
        .create(Client::class.java)

}