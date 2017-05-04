package com.theyavikteam.spainweather.ui.provinces

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.theyavikteam.spainweather.Province
import com.theyavikteam.spainweather.R
import kotlinx.android.synthetic.main.row_province.view.*

class ProvinceAdapter(val data: List<Province>) : RecyclerView.Adapter<ProvinceAdapter.ProvinceVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceVH {
        return ProvinceVH(LayoutInflater.from(parent.context).inflate(R.layout.row_province, parent, false))
    }

    override fun onBindViewHolder(holder: ProvinceVH?, position: Int) {
        holder?.bind(data[position])
    }

    override fun getItemCount(): Int = data.size


    class ProvinceVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Province) = with(itemView) {
            tvProvince.text = item.province
        }
    }
}