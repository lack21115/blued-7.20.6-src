package android.app;

import android.app.IServiceConnection;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.Trace;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.view.DisplayAdjustments;
import dalvik.system.VMRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;

/* loaded from: source-9557208-dex2jar.jar:android/app/LoadedApk.class */
public final class LoadedApk {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String TAG = "LoadedApk";
    private final ActivityThread mActivityThread;
    private final String mAppDir;
    private Application mApplication;
    private ApplicationInfo mApplicationInfo;
    private final ClassLoader mBaseClassLoader;
    private ClassLoader mClassLoader;
    int mClientCount;
    private final String mDataDir;
    private final File mDataDirFile;
    private final DisplayAdjustments mDisplayAdjustments;
    private final boolean mIncludeCode;
    private final String mLibDir;
    private final String[] mOverlayDirs;
    final String mPackageName;
    private final ArrayMap<Context, ArrayMap<BroadcastReceiver, ReceiverDispatcher>> mReceivers;
    private final boolean mRegisterPackage;
    private final String mResDir;
    Resources mResources;
    private final boolean mSecurityViolation;
    private final ArrayMap<Context, ArrayMap<ServiceConnection, ServiceDispatcher>> mServices;
    private final String[] mSharedLibraries;
    private final String[] mSplitAppDirs;
    private final String[] mSplitResDirs;
    private final ArrayMap<Context, ArrayMap<ServiceConnection, ServiceDispatcher>> mUnboundServices;
    private final ArrayMap<Context, ArrayMap<BroadcastReceiver, ReceiverDispatcher>> mUnregisteredReceivers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/LoadedApk$ReceiverDispatcher.class */
    public static final class ReceiverDispatcher {
        final Handler mActivityThread;
        final Context mContext;
        boolean mForgotten;
        final IIntentReceiver.Stub mIIntentReceiver;
        final Instrumentation mInstrumentation;
        final IntentReceiverLeaked mLocation;
        final BroadcastReceiver mReceiver;
        final boolean mRegistered;
        RuntimeException mUnregisterLocation;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-9557208-dex2jar.jar:android/app/LoadedApk$ReceiverDispatcher$Args.class */
        public final class Args extends BroadcastReceiver.PendingResult implements Runnable {
            private Intent mCurIntent;
            private final boolean mOrdered;

