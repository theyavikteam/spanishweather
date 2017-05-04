package com.theyavikteam.spainweather.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.theyavikteam.spainweather.AutonomousRegion
import com.theyavikteam.spainweather.R
import com.theyavikteam.spainweather.RegionAdapter
import kotlinx.android.synthetic.main.activity_regions.*

class RegionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regions)
        rvRegions.layoutManager = LinearLayoutManager(this)
        renderRegions(loadRegions())
    }

    private fun renderRegions(regions: List<AutonomousRegion>) {
        rvRegions.adapter = RegionAdapter(regions)
        rvRegions.setHasFixedSize(true)
    }

    private fun loadRegions(): List<AutonomousRegion> {
        return listOf(AutonomousRegion.ANDALUCIA, AutonomousRegion.CATALUNIA, AutonomousRegion.COMUNIDAD_MADRID, AutonomousRegion.COMUNIDAD_VALENCIANA, AutonomousRegion.GALICIA,
                AutonomousRegion.CASTILLA_LEON, AutonomousRegion.PAIS_VASCO, AutonomousRegion.CANARIAS, AutonomousRegion.CASTILLA_LA_MANCHA, AutonomousRegion.REGION_MURCIA,
                AutonomousRegion.ARAGON, AutonomousRegion.ISLAS_BALEARES, AutonomousRegion.EXTREMADURA, AutonomousRegion.ASTURIAS, AutonomousRegion.NAVARRA, AutonomousRegion.CANTABRIA, AutonomousRegion.LA_RIOJA,
                AutonomousRegion.CEUTA, AutonomousRegion.MELILLA)

    }
}