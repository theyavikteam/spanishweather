package com.theyavikteam.spainweather.ui.provinces

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.theyavikteam.spainweather.AutonomousRegion
import com.theyavikteam.spainweather.Province
import com.theyavikteam.spainweather.R
import kotlinx.android.synthetic.main.activity_provinces.*

class ProvinceActivity : AppCompatActivity() {

    companion object {

        val regionExtra = "REGION_EXTRA"

        fun starter(from: AppCompatActivity, autonomousRegion: AutonomousRegion) {
            val starter: Intent = Intent(from, ProvinceActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable(regionExtra, autonomousRegion)
            starter.putExtras(bundle)
            from.startActivity(starter)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_provinces)
        rvProvinces.layoutManager = LinearLayoutManager(this)
        val autonomousRegion = intent.extras.getSerializable(regionExtra) as AutonomousRegion
        ivRegionFlag.setImageResource(autonomousRegion.image)
        tvRegionName.text = autonomousRegion.region
        renderProvinces(loadProvincesByRegion(autonomousRegion))
    }

    private fun renderProvinces(provinces: List<Province>) {
        rvProvinces.adapter = ProvinceAdapter(provinces)
        rvProvinces.setHasFixedSize(true)
    }

    private fun loadProvincesByRegion(autonomousRegion: AutonomousRegion): List<Province> {
        val provincesByRegion = mutableListOf<Province>()
        for (province in Province.values()) {
            if (province.idRegion == autonomousRegion.id) {
                provincesByRegion.add(province)
            }
        }
        return provincesByRegion
    }
}