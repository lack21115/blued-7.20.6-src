package android.app;

import android.R;
import android.app.Activity;
import android.app.IActivityManager;
import android.app.backup.BackupAgent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.IContentProvider;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDebug;
import android.ddm.DdmHandleAppName;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.hardware.display.DisplayManagerGlobal;
import android.net.ConnectivityManager;
import android.net.IConnectivityManager;
import android.net.Proxy;
import android.net.Uri;
import android.opengl.GLUtils;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
import android.os.DropBoxManager;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.provider.Settings;
import android.renderscript.RenderScript;
import android.security.AndroidKeyStoreProvider;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import android.util.PrintWriterPrinter;
import android.util.Slog;
import android.util.SuperNotCalledException;
import android.view.HardwareRenderer;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewRootImpl;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManagerGlobal;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.content.ReferrerIntent;
import com.android.internal.os.BinderInternal;
import com.android.internal.os.RuntimeInit;
import com.android.internal.os.SamplingProfilerIntegration;
import com.android.internal.util.FastPrintWriter;
import com.android.org.conscrypt.OpenSSLSocketImpl;
import com.android.org.conscrypt.TrustedCertificateStore;
import com.cdo.oaps.ad.OapsKey;
import com.google.android.collect.Lists;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.huawei.openalliance.ad.constant.t;
import dalvik.system.CloseGuard;
import dalvik.system.VMDebug;
import dalvik.system.VMRuntime;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.security.Security;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Pattern;
import libcore.io.DropBox;
import libcore.io.EventLogger;
import libcore.io.IoUtils;
import libcore.net.event.NetworkEventDispatcher;

/* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread.class */
public final class ActivityThread {
    private static final int ACTIVITY_THREAD_CHECKIN_VERSION = 3;
    private static final boolean DEBUG_BACKUP = false;
    public static final boolean DEBUG_BROADCAST = false;
    public static final boolean DEBUG_CONFIGURATION = false;
    private static final boolean DEBUG_MEMORY_TRIM = false;
    static final boolean DEBUG_MESSAGES = false;
    private static final boolean DEBUG_PROVIDER = false;
    private static final boolean DEBUG_RESULTS = false;
    private static final boolean DEBUG_SERVICE = false;
    private static final String HEAP_COLUMN = "%13s %8s %8s %8s %8s %8s %8s %8s";
    private static final String HEAP_FULL_COLUMN = "%13s %8s %8s %8s %8s %8s %8s %8s %8s %8s %8s";
    private static final int LOG_ON_PAUSE_CALLED = 30021;
    private static final int LOG_ON_RESUME_CALLED = 30022;
    private static final long MIN_TIME_BETWEEN_GCS = 5000;
    public static final int SERVICE_DONE_EXECUTING_ANON = 0;
    public static final int SERVICE_DONE_EXECUTING_START = 1;
    public static final int SERVICE_DONE_EXECUTING_STOP = 2;
    private static final int SQLITE_MEM_RELEASED_EVENT_LOG_TAG = 75003;
    public static final String TAG = "ActivityThread";
    static final boolean localLOGV = false;
    private static ActivityThread sCurrentActivityThread;
    static Handler sMainThreadHandler;
    static IPackageManager sPackageManager;
    AppBindData mBoundApplication;
    Configuration mCompatConfiguration;
    Configuration mConfiguration;
    int mCurDefaultDisplayDpi;
    boolean mDensityCompatMode;
    Application mInitialApplication;
    Instrumentation mInstrumentation;
    Profiler mProfiler;
    private ContextImpl mSystemContext;
    private static final Bitmap.Config THUMBNAIL_FORMAT = Bitmap.Config.RGB_565;
    private static final Pattern PATTERN_SEMICOLON = Pattern.compile(t.aE);
    private static final ThreadLocal<Intent> sCurrentBroadcastIntent = new ThreadLocal<>();
    final ApplicationThread mAppThread = new ApplicationThread();
    final Looper mLooper = Looper.myLooper();
    final H mH = new H();
    final ArrayMap<IBinder, ActivityClientRecord> mActivities = new ArrayMap<>();
    ActivityClientRecord mNewActivities = null;
    int mNumVisibleActivities = 0;
    final ArrayMap<IBinder, Service> mServices = new ArrayMap<>();
    final ArrayList<Application> mAllApplications = new ArrayList<>();
    final ArrayMap<String, BackupAgent> mBackupAgents = new ArrayMap<>();
    String mInstrumentationPackageName = null;
    String mInstrumentationAppDir = null;
    String[] mInstrumentationSplitAppDirs = null;
    String mInstrumentationLibDir = null;
    String mInstrumentedAppDir = null;
    String[] mInstrumentedSplitAppDirs = null;
    String mInstrumentedLibDir = null;
    boolean mSystemThread = false;
    boolean mJitEnabled = false;
    boolean mSomeActivitiesChanged = false;
    final ArrayMap<String, WeakReference<LoadedApk>> mPackages = new ArrayMap<>();
    final ArrayMap<String, WeakReference<LoadedApk>> mResourcePackages = new ArrayMap<>();
    final ArrayList<ActivityClientRecord> mRelaunchingActivities = new ArrayList<>();
    Configuration mPendingConfiguration = null;
    final ArrayMap<ProviderKey, ProviderClientRecord> mProviderMap = new ArrayMap<>();
    final ArrayMap<IBinder, ProviderRefCount> mProviderRefCountMap = new ArrayMap<>();
    final ArrayMap<IBinder, ProviderClientRecord> mLocalProviders = new ArrayMap<>();
    final ArrayMap<ComponentName, ProviderClientRecord> mLocalProvidersByName = new ArrayMap<>();
    final ArrayMap<Activity, ArrayList<OnActivityPausedListener>> mOnPauseListeners = new ArrayMap<>();
    final GcIdler mGcIdler = new GcIdler();
    boolean mGcIdlerScheduled = false;
    Bundle mCoreSettings = null;
    private Configuration mMainThreadConfig = new Configuration();
    private int mThumbnailWidth = -1;
    private int mThumbnailHeight = -1;
    private Bitmap mAvailThumbnailBitmap = null;
    private Canvas mThumbnailCanvas = null;
    private final ResourcesManager mResourcesManager = ResourcesManager.getInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$ActivityClientRecord.class */
    public static final class ActivityClientRecord {
        Activity activity;
        ActivityInfo activityInfo;
        CompatibilityInfo compatInfo;
        Configuration createdConfig;
        int ident;
        Intent intent;
        boolean isForward;
        Activity.NonConfigurationInstances lastNonConfigurationInstances;
        View mPendingRemoveWindow;
        WindowManager mPendingRemoveWindowManager;
        Configuration newConfig;
        boolean onlyLocalRequest;
        LoadedApk packageInfo;
        int pendingConfigChanges;
        List<ReferrerIntent> pendingIntents;
        List<ResultInfo> pendingResults;
        PersistableBundle persistentState;
        ProfilerInfo profilerInfo;
        String referrer;
        boolean startsNotResumed;
        Bundle state;
        IBinder token;
        IVoiceInteractor voiceInteractor;
        Window window;
        Activity parent = null;
        String embeddedID = null;
        boolean paused = false;
        boolean stopped = false;
        boolean hideForNow = false;
        ActivityClientRecord nextIdle = null;

        ActivityClientRecord() {
        }

        public boolean isPersistable() {
            return this.activityInfo.persistableMode == 2;
        }

        public boolean isPreHoneycomb() {
            boolean z = false;
            if (this.activity != null) {
                z = false;
                if (this.activity.getApplicationInfo().targetSdkVersion < 11) {
                    z = true;
                }
            }
            return z;
        }

