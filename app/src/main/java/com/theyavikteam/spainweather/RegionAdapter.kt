package com.theyavikteam.spainweather

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_region.view.*

class RegionAdapter(val data: List<AutonomousRegion>) : RecyclerView.Adapter<RegionAdapter.RegionVH>() {

    override fun onBindViewHolder(holder: RegionVH?, position: Int) {
        holder?.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionVH {
        return RegionVH(LayoutInflater.from(parent.context).inflate(R.layout.row_region, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class RegionVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: AutonomousRegion) = with(itemView) {
            //TODO load image
            ivRegionFlag.setImageResource(item.image)
            tvRegionName.text = item.region
        }
    }
}