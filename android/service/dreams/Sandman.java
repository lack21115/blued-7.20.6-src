package android.service.dreams;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ThemeConfig;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.service.dreams.IDreamManager;
import android.util.Slog;

/* loaded from: source-9557208-dex2jar.jar:android/service/dreams/Sandman.class */
public final class Sandman {
    private static final ComponentName SOMNAMBULATOR_COMPONENT = new ComponentName(ThemeConfig.SYSTEMUI_STATUS_BAR_PKG, "com.android.systemui.Somnambulator");
    private static final String TAG = "Sandman";

    private Sandman() {
    }

    private static boolean isScreenSaverActivatedOnDock(Context context) {
        return Settings.Secure.getIntForUser(context.getContentResolver(), Settings.Secure.SCREENSAVER_ACTIVATE_ON_DOCK, context.getResources().getBoolean(17956977) ? 1 : 0, -2) != 0;
    }

    private static boolean isScreenSaverEnabled(Context context) {
        return Settings.Secure.getIntForUser(context.getContentResolver(), Settings.Secure.SCREENSAVER_ENABLED, context.getResources().getBoolean(17956976) ? 1 : 0, -2) != 0;
    }

    public static boolean shouldStartDockApp(Context context, Intent intent) {
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        return (resolveActivity == null || resolveActivity.equals(SOMNAMBULATOR_COMPONENT)) ? false : true;
    }

    private static void startDream(Context context, boolean z) {
        try {
            IDreamManager asInterface = IDreamManager.Stub.asInterface(ServiceManager.getService(DreamService.DREAM_SERVICE));
            if (asInterface == null || asInterface.isDreaming()) {
                return;
            }
            if (z) {
                Slog.i(TAG, "Activating dream while docked.");
                ((PowerManager) context.getSystemService(Context.POWER_SERVICE)).wakeUp(SystemClock.uptimeMillis());
            } else {
                Slog.i(TAG, "Activating dream by user request.");
            }
            asInterface.dream();
        } catch (RemoteException e) {
            Slog.e(TAG, "Could not start dream when docked.", e);
        }
    }

    public static void startDreamByUserRequest(Context context) {
        startDream(context, false);
    }

    public static void startDreamWhenDockedIfAppropriate(Context context) {
        if (isScreenSaverEnabled(context) && isScreenSaverActivatedOnDock(context)) {
            startDream(context, true);
        } else {
            Slog.i(TAG, "Dreams currently disabled for docks.");
        }
    }
}
