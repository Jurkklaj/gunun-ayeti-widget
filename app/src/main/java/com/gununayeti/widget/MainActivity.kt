package com.gununayeti.widget

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(android.graphics.Color.rgb(20, 39, 31))
        }

        val title = TextView(this).apply {
            text = "GÜNÜN AYETİ"
            textSize = 28f
            setTextColor(android.graphics.Color.WHITE)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Her gün yeni bir ayet, her gün yeni bir hatırlayış."
            textSize = 16f
            setTextColor(android.graphics.Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 24)
        }

        val ayah = AyahRepository.getDailyAyah()

        val arabic = TextView(this).apply {
            text = ayah.arabic
            textSize = 26f
            setTextColor(android.graphics.Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(0, 16, 0, 16)
        }

        val translation = TextView(this).apply {
            text = ayah.translation
            textSize = 18f
            setTextColor(android.graphics.Color.rgb(224, 232, 223))
            gravity = Gravity.CENTER
        }

        val reference = TextView(this).apply {
            text = ayah.reference
            textSize = 14f
            setTextColor(android.graphics.Color.rgb(182, 203, 175))
            gravity = Gravity.CENTER
            setPadding(0, 16, 0, 24)
        }

        val button = Button(this).apply {
            text = "Widget'ı Güncelle"
            setOnClickListener {
                AyahWidgetProvider.updateAll(this@MainActivity)
            }
        }

        val instructions = TextView(this).apply {
            text = "Ana ekrana eklemek için boş bir alana basılı tut. " +
                "Widget'lar bölümünden Günün Ayeti'ni seç."
            textSize = 14f
            setTextColor(android.graphics.Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 0)
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(arabic)
        layout.addView(translation)
        layout.addView(reference)
        layout.addView(button)
        layout.addView(instructions)

        setContentView(layout)
    }
}