        public String toString() {
            ComponentName component = this.intent != null ? this.intent.getComponent() : null;
            return "ActivityRecord{" + Integer.toHexString(System.identityHashCode(this)) + " token=" + this.token + " " + (component == null ? "no component name" : component.toShortString()) + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$AppBindData.class */
    public static final class AppBindData {
        ApplicationInfo appInfo;
        CompatibilityInfo compatInfo;
        Configuration config;
        int debugMode;
        boolean enableOpenGlTrace;
        LoadedApk info;
        ProfilerInfo initProfilerInfo;
        Bundle instrumentationArgs;
        ComponentName instrumentationName;
        IUiAutomationConnection instrumentationUiAutomationConnection;
        IInstrumentationWatcher instrumentationWatcher;
        boolean persistent;
        String processName;
        List<ProviderInfo> providers;
        boolean restrictedBackupMode;

        AppBindData() {
        }

        public String toString() {
            return "AppBindData{appInfo=" + this.appInfo + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$ApplicationThread.class */
    public class ApplicationThread extends ApplicationThreadNative {
        private static final String DB_INFO_FORMAT = "  %8s %8s %14s %14s  %s";
        private static final String ONE_COUNT_COLUMN = "%21s %8d";
        private static final String TWO_COUNT_COLUMNS = "%21s %8d %21s %8d";
        private int mLastProcessState;

        private ApplicationThread() {
            this.mLastProcessState = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dumpDatabaseInfo(FileDescriptor fileDescriptor, String[] strArr) {
            FastPrintWriter fastPrintWriter = new FastPrintWriter(new FileOutputStream(fileDescriptor));
            SQLiteDebug.dump(new PrintWriterPrinter(fastPrintWriter), strArr);
            fastPrintWriter.flush();
        }

        private void dumpMemInfo(PrintWriter printWriter, Debug.MemoryInfo memoryInfo, boolean z, boolean z2, boolean z3) {
            long nativeHeapSize = Debug.getNativeHeapSize() / 1024;
            long nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize() / 1024;
            long nativeHeapFreeSize = Debug.getNativeHeapFreeSize() / 1024;
            Runtime runtime = Runtime.getRuntime();
            long j = runtime.totalMemory() / 1024;
            long freeMemory = runtime.freeMemory() / 1024;
            long viewInstanceCount = ViewDebug.getViewInstanceCount();
            long viewRootImplCount = ViewDebug.getViewRootImplCount();
            long countInstancesOfClass = Debug.countInstancesOfClass(ContextImpl.class);
            long countInstancesOfClass2 = Debug.countInstancesOfClass(Activity.class);
            int globalAssetCount = AssetManager.getGlobalAssetCount();
            int globalAssetManagerCount = AssetManager.getGlobalAssetManagerCount();
            int binderLocalObjectCount = Debug.getBinderLocalObjectCount();
            int binderProxyObjectCount = Debug.getBinderProxyObjectCount();
            int binderDeathObjectCount = Debug.getBinderDeathObjectCount();
            long globalAllocSize = Parcel.getGlobalAllocSize();
            long globalAllocCount = Parcel.getGlobalAllocCount();
            long countInstancesOfClass3 = Debug.countInstancesOfClass(OpenSSLSocketImpl.class);
            SQLiteDebug.PagerStats databaseInfo = SQLiteDebug.getDatabaseInfo();
            ActivityThread.dumpMemInfoTable(printWriter, memoryInfo, z, z2, z3, Process.myPid(), ActivityThread.this.mBoundApplication != null ? ActivityThread.this.mBoundApplication.processName : "unknown", nativeHeapSize, nativeHeapAllocatedSize, nativeHeapFreeSize, j, j - freeMemory, freeMemory);
            if (!z) {
                printWriter.println(" ");
                printWriter.println(" Objects");
                ActivityThread.printRow(printWriter, TWO_COUNT_COLUMNS, "Views:", Long.valueOf(viewInstanceCount), "ViewRootImpl:", Long.valueOf(viewRootImplCount));
                ActivityThread.printRow(printWriter, TWO_COUNT_COLUMNS, "AppContexts:", Long.valueOf(countInstancesOfClass), "Activities:", Long.valueOf(countInstancesOfClass2));
                ActivityThread.printRow(printWriter, TWO_COUNT_COLUMNS, "Assets:", Integer.valueOf(globalAssetCount), "AssetManagers:", Integer.valueOf(globalAssetManagerCount));
                ActivityThread.printRow(printWriter, TWO_COUNT_COLUMNS, "Local Binders:", Integer.valueOf(binderLocalObjectCount), "Proxy Binders:", Integer.valueOf(binderProxyObjectCount));
                ActivityThread.printRow(printWriter, TWO_COUNT_COLUMNS, "Parcel memory:", Long.valueOf(globalAllocSize / 1024), "Parcel count:", Long.valueOf(globalAllocCount));
                ActivityThread.printRow(printWriter, TWO_COUNT_COLUMNS, "Death Recipients:", Integer.valueOf(binderDeathObjectCount), "OpenSSL Sockets:", Long.valueOf(countInstancesOfClass3));
                printWriter.println(" ");
                printWriter.println(" SQL");
                ActivityThread.printRow(printWriter, ONE_COUNT_COLUMN, "MEMORY_USED:", Integer.valueOf(databaseInfo.memoryUsed / 1024));
                ActivityThread.printRow(printWriter, TWO_COUNT_COLUMNS, "PAGECACHE_OVERFLOW:", Integer.valueOf(databaseInfo.pageCacheOverflow / 1024), "MALLOC_SIZE:", Integer.valueOf(databaseInfo.largestMemAlloc / 1024));
                printWriter.println(" ");
                int size = databaseInfo.dbStats.size();
                if (size > 0) {
                    printWriter.println(" DATABASES");
                    ActivityThread.printRow(printWriter, DB_INFO_FORMAT, "pgsz", "dbsz", "Lookaside(b)", "cache", "Dbname");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        SQLiteDebug.DbStats dbStats = databaseInfo.dbStats.get(i2);
                        ActivityThread.printRow(printWriter, DB_INFO_FORMAT, dbStats.pageSize > 0 ? String.valueOf(dbStats.pageSize) : " ", dbStats.dbSize > 0 ? String.valueOf(dbStats.dbSize) : " ", dbStats.lookaside > 0 ? String.valueOf(dbStats.lookaside) : " ", dbStats.cache, dbStats.dbName);
                        i = i2 + 1;
                    }
                }
                String assetAllocations = AssetManager.getAssetAllocations();
                if (assetAllocations != null) {
                    printWriter.println(" ");
                    printWriter.println(" Asset Allocations");
                    printWriter.print(assetAllocations);
                    return;
                }
                return;
            }
            printWriter.print(viewInstanceCount);
            printWriter.print(',');
            printWriter.print(viewRootImplCount);
            printWriter.print(',');
            printWriter.print(countInstancesOfClass);
            printWriter.print(',');
            printWriter.print(countInstancesOfClass2);
            printWriter.print(',');
            printWriter.print(globalAssetCount);
            printWriter.print(',');
            printWriter.print(globalAssetManagerCount);
            printWriter.print(',');
            printWriter.print(binderLocalObjectCount);
            printWriter.print(',');
            printWriter.print(binderProxyObjectCount);
            printWriter.print(',');
            printWriter.print(binderDeathObjectCount);
            printWriter.print(',');
            printWriter.print(countInstancesOfClass3);
            printWriter.print(',');
            printWriter.print(databaseInfo.memoryUsed / 1024);
            printWriter.print(',');
            printWriter.print(databaseInfo.memoryUsed / 1024);
            printWriter.print(',');
            printWriter.print(databaseInfo.pageCacheOverflow / 1024);
            printWriter.print(',');
            printWriter.print(databaseInfo.largestMemAlloc / 1024);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= databaseInfo.dbStats.size()) {
                    printWriter.println();
                    return;
                }
                SQLiteDebug.DbStats dbStats2 = databaseInfo.dbStats.get(i4);
                printWriter.print(',');
                printWriter.print(dbStats2.dbName);
                printWriter.print(',');
                printWriter.print(dbStats2.pageSize);
                printWriter.print(',');
                printWriter.print(dbStats2.dbSize);
                printWriter.print(',');
                printWriter.print(dbStats2.lookaside);
                printWriter.print(',');
                printWriter.print(dbStats2.cache);
                printWriter.print(',');
                printWriter.print(dbStats2.cache);
                i3 = i4 + 1;
            }
        }

        private void updatePendingConfiguration(Configuration configuration) {
            synchronized (ActivityThread.this.mResourcesManager) {
                if (ActivityThread.this.mPendingConfiguration == null || ActivityThread.this.mPendingConfiguration.isOtherSeqNewer(configuration)) {
                    ActivityThread.this.mPendingConfiguration = configuration;
                }
            }
        }

        @Override // android.app.IApplicationThread
        public final void bindApplication(String str, ApplicationInfo applicationInfo, List<ProviderInfo> list, ComponentName componentName, ProfilerInfo profilerInfo, Bundle bundle, IInstrumentationWatcher iInstrumentationWatcher, IUiAutomationConnection iUiAutomationConnection, int i, boolean z, boolean z2, boolean z3, Configuration configuration, CompatibilityInfo compatibilityInfo, Map<String, IBinder> map, Bundle bundle2) {
            if (map != null) {
                ServiceManager.initServiceCache(map);
            }
            setCoreSettings(bundle2);
            PackageInfo packageInfo = null;
            try {
                packageInfo = ActivityThread.getPackageManager().getPackageInfo(applicationInfo.packageName, 0, UserHandle.myUserId());
            } catch (RemoteException e) {
            }
            if (packageInfo != null) {
                if (!((packageInfo.sharedUserId != null) || (packageInfo.applicationInfo != null && !applicationInfo.packageName.equals(packageInfo.applicationInfo.processName)))) {
                    VMRuntime.registerAppInfo(applicationInfo.packageName, applicationInfo.dataDir, applicationInfo.processName);
                }
            }
            AppBindData appBindData = new AppBindData();
            appBindData.processName = str;
            appBindData.appInfo = applicationInfo;
            appBindData.providers = list;
            appBindData.instrumentationName = componentName;
            appBindData.instrumentationArgs = bundle;
            appBindData.instrumentationWatcher = iInstrumentationWatcher;
            appBindData.instrumentationUiAutomationConnection = iUiAutomationConnection;
            appBindData.debugMode = i;
            appBindData.enableOpenGlTrace = z;
            appBindData.restrictedBackupMode = z2;
            appBindData.persistent = z3;
            appBindData.config = configuration;
            appBindData.compatInfo = compatibilityInfo;
            appBindData.initProfilerInfo = profilerInfo;
            ActivityThread.this.sendMessage(110, appBindData);
        }

        @Override // android.app.IApplicationThread
        public void clearDnsCache() {
            InetAddress.clearDnsCache();
            NetworkEventDispatcher.getInstance().onNetworkConfigurationChanged();
        }

        @Override // android.app.IApplicationThread
        public void dispatchPackageBroadcast(int i, String[] strArr) {
            ActivityThread.this.sendMessage(133, strArr, i);
        }

        @Override // android.app.IApplicationThread
        public void dumpActivity(FileDescriptor fileDescriptor, IBinder iBinder, String str, String[] strArr) {
            DumpComponentInfo dumpComponentInfo = new DumpComponentInfo();
            try {
                dumpComponentInfo.fd = ParcelFileDescriptor.dup(fileDescriptor);
                dumpComponentInfo.token = iBinder;
                dumpComponentInfo.prefix = str;
                dumpComponentInfo.args = strArr;
                ActivityThread.this.sendMessage(136, dumpComponentInfo, 0, 0, true);
            } catch (IOException e) {
                Slog.w(ActivityThread.TAG, "dumpActivity failed", e);
            }
        }

        @Override // android.app.IApplicationThread
        public void dumpDbInfo(final FileDescriptor fileDescriptor, final String[] strArr) {
            if (ActivityThread.this.mSystemThread) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: android.app.ActivityThread.ApplicationThread.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ApplicationThread.this.dumpDatabaseInfo(fileDescriptor, strArr);
                    }
                });
            } else {
                dumpDatabaseInfo(fileDescriptor, strArr);
            }
        }

        @Override // android.app.IApplicationThread
        public void dumpGfxInfo(FileDescriptor fileDescriptor, String[] strArr) {
            ActivityThread.this.dumpGraphicsInfo(fileDescriptor);
            WindowManagerGlobal.getInstance().dumpGfxInfo(fileDescriptor);
        }

        @Override // android.app.IApplicationThread
        public void dumpHeap(boolean z, String str, ParcelFileDescriptor parcelFileDescriptor) {
            DumpHeapData dumpHeapData = new DumpHeapData();
            dumpHeapData.path = str;
            dumpHeapData.fd = parcelFileDescriptor;
            ActivityThread.this.sendMessage(135, dumpHeapData, z ? 1 : 0, 0, true);
        }

        @Override // android.app.IApplicationThread
        public void dumpMemInfo(FileDescriptor fileDescriptor, Debug.MemoryInfo memoryInfo, boolean z, boolean z2, boolean z3, String[] strArr) {
            FastPrintWriter fastPrintWriter = new FastPrintWriter(new FileOutputStream(fileDescriptor));
            try {
                dumpMemInfo(fastPrintWriter, memoryInfo, z, z2, z3);
            } finally {
                fastPrintWriter.flush();
            }
        }

        @Override // android.app.IApplicationThread
        public void dumpProvider(FileDescriptor fileDescriptor, IBinder iBinder, String[] strArr) {
            DumpComponentInfo dumpComponentInfo = new DumpComponentInfo();
            try {
                dumpComponentInfo.fd = ParcelFileDescriptor.dup(fileDescriptor);
                dumpComponentInfo.token = iBinder;
                dumpComponentInfo.args = strArr;
                ActivityThread.this.sendMessage(141, dumpComponentInfo, 0, 0, true);
            } catch (IOException e) {
                Slog.w(ActivityThread.TAG, "dumpProvider failed", e);
            }
        }

        @Override // android.app.IApplicationThread
        public void dumpService(FileDescriptor fileDescriptor, IBinder iBinder, String[] strArr) {
            DumpComponentInfo dumpComponentInfo = new DumpComponentInfo();
            try {
                dumpComponentInfo.fd = ParcelFileDescriptor.dup(fileDescriptor);
                dumpComponentInfo.token = iBinder;
                dumpComponentInfo.args = strArr;
                ActivityThread.this.sendMessage(123, dumpComponentInfo, 0, 0, true);
            } catch (IOException e) {
                Slog.w(ActivityThread.TAG, "dumpService failed", e);
            }
        }

        @Override // android.app.IApplicationThread
        public void processInBackground() {
            ActivityThread.this.mH.removeMessages(120);
            ActivityThread.this.mH.sendMessage(ActivityThread.this.mH.obtainMessage(120));
        }

        @Override // android.app.IApplicationThread
        public void profilerControl(boolean z, ProfilerInfo profilerInfo, int i) {
            ActivityThread.this.sendMessage(127, profilerInfo, z ? 1 : 0, i);
        }

        @Override // android.app.IApplicationThread
        public void requestAssistContextExtras(IBinder iBinder, IBinder iBinder2, int i) {
            RequestAssistContextExtras requestAssistContextExtras = new RequestAssistContextExtras();
            requestAssistContextExtras.activityToken = iBinder;
            requestAssistContextExtras.requestToken = iBinder2;
            requestAssistContextExtras.requestType = i;
            ActivityThread.this.sendMessage(143, requestAssistContextExtras);
        }

        @Override // android.app.IApplicationThread
        public void scheduleActivityConfigurationChanged(IBinder iBinder) {
            ActivityThread.this.sendMessage(125, iBinder);
        }

        @Override // android.app.IApplicationThread
        public void scheduleBackgroundVisibleBehindChanged(IBinder iBinder, boolean z) {
            ActivityThread.this.sendMessage(148, iBinder, z ? 1 : 0);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleBindService(IBinder iBinder, Intent intent, boolean z, int i) {
            updateProcessState(i, false);
            BindServiceData bindServiceData = new BindServiceData();
            bindServiceData.token = iBinder;
            bindServiceData.intent = intent;
            bindServiceData.rebind = z;
            ActivityThread.this.sendMessage(121, bindServiceData);
        }

        @Override // android.app.IApplicationThread
        public void scheduleCancelVisibleBehind(IBinder iBinder) {
            ActivityThread.this.sendMessage(147, iBinder);
        }

        @Override // android.app.IApplicationThread
        public void scheduleConfigurationChanged(Configuration configuration) {
            updatePendingConfiguration(configuration);
            ActivityThread.this.sendMessage(118, configuration);
        }

        @Override // android.app.IApplicationThread
        public void scheduleCrash(String str) {
            ActivityThread.this.sendMessage(134, str);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleCreateBackupAgent(ApplicationInfo applicationInfo, CompatibilityInfo compatibilityInfo, int i) {
            CreateBackupAgentData createBackupAgentData = new CreateBackupAgentData();
            createBackupAgentData.appInfo = applicationInfo;
            createBackupAgentData.compatInfo = compatibilityInfo;
            createBackupAgentData.backupMode = i;
            ActivityThread.this.sendMessage(128, createBackupAgentData);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleCreateService(IBinder iBinder, ServiceInfo serviceInfo, CompatibilityInfo compatibilityInfo, int i) {
            updateProcessState(i, false);
            CreateServiceData createServiceData = new CreateServiceData();
            createServiceData.token = iBinder;
            createServiceData.info = serviceInfo;
            createServiceData.compatInfo = compatibilityInfo;
            ActivityThread.this.sendMessage(114, createServiceData);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleDestroyActivity(IBinder iBinder, boolean z, int i) {
            ActivityThread.this.sendMessage(109, iBinder, z ? 1 : 0, i);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleDestroyBackupAgent(ApplicationInfo applicationInfo, CompatibilityInfo compatibilityInfo) {
            CreateBackupAgentData createBackupAgentData = new CreateBackupAgentData();
            createBackupAgentData.appInfo = applicationInfo;
            createBackupAgentData.compatInfo = compatibilityInfo;
            ActivityThread.this.sendMessage(129, createBackupAgentData);
        }

        @Override // android.app.IApplicationThread
        public void scheduleEnterAnimationComplete(IBinder iBinder) {
            ActivityThread.this.sendMessage(149, iBinder);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleExit() {
            ActivityThread.this.sendMessage(111, null);
        }

        @Override // android.app.IApplicationThread
        public void scheduleInstallProvider(ProviderInfo providerInfo) {
            ActivityThread.this.sendMessage(145, providerInfo);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleLaunchActivity(Intent intent, IBinder iBinder, int i, ActivityInfo activityInfo, Configuration configuration, CompatibilityInfo compatibilityInfo, String str, IVoiceInteractor iVoiceInteractor, int i2, Bundle bundle, PersistableBundle persistableBundle, List<ResultInfo> list, List<ReferrerIntent> list2, boolean z, boolean z2, ProfilerInfo profilerInfo) {
            updateProcessState(i2, false);
            ActivityClientRecord activityClientRecord = new ActivityClientRecord();
            activityClientRecord.token = iBinder;
            activityClientRecord.ident = i;
            activityClientRecord.intent = intent;
            activityClientRecord.referrer = str;
            activityClientRecord.voiceInteractor = iVoiceInteractor;
            activityClientRecord.activityInfo = activityInfo;
            activityClientRecord.compatInfo = compatibilityInfo;
            activityClientRecord.state = bundle;
            activityClientRecord.persistentState = persistableBundle;
            activityClientRecord.pendingResults = list;
            activityClientRecord.pendingIntents = list2;
            activityClientRecord.startsNotResumed = z;
            activityClientRecord.isForward = z2;
            activityClientRecord.profilerInfo = profilerInfo;
            updatePendingConfiguration(configuration);
            ActivityThread.this.sendMessage(100, activityClientRecord);
        }

        @Override // android.app.IApplicationThread
        public void scheduleLowMemory() {
            ActivityThread.this.sendMessage(124, null);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleNewIntent(List<ReferrerIntent> list, IBinder iBinder) {
            NewIntentData newIntentData = new NewIntentData();
            newIntentData.intents = list;
            newIntentData.token = iBinder;
            ActivityThread.this.sendMessage(112, newIntentData);
        }

        @Override // android.app.IApplicationThread
        public void scheduleOnNewActivityOptions(IBinder iBinder, ActivityOptions activityOptions) {
            ActivityThread.this.sendMessage(146, new Pair(iBinder, activityOptions));
        }

        @Override // android.app.IApplicationThread
        public final void schedulePauseActivity(IBinder iBinder, boolean z, boolean z2, int i, boolean z3) {
            int i2 = 0;
            ActivityThread activityThread = ActivityThread.this;
            int i3 = z ? 102 : 101;
            int i4 = z2 ? 1 : 0;
            if (z3) {
                i2 = 2;
            }
            activityThread.sendMessage(i3, iBinder, i2 | i4, i);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleReceiver(Intent intent, ActivityInfo activityInfo, CompatibilityInfo compatibilityInfo, int i, String str, Bundle bundle, boolean z, int i2, int i3) {
            updateProcessState(i3, false);
            ReceiverData receiverData = new ReceiverData(intent, i, str, bundle, z, false, ActivityThread.this.mAppThread.asBinder(), i2);
            receiverData.info = activityInfo;
            receiverData.compatInfo = compatibilityInfo;
            ActivityThread.this.sendMessage(113, receiverData);
        }

        @Override // android.app.IApplicationThread
        public void scheduleRegisteredReceiver(IIntentReceiver iIntentReceiver, Intent intent, int i, String str, Bundle bundle, boolean z, boolean z2, int i2, int i3) throws RemoteException {
            updateProcessState(i3, false);
            iIntentReceiver.performReceive(intent, i, str, bundle, z, z2, i2);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleRelaunchActivity(IBinder iBinder, List<ResultInfo> list, List<ReferrerIntent> list2, int i, boolean z, Configuration configuration) {
            ActivityThread.this.requestRelaunchActivity(iBinder, list, list2, i, z, configuration, true);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleResumeActivity(IBinder iBinder, int i, boolean z, Bundle bundle) {
            updateProcessState(i, false);
            ActivityThread activityThread = ActivityThread.this;
            int i2 = 0;
            if (z) {
                i2 = 1;
            }
            activityThread.sendMessage(107, iBinder, i2);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleSendResult(IBinder iBinder, List<ResultInfo> list) {
            ResultData resultData = new ResultData();
            resultData.token = iBinder;
            resultData.results = list;
            ActivityThread.this.sendMessage(108, resultData);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleServiceArgs(IBinder iBinder, boolean z, int i, int i2, Intent intent) {
            ServiceArgsData serviceArgsData = new ServiceArgsData();
            serviceArgsData.token = iBinder;
            serviceArgsData.taskRemoved = z;
            serviceArgsData.startId = i;
            serviceArgsData.flags = i2;
            serviceArgsData.args = intent;
            ActivityThread.this.sendMessage(115, serviceArgsData);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleSleeping(IBinder iBinder, boolean z) {
            ActivityThread.this.sendMessage(137, iBinder, z ? 1 : 0);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleStopActivity(IBinder iBinder, boolean z, int i) {
            ActivityThread.this.sendMessage(z ? 103 : 104, iBinder, 0, i);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleStopService(IBinder iBinder) {
            ActivityThread.this.sendMessage(116, iBinder);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleSuicide() {
            ActivityThread.this.sendMessage(130, null);
        }

        @Override // android.app.IApplicationThread
        public void scheduleTranslucentConversionComplete(IBinder iBinder, boolean z) {
            ActivityThread.this.sendMessage(144, iBinder, z ? 1 : 0);
        }

        @Override // android.app.IApplicationThread
        public void scheduleTrimMemory(int i) {
            ActivityThread.this.sendMessage(140, null, i);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleUnbindService(IBinder iBinder, Intent intent) {
            BindServiceData bindServiceData = new BindServiceData();
            bindServiceData.token = iBinder;
            bindServiceData.intent = intent;
            ActivityThread.this.sendMessage(122, bindServiceData);
        }

        @Override // android.app.IApplicationThread
        public final void scheduleWindowVisibility(IBinder iBinder, boolean z) {
            ActivityThread.this.sendMessage(z ? 105 : 106, iBinder);
        }

        @Override // android.app.IApplicationThread
        public void setCoreSettings(Bundle bundle) {
            ActivityThread.this.sendMessage(138, bundle);
        }

        @Override // android.app.IApplicationThread
        public void setHttpProxy(String str, String str2, String str3, Uri uri) {
            if (ConnectivityManager.getProcessDefaultNetwork() != null) {
                Proxy.setHttpProxySystemProperty(ConnectivityManager.from(ActivityThread.this.getSystemContext()).getDefaultProxy());
            } else {
                Proxy.setHttpProxySystemProperty(str, str2, str3, uri);
            }
        }

        @Override // android.app.IApplicationThread
        public void setProcessState(int i) {
            updateProcessState(i, true);
        }

        @Override // android.app.IApplicationThread
        public void setSchedulingGroup(int i) {
            try {
                Process.setProcessGroup(Process.myPid(), i);
            } catch (Exception e) {
                Slog.w(ActivityThread.TAG, "Failed setting process group to " + i, e);
            }
        }

        @Override // android.app.IApplicationThread
        public void unstableProviderDied(IBinder iBinder) {
            ActivityThread.this.sendMessage(142, iBinder);
        }

        @Override // android.app.IApplicationThread
        public void updatePackageCompatibilityInfo(String str, CompatibilityInfo compatibilityInfo) {
            UpdateCompatibilityData updateCompatibilityData = new UpdateCompatibilityData();
            updateCompatibilityData.pkg = str;
            updateCompatibilityData.info = compatibilityInfo;
            ActivityThread.this.sendMessage(139, updateCompatibilityData);
        }

        public void updateProcessState(int i, boolean z) {
            synchronized (this) {
                if (this.mLastProcessState != i) {
                    this.mLastProcessState = i;
                    int i2 = 1;
                    if (i <= 3) {
                        i2 = 0;
                    }
                    VMRuntime.getRuntime().updateProcessState(i2);
                }
            }
        }

        @Override // android.app.IApplicationThread
        public final void updateTimePrefs(boolean z) {
            DateFormat.set24HourTimePref(z);
        }

        @Override // android.app.IApplicationThread
        public void updateTimeZone() {
            TimeZone.setDefault(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$BindServiceData.class */
    public static final class BindServiceData {
        Intent intent;
        boolean rebind;
        IBinder token;

        BindServiceData() {
        }

        public String toString() {
            return "BindServiceData{token=" + this.token + " intent=" + this.intent + "}";
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$ContextCleanupInfo.class */
    static final class ContextCleanupInfo {
        ContextImpl context;
        String what;
        String who;

        ContextCleanupInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$CreateBackupAgentData.class */
    public static final class CreateBackupAgentData {
        ApplicationInfo appInfo;
        int backupMode;
        CompatibilityInfo compatInfo;

        CreateBackupAgentData() {
        }

        public String toString() {
            return "CreateBackupAgentData{appInfo=" + this.appInfo + " backupAgent=" + this.appInfo.backupAgentName + " mode=" + this.backupMode + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$CreateServiceData.class */
    public static final class CreateServiceData {
        CompatibilityInfo compatInfo;
        ServiceInfo info;
        Intent intent;
        IBinder token;

        CreateServiceData() {
        }

        public String toString() {
            return "CreateServiceData{token=" + this.token + " className=" + this.info.name + " packageName=" + this.info.packageName + " intent=" + this.intent + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$DropBoxReporter.class */
    public class DropBoxReporter implements DropBox.Reporter {
        private DropBoxManager dropBox;

        public DropBoxReporter() {
            this.dropBox = (DropBoxManager) ActivityThread.this.getSystemContext().getSystemService(Context.DROPBOX_SERVICE);
        }

        public void addData(String str, byte[] bArr, int i) {
            this.dropBox.addData(str, bArr, i);
        }

        public void addText(String str, String str2) {
            this.dropBox.addText(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$DumpComponentInfo.class */
    public static final class DumpComponentInfo {
        String[] args;
        ParcelFileDescriptor fd;
        String prefix;
        IBinder token;

        DumpComponentInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$DumpHeapData.class */
    public static final class DumpHeapData {
        ParcelFileDescriptor fd;
        String path;

        DumpHeapData() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$EventLoggingReporter.class */
    private static class EventLoggingReporter implements EventLogger.Reporter {
        private EventLoggingReporter() {
        }

        public void report(int i, Object... objArr) {
            EventLog.writeEvent(i, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$GcIdler.class */
    public final class GcIdler implements MessageQueue.IdleHandler {
        GcIdler() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            ActivityThread.this.doGcIfNeeded();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$H.class */
    public class H extends Handler {
        public static final int ACTIVITY_CONFIGURATION_CHANGED = 125;
        public static final int BACKGROUND_VISIBLE_BEHIND_CHANGED = 148;
        public static final int BIND_APPLICATION = 110;
        public static final int BIND_SERVICE = 121;
        public static final int CANCEL_VISIBLE_BEHIND = 147;
        public static final int CLEAN_UP_CONTEXT = 119;
        public static final int CONFIGURATION_CHANGED = 118;
        public static final int CREATE_BACKUP_AGENT = 128;
        public static final int CREATE_SERVICE = 114;
        public static final int DESTROY_ACTIVITY = 109;
        public static final int DESTROY_BACKUP_AGENT = 129;
        public static final int DISPATCH_PACKAGE_BROADCAST = 133;
        public static final int DUMP_ACTIVITY = 136;
        public static final int DUMP_HEAP = 135;
        public static final int DUMP_PROVIDER = 141;
        public static final int DUMP_SERVICE = 123;
        public static final int ENABLE_JIT = 132;
        public static final int ENTER_ANIMATION_COMPLETE = 149;
        public static final int EXIT_APPLICATION = 111;
        public static final int GC_WHEN_IDLE = 120;
        public static final int HIDE_WINDOW = 106;
        public static final int INSTALL_PROVIDER = 145;
        public static final int LAUNCH_ACTIVITY = 100;
        public static final int LOW_MEMORY = 124;
        public static final int NEW_INTENT = 112;
        public static final int ON_NEW_ACTIVITY_OPTIONS = 146;
        public static final int PAUSE_ACTIVITY = 101;
        public static final int PAUSE_ACTIVITY_FINISHING = 102;
        public static final int PROFILER_CONTROL = 127;
        public static final int RECEIVER = 113;
        public static final int RELAUNCH_ACTIVITY = 126;
        public static final int REMOVE_PROVIDER = 131;
        public static final int REQUEST_ASSIST_CONTEXT_EXTRAS = 143;
        public static final int RESUME_ACTIVITY = 107;
        public static final int SCHEDULE_CRASH = 134;
        public static final int SEND_RESULT = 108;
        public static final int SERVICE_ARGS = 115;
        public static final int SET_CORE_SETTINGS = 138;
        public static final int SHOW_WINDOW = 105;
        public static final int SLEEPING = 137;
        public static final int STOP_ACTIVITY_HIDE = 104;
        public static final int STOP_ACTIVITY_SHOW = 103;
        public static final int STOP_SERVICE = 116;
        public static final int SUICIDE = 130;
        public static final int TRANSLUCENT_CONVERSION_COMPLETE = 144;
        public static final int TRIM_MEMORY = 140;
        public static final int UNBIND_SERVICE = 122;
        public static final int UNSTABLE_PROVIDER_DIED = 142;
        public static final int UPDATE_PACKAGE_COMPATIBILITY_INFO = 139;

        private H() {
        }

        private void maybeSnapshot() {
            ContextImpl systemContext;
            if (ActivityThread.this.mBoundApplication == null || !SamplingProfilerIntegration.isEnabled()) {
                return;
            }
            String str = ActivityThread.this.mBoundApplication.info.mPackageName;
            PackageInfo packageInfo = null;
            try {
                systemContext = ActivityThread.this.getSystemContext();
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(ActivityThread.TAG, "cannot get package info for " + str, e);
            }
            if (systemContext == null) {
                Log.e(ActivityThread.TAG, "cannot get a valid context");
                return;
            }
            PackageManager packageManager = systemContext.getPackageManager();
            if (packageManager == null) {
                Log.e(ActivityThread.TAG, "cannot get a valid PackageManager");
                return;
            }
            packageInfo = packageManager.getPackageInfo(str, 1);
            SamplingProfilerIntegration.writeSnapshot(ActivityThread.this.mBoundApplication.processName, packageInfo);
        }

        String codeToString(int i) {
            return Integer.toString(i);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = false;
            switch (message.what) {
                case 100:
                    Trace.traceBegin(64L, "activityStart");
                    ActivityClientRecord activityClientRecord = (ActivityClientRecord) message.obj;
                    activityClientRecord.packageInfo = ActivityThread.this.getPackageInfoNoCheck(activityClientRecord.activityInfo.applicationInfo, activityClientRecord.compatInfo);
                    ActivityThread.this.handleLaunchActivity(activityClientRecord, null);
                    Trace.traceEnd(64L);
                    return;
                case 101:
                    Trace.traceBegin(64L, "activityPause");
                    ActivityThread.this.handlePauseActivity((IBinder) message.obj, false, (message.arg1 & 1) != 0, message.arg2, (message.arg1 & 2) != 0);
                    maybeSnapshot();
                    Trace.traceEnd(64L);
                    return;
                case 102:
                    Trace.traceBegin(64L, "activityPause");
                    ActivityThread.this.handlePauseActivity((IBinder) message.obj, true, (message.arg1 & 1) != 0, message.arg2, (message.arg1 & 1) != 0);
                    Trace.traceEnd(64L);
                    return;
                case 103:
                    Trace.traceBegin(64L, "activityStop");
                    ActivityThread.this.handleStopActivity((IBinder) message.obj, true, message.arg2);
                    Trace.traceEnd(64L);
                    return;
                case 104:
                    Trace.traceBegin(64L, "activityStop");
                    ActivityThread.this.handleStopActivity((IBinder) message.obj, false, message.arg2);
                    Trace.traceEnd(64L);
                    return;
                case 105:
                    Trace.traceBegin(64L, "activityShowWindow");
                    ActivityThread.this.handleWindowVisibility((IBinder) message.obj, true);
                    Trace.traceEnd(64L);
                    return;
                case 106:
                    Trace.traceBegin(64L, "activityHideWindow");
                    ActivityThread.this.handleWindowVisibility((IBinder) message.obj, false);
                    Trace.traceEnd(64L);
                    return;
                case 107:
                    Trace.traceBegin(64L, "activityResume");
                    ActivityThread activityThread = ActivityThread.this;
                    IBinder iBinder = (IBinder) message.obj;
                    if (message.arg1 != 0) {
                        z = true;
                    }
                    activityThread.handleResumeActivity(iBinder, true, z, true);
                    Trace.traceEnd(64L);
                    return;
                case 108:
                    Trace.traceBegin(64L, "activityDeliverResult");
                    ActivityThread.this.handleSendResult((ResultData) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 109:
                    Trace.traceBegin(64L, "activityDestroy");
                    ActivityThread.this.handleDestroyActivity((IBinder) message.obj, message.arg1 != 0, message.arg2, false);
                    Trace.traceEnd(64L);
                    return;
                case 110:
                    Trace.traceBegin(64L, "bindApplication");
                    ActivityThread.this.handleBindApplication((AppBindData) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 111:
                    if (ActivityThread.this.mInitialApplication != null) {
                        ActivityThread.this.mInitialApplication.onTerminate();
                    }
                    Looper.myLooper().quit();
                    return;
                case 112:
                    Trace.traceBegin(64L, "activityNewIntent");
                    ActivityThread.this.handleNewIntent((NewIntentData) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 113:
                    Trace.traceBegin(64L, "broadcastReceiveComp");
                    ActivityThread.this.handleReceiver((ReceiverData) message.obj);
                    maybeSnapshot();
                    Trace.traceEnd(64L);
                    return;
                case 114:
                    Trace.traceBegin(64L, "serviceCreate");
                    ActivityThread.this.handleCreateService((CreateServiceData) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 115:
                    Trace.traceBegin(64L, "serviceStart");
                    ActivityThread.this.handleServiceArgs((ServiceArgsData) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 116:
                    Trace.traceBegin(64L, "serviceStop");
                    ActivityThread.this.handleStopService((IBinder) message.obj);
                    maybeSnapshot();
                    Trace.traceEnd(64L);
                    return;
                case 117:
                default:
                    return;
                case 118:
                    Trace.traceBegin(64L, "configChanged");
                    ActivityThread.this.mCurDefaultDisplayDpi = ((Configuration) message.obj).densityDpi;
                    ActivityThread.this.handleConfigurationChanged((Configuration) message.obj, null);
                    Trace.traceEnd(64L);
                    return;
                case 119:
                    ContextCleanupInfo contextCleanupInfo = (ContextCleanupInfo) message.obj;
                    contextCleanupInfo.context.performFinalCleanup(contextCleanupInfo.who, contextCleanupInfo.what);
                    return;
                case 120:
                    ActivityThread.this.scheduleGcIdler();
                    return;
                case 121:
                    Trace.traceBegin(64L, "serviceBind");
                    ActivityThread.this.handleBindService((BindServiceData) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 122:
                    Trace.traceBegin(64L, "serviceUnbind");
                    ActivityThread.this.handleUnbindService((BindServiceData) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 123:
                    ActivityThread.this.handleDumpService((DumpComponentInfo) message.obj);
                    return;
                case 124:
                    Trace.traceBegin(64L, "lowMemory");
                    ActivityThread.this.handleLowMemory();
                    Trace.traceEnd(64L);
                    return;
                case 125:
                    Trace.traceBegin(64L, "activityConfigChanged");
                    ActivityThread.this.handleActivityConfigurationChanged((IBinder) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 126:
                    Trace.traceBegin(64L, "activityRestart");
                    ActivityThread.this.handleRelaunchActivity((ActivityClientRecord) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 127:
                    ActivityThread.this.handleProfilerControl(message.arg1 != 0, (ProfilerInfo) message.obj, message.arg2);
                    return;
                case 128:
                    Trace.traceBegin(64L, "backupCreateAgent");
                    ActivityThread.this.handleCreateBackupAgent((CreateBackupAgentData) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 129:
                    Trace.traceBegin(64L, "backupDestroyAgent");
                    ActivityThread.this.handleDestroyBackupAgent((CreateBackupAgentData) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 130:
                    Process.killProcess(Process.myPid());
                    return;
                case 131:
                    Trace.traceBegin(64L, "providerRemove");
                    ActivityThread.this.completeRemoveProvider((ProviderRefCount) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 132:
                    ActivityThread.this.ensureJitEnabled();
                    return;
                case 133:
                    Trace.traceBegin(64L, "broadcastPackage");
                    ActivityThread.this.handleDispatchPackageBroadcast(message.arg1, (String[]) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 134:
                    throw new RemoteServiceException((String) message.obj);
                case 135:
                    ActivityThread.handleDumpHeap(message.arg1 != 0, (DumpHeapData) message.obj);
                    return;
                case 136:
                    ActivityThread.this.handleDumpActivity((DumpComponentInfo) message.obj);
                    return;
                case 137:
                    Trace.traceBegin(64L, "sleeping");
                    ActivityThread.this.handleSleeping((IBinder) message.obj, message.arg1 != 0);
                    Trace.traceEnd(64L);
                    return;
                case 138:
                    Trace.traceBegin(64L, "setCoreSettings");
                    ActivityThread.this.handleSetCoreSettings((Bundle) message.obj);
                    Trace.traceEnd(64L);
                    return;
                case 139:
                    ActivityThread.this.handleUpdatePackageCompatibilityInfo((UpdateCompatibilityData) message.obj);
                    return;
                case 140:
                    Trace.traceBegin(64L, "trimMemory");
                    ActivityThread.this.handleTrimMemory(message.arg1);
                    Trace.traceEnd(64L);
                    return;
                case 141:
                    ActivityThread.this.handleDumpProvider((DumpComponentInfo) message.obj);
                    return;
                case 142:
                    ActivityThread.this.handleUnstableProviderDied((IBinder) message.obj, false);
                    return;
                case 143:
                    ActivityThread.this.handleRequestAssistContextExtras((RequestAssistContextExtras) message.obj);
                    return;
                case 144:
                    ActivityThread.this.handleTranslucentConversionComplete((IBinder) message.obj, message.arg1 == 1);
                    return;
                case 145:
                    ActivityThread.this.handleInstallProvider((ProviderInfo) message.obj);
                    return;
                case 146:
                    Pair pair = (Pair) message.obj;
                    ActivityThread.this.onNewActivityOptions((IBinder) pair.first, (ActivityOptions) pair.second);
                    return;
                case 147:
                    ActivityThread.this.handleCancelVisibleBehind((IBinder) message.obj);
                    return;
                case 148:
                    ActivityThread.this.handleOnBackgroundVisibleBehindChanged((IBinder) message.obj, message.arg1 > 0);
                    return;
                case 149:
                    ActivityThread.this.handleEnterAnimationComplete((IBinder) message.obj);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$Idler.class */
    public class Idler implements MessageQueue.IdleHandler {
        private Idler() {
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
        @Override // android.os.MessageQueue.IdleHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean queueIdle() {
            /*
                r5 = this;
                r0 = r5
                android.app.ActivityThread r0 = android.app.ActivityThread.this
                android.app.ActivityThread$ActivityClientRecord r0 = r0.mNewActivities
                r8 = r0
                r0 = 0
                r7 = r0
                r0 = r7
                r6 = r0
                r0 = r5
                android.app.ActivityThread r0 = android.app.ActivityThread.this
                android.app.ActivityThread$AppBindData r0 = r0.mBoundApplication
                if (r0 == 0) goto L36
                r0 = r7
                r6 = r0
                r0 = r5
                android.app.ActivityThread r0 = android.app.ActivityThread.this
                android.app.ActivityThread$Profiler r0 = r0.mProfiler
                android.os.ParcelFileDescriptor r0 = r0.profileFd
                if (r0 == 0) goto L36
                r0 = r7
                r6 = r0
                r0 = r5
                android.app.ActivityThread r0 = android.app.ActivityThread.this
                android.app.ActivityThread$Profiler r0 = r0.mProfiler
                boolean r0 = r0.autoStopProfiler
                if (r0 == 0) goto L36
                r0 = 1
                r6 = r0
            L36:
                r0 = r8
                if (r0 == 0) goto L80
                r0 = r5
                android.app.ActivityThread r0 = android.app.ActivityThread.this
                r1 = 0
                r0.mNewActivities = r1
                android.app.IActivityManager r0 = android.app.ActivityManagerNative.getDefault()
                r10 = r0
            L47:
                r0 = r8
                android.app.Activity r0 = r0.activity
                if (r0 == 0) goto L6d
                r0 = r8
                android.app.Activity r0 = r0.activity
                boolean r0 = r0.mFinished
                if (r0 != 0) goto L6d
                r0 = r10
                r1 = r8
                android.os.IBinder r1 = r1.token     // Catch: android.os.RemoteException -> L97
                r2 = r8
                android.content.res.Configuration r2 = r2.createdConfig     // Catch: android.os.RemoteException -> L97
                r3 = r6
                r0.activityIdle(r1, r2, r3)     // Catch: android.os.RemoteException -> L97
                r0 = r8
                r1 = 0
                r0.createdConfig = r1     // Catch: android.os.RemoteException -> L97
            L6d:
                r0 = r8
                android.app.ActivityThread$ActivityClientRecord r0 = r0.nextIdle
                r9 = r0
                r0 = r8
                r1 = 0
                r0.nextIdle = r1
                r0 = r9
                r8 = r0
                r0 = r9
                if (r0 != 0) goto L47
            L80:
                r0 = r6
                if (r0 == 0) goto L8e
                r0 = r5
                android.app.ActivityThread r0 = android.app.ActivityThread.this
                android.app.ActivityThread$Profiler r0 = r0.mProfiler
                r0.stopProfiling()
            L8e:
                r0 = r5
                android.app.ActivityThread r0 = android.app.ActivityThread.this
                r0.ensureJitEnabled()
                r0 = 0
                return r0
            L97:
                r9 = move-exception
                goto L6d
            */
            throw new UnsupportedOperationException("Method not decompiled: android.app.ActivityThread.Idler.queueIdle():boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$NewIntentData.class */
    public static final class NewIntentData {
        List<ReferrerIntent> intents;
        IBinder token;

        NewIntentData() {
        }

        public String toString() {
            return "NewIntentData{intents=" + this.intents + " token=" + this.token + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$Profiler.class */
    public static final class Profiler {
        boolean autoStopProfiler;
        boolean handlingProfiling;
        ParcelFileDescriptor profileFd;
        String profileFile;
        boolean profiling;
        int samplingInterval;

        Profiler() {
        }

        public void setProfiler(ProfilerInfo profilerInfo) {
            ParcelFileDescriptor parcelFileDescriptor = profilerInfo.profileFd;
            if (this.profiling) {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                        return;
                    } catch (IOException e) {
                        return;
                    }
                }
                return;
            }
            if (this.profileFd != null) {
                try {
                    this.profileFd.close();
                } catch (IOException e2) {
                }
            }
            this.profileFile = profilerInfo.profileFile;
            this.profileFd = parcelFileDescriptor;
            this.samplingInterval = profilerInfo.samplingInterval;
            this.autoStopProfiler = profilerInfo.autoStopProfiler;
        }

        public void startProfiling() {
            boolean z = true;
            if (this.profileFd == null || this.profiling) {
                return;
            }
            try {
                String str = this.profileFile;
                FileDescriptor fileDescriptor = this.profileFd.getFileDescriptor();
                if (this.samplingInterval == 0) {
                    z = false;
                }
                VMDebug.startMethodTracing(str, fileDescriptor, 8388608, 0, z, this.samplingInterval);
                this.profiling = true;
            } catch (RuntimeException e) {
                Slog.w(ActivityThread.TAG, "Profiling failed on path " + this.profileFile);
                try {
                    this.profileFd.close();
                    this.profileFd = null;
                } catch (IOException e2) {
                    Slog.w(ActivityThread.TAG, "Failure closing profile fd", e2);
                }
            }
        }

        public void stopProfiling() {
            if (this.profiling) {
                this.profiling = false;
                Debug.stopMethodTracing();
                if (this.profileFd != null) {
                    try {
                        this.profileFd.close();
                    } catch (IOException e) {
                    }
                }
                this.profileFd = null;
                this.profileFile = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$ProviderClientRecord.class */
    public final class ProviderClientRecord {
        final IActivityManager.ContentProviderHolder mHolder;
        final ContentProvider mLocalProvider;
        final String[] mNames;
        final IContentProvider mProvider;

        ProviderClientRecord(String[] strArr, IContentProvider iContentProvider, ContentProvider contentProvider, IActivityManager.ContentProviderHolder contentProviderHolder) {
            this.mNames = strArr;
            this.mProvider = iContentProvider;
            this.mLocalProvider = contentProvider;
            this.mHolder = contentProviderHolder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$ProviderKey.class */
    public static final class ProviderKey {
        final String authority;
        final int userId;

        public ProviderKey(String str, int i) {
            this.authority = str;
            this.userId = i;
        }

        public boolean equals(Object obj) {
            boolean z = false;
            if (obj instanceof ProviderKey) {
                ProviderKey providerKey = (ProviderKey) obj;
                z = false;
                if (Objects.equals(this.authority, providerKey.authority)) {
                    z = false;
                    if (this.userId == providerKey.userId) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            return (this.authority != null ? this.authority.hashCode() : 0) ^ this.userId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$ProviderRefCount.class */
    public static final class ProviderRefCount {
        public final ProviderClientRecord client;
        public final IActivityManager.ContentProviderHolder holder;
        public boolean removePending;
        public int stableCount;
        public int unstableCount;

        ProviderRefCount(IActivityManager.ContentProviderHolder contentProviderHolder, ProviderClientRecord providerClientRecord, int i, int i2) {
            this.holder = contentProviderHolder;
            this.client = providerClientRecord;
            this.stableCount = i;
            this.unstableCount = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$ReceiverData.class */
    public static final class ReceiverData extends BroadcastReceiver.PendingResult {
        CompatibilityInfo compatInfo;
        ActivityInfo info;
        Intent intent;

        public ReceiverData(Intent intent, int i, String str, Bundle bundle, boolean z, boolean z2, IBinder iBinder, int i2) {
            super(i, str, bundle, 0, z, z2, iBinder, i2, intent.getFlags());
            this.intent = intent;
        }

        public String toString() {
            return "ReceiverData{intent=" + this.intent + " packageName=" + this.info.packageName + " resultCode=" + getResultCode() + " resultData=" + getResultData() + " resultExtras=" + getResultExtras(false) + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$RequestAssistContextExtras.class */
    public static final class RequestAssistContextExtras {
        IBinder activityToken;
        IBinder requestToken;
        int requestType;

        RequestAssistContextExtras() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$ResultData.class */
    public static final class ResultData {
        List<ResultInfo> results;
        IBinder token;

        ResultData() {
        }

        public String toString() {
            return "ResultData{token=" + this.token + " results" + this.results + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$ServiceArgsData.class */
    public static final class ServiceArgsData {
        Intent args;
        int flags;
        int startId;
        boolean taskRemoved;
        IBinder token;

        ServiceArgsData() {
        }

        public String toString() {
            return "ServiceArgsData{token=" + this.token + " startId=" + this.startId + " args=" + this.args + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$StopInfo.class */
    public static class StopInfo implements Runnable {
        ActivityClientRecord activity;
        CharSequence description;
        PersistableBundle persistentState;
        Bundle state;

        private StopInfo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ActivityManagerNative.getDefault().activityStopped(this.activity.token, this.state, this.persistentState, this.description);
            } catch (RemoteException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ActivityThread$UpdateCompatibilityData.class */
    public static final class UpdateCompatibilityData {
        CompatibilityInfo info;
        String pkg;

        UpdateCompatibilityData() {
        }
    }

    ActivityThread() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00b2 -> B:6:0x0039). Please submit an issue!!! */
    private void attach(boolean z) {
        sCurrentActivityThread = this;
        this.mSystemThread = z;
        if (z) {
            DdmHandleAppName.setAppName("system_process", UserHandle.myUserId());
            try {
                this.mInstrumentation = new Instrumentation();
                this.mInitialApplication = ContextImpl.createAppContext(this, getSystemContext().mPackageInfo).mPackageInfo.makeApplication(true, null);
                this.mInitialApplication.onCreate();
            } catch (Exception e) {
                throw new RuntimeException("Unable to instantiate Application():" + e.toString(), e);
            }
        } else {
            ViewRootImpl.addFirstDrawHandler(new Runnable() { // from class: android.app.ActivityThread.1
                @Override // java.lang.Runnable
                public void run() {
                    ActivityThread.this.ensureJitEnabled();
                }
            });
            DdmHandleAppName.setAppName("<pre-initialized>", UserHandle.myUserId());
            RuntimeInit.setApplicationObject(this.mAppThread.asBinder());
            final IActivityManager iActivityManager = ActivityManagerNative.getDefault();
            try {
                iActivityManager.attachApplication(this.mAppThread);
            } catch (RemoteException e2) {
            }
            BinderInternal.addGcWatcher(new Runnable() { // from class: android.app.ActivityThread.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivityThread.this.mSomeActivitiesChanged) {
                        Runtime runtime = Runtime.getRuntime();
                        if (runtime.totalMemory() - runtime.freeMemory() > (3 * runtime.maxMemory()) / 4) {
                            ActivityThread.this.mSomeActivitiesChanged = false;
                            try {
                                iActivityManager.releaseSomeActivities(ActivityThread.this.mAppThread);
                            } catch (RemoteException e3) {
                            }
                        }
                    }
                }
            });
        }
        DropBox.setReporter(new DropBoxReporter());
        ViewRootImpl.addConfigCallback(new ComponentCallbacks2() { // from class: android.app.ActivityThread.3
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                synchronized (ActivityThread.this.mResourcesManager) {
                    if (ActivityThread.this.mResourcesManager.applyConfigurationToResourcesLocked(configuration, null) && (ActivityThread.this.mPendingConfiguration == null || ActivityThread.this.mPendingConfiguration.isOtherSeqNewer(configuration))) {
                        ActivityThread.this.mPendingConfiguration = configuration;
                        ActivityThread.this.sendMessage(118, configuration);
                    }
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i) {
            }
        });
    }

    private void callCallActivityOnSaveInstanceState(ActivityClientRecord activityClientRecord) {
        activityClientRecord.state = new Bundle();
        activityClientRecord.state.setAllowFds(false);
        if (!activityClientRecord.isPersistable()) {
            this.mInstrumentation.callActivityOnSaveInstanceState(activityClientRecord.activity, activityClientRecord.state);
            return;
        }
        activityClientRecord.persistentState = new PersistableBundle();
        this.mInstrumentation.callActivityOnSaveInstanceState(activityClientRecord.activity, activityClientRecord.state, activityClientRecord.persistentState);
    }

    static final void cleanUpPendingRemoveWindows(ActivityClientRecord activityClientRecord) {
        if (activityClientRecord.mPendingRemoveWindow != null) {
            activityClientRecord.mPendingRemoveWindowManager.removeViewImmediate(activityClientRecord.mPendingRemoveWindow);
            IBinder windowToken = activityClientRecord.mPendingRemoveWindow.getWindowToken();
            if (windowToken != null) {
                WindowManagerGlobal.getInstance().closeAll(windowToken, activityClientRecord.activity.getClass().getName(), "Activity");
            }
        }
        activityClientRecord.mPendingRemoveWindow = null;
        activityClientRecord.mPendingRemoveWindowManager = null;
    }

    private Context createBaseContextForActivity(ActivityClientRecord activityClientRecord, Activity activity) {
        Context context;
        ContextImpl createActivityContext = ContextImpl.createActivityContext(this, activityClientRecord.packageInfo, activityClientRecord.token);
        createActivityContext.setOuterContext(activity);
        DisplayManagerGlobal displayManagerGlobal = DisplayManagerGlobal.getInstance();
        try {
            int activityDisplayId = ActivityManagerNative.getDefault().getActivityDisplayId(activityClientRecord.token);
            context = createActivityContext;
            if (activityDisplayId > 0) {
                context = createActivityContext.createDisplayContext(displayManagerGlobal.getRealDisplay(activityDisplayId, activityClientRecord.token));
            }
        } catch (RemoteException e) {
            context = createActivityContext;
        }
        String str = SystemProperties.get("debug.second-display.pkg");
        Context context2 = context;
        if (str != null) {
            context2 = context;
            if (!str.isEmpty()) {
                context2 = context;
                if (activityClientRecord.packageInfo.mPackageName.contains(str)) {
                    int[] displayIds = displayManagerGlobal.getDisplayIds();
                    int length = displayIds.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        context2 = context;
                        if (i2 >= length) {
                            break;
                        }
                        int i3 = displayIds[i2];
                        if (i3 != 0) {
                            context2 = createActivityContext.createDisplayContext(displayManagerGlobal.getRealDisplay(i3, activityClientRecord.token));
                            break;
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        return context2;
    }

    private Bitmap createThumbnailBitmap(ActivityClientRecord activityClientRecord) {
        int i;
        Bitmap bitmap;
        Bitmap bitmap2 = this.mAvailThumbnailBitmap;
        Bitmap bitmap3 = bitmap2;
        if (bitmap2 == null) {
            try {
                int i2 = this.mThumbnailWidth;
                if (i2 < 0) {
                    Resources resources = activityClientRecord.activity.getResources();
                    i2 = resources.getDimensionPixelSize(R.dimen.thumbnail_width);
                    this.mThumbnailWidth = i2;
                    i = resources.getDimensionPixelSize(R.dimen.thumbnail_height);
                    this.mThumbnailHeight = i;
                } else {
                    i = this.mThumbnailHeight;
                }
                bitmap3 = bitmap2;
                if (i2 > 0) {
                    bitmap3 = bitmap2;
                    if (i > 0) {
                        bitmap3 = Bitmap.createBitmap(activityClientRecord.activity.getResources().getDisplayMetrics(), i2, i, THUMBNAIL_FORMAT);
                        bitmap3.eraseColor(0);
                    }
                }
            } catch (Exception e) {
                if (!this.mInstrumentation.onException(activityClientRecord.activity, e)) {
                    throw new RuntimeException("Unable to create thumbnail of " + activityClientRecord.intent.getComponent().toShortString() + ": " + e.toString(), e);
                }
                bitmap = null;
            }
        }
        bitmap = bitmap3;
        if (bitmap3 != null) {
            Canvas canvas = this.mThumbnailCanvas;
            Canvas canvas2 = canvas;
            if (canvas == null) {
                canvas2 = new Canvas();
                this.mThumbnailCanvas = canvas2;
            }
            canvas2.setBitmap(bitmap3);
            Bitmap bitmap4 = bitmap3;
            if (!activityClientRecord.activity.onCreateThumbnail(bitmap3, canvas2)) {
                this.mAvailThumbnailBitmap = bitmap3;
                bitmap4 = null;
            }
            canvas2.setBitmap(null);
            return bitmap4;
        }
        return bitmap;
    }

    public static ActivityThread currentActivityThread() {
        return sCurrentActivityThread;
    }

    public static Application currentApplication() {
        ActivityThread currentActivityThread = currentActivityThread();
        if (currentActivityThread != null) {
            return currentActivityThread.mInitialApplication;
        }
        return null;
    }

    public static String currentPackageName() {
        ActivityThread currentActivityThread = currentActivityThread();
        if (currentActivityThread == null || currentActivityThread.mBoundApplication == null) {
            return null;
        }
        return currentActivityThread.mBoundApplication.appInfo.packageName;
    }

    public static String currentProcessName() {
        ActivityThread currentActivityThread = currentActivityThread();
        if (currentActivityThread == null || currentActivityThread.mBoundApplication == null) {
            return null;
        }
        return currentActivityThread.mBoundApplication.processName;
    }

    private void deliverNewIntents(ActivityClientRecord activityClientRecord, List<ReferrerIntent> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ReferrerIntent referrerIntent = list.get(i2);
            referrerIntent.setExtrasClassLoader(activityClientRecord.activity.getClassLoader());
            referrerIntent.prepareToEnterProcess();
            activityClientRecord.activity.mFragments.noteStateNotSaved();
            this.mInstrumentation.callActivityOnNewIntent(activityClientRecord.activity, referrerIntent);
            i = i2 + 1;
        }
    }

    private void deliverResults(ActivityClientRecord activityClientRecord, List<ResultInfo> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ResultInfo resultInfo = list.get(i2);
            try {
                if (resultInfo.mData != null) {
                    resultInfo.mData.setExtrasClassLoader(activityClientRecord.activity.getClassLoader());
                    resultInfo.mData.prepareToEnterProcess();
                }
                activityClientRecord.activity.dispatchActivityResult(resultInfo.mResultWho, resultInfo.mRequestCode, resultInfo.mResultCode, resultInfo.mData);
            } catch (Exception e) {
                if (!this.mInstrumentation.onException(activityClientRecord.activity, e)) {
                    throw new RuntimeException("Failure delivering result " + resultInfo + " to activity " + activityClientRecord.intent.getComponent().toShortString() + ": " + e.toString(), e);
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void dumpGraphicsInfo(FileDescriptor fileDescriptor);

    public static void dumpMemInfoTable(PrintWriter printWriter, Debug.MemoryInfo memoryInfo, boolean z, boolean z2, boolean z3, int i, String str, long j, long j2, long j3, long j4, long j5, long j6) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (z) {
            printWriter.print(3);
            printWriter.print(',');
            printWriter.print(i);
            printWriter.print(',');
            printWriter.print(str);
            printWriter.print(',');
            printWriter.print(j);
            printWriter.print(',');
            printWriter.print(j4);
            printWriter.print(',');
            printWriter.print("N/A,");
            printWriter.print(j + j4);
            printWriter.print(',');
            printWriter.print(j2);
            printWriter.print(',');
            printWriter.print(j5);
            printWriter.print(',');
            printWriter.print("N/A,");
            printWriter.print(j2 + j5);
            printWriter.print(',');
            printWriter.print(j3);
            printWriter.print(',');
            printWriter.print(j6);
            printWriter.print(',');
            printWriter.print("N/A,");
            printWriter.print(j3 + j6);
            printWriter.print(',');
            printWriter.print(memoryInfo.nativePss);
            printWriter.print(',');
            printWriter.print(memoryInfo.dalvikPss);
            printWriter.print(',');
            printWriter.print(memoryInfo.otherPss);
            printWriter.print(',');
            printWriter.print(memoryInfo.getTotalPss());
            printWriter.print(',');
            printWriter.print(memoryInfo.nativeSwappablePss);
            printWriter.print(',');
            printWriter.print(memoryInfo.dalvikSwappablePss);
            printWriter.print(',');
            printWriter.print(memoryInfo.otherSwappablePss);
            printWriter.print(',');
            printWriter.print(memoryInfo.getTotalSwappablePss());
            printWriter.print(',');
            printWriter.print(memoryInfo.nativeSharedDirty);
            printWriter.print(',');
            printWriter.print(memoryInfo.dalvikSharedDirty);
            printWriter.print(',');
            printWriter.print(memoryInfo.otherSharedDirty);
            printWriter.print(',');
            printWriter.print(memoryInfo.getTotalSharedDirty());
            printWriter.print(',');
            printWriter.print(memoryInfo.nativeSharedClean);
            printWriter.print(',');
            printWriter.print(memoryInfo.dalvikSharedClean);
            printWriter.print(',');
            printWriter.print(memoryInfo.otherSharedClean);
            printWriter.print(',');
            printWriter.print(memoryInfo.getTotalSharedClean());
            printWriter.print(',');
            printWriter.print(memoryInfo.nativePrivateDirty);
            printWriter.print(',');
            printWriter.print(memoryInfo.dalvikPrivateDirty);
            printWriter.print(',');
            printWriter.print(memoryInfo.otherPrivateDirty);
            printWriter.print(',');
            printWriter.print(memoryInfo.getTotalPrivateDirty());
            printWriter.print(',');
            printWriter.print(memoryInfo.nativePrivateClean);
            printWriter.print(',');
            printWriter.print(memoryInfo.dalvikPrivateClean);
            printWriter.print(',');
            printWriter.print(memoryInfo.otherPrivateClean);
            printWriter.print(',');
            printWriter.print(memoryInfo.getTotalPrivateClean());
            printWriter.print(',');
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= 17) {
                    return;
                }
                printWriter.print(Debug.MemoryInfo.getOtherLabel(i10));
                printWriter.print(',');
                printWriter.print(memoryInfo.getOtherPss(i10));
                printWriter.print(',');
                printWriter.print(memoryInfo.getOtherSwappablePss(i10));
                printWriter.print(',');
                printWriter.print(memoryInfo.getOtherSharedDirty(i10));
                printWriter.print(',');
                printWriter.print(memoryInfo.getOtherSharedClean(i10));
                printWriter.print(',');
                printWriter.print(memoryInfo.getOtherPrivateDirty(i10));
                printWriter.print(',');
                printWriter.print(memoryInfo.getOtherPrivateClean(i10));
                printWriter.print(',');
                i9 = i10 + 1;
            }
        } else {
            if (z2) {
                printRow(printWriter, HEAP_FULL_COLUMN, "", "Pss", "Pss", "Shared", "Private", "Shared", "Private", "Swapped", "Heap", "Heap", "Heap");
                printRow(printWriter, HEAP_FULL_COLUMN, "", "Total", "Clean", "Dirty", "Dirty", "Clean", "Clean", "Dirty", "Size", "Alloc", "Free");
                printRow(printWriter, HEAP_FULL_COLUMN, "", "------", "------", "------", "------", "------", "------", "------", "------", "------", "------");
                printRow(printWriter, HEAP_FULL_COLUMN, "Native Heap", Integer.valueOf(memoryInfo.nativePss), Integer.valueOf(memoryInfo.nativeSwappablePss), Integer.valueOf(memoryInfo.nativeSharedDirty), Integer.valueOf(memoryInfo.nativePrivateDirty), Integer.valueOf(memoryInfo.nativeSharedClean), Integer.valueOf(memoryInfo.nativePrivateClean), Integer.valueOf(memoryInfo.nativeSwappedOut), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
                printRow(printWriter, HEAP_FULL_COLUMN, "Dalvik Heap", Integer.valueOf(memoryInfo.dalvikPss), Integer.valueOf(memoryInfo.dalvikSwappablePss), Integer.valueOf(memoryInfo.dalvikSharedDirty), Integer.valueOf(memoryInfo.dalvikPrivateDirty), Integer.valueOf(memoryInfo.dalvikSharedClean), Integer.valueOf(memoryInfo.dalvikPrivateClean), Integer.valueOf(memoryInfo.dalvikSwappedOut), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6));
            } else {
                printRow(printWriter, HEAP_COLUMN, "", "Pss", "Private", "Private", "Swapped", "Heap", "Heap", "Heap");
                printRow(printWriter, HEAP_COLUMN, "", "Total", "Dirty", "Clean", "Dirty", "Size", "Alloc", "Free");
                printRow(printWriter, HEAP_COLUMN, "", "------", "------", "------", "------", "------", "------", "------", "------");
                printRow(printWriter, HEAP_COLUMN, "Native Heap", Integer.valueOf(memoryInfo.nativePss), Integer.valueOf(memoryInfo.nativePrivateDirty), Integer.valueOf(memoryInfo.nativePrivateClean), Integer.valueOf(memoryInfo.nativeSwappedOut), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
                printRow(printWriter, HEAP_COLUMN, "Dalvik Heap", Integer.valueOf(memoryInfo.dalvikPss), Integer.valueOf(memoryInfo.dalvikPrivateDirty), Integer.valueOf(memoryInfo.dalvikPrivateClean), Integer.valueOf(memoryInfo.dalvikSwappedOut), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6));
            }
            int i11 = memoryInfo.otherPss;
            int i12 = memoryInfo.otherSwappablePss;
            int i13 = memoryInfo.otherSharedDirty;
            int i14 = memoryInfo.otherPrivateDirty;
            int i15 = memoryInfo.otherSharedClean;
            int i16 = memoryInfo.otherPrivateClean;
            int i17 = memoryInfo.otherSwappedOut;
            int i18 = 0;
            while (i18 < 17) {
                int otherPss = memoryInfo.getOtherPss(i18);
                int otherSwappablePss = memoryInfo.getOtherSwappablePss(i18);
                int otherSharedDirty = memoryInfo.getOtherSharedDirty(i18);
                int otherPrivateDirty = memoryInfo.getOtherPrivateDirty(i18);
                int otherSharedClean = memoryInfo.getOtherSharedClean(i18);
                int otherPrivateClean = memoryInfo.getOtherPrivateClean(i18);
                int otherSwappedOut = memoryInfo.getOtherSwappedOut(i18);
                if (otherPss == 0 && otherSharedDirty == 0 && otherPrivateDirty == 0 && otherSharedClean == 0 && otherPrivateClean == 0) {
                    i7 = i16;
                    i5 = i14;
                    i2 = i11;
                    i6 = i15;
                    i4 = i13;
                    i3 = i12;
                    i8 = i17;
                    if (otherSwappedOut == 0) {
                        i18++;
                        i16 = i7;
                        i14 = i5;
                        i11 = i2;
                        i15 = i6;
                        i13 = i4;
                        i12 = i3;
                        i17 = i8;
                    }
                }
                if (z2) {
                    printRow(printWriter, HEAP_FULL_COLUMN, Debug.MemoryInfo.getOtherLabel(i18), Integer.valueOf(otherPss), Integer.valueOf(otherSwappablePss), Integer.valueOf(otherSharedDirty), Integer.valueOf(otherPrivateDirty), Integer.valueOf(otherSharedClean), Integer.valueOf(otherPrivateClean), Integer.valueOf(otherSwappedOut), "", "", "");
                } else {
                    printRow(printWriter, HEAP_COLUMN, Debug.MemoryInfo.getOtherLabel(i18), Integer.valueOf(otherPss), Integer.valueOf(otherPrivateDirty), Integer.valueOf(otherPrivateClean), Integer.valueOf(otherSwappedOut), "", "", "");
                }
                i2 = i11 - otherPss;
                i3 = i12 - otherSwappablePss;
                i4 = i13 - otherSharedDirty;
                i5 = i14 - otherPrivateDirty;
                i6 = i15 - otherSharedClean;
                i7 = i16 - otherPrivateClean;
                i8 = i17 - otherSwappedOut;
                i18++;
                i16 = i7;
                i14 = i5;
                i11 = i2;
                i15 = i6;
                i13 = i4;
                i12 = i3;
                i17 = i8;
            }
            if (z2) {
                printRow(printWriter, HEAP_FULL_COLUMN, "Unknown", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i17), "", "", "");
                printRow(printWriter, HEAP_FULL_COLUMN, "TOTAL", Integer.valueOf(memoryInfo.getTotalPss()), Integer.valueOf(memoryInfo.getTotalSwappablePss()), Integer.valueOf(memoryInfo.getTotalSharedDirty()), Integer.valueOf(memoryInfo.getTotalPrivateDirty()), Integer.valueOf(memoryInfo.getTotalSharedClean()), Integer.valueOf(memoryInfo.getTotalPrivateClean()), Integer.valueOf(memoryInfo.getTotalSwappedOut()), Long.valueOf(j + j4), Long.valueOf(j2 + j5), Long.valueOf(j3 + j6));
            } else {
                printRow(printWriter, HEAP_COLUMN, "Unknown", Integer.valueOf(i11), Integer.valueOf(i14), Integer.valueOf(i16), Integer.valueOf(i17), "", "", "");
                printRow(printWriter, HEAP_COLUMN, "TOTAL", Integer.valueOf(memoryInfo.getTotalPss()), Integer.valueOf(memoryInfo.getTotalPrivateDirty()), Integer.valueOf(memoryInfo.getTotalPrivateClean()), Integer.valueOf(memoryInfo.getTotalSwappedOut()), Long.valueOf(j + j4), Long.valueOf(j2 + j5), Long.valueOf(j3 + j6));
            }
            if (!z3) {
                return;
            }
            printWriter.println(" ");
            printWriter.println(" Dalvik Details");
            int i19 = 17;
            while (true) {
                int i20 = i19;
                if (i20 >= 25) {
                    return;
                }
                int otherPss2 = memoryInfo.getOtherPss(i20);
                int otherSwappablePss2 = memoryInfo.getOtherSwappablePss(i20);
                int otherSharedDirty2 = memoryInfo.getOtherSharedDirty(i20);
                int otherPrivateDirty2 = memoryInfo.getOtherPrivateDirty(i20);
                int otherSharedClean2 = memoryInfo.getOtherSharedClean(i20);
                int otherPrivateClean2 = memoryInfo.getOtherPrivateClean(i20);
                int otherSwappedOut2 = memoryInfo.getOtherSwappedOut(i20);
                if (otherPss2 != 0 || otherSharedDirty2 != 0 || otherPrivateDirty2 != 0 || otherSharedClean2 != 0 || otherPrivateClean2 != 0) {
                    if (z2) {
                        printRow(printWriter, HEAP_FULL_COLUMN, Debug.MemoryInfo.getOtherLabel(i20), Integer.valueOf(otherPss2), Integer.valueOf(otherSwappablePss2), Integer.valueOf(otherSharedDirty2), Integer.valueOf(otherPrivateDirty2), Integer.valueOf(otherSharedClean2), Integer.valueOf(otherPrivateClean2), Integer.valueOf(otherSwappedOut2), "", "", "");
                    } else {
                        printRow(printWriter, HEAP_COLUMN, Debug.MemoryInfo.getOtherLabel(i20), Integer.valueOf(otherPss2), Integer.valueOf(otherPrivateDirty2), Integer.valueOf(otherPrivateClean2), Integer.valueOf(otherSwappedOut2), "", "", "");
                    }
                }
                i19 = i20 + 1;
            }
        }
    }

    static void freeTextLayoutCachesIfNeeded(int i) {
        if (i != 0) {
            boolean z = (i & 4) != 0;
            boolean z2 = (2097152 & i) != 0;
            if (z || z2) {
                Canvas.freeTextLayoutCaches();
                if (z2) {
                    Typeface.recreateDefaults();
                }
            }
        }
    }

    public static Intent getIntentBeingBroadcast() {
        return sCurrentBroadcastIntent.get();
    }

    private LoadedApk getPackageInfo(ApplicationInfo applicationInfo, CompatibilityInfo compatibilityInfo, ClassLoader classLoader, boolean z, boolean z2, boolean z3) {
        LoadedApk loadedApk;
        synchronized (this.mResourcesManager) {
            WeakReference<LoadedApk> weakReference = z2 ? this.mPackages.get(applicationInfo.packageName) : this.mResourcePackages.get(applicationInfo.packageName);
            LoadedApk loadedApk2 = weakReference != null ? weakReference.get() : null;
            loadedApk = loadedApk2;
            if (loadedApk2 == null) {
                loadedApk = new LoadedApk(this, applicationInfo, compatibilityInfo, classLoader, z, z2 && (applicationInfo.flags & 4) != 0, z3);
                if (this.mSystemThread && "android".equals(applicationInfo.packageName)) {
                    loadedApk.installSystemApplicationInfo(applicationInfo, getSystemContext().mPackageInfo.getClassLoader());
                }
                if (z2) {
                    this.mPackages.put(applicationInfo.packageName, new WeakReference<>(loadedApk));
                } else {
                    this.mResourcePackages.put(applicationInfo.packageName, new WeakReference<>(loadedApk));
                }
            }
            if (loadedApk.mResources != null && !loadedApk.mResources.getAssets().isUpToDate()) {
                loadedApk.mResources = null;
            }
        }
        return loadedApk;
    }

    public static IPackageManager getPackageManager() {
        if (sPackageManager != null) {
            return sPackageManager;
        }
        sPackageManager = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
        return sPackageManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x04ee -> B:39:0x01df). Please submit an issue!!! */
    public void handleBindApplication(AppBindData appBindData) {
        List<ProviderInfo> list;
        this.mBoundApplication = appBindData;
        this.mConfiguration = new Configuration(appBindData.config);
        this.mCompatConfiguration = new Configuration(appBindData.config);
        this.mProfiler = new Profiler();
        if (appBindData.initProfilerInfo != null) {
            this.mProfiler.profileFile = appBindData.initProfilerInfo.profileFile;
            this.mProfiler.profileFd = appBindData.initProfilerInfo.profileFd;
            this.mProfiler.samplingInterval = appBindData.initProfilerInfo.samplingInterval;
            this.mProfiler.autoStopProfiler = appBindData.initProfilerInfo.autoStopProfiler;
        }
        Process.setArgV0(appBindData.processName);
        DdmHandleAppName.setAppName(appBindData.processName, UserHandle.myUserId());
        if (appBindData.persistent && !ActivityManager.isHighEndGfx()) {
            HardwareRenderer.disable(false);
        }
        if (this.mProfiler.profileFd != null) {
            this.mProfiler.startProfiling();
        }
        if (appBindData.appInfo.targetSdkVersion <= 12) {
            AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        Message.updateCheckRecycle(appBindData.appInfo.targetSdkVersion);
        TimeZone.setDefault(null);
        Locale.setDefault(appBindData.config.locale);
        this.mResourcesManager.applyConfigurationToResourcesLocked(appBindData.config, appBindData.compatInfo);
        this.mCurDefaultDisplayDpi = appBindData.config.densityDpi;
        applyCompatConfiguration(this.mCurDefaultDisplayDpi);
        appBindData.info = getPackageInfoNoCheck(appBindData.appInfo, appBindData.compatInfo);
        if ((appBindData.appInfo.flags & 8192) == 0) {
            this.mDensityCompatMode = true;
            Bitmap.setDefaultDensity(160);
        }
        updateDefaultDensity();
        ContextImpl createAppContext = ContextImpl.createAppContext(this, appBindData.info);
        if (!Process.isIsolated()) {
            File cacheDir = createAppContext.getCacheDir();
            if (cacheDir != null) {
                System.setProperty("java.io.tmpdir", cacheDir.getAbsolutePath());
                setupGraphicsSupport(appBindData.info, cacheDir);
            } else {
                Log.e(TAG, "Unable to setupGraphicsSupport due to missing cache directory");
            }
        }
        DateFormat.set24HourTimePref(android.text.format.DateFormat.is24HourFormat(this.mCoreSettings.getString(Settings.System.TIME_12_24), appBindData.config.locale));
        View.mDebugViewAttributes = this.mCoreSettings.getInt(Settings.Global.DEBUG_VIEW_ATTRIBUTES, 0) != 0;
        if ((appBindData.appInfo.flags & 129) != 0) {
            StrictMode.conditionallyEnableDebugLogging();
        }
        if (appBindData.appInfo.targetSdkVersion > 9) {
            StrictMode.enableDeathOnNetwork();
        }
        if (appBindData.debugMode != 0) {
            Debug.changeDebugPort(JosStatusCodes.RTN_CODE_PARAMS_ERROR);
            if (appBindData.debugMode == 2) {
                Slog.w(TAG, "Application " + appBindData.info.getPackageName() + " is waiting for the debugger on port 8100...");
                IActivityManager iActivityManager = ActivityManagerNative.getDefault();
                try {
                    iActivityManager.showWaitingForDebugger(this.mAppThread, true);
                } catch (RemoteException e) {
                }
                Debug.waitForDebugger();
                try {
                    iActivityManager.showWaitingForDebugger(this.mAppThread, false);
                } catch (RemoteException e2) {
                }
            } else {
                Slog.w(TAG, "Application " + appBindData.info.getPackageName() + " can be debugged on port 8100...");
            }
        }
        if (appBindData.enableOpenGlTrace) {
            GLUtils.setTracingLevel(1);
        }
        Trace.setAppTracingAllowed((appBindData.appInfo.flags & 2) != 0);
        IBinder service = ServiceManager.getService(Context.CONNECTIVITY_SERVICE);
        if (service != null) {
            try {
                Proxy.setHttpProxySystemProperty(IConnectivityManager.Stub.asInterface(service).getDefaultProxy());
            } catch (RemoteException e3) {
            }
        }
        if (appBindData.instrumentationName != null) {
            InstrumentationInfo instrumentationInfo = null;
            try {
                instrumentationInfo = createAppContext.getPackageManager().getInstrumentationInfo(appBindData.instrumentationName, 0);
            } catch (PackageManager.NameNotFoundException e4) {
            }
            if (instrumentationInfo == null) {
                throw new RuntimeException("Unable to find instrumentation info for: " + appBindData.instrumentationName);
            }
            this.mInstrumentationPackageName = instrumentationInfo.packageName;
            this.mInstrumentationAppDir = instrumentationInfo.sourceDir;
            this.mInstrumentationSplitAppDirs = instrumentationInfo.splitSourceDirs;
            this.mInstrumentationLibDir = instrumentationInfo.nativeLibraryDir;
            this.mInstrumentedAppDir = appBindData.info.getAppDir();
            this.mInstrumentedSplitAppDirs = appBindData.info.getSplitAppDirs();
            this.mInstrumentedLibDir = appBindData.info.getLibDir();
            ApplicationInfo applicationInfo = new ApplicationInfo();
            applicationInfo.packageName = instrumentationInfo.packageName;
            applicationInfo.sourceDir = instrumentationInfo.sourceDir;
            applicationInfo.publicSourceDir = instrumentationInfo.publicSourceDir;
            applicationInfo.splitSourceDirs = instrumentationInfo.splitSourceDirs;
            applicationInfo.splitPublicSourceDirs = instrumentationInfo.splitPublicSourceDirs;
            applicationInfo.dataDir = instrumentationInfo.dataDir;
            applicationInfo.nativeLibraryDir = instrumentationInfo.nativeLibraryDir;
            ContextImpl createAppContext2 = ContextImpl.createAppContext(this, getPackageInfo(applicationInfo, appBindData.compatInfo, createAppContext.getClassLoader(), false, true, false));
            try {
                this.mInstrumentation = (Instrumentation) createAppContext2.getClassLoader().loadClass(appBindData.instrumentationName.getClassName()).newInstance();
                this.mInstrumentation.init(this, createAppContext2, createAppContext, new ComponentName(instrumentationInfo.packageName, instrumentationInfo.name), appBindData.instrumentationWatcher, appBindData.instrumentationUiAutomationConnection);
                if (this.mProfiler.profileFile != null && !instrumentationInfo.handleProfiling && this.mProfiler.profileFd == null) {
                    this.mProfiler.handlingProfiling = true;
                    File file = new File(this.mProfiler.profileFile);
                    file.getParentFile().mkdirs();
                    Debug.startMethodTracing(file.toString(), 8388608);
                }
            } catch (Exception e5) {
                throw new RuntimeException("Unable to instantiate instrumentation " + appBindData.instrumentationName + ": " + e5.toString(), e5);
            }
        } else {
            this.mInstrumentation = new Instrumentation();
        }
        if ((appBindData.appInfo.flags & 1048576) != 0) {
            VMRuntime.getRuntime().clearGrowthLimit();
        }
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            Application makeApplication = appBindData.info.makeApplication(appBindData.restrictedBackupMode, null);
            this.mInitialApplication = makeApplication;
            if (!appBindData.restrictedBackupMode && (list = appBindData.providers) != null) {
                installContentProviders(makeApplication, list);
                this.mH.sendEmptyMessageDelayed(132, 10000L);
            }
            try {
                this.mInstrumentation.onCreate(appBindData.instrumentationArgs);
                try {
                    this.mInstrumentation.callApplicationOnCreate(makeApplication);
                } catch (Exception e6) {
                    if (!this.mInstrumentation.onException(makeApplication, e6)) {
                        throw new RuntimeException("Unable to create application " + makeApplication.getClass().getName() + ": " + e6.toString(), e6);
                    }
                }
            } catch (Exception e7) {
                throw new RuntimeException("Exception thrown in onCreate() of " + appBindData.instrumentationName + ": " + e7.toString(), e7);
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBindService(BindServiceData bindServiceData) {
        Service service = this.mServices.get(bindServiceData.token);
        if (service != null) {
            try {
                bindServiceData.intent.setExtrasClassLoader(service.getClassLoader());
                bindServiceData.intent.prepareToEnterProcess();
                try {
                    if (bindServiceData.rebind) {
                        service.onRebind(bindServiceData.intent);
                        ActivityManagerNative.getDefault().serviceDoneExecuting(bindServiceData.token, 0, 0, 0);
                    } else {
                        ActivityManagerNative.getDefault().publishService(bindServiceData.token, bindServiceData.intent, service.onBind(bindServiceData.intent));
                    }
                    ensureJitEnabled();
                } catch (RemoteException e) {
                }
            } catch (Exception e2) {
                if (!this.mInstrumentation.onException(service, e2)) {
                    throw new RuntimeException("Unable to bind to service " + service + " with " + bindServiceData.intent + ": " + e2.toString(), e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0093, code lost:
        if (r6.backupMode == 3) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleCreateBackupAgent(android.app.ActivityThread.CreateBackupAgentData r6) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.ActivityThread.handleCreateBackupAgent(android.app.ActivityThread$CreateBackupAgentData):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCreateService(CreateServiceData createServiceData) {
        unscheduleGcIdler();
        LoadedApk packageInfoNoCheck = getPackageInfoNoCheck(createServiceData.info.applicationInfo, createServiceData.compatInfo);
        Service service = null;
        try {
            service = (Service) packageInfoNoCheck.getClassLoader().loadClass(createServiceData.info.name).newInstance();
        } catch (Exception e) {
            if (!this.mInstrumentation.onException(null, e)) {
                throw new RuntimeException("Unable to instantiate service " + createServiceData.info.name + ": " + e.toString(), e);
            }
        }
        try {
            ContextImpl createAppContext = ContextImpl.createAppContext(this, packageInfoNoCheck);
            createAppContext.setOuterContext(service);
            service.attach(createAppContext, this, createServiceData.info.name, createServiceData.token, packageInfoNoCheck.makeApplication(false, this.mInstrumentation), ActivityManagerNative.getDefault());
            service.onCreate();
            this.mServices.put(createServiceData.token, service);
            try {
                ActivityManagerNative.getDefault().serviceDoneExecuting(createServiceData.token, 0, 0, 0);
            } catch (RemoteException e2) {
            }
        } catch (Exception e3) {
            if (!this.mInstrumentation.onException(service, e3)) {
                throw new RuntimeException("Unable to create service " + createServiceData.info.name + ": " + e3.toString(), e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDestroyActivity(IBinder iBinder, boolean z, int i, boolean z2) {
        ActivityClientRecord performDestroyActivity = performDestroyActivity(iBinder, z, i, z2);
        if (performDestroyActivity != null) {
            cleanUpPendingRemoveWindows(performDestroyActivity);
            WindowManager windowManager = performDestroyActivity.activity.getWindowManager();
            View view = performDestroyActivity.activity.mDecor;
            if (view != null) {
                if (performDestroyActivity.activity.mVisibleFromServer) {
                    this.mNumVisibleActivities--;
                }
                IBinder windowToken = view.getWindowToken();
                if (performDestroyActivity.activity.mWindowAdded) {
                    if (performDestroyActivity.onlyLocalRequest) {
                        performDestroyActivity.mPendingRemoveWindow = view;
                        performDestroyActivity.mPendingRemoveWindowManager = windowManager;
                    } else {
                        windowManager.removeViewImmediate(view);
                    }
                }
                if (windowToken != null && performDestroyActivity.mPendingRemoveWindow == null) {
                    WindowManagerGlobal.getInstance().closeAll(windowToken, performDestroyActivity.activity.getClass().getName(), "Activity");
                }
                performDestroyActivity.activity.mDecor = null;
            }
            if (performDestroyActivity.mPendingRemoveWindow == null) {
                WindowManagerGlobal.getInstance().closeAll(iBinder, performDestroyActivity.activity.getClass().getName(), "Activity");
            }
            Context baseContext = performDestroyActivity.activity.getBaseContext();
            if (baseContext instanceof ContextImpl) {
                ((ContextImpl) baseContext).scheduleFinalCleanup(performDestroyActivity.activity.getClass().getName(), "Activity");
            }
        }
        if (z) {
            try {
                ActivityManagerNative.getDefault().activityDestroyed(iBinder);
            } catch (RemoteException e) {
            }
        }
        this.mSomeActivitiesChanged = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDestroyBackupAgent(CreateBackupAgentData createBackupAgentData) {
        String str = getPackageInfoNoCheck(createBackupAgentData.appInfo, createBackupAgentData.compatInfo).mPackageName;
        BackupAgent backupAgent = this.mBackupAgents.get(str);
        if (backupAgent == null) {
            Slog.w(TAG, "Attempt to destroy unknown backup agent " + createBackupAgentData);
            return;
        }
        try {
            backupAgent.onDestroy();
        } catch (Exception e) {
            Slog.w(TAG, "Exception thrown in onDestroy by backup agent of " + createBackupAgentData.appInfo);
            e.printStackTrace();
        }
        this.mBackupAgents.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDumpActivity(DumpComponentInfo dumpComponentInfo) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            ActivityClientRecord activityClientRecord = this.mActivities.get(dumpComponentInfo.token);
            if (activityClientRecord != null && activityClientRecord.activity != null) {
                PrintWriter fastPrintWriter = new FastPrintWriter(new FileOutputStream(dumpComponentInfo.fd.getFileDescriptor()));
                activityClientRecord.activity.dump(dumpComponentInfo.prefix, dumpComponentInfo.fd.getFileDescriptor(), fastPrintWriter, dumpComponentInfo.args);
                fastPrintWriter.flush();
            }
        } finally {
            IoUtils.closeQuietly(dumpComponentInfo.fd);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    static final void handleDumpHeap(boolean z, DumpHeapData dumpHeapData) {
        if (!z) {
            Debug.dumpNativeHeap(dumpHeapData.fd.getFileDescriptor());
            return;
        }
        try {
            try {
                Debug.dumpHprofData(dumpHeapData.path, dumpHeapData.fd.getFileDescriptor());
            } finally {
                try {
                    dumpHeapData.fd.close();
                } catch (IOException e) {
                    Slog.w(TAG, "Failure closing profile fd", e);
                }
            }
        } catch (IOException e2) {
            Slog.w(TAG, "Managed heap dump failed on path " + dumpHeapData.path + " -- can the process access this path?");
            try {
                dumpHeapData.fd.close();
            } catch (IOException e3) {
                Slog.w(TAG, "Failure closing profile fd", e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDumpProvider(DumpComponentInfo dumpComponentInfo) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            ProviderClientRecord providerClientRecord = this.mLocalProviders.get(dumpComponentInfo.token);
            if (providerClientRecord != null && providerClientRecord.mLocalProvider != null) {
                PrintWriter fastPrintWriter = new FastPrintWriter(new FileOutputStream(dumpComponentInfo.fd.getFileDescriptor()));
                providerClientRecord.mLocalProvider.dump(dumpComponentInfo.fd.getFileDescriptor(), fastPrintWriter, dumpComponentInfo.args);
                fastPrintWriter.flush();
            }
        } finally {
            IoUtils.closeQuietly(dumpComponentInfo.fd);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDumpService(DumpComponentInfo dumpComponentInfo) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            Service service = this.mServices.get(dumpComponentInfo.token);
            if (service != null) {
                FastPrintWriter fastPrintWriter = new FastPrintWriter(new FileOutputStream(dumpComponentInfo.fd.getFileDescriptor()));
                service.dump(dumpComponentInfo.fd.getFileDescriptor(), fastPrintWriter, dumpComponentInfo.args);
                fastPrintWriter.flush();
            }
        } finally {
            IoUtils.closeQuietly(dumpComponentInfo.fd);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEnterAnimationComplete(IBinder iBinder) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord != null) {
            activityClientRecord.activity.dispatchEnterAnimationComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLaunchActivity(ActivityClientRecord activityClientRecord, Intent intent) {
        unscheduleGcIdler();
        this.mSomeActivitiesChanged = true;
        if (activityClientRecord.profilerInfo != null) {
            this.mProfiler.setProfiler(activityClientRecord.profilerInfo);
            this.mProfiler.startProfiling();
        }
        handleConfigurationChanged(null, null);
        WindowManagerGlobal.initialize();
        if (performLaunchActivity(activityClientRecord, intent) == null) {
            try {
                ActivityManagerNative.getDefault().finishActivity(activityClientRecord.token, 0, null, false);
                return;
            } catch (RemoteException e) {
                return;
            }
        }
        activityClientRecord.createdConfig = new Configuration(this.mConfiguration);
        Bundle bundle = activityClientRecord.state;
        handleResumeActivity(activityClientRecord.token, false, activityClientRecord.isForward, (activityClientRecord.activity.mFinished || activityClientRecord.startsNotResumed) ? false : true);
        if (activityClientRecord.activity.mFinished || !activityClientRecord.startsNotResumed) {
            return;
        }
        try {
            activityClientRecord.activity.mCalled = false;
            this.mInstrumentation.callActivityOnPause(activityClientRecord.activity);
            if (activityClientRecord.isPreHoneycomb()) {
                activityClientRecord.state = bundle;
            }
            if (!activityClientRecord.activity.mCalled) {
                throw new SuperNotCalledException("Activity " + activityClientRecord.intent.getComponent().toShortString() + " did not call through to super.onPause()");
            }
        } catch (SuperNotCalledException e2) {
            throw e2;
        } catch (Exception e3) {
            if (!this.mInstrumentation.onException(activityClientRecord.activity, e3)) {
                throw new RuntimeException("Unable to pause activity " + activityClientRecord.intent.getComponent().toShortString() + ": " + e3.toString(), e3);
            }
        }
        activityClientRecord.paused = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNewIntent(NewIntentData newIntentData) {
        performNewIntents(newIntentData.token, newIntentData.intents);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePauseActivity(IBinder iBinder, boolean z, boolean z2, int i, boolean z3) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord != null) {
            if (z2) {
                performUserLeavingActivity(activityClientRecord);
            }
            activityClientRecord.activity.mConfigChangeFlags |= i;
            performPauseActivity(iBinder, z, activityClientRecord.isPreHoneycomb());
            if (activityClientRecord.isPreHoneycomb()) {
                QueuedWork.waitToFinish();
            }
            if (!z3) {
                try {
                    ActivityManagerNative.getDefault().activityPaused(iBinder);
                } catch (RemoteException e) {
                }
            }
            this.mSomeActivitiesChanged = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReceiver(ReceiverData receiverData) {
        unscheduleGcIdler();
        String className = receiverData.intent.getComponent().getClassName();
        LoadedApk packageInfoNoCheck = getPackageInfoNoCheck(receiverData.info.applicationInfo, receiverData.compatInfo);
        IActivityManager iActivityManager = ActivityManagerNative.getDefault();
        try {
            try {
                ClassLoader classLoader = packageInfoNoCheck.getClassLoader();
                receiverData.intent.setExtrasClassLoader(classLoader);
                receiverData.intent.prepareToEnterProcess();
                receiverData.setExtrasClassLoader(classLoader);
                BroadcastReceiver broadcastReceiver = (BroadcastReceiver) classLoader.loadClass(className).newInstance();
                try {
                    ContextImpl contextImpl = (ContextImpl) packageInfoNoCheck.makeApplication(false, this.mInstrumentation).getBaseContext();
                    sCurrentBroadcastIntent.set(receiverData.intent);
                    broadcastReceiver.setPendingResult(receiverData);
                    broadcastReceiver.onReceive(contextImpl.getReceiverRestrictedContext(), receiverData.intent);
                    sCurrentBroadcastIntent.set(null);
                } catch (Exception e) {
                    receiverData.sendFinished(iActivityManager);
                    if (!this.mInstrumentation.onException(broadcastReceiver, e)) {
                        throw new RuntimeException("Unable to start receiver " + className + ": " + e.toString(), e);
                    }
                    sCurrentBroadcastIntent.set(null);
                }
                if (broadcastReceiver.getPendingResult() != null) {
                    receiverData.finish();
                }
            } catch (Exception e2) {
                receiverData.sendFinished(iActivityManager);
                throw new RuntimeException("Unable to instantiate receiver " + className + ": " + e2.toString(), e2);
            }
        } catch (Throwable th) {
            sCurrentBroadcastIntent.set(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c5, code lost:
        if (r6.mConfiguration.diff(r14.createdConfig) != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d8, code lost:
        if (r14.createdConfig.isOtherSeqNewer(r7) != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleRelaunchActivity(android.app.ActivityThread.ActivityClientRecord r7) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.ActivityThread.handleRelaunchActivity(android.app.ActivityThread$ActivityClientRecord):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSendResult(ResultData resultData) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(resultData.token);
        if (activityClientRecord != null) {
            boolean z = !activityClientRecord.paused;
            if (!activityClientRecord.activity.mFinished && activityClientRecord.activity.mDecor != null && activityClientRecord.hideForNow && z) {
                updateVisibility(activityClientRecord, true);
            }
            if (z) {
                try {
                    activityClientRecord.activity.mCalled = false;
                    activityClientRecord.activity.mTemporaryPause = true;
                    this.mInstrumentation.callActivityOnPause(activityClientRecord.activity);
                    if (!activityClientRecord.activity.mCalled) {
                        throw new SuperNotCalledException("Activity " + activityClientRecord.intent.getComponent().toShortString() + " did not call through to super.onPause()");
                    }
                } catch (SuperNotCalledException e) {
                    throw e;
                } catch (Exception e2) {
                    if (!this.mInstrumentation.onException(activityClientRecord.activity, e2)) {
                        throw new RuntimeException("Unable to pause activity " + activityClientRecord.intent.getComponent().toShortString() + ": " + e2.toString(), e2);
                    }
                }
            }
            deliverResults(activityClientRecord, resultData.results);
            if (z) {
                activityClientRecord.activity.performResume();
                activityClientRecord.activity.mTemporaryPause = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServiceArgs(ServiceArgsData serviceArgsData) {
        int i;
        Service service = this.mServices.get(serviceArgsData.token);
        if (service != null) {
            try {
                if (serviceArgsData.args != null) {
                    serviceArgsData.args.setExtrasClassLoader(service.getClassLoader());
                    serviceArgsData.args.prepareToEnterProcess();
                }
                if (serviceArgsData.taskRemoved) {
                    service.onTaskRemoved(serviceArgsData.args);
                    i = 1000;
                } else {
                    i = service.onStartCommand(serviceArgsData.args, serviceArgsData.flags, serviceArgsData.startId);
                }
                QueuedWork.waitToFinish();
                try {
                    ActivityManagerNative.getDefault().serviceDoneExecuting(serviceArgsData.token, 1, serviceArgsData.startId, i);
                } catch (RemoteException e) {
                }
                ensureJitEnabled();
            } catch (Exception e2) {
                if (!this.mInstrumentation.onException(service, e2)) {
                    throw new RuntimeException("Unable to start service " + service + " with " + serviceArgsData.args + ": " + e2.toString(), e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSetCoreSettings(Bundle bundle) {
        synchronized (this.mResourcesManager) {
            this.mCoreSettings = bundle;
        }
        onCoreSettingsChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSleeping(IBinder iBinder, boolean z) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord == null) {
            Log.w(TAG, "handleSleeping: no activity for token " + iBinder);
        } else if (!z) {
            if (activityClientRecord.stopped && activityClientRecord.activity.mVisibleFromServer) {
                activityClientRecord.activity.performRestart();
                activityClientRecord.stopped = false;
            }
        } else {
            if (!activityClientRecord.stopped && !activityClientRecord.isPreHoneycomb()) {
                try {
                    activityClientRecord.activity.performStop();
                } catch (Exception e) {
                    if (!this.mInstrumentation.onException(activityClientRecord.activity, e)) {
                        throw new RuntimeException("Unable to stop activity " + activityClientRecord.intent.getComponent().toShortString() + ": " + e.toString(), e);
                    }
                }
                activityClientRecord.stopped = true;
            }
            if (!activityClientRecord.isPreHoneycomb()) {
                QueuedWork.waitToFinish();
            }
            try {
                ActivityManagerNative.getDefault().activitySlept(activityClientRecord.token);
            } catch (RemoteException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopActivity(IBinder iBinder, boolean z, int i) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        activityClientRecord.activity.mConfigChangeFlags |= i;
        StopInfo stopInfo = new StopInfo();
        performStopActivityInner(activityClientRecord, stopInfo, z, true);
        updateVisibility(activityClientRecord, z);
        if (!activityClientRecord.isPreHoneycomb()) {
            QueuedWork.waitToFinish();
        }
        stopInfo.activity = activityClientRecord;
        stopInfo.state = activityClientRecord.state;
        stopInfo.persistentState = activityClientRecord.persistentState;
        this.mH.post(stopInfo);
        this.mSomeActivitiesChanged = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopService(IBinder iBinder) {
        Service remove = this.mServices.remove(iBinder);
        if (remove == null) {
            Slog.i(TAG, "handleStopService: token=" + iBinder + " not found.");
            return;
        }
        try {
            remove.onDestroy();
            Context baseContext = remove.getBaseContext();
            if (baseContext instanceof ContextImpl) {
                ((ContextImpl) baseContext).scheduleFinalCleanup(remove.getClassName(), "Service");
            }
            QueuedWork.waitToFinish();
            try {
                ActivityManagerNative.getDefault().serviceDoneExecuting(iBinder, 2, 0, 0);
            } catch (RemoteException e) {
                Slog.i(TAG, "handleStopService: unable to execute serviceDoneExecuting for " + iBinder, e);
            }
        } catch (Exception e2) {
            if (!this.mInstrumentation.onException(remove, e2)) {
                throw new RuntimeException("Unable to stop service " + remove + ": " + e2.toString(), e2);
            }
            Slog.i(TAG, "handleStopService: exception for " + iBinder, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUnbindService(BindServiceData bindServiceData) {
        Service service = this.mServices.get(bindServiceData.token);
        if (service != null) {
            try {
                bindServiceData.intent.setExtrasClassLoader(service.getClassLoader());
                bindServiceData.intent.prepareToEnterProcess();
                boolean onUnbind = service.onUnbind(bindServiceData.intent);
                try {
                    if (onUnbind) {
                        ActivityManagerNative.getDefault().unbindFinished(bindServiceData.token, bindServiceData.intent, onUnbind);
                    } else {
                        ActivityManagerNative.getDefault().serviceDoneExecuting(bindServiceData.token, 0, 0, 0);
                    }
                } catch (RemoteException e) {
                }
            } catch (Exception e2) {
                if (!this.mInstrumentation.onException(service, e2)) {
                    throw new RuntimeException("Unable to unbind to service " + service + " with " + bindServiceData.intent + ": " + e2.toString(), e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpdatePackageCompatibilityInfo(UpdateCompatibilityData updateCompatibilityData) {
        LoadedApk peekPackageInfo = peekPackageInfo(updateCompatibilityData.pkg, false);
        if (peekPackageInfo != null) {
            peekPackageInfo.setCompatibilityInfo(updateCompatibilityData.info);
        }
        LoadedApk peekPackageInfo2 = peekPackageInfo(updateCompatibilityData.pkg, true);
        if (peekPackageInfo2 != null) {
            peekPackageInfo2.setCompatibilityInfo(updateCompatibilityData.info);
        }
        handleConfigurationChanged(this.mConfiguration, updateCompatibilityData.info);
        WindowManagerGlobal.getInstance().reportNewConfiguration(this.mConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWindowVisibility(IBinder iBinder, boolean z) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord == null) {
            Log.w(TAG, "handleWindowVisibility: no activity for token " + iBinder);
            return;
        }
        if (!z && !activityClientRecord.stopped) {
            performStopActivityInner(activityClientRecord, null, z, false);
        } else if (z && activityClientRecord.stopped) {
            unscheduleGcIdler();
            activityClientRecord.activity.performRestart();
            activityClientRecord.stopped = false;
        }
        if (activityClientRecord.activity.mDecor != null) {
            updateVisibility(activityClientRecord, z);
        }
        this.mSomeActivitiesChanged = true;
    }

    private final void incProviderRefLocked(ProviderRefCount providerRefCount, boolean z) {
        int i;
        if (!z) {
            providerRefCount.unstableCount++;
            if (providerRefCount.unstableCount == 1) {
                if (providerRefCount.removePending) {
                    providerRefCount.removePending = false;
                    this.mH.removeMessages(131, providerRefCount);
                    return;
                }
                try {
                    ActivityManagerNative.getDefault().refContentProvider(providerRefCount.holder.connection, 0, 1);
                    return;
                } catch (RemoteException e) {
                    return;
                }
            }
            return;
        }
        providerRefCount.stableCount++;
        if (providerRefCount.stableCount == 1) {
            if (providerRefCount.removePending) {
                i = -1;
                providerRefCount.removePending = false;
                this.mH.removeMessages(131, providerRefCount);
            } else {
                i = 0;
            }
            try {
                ActivityManagerNative.getDefault().refContentProvider(providerRefCount.holder.connection, 1, i);
            } catch (RemoteException e2) {
            }
        }
    }

    private void installContentProviders(Context context, List<ProviderInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (ProviderInfo providerInfo : list) {
            IActivityManager.ContentProviderHolder installProvider = installProvider(context, null, providerInfo, false, true, true);
            if (installProvider != null) {
                installProvider.noReleaseNeeded = true;
                arrayList.add(installProvider);
            }
        }
        try {
            ActivityManagerNative.getDefault().publishContentProviders(getApplicationThread(), arrayList);
        } catch (RemoteException e) {
        }
    }

    private IActivityManager.ContentProviderHolder installProvider(Context context, IActivityManager.ContentProviderHolder contentProviderHolder, ProviderInfo providerInfo, boolean z, boolean z2, boolean z3) {
        IContentProvider iContentProvider;
        ContentProvider contentProvider;
        ProviderRefCount providerRefCount;
        IActivityManager.ContentProviderHolder contentProviderHolder2;
        ProviderClientRecord installProviderAuthoritiesLocked;
        if (contentProviderHolder == null || contentProviderHolder.provider == null) {
            if (z) {
                Slog.d(TAG, "Loading provider " + providerInfo.authority + ": " + providerInfo.name);
            }
            ApplicationInfo applicationInfo = providerInfo.applicationInfo;
            if (!context.getPackageName().equals(applicationInfo.packageName)) {
                if (this.mInitialApplication == null || !this.mInitialApplication.getPackageName().equals(applicationInfo.packageName)) {
                    try {
                        context = context.createPackageContext(applicationInfo.packageName, 1);
                    } catch (PackageManager.NameNotFoundException e) {
                        context = null;
                    }
                } else {
                    context = this.mInitialApplication;
                }
            }
            if (context == null) {
                Slog.w(TAG, "Unable to get context for package " + applicationInfo.packageName + " while loading content provider " + providerInfo.name);
                return null;
            }
            try {
                ContentProvider contentProvider2 = (ContentProvider) context.getClassLoader().loadClass(providerInfo.name).newInstance();
                iContentProvider = contentProvider2.getIContentProvider();
                if (iContentProvider == null) {
                    Slog.e(TAG, "Failed to instantiate class " + providerInfo.name + " from sourceDir " + providerInfo.applicationInfo.sourceDir);
                    return null;
                }
                contentProvider2.attachInfo(context, providerInfo);
                contentProvider = contentProvider2;
            } catch (Exception e2) {
                if (this.mInstrumentation.onException(null, e2)) {
                    return null;
                }
                throw new RuntimeException("Unable to get provider " + providerInfo.name + ": " + e2.toString(), e2);
            }
        } else {
            contentProvider = null;
            iContentProvider = contentProviderHolder.provider;
        }
        synchronized (this.mProviderMap) {
            try {
                IBinder asBinder = iContentProvider.asBinder();
                if (contentProvider != null) {
                    ComponentName componentName = new ComponentName(providerInfo.packageName, providerInfo.name);
                    ProviderClientRecord providerClientRecord = this.mLocalProvidersByName.get(componentName);
                    if (providerClientRecord != null) {
                        IContentProvider iContentProvider2 = providerClientRecord.mProvider;
                        installProviderAuthoritiesLocked = providerClientRecord;
                    } else {
                        IActivityManager.ContentProviderHolder contentProviderHolder3 = new IActivityManager.ContentProviderHolder(providerInfo);
                        try {
                            contentProviderHolder3.provider = iContentProvider;
                            contentProviderHolder3.noReleaseNeeded = true;
                            installProviderAuthoritiesLocked = installProviderAuthoritiesLocked(iContentProvider, contentProvider, contentProviderHolder3);
                            this.mLocalProviders.put(asBinder, installProviderAuthoritiesLocked);
                            this.mLocalProvidersByName.put(componentName, installProviderAuthoritiesLocked);
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                    contentProviderHolder2 = installProviderAuthoritiesLocked.mHolder;
                } else {
                    ProviderRefCount providerRefCount2 = this.mProviderRefCountMap.get(asBinder);
                    if (providerRefCount2 != null) {
                        providerRefCount = providerRefCount2;
                        if (!z2) {
                            incProviderRefLocked(providerRefCount2, z3);
                            try {
                                ActivityManagerNative.getDefault().removeContentProvider(contentProviderHolder.connection, z3);
                                providerRefCount = providerRefCount2;
                            } catch (RemoteException e3) {
                                providerRefCount = providerRefCount2;
                            }
                        }
                    } else {
                        ProviderClientRecord installProviderAuthoritiesLocked2 = installProviderAuthoritiesLocked(iContentProvider, contentProvider, contentProviderHolder);
                        providerRefCount = z2 ? new ProviderRefCount(contentProviderHolder, installProviderAuthoritiesLocked2, 1000, 1000) : z3 ? new ProviderRefCount(contentProviderHolder, installProviderAuthoritiesLocked2, 1, 0) : new ProviderRefCount(contentProviderHolder, installProviderAuthoritiesLocked2, 0, 1);
                        this.mProviderRefCountMap.put(asBinder, providerRefCount);
                    }
                    contentProviderHolder2 = providerRefCount.holder;
                }
                return contentProviderHolder2;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private ProviderClientRecord installProviderAuthoritiesLocked(IContentProvider iContentProvider, ContentProvider contentProvider, IActivityManager.ContentProviderHolder contentProviderHolder) {
        String[] split = PATTERN_SEMICOLON.split(contentProviderHolder.info.authority);
        int userId = UserHandle.getUserId(contentProviderHolder.info.applicationInfo.uid);
        ProviderClientRecord providerClientRecord = new ProviderClientRecord(split, iContentProvider, contentProvider, contentProviderHolder);
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return providerClientRecord;
            }
            String str = split[i2];
            ProviderKey providerKey = new ProviderKey(str, userId);
            if (this.mProviderMap.get(providerKey) != null) {
                Slog.w(TAG, "Content provider " + providerClientRecord.mHolder.info.name + " already published as " + str);
            } else {
                this.mProviderMap.put(providerKey, providerClientRecord);
            }
            i = i2 + 1;
        }
    }

    public static void main(String[] strArr) {
        SamplingProfilerIntegration.start();
        CloseGuard.setEnabled(false);
        Environment.initForCurrentUser();
        EventLogger.setReporter(new EventLoggingReporter());
        Security.addProvider(new AndroidKeyStoreProvider());
        TrustedCertificateStore.setDefaultUserDirectory(Environment.getUserConfigDirectory(UserHandle.myUserId()));
        Process.setArgV0("<pre-initialized>");
        Looper.prepareMainLooper();
        ActivityThread activityThread = new ActivityThread();
        activityThread.attach(false);
        if (sMainThreadHandler == null) {
            sMainThreadHandler = activityThread.getHandler();
        }
        Looper.loop();
        throw new RuntimeException("Main thread loop unexpectedly exited");
    }

    private void onCoreSettingsChange() {
        boolean z = this.mCoreSettings.getInt(Settings.Global.DEBUG_VIEW_ATTRIBUTES, 0) != 0;
        if (z != View.mDebugViewAttributes) {
            View.mDebugViewAttributes = z;
            for (Map.Entry<IBinder, ActivityClientRecord> entry : this.mActivities.entrySet()) {
                requestRelaunchActivity(entry.getKey(), null, null, 0, false, null, false);
            }
        }
    }

    private static void performConfigurationChanged(ComponentCallbacks2 componentCallbacks2, Configuration configuration) {
        boolean z;
        Activity activity = componentCallbacks2 instanceof Activity ? (Activity) componentCallbacks2 : null;
        if (activity != null) {
            activity.mCalled = false;
        }
        if (activity == null || activity.mCurrentConfig == null) {
            z = true;
        } else {
            int diff = activity.mCurrentConfig.diff(configuration);
            z = false;
            if (diff != 0) {
                z = false;
                if (((activity.mActivityInfo.getRealConfigChanged() ^ (-1)) & diff) == 0) {
                    z = true;
                }
            }
        }
        if (z) {
            componentCallbacks2.onConfigurationChanged(configuration);
            if (activity != null) {
                if (!activity.mCalled) {
                    throw new SuperNotCalledException("Activity " + activity.getLocalClassName() + " did not call through to super.onConfigurationChanged()");
                }
                activity.mConfigChangeFlags = 0;
                activity.mCurrentConfig = new Configuration(configuration);
            }
        }
    }

    private ActivityClientRecord performDestroyActivity(IBinder iBinder, boolean z, int i, boolean z2) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        Class<?> cls = null;
        if (activityClientRecord != null) {
            Class<?> cls2 = activityClientRecord.activity.getClass();
            activityClientRecord.activity.mConfigChangeFlags |= i;
            if (z) {
                activityClientRecord.activity.mFinished = true;
            }
            if (!activityClientRecord.paused) {
                try {
                    activityClientRecord.activity.mCalled = false;
                    this.mInstrumentation.callActivityOnPause(activityClientRecord.activity);
                    EventLog.writeEvent((int) LOG_ON_PAUSE_CALLED, Integer.valueOf(UserHandle.myUserId()), activityClientRecord.activity.getComponentName().getClassName());
                    if (!activityClientRecord.activity.mCalled) {
                        throw new SuperNotCalledException("Activity " + safeToComponentShortString(activityClientRecord.intent) + " did not call through to super.onPause()");
                    }
                } catch (SuperNotCalledException e) {
                    throw e;
                } catch (Exception e2) {
                    if (!this.mInstrumentation.onException(activityClientRecord.activity, e2)) {
                        throw new RuntimeException("Unable to pause activity " + safeToComponentShortString(activityClientRecord.intent) + ": " + e2.toString(), e2);
                    }
                }
                activityClientRecord.paused = true;
            }
            if (!activityClientRecord.stopped) {
                try {
                    activityClientRecord.activity.performStop();
                } catch (SuperNotCalledException e3) {
                    throw e3;
                } catch (Exception e4) {
                    if (!this.mInstrumentation.onException(activityClientRecord.activity, e4)) {
                        throw new RuntimeException("Unable to stop activity " + safeToComponentShortString(activityClientRecord.intent) + ": " + e4.toString(), e4);
                    }
                }
                activityClientRecord.stopped = true;
            }
            if (z2) {
                try {
                    activityClientRecord.lastNonConfigurationInstances = activityClientRecord.activity.retainNonConfigurationInstances();
                } catch (Exception e5) {
                    if (!this.mInstrumentation.onException(activityClientRecord.activity, e5)) {
                        throw new RuntimeException("Unable to retain activity " + activityClientRecord.intent.getComponent().toShortString() + ": " + e5.toString(), e5);
                    }
                }
            }
            try {
                activityClientRecord.activity.mCalled = false;
                this.mInstrumentation.callActivityOnDestroy(activityClientRecord.activity);
                if (!activityClientRecord.activity.mCalled) {
                    throw new SuperNotCalledException("Activity " + safeToComponentShortString(activityClientRecord.intent) + " did not call through to super.onDestroy()");
                }
                cls = cls2;
                if (activityClientRecord.window != null) {
                    activityClientRecord.window.closeAllPanels();
                    cls = cls2;
                }
            } catch (SuperNotCalledException e6) {
                throw e6;
            } catch (Exception e7) {
                cls = cls2;
                if (!this.mInstrumentation.onException(activityClientRecord.activity, e7)) {
                    throw new RuntimeException("Unable to destroy activity " + safeToComponentShortString(activityClientRecord.intent) + ": " + e7.toString(), e7);
                }
            }
        }
        this.mActivities.remove(iBinder);
        StrictMode.decrementExpectedActivityCount(cls);
        return activityClientRecord;
    }

    private Activity performLaunchActivity(ActivityClientRecord activityClientRecord, Intent intent) {
        Activity activity;
        ActivityInfo activityInfo = activityClientRecord.activityInfo;
        if (activityClientRecord.packageInfo == null) {
            activityClientRecord.packageInfo = getPackageInfo(activityInfo.applicationInfo, activityClientRecord.compatInfo, 1);
        }
        ComponentName component = activityClientRecord.intent.getComponent();
        ComponentName componentName = component;
        if (component == null) {
            componentName = activityClientRecord.intent.resolveActivity(this.mInitialApplication.getPackageManager());
            activityClientRecord.intent.setComponent(componentName);
        }
        ComponentName componentName2 = componentName;
        if (activityClientRecord.activityInfo.targetActivity != null) {
            componentName2 = new ComponentName(activityClientRecord.activityInfo.packageName, activityClientRecord.activityInfo.targetActivity);
        }
        Activity activity2 = null;
        try {
            ClassLoader classLoader = activityClientRecord.packageInfo.getClassLoader();
            Activity newActivity = this.mInstrumentation.newActivity(classLoader, componentName2.getClassName(), activityClientRecord.intent);
            StrictMode.incrementExpectedActivityCount(newActivity.getClass());
            activityClientRecord.intent.setExtrasClassLoader(classLoader);
            activityClientRecord.intent.prepareToEnterProcess();
            activity = newActivity;
            if (activityClientRecord.state != null) {
                activity2 = newActivity;
                activityClientRecord.state.setClassLoader(classLoader);
                activity = newActivity;
            }
        } catch (Exception e) {
            activity = activity2;
            if (!this.mInstrumentation.onException(activity2, e)) {
                throw new RuntimeException("Unable to instantiate activity " + componentName2 + ": " + e.toString(), e);
            }
        }
        try {
            Application makeApplication = activityClientRecord.packageInfo.makeApplication(false, this.mInstrumentation);
            if (activity != null) {
                Context createBaseContextForActivity = createBaseContextForActivity(activityClientRecord, activity);
                activity.attach(createBaseContextForActivity, this, getInstrumentation(), activityClientRecord.token, activityClientRecord.ident, makeApplication, activityClientRecord.intent, activityClientRecord.activityInfo, activityClientRecord.activityInfo.loadLabel(createBaseContextForActivity.getPackageManager()), activityClientRecord.parent, activityClientRecord.embeddedID, activityClientRecord.lastNonConfigurationInstances, new Configuration(this.mCompatConfiguration), activityClientRecord.referrer, activityClientRecord.voiceInteractor);
                if (intent != null) {
                    activity.mIntent = intent;
                }
                activityClientRecord.lastNonConfigurationInstances = null;
                activity.mStartedActivity = false;
                int themeResource = activityClientRecord.activityInfo.getThemeResource();
                if (themeResource != 0) {
                    activity.setTheme(themeResource);
                }
                activity.mCalled = false;
                if (activityClientRecord.isPersistable()) {
                    this.mInstrumentation.callActivityOnCreate(activity, activityClientRecord.state, activityClientRecord.persistentState);
                } else {
                    this.mInstrumentation.callActivityOnCreate(activity, activityClientRecord.state);
                }
                if (!activity.mCalled) {
                    throw new SuperNotCalledException("Activity " + activityClientRecord.intent.getComponent().toShortString() + " did not call through to super.onCreate()");
                }
                activityClientRecord.activity = activity;
                activityClientRecord.stopped = true;
                if (!activityClientRecord.activity.mFinished) {
                    activity.performStart();
                    activityClientRecord.stopped = false;
                }
                if (!activityClientRecord.activity.mFinished) {
                    if (activityClientRecord.isPersistable()) {
                        if (activityClientRecord.state != null || activityClientRecord.persistentState != null) {
                            this.mInstrumentation.callActivityOnRestoreInstanceState(activity, activityClientRecord.state, activityClientRecord.persistentState);
                        }
                    } else if (activityClientRecord.state != null) {
                        this.mInstrumentation.callActivityOnRestoreInstanceState(activity, activityClientRecord.state);
                    }
                }
                if (!activityClientRecord.activity.mFinished) {
                    activity.mCalled = false;
                    if (activityClientRecord.isPersistable()) {
                        this.mInstrumentation.callActivityOnPostCreate(activity, activityClientRecord.state, activityClientRecord.persistentState);
                    } else {
                        this.mInstrumentation.callActivityOnPostCreate(activity, activityClientRecord.state);
                    }
                    if (!activity.mCalled) {
                        throw new SuperNotCalledException("Activity " + activityClientRecord.intent.getComponent().toShortString() + " did not call through to super.onPostCreate()");
                    }
                }
            }
            activityClientRecord.paused = true;
            this.mActivities.put(activityClientRecord.token, activityClientRecord);
        } catch (SuperNotCalledException e2) {
            throw e2;
        } catch (Exception e3) {
            if (!this.mInstrumentation.onException(activity, e3)) {
                throw new RuntimeException("Unable to start activity " + componentName2 + ": " + e3.toString(), e3);
            }
        }
        return activity;
    }

    private void performStopActivityInner(ActivityClientRecord activityClientRecord, StopInfo stopInfo, boolean z, boolean z2) {
        if (activityClientRecord != null) {
            if (!z && activityClientRecord.stopped) {
                if (activityClientRecord.activity.mFinished) {
                    return;
                }
                RuntimeException runtimeException = new RuntimeException("Performing stop of activity that is not resumed: " + activityClientRecord.intent.getComponent().toShortString());
                Slog.e(TAG, runtimeException.getMessage(), runtimeException);
            }
            if (stopInfo != null) {
                try {
                    stopInfo.description = activityClientRecord.activity.onCreateDescription();
                } catch (Exception e) {
                    if (!this.mInstrumentation.onException(activityClientRecord.activity, e)) {
                        throw new RuntimeException("Unable to save state of activity " + activityClientRecord.intent.getComponent().toShortString() + ": " + e.toString(), e);
                    }
                }
            }
            if (!activityClientRecord.activity.mFinished && z2 && activityClientRecord.state == null) {
                callCallActivityOnSaveInstanceState(activityClientRecord);
            }
            if (!z) {
                try {
                    activityClientRecord.activity.performStop();
                } catch (Exception e2) {
                    if (!this.mInstrumentation.onException(activityClientRecord.activity, e2)) {
                        throw new RuntimeException("Unable to stop activity " + activityClientRecord.intent.getComponent().toShortString() + ": " + e2.toString(), e2);
                    }
                }
                activityClientRecord.stopped = true;
            }
            activityClientRecord.paused = true;
        }
    }

    static void printRow(PrintWriter printWriter, String str, Object... objArr) {
        printWriter.println(String.format(str, objArr));
    }

    private static String safeToComponentShortString(Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? "[Unknown]" : component.toShortString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(int i, Object obj) {
        sendMessage(i, obj, 0, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(int i, Object obj, int i2) {
        sendMessage(i, obj, i2, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(int i, Object obj, int i2, int i3) {
        sendMessage(i, obj, i2, i3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage(int i, Object obj, int i2, int i3, boolean z) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        if (z) {
            obtain.setAsynchronous(true);
        }
        this.mH.sendMessage(obtain);
    }

    private void setupGraphicsSupport(LoadedApk loadedApk, File file) {
        if (Process.isIsolated()) {
            return;
        }
        try {
            String[] packagesForUid = getPackageManager().getPackagesForUid(Process.myUid());
            if (packagesForUid == null || packagesForUid.length != 1) {
                return;
            }
            HardwareRenderer.setupDiskCache(file);
            RenderScript.setupDiskCache(file);
        } catch (RemoteException e) {
        }
    }

    public static ActivityThread systemMain() {
        if (ActivityManager.isHighEndGfx()) {
            HardwareRenderer.enableForegroundTrimming();
        } else {
            HardwareRenderer.disable(true);
        }
        ActivityThread activityThread = new ActivityThread();
        activityThread.attach(true);
        return activityThread;
    }

    private void updateDefaultDensity() {
        if (this.mCurDefaultDisplayDpi == 0 || this.mCurDefaultDisplayDpi == DisplayMetrics.DENSITY_DEVICE || this.mDensityCompatMode) {
            return;
        }
        Slog.i(TAG, "Switching default density from " + DisplayMetrics.DENSITY_DEVICE + " to " + this.mCurDefaultDisplayDpi);
        DisplayMetrics.DENSITY_DEVICE = this.mCurDefaultDisplayDpi;
        Bitmap.setDefaultDensity(DisplayMetrics.DENSITY_DEVICE);
    }

    private void updateVisibility(ActivityClientRecord activityClientRecord, boolean z) {
        View view = activityClientRecord.activity.mDecor;
        if (view != null) {
            if (!z) {
                if (activityClientRecord.activity.mVisibleFromServer) {
                    activityClientRecord.activity.mVisibleFromServer = false;
                    this.mNumVisibleActivities--;
                    view.setVisibility(4);
                    return;
                }
                return;
            }
            if (!activityClientRecord.activity.mVisibleFromServer) {
                activityClientRecord.activity.mVisibleFromServer = true;
                this.mNumVisibleActivities++;
                if (activityClientRecord.activity.mVisibleFromClient) {
                    activityClientRecord.activity.makeVisible();
                }
            }
            if (activityClientRecord.newConfig != null) {
                performConfigurationChanged(activityClientRecord.activity, activityClientRecord.newConfig);
                freeTextLayoutCachesIfNeeded(activityClientRecord.activity.mCurrentConfig.diff(activityClientRecord.newConfig));
                activityClientRecord.newConfig = null;
            }
        }
    }

    public final IContentProvider acquireExistingProvider(Context context, String str, int i, boolean z) {
        synchronized (this.mProviderMap) {
            ProviderClientRecord providerClientRecord = this.mProviderMap.get(new ProviderKey(str, i));
            if (providerClientRecord == null) {
                return null;
            }
            IContentProvider iContentProvider = providerClientRecord.mProvider;
            IBinder asBinder = iContentProvider.asBinder();
            if (!asBinder.isBinderAlive()) {
                Log.i(TAG, "Acquiring provider " + str + " for user " + i + ": existing object's process dead");
                handleUnstableProviderDiedLocked(asBinder, true);
                return null;
            }
            ProviderRefCount providerRefCount = this.mProviderRefCountMap.get(asBinder);
            if (providerRefCount != null) {
                incProviderRefLocked(providerRefCount, z);
            }
            return iContentProvider;
        }
    }

    public final IContentProvider acquireProvider(Context context, String str, int i, boolean z) {
        IContentProvider acquireExistingProvider = acquireExistingProvider(context, str, i, z);
        if (acquireExistingProvider != null) {
            return acquireExistingProvider;
        }
        IActivityManager.ContentProviderHolder contentProviderHolder = null;
        try {
            contentProviderHolder = ActivityManagerNative.getDefault().getContentProvider(getApplicationThread(), str, i, z);
        } catch (RemoteException e) {
        }
        if (contentProviderHolder == null) {
            Slog.e(TAG, "Failed to find provider info for " + str);
            return null;
        }
        return installProvider(context, contentProviderHolder, contentProviderHolder.info, true, contentProviderHolder.noReleaseNeeded, z).provider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void appNotRespondingViaProvider(IBinder iBinder) {
        synchronized (this.mProviderMap) {
            ProviderRefCount providerRefCount = this.mProviderRefCountMap.get(iBinder);
            if (providerRefCount != null) {
                try {
                    ActivityManagerNative.getDefault().appNotRespondingViaProvider(providerRefCount.holder.connection);
                } catch (RemoteException e) {
                }
            }
        }
    }

    final Configuration applyCompatConfiguration(int i) {
        Configuration configuration = this.mConfiguration;
        if (this.mCompatConfiguration == null) {
            this.mCompatConfiguration = new Configuration();
        }
        this.mCompatConfiguration.setTo(this.mConfiguration);
        if (this.mResourcesManager.applyCompatConfiguration(i, this.mCompatConfiguration)) {
            configuration = this.mCompatConfiguration;
        }
        return configuration;
    }

    Configuration applyConfigCompatMainThread(int i, Configuration configuration, CompatibilityInfo compatibilityInfo) {
        if (configuration == null) {
            return null;
        }
        Configuration configuration2 = configuration;
        if (!compatibilityInfo.supportsScreen()) {
            this.mMainThreadConfig.setTo(configuration);
            configuration2 = this.mMainThreadConfig;
            compatibilityInfo.applyToConfiguration(i, configuration2);
        }
        return configuration2;
    }

    public final void applyConfigurationToResources(Configuration configuration) {
        synchronized (this.mResourcesManager) {
            this.mResourcesManager.applyConfigurationToResourcesLocked(configuration, null);
        }
    }

    ArrayList<ComponentCallbacks2> collectComponentCallbacks(boolean z, Configuration configuration) {
        ArrayList<ComponentCallbacks2> arrayList = new ArrayList<>();
        synchronized (this.mResourcesManager) {
            int size = this.mAllApplications.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                arrayList.add(this.mAllApplications.get(i2));
                i = i2 + 1;
            }
            int size2 = this.mActivities.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    break;
                }
                ActivityClientRecord valueAt = this.mActivities.valueAt(i4);
                Activity activity = valueAt.activity;
                if (activity != null) {
                    Configuration applyConfigCompatMainThread = applyConfigCompatMainThread(this.mCurDefaultDisplayDpi, configuration, valueAt.packageInfo.getCompatibilityInfo());
                    if (!valueAt.activity.mFinished && (z || !valueAt.paused)) {
                        arrayList.add(activity);
                    } else if (applyConfigCompatMainThread != null) {
                        valueAt.newConfig = applyConfigCompatMainThread;
                    }
                }
                i3 = i4 + 1;
            }
            int size3 = this.mServices.size();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= size3) {
                    break;
                }
                arrayList.add(this.mServices.valueAt(i6));
                i5 = i6 + 1;
            }
        }
        synchronized (this.mProviderMap) {
            int size4 = this.mLocalProviders.size();
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 < size4) {
                    arrayList.add(this.mLocalProviders.valueAt(i8).mLocalProvider);
                    i7 = i8 + 1;
                }
            }
        }
        return arrayList;
    }

    final void completeRemoveProvider(ProviderRefCount providerRefCount) {
        synchronized (this.mProviderMap) {
            if (!providerRefCount.removePending) {
                return;
            }
            providerRefCount.removePending = false;
            IBinder asBinder = providerRefCount.holder.provider.asBinder();
            if (this.mProviderRefCountMap.get(asBinder) == providerRefCount) {
                this.mProviderRefCountMap.remove(asBinder);
            }
            int size = this.mProviderMap.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    try {
                        ActivityManagerNative.getDefault().removeContentProvider(providerRefCount.holder.connection, false);
                        return;
                    } catch (RemoteException e) {
                        return;
                    }
                }
                if (this.mProviderMap.valueAt(i).mProvider.asBinder() == asBinder) {
                    this.mProviderMap.removeAt(i);
                }
                size = i;
            }
        }
    }

    void doGcIfNeeded() {
        this.mGcIdlerScheduled = false;
        if (BinderInternal.getLastGcTime() + 5000 < SystemClock.uptimeMillis()) {
            BinderInternal.forceGc(OapsKey.KEY_BG);
        }
    }

    void ensureJitEnabled() {
        if (this.mJitEnabled) {
            return;
        }
        this.mJitEnabled = true;
        VMRuntime.getRuntime().startJitCompilation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void finishInstrumentation(int i, Bundle bundle) {
        IActivityManager iActivityManager = ActivityManagerNative.getDefault();
        if (this.mProfiler.profileFile != null && this.mProfiler.handlingProfiling && this.mProfiler.profileFd == null) {
            Debug.stopMethodTracing();
        }
        try {
            iActivityManager.finishInstrumentation(this.mAppThread, i, bundle);
        } catch (RemoteException e) {
        }
    }

    public final Activity getActivity(IBinder iBinder) {
        return this.mActivities.get(iBinder).activity;
    }

    public Application getApplication() {
        return this.mInitialApplication;
    }

    public ApplicationThread getApplicationThread() {
        return this.mAppThread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Handler getHandler() {
        return this.mH;
    }

    public Instrumentation getInstrumentation() {
        return this.mInstrumentation;
    }

    public int getIntCoreSetting(String str, int i) {
        synchronized (this.mResourcesManager) {
            if (this.mCoreSettings != null) {
                return this.mCoreSettings.getInt(str, i);
            }
            return i;
        }
    }

    public Looper getLooper() {
        return this.mLooper;
    }

    public final LoadedApk getPackageInfo(ApplicationInfo applicationInfo, CompatibilityInfo compatibilityInfo, int i) {
        boolean z = (i & 1) != 0;
        boolean z2 = z && applicationInfo.uid != 0 && applicationInfo.uid != 1000 && (this.mBoundApplication == null || !UserHandle.isSameApp(applicationInfo.uid, this.mBoundApplication.appInfo.uid));
        boolean z3 = false;
        if (z) {
            z3 = false;
            if ((1073741824 & i) != 0) {
                z3 = true;
            }
        }
        if ((i & 3) == 1 && z2) {
            String str = "Requesting code from " + applicationInfo.packageName + " (with uid " + applicationInfo.uid + ")";
            String str2 = str;
            if (this.mBoundApplication != null) {
                str2 = str + " to be run in process " + this.mBoundApplication.processName + " (with uid " + this.mBoundApplication.appInfo.uid + ")";
            }
            throw new SecurityException(str2);
        }
        return getPackageInfo(applicationInfo, compatibilityInfo, null, z2, z, z3);
    }

    public final LoadedApk getPackageInfo(String str, CompatibilityInfo compatibilityInfo, int i) {
        return getPackageInfo(str, compatibilityInfo, i, UserHandle.myUserId());
    }

    public final LoadedApk getPackageInfo(String str, CompatibilityInfo compatibilityInfo, int i, int i2) {
        ApplicationInfo applicationInfo;
        synchronized (this.mResourcesManager) {
            WeakReference<LoadedApk> weakReference = (i & 1) != 0 ? this.mPackages.get(str) : this.mResourcePackages.get(str);
            LoadedApk loadedApk = weakReference != null ? weakReference.get() : null;
            if (loadedApk != null && (loadedApk.mResources == null || loadedApk.mResources.getAssets().isUpToDate())) {
                if (loadedApk.isSecurityViolation() && (i & 2) == 0) {
                    throw new SecurityException("Requesting code from " + str + " to be run in process " + this.mBoundApplication.processName + "/" + this.mBoundApplication.appInfo.uid);
                }
                return loadedApk;
            }
            try {
                applicationInfo = getPackageManager().getApplicationInfo(str, 1024, i2);
            } catch (RemoteException e) {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                return getPackageInfo(applicationInfo, compatibilityInfo, i);
            }
            return null;
        }
    }

    public final LoadedApk getPackageInfoNoCheck(ApplicationInfo applicationInfo, CompatibilityInfo compatibilityInfo) {
        return getPackageInfo(applicationInfo, compatibilityInfo, null, false, true, false);
    }

    public String getProcessName() {
        return this.mBoundApplication.processName;
    }

    public String getProfileFilePath() {
        return this.mProfiler.profileFile;
    }

    public ContextImpl getSystemContext() {
        ContextImpl contextImpl;
        synchronized (this) {
            if (this.mSystemContext == null) {
                this.mSystemContext = ContextImpl.createSystemContext(this);
            }
            contextImpl = this.mSystemContext;
        }
        return contextImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resources getTopLevelResources(String str, String[] strArr, String[] strArr2, String[] strArr3, int i, Configuration configuration, LoadedApk loadedApk, Context context, String str2) {
        return this.mResourcesManager.getTopLevelResources(str, strArr, strArr2, strArr3, i, str2, configuration, loadedApk.getCompatibilityInfo(), null, context, loadedApk.getApplicationInfo().isThemeable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Resources getTopLevelThemedResources(String str, int i, Configuration configuration, LoadedApk loadedApk, String str2, String str3) {
        return this.mResourcesManager.getTopLevelThemedResources(str, i, str2, str3, configuration, loadedApk.getCompatibilityInfo(), null, loadedApk.getApplicationInfo().isThemeable);
    }

    final void handleActivityConfigurationChanged(IBinder iBinder) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord == null || activityClientRecord.activity == null) {
            return;
        }
        performConfigurationChanged(activityClientRecord.activity, this.mCompatConfiguration);
        freeTextLayoutCachesIfNeeded(activityClientRecord.activity.mCurrentConfig.diff(this.mCompatConfiguration));
        this.mSomeActivitiesChanged = true;
    }

    public void handleCancelVisibleBehind(IBinder iBinder) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord != null) {
            this.mSomeActivitiesChanged = true;
            Activity activity = activityClientRecord.activity;
            if (activity.mVisibleBehind) {
                activity.mCalled = false;
                activity.onVisibleBehindCanceled();
                if (!activity.mCalled) {
                    throw new SuperNotCalledException("Activity " + activity.getLocalClassName() + " did not call through to super.onVisibleBehindCanceled()");
                }
                activity.mVisibleBehind = false;
            }
        }
        try {
            ActivityManagerNative.getDefault().backgroundResourcesReleased(iBinder);
        } catch (RemoteException e) {
        }
    }

    final void handleConfigurationChanged(Configuration configuration, CompatibilityInfo compatibilityInfo) {
        synchronized (this.mResourcesManager) {
            Configuration configuration2 = configuration;
            if (this.mPendingConfiguration != null) {
                configuration2 = configuration;
                if (!this.mPendingConfiguration.isOtherSeqNewer(configuration)) {
                    configuration2 = this.mPendingConfiguration;
                    this.mCurDefaultDisplayDpi = configuration2.densityDpi;
                    updateDefaultDensity();
                }
                this.mPendingConfiguration = null;
            }
            if (configuration2 == null) {
                return;
            }
            this.mResourcesManager.applyConfigurationToResourcesLocked(configuration2, compatibilityInfo);
            if (this.mConfiguration == null) {
                this.mConfiguration = new Configuration();
            }
            if (!this.mConfiguration.isOtherSeqNewer(configuration2) && compatibilityInfo == null) {
                return;
            }
            int diff = this.mConfiguration.diff(configuration2);
            this.mConfiguration.updateFrom(configuration2);
            Configuration applyCompatConfiguration = applyCompatConfiguration(this.mCurDefaultDisplayDpi);
            ArrayList<ComponentCallbacks2> collectComponentCallbacks = collectComponentCallbacks(false, applyCompatConfiguration);
            freeTextLayoutCachesIfNeeded(diff);
            if (collectComponentCallbacks == null) {
                return;
            }
            int size = collectComponentCallbacks.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                performConfigurationChanged(collectComponentCallbacks.get(i2), applyCompatConfiguration);
                i = i2 + 1;
            }
        }
    }

    final void handleDispatchPackageBroadcast(int i, String[] strArr) {
        boolean z = false;
        if (strArr != null) {
            synchronized (this.mResourcesManager) {
                int length = strArr.length - 1;
                boolean z2 = false;
                while (true) {
                    z = z2;
                    if (length < 0) {
                        break;
                    }
                    boolean z3 = z;
                    if (!z) {
                        WeakReference<LoadedApk> weakReference = this.mPackages.get(strArr[length]);
                        if (weakReference == null || weakReference.get() == null) {
                            WeakReference<LoadedApk> weakReference2 = this.mResourcePackages.get(strArr[length]);
                            z3 = z;
                            if (weakReference2 != null) {
                                z3 = z;
                                if (weakReference2.get() != null) {
                                    z3 = true;
                                }
                            }
                        } else {
                            z3 = true;
                        }
                    }
                    this.mPackages.remove(strArr[length]);
                    this.mResourcePackages.remove(strArr[length]);
                    length--;
                    z2 = z3;
                }
            }
        }
        ApplicationPackageManager.handlePackageBroadcast(i, strArr, z);
    }

    public void handleInstallProvider(ProviderInfo providerInfo) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            installContentProviders(this.mInitialApplication, Lists.newArrayList(new ProviderInfo[]{providerInfo}));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    final void handleLowMemory() {
        ArrayList<ComponentCallbacks2> collectComponentCallbacks = collectComponentCallbacks(true, null);
        int size = collectComponentCallbacks.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            collectComponentCallbacks.get(i2).onLowMemory();
            i = i2 + 1;
        }
        if (Process.myUid() != 1000) {
            EventLog.writeEvent((int) SQLITE_MEM_RELEASED_EVENT_LOG_TAG, SQLiteDatabase.releaseMemory());
        }
        Canvas.freeCaches();
        Canvas.freeTextLayoutCaches();
        BinderInternal.forceGc("mem");
    }

    public void handleOnBackgroundVisibleBehindChanged(IBinder iBinder, boolean z) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord != null) {
            activityClientRecord.activity.onBackgroundVisibleBehindChanged(z);
        }
    }

    final void handleProfilerControl(boolean z, ProfilerInfo profilerInfo, int i) {
        try {
            if (!z) {
                this.mProfiler.stopProfiling();
                return;
            }
            try {
                this.mProfiler.setProfiler(profilerInfo);
                this.mProfiler.startProfiling();
            } catch (RuntimeException e) {
                Slog.w(TAG, "Profiling failed on path " + profilerInfo.profileFile + " -- can the process access this path?");
                try {
                    profilerInfo.profileFd.close();
                } catch (IOException e2) {
                    Slog.w(TAG, "Failure closing profile fd", e2);
                }
            }
        } finally {
            try {
                profilerInfo.profileFd.close();
            } catch (IOException e3) {
                Slog.w(TAG, "Failure closing profile fd", e3);
            }
        }
    }

    public void handleRequestAssistContextExtras(RequestAssistContextExtras requestAssistContextExtras) {
        Bundle bundle = new Bundle();
        ActivityClientRecord activityClientRecord = this.mActivities.get(requestAssistContextExtras.activityToken);
        if (activityClientRecord != null) {
            activityClientRecord.activity.getApplication().dispatchOnProvideAssistData(activityClientRecord.activity, bundle);
            activityClientRecord.activity.onProvideAssistData(bundle);
        }
        Bundle bundle2 = bundle;
        if (bundle.isEmpty()) {
            bundle2 = null;
        }
        try {
            ActivityManagerNative.getDefault().reportAssistContextExtras(requestAssistContextExtras.requestToken, bundle2);
        } catch (RemoteException e) {
        }
    }

    final void handleResumeActivity(IBinder iBinder, boolean z, boolean z2, boolean z3) {
        unscheduleGcIdler();
        this.mSomeActivitiesChanged = true;
        ActivityClientRecord performResumeActivity = performResumeActivity(iBinder, z);
        if (performResumeActivity == null) {
            try {
                ActivityManagerNative.getDefault().finishActivity(iBinder, 0, null, false);
                return;
            } catch (RemoteException e) {
                return;
            }
        }
        Activity activity = performResumeActivity.activity;
        int i = z2 ? 256 : 0;
        boolean z4 = !activity.mStartedActivity;
        boolean z5 = z4;
        if (!z4) {
            try {
                z5 = ActivityManagerNative.getDefault().willActivityBeVisible(activity.getActivityToken());
            } catch (RemoteException e2) {
                z5 = z4;
            }
        }
        if (performResumeActivity.window == null && !activity.mFinished && z5) {
            performResumeActivity.window = performResumeActivity.activity.getWindow();
            View decorView = performResumeActivity.window.getDecorView();
            decorView.setVisibility(4);
            WindowManager windowManager = activity.getWindowManager();
            WindowManager.LayoutParams attributes = performResumeActivity.window.getAttributes();
            activity.mDecor = decorView;
            attributes.type = 1;
            attributes.softInputMode |= i;
            if (activity.mVisibleFromClient) {
                activity.mWindowAdded = true;
                windowManager.addView(decorView, attributes);
            }
        } else if (!z5) {
            performResumeActivity.hideForNow = true;
        }
        cleanUpPendingRemoveWindows(performResumeActivity);
        if (!performResumeActivity.activity.mFinished && z5 && performResumeActivity.activity.mDecor != null && !performResumeActivity.hideForNow) {
            if (performResumeActivity.newConfig != null) {
                performConfigurationChanged(performResumeActivity.activity, performResumeActivity.newConfig);
                freeTextLayoutCachesIfNeeded(performResumeActivity.activity.mCurrentConfig.diff(performResumeActivity.newConfig));
                performResumeActivity.newConfig = null;
            }
            WindowManager.LayoutParams attributes2 = performResumeActivity.window.getAttributes();
            if ((attributes2.softInputMode & 256) != i) {
                attributes2.softInputMode = (attributes2.softInputMode & (-257)) | i;
                if (performResumeActivity.activity.mVisibleFromClient) {
                    activity.getWindowManager().updateViewLayout(performResumeActivity.window.getDecorView(), attributes2);
                }
            }
            performResumeActivity.activity.mVisibleFromServer = true;
            this.mNumVisibleActivities++;
            if (performResumeActivity.activity.mVisibleFromClient) {
                performResumeActivity.activity.makeVisible();
            }
        }
        if (!performResumeActivity.onlyLocalRequest) {
            performResumeActivity.nextIdle = this.mNewActivities;
            this.mNewActivities = performResumeActivity;
            Looper.myQueue().addIdleHandler(new Idler());
        }
        performResumeActivity.onlyLocalRequest = false;
        if (z3) {
            try {
                ActivityManagerNative.getDefault().activityResumed(iBinder);
            } catch (RemoteException e3) {
            }
        }
    }

    public void handleTranslucentConversionComplete(IBinder iBinder, boolean z) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord != null) {
            activityClientRecord.activity.onTranslucentConversionComplete(z);
        }
    }

    final void handleTrimMemory(int i) {
        ArrayList<ComponentCallbacks2> collectComponentCallbacks = collectComponentCallbacks(true, null);
        int size = collectComponentCallbacks.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                WindowManagerGlobal.getInstance().trimMemory(i);
                return;
            } else {
                collectComponentCallbacks.get(i3).onTrimMemory(i);
                i2 = i3 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void handleUnstableProviderDied(IBinder iBinder, boolean z) {
        synchronized (this.mProviderMap) {
            handleUnstableProviderDiedLocked(iBinder, z);
        }
    }

    final void handleUnstableProviderDiedLocked(IBinder iBinder, boolean z) {
        ProviderRefCount providerRefCount = this.mProviderRefCountMap.get(iBinder);
        if (providerRefCount != null) {
            this.mProviderRefCountMap.remove(iBinder);
            int size = this.mProviderMap.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                ProviderClientRecord valueAt = this.mProviderMap.valueAt(i);
                if (valueAt != null && valueAt.mProvider.asBinder() == iBinder) {
                    Slog.i(TAG, "Removing dead content provider:" + valueAt.mProvider.toString());
                    this.mProviderMap.removeAt(i);
                }
                size = i;
            }
            if (z) {
                try {
                    ActivityManagerNative.getDefault().unstableProviderDied(providerRefCount.holder.connection);
                } catch (RemoteException e) {
                }
            }
        }
    }

    public void installSystemApplicationInfo(ApplicationInfo applicationInfo, ClassLoader classLoader) {
        synchronized (this) {
            getSystemContext().installSystemApplicationInfo(applicationInfo, classLoader);
            this.mProfiler = new Profiler();
        }
    }

    public final void installSystemProviders(List<ProviderInfo> list) {
        if (list != null) {
            installContentProviders(this.mInitialApplication, list);
        }
    }

    public boolean isProfiling() {
        return (this.mProfiler == null || this.mProfiler.profileFile == null || this.mProfiler.profileFd != null) ? false : true;
    }

    public void onNewActivityOptions(IBinder iBinder, ActivityOptions activityOptions) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord != null) {
            activityClientRecord.activity.onNewActivityOptions(activityOptions);
        }
    }

    public final LoadedApk peekPackageInfo(String str, boolean z) {
        LoadedApk loadedApk;
        synchronized (this.mResourcesManager) {
            WeakReference<LoadedApk> weakReference = z ? this.mPackages.get(str) : this.mResourcePackages.get(str);
            loadedApk = weakReference != null ? weakReference.get() : null;
        }
        return loadedApk;
    }

    public final ActivityClientRecord performDestroyActivity(IBinder iBinder, boolean z) {
        return performDestroyActivity(iBinder, z, 0, false);
    }

    public final void performNewIntents(IBinder iBinder, List<ReferrerIntent> list) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord != null) {
            boolean z = !activityClientRecord.paused;
            if (z) {
                activityClientRecord.activity.mTemporaryPause = true;
                this.mInstrumentation.callActivityOnPause(activityClientRecord.activity);
            }
            deliverNewIntents(activityClientRecord, list);
            if (z) {
                activityClientRecord.activity.performResume();
                activityClientRecord.activity.mTemporaryPause = false;
            }
        }
    }

    final Bundle performPauseActivity(ActivityClientRecord activityClientRecord, boolean z, boolean z2) {
        ArrayList<OnActivityPausedListener> remove;
        int i = 0;
        if (activityClientRecord.paused) {
            if (activityClientRecord.activity.mFinished) {
                return null;
            }
            RuntimeException runtimeException = new RuntimeException("Performing pause of activity that is not resumed: " + activityClientRecord.intent.getComponent().toShortString());
            Slog.e(TAG, runtimeException.getMessage(), runtimeException);
        }
        if (z) {
            activityClientRecord.activity.mFinished = true;
        }
        try {
            if (!activityClientRecord.activity.mFinished && z2) {
                callCallActivityOnSaveInstanceState(activityClientRecord);
            }
            activityClientRecord.activity.mCalled = false;
            this.mInstrumentation.callActivityOnPause(activityClientRecord.activity);
            EventLog.writeEvent((int) LOG_ON_PAUSE_CALLED, Integer.valueOf(UserHandle.myUserId()), activityClientRecord.activity.getComponentName().getClassName());
            if (!activityClientRecord.activity.mCalled) {
                throw new SuperNotCalledException("Activity " + activityClientRecord.intent.getComponent().toShortString() + " did not call through to super.onPause()");
            }
        } catch (SuperNotCalledException e) {
            throw e;
        } catch (Exception e2) {
            if (!this.mInstrumentation.onException(activityClientRecord.activity, e2)) {
                throw new RuntimeException("Unable to pause activity " + activityClientRecord.intent.getComponent().toShortString() + ": " + e2.toString(), e2);
            }
        }
        activityClientRecord.paused = true;
        synchronized (this.mOnPauseListeners) {
            remove = this.mOnPauseListeners.remove(activityClientRecord.activity);
        }
        if (remove != null) {
            i = remove.size();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            remove.get(i3).onPaused(activityClientRecord.activity);
            i2 = i3 + 1;
        }
        return (activityClientRecord.activity.mFinished || !z2) ? null : activityClientRecord.state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle performPauseActivity(IBinder iBinder, boolean z, boolean z2) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord != null) {
            return performPauseActivity(activityClientRecord, z, z2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performRestartActivity(IBinder iBinder) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord.stopped) {
            activityClientRecord.activity.performRestart();
            activityClientRecord.stopped = false;
        }
    }

    public final ActivityClientRecord performResumeActivity(IBinder iBinder, boolean z) {
        ActivityClientRecord activityClientRecord = this.mActivities.get(iBinder);
        if (activityClientRecord != null && !activityClientRecord.activity.mFinished) {
            if (z) {
                activityClientRecord.hideForNow = false;
                activityClientRecord.activity.mStartedActivity = false;
            }
            try {
                activityClientRecord.activity.mFragments.noteStateNotSaved();
                if (activityClientRecord.pendingIntents != null) {
                    deliverNewIntents(activityClientRecord, activityClientRecord.pendingIntents);
                    activityClientRecord.pendingIntents = null;
                }
                if (activityClientRecord.pendingResults != null) {
                    deliverResults(activityClientRecord, activityClientRecord.pendingResults);
                    activityClientRecord.pendingResults = null;
                }
                activityClientRecord.activity.performResume();
                EventLog.writeEvent((int) LOG_ON_RESUME_CALLED, Integer.valueOf(UserHandle.myUserId()), activityClientRecord.activity.getComponentName().getClassName());
                activityClientRecord.paused = false;
                activityClientRecord.stopped = false;
                activityClientRecord.state = null;
                activityClientRecord.persistentState = null;
            } catch (Exception e) {
                if (!this.mInstrumentation.onException(activityClientRecord.activity, e)) {
                    throw new RuntimeException("Unable to resume activity " + activityClientRecord.intent.getComponent().toShortString() + ": " + e.toString(), e);
                }
            }
        }
        return activityClientRecord;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performStopActivity(IBinder iBinder, boolean z) {
        performStopActivityInner(this.mActivities.get(iBinder), null, false, z);
    }

    final void performUserLeavingActivity(ActivityClientRecord activityClientRecord) {
        this.mInstrumentation.callActivityOnUserLeaving(activityClientRecord.activity);
    }

    public void registerOnActivityPausedListener(Activity activity, OnActivityPausedListener onActivityPausedListener) {
        synchronized (this.mOnPauseListeners) {
            ArrayList<OnActivityPausedListener> arrayList = this.mOnPauseListeners.get(activity);
            ArrayList<OnActivityPausedListener> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<>();
                this.mOnPauseListeners.put(activity, arrayList2);
            }
            arrayList2.add(onActivityPausedListener);
        }
    }

    public final boolean releaseProvider(IContentProvider iContentProvider, boolean z) {
        int i = 0;
        if (iContentProvider == null) {
            return false;
        }
        IBinder asBinder = iContentProvider.asBinder();
        synchronized (this.mProviderMap) {
            ProviderRefCount providerRefCount = this.mProviderRefCountMap.get(asBinder);
            if (providerRefCount == null) {
                return false;
            }
            boolean z2 = false;
            if (z) {
                if (providerRefCount.stableCount == 0) {
                    return false;
                }
                providerRefCount.stableCount--;
                if (providerRefCount.stableCount == 0) {
                    z2 = providerRefCount.unstableCount == 0;
                    try {
                        IActivityManager iActivityManager = ActivityManagerNative.getDefault();
                        IBinder iBinder = providerRefCount.holder.connection;
                        if (z2) {
                            i = 1;
                        }
                        iActivityManager.refContentProvider(iBinder, -1, i);
                    } catch (RemoteException e) {
                    }
                }
            } else if (providerRefCount.unstableCount == 0) {
                return false;
            } else {
                providerRefCount.unstableCount--;
                if (providerRefCount.unstableCount == 0) {
                    boolean z3 = providerRefCount.stableCount == 0;
                    z2 = z3;
                    if (!z3) {
                        try {
                            ActivityManagerNative.getDefault().refContentProvider(providerRefCount.holder.connection, 0, -1);
                            z2 = z3;
                        } catch (RemoteException e2) {
                            z2 = z3;
                        }
                    }
                }
            }
            if (z2) {
                if (providerRefCount.removePending) {
                    Slog.w(TAG, "Duplicate remove pending of provider " + providerRefCount.holder.info.name);
                } else {
                    providerRefCount.removePending = true;
                    this.mH.sendMessage(this.mH.obtainMessage(131, providerRefCount));
                }
            }
            return true;
        }
    }

    public final void requestRelaunchActivity(IBinder iBinder, List<ResultInfo> list, List<ReferrerIntent> list2, int i, boolean z, Configuration configuration, boolean z2) {
        ActivityClientRecord activityClientRecord;
        ActivityClientRecord activityClientRecord2;
        ActivityClientRecord activityClientRecord3;
        synchronized (this.mResourcesManager) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                activityClientRecord = null;
                try {
                    if (i3 >= this.mRelaunchingActivities.size()) {
                        break;
                    }
                    ActivityClientRecord activityClientRecord4 = this.mRelaunchingActivities.get(i3);
                    if (activityClientRecord4.token == iBinder) {
                        activityClientRecord2 = activityClientRecord4;
                        if (list != null) {
                            if (activityClientRecord4.pendingResults != null) {
                                activityClientRecord4.pendingResults.addAll(list);
                            } else {
                                activityClientRecord4.pendingResults = list;
                            }
                        }
                        activityClientRecord = activityClientRecord2;
                        if (list2 != null) {
                            if (activityClientRecord4.pendingIntents != null) {
                                activityClientRecord4.pendingIntents.addAll(list2);
                            } else {
                                activityClientRecord4.pendingIntents = list2;
                            }
                        }
                    } else {
                        i2 = i3 + 1;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            }
            activityClientRecord2 = activityClientRecord;
            if (activityClientRecord2 == null) {
                try {
                    ActivityClientRecord activityClientRecord5 = new ActivityClientRecord();
                    activityClientRecord5.token = iBinder;
                    activityClientRecord5.pendingResults = list;
                    activityClientRecord5.pendingIntents = list2;
                    if (!z2) {
                        ActivityClientRecord activityClientRecord6 = this.mActivities.get(iBinder);
                        if (activityClientRecord6 != null) {
                            activityClientRecord5.startsNotResumed = activityClientRecord6.paused;
                        }
                        activityClientRecord5.onlyLocalRequest = true;
                    }
                    this.mRelaunchingActivities.add(activityClientRecord5);
                    sendMessage(126, activityClientRecord5);
                    activityClientRecord3 = activityClientRecord5;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } else {
                activityClientRecord3 = activityClientRecord2;
            }
            if (z2) {
                activityClientRecord3.startsNotResumed = z;
                activityClientRecord3.onlyLocalRequest = false;
            }
            if (configuration != null) {
                activityClientRecord3.createdConfig = configuration;
            }
            activityClientRecord3.pendingConfigChanges |= i;
        }
    }

    public final ActivityInfo resolveActivityInfo(Intent intent) {
        ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.mInitialApplication.getPackageManager(), 1024);
        if (resolveActivityInfo == null) {
            Instrumentation.checkStartActivityResult(-2, intent);
        }
        return resolveActivityInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void scheduleContextCleanup(ContextImpl contextImpl, String str, String str2) {
        ContextCleanupInfo contextCleanupInfo = new ContextCleanupInfo();
        contextCleanupInfo.context = contextImpl;
        contextCleanupInfo.who = str;
        contextCleanupInfo.what = str2;
        sendMessage(119, contextCleanupInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scheduleGcIdler() {
        if (!this.mGcIdlerScheduled) {
            this.mGcIdlerScheduled = true;
            Looper.myQueue().addIdleHandler(this.mGcIdler);
        }
        this.mH.removeMessages(120);
    }

    public final void sendActivityResult(IBinder iBinder, String str, int i, int i2, Intent intent) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ResultInfo(str, i, i2, intent));
        this.mAppThread.scheduleSendResult(iBinder, arrayList);
    }

    public final Activity startActivityNow(Activity activity, String str, Intent intent, ActivityInfo activityInfo, IBinder iBinder, Bundle bundle, Activity.NonConfigurationInstances nonConfigurationInstances) {
        ActivityClientRecord activityClientRecord = new ActivityClientRecord();
        activityClientRecord.token = iBinder;
        activityClientRecord.ident = 0;
        activityClientRecord.intent = intent;
        activityClientRecord.state = bundle;
        activityClientRecord.parent = activity;
        activityClientRecord.embeddedID = str;
        activityClientRecord.activityInfo = activityInfo;
        activityClientRecord.lastNonConfigurationInstances = nonConfigurationInstances;
        return performLaunchActivity(activityClientRecord, null);
    }

    public void unregisterOnActivityPausedListener(Activity activity, OnActivityPausedListener onActivityPausedListener) {
        synchronized (this.mOnPauseListeners) {
            ArrayList<OnActivityPausedListener> arrayList = this.mOnPauseListeners.get(activity);
            if (arrayList != null) {
                arrayList.remove(onActivityPausedListener);
            }
        }
    }

    void unscheduleGcIdler() {
        if (this.mGcIdlerScheduled) {
            this.mGcIdlerScheduled = false;
            Looper.myQueue().removeIdleHandler(this.mGcIdler);
        }
        this.mH.removeMessages(120);
    }
}
