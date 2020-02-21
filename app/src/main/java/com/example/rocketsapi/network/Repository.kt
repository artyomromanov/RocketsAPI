import com.example.rocketsapi.model.RocketsModel
import com.example.rocketsapi.network.RepositoryInterface
import com.example.rocketsapi.network.RetrofitInstance
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository :  RepositoryInterface{

    override fun returnObservable() : Observable<List<RocketsModel>>{

        return RetrofitInstance.getRetrofit()
            .getRocketsClient()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}