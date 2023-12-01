package android.os;

import android.util.Log;
import com.android.internal.os.BinderInternal;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/os/ServiceManager.class */
public final class ServiceManager {
    private static final String TAG = "ServiceManager";
    private static HashMap<String, IBinder> sCache = new HashMap<>();
    private static IServiceManager sServiceManager;

    public static void addService(String str, IBinder iBinder) {
        try {
            getIServiceManager().addService(str, iBinder, false);
        } catch (RemoteException e) {
            Log.e(TAG, "error in addService", e);
        }
    }

    public static void addService(String str, IBinder iBinder, boolean z) {
        try {
            getIServiceManager().addService(str, iBinder, z);
        } catch (RemoteException e) {
            Log.e(TAG, "error in addService", e);
        }
    }

    public static IBinder checkService(String str) {
        try {
            IBinder iBinder = sCache.get(str);
            return iBinder != null ? iBinder : getIServiceManager().checkService(str);
        } catch (RemoteException e) {
            Log.e(TAG, "error in checkService", e);
            return null;
        }
    }

    private static IServiceManager getIServiceManager() {
        if (sServiceManager != null) {
            return sServiceManager;
        }
        sServiceManager = ServiceManagerNative.asInterface(BinderInternal.getContextObject());
        return sServiceManager;
    }

    public static IBinder getService(String str) {
        try {
            IBinder iBinder = sCache.get(str);
            return iBinder != null ? iBinder : getIServiceManager().getService(str);
        } catch (RemoteException e) {
            Log.e(TAG, "error in getService", e);
            return null;
        }
    }

    public static void initServiceCache(Map<String, IBinder> map) {
        if (sCache.size() != 0) {
            throw new IllegalStateException("setServiceCache may only be called once");
        }
        sCache.putAll(map);
    }

    public static String[] listServices() throws RemoteException {
        try {
            return getIServiceManager().listServices();
        } catch (RemoteException e) {
            Log.e(TAG, "error in listServices", e);
            return null;
        }
    }
}
