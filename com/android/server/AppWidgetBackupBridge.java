package com.android.server;

import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/server/AppWidgetBackupBridge.class */
public class AppWidgetBackupBridge {
    private static WidgetBackupProvider sAppWidgetService;

    public static List<String> getWidgetParticipants(int i) {
        if (sAppWidgetService != null) {
            return sAppWidgetService.getWidgetParticipants(i);
        }
        return null;
    }

    public static byte[] getWidgetState(String str, int i) {
        if (sAppWidgetService != null) {
            return sAppWidgetService.getWidgetState(str, i);
        }
        return null;
    }

    public static void register(WidgetBackupProvider widgetBackupProvider) {
        sAppWidgetService = widgetBackupProvider;
    }

    public static void restoreFinished(int i) {
        if (sAppWidgetService != null) {
            sAppWidgetService.restoreFinished(i);
        }
    }

    public static void restoreStarting(int i) {
        if (sAppWidgetService != null) {
            sAppWidgetService.restoreStarting(i);
        }
    }

    public static void restoreWidgetState(String str, byte[] bArr, int i) {
        if (sAppWidgetService != null) {
            sAppWidgetService.restoreWidgetState(str, bArr, i);
        }
    }
}
