package android.app;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: source-259656-dex2jar.jar:android/app/AndroidAppHelper.class */
public final class AndroidAppHelper {
    private static final Class<?> CLASS_RESOURCES_KEY;
    private static final boolean HAS_IS_THEMEABLE;
    private static final boolean HAS_THEME_CONFIG_PARAMETER;

    static {
        CLASS_RESOURCES_KEY = Build.VERSION.SDK_INT < 19 ? XposedHelpers.findClass("android.app.ActivityThread$ResourcesKey", null) : XposedHelpers.findClass("android.content.res.ResourcesKey", null);
        HAS_IS_THEMEABLE = XposedHelpers.findFieldIfExists(CLASS_RESOURCES_KEY, "mIsThemeable") != null;
        HAS_THEME_CONFIG_PARAMETER = HAS_IS_THEMEABLE && Build.VERSION.SDK_INT >= 21 && XposedHelpers.findMethodExactIfExists("android.app.ResourcesManager", null, "getThemeConfig", new Object[0]) != null;
    }

    private AndroidAppHelper() {
    }

    public static void addActiveResource(String str, float f, boolean z, Resources resources) {
        addActiveResource(str, resources);
    }

    public static void addActiveResource(String str, Resources resources) {
        Object createResourcesKey;
        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
        if (currentActivityThread == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            CompatibilityInfo compatibilityInfo = (CompatibilityInfo) XposedHelpers.newInstance(CompatibilityInfo.class, new Object[0]);
            XposedHelpers.setFloatField(compatibilityInfo, "applicationScale", resources.hashCode());
            createResourcesKey = createResourcesKey(str, null, null, null, 0, null, compatibilityInfo);
        } else {
            createResourcesKey = Build.VERSION.SDK_INT == 23 ? createResourcesKey(str, 0, null, resources.hashCode()) : Build.VERSION.SDK_INT >= 19 ? createResourcesKey(str, 0, null, resources.hashCode(), null) : Build.VERSION.SDK_INT >= 17 ? createResourcesKey(str, 0, null, resources.hashCode()) : createResourcesKey(str, resources.hashCode());
        }
        if (createResourcesKey != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                getResourcesMap(currentActivityThread).put(createResourcesKey, new WeakReference(XposedHelpers.getObjectField(resources, "mResourcesImpl")));
            } else {
                getResourcesMap(currentActivityThread).put(createResourcesKey, new WeakReference(resources));
            }
        }
    }

    private static Object createResourcesKey(String str, float f) {
        try {
            return HAS_IS_THEMEABLE ? XposedHelpers.newInstance(CLASS_RESOURCES_KEY, str, Float.valueOf(f), false) : XposedHelpers.newInstance(CLASS_RESOURCES_KEY, str, Float.valueOf(f));
        } catch (Throwable th) {
            XposedBridge.log(th);
            return null;
        }
    }

    private static Object createResourcesKey(String str, int i, Configuration configuration, float f) {
        try {
            return HAS_THEME_CONFIG_PARAMETER ? XposedHelpers.newInstance(CLASS_RESOURCES_KEY, str, Integer.valueOf(i), configuration, Float.valueOf(f), false, null) : HAS_IS_THEMEABLE ? XposedHelpers.newInstance(CLASS_RESOURCES_KEY, str, Integer.valueOf(i), configuration, Float.valueOf(f), false) : XposedHelpers.newInstance(CLASS_RESOURCES_KEY, str, Integer.valueOf(i), configuration, Float.valueOf(f));
        } catch (Throwable th) {
            XposedBridge.log(th);
            return null;
        }
    }

    private static Object createResourcesKey(String str, int i, Configuration configuration, float f, IBinder iBinder) {
        try {
            return HAS_THEME_CONFIG_PARAMETER ? XposedHelpers.newInstance(CLASS_RESOURCES_KEY, str, Integer.valueOf(i), configuration, Float.valueOf(f), false, null, iBinder) : HAS_IS_THEMEABLE ? XposedHelpers.newInstance(CLASS_RESOURCES_KEY, str, Integer.valueOf(i), configuration, Float.valueOf(f), false, iBinder) : XposedHelpers.newInstance(CLASS_RESOURCES_KEY, str, Integer.valueOf(i), configuration, Float.valueOf(f), iBinder);
        } catch (Throwable th) {
            XposedBridge.log(th);
            return null;
        }
    }

    private static Object createResourcesKey(String str, String[] strArr, String[] strArr2, String[] strArr3, int i, Configuration configuration, CompatibilityInfo compatibilityInfo) {
        try {
            return XposedHelpers.newInstance(CLASS_RESOURCES_KEY, str, strArr, strArr2, strArr3, Integer.valueOf(i), configuration, compatibilityInfo);
        } catch (Throwable th) {
            XposedBridge.log(th);
            return null;
        }
    }

    public static Application currentApplication() {
        return ActivityThread.currentApplication();
    }

    public static ApplicationInfo currentApplicationInfo() {
        Object objectField;
        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();
        if (currentActivityThread == null || (objectField = XposedHelpers.getObjectField(currentActivityThread, "mBoundApplication")) == null) {
            return null;
        }
        return (ApplicationInfo) XposedHelpers.getObjectField(objectField, "appInfo");
    }

    public static String currentPackageName() {
        ApplicationInfo currentApplicationInfo = currentApplicationInfo();
        return currentApplicationInfo != null ? currentApplicationInfo.packageName : MsgBackupManager.PLATFORM_ANDROID;
    }

    public static String currentProcessName() {
        String currentPackageName = ActivityThread.currentPackageName();
        String str = currentPackageName;
        if (currentPackageName == null) {
            str = MsgBackupManager.PLATFORM_ANDROID;
        }
        return str;
    }

    @Deprecated
    public static SharedPreferences getDefaultSharedPreferencesForPackage(String str) {
        return new XSharedPreferences(str);
    }

    private static Map<Object, WeakReference> getResourcesMap(ActivityThread activityThread) {
        return Build.VERSION.SDK_INT >= 24 ? (Map) XposedHelpers.getObjectField(XposedHelpers.getObjectField(activityThread, "mResourcesManager"), "mResourceImpls") : Build.VERSION.SDK_INT >= 19 ? (Map) XposedHelpers.getObjectField(XposedHelpers.getObjectField(activityThread, "mResourcesManager"), "mActiveResources") : (Map) XposedHelpers.getObjectField(activityThread, "mActiveResources");
    }

    @Deprecated
    public static SharedPreferences getSharedPreferencesForPackage(String str, String str2, int i) {
        return new XSharedPreferences(str, str2);
    }

    @Deprecated
    public static void reloadSharedPreferencesIfNeeded(SharedPreferences sharedPreferences) {
        if (sharedPreferences instanceof XSharedPreferences) {
            ((XSharedPreferences) sharedPreferences).reload();
        }
    }
}
