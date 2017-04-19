package com.theyavikteam.spainweather

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_daily_forecast.view.*

class DailyForecastAdapter(val data: List<AemetDay>) : RecyclerView.Adapter<DailyForecastAdapter.DailyForecastVH>() {

    override fun onBindViewHolder(holder: DailyForecastVH?, position: Int) {
        holder?.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyForecastVH {
        return DailyForecastVH(LayoutInflater.from(parent.context).inflate(R.layout.row_daily_forecast, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class DailyForecastVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: AemetDay) = with(itemView){
            tvDate.text = item.date
        }
    }
}