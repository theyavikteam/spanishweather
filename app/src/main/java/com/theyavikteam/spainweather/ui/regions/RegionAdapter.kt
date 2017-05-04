package com.theyavikteam.spainweather.ui.regions

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.theyavikteam.spainweather.AutonomousRegion
import com.theyavikteam.spainweather.R
import com.theyavikteam.spainweather.ui.provinces.ProvinceActivity
import kotlinx.android.synthetic.main.row_region.view.*

class RegionAdapter(val context: AppCompatActivity, val data: Array<AutonomousRegion>) : RecyclerView.Adapter<RegionAdapter.RegionVH>() {

    override fun onBindViewHolder(holder: RegionVH?, position: Int) {
        val autonomousRegion = data[position]
        holder?.bind(autonomousRegion){
            openProvincesByRegion(autonomousRegion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionVH {
        return RegionVH(LayoutInflater.from(parent.context).inflate(R.layout.row_region, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun openProvincesByRegion(autonomousRegion: AutonomousRegion){
        ProvinceActivity.starter(context, autonomousRegion)
    }

    class RegionVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: AutonomousRegion, listener: (AutonomousRegion) -> Unit) = with(itemView) {
            ivRegionFlag.setImageResource(item.image)
            tvRegionName.text = item.region
            setOnClickListener { listener.invoke(item) }
        }
    }
}