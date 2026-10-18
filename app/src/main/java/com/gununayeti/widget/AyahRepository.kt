package com.gununayeti.widget

import java.time.LocalDate
import java.util.Random

data class Ayah(
    val arabic: String,
    val translation: String,
    val reference: String
)

object AyahRepository {

    private val ayahs = listOf(
        Ayah(
            "فَإِنَّ مَعَ الْعُسْرِ يُسْرًا",
            "Şüphesiz güçlükle beraber bir kolaylık vardır.",
            "İnşirah Suresi · 5. ayet"
        ),
        Ayah(
            "إِنَّ اللَّهَ مَعَ الصَّابِرِينَ",
            "Şüphesiz Allah sabredenlerle beraberdir.",
            "Bakara Suresi · 153. ayetten"
        ),
        Ayah(
            "وَقُلْ رَبِّ زِدْنِي عِلْمًا",
            "Rabbim! İlmimi artır, de.",
            "Tâhâ Suresi · 114. ayetten"
        ),
        Ayah(
            "فَاذْكُرُونِي أَذْكُرْكُمْ",
            "Öyleyse siz beni anın ki ben de sizi anayım.",
            "Bakara Suresi · 152. ayetten"
        ),
        Ayah(
            "إِنَّ اللَّهَ يُحِبُّ الْمُحْسِنِينَ",
            "Şüphesiz Allah iyilik edenleri sever.",
            "Bakara Suresi · 195. ayetten"
        )
    )

    fun getDailyAyah(): Ayah {
        val day = LocalDate.now().toEpochDay()
        val index = Math.floorMod(day, ayahs.size.toLong()).toInt()
        return ayahs[index]
    }
}
