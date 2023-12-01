package com.tencent.thumbplayer.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.a.b.a;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.c.b;
import com.tencent.thumbplayer.c.i;
import com.tencent.thumbplayer.common.a.c;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.common.ITPNativeLibraryExternalLoader;
import com.tencent.thumbplayer.core.common.ITPNativeLogCallback;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPProxyAdapter;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.d;
import com.tencent.thumbplayer.utils.f;
import com.tencent.thumbplayer.utils.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerMgr.class */
public class TPPlayerMgr {
    public static final String BEACON_LOG_HOST_KEY = "beacon_log_host";
    public static final String BEACON_POLICY_HOST_KEY = "beacon_policy_host";
    public static final int EVENT_ID_APP_ENTER_BACKGROUND = 100001;
    public static final int EVENT_ID_APP_ENTER_FOREGROUND = 100002;
    public static final int INVALID_SUGGEST_BITRATE = -1;
    public static final String PLYAER_HOST_KEY = "player_host_config";
    public static final String PROPERTY_AB_USER_ID = "PROPERTY_AbUserId";
    public static final String PROPERTY_ENABLE_DATA_REPORT = "PROPERTY_EnableDataReport";
    public static final String PROPERTY_ENABLE_NEW_REPORT = "PROPERTY_EnableNewReport";
    public static final String PROPERTY_ENABLE_PLAYER_REPORT = "PROPERTY_EnablePlayerReport";
    public static final String PROPERTY_MEDIA_DRM_REUSE_BEFORE_INIT_SDK = "PROPERTY_MediaDrmReuse";
    public static final String PROPERTY_PROXY_MAX_USE_MEMORY_MB = "PROPERTY_ProxyMaxUseMemoryMB";
    public static final String PROPERTY_VIDEO_MEDIACODEC_CO_EXIST_MAX_CNT = "PROPERTY_VideoMediaCodecCoexistMaxCnt";
    public static final String PROPERTY_WIDEVINE_PROVISIONING_SERVER_URL_BEFORE_INIT_SDK = "PROPERTY_WidevineProvisioningServerUrl";
    public static final String PROXY_HOST_KEY = "httpproxy_config";
    private static final String TAG = "TPThumbPlayer[TPPlayerMgr.java]";
    public static final String TP_DOWNLOAD_PROXY_MODULE_NAME = "DownloadProxy";
    public static final String TP_PLAYERCORE_MODULE_NAME = "TPCore";
    private static Context mAppContext;
    private static final HashMap<String, ITPPropertyHandler<Boolean>> mBooleanPropertyNameToPropertyHandlerTables;
    private static boolean mIsInit;
    private static final HashMap<String, ITPPropertyHandler<String>> mStringPropertyNameToPropertyHandlerTables;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerMgr$BooleanProperty.class */
    public @interface BooleanProperty {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerMgr$EventId.class */
    public @interface EventId {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerMgr$ITPPropertyHandler.class */
    public interface ITPPropertyHandler<T> {
        T getPropertyValue();

        void setPropertyValue(T t);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerMgr$IntegerProperty.class */
    public @interface IntegerProperty {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerMgr$LongProperty.class */
    public @interface LongProperty {
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerMgr$OnLogListener.class */
    public interface OnLogListener {
        int d(String str, String str2);

        int e(String str, String str2);

        int i(String str, String str2);

        int v(String str, String str2);

        int w(String str, String str2);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPPlayerMgr$StringProperty.class */
    public @interface StringProperty {
    }

