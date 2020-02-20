import com.example.rocketsapi.BASE_URL
import com.example.rocketsapi.model.RocketsModel
import com.example.rocketsapi.network.Client
import com.example.rocketsapi.network.NetworkClientInterface
import com.example.rocketsapi.network.RepositoryInterface
import com.example.rocketsapi.network.RetrofitInstance
import com.example.rocketsapi.presenter.PresenterContract
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class NetworkClient :   RepositoryInterface{

    override fun returnObservable() : Observable<List<RocketsModel>>{

        return RetrofitInstance.getRetrofit()
            .getRocketsClient()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}