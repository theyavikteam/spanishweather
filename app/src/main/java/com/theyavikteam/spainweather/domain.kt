package com.theyavikteam.spainweather

import com.google.gson.annotations.SerializedName

data class AemetResponse(@SerializedName("descripcion") val description: String,
                        @SerializedName("estado") val state: Int,
                        @SerializedName("datos") val data: String,
                        @SerializedName("metadatos") val metadata: String)

data class AemetDailyResponse(@SerializedName("origen")val origin: AemetOrigin,
                              @SerializedName("elaborado")val elaborated:String,
                              @SerializedName("nombre")val city:String,
                              @SerializedName("provincia")val province:String,
                              @SerializedName("prediccion")val prediction:AemetDailyForecast,
                              @SerializedName("id")val id: Long,
                              @SerializedName("version")val version: Int)

data class AemetOrigin(@SerializedName("productor")val producer:String,
                       @SerializedName("web")val web:String,
                       @SerializedName("enlace")val url:String,
                       @SerializedName("language")val language: String,
                       @SerializedName("copyright")val copyright:String,
                       @SerializedName("notaLegal")val legalNote: String)

data class AemetDailyForecast(@SerializedName("dia")val days: List<AemetDay>)

data class AemetDay(@SerializedName("probPrecipitacion")val precipitationProbability: List<AemetPrecipitationProbability>,
                    @SerializedName("cotaNieve")val snowCover: List<AemetSnowCover>,
                    @SerializedName("estadoCielo")val skyState: List<AemetSkyState>,
                    @SerializedName("viento")val wind: List<AemetWind>,
                    @SerializedName("rachaMax")val maxStreak: List<AemetMaxStreak>,
                    @SerializedName("temperatura")val temperature: AemetTemperature,
                    @SerializedName("sensTermica")val thermalSensation: AemetThermalSensation,
                    @SerializedName("humedadRelativa")val relativeHumidity: AemetRelativeHumidity,
                    @SerializedName("uvMax")val uvMax: Int,
                    @SerializedName("fecha")val date:String)

data class AemetPrecipitationProbability(@SerializedName("value")val value:String,
                                         @SerializedName("periodo")val period:String)

data class AemetSnowCover(@SerializedName("value")val value:String,
                          @SerializedName("periodo")val period:String)

data class AemetSkyState(@SerializedName("value")val value:String,
                         @SerializedName("periodo")val period:String,
                         @SerializedName("descripcion")val description:String)

data class AemetWind(@SerializedName("periodo")val period:String,
                     @SerializedName("direccion")val direction:String,
                     @SerializedName("velocidad")val speed: String)

data class AemetMaxStreak(@SerializedName("value")val value:String,
                          @SerializedName("periodo")val period:String)

data class AemetTemperature(@SerializedName("maxima")val max:String,
                            @SerializedName("minima")val min:String,
                            @SerializedName("dato")val data: List<AemetData>)

data class AemetThermalSensation(@SerializedName("maxima")val max:String,
                                 @SerializedName("minima")val min:String,
                                 @SerializedName("dato")val data: List<AemetData>)

data class AemetRelativeHumidity(@SerializedName("maxima")val max:String,
                                 @SerializedName("minima")val min:String,
                                 @SerializedName("dato")val data: List<AemetData>)

data class AemetData(@SerializedName("hora")val hour:Any,
                     @SerializedName("value")val value:String)