    static {
        HashMap<String, ITPPropertyHandler<Boolean>> hashMap = new HashMap<>();
        mBooleanPropertyNameToPropertyHandlerTables = hashMap;
        hashMap.put(PROPERTY_MEDIA_DRM_REUSE_BEFORE_INIT_SDK, new ITPPropertyHandler<Boolean>() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final Boolean getPropertyValue() {
                return Boolean.valueOf(TPPlayerConfig.getMediaDrmReuseEnable());
            }

            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final void setPropertyValue(Boolean bool) {
                TPPlayerConfig.setMediaDrmReuseEnable(bool.booleanValue());
            }
        });
        mBooleanPropertyNameToPropertyHandlerTables.put(PROPERTY_ENABLE_DATA_REPORT, new ITPPropertyHandler<Boolean>() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final Boolean getPropertyValue() {
                return Boolean.valueOf(TPPlayerConfig.isDataReportEnable());
            }

            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final void setPropertyValue(Boolean bool) {
                TPLogUtil.i(TPPlayerMgr.TAG, "set data report enable : ".concat(String.valueOf(bool)));
                TPPlayerConfig.setDataReportEnable(bool.booleanValue());
                i.a().a(bool.booleanValue());
            }
        });
        mBooleanPropertyNameToPropertyHandlerTables.put(PROPERTY_ENABLE_PLAYER_REPORT, new ITPPropertyHandler<Boolean>() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final Boolean getPropertyValue() {
                return Boolean.valueOf(TPPlayerConfig.isPlayerReportEnable());
            }

            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final void setPropertyValue(Boolean bool) {
                TPLogUtil.i(TPPlayerMgr.TAG, "set player report enable : ".concat(String.valueOf(bool)));
                TPPlayerConfig.setPlayerReportEnable(bool.booleanValue());
            }
        });
        mBooleanPropertyNameToPropertyHandlerTables.put(PROPERTY_ENABLE_NEW_REPORT, new ITPPropertyHandler<Boolean>() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final Boolean getPropertyValue() {
                return Boolean.valueOf(TPPlayerConfig.getNewReportEnable());
            }

            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final void setPropertyValue(Boolean bool) {
                TPLogUtil.i(TPPlayerMgr.TAG, "set new report enable : ".concat(String.valueOf(bool)));
                TPPlayerConfig.setNewReportEnable(bool.booleanValue());
            }
        });
        HashMap<String, ITPPropertyHandler<String>> hashMap2 = new HashMap<>();
        mStringPropertyNameToPropertyHandlerTables = hashMap2;
        hashMap2.put(PROPERTY_AB_USER_ID, new ITPPropertyHandler<String>() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.10
            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final String getPropertyValue() {
                return TPPlayerConfig.getAbUserId();
            }

            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final void setPropertyValue(String str) {
                TPPlayerConfig.setAbUserId(str);
            }
        });
        mStringPropertyNameToPropertyHandlerTables.put(PROPERTY_WIDEVINE_PROVISIONING_SERVER_URL_BEFORE_INIT_SDK, new ITPPropertyHandler<String>() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.11
            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final String getPropertyValue() {
                return TPPlayerConfig.getWidevineProvisioningServerUrl();
            }

            @Override // com.tencent.thumbplayer.api.TPPlayerMgr.ITPPropertyHandler
            public final void setPropertyValue(String str) {
                TPPlayerConfig.setWidevineProvisioningServerUrl(str);
            }
        });
    }

