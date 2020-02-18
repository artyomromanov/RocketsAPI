package com.example.rocketsapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rocket_item.view.*

class RocketsAdapter(private val rocketsList: List<RocketsModel>) : RecyclerView.Adapter<RocketsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rocket_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return rocketsList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(position)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {

            itemView.tv_country.text = rocketsList[position].country
            itemView.tv_engine_count.text = rocketsList[position].engines.number.toString()
            itemView.tv_name.text = rocketsList[position].rocketName
        }
    }
}