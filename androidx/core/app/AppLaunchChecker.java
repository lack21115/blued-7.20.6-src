package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/AppLaunchChecker.class */
public class AppLaunchChecker {
    public static boolean hasStartedFromLauncher(Context context) {
        return context.getSharedPreferences("android.support.AppLaunchChecker", 0).getBoolean("startedFromLauncher", false);
    }

    public static void onActivityCreate(Activity activity) {
        Intent intent;
        SharedPreferences sharedPreferences = activity.getSharedPreferences("android.support.AppLaunchChecker", 0);
        if (sharedPreferences.getBoolean("startedFromLauncher", false) || (intent = activity.getIntent()) == null || !Intent.ACTION_MAIN.equals(intent.getAction())) {
            return;
        }
        if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) || intent.hasCategory("android.intent.category.LEANBACK_LAUNCHER")) {
            sharedPreferences.edit().putBoolean("startedFromLauncher", true).apply();
        }
    }
}
