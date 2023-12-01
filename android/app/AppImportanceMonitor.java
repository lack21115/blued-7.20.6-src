package android.app;

import android.app.ActivityManager;
import android.app.IProcessObserver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.SparseArray;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/AppImportanceMonitor.class */
public class AppImportanceMonitor {
    static final int MSG_UPDATE = 1;
    final Context mContext;
    final Handler mHandler;
    final SparseArray<AppEntry> mApps = new SparseArray<>();
    final IProcessObserver mProcessObserver = new IProcessObserver.Stub() { // from class: android.app.AppImportanceMonitor.1
        @Override // android.app.IProcessObserver
        public void onForegroundActivitiesChanged(int i, int i2, boolean z) {
        }

        @Override // android.app.IProcessObserver
        public void onProcessDied(int i, int i2) {
            synchronized (AppImportanceMonitor.this.mApps) {
                AppImportanceMonitor.this.updateImportanceLocked(i, i2, 1000, true);
            }
        }

        @Override // android.app.IProcessObserver
        public void onProcessStateChanged(int i, int i2, int i3) {
            synchronized (AppImportanceMonitor.this.mApps) {
                AppImportanceMonitor.this.updateImportanceLocked(i, i2, ActivityManager.RunningAppProcessInfo.procStateToImportance(i3), true);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/AppImportanceMonitor$AppEntry.class */
    public static class AppEntry {
        final int uid;
        final SparseArray<Integer> procs = new SparseArray<>(1);
        int importance = 1000;

        AppEntry(int i) {
            this.uid = i;
        }
    }

    public AppImportanceMonitor(Context context, Looper looper) {
        this.mContext = context;
        this.mHandler = new Handler(looper) { // from class: android.app.AppImportanceMonitor.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        AppImportanceMonitor.this.onImportanceChanged(message.arg1, message.arg2 & 65535, message.arg2 >> 16);
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        try {
            ActivityManagerNative.getDefault().registerProcessObserver(this.mProcessObserver);
        } catch (RemoteException e) {
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= runningAppProcesses.size()) {
                return;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
            updateImportanceLocked(runningAppProcessInfo.uid, runningAppProcessInfo.pid, runningAppProcessInfo.importance, false);
            i = i2 + 1;
        }
    }

    public int getImportance(int i) {
        AppEntry appEntry = this.mApps.get(i);
        if (appEntry == null) {
            return 1000;
        }
        return appEntry.importance;
    }

    public void onImportanceChanged(int i, int i2, int i3) {
    }

    void updateImportanceLocked(int i, int i2, int i3, boolean z) {
        AppEntry appEntry = this.mApps.get(i);
        AppEntry appEntry2 = appEntry;
        if (appEntry == null) {
            appEntry2 = new AppEntry(i);
            this.mApps.put(i, appEntry2);
        }
        if (i3 >= 1000) {
            appEntry2.procs.remove(i2);
        } else {
            appEntry2.procs.put(i2, Integer.valueOf(i3));
        }
        updateImportanceLocked(appEntry2, z);
    }

    void updateImportanceLocked(AppEntry appEntry, boolean z) {
        int i = 1000;
        int i2 = 0;
        while (i2 < appEntry.procs.size()) {
            int intValue = appEntry.procs.valueAt(i2).intValue();
            int i3 = i;
            if (intValue < i) {
                i3 = intValue;
            }
            i2++;
            i = i3;
        }
        if (i != appEntry.importance) {
            int i4 = appEntry.importance;
            appEntry.importance = i;
            if (i >= 1000) {
                this.mApps.remove(appEntry.uid);
            }
            if (z) {
                this.mHandler.obtainMessage(1, appEntry.uid, i | (i4 << 16)).sendToTarget();
            }
        }
    }
}
