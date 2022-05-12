package com.example.widgetapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.example.widgetapp.R;
import com.example.widgetapp.Screens.ShortcutHome;

import java.util.ArrayList;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.appwidget_image, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
//            ArrayList<String> data = new ArrayList<>();
//            data.add("Richmond Centre");
//            Shortcut shortcut = new Shortcut("hello", "SearchGoogleMaps");
//            shortcut.setInfo(data);
//            Intent intent = shortcut.run(context);
//            System.out.println("4");
//
//            // Create an Intent to launch ExampleActivity
////            Intent intent = new Intent(context, ShortcutHome.class);
//            PendingIntent pendingIntent = PendingIntent.getActivity(
//                    /* context = */ context,
//                    /* requestCode = */ 0,
//                    /* intent = */ intent,
//                    /* flags = */ PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
//            );
//
//            // Get the layout for the widget and attach an on-click listener
//            // to the button.
//            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
//            views.setOnClickPendingIntent(R.id.appwidget_image, pendingIntent);
//
//            // Tell the AppWidgetManager to perform an update on the current app widget.
//            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}