import com.example.rocketsapi.PresenterContract
import com.example.rocketsapi.RocketsModel
import com.example.rocketsapi.ViewInterface

class Presenter(private var viewInterface : ViewInterface?) : PresenterContract.View,
    PresenterContract.Network {

    private val networkClient = NetworkClient(this)

    override fun getData(active : Boolean) {

        networkClient.retrieveData(active)

    }

    override fun callSuccess(rocketsList : List<RocketsModel>) {

        viewInterface?.displayData(rocketsList)

    }

    override fun callFailure(t: Throwable) {
        viewInterface?.showError(t)
    }

    override fun onDestroyCalled() {

        viewInterface = null //erase the link to the activity

        networkClient.onDestroyCalled() //pass the information to the network client that activity is being destroyed

    }

}

