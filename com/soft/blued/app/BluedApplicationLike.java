package com.soft.blued.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.DownloadManager;
import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.WebView;
import androidx.multidex.MultiDex;
import com.blued.android.chat.ChatDBImpl;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.init.InitTaskManager;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.web.cache.BluedWebViewCache;
import com.blued.android.framework_operation_provider.PageLifecycleProvider;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.Host;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.observer.LiveSysNetworkObserver;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.yy_china.broadcastReceiver.YYNetworkReceiver;
import com.blued.android.provider.AppInfoProvider;
import com.blued.android.provider.StringResourceProvider;
import com.blued.android.provider.UserInfoProvider;
import com.blued.android.statistics.BluedStatistics;
import com.mcxiaoke.packer.helper.PackerNg;
import com.sobot.chat.SobotUIConfig;
import com.sobot.chat.ZCSobotApi;
import com.soft.blued.R;
import com.soft.blued.manager.BroadcastReceiverListener;
import com.soft.blued.manager.BroadcastReceiverManager;
import com.soft.blued.manager.FollowedUsersNotificationManager;
import com.soft.blued.manager.SendNotificationManager;
import com.soft.blued.push.PushManager;
import com.soft.blued.service.AutoStartService;
import com.soft.blued.tinker.Log.MyLogImp;
import com.soft.blued.tinker.reporter.BluedTinkerReport;
import com.soft.blued.tinker.util.TinkerManager;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.video.manager.NetWorkObserverManager;
import com.soft.blued.ui.welcome.FirstActivity;
import com.soft.blued.ui.welcome.helper.DownLoadADApkHelper;
import com.soft.blued.ui.yy_room.YYRoomInfoChannel;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.DurationUtils;
import com.soft.blued.utils.FileUtils;
import com.soft.blued.utils.HookActivityManager;
import com.soft.blued.utils.activity.BDActivityManager;
import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.youzan.spiderman.utils.Stone;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/app/BluedApplicationLike.class */
public class BluedApplicationLike extends DefaultApplicationLike {
    public static final boolean DEBUG_CHAT = false;
    public static final boolean DEBUG_HTTP = false;
    private static final String TAG = "Tinker.BluedApplication";
    public static final boolean TEST_SERVER = false;
    public static final String TX_LOGIN_APPKEY = "w4OcZLOk";
    public static BluedAppHandoverListener bluedAppHandoverListener;
    public static String previousLanguage;
    public static final String umengAppKey = "5359cd0256240b7faf0a09db";
    private Tinker tinker;
    private static final String[] GOTO_FIRST_ACTIVITY_CLASSES = {"com.soft.blued.icon0", "com.soft.blued.icon1", "com.soft.blued.icon2", "com.soft.blued.icon3", "com.soft.blued.icon4", "com.soft.blued.icon5", "com.soft.blued.icon6", "com.soft.blued.ui.welcome.FirstActivity", "com.soft.blued.ui.welcome.PushClickActivity"};
    public static boolean SPECIAL_DEVICE_FOR_VIEW_OVERFLOW = false;
    public static Uri outUri = null;
    public static boolean ifFeedFloatAuthShowed = false;
    public static boolean isEnterLogin = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/app/BluedApplicationLike$DeadSystemInstrumentation.class */
    public static class DeadSystemInstrumentation extends Instrumentation {
        private DeadSystemInstrumentation() {
        }

        @Override // android.app.Instrumentation
        public boolean onException(Object obj, Throwable th) {
            if (Build.VERSION.SDK_INT < 24 || !th.toString().contains("DeadSystemException")) {
                return super.onException(obj, th);
            }
            return true;
        }
    }

