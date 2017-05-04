package com.theyavikteam.spainweather

enum class AutonomousRegion(val id: Int, val region: String,val image: Int) {
    ANDALUCIA(1, "Andalucía", R.drawable.flag_andalucia)
    ,CATALUNIA(2, "Cataluña", R.drawable.flag_catalunya)
    ,COMUNIDAD_MADRID(3, "Comunidad de Madrid", R.drawable.flag_madrid)
    ,COMUNIDAD_VALENCIANA(4, "Comunidad Valenciana", R.drawable.flag_comunidad_valenciana)
    ,GALICIA(5, "Galicia", R.drawable.flag_galicia)
    ,CASTILLA_LEON(6, "Castilla y León", R.drawable.flag_castilla_leon)
    ,PAIS_VASCO(7, "País Vasco", R.drawable.flag_euskadi)
    ,CANARIAS(8, "Canarias", R.drawable.flag_canarias)
    ,CASTILLA_LA_MANCHA(9, "Castilla-La Mancha", R.drawable.flag_castilla_la_mancha)
    ,REGION_MURCIA(10, "Región de Murcia", R.drawable.flag_murcia)
    ,ARAGON(11, "Aragón", R.drawable.flag_aragon)
    ,ISLAS_BALEARES(12, "Islas Baleares", R.drawable.flag_baleares)
    ,EXTREMADURA(13, "Extremadura", R.drawable.flag_extremadura)
    ,ASTURIAS(14, "Asturias", R.drawable.flag_asturias)
    ,NAVARRA(15, "Navarra", R.drawable.flag_navarra)
    ,CANTABRIA(16, "Cantabria", R.drawable.flag_cantabria)
    ,LA_RIOJA(17, "La Rioja", R.drawable.flag_la_rioja)
    ,CEUTA(18, "Ceuta", R.drawable.flag_ceuta)
    ,MELILLA(19, "Melilla", R.drawable.flag_melilla);
}