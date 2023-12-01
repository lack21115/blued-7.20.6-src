package android.app;

import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/app/Service.class */
public abstract class Service extends ContextWrapper implements ComponentCallbacks2 {
    public static final int START_CONTINUATION_MASK = 15;
    public static final int START_FLAG_REDELIVERY = 1;
    public static final int START_FLAG_RETRY = 2;
    public static final int START_NOT_STICKY = 2;
    public static final int START_REDELIVER_INTENT = 3;
    public static final int START_STICKY = 1;
    public static final int START_STICKY_COMPATIBILITY = 0;
    public static final int START_TASK_REMOVED_COMPLETE = 1000;
    private static final String TAG = "Service";
    private IActivityManager mActivityManager;
    private Application mApplication;
    private String mClassName;
    private boolean mStartCompatibility;
    private ActivityThread mThread;
    private IBinder mToken;

    public Service() {
        super(null);
        this.mThread = null;
        this.mClassName = null;
        this.mToken = null;
        this.mApplication = null;
        this.mActivityManager = null;
        this.mStartCompatibility = false;
    }

    public final void attach(Context context, ActivityThread activityThread, String str, IBinder iBinder, Application application, Object obj) {
        attachBaseContext(context);
        this.mThread = activityThread;
        this.mClassName = str;
        this.mToken = iBinder;
        this.mApplication = application;
        this.mActivityManager = (IActivityManager) obj;
        this.mStartCompatibility = getApplicationInfo().targetSdkVersion < 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.println("nothing to dump");
    }

    public final Application getApplication() {
        return this.mApplication;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getClassName() {
        return this.mClassName;
    }

    public abstract IBinder onBind(Intent intent);

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    public void onRebind(Intent intent) {
    }

    @Deprecated
    public void onStart(Intent intent, int i) {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return this.mStartCompatibility ? 0 : 1;
    }

    public void onTaskRemoved(Intent intent) {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }

    @Deprecated
    public final void setForeground(boolean z) {
        Log.w(TAG, "setForeground: ignoring old API call on " + getClass().getName());
    }

    public final void startForeground(int i, Notification notification) {
        try {
            this.mActivityManager.setServiceForeground(new ComponentName(this, this.mClassName), this.mToken, i, notification, true);
        } catch (RemoteException e) {
        }
    }

    public final void stopForeground(boolean z) {
        try {
            this.mActivityManager.setServiceForeground(new ComponentName(this, this.mClassName), this.mToken, 0, null, z);
        } catch (RemoteException e) {
        }
    }

    public final void stopSelf() {
        stopSelf(-1);
    }

    public final void stopSelf(int i) {
        if (this.mActivityManager == null) {
            return;
        }
        try {
            this.mActivityManager.stopServiceToken(new ComponentName(this, this.mClassName), this.mToken, i);
        } catch (RemoteException e) {
        }
    }

    public final boolean stopSelfResult(int i) {
        if (this.mActivityManager == null) {
            return false;
        }
        try {
            return this.mActivityManager.stopServiceToken(new ComponentName(this, this.mClassName), this.mToken, i);
        } catch (RemoteException e) {
            return false;
        }
    }
}
