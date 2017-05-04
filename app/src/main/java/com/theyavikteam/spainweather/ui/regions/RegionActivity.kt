package com.theyavikteam.spainweather.ui.regions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.theyavikteam.spainweather.AutonomousRegion
import com.theyavikteam.spainweather.R
import kotlinx.android.synthetic.main.activity_regions.*

class RegionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regions)
        rvRegions.layoutManager = LinearLayoutManager(this)
        renderRegions((AutonomousRegion.values()))
    }

    private fun renderRegions(regions: Array<AutonomousRegion>) {
        rvRegions.adapter = RegionAdapter(this, regions)
        rvRegions.setHasFixedSize(true)
    }
}