package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContextCompat.class */
public class ContextCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2355a = new Object();
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static TypedValue f2356c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContextCompat$Api16Impl.class */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        static void startActivity(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContextCompat$Api19Impl.class */
    static class Api19Impl {
        private Api19Impl() {
        }

        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        static File[] a(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        static File[] b(Context context) {
            return context.getObbDirs();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContextCompat$Api21Impl.class */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static Drawable a(Context context, int i) {
            return context.getDrawable(i);
        }

        static File a(Context context) {
            return context.getNoBackupFilesDir();
        }

        static File b(Context context) {
            return context.getCodeCacheDir();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContextCompat$Api23Impl.class */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static int a(Context context, int i) {
            return context.getColor(i);
        }

        static <T> T a(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static String b(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContextCompat$Api24Impl.class */
    static class Api24Impl {
        private Api24Impl() {
        }

        static File a(Context context) {
            return context.getDataDir();
        }

        static Context b(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContextCompat$Api26Impl.class */
    static class Api26Impl {
        private Api26Impl() {
        }

        static ComponentName a(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContextCompat$Api28Impl.class */
    static class Api28Impl {
        private Api28Impl() {
        }

        static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContextCompat$Api30Impl.class */
    static class Api30Impl {
        private Api30Impl() {
        }

        static String a(Context context) {
            return context.getAttributionTag();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContextCompat$LegacyServiceMapHolder.class */
    public static final class LegacyServiceMapHolder {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<Class<?>, String> f2357a = new HashMap<>();

        static {
            if (Build.VERSION.SDK_INT >= 22) {
                f2357a.put(SubscriptionManager.class, Context.TELEPHONY_SUBSCRIPTION_SERVICE);
                f2357a.put(UsageStatsManager.class, Context.USAGE_STATS_SERVICE);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                f2357a.put(AppWidgetManager.class, Context.APPWIDGET_SERVICE);
                f2357a.put(BatteryManager.class, Context.BATTERY_SERVICE);
                f2357a.put(CameraManager.class, "camera");
                f2357a.put(JobScheduler.class, Context.JOB_SCHEDULER_SERVICE);
                f2357a.put(LauncherApps.class, Context.LAUNCHER_APPS_SERVICE);
                f2357a.put(MediaProjectionManager.class, Context.MEDIA_PROJECTION_SERVICE);
                f2357a.put(MediaSessionManager.class, Context.MEDIA_SESSION_SERVICE);
                f2357a.put(RestrictionsManager.class, Context.RESTRICTIONS_SERVICE);
                f2357a.put(TelecomManager.class, "telecom");
                f2357a.put(TvInputManager.class, Context.TV_INPUT_SERVICE);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                f2357a.put(AppOpsManager.class, Context.APP_OPS_SERVICE);
                f2357a.put(CaptioningManager.class, Context.CAPTIONING_SERVICE);
                f2357a.put(ConsumerIrManager.class, Context.CONSUMER_IR_SERVICE);
                f2357a.put(PrintManager.class, "print");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                f2357a.put(BluetoothManager.class, "bluetooth");
            }
            if (Build.VERSION.SDK_INT >= 17) {
                f2357a.put(DisplayManager.class, "display");
                f2357a.put(UserManager.class, "user");
            }
            if (Build.VERSION.SDK_INT >= 16) {
                f2357a.put(InputManager.class, "input");
                f2357a.put(MediaRouter.class, Context.MEDIA_ROUTER_SERVICE);
                f2357a.put(NsdManager.class, Context.NSD_SERVICE);
            }
            f2357a.put(AccessibilityManager.class, Context.ACCESSIBILITY_SERVICE);
            f2357a.put(AccountManager.class, "account");
            f2357a.put(ActivityManager.class, "activity");
            f2357a.put(AlarmManager.class, "alarm");
            f2357a.put(AudioManager.class, "audio");
            f2357a.put(ClipboardManager.class, Context.CLIPBOARD_SERVICE);
            f2357a.put(ConnectivityManager.class, Context.CONNECTIVITY_SERVICE);
            f2357a.put(DevicePolicyManager.class, Context.DEVICE_POLICY_SERVICE);
            f2357a.put(DownloadManager.class, "download");
            f2357a.put(DropBoxManager.class, Context.DROPBOX_SERVICE);
            f2357a.put(InputMethodManager.class, Context.INPUT_METHOD_SERVICE);
            f2357a.put(KeyguardManager.class, Context.KEYGUARD_SERVICE);
            f2357a.put(LayoutInflater.class, Context.LAYOUT_INFLATER_SERVICE);
            f2357a.put(LocationManager.class, "location");
            f2357a.put(NfcManager.class, "nfc");
            f2357a.put(NotificationManager.class, "notification");
            f2357a.put(PowerManager.class, Context.POWER_SERVICE);
            f2357a.put(SearchManager.class, "search");
            f2357a.put(SensorManager.class, "sensor");
            f2357a.put(StorageManager.class, Context.STORAGE_SERVICE);
            f2357a.put(TelephonyManager.class, "phone");
            f2357a.put(TextServicesManager.class, Context.TEXT_SERVICES_MANAGER_SERVICE);
            f2357a.put(UiModeManager.class, Context.UI_MODE_SERVICE);
            f2357a.put(UsbManager.class, Context.USB_SERVICE);
            f2357a.put(Vibrator.class, Context.VIBRATOR_SERVICE);
            f2357a.put(WallpaperManager.class, Context.WALLPAPER_SERVICE);
            f2357a.put(WifiP2pManager.class, Context.WIFI_P2P_SERVICE);
            f2357a.put(WifiManager.class, "wifi");
            f2357a.put(WindowManager.class, Context.WINDOW_SERVICE);
        }

        private LegacyServiceMapHolder() {
        }
    }

    private static File a(File file) {
        synchronized (b) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
            }
            return file;
        }
    }

    public static int checkSelfPermission(Context context, String str) {
        ObjectsCompat.requireNonNull(str, "permission must be non-null");
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.b(context);
        }
        return null;
    }

    public static String getAttributionTag(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.a(context);
        }
        return null;
    }

    public static File getCodeCacheDir(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? Api21Impl.b(context) : a(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    public static int getColor(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.a(context, i) : context.getResources().getColor(i);
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        return ResourcesCompat.getColorStateList(context.getResources(), i, context.getTheme());
    }

    public static File getDataDir(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.a(context);
        }
        String str = context.getApplicationInfo().dataDir;
        if (str != null) {
            return new File(str);
        }
        return null;
    }

    public static Drawable getDrawable(Context context, int i) {
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.a(context, i);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f2355a) {
            if (f2356c == null) {
                f2356c = new TypedValue();
            }
            context.getResources().getValue(i, f2356c, true);
            i2 = f2356c.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    public static File[] getExternalCacheDirs(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? Api19Impl.a(context) : new File[]{context.getExternalCacheDir()};
    }

    public static File[] getExternalFilesDirs(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? Api19Impl.a(context, str) : new File[]{context.getExternalFilesDir(str)};
    }

    public static Executor getMainExecutor(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.a(context) : ExecutorCompat.create(new Handler(context.getMainLooper()));
    }

    public static File getNoBackupFilesDir(Context context) {
        return Build.VERSION.SDK_INT >= 21 ? Api21Impl.a(context) : a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public static File[] getObbDirs(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? Api19Impl.b(context) : new File[]{context.getObbDir()};
    }

    public static <T> T getSystemService(Context context, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return (T) Api23Impl.a(context, cls);
        }
        String systemServiceName = getSystemServiceName(context, cls);
        if (systemServiceName != null) {
            return (T) context.getSystemService(systemServiceName);
        }
        return null;
    }

    public static String getSystemServiceName(Context context, Class<?> cls) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.b(context, cls) : LegacyServiceMapHolder.f2357a.get(cls);
    }

    public static boolean isDeviceProtectedStorage(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.c(context);
        }
        return false;
    }

    public static boolean startActivities(Context context, Intent[] intentArr) {
        return startActivities(context, intentArr, null);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.a(context, intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.startActivity(context, intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static void startForegroundService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.a(context, intent);
        } else {
            context.startService(intent);
        }
    }
}
