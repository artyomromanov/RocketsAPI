package com.example.rocketsapi

import Presenter
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewInterface {

    var isActive : Boolean = false

    val TAG = "MainActivity"

    private val presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_rockets.layoutManager = LinearLayoutManager(this)

        presenter.getData(false)

        rbtn_active.setOnClickListener {

            onRadioButtonClicked(rbtn_active)

        }
        rbtn_all.setOnClickListener {

            onRadioButtonClicked(rbtn_all)

        }

        //presenter.getData(false)

    }

    override fun displayData(rocketsList : List<RocketsModel>) {

        val rocketsAdapter = RocketsAdapter(rocketsList)
        rv_rockets.adapter = rocketsAdapter
    }

    override fun showError(t: Throwable) {
       Log.i(TAG, t.message)
    }

    override fun onDestroy() {
        presenter.onDestroyCalled()
        super.onDestroy()
    }
    fun onRadioButtonClicked(view: View) {

        if (view is RadioButton) {
            // Is the button now checked?

            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {

                R.id.rbtn_active ->

                    if (checked) {

                        isActive = true
                        presenter.getData(isActive)

                    }

                R.id.rbtn_all ->

                    if (checked) {

                        isActive = false
                        presenter.getData(isActive)

                    }
            }
        }
    }
}
