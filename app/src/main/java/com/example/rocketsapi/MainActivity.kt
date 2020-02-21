package com.example.rocketsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rocketsapi.recyclerview.RocketsAdapter
import com.example.rocketsapi.viewmodel.RocketsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rocketsViewModel = ViewModelProvider(this).get(RocketsViewModel::class.java)

        rocketsViewModel.getData()

        error_container.visibility = View.VISIBLE
        tv_error.text = getString(R.string.txt_loading)
        pb_progress.visibility = View.VISIBLE
        btn_retry.visibility = View.GONE

        //Set Observer on rocketsLiveData


        rocketsViewModel.rocketsLiveData.observe(this, Observer { rockets ->

            rv_rockets.adapter = RocketsAdapter(rockets)

            rv_rockets.layoutManager = LinearLayoutManager(this)

           error_container.visibility = View.GONE

        })

        //setObserver on rocketsLiveDataError

        rocketsViewModel.rocketsLiveDataError.observe(this, Observer { error ->

            if(error!=""){
                showError(error)
            }
        })

        //RadioGroup Change Listener

        radio_group.setOnCheckedChangeListener { group, checkedId ->

            error_container.visibility = View.VISIBLE
            tv_error.text = getString(R.string.txt_loading)
            pb_progress.visibility = View.VISIBLE
            btn_retry.visibility = View.GONE

        rocketsViewModel.getData(checkedId == R.id.rbtn_active)

        }

        //RetryButton listener

        btn_retry.setOnClickListener {

            rocketsViewModel.getData(radio_group.checkedRadioButtonId == R.id.rbtn_active)

            tv_error.text = getString(R.string.txt_loading)
            pb_progress.visibility = View.VISIBLE
            btn_retry.visibility = View.GONE


        }

    }

   private fun showError(error : String){

       error_container.visibility = View.VISIBLE
       tv_error.text = error
       pb_progress.visibility = View.GONE
       btn_retry.visibility = View.VISIBLE

   }

}
