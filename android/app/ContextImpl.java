package android.app;

import android.accounts.AccountManager;
import android.accounts.IAccountManager;
import android.app.IAlarmManager;
import android.app.IBatteryService;
import android.app.LoadedApk;
import android.app.admin.DevicePolicyManager;
import android.app.job.IJobScheduler;
import android.app.trust.TrustManager;
import android.app.usage.IUsageStatsManager;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IContentProvider;
import android.content.IIntentReceiver;
import android.content.IRestrictionsManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.RestrictionsManager;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ILauncherApps;
import android.content.pm.IPackageManager;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.IThemeService;
import android.content.res.Resources;
import android.content.res.ThemeManager;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.ISerialManager;
import android.hardware.ITorchService;
import android.hardware.SerialManager;
import android.hardware.SystemSensorManager;
import android.hardware.TorchManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.hdmi.HdmiControlManager;
import android.hardware.hdmi.IHdmiControlService;
import android.hardware.input.InputManager;
import android.hardware.usb.IUsbManager;
import android.hardware.usb.UsbManager;
import android.location.CountryDetector;
import android.location.ICountryDetector;
import android.location.ILocationManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.ITvInputManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.EthernetManager;
import android.net.IConnectivityManager;
import android.net.IEthernetManager;
import android.net.INetworkPolicyManager;
import android.net.NetworkPolicyManager;
import android.net.NetworkScoreManager;
import android.net.Uri;
import android.net.nsd.INsdManager;
import android.net.nsd.NsdManager;
import android.net.wifi.IRttManager;
import android.net.wifi.IWifiManager;
import android.net.wifi.IWifiScanner;
import android.net.wifi.RttManager;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiScanner;
import android.net.wifi.p2p.IWifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import android.os.DropBoxManager;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.IPowerManager;
import android.os.IUserManager;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemVibrator;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.IMountService;
import android.os.storage.StorageManager;
import android.print.IPrintManager;
import android.print.PrintManager;
import android.service.fingerprint.FingerprintManager;
import android.service.fingerprint.IFingerprintService;
import android.service.persistentdata.IPersistentDataBlockService;
import android.service.persistentdata.PersistentDataBlockManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.AndroidRuntimeException;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.DisplayAdjustments;
import android.view.WindowManagerImpl;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import com.android.internal.annotations.GuardedBy;
import com.android.internal.app.IAppOpsService;
import com.android.internal.appwidget.IAppWidgetService;
import com.android.internal.os.IDropBoxManagerService;
import com.android.internal.policy.PolicyManager;
import com.android.internal.util.Preconditions;
import com.igexin.push.core.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/app/ContextImpl.class */
public class ContextImpl extends Context {
    private static final boolean DEBUG = false;
    private static final String TAG = "ContextImpl";
    private static ArrayMap<String, ArrayMap<String, SharedPreferencesImpl>> sSharedPrefs;
    private final IBinder mActivityToken;
    private final String mBasePackageName;
    @GuardedBy("mSync")
    private File mCacheDir;
    @GuardedBy("mSync")
    private File mCodeCacheDir;
    private final ApplicationContentResolver mContentResolver;
    @GuardedBy("mSync")
    private File mDatabasesDir;
    private final Display mDisplay;
    private final DisplayAdjustments mDisplayAdjustments;
    @GuardedBy("mSync")
    private File[] mExternalCacheDirs;
    @GuardedBy("mSync")
    private File[] mExternalFilesDirs;
    @GuardedBy("mSync")
    private File[] mExternalMediaDirs;
    @GuardedBy("mSync")
    private File[] mExternalObbDirs;
    @GuardedBy("mSync")
    private File mFilesDir;
    final ActivityThread mMainThread;
    @GuardedBy("mSync")
    private File mNoBackupFilesDir;
    private final String mOpPackageName;
    private Context mOuterContext;
    private final Configuration mOverrideConfiguration;
    final LoadedApk mPackageInfo;
    private PackageManager mPackageManager;
    @GuardedBy("mSync")
    private File mPreferencesDir;
    private Context mReceiverRestrictedContext;
    private final Resources mResources;
    private final ResourcesManager mResourcesManager;
    private final boolean mRestricted;
    final ArrayList<Object> mServiceCache;
    private final Object mSync;
    private Resources.Theme mTheme;
    private int mThemeResource;
    private final UserHandle mUser;
    private static final String[] EMPTY_FILE_LIST = new String[0];
    private static final HashMap<String, ServiceFetcher> SYSTEM_SERVICE_MAP = new HashMap<>();
    private static int sNextPerContextServiceCacheIndex = 0;
    private static ServiceFetcher WALLPAPER_FETCHER = new ServiceFetcher() { // from class: android.app.ContextImpl.1
        @Override // android.app.ContextImpl.ServiceFetcher
        public Object createService(ContextImpl contextImpl) {
            return new WallpaperManager(contextImpl.getOuterContext(), contextImpl.mMainThread.getHandler());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ContextImpl$ApplicationContentResolver.class */
    public static final class ApplicationContentResolver extends ContentResolver {
        private final ActivityThread mMainThread;
        private final UserHandle mUser;

        public ApplicationContentResolver(Context context, ActivityThread activityThread, UserHandle userHandle) {
            super(context);
            this.mMainThread = (ActivityThread) Preconditions.checkNotNull(activityThread);
            this.mUser = (UserHandle) Preconditions.checkNotNull(userHandle);
        }

        @Override // android.content.ContentResolver
        protected IContentProvider acquireExistingProvider(Context context, String str) {
            return this.mMainThread.acquireExistingProvider(context, ContentProvider.getAuthorityWithoutUserId(str), resolveUserIdFromAuthority(str), true);
        }

        @Override // android.content.ContentResolver
        protected IContentProvider acquireProvider(Context context, String str) {
            return this.mMainThread.acquireProvider(context, ContentProvider.getAuthorityWithoutUserId(str), resolveUserIdFromAuthority(str), true);
        }

        @Override // android.content.ContentResolver
        protected IContentProvider acquireUnstableProvider(Context context, String str) {
            return this.mMainThread.acquireProvider(context, ContentProvider.getAuthorityWithoutUserId(str), resolveUserIdFromAuthority(str), false);
        }

        @Override // android.content.ContentResolver
        public void appNotRespondingViaProvider(IContentProvider iContentProvider) {
            this.mMainThread.appNotRespondingViaProvider(iContentProvider.asBinder());
        }

        @Override // android.content.ContentResolver
        public boolean releaseProvider(IContentProvider iContentProvider) {
            return this.mMainThread.releaseProvider(iContentProvider, true);
        }

        @Override // android.content.ContentResolver
        public boolean releaseUnstableProvider(IContentProvider iContentProvider) {
            return this.mMainThread.releaseProvider(iContentProvider, false);
        }

        protected int resolveUserIdFromAuthority(String str) {
            return ContentProvider.getUserIdFromAuthority(str, this.mUser.getIdentifier());
        }

        @Override // android.content.ContentResolver
        public void unstableProviderDied(IContentProvider iContentProvider) {
            this.mMainThread.handleUnstableProviderDied(iContentProvider.asBinder(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ContextImpl$ServiceFetcher.class */
    public static class ServiceFetcher {
        int mContextCacheIndex = -1;

        ServiceFetcher() {
        }

        public Object createService(ContextImpl contextImpl) {
            throw new RuntimeException("Not implemented");
        }

        public Object getService(ContextImpl contextImpl) {
            ArrayList<Object> arrayList = contextImpl.mServiceCache;
            synchronized (arrayList) {
                if (arrayList.size() == 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= ContextImpl.sNextPerContextServiceCacheIndex) {
                            break;
                        }
                        arrayList.add(null);
                        i = i2 + 1;
                    }
                } else {
                    Object obj = arrayList.get(this.mContextCacheIndex);
                    if (obj != null) {
                        return obj;
                    }
                }
                Object createService = createService(contextImpl);
                arrayList.set(this.mContextCacheIndex, createService);
                return createService;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/ContextImpl$StaticServiceFetcher.class */
    public static abstract class StaticServiceFetcher extends ServiceFetcher {
        private Object mCachedInstance;

        StaticServiceFetcher() {
        }

        public abstract Object createStaticService();

        @Override // android.app.ContextImpl.ServiceFetcher
        public final Object getService(ContextImpl contextImpl) {
            synchronized (this) {
                Object obj = this.mCachedInstance;
                if (obj != null) {
                    return obj;
                }
                Object createStaticService = createStaticService();
                this.mCachedInstance = createStaticService;
                return createStaticService;
            }
        }
    }

    static {
        registerService(Context.ACCESSIBILITY_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.2
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object getService(ContextImpl contextImpl) {
                return AccessibilityManager.getInstance(contextImpl);
            }
        });
        registerService(Context.CAPTIONING_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.3
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object getService(ContextImpl contextImpl) {
                return new CaptioningManager(contextImpl);
            }
        });
        registerService("account", new ServiceFetcher() { // from class: android.app.ContextImpl.4
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new AccountManager(contextImpl, IAccountManager.Stub.asInterface(ServiceManager.getService("account")));
            }
        });
        registerService("activity", new ServiceFetcher() { // from class: android.app.ContextImpl.5
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new ActivityManager(contextImpl.getOuterContext(), contextImpl.mMainThread.getHandler());
            }
        });
        registerService("alarm", new ServiceFetcher() { // from class: android.app.ContextImpl.6
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new AlarmManager(IAlarmManager.Stub.asInterface(ServiceManager.getService("alarm")), contextImpl);
            }
        });
        registerService("audio", new ServiceFetcher() { // from class: android.app.ContextImpl.7
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new AudioManager(contextImpl);
            }
        });
        registerService(Context.MEDIA_ROUTER_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.8
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new MediaRouter(contextImpl);
            }
        });
        registerService("bluetooth", new ServiceFetcher() { // from class: android.app.ContextImpl.9
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new BluetoothManager(contextImpl);
            }
        });
        registerService(Context.HDMI_CONTROL_SERVICE, new StaticServiceFetcher() { // from class: android.app.ContextImpl.10
            @Override // android.app.ContextImpl.StaticServiceFetcher
            public Object createStaticService() {
                return new HdmiControlManager(IHdmiControlService.Stub.asInterface(ServiceManager.getService(Context.HDMI_CONTROL_SERVICE)));
            }
        });
        registerService(Context.CLIPBOARD_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.11
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new ClipboardManager(contextImpl.getOuterContext(), contextImpl.mMainThread.getHandler());
            }
        });
        registerService(Context.CONNECTIVITY_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.12
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new ConnectivityManager(IConnectivityManager.Stub.asInterface(ServiceManager.getService(Context.CONNECTIVITY_SERVICE)));
            }
        });
        registerService(Context.COUNTRY_DETECTOR, new StaticServiceFetcher() { // from class: android.app.ContextImpl.13
            @Override // android.app.ContextImpl.StaticServiceFetcher
            public Object createStaticService() {
                return new CountryDetector(ICountryDetector.Stub.asInterface(ServiceManager.getService(Context.COUNTRY_DETECTOR)));
            }
        });
        registerService(Context.DEVICE_POLICY_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.14
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return DevicePolicyManager.create(contextImpl, contextImpl.mMainThread.getHandler());
            }
        });
        registerService("download", new ServiceFetcher() { // from class: android.app.ContextImpl.15
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new DownloadManager(contextImpl.getContentResolver(), contextImpl.getPackageName());
            }
        });
        registerService(Context.BATTERY_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.16
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new BatteryManager(IBatteryService.Stub.asInterface(ServiceManager.getService(Context.BATTERY_SERVICE)));
            }
        });
        registerService("nfc", new ServiceFetcher() { // from class: android.app.ContextImpl.17
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new NfcManager(contextImpl);
            }
        });
        registerService(Context.DROPBOX_SERVICE, new StaticServiceFetcher() { // from class: android.app.ContextImpl.18
            @Override // android.app.ContextImpl.StaticServiceFetcher
            public Object createStaticService() {
                return ContextImpl.createDropBoxManager();
            }
        });
        registerService("input", new StaticServiceFetcher() { // from class: android.app.ContextImpl.19
            @Override // android.app.ContextImpl.StaticServiceFetcher
            public Object createStaticService() {
                return InputManager.getInstance();
            }
        });
        registerService("display", new ServiceFetcher() { // from class: android.app.ContextImpl.20
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new DisplayManager(contextImpl.getOuterContext());
            }
        });
        registerService(Context.INPUT_METHOD_SERVICE, new StaticServiceFetcher() { // from class: android.app.ContextImpl.21
            @Override // android.app.ContextImpl.StaticServiceFetcher
            public Object createStaticService() {
                return InputMethodManager.getInstance();
            }
        });
        registerService(Context.TEXT_SERVICES_MANAGER_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.22
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return TextServicesManager.getInstance();
            }
        });
        registerService(Context.KEYGUARD_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.23
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object getService(ContextImpl contextImpl) {
                return new KeyguardManager();
            }
        });
        registerService(Context.LAYOUT_INFLATER_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.24
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return PolicyManager.makeNewLayoutInflater(contextImpl.getOuterContext());
            }
        });
        registerService("location", new ServiceFetcher() { // from class: android.app.ContextImpl.25
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new LocationManager(contextImpl, ILocationManager.Stub.asInterface(ServiceManager.getService("location")));
            }
        });
        registerService(Context.NETWORK_POLICY_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.26
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new NetworkPolicyManager(INetworkPolicyManager.Stub.asInterface(ServiceManager.getService(Context.NETWORK_POLICY_SERVICE)));
            }
        });
        registerService("notification", new ServiceFetcher() { // from class: android.app.ContextImpl.27
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                Context outerContext = contextImpl.getOuterContext();
                return new NotificationManager(new ContextThemeWrapper(outerContext, Resources.selectSystemTheme(0, outerContext.getApplicationInfo().targetSdkVersion, 16973835, 16973935, 16974126, 16974130)), contextImpl.mMainThread.getHandler());
            }
        });
        registerService(Context.NSD_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.28
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new NsdManager(contextImpl.getOuterContext(), INsdManager.Stub.asInterface(ServiceManager.getService(Context.NSD_SERVICE)));
            }
        });
        registerService("power", new ServiceFetcher() { // from class: android.app.ContextImpl.29
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                IPowerManager asInterface = IPowerManager.Stub.asInterface(ServiceManager.getService("power"));
                if (asInterface == null) {
                    Log.wtf(ContextImpl.TAG, "Failed to get power manager service.");
                }
                return new PowerManager(contextImpl.getOuterContext(), asInterface, contextImpl.mMainThread.getHandler());
            }
        });
        registerService("search", new ServiceFetcher() { // from class: android.app.ContextImpl.30
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new SearchManager(contextImpl.getOuterContext(), contextImpl.mMainThread.getHandler());
            }
        });
        registerService("sensor", new ServiceFetcher() { // from class: android.app.ContextImpl.31
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new SystemSensorManager(contextImpl.getOuterContext(), contextImpl.mMainThread.getHandler().getLooper());
            }
        });
        registerService(Context.STATUS_BAR_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.32
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new StatusBarManager(contextImpl.getOuterContext());
            }
        });
        registerService(Context.STORAGE_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.33
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                try {
                    return new StorageManager(contextImpl.getContentResolver(), contextImpl.mMainThread.getHandler().getLooper());
                } catch (RemoteException e) {
                    Log.e(ContextImpl.TAG, "Failed to create StorageManager", e);
                    return null;
                }
            }
        });
        registerService("phone", new ServiceFetcher() { // from class: android.app.ContextImpl.34
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new TelephonyManager(contextImpl.getOuterContext());
            }
        });
        registerService(Context.TELEPHONY_SUBSCRIPTION_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.35
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new SubscriptionManager(contextImpl.getOuterContext());
            }
        });
        registerService("telecom", new ServiceFetcher() { // from class: android.app.ContextImpl.36
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new TelecomManager(contextImpl.getOuterContext());
            }
        });
        registerService(Context.UI_MODE_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.37
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new UiModeManager();
            }
        });
        registerService(Context.USB_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.38
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new UsbManager(contextImpl, IUsbManager.Stub.asInterface(ServiceManager.getService(Context.USB_SERVICE)));
            }
        });
        registerService(Context.SERIAL_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.39
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new SerialManager(contextImpl, ISerialManager.Stub.asInterface(ServiceManager.getService(Context.SERIAL_SERVICE)));
            }
        });
        registerService(Context.VIBRATOR_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.40
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new SystemVibrator(contextImpl);
            }
        });
        registerService(Context.WALLPAPER_SERVICE, WALLPAPER_FETCHER);
        registerService("wifi", new ServiceFetcher() { // from class: android.app.ContextImpl.41
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new WifiManager(contextImpl.getOuterContext(), IWifiManager.Stub.asInterface(ServiceManager.getService("wifi")));
            }
        });
        registerService(Context.WIFI_P2P_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.42
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new WifiP2pManager(IWifiP2pManager.Stub.asInterface(ServiceManager.getService(Context.WIFI_P2P_SERVICE)));
            }
        });
        registerService(Context.WIFI_SCANNING_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.43
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new WifiScanner(contextImpl.getOuterContext(), IWifiScanner.Stub.asInterface(ServiceManager.getService(Context.WIFI_SCANNING_SERVICE)));
            }
        });
        registerService(Context.WIFI_RTT_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.44
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new RttManager(contextImpl.getOuterContext(), IRttManager.Stub.asInterface(ServiceManager.getService(Context.WIFI_RTT_SERVICE)));
            }
        });
        registerService(Context.ETHERNET_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.45
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new EthernetManager(contextImpl.getOuterContext(), IEthernetManager.Stub.asInterface(ServiceManager.getService(Context.ETHERNET_SERVICE)));
            }
        });
        registerService(Context.WINDOW_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.46
            Display mDefaultDisplay;

            @Override // android.app.ContextImpl.ServiceFetcher
            public Object getService(ContextImpl contextImpl) {
                Display display = contextImpl.mDisplay;
                Display display2 = display;
                if (display == null) {
                    if (this.mDefaultDisplay == null) {
                        this.mDefaultDisplay = ((DisplayManager) contextImpl.getOuterContext().getSystemService("display")).getDisplay(0);
                    }
                    display2 = this.mDefaultDisplay;
                }
                return new WindowManagerImpl(display2);
            }
        });
        registerService("user", new ServiceFetcher() { // from class: android.app.ContextImpl.47
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new UserManager(contextImpl, IUserManager.Stub.asInterface(ServiceManager.getService("user")));
            }
        });
        registerService(Context.APP_OPS_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.48
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new AppOpsManager(contextImpl, IAppOpsService.Stub.asInterface(ServiceManager.getService(Context.APP_OPS_SERVICE)));
            }
        });
        registerService("camera", new ServiceFetcher() { // from class: android.app.ContextImpl.49
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new CameraManager(contextImpl);
            }
        });
        registerService(Context.LAUNCHER_APPS_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.50
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new LauncherApps(contextImpl, ILauncherApps.Stub.asInterface(ServiceManager.getService(Context.LAUNCHER_APPS_SERVICE)));
            }
        });
        registerService(Context.RESTRICTIONS_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.51
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new RestrictionsManager(contextImpl, IRestrictionsManager.Stub.asInterface(ServiceManager.getService(Context.RESTRICTIONS_SERVICE)));
            }
        });
        registerService("print", new ServiceFetcher() { // from class: android.app.ContextImpl.52
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new PrintManager(contextImpl.getOuterContext(), IPrintManager.Stub.asInterface(ServiceManager.getService("print")), UserHandle.myUserId(), UserHandle.getAppId(Process.myUid()));
            }
        });
        registerService(Context.CONSUMER_IR_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.53
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new ConsumerIrManager(contextImpl);
            }
        });
        registerService(Context.MEDIA_SESSION_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.54
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new MediaSessionManager(contextImpl);
            }
        });
        registerService(Context.TRUST_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.55
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new TrustManager(ServiceManager.getService(Context.TRUST_SERVICE));
            }
        });
        registerService(Context.FINGERPRINT_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.56
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new FingerprintManager(contextImpl.getOuterContext(), IFingerprintService.Stub.asInterface(ServiceManager.getService(Context.FINGERPRINT_SERVICE)));
            }
        });
        registerService(Context.TV_INPUT_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.57
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new TvInputManager(ITvInputManager.Stub.asInterface(ServiceManager.getService(Context.TV_INPUT_SERVICE)), UserHandle.myUserId());
            }
        });
        registerService(Context.NETWORK_SCORE_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.58
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new NetworkScoreManager(contextImpl);
            }
        });
        registerService(Context.USAGE_STATS_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.59
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new UsageStatsManager(contextImpl.getOuterContext(), IUsageStatsManager.Stub.asInterface(ServiceManager.getService(Context.USAGE_STATS_SERVICE)));
            }
        });
        registerService(Context.JOB_SCHEDULER_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.60
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new JobSchedulerImpl(IJobScheduler.Stub.asInterface(ServiceManager.getService(Context.JOB_SCHEDULER_SERVICE)));
            }
        });
        registerService(Context.PERSISTENT_DATA_BLOCK_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.61
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                IPersistentDataBlockService asInterface = IPersistentDataBlockService.Stub.asInterface(ServiceManager.getService(Context.PERSISTENT_DATA_BLOCK_SERVICE));
                if (asInterface != null) {
                    return new PersistentDataBlockManager(asInterface);
                }
                return null;
            }
        });
        registerService(Context.MEDIA_PROJECTION_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.62
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new MediaProjectionManager(contextImpl);
            }
        });
        registerService(Context.APPWIDGET_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.63
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new AppWidgetManager(contextImpl, IAppWidgetService.Stub.asInterface(ServiceManager.getService(Context.APPWIDGET_SERVICE)));
            }
        });
        registerService(Context.THEME_SERVICE, new ServiceFetcher() { // from class: android.app.ContextImpl.64
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new ThemeManager(contextImpl.getOuterContext(), IThemeService.Stub.asInterface(ServiceManager.getService(Context.THEME_SERVICE)));
            }
        });
        registerService("torch", new ServiceFetcher() { // from class: android.app.ContextImpl.65
            @Override // android.app.ContextImpl.ServiceFetcher
            public Object createService(ContextImpl contextImpl) {
                return new TorchManager(contextImpl.getOuterContext(), ITorchService.Stub.asInterface(ServiceManager.getService("torch")));
            }
        });
    }

    private ContextImpl(ContextImpl contextImpl, ActivityThread activityThread, LoadedApk loadedApk, IBinder iBinder, UserHandle userHandle, boolean z, Display display, Configuration configuration) {
        this(contextImpl, activityThread, loadedApk, iBinder, userHandle, z, display, configuration, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0103, code lost:
        if (r20.applicationScale != r0.getCompatibilityInfo().applicationScale) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private ContextImpl(android.app.ContextImpl r14, android.app.ActivityThread r15, android.app.LoadedApk r16, android.os.IBinder r17, android.os.UserHandle r18, boolean r19, android.view.Display r20, android.content.res.Configuration r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.ContextImpl.<init>(android.app.ContextImpl, android.app.ActivityThread, android.app.LoadedApk, android.os.IBinder, android.os.UserHandle, boolean, android.view.Display, android.content.res.Configuration, java.lang.String):void");
    }

    private boolean bindServiceCommon(Intent intent, ServiceConnection serviceConnection, int i, UserHandle userHandle) {
        if (serviceConnection == null) {
            throw new IllegalArgumentException("connection is null");
        }
        if (this.mPackageInfo != null) {
            IServiceConnection serviceDispatcher = this.mPackageInfo.getServiceDispatcher(serviceConnection, getOuterContext(), this.mMainThread.getHandler(), i);
            validateServiceIntent(intent);
            int i2 = i;
            try {
                if (getActivityToken() == null) {
                    i2 = i;
                    if ((i & 1) == 0) {
                        i2 = i;
                        if (this.mPackageInfo != null) {
                            i2 = i;
                            if (this.mPackageInfo.getApplicationInfo().targetSdkVersion < 14) {
                                i2 = i | 32;
                            }
                        }
                    }
                }
                intent.prepareToLeaveProcess();
                int bindService = ActivityManagerNative.getDefault().bindService(this.mMainThread.getApplicationThread(), getActivityToken(), intent, intent.resolveTypeIfNeeded(getContentResolver()), serviceDispatcher, i2, userHandle.getIdentifier());
                if (bindService < 0) {
                    throw new SecurityException("Not allowed to bind to service " + intent);
                }
                return bindService != 0;
            } catch (RemoteException e) {
                return false;
            }
        }
        throw new RuntimeException("Not supported in system context");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContextImpl createActivityContext(ActivityThread activityThread, LoadedApk loadedApk, IBinder iBinder) {
        if (loadedApk == null) {
            throw new IllegalArgumentException("packageInfo");
        }
        if (iBinder == null) {
            throw new IllegalArgumentException("activityInfo");
        }
        return new ContextImpl(null, activityThread, loadedApk, iBinder, null, false, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContextImpl createAppContext(ActivityThread activityThread, LoadedApk loadedApk) {
        if (loadedApk == null) {
            throw new IllegalArgumentException("packageInfo");
        }
        return new ContextImpl(null, activityThread, loadedApk, null, null, false, null, null, null);
    }

    static DropBoxManager createDropBoxManager() {
        IDropBoxManagerService asInterface = IDropBoxManagerService.Stub.asInterface(ServiceManager.getService(Context.DROPBOX_SERVICE));
        if (asInterface == null) {
            return null;
        }
        return new DropBoxManager(asInterface);
    }

    private static File createFilesDirLocked(File file) {
        if (!file.exists()) {
            if (file.mkdirs()) {
                FileUtils.setPermissions(file.getPath(), 505, -1, -1);
                return file;
            } else if (!file.exists()) {
                Log.w(TAG, "Unable to create files subdir " + file.getPath());
                return null;
            }
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContextImpl createSystemContext(ActivityThread activityThread) {
        ContextImpl contextImpl = new ContextImpl(null, activityThread, new LoadedApk(activityThread), null, null, false, null, null, null);
        contextImpl.mResources.updateConfiguration(contextImpl.mResourcesManager.getConfiguration(), contextImpl.mResourcesManager.getDisplayMetricsLocked(0));
        return contextImpl;
    }

    private void enforce(String str, int i, boolean z, int i2, String str2) {
        if (i != 0) {
            throw new SecurityException((str2 != null ? str2 + ": " : "") + (z ? "Neither user " + i2 + " nor current process has " : "uid " + i2 + " does not have ") + str + ".");
        }
    }

    private void enforceForUri(int i, int i2, boolean z, int i3, Uri uri, String str) {
        if (i2 != 0) {
            throw new SecurityException((str != null ? str + ": " : "") + (z ? "Neither user " + i3 + " nor current process has " : "User " + i3 + " does not have ") + uriModeFlagToString(i) + " permission on " + uri + ".");
        }
    }

    private File[] ensureDirsExistOrFilter(File[] fileArr) {
        ArrayList arrayList = new ArrayList(fileArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fileArr.length) {
                return (File[]) arrayList.toArray(new File[arrayList.size()]);
            }
            File file = fileArr[i2];
            if (!Environment.MEDIA_REMOVED.equals(Environment.getStorageState(file))) {
                File file2 = file;
                if (!file.exists()) {
                    file2 = file;
                    if (!file.mkdirs()) {
                        file2 = file;
                        if (!file.exists()) {
                            int i3 = -1;
                            try {
                                i3 = IMountService.Stub.asInterface(ServiceManager.getService("mount")).mkdirs(getPackageName(), file.getAbsolutePath());
                            } catch (Exception e) {
                            }
                            file2 = file;
                            if (i3 != 0) {
                                Log.w(TAG, "Failed to ensure directory: " + file);
                                file2 = null;
                            }
                        }
                    }
                }
                arrayList.add(file2);
            }
            i = i2 + 1;
        }
    }

    private File getDataDirFile() {
        if (this.mPackageInfo != null) {
            return this.mPackageInfo.getDataDirFile();
        }
        throw new RuntimeException("Not supported in system context");
    }

    private File getDatabasesDir() {
        File file;
        synchronized (this.mSync) {
            if (this.mDatabasesDir == null) {
                this.mDatabasesDir = new File(getDataDirFile(), "databases");
            }
            if (this.mDatabasesDir.getPath().equals("databases")) {
                this.mDatabasesDir = new File("/data/system");
            }
            file = this.mDatabasesDir;
        }
        return file;
    }

    private int getDisplayId() {
        if (this.mDisplay != null) {
            return this.mDisplay.getDisplayId();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContextImpl getImpl(Context context) {
        Context baseContext;
        while ((context instanceof ContextWrapper) && (baseContext = ((ContextWrapper) context).getBaseContext()) != null) {
            context = baseContext;
        }
        return (ContextImpl) context;
    }

    private File getPreferencesDir() {
        File file;
        synchronized (this.mSync) {
            if (this.mPreferencesDir == null) {
                this.mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            }
            file = this.mPreferencesDir;
        }
        return file;
    }

    private WallpaperManager getWallpaperManager() {
        return (WallpaperManager) WALLPAPER_FETCHER.getService(this);
    }

    private File makeFilename(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private Intent registerReceiverInternal(BroadcastReceiver broadcastReceiver, int i, IntentFilter intentFilter, String str, Handler handler, Context context) {
        IIntentReceiver iIntentReceiver = null;
        if (broadcastReceiver != null) {
            if (this.mPackageInfo == null || context == null) {
                Handler handler2 = handler;
                if (handler == null) {
                    handler2 = this.mMainThread.getHandler();
                }
                iIntentReceiver = new LoadedApk.ReceiverDispatcher(broadcastReceiver, context, handler2, null, true).getIIntentReceiver();
            } else {
                Handler handler3 = handler;
                if (handler == null) {
                    handler3 = this.mMainThread.getHandler();
                }
                iIntentReceiver = this.mPackageInfo.getReceiverDispatcher(broadcastReceiver, context, handler3, this.mMainThread.getInstrumentation(), true);
            }
        }
        try {
            return ActivityManagerNative.getDefault().registerReceiver(this.mMainThread.getApplicationThread(), this.mBasePackageName, iIntentReceiver, intentFilter, str, i);
        } catch (RemoteException e) {
            return null;
        }
    }

    private static void registerService(String str, ServiceFetcher serviceFetcher) {
        if (!(serviceFetcher instanceof StaticServiceFetcher)) {
            int i = sNextPerContextServiceCacheIndex;
            sNextPerContextServiceCacheIndex = i + 1;
            serviceFetcher.mContextCacheIndex = i;
        }
        SYSTEM_SERVICE_MAP.put(str, serviceFetcher);
    }

    private int resolveUserId(Uri uri) {
        return ContentProvider.getUserIdFromUri(uri, getUserId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setFilePermissionsFromMode(String str, int i, int i2) {
        int i3 = i2 | 432;
        int i4 = i3;
        if ((i & 1) != 0) {
            i4 = i3 | 4;
        }
        int i5 = i4;
        if ((i & 2) != 0) {
            i5 = i4 | 2;
        }
        FileUtils.setPermissions(str, i5, -1, -1);
    }

    private ComponentName startServiceCommon(Intent intent, UserHandle userHandle) {
        ComponentName componentName;
        try {
            validateServiceIntent(intent);
            intent.prepareToLeaveProcess();
            ComponentName startService = ActivityManagerNative.getDefault().startService(this.mMainThread.getApplicationThread(), intent, intent.resolveTypeIfNeeded(getContentResolver()), userHandle.getIdentifier());
            componentName = startService;
            if (startService != null) {
                if (startService.getPackageName().equals("!")) {
                    throw new SecurityException("Not allowed to start service " + intent + " without permission " + startService.getClassName());
                }
                componentName = startService;
                if (startService.getPackageName().equals("!!")) {
                    throw new SecurityException("Unable to start service " + intent + ": " + startService.getClassName());
                }
            }
        } catch (RemoteException e) {
            componentName = null;
        }
        return componentName;
    }

    private boolean stopServiceCommon(Intent intent, UserHandle userHandle) {
        try {
            validateServiceIntent(intent);
            intent.prepareToLeaveProcess();
            int stopService = ActivityManagerNative.getDefault().stopService(this.mMainThread.getApplicationThread(), intent, intent.resolveTypeIfNeeded(getContentResolver()), userHandle.getIdentifier());
            if (stopService < 0) {
                throw new SecurityException("Not allowed to stop service " + intent);
            }
            return stopService != 0;
        } catch (RemoteException e) {
            return false;
        }
    }

    private String uriModeFlagToString(int i) {
        StringBuilder sb = new StringBuilder();
        if ((i & 1) != 0) {
            sb.append("read and ");
        }
        if ((i & 2) != 0) {
            sb.append("write and ");
        }
        if ((i & 64) != 0) {
            sb.append("persistable and ");
        }
        if ((i & 128) != 0) {
            sb.append("prefix and ");
        }
        if (sb.length() > 5) {
            sb.setLength(sb.length() - 5);
            return sb.toString();
        }
        throw new IllegalArgumentException("Unknown permission mode flags: " + i);
    }

    private File validateFilePath(String str, boolean z) {
        File file;
        File file2;
        if (str.charAt(0) == File.separatorChar) {
            File file3 = new File(str.substring(0, str.lastIndexOf(File.separatorChar)));
            file2 = new File(file3, str.substring(str.lastIndexOf(File.separatorChar)));
            file = file3;
        } else {
            File databasesDir = getDatabasesDir();
            File makeFilename = makeFilename(databasesDir, str);
            file = databasesDir;
            file2 = makeFilename;
        }
        if (z && !file.isDirectory() && file.mkdir()) {
            FileUtils.setPermissions(file.getPath(), 505, -1, -1);
        }
        return file2;
    }

    private void validateServiceIntent(Intent intent) {
        if (intent.getComponent() == null && intent.getPackage() == null) {
            if (getApplicationInfo().targetSdkVersion >= 21) {
                throw new IllegalArgumentException("Service Intent must be explicit: " + intent);
            }
            Log.w(TAG, "Implicit intents with startService are not safe: " + intent + " " + Debug.getCallers(2, 3));
        }
    }

    private void warnIfCallingFromSystemProcess() {
        if (Process.myUid() == 1000) {
            Slog.w(TAG, "Calling a method in the system process without a qualified user: " + Debug.getCallers(5));
        }
    }

    @Override // android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        warnIfCallingFromSystemProcess();
        return bindServiceCommon(intent, serviceConnection, i, Process.myUserHandle());
    }

    @Override // android.content.Context
    public boolean bindServiceAsUser(Intent intent, ServiceConnection serviceConnection, int i, UserHandle userHandle) {
        return bindServiceCommon(intent, serviceConnection, i, userHandle);
    }

    @Override // android.content.Context
    public int checkCallingOrSelfPermission(String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return checkPermission(str, Binder.getCallingPid(), Binder.getCallingUid());
    }

    @Override // android.content.Context
    public int checkCallingOrSelfUriPermission(Uri uri, int i) {
        return checkUriPermission(uri, Binder.getCallingPid(), Binder.getCallingUid(), i);
    }

    @Override // android.content.Context
    public int checkCallingPermission(String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        int callingPid = Binder.getCallingPid();
        if (callingPid != Process.myPid()) {
            return checkPermission(str, callingPid, Binder.getCallingUid());
        }
        return -1;
    }

    @Override // android.content.Context
    public int checkCallingUriPermission(Uri uri, int i) {
        int callingPid = Binder.getCallingPid();
        if (callingPid != Process.myPid()) {
            return checkUriPermission(uri, callingPid, Binder.getCallingUid(), i);
        }
        return -1;
    }

    @Override // android.content.Context
    public int checkPermission(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return ActivityManagerNative.getDefault().checkPermission(str, i, i2);
        } catch (RemoteException e) {
            return -1;
        }
    }

    @Override // android.content.Context
    public int checkPermission(String str, int i, int i2, IBinder iBinder) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return ActivityManagerNative.getDefault().checkPermissionWithToken(str, i, i2, iBinder);
        } catch (RemoteException e) {
            return -1;
        }
    }

    @Override // android.content.Context
    public int checkUriPermission(Uri uri, int i, int i2, int i3) {
        try {
            return ActivityManagerNative.getDefault().checkUriPermission(ContentProvider.getUriWithoutUserId(uri), i, i2, i3, resolveUserId(uri), null);
        } catch (RemoteException e) {
            return -1;
        }
    }

    @Override // android.content.Context
    public int checkUriPermission(Uri uri, int i, int i2, int i3, IBinder iBinder) {
        try {
            return ActivityManagerNative.getDefault().checkUriPermission(ContentProvider.getUriWithoutUserId(uri), i, i2, i3, resolveUserId(uri), iBinder);
        } catch (RemoteException e) {
            return -1;
        }
    }

    @Override // android.content.Context
    public int checkUriPermission(Uri uri, String str, String str2, int i, int i2, int i3) {
        if ((i3 & 1) == 0 || !(str == null || checkPermission(str, i, i2) == 0)) {
            if ((i3 & 2) == 0 || !(str2 == null || checkPermission(str2, i, i2) == 0)) {
                if (uri != null) {
                    return checkUriPermission(uri, i, i2, i3);
                }
                return -1;
            }
            return 0;
        }
        return 0;
    }

    @Override // android.content.Context
    public void clearWallpaper() throws IOException {
        getWallpaperManager().clear();
    }

    @Override // android.content.Context
    public Context createApplicationContext(ApplicationInfo applicationInfo, int i) throws PackageManager.NameNotFoundException {
        return createApplicationContext(applicationInfo, null, i);
    }

    @Override // android.content.Context
    public Context createApplicationContext(ApplicationInfo applicationInfo, String str, int i) throws PackageManager.NameNotFoundException {
        LoadedApk packageInfo = this.mMainThread.getPackageInfo(applicationInfo, this.mResources.getCompatibilityInfo(), 1073741824 | i);
        if (packageInfo != null) {
            ContextImpl contextImpl = new ContextImpl(this, this.mMainThread, packageInfo, this.mActivityToken, new UserHandle(UserHandle.getUserId(applicationInfo.uid)), (i & 4) == 4, this.mDisplay, this.mOverrideConfiguration, str);
            if (contextImpl.mResources != null) {
                return contextImpl;
            }
        }
        throw new PackageManager.NameNotFoundException("Application package " + applicationInfo.packageName + " not found");
    }

    @Override // android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("overrideConfiguration must not be null");
        }
        return new ContextImpl(this, this.mMainThread, this.mPackageInfo, this.mActivityToken, this.mUser, this.mRestricted, this.mDisplay, configuration);
    }

    @Override // android.content.Context
    public Context createDisplayContext(Display display) {
        if (display == null) {
            throw new IllegalArgumentException("display must not be null");
        }
        return new ContextImpl(this, this.mMainThread, this.mPackageInfo, this.mActivityToken, this.mUser, this.mRestricted, display, this.mOverrideConfiguration);
    }

    @Override // android.content.Context
    public Context createPackageContext(String str, int i) throws PackageManager.NameNotFoundException {
        return createPackageContextAsUser(str, null, i, this.mUser != null ? this.mUser : Process.myUserHandle());
    }

    @Override // android.content.Context
    public Context createPackageContextAsUser(String str, int i, UserHandle userHandle) throws PackageManager.NameNotFoundException {
        return createPackageContextAsUser(str, null, i, userHandle);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0091, code lost:
        if (r0.mResources == null) goto L15;
     */
    @Override // android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.Context createPackageContextAsUser(java.lang.String r13, java.lang.String r14, int r15, android.os.UserHandle r16) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r12 = this;
            r0 = r15
            r1 = 4
            r0 = r0 & r1
            r1 = 4
            if (r0 != r1) goto L42
            r0 = 1
            r17 = r0
        La:
            r0 = r13
            java.lang.String r1 = "system"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            r0 = r13
            java.lang.String r1 = "android"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L48
        L1e:
            android.app.ContextImpl r0 = new android.app.ContextImpl
            r1 = r0
            r2 = r12
            r3 = r12
            android.app.ActivityThread r3 = r3.mMainThread
            r4 = r12
            android.app.LoadedApk r4 = r4.mPackageInfo
            r5 = r12
            android.os.IBinder r5 = r5.mActivityToken
            r6 = r16
            r7 = r17
            r8 = r12
            android.view.Display r8 = r8.mDisplay
            r9 = r12
            android.content.res.Configuration r9 = r9.mOverrideConfiguration
            r10 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14 = r0
        L40:
            r0 = r14
            return r0
        L42:
            r0 = 0
            r17 = r0
            goto La
        L48:
            r0 = r12
            android.app.ActivityThread r0 = r0.mMainThread
            r1 = r13
            r2 = r12
            android.content.res.Resources r2 = r2.mResources
            android.content.res.CompatibilityInfo r2 = r2.getCompatibilityInfo()
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = r15
            r3 = r3 | r4
            r4 = r16
            int r4 = r4.getIdentifier()
            android.app.LoadedApk r0 = r0.getPackageInfo(r1, r2, r3, r4)
            r18 = r0
            r0 = r18
            if (r0 == 0) goto L94
            android.app.ContextImpl r0 = new android.app.ContextImpl
            r1 = r0
            r2 = r12
            r3 = r12
            android.app.ActivityThread r3 = r3.mMainThread
            r4 = r18
            r5 = r12
            android.os.IBinder r5 = r5.mActivityToken
            r6 = r16
            r7 = r17
            r8 = r12
            android.view.Display r8 = r8.mDisplay
            r9 = r12
            android.content.res.Configuration r9 = r9.mOverrideConfiguration
            r10 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r16 = r0
            r0 = r16
            r14 = r0
            r0 = r16
            android.content.res.Resources r0 = r0.mResources
            if (r0 != 0) goto L40
        L94:
            android.content.pm.PackageManager$NameNotFoundException r0 = new android.content.pm.PackageManager$NameNotFoundException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Application package "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r13
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " not found"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.ContextImpl.createPackageContextAsUser(java.lang.String, java.lang.String, int, android.os.UserHandle):android.content.Context");
    }

    @Override // android.content.Context
    public String[] databaseList() {
        String[] list = getDatabasesDir().list();
        return list != null ? list : EMPTY_FILE_LIST;
    }

    @Override // android.content.Context
    public boolean deleteDatabase(String str) {
        try {
            return SQLiteDatabase.deleteDatabase(validateFilePath(str, false));
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.content.Context
    public boolean deleteFile(String str) {
        return makeFilename(getFilesDir(), str).delete();
    }

    @Override // android.content.Context
    public void enforceCallingOrSelfPermission(String str, String str2) {
        enforce(str, checkCallingOrSelfPermission(str), true, Binder.getCallingUid(), str2);
    }

    @Override // android.content.Context
    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String str) {
        enforceForUri(i, checkCallingOrSelfUriPermission(uri, i), true, Binder.getCallingUid(), uri, str);
    }

    @Override // android.content.Context
    public void enforceCallingPermission(String str, String str2) {
        enforce(str, checkCallingPermission(str), false, Binder.getCallingUid(), str2);
    }

    @Override // android.content.Context
    public void enforceCallingUriPermission(Uri uri, int i, String str) {
        enforceForUri(i, checkCallingUriPermission(uri, i), false, Binder.getCallingUid(), uri, str);
    }

    @Override // android.content.Context
    public void enforcePermission(String str, int i, int i2, String str2) {
        enforce(str, checkPermission(str, i, i2), false, i2, str2);
    }

    @Override // android.content.Context
    public void enforceUriPermission(Uri uri, int i, int i2, int i3, String str) {
        enforceForUri(i3, checkUriPermission(uri, i, i2, i3), false, i2, uri, str);
    }

    @Override // android.content.Context
    public void enforceUriPermission(Uri uri, String str, String str2, int i, int i2, int i3, String str3) {
        enforceForUri(i3, checkUriPermission(uri, str, str2, i, i2, i3), false, i2, uri, str3);
    }

    @Override // android.content.Context
    public String[] fileList() {
        String[] list = getFilesDir().list();
        return list != null ? list : EMPTY_FILE_LIST;
    }

    final IBinder getActivityToken() {
        return this.mActivityToken;
    }

    @Override // android.content.Context
    public Context getApplicationContext() {
        return this.mPackageInfo != null ? this.mPackageInfo.getApplication() : this.mMainThread.getApplication();
    }

    @Override // android.content.Context
    public ApplicationInfo getApplicationInfo() {
        if (this.mPackageInfo != null) {
            return this.mPackageInfo.getApplicationInfo();
        }
        throw new RuntimeException("Not supported in system context");
    }

    @Override // android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.Context
    public String getBasePackageName() {
        return this.mBasePackageName != null ? this.mBasePackageName : getPackageName();
    }

    @Override // android.content.Context
    public File getCacheDir() {
        File createFilesDirLocked;
        synchronized (this.mSync) {
            if (this.mCacheDir == null) {
                this.mCacheDir = new File(getDataDirFile(), "cache");
            }
            createFilesDirLocked = createFilesDirLocked(this.mCacheDir);
        }
        return createFilesDirLocked;
    }

    @Override // android.content.Context
    public ClassLoader getClassLoader() {
        return this.mPackageInfo != null ? this.mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    @Override // android.content.Context
    public File getCodeCacheDir() {
        File createFilesDirLocked;
        synchronized (this.mSync) {
            if (this.mCodeCacheDir == null) {
                this.mCodeCacheDir = new File(getDataDirFile(), "code_cache");
            }
            createFilesDirLocked = createFilesDirLocked(this.mCodeCacheDir);
        }
        return createFilesDirLocked;
    }

    @Override // android.content.Context
    public ContentResolver getContentResolver() {
        return this.mContentResolver;
    }

    @Override // android.content.Context
    public File getDatabasePath(String str) {
        return validateFilePath(str, false);
    }

    @Override // android.content.Context
    public File getDir(String str, int i) {
        File makeFilename = makeFilename(getDataDirFile(), "app_" + str);
        if (!makeFilename.exists()) {
            makeFilename.mkdir();
            setFilePermissionsFromMode(makeFilename.getPath(), i, 505);
        }
        return makeFilename;
    }

    @Override // android.content.Context
    public DisplayAdjustments getDisplayAdjustments(int i) {
        return this.mDisplayAdjustments;
    }

    @Override // android.content.Context
    public File getExternalCacheDir() {
        return getExternalCacheDirs()[0];
    }

    @Override // android.content.Context
    public File[] getExternalCacheDirs() {
        File[] ensureDirsExistOrFilter;
        synchronized (this.mSync) {
            if (this.mExternalCacheDirs == null) {
                this.mExternalCacheDirs = Environment.buildExternalStorageAppCacheDirs(getPackageName());
            }
            ensureDirsExistOrFilter = ensureDirsExistOrFilter(this.mExternalCacheDirs);
        }
        return ensureDirsExistOrFilter;
    }

    @Override // android.content.Context
    public File getExternalFilesDir(String str) {
        return getExternalFilesDirs(str)[0];
    }

    @Override // android.content.Context
    public File[] getExternalFilesDirs(String str) {
        File[] ensureDirsExistOrFilter;
        synchronized (this.mSync) {
            if (this.mExternalFilesDirs == null) {
                this.mExternalFilesDirs = Environment.buildExternalStorageAppFilesDirs(getPackageName());
            }
            File[] fileArr = this.mExternalFilesDirs;
            File[] fileArr2 = fileArr;
            if (str != null) {
                fileArr2 = Environment.buildPaths(fileArr, str);
            }
            ensureDirsExistOrFilter = ensureDirsExistOrFilter(fileArr2);
        }
        return ensureDirsExistOrFilter;
    }

    @Override // android.content.Context
    public File[] getExternalMediaDirs() {
        File[] ensureDirsExistOrFilter;
        synchronized (this.mSync) {
            if (this.mExternalMediaDirs == null) {
                this.mExternalMediaDirs = Environment.buildExternalStorageAppMediaDirs(getPackageName());
            }
            ensureDirsExistOrFilter = ensureDirsExistOrFilter(this.mExternalMediaDirs);
        }
        return ensureDirsExistOrFilter;
    }

    @Override // android.content.Context
    public File getFileStreamPath(String str) {
        return makeFilename(getFilesDir(), str);
    }

    @Override // android.content.Context
    public File getFilesDir() {
        File createFilesDirLocked;
        synchronized (this.mSync) {
            if (this.mFilesDir == null) {
                this.mFilesDir = new File(getDataDirFile(), "files");
            }
            createFilesDirLocked = createFilesDirLocked(this.mFilesDir);
        }
        return createFilesDirLocked;
    }

    @Override // android.content.Context
    public Looper getMainLooper() {
        return this.mMainThread.getLooper();
    }

    @Override // android.content.Context
    public File getNoBackupFilesDir() {
        File createFilesDirLocked;
        synchronized (this.mSync) {
            if (this.mNoBackupFilesDir == null) {
                this.mNoBackupFilesDir = new File(getDataDirFile(), "no_backup");
            }
            createFilesDirLocked = createFilesDirLocked(this.mNoBackupFilesDir);
        }
        return createFilesDirLocked;
    }

    @Override // android.content.Context
    public File getObbDir() {
        return getObbDirs()[0];
    }

    @Override // android.content.Context
    public File[] getObbDirs() {
        File[] ensureDirsExistOrFilter;
        synchronized (this.mSync) {
            if (this.mExternalObbDirs == null) {
                this.mExternalObbDirs = Environment.buildExternalStorageAppObbDirs(getPackageName());
            }
            ensureDirsExistOrFilter = ensureDirsExistOrFilter(this.mExternalObbDirs);
        }
        return ensureDirsExistOrFilter;
    }

    @Override // android.content.Context
    public String getOpPackageName() {
        return this.mOpPackageName != null ? this.mOpPackageName : getBasePackageName();
    }

    final Context getOuterContext() {
        return this.mOuterContext;
    }

    @Override // android.content.Context
    public String getPackageCodePath() {
        if (this.mPackageInfo != null) {
            return this.mPackageInfo.getAppDir();
        }
        throw new RuntimeException("Not supported in system context");
    }

    @Override // android.content.Context
    public PackageManager getPackageManager() {
        if (this.mPackageManager != null) {
            return this.mPackageManager;
        }
        IPackageManager packageManager = ActivityThread.getPackageManager();
        if (packageManager != null) {
            ApplicationPackageManager applicationPackageManager = new ApplicationPackageManager(this, packageManager);
            this.mPackageManager = applicationPackageManager;
            return applicationPackageManager;
        }
        return null;
    }

    @Override // android.content.Context
    public String getPackageName() {
        return this.mPackageInfo != null ? this.mPackageInfo.getPackageName() : "android";
    }

    @Override // android.content.Context
    public String getPackageResourcePath() {
        if (this.mPackageInfo != null) {
            return this.mPackageInfo.getResDir();
        }
        throw new RuntimeException("Not supported in system context");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context getReceiverRestrictedContext() {
        if (this.mReceiverRestrictedContext != null) {
            return this.mReceiverRestrictedContext;
        }
        ReceiverRestrictedContext receiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
        this.mReceiverRestrictedContext = receiverRestrictedContext;
        return receiverRestrictedContext;
    }

    @Override // android.content.Context
    public Resources getResources() {
        return this.mResources;
    }

    @Override // android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        synchronized (ContextImpl.class) {
            try {
                if (sSharedPrefs == null) {
                    sSharedPrefs = new ArrayMap<>();
                }
                String packageName = getPackageName();
                ArrayMap<String, SharedPreferencesImpl> arrayMap = sSharedPrefs.get(packageName);
                ArrayMap<String, SharedPreferencesImpl> arrayMap2 = arrayMap;
                if (arrayMap == null) {
                    arrayMap2 = new ArrayMap<>();
                    sSharedPrefs.put(packageName, arrayMap2);
                }
                String str2 = str;
                if (this.mPackageInfo.getApplicationInfo().targetSdkVersion < 19) {
                    str2 = str;
                    if (str == null) {
                        str2 = b.l;
                    }
                }
                SharedPreferencesImpl sharedPreferencesImpl = arrayMap2.get(str2);
                if (sharedPreferencesImpl == null) {
                    SharedPreferencesImpl sharedPreferencesImpl2 = new SharedPreferencesImpl(getSharedPrefsFile(str2), i);
                    arrayMap2.put(str2, sharedPreferencesImpl2);
                    return sharedPreferencesImpl2;
                }
                if ((i & 4) != 0 || getApplicationInfo().targetSdkVersion < 11) {
                    sharedPreferencesImpl.startReloadIfChangedUnexpectedly();
                }
                return sharedPreferencesImpl;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.Context
    public File getSharedPrefsFile(String str) {
        return makeFilename(getPreferencesDir(), str + ".xml");
    }

    @Override // android.content.Context
    public Object getSystemService(String str) {
        ServiceFetcher serviceFetcher = SYSTEM_SERVICE_MAP.get(str);
        if (serviceFetcher == null) {
            return null;
        }
        return serviceFetcher.getService(this);
    }

    @Override // android.content.Context
    public Resources.Theme getTheme() {
        if (this.mTheme == null) {
            this.mThemeResource = Resources.selectDefaultTheme(this.mThemeResource, getOuterContext().getApplicationInfo().targetSdkVersion);
            this.mTheme = this.mResources.newTheme();
            this.mTheme.applyStyle(this.mThemeResource, true);
        }
        return this.mTheme;
    }

    @Override // android.content.Context
    public int getThemeResId() {
        return this.mThemeResource;
    }

    @Override // android.content.Context
    public int getUserId() {
        return this.mUser.getIdentifier();
    }

    @Override // android.content.Context
    public Drawable getWallpaper() {
        return getWallpaperManager().getDrawable();
    }

    @Override // android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        return getWallpaperManager().getDesiredMinimumHeight();
    }

    @Override // android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        return getWallpaperManager().getDesiredMinimumWidth();
    }

    @Override // android.content.Context
    public void grantUriPermission(String str, Uri uri, int i) {
        try {
            ActivityManagerNative.getDefault().grantUriPermission(this.mMainThread.getApplicationThread(), str, ContentProvider.getUriWithoutUserId(uri), i, resolveUserId(uri));
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void installSystemApplicationInfo(ApplicationInfo applicationInfo, ClassLoader classLoader) {
        this.mPackageInfo.installSystemApplicationInfo(applicationInfo, classLoader);
    }

    @Override // android.content.Context
    public boolean isRestricted() {
        return this.mRestricted;
    }

    @Override // android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        return new FileInputStream(makeFilename(getFilesDir(), str));
    }

    @Override // android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        boolean z = (32768 & i) != 0;
        File makeFilename = makeFilename(getFilesDir(), str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(makeFilename, z);
            setFilePermissionsFromMode(makeFilename.getPath(), i, 0);
            return fileOutputStream;
        } catch (FileNotFoundException e) {
            File parentFile = makeFilename.getParentFile();
            parentFile.mkdir();
            FileUtils.setPermissions(parentFile.getPath(), 505, -1, -1);
            FileOutputStream fileOutputStream2 = new FileOutputStream(makeFilename, z);
            setFilePermissionsFromMode(makeFilename.getPath(), i, 0);
            return fileOutputStream2;
        }
    }

    @Override // android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return openOrCreateDatabase(str, i, cursorFactory, null);
    }

    @Override // android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        File validateFilePath = validateFilePath(str, true);
        int i2 = 268435456;
        if ((i & 8) != 0) {
            i2 = 268435456 | 536870912;
        }
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(validateFilePath.getPath(), cursorFactory, i2, databaseErrorHandler);
        setFilePermissionsFromMode(validateFilePath.getPath(), i, 0);
        return openDatabase;
    }

    @Override // android.content.Context
    public Drawable peekWallpaper() {
        return getWallpaperManager().peekDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void performFinalCleanup(String str, String str2) {
        this.mPackageInfo.removeContextRegistrations(getOuterContext(), str, str2);
    }

    @Override // android.content.Context
    public void recreateTheme() {
        if (this.mTheme != null) {
            Resources.Theme newTheme = this.mResources.newTheme();
            newTheme.applyStyle(this.mThemeResource, true);
            this.mTheme.setTo(newTheme);
        }
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return registerReceiver(broadcastReceiver, intentFilter, null, null);
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return registerReceiverInternal(broadcastReceiver, getUserId(), intentFilter, str, handler, getOuterContext());
    }

    @Override // android.content.Context
    public Intent registerReceiverAsUser(BroadcastReceiver broadcastReceiver, UserHandle userHandle, IntentFilter intentFilter, String str, Handler handler) {
        return registerReceiverInternal(broadcastReceiver, userHandle.getIdentifier(), intentFilter, str, handler, getOuterContext());
    }

    @Override // android.content.Context
    public void removeStickyBroadcast(Intent intent) {
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        Intent intent2 = intent;
        if (resolveTypeIfNeeded != null) {
            intent2 = new Intent(intent);
            intent2.setDataAndType(intent2.getData(), resolveTypeIfNeeded);
        }
        try {
            intent2.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().unbroadcastIntent(this.mMainThread.getApplicationThread(), intent2, getUserId());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        Intent intent2 = intent;
        if (resolveTypeIfNeeded != null) {
            intent2 = new Intent(intent);
            intent2.setDataAndType(intent2.getData(), resolveTypeIfNeeded);
        }
        try {
            intent2.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().unbroadcastIntent(this.mMainThread.getApplicationThread(), intent2, userHandle.getIdentifier());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void revokeUriPermission(Uri uri, int i) {
        try {
            ActivityManagerNative.getDefault().revokeUriPermission(this.mMainThread.getApplicationThread(), ContentProvider.getUriWithoutUserId(uri), i, resolveUserId(uri));
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void scheduleFinalCleanup(String str, String str2) {
        this.mMainThread.scheduleContextCleanup(this, str, str2);
    }

    @Override // android.content.Context
    public void sendBroadcast(Intent intent) {
        warnIfCallingFromSystemProcess();
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, null, -1, null, null, null, -1, false, false, getUserId());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        warnIfCallingFromSystemProcess();
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, null, -1, null, null, str, -1, false, false, getUserId());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendBroadcast(Intent intent, String str, int i) {
        warnIfCallingFromSystemProcess();
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, null, -1, null, null, str, i, false, false, getUserId());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, null, -1, null, null, null, -1, false, false, userHandle.getIdentifier());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String str) {
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, null, -1, null, null, str, -1, false, false, userHandle.getIdentifier());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        warnIfCallingFromSystemProcess();
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, null, -1, null, null, str, -1, true, false, getUserId());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, int i, BroadcastReceiver broadcastReceiver, Handler handler, int i2, String str2, Bundle bundle) {
        warnIfCallingFromSystemProcess();
        IIntentReceiver iIntentReceiver = null;
        if (broadcastReceiver != null) {
            if (this.mPackageInfo != null) {
                Handler handler2 = handler;
                if (handler == null) {
                    handler2 = this.mMainThread.getHandler();
                }
                iIntentReceiver = this.mPackageInfo.getReceiverDispatcher(broadcastReceiver, getOuterContext(), handler2, this.mMainThread.getInstrumentation(), false);
            } else {
                Handler handler3 = handler;
                if (handler == null) {
                    handler3 = this.mMainThread.getHandler();
                }
                iIntentReceiver = new LoadedApk.ReceiverDispatcher(broadcastReceiver, getOuterContext(), handler3, null, false).getIIntentReceiver();
            }
        }
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, iIntentReceiver, i2, str2, bundle, str, i, true, false, getUserId());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        sendOrderedBroadcast(intent, str, -1, broadcastReceiver, handler, i, str2, bundle);
    }

    @Override // android.content.Context
    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, int i, BroadcastReceiver broadcastReceiver, Handler handler, int i2, String str2, Bundle bundle) {
        IIntentReceiver iIntentReceiver = null;
        if (broadcastReceiver != null) {
            if (this.mPackageInfo != null) {
                Handler handler2 = handler;
                if (handler == null) {
                    handler2 = this.mMainThread.getHandler();
                }
                iIntentReceiver = this.mPackageInfo.getReceiverDispatcher(broadcastReceiver, getOuterContext(), handler2, this.mMainThread.getInstrumentation(), false);
            } else {
                Handler handler3 = handler;
                if (handler == null) {
                    handler3 = this.mMainThread.getHandler();
                }
                iIntentReceiver = new LoadedApk.ReceiverDispatcher(broadcastReceiver, getOuterContext(), handler3, null, false).getIIntentReceiver();
            }
        }
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, iIntentReceiver, i2, str2, bundle, str, i, true, false, userHandle.getIdentifier());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        sendOrderedBroadcastAsUser(intent, userHandle, str, -1, broadcastReceiver, handler, i, str2, bundle);
    }

    @Override // android.content.Context
    public void sendStickyBroadcast(Intent intent) {
        warnIfCallingFromSystemProcess();
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, null, -1, null, null, null, -1, false, true, getUserId());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, null, -1, null, null, null, -1, false, true, userHandle.getIdentifier());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        warnIfCallingFromSystemProcess();
        IIntentReceiver iIntentReceiver = null;
        if (broadcastReceiver != null) {
            if (this.mPackageInfo != null) {
                Handler handler2 = handler;
                if (handler == null) {
                    handler2 = this.mMainThread.getHandler();
                }
                iIntentReceiver = this.mPackageInfo.getReceiverDispatcher(broadcastReceiver, getOuterContext(), handler2, this.mMainThread.getInstrumentation(), false);
            } else {
                Handler handler3 = handler;
                if (handler == null) {
                    handler3 = this.mMainThread.getHandler();
                }
                iIntentReceiver = new LoadedApk.ReceiverDispatcher(broadcastReceiver, getOuterContext(), handler3, null, false).getIIntentReceiver();
            }
        }
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, iIntentReceiver, i, str, bundle, null, -1, true, true, getUserId());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        IIntentReceiver iIntentReceiver = null;
        if (broadcastReceiver != null) {
            if (this.mPackageInfo != null) {
                Handler handler2 = handler;
                if (handler == null) {
                    handler2 = this.mMainThread.getHandler();
                }
                iIntentReceiver = this.mPackageInfo.getReceiverDispatcher(broadcastReceiver, getOuterContext(), handler2, this.mMainThread.getInstrumentation(), false);
            } else {
                Handler handler3 = handler;
                if (handler == null) {
                    handler3 = this.mMainThread.getHandler();
                }
                iIntentReceiver = new LoadedApk.ReceiverDispatcher(broadcastReceiver, getOuterContext(), handler3, null, false).getIIntentReceiver();
            }
        }
        String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(getContentResolver());
        try {
            intent.prepareToLeaveProcess();
            ActivityManagerNative.getDefault().broadcastIntent(this.mMainThread.getApplicationThread(), intent, resolveTypeIfNeeded, iIntentReceiver, i, str, bundle, null, -1, true, true, userHandle.getIdentifier());
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setOuterContext(Context context) {
        this.mOuterContext = context;
    }

    @Override // android.content.Context
    public void setTheme(int i) {
        this.mThemeResource = i;
    }

    @Override // android.content.Context
    public void setWallpaper(Bitmap bitmap) throws IOException {
        getWallpaperManager().setBitmap(bitmap);
    }

    @Override // android.content.Context
    public void setWallpaper(InputStream inputStream) throws IOException {
        getWallpaperManager().setStream(inputStream);
    }

    @Override // android.content.Context
    public void startActivities(Intent[] intentArr) {
        warnIfCallingFromSystemProcess();
        startActivities(intentArr, null);
    }

    @Override // android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        warnIfCallingFromSystemProcess();
        if ((intentArr[0].getFlags() & 268435456) == 0) {
            throw new AndroidRuntimeException("Calling startActivities() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag on first Intent. Is this really what you want?");
        }
        this.mMainThread.getInstrumentation().execStartActivities(getOuterContext(), this.mMainThread.getApplicationThread(), null, null, intentArr, bundle);
    }

    @Override // android.content.Context
    public void startActivitiesAsUser(Intent[] intentArr, Bundle bundle, UserHandle userHandle) {
        if ((intentArr[0].getFlags() & 268435456) == 0) {
            throw new AndroidRuntimeException("Calling startActivities() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag on first Intent. Is this really what you want?");
        }
        this.mMainThread.getInstrumentation().execStartActivitiesAsUser(getOuterContext(), this.mMainThread.getApplicationThread(), null, null, intentArr, bundle, userHandle.getIdentifier());
    }

    @Override // android.content.Context
    public void startActivity(Intent intent) {
        warnIfCallingFromSystemProcess();
        startActivity(intent, null);
    }

    @Override // android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        warnIfCallingFromSystemProcess();
        if ((intent.getFlags() & 268435456) == 0) {
            throw new AndroidRuntimeException("Calling startActivity() from outside of an Activity  context requires the FLAG_ACTIVITY_NEW_TASK flag. Is this really what you want?");
        }
        this.mMainThread.getInstrumentation().execStartActivity(getOuterContext(), this.mMainThread.getApplicationThread(), (IBinder) null, (Activity) null, intent, -1, bundle);
    }

    @Override // android.content.Context
    public void startActivityAsUser(Intent intent, Bundle bundle, UserHandle userHandle) {
        try {
            ActivityManagerNative.getDefault().startActivityAsUser(this.mMainThread.getApplicationThread(), getBasePackageName(), intent, intent.resolveTypeIfNeeded(getContentResolver()), null, null, 0, 268435456, null, bundle, userHandle.getIdentifier());
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void startActivityAsUser(Intent intent, UserHandle userHandle) {
        startActivityAsUser(intent, null, userHandle);
    }

    @Override // android.content.Context
    public boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setAllowFds(false);
            } catch (RemoteException e) {
                return false;
            }
        }
        return ActivityManagerNative.getDefault().startInstrumentation(componentName, str, 0, bundle, null, null, getUserId(), null);
    }

    @Override // android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        startIntentSender(intentSender, intent, i, i2, i3, null);
    }

    @Override // android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) throws IntentSender.SendIntentException {
        String str = null;
        if (intent != null) {
            try {
                intent.migrateExtraStreamToClipData();
                intent.prepareToLeaveProcess();
                str = intent.resolveTypeIfNeeded(getContentResolver());
            } catch (RemoteException e) {
                return;
            }
        }
        int startActivityIntentSender = ActivityManagerNative.getDefault().startActivityIntentSender(this.mMainThread.getApplicationThread(), intentSender, intent, str, null, null, 0, i, i2, bundle);
        if (startActivityIntentSender == -6) {
            throw new IntentSender.SendIntentException();
        }
        Instrumentation.checkStartActivityResult(startActivityIntentSender, null);
    }

    @Override // android.content.Context
    public ComponentName startService(Intent intent) {
        warnIfCallingFromSystemProcess();
        return startServiceCommon(intent, this.mUser);
    }

    @Override // android.content.Context
    public ComponentName startServiceAsUser(Intent intent, UserHandle userHandle) {
        return startServiceCommon(intent, userHandle);
    }

    @Override // android.content.Context
    public boolean stopService(Intent intent) {
        warnIfCallingFromSystemProcess();
        return stopServiceCommon(intent, this.mUser);
    }

    @Override // android.content.Context
    public boolean stopServiceAsUser(Intent intent, UserHandle userHandle) {
        return stopServiceCommon(intent, userHandle);
    }

    @Override // android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        if (serviceConnection == null) {
            throw new IllegalArgumentException("connection is null");
        }
        if (this.mPackageInfo == null) {
            throw new RuntimeException("Not supported in system context");
        }
        try {
            ActivityManagerNative.getDefault().unbindService(this.mPackageInfo.forgetServiceDispatcher(getOuterContext(), serviceConnection));
        } catch (RemoteException e) {
        }
    }

    @Override // android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        if (this.mPackageInfo == null) {
            throw new RuntimeException("Not supported in system context");
        }
        try {
            ActivityManagerNative.getDefault().unregisterReceiver(this.mPackageInfo.forgetReceiverDispatcher(getOuterContext(), broadcastReceiver));
        } catch (RemoteException e) {
        }
    }
}