    private static void dumpStackTrace() {
        TPLogUtil.i(TAG, "Current stack trace: ");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            TPLogUtil.i(TAG, stackTrace[i2].toString());
            i = i2 + 1;
        }
    }

    public static Context getAppContext() {
        return mAppContext;
    }

    public static String getLibVersion(String str) {
        if (mIsInit) {
            if (!TextUtils.isEmpty(str)) {
                if (str.equals(TP_DOWNLOAD_PROXY_MODULE_NAME)) {
                    return TPDownloadProxyHelper.getNativeLibVersion();
                }
                if (str.equals(TP_PLAYERCORE_MODULE_NAME)) {
                    return TPNativeLibraryLoader.getLibVersion();
                }
            }
            throw new IllegalArgumentException("libName:".concat(String.valueOf(str)));
        }
        throw new IllegalStateException("player not initialized");
    }

    public static int getOfflineRecordDurationMs(String str, String str2) {
        return TPDownloadProxyHelper.getRecordDuration(str, str2);
    }

    public static String getOfflineRecordVinfo(String str, String str2) {
        return TPDownloadProxyHelper.checkVideoStatus(str, str2);
    }

    @Deprecated
    public static boolean getPropertyBoolean(String str) {
        return getPropertyBoolean(str, false);
    }

    public static boolean getPropertyBoolean(String str, boolean z) {
        ITPPropertyHandler<Boolean> iTPPropertyHandler = mBooleanPropertyNameToPropertyHandlerTables.get(str);
        return iTPPropertyHandler != null ? iTPPropertyHandler.getPropertyValue().booleanValue() : z;
    }

    @Deprecated
    public static int getPropertyInteger(String str) {
        return getPropertyInteger(str, 0);
    }

    public static int getPropertyInteger(String str, int i) {
        return TextUtils.equals(PROPERTY_VIDEO_MEDIACODEC_CO_EXIST_MAX_CNT, str) ? TPPlayerConfig.getVideoMediaCodecCoexistMaxCnt() : i;
    }

    @Deprecated
    public static long getPropertyLong(String str) {
        return getPropertyLong(str, 0L);
    }

    public static long getPropertyLong(String str, long j) {
        return TextUtils.equals(PROPERTY_PROXY_MAX_USE_MEMORY_MB, str) ? TPPlayerConfig.getProxyMaxUseMemoryMB() : j;
    }

    @Deprecated
    public static String getPropertyString(String str) {
        return getPropertyString(str, "");
    }

    public static String getPropertyString(String str, String str2) {
        ITPPropertyHandler<String> iTPPropertyHandler = mStringPropertyNameToPropertyHandlerTables.get(str);
        return iTPPropertyHandler != null ? iTPPropertyHandler.getPropertyValue() : str2;
    }

    public static int getSuggestedBitrate() {
        ITPDownloadProxy a2;
        b a3 = i.a().a(TPPlayerConfig.getProxyServiceType());
        if (a3 == null || (a2 = a3.a()) == null) {
            return -1;
        }
        return com.tencent.thumbplayer.utils.b.a(a2.getNativeInfo(0), -1);
    }

    public static String getThumbPlayerVersion() {
        return TPPlayerConfig.VERSION;
    }

    private static Future<Boolean> initAsyncWithWait() {
        return o.a().c().submit(new Callable<Boolean>() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public final Boolean call() {
                TPPlayerMgr.initInAsyncThread();
                return Boolean.TRUE;
            }
        });
    }

    private static void initAsyncWithoutWait() {
        o.a().d().execute(new Runnable() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.3
            @Override // java.lang.Runnable
            public final void run() {
                d dVar = new d();
                dVar.a();
                TPNativeKeyMapUtil.init();
                TPLogUtil.i(TPPlayerMgr.TAG, "Init SDK, initAsyncWithoutWait  nativeKeyMap init, times: " + dVar.c());
                com.tencent.thumbplayer.utils.i.a().a(TPPlayerMgr.mAppContext);
                new c().a();
                TPLogUtil.i(TPPlayerMgr.TAG, "Init SDK, initAsyncWithoutWait all times: " + dVar.d());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initInAsyncThread() {
        d dVar = new d();
        dVar.a();
        com.tencent.thumbplayer.common.a.b.a(mAppContext.getApplicationContext());
        TPLogUtil.i(TAG, "Init SDK, initAsyncWithWait  TPBeaconReportWrapper init, times: " + dVar.e());
        a.a(mAppContext);
        TPLogUtil.i(TAG, "Init SDK, initAsyncWithWait  TPDrmCapability init, times: " + dVar.e());
        TPThumbplayerCapabilityHelper.init(mAppContext, true);
        TPLogUtil.i(TAG, "Init SDK, initAsyncWithWait  TPThumbplayerCapabilityHelper init, times: " + dVar.e());
        try {
            TPNativePlayer.playerCoreNativeSetup(mAppContext);
        } catch (UnsupportedOperationException e) {
            TPLogUtil.e(TAG, e);
        }
        TPLogUtil.i(TAG, "Init SDK, initAsyncWithWait all times: " + dVar.d());
    }

    public static void initSdk(Context context, TPInitParams tPInitParams) {
        TPSystemInfo.setDeviceName(tPInitParams.getDeviceName());
        initSdk(context, tPInitParams.getGuid(), tPInitParams.getPlatform());
    }

    public static void initSdk(Context context, String str, int i) {
        StringBuilder sb;
        String str2;
        dumpStackTrace();
        if (mIsInit) {
            str2 = "Init SDK, has init sdk";
        } else {
            mIsInit = true;
            d dVar = new d();
            dVar.a();
            preInitSync(context, str, i);
            Future<Boolean> initAsyncWithWait = initAsyncWithWait();
            initSync();
            initAsyncWithoutWait();
            dVar.b();
            try {
                if (initAsyncWithWait.get().booleanValue()) {
                    TPLogUtil.i(TAG, "Init SDK, TPPlayer  wait initSync finish, times: " + dVar.c());
                }
            } catch (InterruptedException e) {
                sb = new StringBuilder("Init SDK, TPPlayer wait initSync InterruptedException, times: ");
                sb.append(dVar.c());
                TPLogUtil.e(TAG, sb.toString());
                str2 = "Init SDK, TPPlayer all times: " + dVar.d();
                TPLogUtil.i(TAG, str2);
            } catch (ExecutionException e2) {
                sb = new StringBuilder("Init SDK, TPPlayer wait initSync ExecutionException, times: ");
                sb.append(dVar.c());
                TPLogUtil.e(TAG, sb.toString());
                str2 = "Init SDK, TPPlayer all times: " + dVar.d();
                TPLogUtil.i(TAG, str2);
            }
            str2 = "Init SDK, TPPlayer all times: " + dVar.d();
        }
        TPLogUtil.i(TAG, str2);
    }

    private static void initSync() {
        d dVar = new d();
        dVar.a();
        try {
            TPNativeLibraryLoader.loadLibIfNeeded(mAppContext);
        } catch (UnsupportedOperationException e) {
            TPLogUtil.e(TAG, e);
        }
        TPLogUtil.i(TAG, "Init SDK, initSync so load times: " + dVar.d());
    }

    public static boolean isProxyEnable() {
        return TPPlayerConfig.isUseP2P() && TPDownloadProxyHelper.isReadyForPlay();
    }

    public static boolean isThumbPlayerEnable() {
        return TPNativeLibraryLoader.isLibLoaded();
    }

    public static void postEvent(int i, int i2, int i3, Object obj) {
        f.a(i, i2, i3, obj);
    }

    private static void preInitSync(Context context, String str, int i) {
        d dVar = new d();
        dVar.a();
        mAppContext = context.getApplicationContext();
        TPPlayerConfig.setGuid(str);
        TPPlayerConfig.setPlatform(i);
        TPNativeLog.setLogCallback(new ITPNativeLogCallback() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.1
            @Override // com.tencent.thumbplayer.core.common.ITPNativeLogCallback
            public final void onPrintLog(int i2, String str2, String str3) {
                if (i2 == 0) {
                    TPLogUtil.v(str2, str3);
                } else if (i2 == 1) {
                    TPLogUtil.d(str2, str3);
                } else if (i2 == 2) {
                    TPLogUtil.i(str2, str3);
                } else if (i2 == 3) {
                    TPLogUtil.w(str2, str3);
                } else if (i2 != 4) {
                } else {
                    TPLogUtil.e(str2, str3);
                }
            }
        });
        TPLogUtil.i(TAG, "Init SDK, preInitSync all times: " + dVar.d());
    }

    public static void setDebugEnable(boolean z) {
        TPPlayerConfig.setDebugEnable(z);
    }

    public static void setHost(String str) {
        TPPlayerConfig.parseHostConfig(str);
    }

    public static void setLibLoader(final ITPModuleLoader iTPModuleLoader) {
        if (mIsInit) {
            throw new IllegalStateException("player has init");
        }
        TPNativeLibraryLoader.setLibLoader(new ITPNativeLibraryExternalLoader() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.4
            @Override // com.tencent.thumbplayer.core.common.ITPNativeLibraryExternalLoader
            public final boolean loadLib(String str, String str2) {
                ITPModuleLoader iTPModuleLoader2 = ITPModuleLoader.this;
                if (iTPModuleLoader2 != null) {
                    try {
                        iTPModuleLoader2.loadLibrary(str, str2);
                        return true;
                    } catch (Throwable th) {
                        TPLogUtil.e(TPPlayerMgr.TAG, th);
                        return false;
                    }
                }
                return false;
            }
        });
        TPDownloadProxyHelper.setNativeLibLoader(new ITPDLProxyNativeLibLoader() { // from class: com.tencent.thumbplayer.api.TPPlayerMgr.5
            @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader
            public final boolean loadLib(String str, String str2) {
                ITPModuleLoader iTPModuleLoader2 = ITPModuleLoader.this;
                if (iTPModuleLoader2 != null) {
                    try {
                        iTPModuleLoader2.loadLibrary(str, str2);
                        return true;
                    } catch (Throwable th) {
                        TPLogUtil.e(TPPlayerMgr.TAG, th);
                        return false;
                    }
                }
                return false;
            }
        });
    }

    public static void setOnLogListener(OnLogListener onLogListener) {
        TPLogUtil.setOnLogListener(onLogListener);
    }

    public static void setOutNetIP(String str) {
        TPPlayerConfig.setOutNetIp(str);
    }

    public static void setPropertyBool(String str, boolean z) {
        ITPPropertyHandler<Boolean> iTPPropertyHandler = mBooleanPropertyNameToPropertyHandlerTables.get(str);
        if (iTPPropertyHandler != null) {
            iTPPropertyHandler.setPropertyValue(Boolean.valueOf(z));
        }
    }

    public static void setPropertyInteger(String str, int i) {
        if (TextUtils.equals(PROPERTY_VIDEO_MEDIACODEC_CO_EXIST_MAX_CNT, str)) {
            TPPlayerConfig.setVideoMediaCodecCoexistMaxCnt(i);
        }
    }

    public static void setPropertyLong(String str, long j) {
        if (TextUtils.equals(PROPERTY_PROXY_MAX_USE_MEMORY_MB, str)) {
            TPPlayerConfig.setProxyMaxUseMemoryMB(j);
            i.a().b(j);
        }
    }

    public static void setPropertyString(String str, String str2) {
        ITPPropertyHandler<String> iTPPropertyHandler = mStringPropertyNameToPropertyHandlerTables.get(str);
        if (iTPPropertyHandler != null) {
            iTPPropertyHandler.setPropertyValue(str2);
        }
    }

    public static void setProxyEnable(boolean z) {
        TPPlayerConfig.setP2PEnable(z);
    }

    public static void setProxyMaxStorageSizeMB(long j) {
        TPLogUtil.i(TAG, "setProxyMaxStorageSize: " + j + " MB.");
        TPPlayerConfig.setProxyMaxStorageSizeMB(j);
        i.a().a(j);
    }

    public static void setProxyServiceType(int i) {
        TPPlayerConfig.setProxyServiceType(i);
    }

    public static void setTPProxyAdapter(ITPProxyAdapter iTPProxyAdapter) {
        TPDownloadProxyHelper.setTPProxyAdapter(iTPProxyAdapter);
    }

    public static void setUpcInfo(String str, int i) {
        TPPlayerConfig.setUserUpc(str);
        TPPlayerConfig.setUserUpcState(i);
        f.a(100003, i, 0, str);
    }

    public static void setUserInfo(String str, boolean z) {
        TPPlayerConfig.setUserUin(str);
        TPPlayerConfig.setUserIsVip(z);
    }
}