            public Args(Intent intent, int i, String str, Bundle bundle, boolean z, boolean z2, int i2) {
                super(i, str, bundle, ReceiverDispatcher.this.mRegistered ? 1 : 2, z, z2, ReceiverDispatcher.this.mIIntentReceiver.asBinder(), i2, intent.getFlags());
                this.mCurIntent = intent;
                this.mOrdered = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                BroadcastReceiver broadcastReceiver = ReceiverDispatcher.this.mReceiver;
                boolean z = this.mOrdered;
                IActivityManager iActivityManager = ActivityManagerNative.getDefault();
                Intent intent = this.mCurIntent;
                this.mCurIntent = null;
                if (broadcastReceiver == null || ReceiverDispatcher.this.mForgotten) {
                    if (ReceiverDispatcher.this.mRegistered && z) {
                        sendFinished(iActivityManager);
                        return;
                    }
                    return;
                }
                Trace.traceBegin(64L, "broadcastReceiveReg");
                try {
                    ClassLoader classLoader = ReceiverDispatcher.this.mReceiver.getClass().getClassLoader();
                    intent.setExtrasClassLoader(classLoader);
                    setExtrasClassLoader(classLoader);
                    broadcastReceiver.setPendingResult(this);
                    broadcastReceiver.onReceive(ReceiverDispatcher.this.mContext, intent);
                } catch (Exception e) {
                    if (ReceiverDispatcher.this.mRegistered && z) {
                        sendFinished(iActivityManager);
                    }
                    if (ReceiverDispatcher.this.mInstrumentation == null || !ReceiverDispatcher.this.mInstrumentation.onException(ReceiverDispatcher.this.mReceiver, e)) {
                        Trace.traceEnd(64L);
                        throw new RuntimeException("Error receiving broadcast " + intent + " in " + ReceiverDispatcher.this.mReceiver, e);
                    }
                }
                if (broadcastReceiver.getPendingResult() != null) {
                    finish();
                }
                Trace.traceEnd(64L);
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/app/LoadedApk$ReceiverDispatcher$InnerReceiver.class */
        static final class InnerReceiver extends IIntentReceiver.Stub {
            final WeakReference<ReceiverDispatcher> mDispatcher;
            final ReceiverDispatcher mStrongRef;

            InnerReceiver(ReceiverDispatcher receiverDispatcher, boolean z) {
                this.mDispatcher = new WeakReference<>(receiverDispatcher);
                this.mStrongRef = z ? receiverDispatcher : null;
            }

            @Override // android.content.IIntentReceiver
            public void performReceive(Intent intent, int i, String str, Bundle bundle, boolean z, boolean z2, int i2) {
                ReceiverDispatcher receiverDispatcher = this.mDispatcher.get();
                if (receiverDispatcher != null) {
                    receiverDispatcher.performReceive(intent, i, str, bundle, z, z2, i2);
                    return;
                }
                IActivityManager iActivityManager = ActivityManagerNative.getDefault();
                if (bundle != null) {
                    try {
                        bundle.setAllowFds(false);
                    } catch (RemoteException e) {
                        Slog.w(ActivityThread.TAG, "Couldn't finish broadcast to unregistered receiver");
                        return;
                    }
                }
                iActivityManager.finishReceiver(this, i, str, bundle, false, intent.getFlags());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ReceiverDispatcher(BroadcastReceiver broadcastReceiver, Context context, Handler handler, Instrumentation instrumentation, boolean z) {
            if (handler == null) {
                throw new NullPointerException("Handler must not be null");
            }
            this.mIIntentReceiver = new InnerReceiver(this, !z);
            this.mReceiver = broadcastReceiver;
            this.mContext = context;
            this.mActivityThread = handler;
            this.mInstrumentation = instrumentation;
            this.mRegistered = z;
            this.mLocation = new IntentReceiverLeaked(null);
            this.mLocation.fillInStackTrace();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public IIntentReceiver getIIntentReceiver() {
            return this.mIIntentReceiver;
        }

        BroadcastReceiver getIntentReceiver() {
            return this.mReceiver;
        }

        IntentReceiverLeaked getLocation() {
            return this.mLocation;
        }

        RuntimeException getUnregisterLocation() {
            return this.mUnregisterLocation;
        }

        public void performReceive(Intent intent, int i, String str, Bundle bundle, boolean z, boolean z2, int i2) {
            Args args = new Args(intent, i, str, bundle, z, z2, i2);
            if (!this.mActivityThread.post(args) && this.mRegistered && z) {
                args.sendFinished(ActivityManagerNative.getDefault());
            }
        }

        void setUnregisterLocation(RuntimeException runtimeException) {
            this.mUnregisterLocation = runtimeException;
        }

        void validate(Context context, Handler handler) {
            if (this.mContext != context) {
                throw new IllegalStateException("Receiver " + this.mReceiver + " registered with differing Context (was " + this.mContext + " now " + context + ")");
            }
            if (this.mActivityThread != handler) {
                throw new IllegalStateException("Receiver " + this.mReceiver + " registered with differing handler (was " + this.mActivityThread + " now " + handler + ")");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/LoadedApk$ServiceDispatcher.class */
    public static final class ServiceDispatcher {
        private final Handler mActivityThread;
        private final ServiceConnection mConnection;
        private final Context mContext;
        private boolean mDied;
        private final int mFlags;
        private boolean mForgotten;
        private RuntimeException mUnbindLocation;
        private final ArrayMap<ComponentName, ConnectionInfo> mActiveConnections = new ArrayMap<>();
        private final InnerConnection mIServiceConnection = new InnerConnection(this);
        private final ServiceConnectionLeaked mLocation = new ServiceConnectionLeaked(null);

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/app/LoadedApk$ServiceDispatcher$ConnectionInfo.class */
        public static class ConnectionInfo {
            IBinder binder;
            IBinder.DeathRecipient deathMonitor;

            private ConnectionInfo() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/app/LoadedApk$ServiceDispatcher$DeathMonitor.class */
        public final class DeathMonitor implements IBinder.DeathRecipient {
            final ComponentName mName;
            final IBinder mService;

            DeathMonitor(ComponentName componentName, IBinder iBinder) {
                this.mName = componentName;
                this.mService = iBinder;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                ServiceDispatcher.this.death(this.mName, this.mService);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/app/LoadedApk$ServiceDispatcher$InnerConnection.class */
        public static class InnerConnection extends IServiceConnection.Stub {
            final WeakReference<ServiceDispatcher> mDispatcher;

            InnerConnection(ServiceDispatcher serviceDispatcher) {
                this.mDispatcher = new WeakReference<>(serviceDispatcher);
            }

            @Override // android.app.IServiceConnection
            public void connected(ComponentName componentName, IBinder iBinder) throws RemoteException {
                ServiceDispatcher serviceDispatcher = this.mDispatcher.get();
                if (serviceDispatcher != null) {
                    serviceDispatcher.connected(componentName, iBinder);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/app/LoadedApk$ServiceDispatcher$RunConnection.class */
        public final class RunConnection implements Runnable {
            final int mCommand;
            final ComponentName mName;
            final IBinder mService;

            RunConnection(ComponentName componentName, IBinder iBinder, int i) {
                this.mName = componentName;
                this.mService = iBinder;
                this.mCommand = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.mCommand == 0) {
                    ServiceDispatcher.this.doConnected(this.mName, this.mService);
                } else if (this.mCommand == 1) {
                    ServiceDispatcher.this.doDeath(this.mName, this.mService);
                }
            }
        }

        ServiceDispatcher(ServiceConnection serviceConnection, Context context, Handler handler, int i) {
            this.mConnection = serviceConnection;
            this.mContext = context;
            this.mActivityThread = handler;
            this.mLocation.fillInStackTrace();
            this.mFlags = i;
        }

        public void connected(ComponentName componentName, IBinder iBinder) {
            if (this.mActivityThread != null) {
                this.mActivityThread.post(new RunConnection(componentName, iBinder, 0));
            } else {
                doConnected(componentName, iBinder);
            }
        }

        public void death(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                this.mDied = true;
                ConnectionInfo remove = this.mActiveConnections.remove(componentName);
                if (remove == null || remove.binder != iBinder) {
                    return;
                }
                remove.binder.unlinkToDeath(remove.deathMonitor, 0);
                if (this.mActivityThread != null) {
                    this.mActivityThread.post(new RunConnection(componentName, iBinder, 1));
                } else {
                    doDeath(componentName, iBinder);
                }
            }
        }

        public void doConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                if (this.mForgotten) {
                    return;
                }
                ConnectionInfo connectionInfo = this.mActiveConnections.get(componentName);
                if (connectionInfo == null || connectionInfo.binder != iBinder) {
                    if (iBinder != null) {
                        this.mDied = false;
                        ConnectionInfo connectionInfo2 = new ConnectionInfo();
                        connectionInfo2.binder = iBinder;
                        connectionInfo2.deathMonitor = new DeathMonitor(componentName, iBinder);
                        try {
                            iBinder.linkToDeath(connectionInfo2.deathMonitor, 0);
                            this.mActiveConnections.put(componentName, connectionInfo2);
                        } catch (RemoteException e) {
                            this.mActiveConnections.remove(componentName);
                            return;
                        }
                    } else {
                        this.mActiveConnections.remove(componentName);
                    }
                    if (connectionInfo != null) {
                        connectionInfo.binder.unlinkToDeath(connectionInfo.deathMonitor, 0);
                    }
                    if (connectionInfo != null) {
                        this.mConnection.onServiceDisconnected(componentName);
                    }
                    if (iBinder != null) {
                        this.mConnection.onServiceConnected(componentName, iBinder);
                    }
                }
            }
        }

        public void doDeath(ComponentName componentName, IBinder iBinder) {
            this.mConnection.onServiceDisconnected(componentName);
        }

        void doForget() {
            synchronized (this) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.mActiveConnections.size()) {
                        ConnectionInfo valueAt = this.mActiveConnections.valueAt(i2);
                        valueAt.binder.unlinkToDeath(valueAt.deathMonitor, 0);
                        i = i2 + 1;
                    } else {
                        this.mActiveConnections.clear();
                        this.mForgotten = true;
                    }
                }
            }
        }

        int getFlags() {
            return this.mFlags;
        }

        IServiceConnection getIServiceConnection() {
            return this.mIServiceConnection;
        }

        ServiceConnectionLeaked getLocation() {
            return this.mLocation;
        }

        ServiceConnection getServiceConnection() {
            return this.mConnection;
        }

        RuntimeException getUnbindLocation() {
            return this.mUnbindLocation;
        }

        void setUnbindLocation(RuntimeException runtimeException) {
            this.mUnbindLocation = runtimeException;
        }

        void validate(Context context, Handler handler) {
            if (this.mContext != context) {
                throw new RuntimeException("ServiceConnection " + this.mConnection + " registered with differing Context (was " + this.mContext + " now " + context + ")");
            }
            if (this.mActivityThread != handler) {
                throw new RuntimeException("ServiceConnection " + this.mConnection + " registered with differing handler (was " + this.mActivityThread + " now " + handler + ")");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/LoadedApk$WarningContextClassLoader.class */
    public static class WarningContextClassLoader extends ClassLoader {
        private static boolean warned = false;

        private WarningContextClassLoader() {
        }

        private void warn(String str) {
            if (warned) {
                return;
            }
            warned = true;
            Thread.currentThread().setContextClassLoader(getParent());
            Slog.w(ActivityThread.TAG, "ClassLoader." + str + ": The class loader returned by Thread.getContextClassLoader() may fail for processes that host multiple applications. You should explicitly specify a context class loader. For example: Thread.setContextClassLoader(getClass().getClassLoader());");
        }

        @Override // java.lang.ClassLoader
        public void clearAssertionStatus() {
            warn("clearAssertionStatus");
            getParent().clearAssertionStatus();
        }

        @Override // java.lang.ClassLoader
        public URL getResource(String str) {
            warn("getResource");
            return getParent().getResource(str);
        }

        @Override // java.lang.ClassLoader
        public InputStream getResourceAsStream(String str) {
            warn("getResourceAsStream");
            return getParent().getResourceAsStream(str);
        }

        @Override // java.lang.ClassLoader
        public Enumeration<URL> getResources(String str) throws IOException {
            warn("getResources");
            return getParent().getResources(str);
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str) throws ClassNotFoundException {
            warn("loadClass");
            return getParent().loadClass(str);
        }

        @Override // java.lang.ClassLoader
        public void setClassAssertionStatus(String str, boolean z) {
            warn("setClassAssertionStatus");
            getParent().setClassAssertionStatus(str, z);
        }

        @Override // java.lang.ClassLoader
        public void setDefaultAssertionStatus(boolean z) {
            warn("setDefaultAssertionStatus");
            getParent().setDefaultAssertionStatus(z);
        }

        @Override // java.lang.ClassLoader
        public void setPackageAssertionStatus(String str, boolean z) {
            warn("setPackageAssertionStatus");
            getParent().setPackageAssertionStatus(str, z);
        }
    }

    static {
        $assertionsDisabled = !LoadedApk.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoadedApk(ActivityThread activityThread) {
        this.mDisplayAdjustments = new DisplayAdjustments();
        this.mReceivers = new ArrayMap<>();
        this.mUnregisteredReceivers = new ArrayMap<>();
        this.mServices = new ArrayMap<>();
        this.mUnboundServices = new ArrayMap<>();
        this.mClientCount = 0;
        this.mActivityThread = activityThread;
        this.mApplicationInfo = new ApplicationInfo();
        this.mApplicationInfo.packageName = "android";
        this.mPackageName = "android";
        this.mAppDir = null;
        this.mResDir = null;
        this.mSplitAppDirs = null;
        this.mSplitResDirs = null;
        this.mOverlayDirs = null;
        this.mSharedLibraries = null;
        this.mDataDir = null;
        this.mDataDirFile = null;
        this.mLibDir = null;
        this.mBaseClassLoader = null;
        this.mSecurityViolation = false;
        this.mIncludeCode = true;
        this.mRegisterPackage = false;
        this.mClassLoader = ClassLoader.getSystemClassLoader();
        this.mResources = Resources.getSystem();
    }

    public LoadedApk(ActivityThread activityThread, ApplicationInfo applicationInfo, CompatibilityInfo compatibilityInfo, ClassLoader classLoader, boolean z, boolean z2, boolean z3) {
        this.mDisplayAdjustments = new DisplayAdjustments();
        this.mReceivers = new ArrayMap<>();
        this.mUnregisteredReceivers = new ArrayMap<>();
        this.mServices = new ArrayMap<>();
        this.mUnboundServices = new ArrayMap<>();
        this.mClientCount = 0;
        int myUid = Process.myUid();
        ApplicationInfo adjustNativeLibraryPaths = adjustNativeLibraryPaths(applicationInfo);
        this.mActivityThread = activityThread;
        this.mApplicationInfo = adjustNativeLibraryPaths;
        this.mPackageName = adjustNativeLibraryPaths.packageName;
        this.mAppDir = adjustNativeLibraryPaths.sourceDir;
        this.mResDir = adjustNativeLibraryPaths.uid == myUid ? adjustNativeLibraryPaths.sourceDir : adjustNativeLibraryPaths.publicSourceDir;
        this.mSplitAppDirs = adjustNativeLibraryPaths.splitSourceDirs;
        this.mSplitResDirs = adjustNativeLibraryPaths.uid == myUid ? adjustNativeLibraryPaths.splitSourceDirs : adjustNativeLibraryPaths.splitPublicSourceDirs;
        this.mOverlayDirs = adjustNativeLibraryPaths.resourceDirs;
        if (!UserHandle.isSameUser(adjustNativeLibraryPaths.uid, myUid) && !Process.isIsolated()) {
            adjustNativeLibraryPaths.dataDir = PackageManager.getDataDirForUser(UserHandle.getUserId(myUid), this.mPackageName);
        }
        this.mSharedLibraries = adjustNativeLibraryPaths.sharedLibraryFiles;
        this.mDataDir = adjustNativeLibraryPaths.dataDir;
        this.mDataDirFile = this.mDataDir != null ? new File(this.mDataDir) : null;
        this.mLibDir = adjustNativeLibraryPaths.nativeLibraryDir;
        this.mBaseClassLoader = classLoader;
        this.mSecurityViolation = z;
        this.mIncludeCode = z2;
        this.mRegisterPackage = z3;
        this.mDisplayAdjustments.setCompatibilityInfo(compatibilityInfo);
    }

    private static ApplicationInfo adjustNativeLibraryPaths(ApplicationInfo applicationInfo) {
        if (applicationInfo.primaryCpuAbi == null || applicationInfo.secondaryCpuAbi == null || !VMRuntime.getRuntime().vmInstructionSet().equals(VMRuntime.getInstructionSet(applicationInfo.secondaryCpuAbi))) {
            return applicationInfo;
        }
        ApplicationInfo applicationInfo2 = new ApplicationInfo(applicationInfo);
        applicationInfo2.nativeLibraryDir = applicationInfo2.secondaryNativeLibraryDir;
        return applicationInfo2;
    }

    private static String[] getLibrariesFor(String str) {
        try {
            ApplicationInfo applicationInfo = ActivityThread.getPackageManager().getApplicationInfo(str, 1024, UserHandle.myUserId());
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sharedLibraryFiles;
        } catch (RemoteException e) {
            throw new AssertionError(e);
        }
    }

    private void initializeJavaContextClassLoader() {
        try {
            PackageInfo packageInfo = ActivityThread.getPackageManager().getPackageInfo(this.mPackageName, 0, UserHandle.myUserId());
            if (packageInfo == null) {
                throw new IllegalStateException("Unable to get package info for " + this.mPackageName + "; is package not installed?");
            }
            Thread.currentThread().setContextClassLoader((packageInfo.sharedUserId != null) || (packageInfo.applicationInfo != null && !this.mPackageName.equals(packageInfo.applicationInfo.processName)) ? new WarningContextClassLoader() : this.mClassLoader);
        } catch (RemoteException e) {
            throw new IllegalStateException("Unable to get package info for " + this.mPackageName + "; is system dying?", e);
        }
    }

    private void rewriteRValues(ClassLoader classLoader, String str, int i) {
        Throwable e;
        try {
            try {
                try {
                    classLoader.loadClass(str + ".R").getMethod("onResourcesLoaded", Integer.TYPE).invoke(null, Integer.valueOf(i));
                } catch (IllegalAccessException e2) {
                    e = e2;
                    throw new RuntimeException("Failed to rewrite resource references for " + str, e);
                } catch (InvocationTargetException e3) {
                    e = e3.getCause();
                    throw new RuntimeException("Failed to rewrite resource references for " + str, e);
                }
            } catch (NoSuchMethodException e4) {
            }
        } catch (ClassNotFoundException e5) {
            Log.i(TAG, "No resource references to update in package " + str);
        }
    }

    public IIntentReceiver forgetReceiverDispatcher(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverDispatcher receiverDispatcher;
        ReceiverDispatcher receiverDispatcher2;
        IIntentReceiver iIntentReceiver;
        synchronized (this.mReceivers) {
            ArrayMap<BroadcastReceiver, ReceiverDispatcher> arrayMap = this.mReceivers.get(context);
            if (arrayMap == null || (receiverDispatcher2 = arrayMap.get(broadcastReceiver)) == null) {
                ArrayMap<BroadcastReceiver, ReceiverDispatcher> arrayMap2 = this.mUnregisteredReceivers.get(context);
                if (arrayMap2 == null || (receiverDispatcher = arrayMap2.get(broadcastReceiver)) == null) {
                    if (context == null) {
                        throw new IllegalStateException("Unbinding Receiver " + broadcastReceiver + " from Context that is no longer in use: " + context);
                    }
                    throw new IllegalArgumentException("Receiver not registered: " + broadcastReceiver);
                }
                throw new IllegalArgumentException("Unregistering Receiver " + broadcastReceiver + " that was already unregistered", receiverDispatcher.getUnregisterLocation());
            }
            arrayMap.remove(broadcastReceiver);
            if (arrayMap.size() == 0) {
                this.mReceivers.remove(context);
            }
            if (broadcastReceiver.getDebugUnregister()) {
                ArrayMap<BroadcastReceiver, ReceiverDispatcher> arrayMap3 = this.mUnregisteredReceivers.get(context);
                ArrayMap<BroadcastReceiver, ReceiverDispatcher> arrayMap4 = arrayMap3;
                if (arrayMap3 == null) {
                    arrayMap4 = new ArrayMap<>();
                    this.mUnregisteredReceivers.put(context, arrayMap4);
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Originally unregistered here:");
                illegalArgumentException.fillInStackTrace();
                receiverDispatcher2.setUnregisterLocation(illegalArgumentException);
                arrayMap4.put(broadcastReceiver, receiverDispatcher2);
            }
            receiverDispatcher2.mForgotten = true;
            iIntentReceiver = receiverDispatcher2.getIIntentReceiver();
        }
        return iIntentReceiver;
    }

    public final IServiceConnection forgetServiceDispatcher(Context context, ServiceConnection serviceConnection) {
        ServiceDispatcher serviceDispatcher;
        ServiceDispatcher serviceDispatcher2;
        IServiceConnection iServiceConnection;
        synchronized (this.mServices) {
            ArrayMap<ServiceConnection, ServiceDispatcher> arrayMap = this.mServices.get(context);
            if (arrayMap == null || (serviceDispatcher2 = arrayMap.get(serviceConnection)) == null) {
                ArrayMap<ServiceConnection, ServiceDispatcher> arrayMap2 = this.mUnboundServices.get(context);
                if (arrayMap2 == null || (serviceDispatcher = arrayMap2.get(serviceConnection)) == null) {
                    if (context == null) {
                        throw new IllegalStateException("Unbinding Service " + serviceConnection + " from Context that is no longer in use: " + context);
                    }
                    throw new IllegalArgumentException("Service not registered: " + serviceConnection);
                }
                throw new IllegalArgumentException("Unbinding Service " + serviceConnection + " that was already unbound", serviceDispatcher.getUnbindLocation());
            }
            arrayMap.remove(serviceConnection);
            serviceDispatcher2.doForget();
            if (arrayMap.size() == 0) {
                this.mServices.remove(context);
            }
            if ((serviceDispatcher2.getFlags() & 2) != 0) {
                ArrayMap<ServiceConnection, ServiceDispatcher> arrayMap3 = this.mUnboundServices.get(context);
                ArrayMap<ServiceConnection, ServiceDispatcher> arrayMap4 = arrayMap3;
                if (arrayMap3 == null) {
                    arrayMap4 = new ArrayMap<>();
                    this.mUnboundServices.put(context, arrayMap4);
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Originally unbound here:");
                illegalArgumentException.fillInStackTrace();
                serviceDispatcher2.setUnbindLocation(illegalArgumentException);
                arrayMap4.put(serviceConnection, serviceDispatcher2);
            }
            iServiceConnection = serviceDispatcher2.getIServiceConnection();
        }
        return iServiceConnection;
    }

    public String getAppDir() {
        return this.mAppDir;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Application getApplication() {
        return this.mApplication;
    }

    public ApplicationInfo getApplicationInfo() {
        return this.mApplicationInfo;
    }

    public AssetManager getAssets(ActivityThread activityThread) {
        return getResources(activityThread).getAssets();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f2, code lost:
        if (r6.mAppDir.equals(r0) != false) goto L71;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x020f -> B:19:0x004b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.ClassLoader getClassLoader() {
        /*
            Method dump skipped, instructions count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.LoadedApk.getClassLoader():java.lang.ClassLoader");
    }

    public CompatibilityInfo getCompatibilityInfo() {
        return this.mDisplayAdjustments.getCompatibilityInfo();
    }

    public String getDataDir() {
        return this.mDataDir;
    }

    public File getDataDirFile() {
        return this.mDataDirFile;
    }

    public String getLibDir() {
        return this.mLibDir;
    }

    public String[] getOverlayDirs() {
        return this.mOverlayDirs;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[Catch: all -> 0x009a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x009a, blocks: (B:13:0x003f, B:27:0x0087), top: B:42:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087 A[Catch: all -> 0x009a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x009a, blocks: (B:13:0x003f, B:27:0x0087), top: B:42:0x003c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.IIntentReceiver getReceiverDispatcher(android.content.BroadcastReceiver r9, android.content.Context r10, android.os.Handler r11, android.app.Instrumentation r12, boolean r13) {
        /*
            r8 = this;
            r0 = r8
            android.util.ArrayMap<android.content.Context, android.util.ArrayMap<android.content.BroadcastReceiver, android.app.LoadedApk$ReceiverDispatcher>> r0 = r0.mReceivers
            r17 = r0
            r0 = r17
            monitor-enter(r0)
            r0 = 0
            r14 = r0
            r0 = r13
            if (r0 == 0) goto Lad
            r0 = r8
            android.util.ArrayMap<android.content.Context, android.util.ArrayMap<android.content.BroadcastReceiver, android.app.LoadedApk$ReceiverDispatcher>> r0 = r0.mReceivers     // Catch: java.lang.Throwable -> L94
            r1 = r10
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L94
            android.util.ArrayMap r0 = (android.util.ArrayMap) r0     // Catch: java.lang.Throwable -> L94
            r15 = r0
            r0 = r15
            r14 = r0
            r0 = r15
            if (r0 == 0) goto Lad
            r0 = r15
            r1 = r9
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L94
            android.app.LoadedApk$ReceiverDispatcher r0 = (android.app.LoadedApk.ReceiverDispatcher) r0     // Catch: java.lang.Throwable -> L94
            r16 = r0
            r0 = r15
            r14 = r0
            r0 = r16
            r15 = r0
        L3a:
            r0 = r15
            if (r0 != 0) goto L87
            android.app.LoadedApk$ReceiverDispatcher r0 = new android.app.LoadedApk$ReceiverDispatcher     // Catch: java.lang.Throwable -> L9a
            r1 = r0
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9a
            r11 = r0
            r0 = r13
            if (r0 == 0) goto La8
            r0 = r14
            if (r0 != 0) goto La2
            android.util.ArrayMap r0 = new android.util.ArrayMap     // Catch: java.lang.Throwable -> L9e
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L9e
            r12 = r0
            r0 = r8
            android.util.ArrayMap<android.content.Context, android.util.ArrayMap<android.content.BroadcastReceiver, android.app.LoadedApk$ReceiverDispatcher>> r0 = r0.mReceivers     // Catch: java.lang.Throwable -> L94
            r1 = r10
            r2 = r12
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> L94
            r0 = r12
            r10 = r0
        L6f:
            r0 = r10
            r1 = r9
            r2 = r11
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> L94
            r0 = r11
            r9 = r0
        L78:
            r0 = r9
            r1 = 0
            r0.mForgotten = r1     // Catch: java.lang.Throwable -> L94
            r0 = r9
            android.content.IIntentReceiver r0 = r0.getIIntentReceiver()     // Catch: java.lang.Throwable -> L94
            r9 = r0
            r0 = r17
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L94
            r0 = r9
            return r0
        L87:
            r0 = r15
            r1 = r10
            r2 = r11
            r0.validate(r1, r2)     // Catch: java.lang.Throwable -> L9a
            r0 = r15
            r9 = r0
            goto L78
        L94:
            r9 = move-exception
        L95:
            r0 = r17
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L94
            r0 = r9
            throw r0
        L9a:
            r9 = move-exception
            goto L95
        L9e:
            r9 = move-exception
            goto L95
        La2:
            r0 = r14
            r10 = r0
            goto L6f
        La8:
            r0 = r11
            r9 = r0
            goto L78
        Lad:
            r0 = 0
            r15 = r0
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.LoadedApk.getReceiverDispatcher(android.content.BroadcastReceiver, android.content.Context, android.os.Handler, android.app.Instrumentation, boolean):android.content.IIntentReceiver");
    }

    public String getResDir() {
        return this.mResDir;
    }

    public Resources getResources(ActivityThread activityThread) {
        if (this.mResources == null) {
            this.mResources = activityThread.getTopLevelResources(this.mResDir, this.mSplitResDirs, this.mOverlayDirs, this.mApplicationInfo.sharedLibraryFiles, 0, null, this, activityThread.getSystemContext(), this.mPackageName);
        }
        return this.mResources;
    }

    public final IServiceConnection getServiceDispatcher(ServiceConnection serviceConnection, Context context, Handler handler, int i) {
        ServiceDispatcher serviceDispatcher;
        synchronized (this.mServices) {
            try {
                ArrayMap<ServiceConnection, ServiceDispatcher> arrayMap = this.mServices.get(context);
                ServiceDispatcher serviceDispatcher2 = arrayMap != null ? arrayMap.get(serviceConnection) : null;
                try {
                    if (serviceDispatcher2 == null) {
                        ServiceDispatcher serviceDispatcher3 = new ServiceDispatcher(serviceConnection, context, handler, i);
                        ArrayMap<ServiceConnection, ServiceDispatcher> arrayMap2 = arrayMap;
                        if (arrayMap == null) {
                            arrayMap2 = new ArrayMap<>();
                            this.mServices.put(context, arrayMap2);
                        }
                        arrayMap2.put(serviceConnection, serviceDispatcher3);
                        serviceDispatcher = serviceDispatcher3;
                    } else {
                        serviceDispatcher2.validate(context, handler);
                        serviceDispatcher = serviceDispatcher2;
                    }
                    return serviceDispatcher.getIServiceConnection();
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public String[] getSplitAppDirs() {
        return this.mSplitAppDirs;
    }

    public String[] getSplitResDirs() {
        return this.mSplitResDirs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void installSystemApplicationInfo(ApplicationInfo applicationInfo, ClassLoader classLoader) {
        if (!$assertionsDisabled && !applicationInfo.packageName.equals("android")) {
            throw new AssertionError();
        }
        this.mApplicationInfo = applicationInfo;
        this.mClassLoader = classLoader;
    }

    public boolean isSecurityViolation() {
        return this.mSecurityViolation;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r0 == null) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.app.Application makeApplication(boolean r6, android.app.Instrumentation r7) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.LoadedApk.makeApplication(boolean, android.app.Instrumentation):android.app.Application");
    }

    public void removeContextRegistrations(Context context, String str, String str2) {
        boolean vmRegistrationLeaksEnabled = StrictMode.vmRegistrationLeaksEnabled();
        synchronized (this.mReceivers) {
            ArrayMap<BroadcastReceiver, ReceiverDispatcher> remove = this.mReceivers.remove(context);
            if (remove != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= remove.size()) {
                        break;
                    }
                    ReceiverDispatcher valueAt = remove.valueAt(i2);
                    IntentReceiverLeaked intentReceiverLeaked = new IntentReceiverLeaked(str2 + " " + str + " has leaked IntentReceiver " + valueAt.getIntentReceiver() + " that was originally registered here. Are you missing a call to unregisterReceiver()?");
                    intentReceiverLeaked.setStackTrace(valueAt.getLocation().getStackTrace());
                    Slog.e(ActivityThread.TAG, intentReceiverLeaked.getMessage(), intentReceiverLeaked);
                    if (vmRegistrationLeaksEnabled) {
                        StrictMode.onIntentReceiverLeaked(intentReceiverLeaked);
                    }
                    try {
                        ActivityManagerNative.getDefault().unregisterReceiver(valueAt.getIIntentReceiver());
                    } catch (RemoteException e) {
                    }
                    i = i2 + 1;
                }
            }
            this.mUnregisteredReceivers.remove(context);
        }
        synchronized (this.mServices) {
            ArrayMap<ServiceConnection, ServiceDispatcher> remove2 = this.mServices.remove(context);
            if (remove2 != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= remove2.size()) {
                        break;
                    }
                    ServiceDispatcher valueAt2 = remove2.valueAt(i4);
                    ServiceConnectionLeaked serviceConnectionLeaked = new ServiceConnectionLeaked(str2 + " " + str + " has leaked ServiceConnection " + valueAt2.getServiceConnection() + " that was originally bound here");
                    serviceConnectionLeaked.setStackTrace(valueAt2.getLocation().getStackTrace());
                    Slog.e(ActivityThread.TAG, serviceConnectionLeaked.getMessage(), serviceConnectionLeaked);
                    if (vmRegistrationLeaksEnabled) {
                        StrictMode.onServiceConnectionLeaked(serviceConnectionLeaked);
                    }
                    try {
                        ActivityManagerNative.getDefault().unbindService(valueAt2.getIServiceConnection());
                    } catch (RemoteException e2) {
                    }
                    valueAt2.doForget();
                    i3 = i4 + 1;
                }
            }
            this.mUnboundServices.remove(context);
        }
    }

    public void setCompatibilityInfo(CompatibilityInfo compatibilityInfo) {
        this.mDisplayAdjustments.setCompatibilityInfo(compatibilityInfo);
    }
}
