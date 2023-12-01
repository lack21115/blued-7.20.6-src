package android.app;

import android.app.INotificationManager;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.os.UserHandle;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/app/NotificationManager.class */
public class NotificationManager {
    public static final String ACTION_EFFECTS_SUPPRESSOR_CHANGED = "android.os.action.ACTION_EFFECTS_SUPPRESSOR_CHANGED";
    private static String TAG = "NotificationManager";
    private static boolean localLOGV = false;
    private static INotificationManager sService;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationManager(Context context, Handler handler) {
        this.mContext = context;
    }

    public static NotificationManager from(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }

    public static INotificationManager getService() {
        if (sService != null) {
            return sService;
        }
        sService = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        return sService;
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancel(String str, int i) {
        INotificationManager service = getService();
        String packageName = this.mContext.getPackageName();
        if (localLOGV) {
            Log.v(TAG, packageName + ": cancel(" + i + ")");
        }
        try {
            service.cancelNotificationWithTag(packageName, str, i, UserHandle.myUserId());
        } catch (RemoteException e) {
        }
    }

    public void cancelAll() {
        INotificationManager service = getService();
        String packageName = this.mContext.getPackageName();
        if (localLOGV) {
            Log.v(TAG, packageName + ": cancelAll()");
        }
        try {
            service.cancelAllNotifications(packageName, UserHandle.myUserId());
        } catch (RemoteException e) {
        }
    }

    public void cancelAsUser(String str, int i, UserHandle userHandle) {
        INotificationManager service = getService();
        String packageName = this.mContext.getPackageName();
        if (localLOGV) {
            Log.v(TAG, packageName + ": cancel(" + i + ")");
        }
        try {
            service.cancelNotificationWithTag(packageName, str, i, userHandle.getIdentifier());
        } catch (RemoteException e) {
        }
    }

    public ComponentName getEffectsSuppressor() {
        try {
            return getService().getEffectsSuppressor();
        } catch (RemoteException e) {
            return null;
        }
    }

    public int getShowNotificationForPackageOnKeyguard(String str, int i) {
        getService();
        try {
            return getService().getShowNotificationForPackageOnKeyguard(str, i);
        } catch (RemoteException e) {
            return 1;
        }
    }

    public boolean isSystemConditionProviderEnabled(String str) {
        try {
            return getService().isSystemConditionProviderEnabled(str);
        } catch (RemoteException e) {
            return false;
        }
    }

    public boolean matchesCallFilter(Bundle bundle) {
        try {
            return getService().matchesCallFilter(bundle);
        } catch (RemoteException e) {
            return false;
        }
    }

    public void notify(int i, Notification notification) {
        notify(null, i, notification);
    }

    public void notify(String str, int i, Notification notification) {
        int[] iArr = new int[1];
        INotificationManager service = getService();
        String packageName = this.mContext.getPackageName();
        if (notification.sound != null) {
            notification.sound = notification.sound.getCanonicalUri();
            if (StrictMode.vmFileUriExposureEnabled()) {
                notification.sound.checkFileUriExposed("Notification.sound");
            }
        }
        if (localLOGV) {
            Log.v(TAG, packageName + ": notify(" + i + ", " + notification + ")");
        }
        Notification m115clone = notification.m115clone();
        Notification.Builder.stripForDelivery(m115clone);
        try {
            service.enqueueNotificationWithTag(packageName, this.mContext.getOpPackageName(), str, i, m115clone, iArr, UserHandle.myUserId());
            if (i != iArr[0]) {
                Log.w(TAG, "notify: id corrupted: sent " + i + ", got back " + iArr[0]);
            }
        } catch (RemoteException e) {
        }
    }

    public void notifyAsUser(String str, int i, Notification notification, UserHandle userHandle) {
        int[] iArr = new int[1];
        INotificationManager service = getService();
        String packageName = this.mContext.getPackageName();
        if (notification.sound != null) {
            notification.sound = notification.sound.getCanonicalUri();
            if (StrictMode.vmFileUriExposureEnabled()) {
                notification.sound.checkFileUriExposed("Notification.sound");
            }
        }
        if (localLOGV) {
            Log.v(TAG, packageName + ": notify(" + i + ", " + notification + ")");
        }
        Notification m115clone = notification.m115clone();
        Notification.Builder.stripForDelivery(m115clone);
        try {
            service.enqueueNotificationWithTag(packageName, this.mContext.getOpPackageName(), str, i, m115clone, iArr, userHandle.getIdentifier());
            if (i != iArr[0]) {
                Log.w(TAG, "notify: id corrupted: sent " + i + ", got back " + iArr[0]);
            }
        } catch (RemoteException e) {
        }
    }
}
