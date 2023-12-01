package android.net.wimax;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.IBinder;
import android.os.ServiceManager;
import android.provider.Settings;
import android.util.Log;
import com.android.internal.R;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;

/* loaded from: source-9557208-dex2jar.jar:android/net/wimax/WimaxHelper.class */
public class WimaxHelper {
    private static final String TAG = "WimaxHelper";
    private static final String WIMAX_CONTROLLER_CLASSNAME = "com.htc.net.wimax.WimaxController";
    private static final String WIMAX_MANAGER_CLASSNAME = "android.net.fourG.wimax.Wimax4GManager";
    private static String sGetWimaxStateMethodname;
    private static String sIsWimaxEnabledMethodname;
    private static String sSetWimaxEnabledMethodname;
    private static DexClassLoader sWimaxClassLoader;
    private static String sWimaxManagerClassname;

    public static Object createWimaxService(Context context, Handler handler) {
        Class<?> loadClass;
        Class<?> loadClass2;
        Object invoke;
        Class<?> loadClass3;
        try {
            DexClassLoader wimaxClassLoader = getWimaxClassLoader(context);
            if (!sWimaxManagerClassname.equals(WIMAX_CONTROLLER_CLASSNAME)) {
                if (!sWimaxManagerClassname.equals(WIMAX_MANAGER_CLASSNAME) || (loadClass = wimaxClassLoader.loadClass(WIMAX_MANAGER_CLASSNAME)) == null) {
                    return null;
                }
                return loadClass.getDeclaredConstructors()[0].newInstance(new Object[0]);
            }
            IBinder service = ServiceManager.getService(WimaxManagerConstants.WIMAX_SERVICE);
            if (service == null || (loadClass2 = wimaxClassLoader.loadClass("com.htc.net.wimax.IWimaxController$Stub")) == null || (invoke = loadClass2.getMethod("asInterface", IBinder.class).invoke(null, service)) == null || (loadClass3 = wimaxClassLoader.loadClass(WIMAX_CONTROLLER_CLASSNAME)) == null) {
                return null;
            }
            return loadClass3.getDeclaredConstructors()[1].newInstance(invoke, handler);
        } catch (Exception e) {
            Log.e(TAG, "Unable to create WimaxController instance", e);
            return null;
        }
    }

    public static DexClassLoader getWimaxClassLoader(Context context) {
        if (isWimaxSupported(context)) {
            if (sWimaxClassLoader == null) {
                sWimaxManagerClassname = context.getResources().getString(R.string.config_wimaxManagerClassname);
                if (sWimaxManagerClassname.equals(WIMAX_CONTROLLER_CLASSNAME)) {
                    sIsWimaxEnabledMethodname = "isWimaxEnabled";
                    sSetWimaxEnabledMethodname = "setWimaxEnabled";
                    sGetWimaxStateMethodname = "getWimaxState";
                } else if (sWimaxManagerClassname.equals(WIMAX_MANAGER_CLASSNAME)) {
                    sIsWimaxEnabledMethodname = "is4GEnabled";
                    sSetWimaxEnabledMethodname = "set4GEnabled";
                    sGetWimaxStateMethodname = "get4GState";
                }
                sWimaxClassLoader = new DexClassLoader(context.getResources().getString(R.string.config_wimaxServiceJarLocation), new ContextWrapper(context).getCacheDir().getAbsolutePath(), context.getResources().getString(R.string.config_wimaxNativeLibLocation), ClassLoader.getSystemClassLoader());
            }
            return sWimaxClassLoader;
        }
        return null;
    }

    private static Object getWimaxInfo(Context context) {
        try {
            Object systemService = context.getSystemService(WimaxManagerConstants.WIMAX_SERVICE);
            return systemService.getClass().getMethod("getConnectionInfo", new Class[0]).invoke(systemService, new Object[0]);
        } catch (Exception e) {
            Log.e(TAG, "Unable to get a WimaxInfo object!", e);
            return null;
        }
    }

    public static int getWimaxState(Context context) {
        try {
            Object systemService = context.getSystemService(WimaxManagerConstants.WIMAX_SERVICE);
            return ((Integer) systemService.getClass().getMethod(sGetWimaxStateMethodname, new Class[0]).invoke(systemService, new Object[0])).intValue();
        } catch (Exception e) {
            Log.e(TAG, "Unable to get WiMAX state!", e);
            return 0;
        }
    }

    public static boolean isWimaxEnabled(Context context) {
        try {
            Object systemService = context.getSystemService(WimaxManagerConstants.WIMAX_SERVICE);
            return ((Boolean) systemService.getClass().getMethod(sIsWimaxEnabledMethodname, new Class[0]).invoke(systemService, new Object[0])).booleanValue();
        } catch (Exception e) {
            Log.e(TAG, "Unable to get WiMAX enabled state!", e);
            return false;
        }
    }

    public static boolean isWimaxSupported(Context context) {
        return context.getResources().getBoolean(R.bool.config_wimaxEnabled);
    }

    public static boolean setWimaxEnabled(Context context, boolean z) {
        boolean z2 = false;
        try {
            Object systemService = context.getSystemService(WimaxManagerConstants.WIMAX_SERVICE);
            boolean booleanValue = ((Boolean) systemService.getClass().getMethod(sSetWimaxEnabledMethodname, Boolean.TYPE).invoke(systemService, Boolean.valueOf(z))).booleanValue();
            if (booleanValue) {
                z2 = booleanValue;
                Settings.Secure.putInt(context.getContentResolver(), Settings.Secure.WIMAX_ON, Boolean.valueOf(z).booleanValue() ? 1 : 0);
            }
            return booleanValue;
        } catch (Exception e) {
            Log.e(TAG, "Unable to set WiMAX state!", e);
            return z2;
        }
    }

    public static boolean wimaxRescan(Context context) {
        boolean z = false;
        try {
            Object systemService = context.getSystemService(WimaxManagerConstants.WIMAX_SERVICE);
            Method method = systemService.getClass().getMethod("wimaxRescan", new Class[0]);
            if (method != null) {
                method.invoke(systemService, new Object[0]);
                z = true;
            }
            return z;
        } catch (Exception e) {
            Log.e(TAG, "Unable to perform WiMAX rescan!", e);
            return false;
        }
    }
}
