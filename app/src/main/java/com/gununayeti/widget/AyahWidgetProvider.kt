package com.gununayeti.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class AyahWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        manager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (id in appWidgetIds) {
            updateWidget(context, manager, id)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        if (
            intent.action == Intent.ACTION_DATE_CHANGED ||
            intent.action == Intent.ACTION_TIMEZONE_CHANGED
        ) {
            updateAll(context)
        }
    }

    companion object {

        fun updateAll(context: Context) {
            val manager = AppWidgetManager.getInstance(context)
            val ids = manager.getAppWidgetIds(
                android.content.ComponentName(
                    context,
                    AyahWidgetProvider::class.java
                )
            )

            for (id in ids) {
                updateWidget(context, manager, id)
            }
        }

        private fun updateWidget(
            context: Context,
            manager: AppWidgetManager,
            id: Int
        ) {
            val ayah = AyahRepository.getDailyAyah()

            val views = RemoteViews(
                context.packageName,
                R.layout.widget_ayah
            )

            views.setTextViewText(
                R.id.ayah_arabic,
                ayah.arabic
            )

            views.setTextViewText(
                R.id.ayah_translation,
                ayah.translation
            )

            views.setTextViewText(
                R.id.ayah_reference,
                ayah.reference
            )

            val intent = Intent(context, MainActivity::class.java)

            val pendingIntent = PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or
                    PendingIntent.FLAG_IMMUTABLE
            )

            views.setOnClickPendingIntent(
                R.id.ayah_arabic,
                pendingIntent
            )

            manager.updateAppWidget(id, views)
        }
    }
}
