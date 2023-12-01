package android.appwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: source-9557208-dex2jar.jar:android/appwidget/AppWidgetProvider.class */
public class AppWidgetProvider extends BroadcastReceiver {
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i, Bundle bundle) {
    }

    public void onDeleted(Context context, int[] iArr) {
    }

    public void onDisabled(Context context) {
    }

    public void onEnabled(Context context) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        int[] intArray;
        String action = intent.getAction();
        if (AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 == null || (intArray = extras2.getIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS)) == null || intArray.length <= 0) {
                return;
            }
            onUpdate(context, AppWidgetManager.getInstance(context), intArray);
        } else if (AppWidgetManager.ACTION_APPWIDGET_DELETED.equals(action)) {
            Bundle extras3 = intent.getExtras();
            if (extras3 == null || !extras3.containsKey(AppWidgetManager.EXTRA_APPWIDGET_ID)) {
                return;
            }
            onDeleted(context, new int[]{extras3.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID)});
        } else if (AppWidgetManager.ACTION_APPWIDGET_OPTIONS_CHANGED.equals(action)) {
            Bundle extras4 = intent.getExtras();
            if (extras4 != null && extras4.containsKey(AppWidgetManager.EXTRA_APPWIDGET_ID) && extras4.containsKey(AppWidgetManager.EXTRA_APPWIDGET_OPTIONS)) {
                onAppWidgetOptionsChanged(context, AppWidgetManager.getInstance(context), extras4.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID), extras4.getBundle(AppWidgetManager.EXTRA_APPWIDGET_OPTIONS));
            }
        } else if (AppWidgetManager.ACTION_APPWIDGET_ENABLED.equals(action)) {
            onEnabled(context);
        } else if (AppWidgetManager.ACTION_APPWIDGET_DISABLED.equals(action)) {
            onDisabled(context);
        } else if (!AppWidgetManager.ACTION_APPWIDGET_RESTORED.equals(action) || (extras = intent.getExtras()) == null) {
        } else {
            int[] intArray2 = extras.getIntArray(AppWidgetManager.EXTRA_APPWIDGET_OLD_IDS);
            int[] intArray3 = extras.getIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS);
            if (intArray2 == null || intArray2.length <= 0) {
                return;
            }
            onRestored(context, intArray2, intArray3);
            onUpdate(context, AppWidgetManager.getInstance(context), intArray3);
        }
    }

    public void onRestored(Context context, int[] iArr, int[] iArr2) {
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
    }
}
