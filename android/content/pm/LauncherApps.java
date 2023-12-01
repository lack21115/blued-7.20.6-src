package android.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IOnAppsChangedListener;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/LauncherApps.class */
public class LauncherApps {
    static final boolean DEBUG = false;
    static final String TAG = "LauncherApps";
    private Context mContext;
    private PackageManager mPm;
    private ILauncherApps mService;
    private List<CallbackMessageHandler> mCallbacks = new ArrayList();
    private IOnAppsChangedListener.Stub mAppsChangedListener = new IOnAppsChangedListener.Stub() { // from class: android.content.pm.LauncherApps.1
        @Override // android.content.pm.IOnAppsChangedListener
        public void onPackageAdded(UserHandle userHandle, String str) throws RemoteException {
            synchronized (LauncherApps.this) {
                for (CallbackMessageHandler callbackMessageHandler : LauncherApps.this.mCallbacks) {
                    callbackMessageHandler.postOnPackageAdded(str, userHandle);
                }
            }
        }

        @Override // android.content.pm.IOnAppsChangedListener
        public void onPackageChanged(UserHandle userHandle, String str) throws RemoteException {
            synchronized (LauncherApps.this) {
                for (CallbackMessageHandler callbackMessageHandler : LauncherApps.this.mCallbacks) {
                    callbackMessageHandler.postOnPackageChanged(str, userHandle);
                }
            }
        }

        @Override // android.content.pm.IOnAppsChangedListener
        public void onPackageRemoved(UserHandle userHandle, String str) throws RemoteException {
            synchronized (LauncherApps.this) {
                for (CallbackMessageHandler callbackMessageHandler : LauncherApps.this.mCallbacks) {
                    callbackMessageHandler.postOnPackageRemoved(str, userHandle);
                }
            }
        }

        @Override // android.content.pm.IOnAppsChangedListener
        public void onPackagesAvailable(UserHandle userHandle, String[] strArr, boolean z) throws RemoteException {
            synchronized (LauncherApps.this) {
                for (CallbackMessageHandler callbackMessageHandler : LauncherApps.this.mCallbacks) {
                    callbackMessageHandler.postOnPackagesAvailable(strArr, userHandle, z);
                }
            }
        }

        @Override // android.content.pm.IOnAppsChangedListener
        public void onPackagesUnavailable(UserHandle userHandle, String[] strArr, boolean z) throws RemoteException {
            synchronized (LauncherApps.this) {
                for (CallbackMessageHandler callbackMessageHandler : LauncherApps.this.mCallbacks) {
                    callbackMessageHandler.postOnPackagesUnavailable(strArr, userHandle, z);
                }
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/LauncherApps$Callback.class */
    public static abstract class Callback {
        public abstract void onPackageAdded(String str, UserHandle userHandle);

        public abstract void onPackageChanged(String str, UserHandle userHandle);

        public abstract void onPackageRemoved(String str, UserHandle userHandle);

        public abstract void onPackagesAvailable(String[] strArr, UserHandle userHandle, boolean z);

        public abstract void onPackagesUnavailable(String[] strArr, UserHandle userHandle, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/LauncherApps$CallbackMessageHandler.class */
    public static class CallbackMessageHandler extends Handler {
        private static final int MSG_ADDED = 1;
        private static final int MSG_AVAILABLE = 4;
        private static final int MSG_CHANGED = 3;
        private static final int MSG_REMOVED = 2;
        private static final int MSG_UNAVAILABLE = 5;
        private Callback mCallback;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/content/pm/LauncherApps$CallbackMessageHandler$CallbackInfo.class */
        public static class CallbackInfo {
            String packageName;
            String[] packageNames;
            boolean replacing;
            UserHandle user;

            private CallbackInfo() {
            }
        }

        public CallbackMessageHandler(Looper looper, Callback callback) {
            super(looper, null, true);
            this.mCallback = callback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.mCallback == null || !(message.obj instanceof CallbackInfo)) {
                return;
            }
            CallbackInfo callbackInfo = (CallbackInfo) message.obj;
            switch (message.what) {
                case 1:
                    this.mCallback.onPackageAdded(callbackInfo.packageName, callbackInfo.user);
                    return;
                case 2:
                    this.mCallback.onPackageRemoved(callbackInfo.packageName, callbackInfo.user);
                    return;
                case 3:
                    this.mCallback.onPackageChanged(callbackInfo.packageName, callbackInfo.user);
                    return;
                case 4:
                    this.mCallback.onPackagesAvailable(callbackInfo.packageNames, callbackInfo.user, callbackInfo.replacing);
                    return;
                case 5:
                    this.mCallback.onPackagesUnavailable(callbackInfo.packageNames, callbackInfo.user, callbackInfo.replacing);
                    return;
                default:
                    return;
            }
        }

        public void postOnPackageAdded(String str, UserHandle userHandle) {
            CallbackInfo callbackInfo = new CallbackInfo();
            callbackInfo.packageName = str;
            callbackInfo.user = userHandle;
            obtainMessage(1, callbackInfo).sendToTarget();
        }

        public void postOnPackageChanged(String str, UserHandle userHandle) {
            CallbackInfo callbackInfo = new CallbackInfo();
            callbackInfo.packageName = str;
            callbackInfo.user = userHandle;
            obtainMessage(3, callbackInfo).sendToTarget();
        }

        public void postOnPackageRemoved(String str, UserHandle userHandle) {
            CallbackInfo callbackInfo = new CallbackInfo();
            callbackInfo.packageName = str;
            callbackInfo.user = userHandle;
            obtainMessage(2, callbackInfo).sendToTarget();
        }

        public void postOnPackagesAvailable(String[] strArr, UserHandle userHandle, boolean z) {
            CallbackInfo callbackInfo = new CallbackInfo();
            callbackInfo.packageNames = strArr;
            callbackInfo.replacing = z;
            callbackInfo.user = userHandle;
            obtainMessage(4, callbackInfo).sendToTarget();
        }

        public void postOnPackagesUnavailable(String[] strArr, UserHandle userHandle, boolean z) {
            CallbackInfo callbackInfo = new CallbackInfo();
            callbackInfo.packageNames = strArr;
            callbackInfo.replacing = z;
            callbackInfo.user = userHandle;
            obtainMessage(5, callbackInfo).sendToTarget();
        }
    }

    public LauncherApps(Context context, ILauncherApps iLauncherApps) {
        this.mContext = context;
        this.mService = iLauncherApps;
        this.mPm = context.getPackageManager();
    }

    private void addCallbackLocked(Callback callback, Handler handler) {
        removeCallbackLocked(callback);
        Handler handler2 = handler;
        if (handler == null) {
            handler2 = new Handler();
        }
        this.mCallbacks.add(new CallbackMessageHandler(handler2.getLooper(), callback));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ComponentName getComponentName(ResolveInfo resolveInfo) {
        return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
    }

    private void removeCallbackLocked(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        int size = this.mCallbacks.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            if (this.mCallbacks.get(i2).mCallback == callback) {
                this.mCallbacks.remove(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.util.List] */
    public List<LauncherActivityInfo> getActivityList(String str, UserHandle userHandle) {
        List<ResolveInfo> list;
        ArrayList arrayList;
        try {
            list = this.mService.getLauncherActivities(str, userHandle);
        } catch (RemoteException e) {
            list = null;
        }
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList = arrayList2;
                if (i2 >= size) {
                    break;
                }
                ResolveInfo resolveInfo = list.get(i2);
                long j = 0;
                try {
                    j = this.mPm.getPackageInfo(resolveInfo.activityInfo.packageName, 8192).firstInstallTime;
                } catch (PackageManager.NameNotFoundException e2) {
                }
                arrayList2.add(new LauncherActivityInfo(this.mContext, resolveInfo, userHandle, j));
                i = i2 + 1;
            }
        } else {
            arrayList = Collections.EMPTY_LIST;
        }
        return arrayList;
    }

    public boolean isActivityEnabled(ComponentName componentName, UserHandle userHandle) {
        try {
            return this.mService.isActivityEnabled(componentName, userHandle);
        } catch (RemoteException e) {
            throw new RuntimeException("Failed to call LauncherAppsService");
        }
    }

    public boolean isPackageEnabled(String str, UserHandle userHandle) {
        try {
            return this.mService.isPackageEnabled(str, userHandle);
        } catch (RemoteException e) {
            throw new RuntimeException("Failed to call LauncherAppsService");
        }
    }

    public void registerCallback(Callback callback) {
        registerCallback(callback, null);
    }

    public void registerCallback(Callback callback, Handler handler) {
        synchronized (this) {
            if (callback != null) {
                if (!this.mCallbacks.contains(callback)) {
                    boolean z = this.mCallbacks.size() == 0;
                    addCallbackLocked(callback, handler);
                    if (z) {
                        try {
                            this.mService.addOnAppsChangedListener(this.mAppsChangedListener);
                        } catch (RemoteException e) {
                        }
                    }
                }
            }
        }
    }

    public LauncherActivityInfo resolveActivity(Intent intent, UserHandle userHandle) {
        try {
            ResolveInfo resolveActivity = this.mService.resolveActivity(intent, userHandle);
            if (resolveActivity != null) {
                long j = 0;
                try {
                    j = this.mPm.getPackageInfo(resolveActivity.activityInfo.packageName, 8192).firstInstallTime;
                } catch (PackageManager.NameNotFoundException e) {
                }
                return new LauncherActivityInfo(this.mContext, resolveActivity, userHandle, j);
            }
            return null;
        } catch (RemoteException e2) {
            throw new RuntimeException("Failed to call LauncherAppsService");
        }
    }

    public void startAppDetailsActivity(ComponentName componentName, UserHandle userHandle, Rect rect, Bundle bundle) {
        try {
            this.mService.showAppDetailsAsUser(componentName, rect, bundle, userHandle);
        } catch (RemoteException e) {
        }
    }

    public void startMainActivity(ComponentName componentName, UserHandle userHandle, Rect rect, Bundle bundle) {
        try {
            this.mService.startActivityAsUser(componentName, rect, bundle, userHandle);
        } catch (RemoteException e) {
        }
    }

    public void unregisterCallback(Callback callback) {
        synchronized (this) {
            removeCallbackLocked(callback);
            if (this.mCallbacks.size() == 0) {
                try {
                    this.mService.removeOnAppsChangedListener(this.mAppsChangedListener);
                } catch (RemoteException e) {
                }
            }
        }
    }
}