    public BluedApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent) {
        super(application, i, z, j, j2, intent);
    }

    private static void applyLanguage(String str, String str2) {
        Resources resources = AppInfo.d().getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.locale = new Locale(str, str2);
        resources.updateConfiguration(configuration, displayMetrics);
    }

    private static void createFile(File file, boolean z) {
        if (z) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static long getAppIntoForegroundTime() {
        BluedAppHandoverListener bluedAppHandoverListener2 = bluedAppHandoverListener;
        if (bluedAppHandoverListener2 != null) {
            return bluedAppHandoverListener2.c();
        }
        return 0L;
    }

    public static Activity getForeActivity() {
        BluedAppHandoverListener bluedAppHandoverListener2 = bluedAppHandoverListener;
        if (bluedAppHandoverListener2 != null) {
            return bluedAppHandoverListener2.b();
        }
        return null;
    }

    public static String getProcessName(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
        return "";
    }

    public static String getProcessNameForWeb(Context context) {
        if (context == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private static void handleWebViewDir(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        String str = "";
        try {
            String processNameForWeb = getProcessNameForWeb(context);
            if (!TextUtils.equals(context.getPackageName(), processNameForWeb)) {
                String str2 = processNameForWeb;
                if (TextUtils.isEmpty(processNameForWeb)) {
                    str2 = context.getPackageName();
                }
                WebView.setDataDirectorySuffix(str2);
                str = BridgeUtil.UNDERLINE_STR + str2;
            }
            tryLockOrRecreateFile(context, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initAppGlobal(Application application) {
        initAppInfo(application);
        if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
            AppInfo.t();
            AppInfo.q();
            AppInfo.s();
        }
        setChannel();
        initHttpManager(application);
        initSimilarity();
        initBluedFramework();
        Host.a();
        initCoroutineRequestHost();
        initChatManager();
        BDActivityManager.f34819a.a(application, null);
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.soft.blued.app.BluedApplicationLike.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                SendNotificationManager.a().b(activity);
                FollowedUsersNotificationManager.f29698a.b(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                SendNotificationManager.a().a(activity);
                FollowedUsersNotificationManager.f29698a.a(activity);
            }
        });
    }

    public static void initAppInfo(Application application) {
        if (AppInfo.c()) {
            return;
        }
        AppInfo.a(application, "1", false, false);
        AppInfo.s = 0.1f;
        bluedAppHandoverListener = new BluedAppHandoverListener(AppInfo.d());
        AppInfo.b(FirstActivity.class.getName());
        AppInfo.a(bluedAppHandoverListener);
        String lowerCase = Build.MODEL.toLowerCase();
        if (!TextUtils.isEmpty(lowerCase) && (lowerCase.contains("oppo r11") || lowerCase.contains("vivo x9"))) {
            SPECIAL_DEVICE_FOR_VIEW_OVERFLOW = true;
        }
        AppInfo.a(true, 2131101780, 2131101780);
    }

    public static void initAppLanguage() {
        Locale e = LocaleUtils.e();
        Locale c2 = LocaleUtils.c();
        if (e == null || c2 == null || !LocaleUtils.a() || TextUtils.isEmpty(e.getLanguage()) || (TextUtils.equals(e.getLanguage(), c2.getLanguage()) && TextUtils.equals(e.getCountry(), c2.getCountry()))) {
            e = c2;
        } else {
            LocaleUtils.a(AppInfo.d(), e);
            Logger.b("xpf", "not equal");
        }
        String language = e != null ? e.getLanguage() : "";
        if (!TextUtils.isEmpty(language)) {
            if (BluedPreferences.aG()) {
                previousLanguage = language;
            } else {
                previousLanguage = null;
            }
        }
        LocaleUtils.b(AppInfo.d(), e);
    }

    public static void initBluedFramework() {
        ProviderHolder.a().a(new UserInfoProvider());
        ProviderHolder.a().a(new StringResourceProvider());
        ProviderHolder.a().a(new PageLifecycleProvider());
        ProviderHolder.a().a(new AppInfoProvider());
        BluedURIRouter.a().d("bd_uri_router.json");
        BluedURIRouter.a().e("bd_uri_prefix.json");
        BluedURIRouter.a().c("com.blued.android.similarity_operation_provider.BluedURIRouterAdapter");
        BluedWebViewCache.a("https://web.bldimg.com", "https://www.bldimg.com");
        BluedWebViewCache.b(Stone.CSS_SUFFIX, Stone.JS_SUFFIX);
    }

    public static void initChatManager() {
        if (ChatManager.isInited()) {
            return;
        }
        ChatManager.getInstance().init(AppInfo.d(), ChatManager.ClientType.CHINA, new ChatDBImpl(), false);
    }

    public static void initCoroutineRequestHost() {
        HashMap hashMap = new HashMap();
        hashMap.put("HOST_HTTP", BluedHttpUrl.q());
        hashMap.put("HOST_PAY", BluedHttpUrl.r());
        hashMap.put("HOST_SDK", BluedHttpUrl.s());
        hashMap.put("HOST_WEB", BluedHttpUrl.p());
        BluedApiProxy.b().a(hashMap);
    }

    public static void initHttpManager(Context context) {
        if (HttpManager.a()) {
            return;
        }
        new HttpManager.Builder(context).a(false).a(HappyDnsUtils.d()).a();
        HappyDnsUtils.d().registerNetworkReceiver(context);
    }

    private void initLiveRoomCallBack() {
        LiveRoomInfoChannel.a();
    }

    public static void initMMKV(Application application) {
        BluedSharedPreferences.a(application);
    }

    private void initReceiver() {
        BroadcastReceiverManager.a().registerReceiver(new String[]{"android.net.conn.CONNECTIVITY_CHANGE", "android.intent.action.USER_PRESENT", "com.soft.blued.android.ACTION_AUTOSTARTER"}, new BroadcastReceiverListener() { // from class: com.soft.blued.app.BluedApplicationLike.3
            @Override // com.soft.blued.manager.BroadcastReceiverListener
            public void a(String str, Intent intent) {
                Logger.a("AutoStartReceiver.onReceive(), intent:" + intent.getAction(), new Object[0]);
                AutoStartService.startService(AppInfo.d());
            }
        });
        BroadcastReceiverManager.a().registerReceiver(Intent.ACTION_LOCALE_CHANGED, new BroadcastReceiverListener() { // from class: com.soft.blued.app.BluedApplicationLike.4
            @Override // com.soft.blued.manager.BroadcastReceiverListener
            public void a(String str, Intent intent) {
                Logger.a("LOCALE_CHANGED.onReceive(), intent:" + intent.getAction(), new Object[0]);
                LocaleUtils.d();
                if (!LocaleUtils.a()) {
                    LocaleUtils.c(AppInfo.d());
                    return;
                }
                LocaleUtils.a(AppInfo.d(), LocaleUtils.e());
                AppUtils.a(AppInfo.d());
            }
        });
        BroadcastReceiverManager.a().registerReceiver("android.net.conn.CONNECTIVITY_CHANGE", new BroadcastReceiverListener() { // from class: com.soft.blued.app.BluedApplicationLike.5
            @Override // com.soft.blued.manager.BroadcastReceiverListener
            public void a(String str, Intent intent) {
                Logger.a("CONNECTIVITY_CHANGE.onReceive(), intent:" + intent.getAction(), new Object[0]);
                BluedStatistics.a().b(NetworkUtils.d());
                BluedStatistics.a().a(DeviceUtils.d());
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppInfo.d().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    Logger.a("Tinker.BluedApplication 非联网状�?", new Object[0]);
                    NetWorkObserverManager.a().a(false);
                    return;
                }
                ChatManager.getInstance().networkChanged();
                NetWorkObserverManager.a().a(true);
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                    NetWorkObserverManager.a().b(true);
                    Logger.a("Tinker.BluedApplication  wifi状�??", new Object[0]);
                    return;
                }
                NetWorkObserverManager.a().b(false);
                LiveSysNetworkObserver.a().b();
                Logger.a("Tinker.BluedApplication  正常联网的非wifi状�??", new Object[0]);
            }
        });
        BroadcastReceiverManager.a().registerReceiver(DownloadManager.ACTION_DOWNLOAD_COMPLETE, new BroadcastReceiverListener() { // from class: com.soft.blued.app.BluedApplicationLike.6
            @Override // com.soft.blued.manager.BroadcastReceiverListener
            public void a(String str, Intent intent) {
                if (intent != null) {
                    Logger.a("DOWNLOAD_COMPLETE.onReceive(), intent:" + intent.getAction(), new Object[0]);
                    String e = BluedPreferences.e(intent.getLongExtra("extra_download_id", -1L));
                    if (TextUtils.isEmpty(e)) {
                        return;
                    }
                    FileUtils.b(new File(e));
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_INSTALL);
        intentFilter.addAction(Intent.ACTION_PACKAGE_REPLACED);
        getApplication().getBaseContext().registerReceiver(new BroadcastReceiver() { // from class: com.soft.blued.app.BluedApplicationLike.7
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                DownLoadADApkHelper.f34639a.a(intent);
            }
        }, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        getApplication().getBaseContext().registerReceiver(YYNetworkReceiver.a(), intentFilter2);
    }

    public static void initSimilarity() {
        BluedURIRouter.a().a(true);
        BluedURIRouter.a().c("com.blued.android.similarity_operation_provider.BluedURIRouterAdapter");
    }

    public static void initSkinSdk(Application application) {
        try {
            BluedSkinUtils.a(application);
        } catch (Exception e) {
        }
    }

    private void initSobotSdk() {
        SobotUIConfig.sobot_serviceImgId = R.drawable.icon_service_turnserver;
        SobotUIConfig.sobot_chat_right_bgColor = 2131101766;
        SobotUIConfig.sobot_chat_left_textColor = 2131102263;
        SobotUIConfig.sobot_chat_left_link_textColor = 2131101766;
        ZCSobotApi.initSobotSDK(AppInfo.d(), AppInfo.d().getResources().getString(R.string.sobot_app_key), "");
    }

    private void initYYRoomCallBack() {
        YYRoomInfoChannel.a();
    }

    public static boolean isAppOnForeground() {
        BluedAppHandoverListener bluedAppHandoverListener2 = bluedAppHandoverListener;
        if (bluedAppHandoverListener2 != null) {
            return bluedAppHandoverListener2.a();
        }
        return false;
    }

    public static boolean isGetuiPushProcess(Context context) {
        String processName = getProcessName(context);
        return TextUtils.equals(processName, context.getApplicationContext().getPackageName() + ":pushservice");
    }

    public static boolean isMainApplication(Context context) {
        return getProcessName(context).equals(context.getApplicationContext().getPackageName());
    }

    public static boolean isPushProcess(Context context) {
        String processName = getProcessName(context);
        return TextUtils.equals(processName, context.getApplicationContext().getPackageName() + ":push");
    }

    public static void setChannel() {
        String a2 = PackerNg.a(AppInfo.d());
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            try {
                ApplicationInfo applicationInfo = AppInfo.d().getPackageManager().getApplicationInfo(AppInfo.d().getPackageName(), 128);
                str = a2;
                if (applicationInfo != null) {
                    str = a2;
                    if (applicationInfo.metaData != null) {
                        str = applicationInfo.metaData.getString("UMENG_CHANNEL");
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                str = a2;
            }
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "a9999a";
        }
        LogUtils.c("setChannel: " + str2);
        AppInfo.a(str2);
    }

    private void setDeadSystemInstrumentation() {
        try {
            DeadSystemInstrumentation deadSystemInstrumentation = new DeadSystemInstrumentation();
            Object invoke = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", null).invoke(null, null);
            Field declaredField = invoke.getClass().getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            declaredField.set(invoke, deadSystemInstrumentation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void tryLockOrRecreateFile(Context context, String str) {
        File file = new File(context.getDataDir().getAbsolutePath() + "/app_webview" + str + "/webview_data.lock");
        if (file.exists()) {
            try {
                FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
                if (tryLock != null) {
                    tryLock.close();
                } else {
                    createFile(file, file.delete());
                }
            } catch (Exception e) {
                e.printStackTrace();
                boolean z = false;
                if (file.exists()) {
                    z = file.delete();
                }
                createFile(file, z);
            }
        }
    }

    private void uploadExceptionEvent() {
        String eO = BluedPreferences.eO();
        Log.e(TAG, "uncaughtException: " + eO);
        if (TextUtils.isEmpty(eO)) {
            return;
        }
        BluedStatistics.c().a("uncaughtException", 0L, 0, eO);
        BluedPreferences.ap("");
    }

    @Override // com.tencent.tinker.entry.DefaultApplicationLike, com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle
    public void onBaseContextAttached(Context context) {
        super.onBaseContextAttached(context);
        MultiDex.install(context);
        TinkerManager.a(this);
        TinkerManager.b();
        TinkerManager.a(true);
        TinkerInstaller.setLogIml(new MyLogImp());
        TinkerManager.b(this);
        this.tinker = Tinker.with(getApplication());
        new BluedTinkerReport().a(new BluedTinkerReport.Reporter() { // from class: com.soft.blued.app.BluedApplicationLike.1
            @Override // com.soft.blued.tinker.reporter.BluedTinkerReport.Reporter
            public void a(int i) {
                Logger.b("PTH", "key:", Integer.valueOf(i));
            }

            @Override // com.soft.blued.tinker.reporter.BluedTinkerReport.Reporter
            public void a(String str) {
                Logger.b("PTH", "message:", str);
            }
        });
        handleWebViewDir(getApplication());
    }

    @Override // com.tencent.tinker.entry.DefaultApplicationLike, com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle
    public void onCreate() {
        super.onCreate();
        DurationUtils.a();
        Tinker tinker = this.tinker;
        if (tinker != null && tinker.isPatchProcess()) {
            Log.i("PTH", "isPatchProcess");
        } else if (isPushProcess(getApplication())) {
            Log.i("PTH", "isPushProcess");
        } else if (isGetuiPushProcess(getApplication())) {
            Log.i("PTH", "isGetuiPushProcess");
            PushManager.a().b(getApplication());
        } else if (!isMainApplication(getApplication())) {
            Log.i("PTH", "Process:" + getProcessName(getApplication()));
        } else {
            Log.i("PTH", "isMainProcess");
            initMMKV(getApplication());
            initSkinSdk(getApplication());
            initAppGlobal(getApplication());
            initReceiver();
            initLiveRoomCallBack();
            initYYRoomCallBack();
            initSobotSdk();
            uploadExceptionEvent();
            SVGAParser.f15958a.b().a(getApplication());
            try {
                InitTaskManager.a().a(getApplication(), GOTO_FIRST_ACTIVITY_CLASSES, (InitTaskManager.OnTaskListBuilder) Class.forName("com.soft.blued.app.InitTaskUtil").getMethod("generateTaskListBuilder", new Class[0]).invoke(null, new Object[0]));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
            if (Build.VERSION.SDK_INT == 28 || Build.VERSION.SDK_INT == 29) {
                HookActivityManager.a();
            }
            setDeadSystemInstrumentation();
        }
    }

    @Override // com.tencent.tinker.entry.DefaultApplicationLike, com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoader.b();
        if (AppInfo.c()) {
            MemoryRequest.a().b();
        }
    }

    @Override // com.tencent.tinker.entry.DefaultApplicationLike, com.tencent.tinker.entry.ApplicationLike, com.tencent.tinker.entry.ApplicationLifeCycle
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        ImageLoader.a(i);
        if (AppInfo.c()) {
            MemoryRequest.a().a(i);
        }
    }

    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        getApplication().registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void setDataDirectorySuffix() {
        if (Build.VERSION.SDK_INT >= 28) {
            String processNameForWeb = getProcessNameForWeb(getApplication());
            if (getApplication().getPackageName().equals(processNameForWeb)) {
                return;
            }
            WebView.setDataDirectorySuffix(processNameForWeb);
        }
    }
}
