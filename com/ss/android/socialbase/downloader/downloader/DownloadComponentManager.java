package com.ss.android.socialbase.downloader.downloader;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.impls.DefaultChunkCntCalculator;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.DefaultIdGenerator;
import com.ss.android.socialbase.downloader.impls.DefaultRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/DownloadComponentManager.class */
public class DownloadComponentManager {
    public static final int NET_LIB_DEFAULT = 0;
    public static final int NET_LIB_HOST = 1;
    private static volatile Context appContext;
    private static volatile IChunkAdjustCalculator chunkAdjustCalculator;
    private static volatile IChunkCntCalculator chunkCntCalculator;
    private static volatile ExecutorService chunkDownloadExecutor;
    private static volatile ExecutorService cpuThreadExecutor;
    private static volatile ExecutorService dbThreadExecutor;
    private static volatile IDownloadDns defaultDownloadDns;
    private static volatile IDownloadHeadHttpService defaultHeadHttpService;
    private static volatile IDownloadHttpService defaultHttpService;
    private static volatile IDownloadCache downloadCache;
    private static final List<IDownloadCacheSyncStatusListener> downloadCacheSyncStatusListeners;
    private static volatile IDownloadDns downloadDns;
    private static volatile AbsDownloadEngine downloadEngine;
    private static InnerEventListener downloadEventListener;
    private static int downloadExpSwitchCode;
    private static volatile IDownloadLaunchHandler downloadLaunchHandler;
    private static volatile IDownloadMonitorListener downloadMonitorListener;
    private static volatile DownloadReceiver downloadReceiver;
    private static volatile IDownloadServiceHandler downloadServiceHandler;
    private static volatile IDownloadSettings downloadSettings;
    private static final List<IDownloadTaskExecuteListener> downloadTaskExecuteListeners;
    private static final int fixedDBPoolSize;
    private static final int fixedMIXPoolSize;
    private static volatile boolean hasInit;
    private static volatile IDownloadHeadHttpService headHttpService;
    private static volatile IDownloadHttpService httpService;
    private static boolean httpServiceInit;
    private static volatile ITTNetHandler iTTNetHandler;
    private static volatile IDownloadIdGenerator idGenerator;
    private static volatile IDownloadServiceHandler independentDownloadServiceHandler;
    private static volatile IndependentHolderCreator independentHolderCreator;
    private static volatile ExecutorService ioThreadExecutor;
    private static int maxDownloadPoolSize;
    private static volatile ExecutorService mixApkDownloadExecutor;
    private static volatile ExecutorService mixDefaultDownloadExecutor;
    private static volatile ExecutorService mixFrequentDownloadExecutor;
    private static volatile IMonitorConfig monitorConfig;
    private static boolean needAutoRefreshUnSuccessTask;
    private static boolean notAutoRebootService;
    private static volatile INotificationClickCallback notificationClickCallback;
    private static volatile ExecutorService okHttpDispatcherExecutor;
    private static IReserveWifiStatusListener reserveWifiStatusListener;
    private static volatile IRetryDelayTimeCalculator retryDelayTimeCalculator;
    private static int writeBufferSize;
    private static volatile List<ProcessCallback> processCallbacks = new ArrayList();
    private static volatile boolean downloadInMultiProcess = false;
    private static volatile OkHttpClient sOkHttpClient = null;
    private static final List<IDownloadCompleteHandler> downloadCompleteHandlers = new ArrayList();
    private static boolean isReceiverRegistered = false;
    private static final int fixedCPUPoolSize = Runtime.getRuntime().availableProcessors() + 1;
    private static final int fixedIOPoolSize = (Runtime.getRuntime().availableProcessors() * 2) + 1;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/DownloadComponentManager$IndependentHolderCreator.class */
    public interface IndependentHolderCreator {

        /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener.class */
        public interface OnMainProcessRebindErrorListener {
            void onRebindError();
        }

        ISqlDownloadCache createCache(OnMainProcessRebindErrorListener onMainProcessRebindErrorListener);

        IDownloadProxy createProxy();

        IDownloadServiceHandler createServiceHandler();
    }

    static {
        int i = fixedCPUPoolSize;
        fixedMIXPoolSize = i;
        fixedDBPoolSize = i;
        writeBufferSize = 8192;
        downloadCacheSyncStatusListeners = new ArrayList();
        downloadTaskExecuteListeners = new ArrayList();
        needAutoRefreshUnSuccessTask = true;
        notAutoRebootService = false;
        hasInit = false;
    }

    private DownloadComponentManager() {
    }

    public static void addDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (downloadCompleteHandlers) {
            if (iDownloadCompleteHandler != null) {
                if (!downloadCompleteHandlers.contains(iDownloadCompleteHandler)) {
                    downloadCompleteHandlers.add(iDownloadCompleteHandler);
                }
            }
        }
    }

    public static void addProcessCallback(ProcessCallback processCallback) {
        if (processCallback == null) {
            return;
        }
        synchronized (processCallbacks) {
            processCallbacks.add(processCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void coverComponent(DownloaderBuilder downloaderBuilder) {
        synchronized (DownloadComponentManager.class) {
            try {
                setDownloadBuilder(downloaderBuilder);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static OkHttpClient.Builder createDownloadClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (okHttpDispatcherExecutor != null) {
            builder.dispatcher(new Dispatcher(okHttpDispatcherExecutor));
        }
        return builder;
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean z, int i, String str, String str2, List<HttpHeader> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        IDownloadHttpConnection downloadWithConnection2;
        if (!TextUtils.isEmpty(str2)) {
            if (list == null) {
                list = new ArrayList();
            }
            list.add(new HttpHeader(DownloadConstants.EXTRA_REQUEST_HOST_IP, str2));
            i2 = 1;
        } else if (!z) {
            i2 = 2;
        }
        int[] downloadNetLibs = getDownloadNetLibs(i2);
        int length = downloadNetLibs.length;
        Exception e = null;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                if (e == null) {
                    return null;
                }
                throw e;
            }
            try {
                downloadWithConnection2 = downloadWithConnection2(i, str, str2, list, downloadNetLibs[i4], z2, downloadInfo);
            } catch (Exception e2) {
                e = e2;
                if (!downloadInfo.isExpiredRedownload()) {
                    continue;
                } else if (!DownloadUtils.isResponseCode304Error(e)) {
                    continue;
                } else if (DownloadUtils.hasDownloadCacheHeader(list)) {
                    Logger.d("dcach::http exception 304, throw excepiton, not retry " + e);
                    throw e;
                }
            }
            if (downloadWithConnection2 != null) {
                return downloadWithConnection2;
            }
            i3 = i4 + 1;
        }
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean z, int i, String str, List<HttpHeader> list) throws Exception {
        return downloadWithConnection(z, i, str, null, list, 0, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection2(int r10, java.lang.String r11, java.lang.String r12, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> r13, int r14, boolean r15, com.ss.android.socialbase.downloader.model.DownloadInfo r16) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r0 = r14
            r1 = 1
            if (r0 != r1) goto Le
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = getHttpService()
            r21 = r0
            goto L13
        Le:
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = getDefaultHttpService()
            r21 = r0
        L13:
            r0 = r21
            if (r0 == 0) goto L98
            r0 = 0
            r22 = r0
            r0 = 0
            r19 = r0
            r0 = r19
            r17 = r0
            r0 = r15
            if (r0 == 0) goto L43
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L3b
            r17 = r0
            goto L43
        L2f:
            r13 = move-exception
            r0 = r19
            r17 = r0
            r0 = r22
            r21 = r0
            goto L7c
        L3b:
            r13 = move-exception
            r0 = r19
            r17 = r0
            goto L72
        L43:
            r0 = r21
            r1 = r10
            r2 = r11
            r3 = r13
            com.ss.android.socialbase.downloader.network.IDownloadHttpConnection r0 = r0.downloadWithConnection(r1, r2, r3)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L71
            r13 = r0
            r0 = r15
            if (r0 == 0) goto L67
            r0 = r13
            r1 = r11
            r2 = r12
            long r3 = java.lang.System.currentTimeMillis()
            r4 = r17
            long r3 = r3 - r4
            java.lang.String r4 = "get"
            r5 = r14
            r6 = 0
            r7 = r16
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(r0, r1, r2, r3, r4, r5, r6, r7)
        L67:
            r0 = r13
            return r0
        L69:
            r13 = move-exception
            r0 = r22
            r21 = r0
            goto L7c
        L71:
            r13 = move-exception
        L72:
            r0 = r13
            throw r0     // Catch: java.lang.Throwable -> L74
        L74:
            r22 = move-exception
            r0 = r13
            r21 = r0
            r0 = r22
            r13 = r0
        L7c:
            r0 = r15
            if (r0 == 0) goto L96
            r0 = 0
            r1 = r11
            r2 = r12
            long r3 = java.lang.System.currentTimeMillis()
            r4 = r17
            long r3 = r3 - r4
            java.lang.String r4 = "get"
            r5 = r14
            r6 = r21
            r7 = r16
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(r0, r1, r2, r3, r4, r5, r6, r7)
        L96:
            r0 = r13
            throw r0
        L98:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = r11
            java.lang.String r1 = "httpService not exist, netLib = "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r11
            r1 = r14
            java.lang.StringBuilder r0 = r0.append(r1)
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = r0
            r2 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r3 = new java.io.IOException
            r4 = r3
            r5 = r11
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            r1.<init>(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithConnection2(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.IDownloadHttpConnection");
    }

    public static IDownloadHeadHttpConnection downloadWithHeadConnection(String str, List<HttpHeader> list) throws Exception {
        return downloadWithHeadConnection(str, list, 0, false, null);
    }

    public static IDownloadHeadHttpConnection downloadWithHeadConnection(String str, List<HttpHeader> list, int i, boolean z, DownloadInfo downloadInfo) throws Exception {
        IDownloadHeadHttpConnection downloadWithHeadConnection2;
        int[] downloadNetLibs = getDownloadNetLibs(i);
        Exception e = null;
        for (int i2 : downloadNetLibs) {
            try {
                downloadWithHeadConnection2 = downloadWithHeadConnection2(str, list, i2, z, downloadInfo);
            } catch (Exception e2) {
                e = e2;
            }
            if (downloadWithHeadConnection2 != null) {
                return downloadWithHeadConnection2;
            }
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection downloadWithHeadConnection2(java.lang.String r10, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> r11, int r12, boolean r13, com.ss.android.socialbase.downloader.model.DownloadInfo r14) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r0 = r12
            r1 = 1
            if (r0 != r1) goto Ld
            com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService r0 = getHeadHttpService()
            r21 = r0
            goto L12
        Ld:
            com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService r0 = getDefaultHeadHttpService()
            r21 = r0
        L12:
            r0 = r21
            if (r0 == 0) goto L80
            r0 = 0
            r19 = r0
            r0 = r19
            r15 = r0
            r0 = r13
            if (r0 == 0) goto L2b
            r0 = r19
            r17 = r0
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L5d
            r15 = r0
        L2b:
            r0 = r15
            r17 = r0
            r0 = r15
            r19 = r0
            r0 = r21
            r1 = r10
            r2 = r11
            com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection r0 = r0.downloadWithConnection(r1, r2)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L5d
            r11 = r0
            r0 = r13
            if (r0 == 0) goto L54
            r0 = r11
            r1 = r10
            r2 = 0
            long r3 = java.lang.System.currentTimeMillis()
            r4 = r15
            long r3 = r3 - r4
            java.lang.String r4 = "head"
            r5 = r12
            r6 = 0
            r7 = r14
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(r0, r1, r2, r3, r4, r5, r6, r7)
        L54:
            r0 = r11
            return r0
        L56:
            r21 = move-exception
            r0 = 0
            r11 = r0
            goto L66
        L5d:
            r11 = move-exception
            r0 = r11
            throw r0     // Catch: java.lang.Throwable -> L60
        L60:
            r21 = move-exception
            r0 = r19
            r17 = r0
        L66:
            r0 = r13
            if (r0 == 0) goto L7d
            r0 = 0
            r1 = r10
            r2 = 0
            long r3 = java.lang.System.currentTimeMillis()
            r4 = r17
            long r3 = r3 - r4
            java.lang.String r4 = "head"
            r5 = r12
            r6 = r11
            r7 = r14
            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadConnect(r0, r1, r2, r3, r4, r5, r6, r7)
        L7d:
            r0 = r21
            throw r0
        L80:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            java.lang.String r1 = "httpService not exist, netLib = "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r12
            java.lang.StringBuilder r0 = r0.append(r1)
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = r0
            r2 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r3 = new java.io.IOException
            r4 = r3
            r5 = r10
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            r1.<init>(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithHeadConnection2(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection");
    }

    public static void ensureOPPO() {
        if (TextUtils.isEmpty(DownloadConstants.LOWER_OPPO)) {
            DownloadConstants.LOWER_OPPO = AssistUtils.BRAND_OPPO;
            DownloadConstants.UPPER_OPPO = DownloadConstants.LOWER_OPPO.toUpperCase();
        }
    }

    public static AlarmManager getAlarmManager() {
        return null;
    }

    public static Context getAppContext() {
        Context context;
        synchronized (DownloadComponentManager.class) {
            try {
                context = appContext;
            } catch (Throwable th) {
                throw th;
            }
        }
        return context;
    }

    public static ExecutorService getCPUThreadExecutor() {
        if (cpuThreadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (cpuThreadExecutor == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(fixedCPUPoolSize, fixedCPUPoolSize, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-cpu-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        cpuThreadExecutor = threadPoolExecutor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return cpuThreadExecutor;
    }

    public static IChunkAdjustCalculator getChunkAdjustCalculator() {
        if (chunkAdjustCalculator == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (chunkAdjustCalculator == null) {
                        chunkAdjustCalculator = new DefaultChunkAdjustCalculator();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return chunkAdjustCalculator;
    }

    public static IChunkCntCalculator getChunkCntCalculator() {
        if (chunkCntCalculator == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (chunkCntCalculator == null) {
                        chunkCntCalculator = new DefaultChunkCntCalculator();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return chunkCntCalculator;
    }

    public static ExecutorService getChunkDownloadThreadExecutorService() {
        if (chunkDownloadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (chunkDownloadExecutor == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(fixedIOPoolSize, fixedIOPoolSize, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-chunk-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        chunkDownloadExecutor = threadPoolExecutor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return chunkDownloadExecutor;
    }

    public static ExecutorService getDBThreadExecutorService() {
        if (dbThreadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (dbThreadExecutor == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(fixedDBPoolSize, fixedDBPoolSize, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-db-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        dbThreadExecutor = threadPoolExecutor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return dbThreadExecutor;
    }

    public static IDownloadDns getDefaultDownloadDns() {
        if (defaultDownloadDns == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (defaultDownloadDns == null) {
                        defaultDownloadDns = new IDownloadDns() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.2
                            @Override // com.ss.android.socialbase.downloader.network.IDownloadDns
                            public List<InetAddress> lookup(String str) throws UnknownHostException {
                                return Dns.SYSTEM.lookup(str);
                            }
                        };
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return defaultDownloadDns;
    }

    public static IDownloadHeadHttpService getDefaultHeadHttpService() {
        if (defaultHeadHttpService == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (defaultHeadHttpService == null) {
                        defaultHeadHttpService = new DefaultDownloadHeadHttpService();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return defaultHeadHttpService;
    }

    public static IDownloadHttpService getDefaultHttpService() {
        if (defaultHttpService == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (defaultHttpService == null) {
                        defaultHttpService = new DefaultDownloadHttpService();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return defaultHttpService;
    }

    public static IDownloadCache getDownloadCache() {
        if (downloadCache == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (downloadCache == null) {
                        downloadCache = new DefaultDownloadCache();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return downloadCache;
    }

    public static OkHttpClient getDownloadClient() {
        if (sOkHttpClient == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (sOkHttpClient == null) {
                        sOkHttpClient = createDownloadClientBuilder().build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sOkHttpClient;
    }

    public static List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return downloadCompleteHandlers;
    }

    public static IDownloadDns getDownloadDns() {
        return downloadDns;
    }

    public static AbsDownloadEngine getDownloadEngine() {
        if (downloadEngine == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (downloadEngine == null) {
                        downloadEngine = new DefaultDownloadEngine();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return downloadEngine;
    }

    public static int getDownloadExpSwitchCode() {
        return downloadExpSwitchCode;
    }

    public static int getDownloadId(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        return getDownloadId(downloadInfo.getUrl(), downloadInfo.getSavePath());
    }

    public static int getDownloadId(String str, String str2) {
        IDownloadIdGenerator idGenerator2 = getIdGenerator();
        if (idGenerator2 == null) {
            return 0;
        }
        return idGenerator2.generate(str, str2);
    }

    public static IDownloadLaunchHandler getDownloadLaunchHandler() {
        IDownloadLaunchHandler iDownloadLaunchHandler;
        synchronized (DownloadComponentManager.class) {
            try {
                iDownloadLaunchHandler = downloadLaunchHandler;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iDownloadLaunchHandler;
    }

    public static IDownloadMonitorListener getDownloadMonitorListener() {
        return downloadMonitorListener;
    }

    private static int[] getDownloadNetLibs(int i) {
        return i != 1 ? i != 2 ? i != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    public static IDownloadServiceHandler getDownloadServiceHandler() {
        if (downloadServiceHandler == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (downloadServiceHandler == null) {
                        downloadServiceHandler = new DefaultDownloadServiceHandler();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return downloadServiceHandler;
    }

    public static JSONObject getDownloadSetting() {
        return (downloadSettings == null || downloadSettings.get() == null) ? DownloadConstants.EMPTY_JSON : downloadSettings.get();
    }

    public static InnerEventListener getEventListener() {
        if (downloadEventListener == null) {
            downloadEventListener = new InnerEventListener() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.3
                @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
                public void onEvent(int i, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
                public void onUnityEvent(int i, String str, JSONObject jSONObject) {
                }
            };
        }
        return downloadEventListener;
    }

    public static IDownloadHeadHttpService getHeadHttpService() {
        return headHttpService;
    }

    public static IDownloadHttpService getHttpService() {
        return httpService;
    }

    public static ExecutorService getIOThreadExecutor() {
        return ioThreadExecutor != null ? ioThreadExecutor : getCPUThreadExecutor();
    }

    public static IDownloadIdGenerator getIdGenerator() {
        if (idGenerator == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (idGenerator == null) {
                        idGenerator = new DefaultIdGenerator();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return idGenerator;
    }

    public static IDownloadServiceHandler getIndependentDownloadServiceHandler() {
        if (independentDownloadServiceHandler == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (independentDownloadServiceHandler == null) {
                        independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return independentDownloadServiceHandler;
    }

    public static IndependentHolderCreator getIndependentHolderCreator() {
        return independentHolderCreator;
    }

    private static int getMaxDownloadPoolSize() {
        int i = maxDownloadPoolSize;
        if (i <= 0 || i > fixedCPUPoolSize) {
            maxDownloadPoolSize = fixedCPUPoolSize;
        }
        return maxDownloadPoolSize;
    }

    public static ExecutorService getMixApkThreadExecutor() {
        return mixApkDownloadExecutor != null ? mixApkDownloadExecutor : getMixDefaultThreadExecutor();
    }

    public static ExecutorService getMixDefaultThreadExecutor() {
        if (mixDefaultDownloadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (mixDefaultDownloadExecutor == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(fixedMIXPoolSize, fixedMIXPoolSize, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-mix-fixed", true));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        mixDefaultDownloadExecutor = threadPoolExecutor;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mixDefaultDownloadExecutor;
    }

    public static ExecutorService getMixFrequentThreadExecutor() {
        return mixFrequentDownloadExecutor != null ? mixFrequentDownloadExecutor : getMixDefaultThreadExecutor();
    }

    public static IMonitorConfig getMonitorConfig() {
        IMonitorConfig iMonitorConfig;
        synchronized (DownloadComponentManager.class) {
            try {
                iMonitorConfig = monitorConfig;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iMonitorConfig;
    }

    public static INotificationClickCallback getNotificationClickCallback() {
        return notificationClickCallback;
    }

    public static List<ProcessCallback> getProcessCallbacks() {
        List<ProcessCallback> list;
        synchronized (processCallbacks) {
            list = processCallbacks;
        }
        return list;
    }

    public static IReserveWifiStatusListener getReserveWifiStatusListener() {
        return reserveWifiStatusListener;
    }

    public static IRetryDelayTimeCalculator getRetryDelayTimeCalculator() {
        if (retryDelayTimeCalculator == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (retryDelayTimeCalculator == null) {
                        retryDelayTimeCalculator = new DefaultRetryDelayTimeCalculator();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return retryDelayTimeCalculator;
    }

    public static ITTNetHandler getTTNetHandler() {
        if (iTTNetHandler == null) {
            synchronized (DownloadComponentManager.class) {
                try {
                    if (iTTNetHandler == null) {
                        iTTNetHandler = new ITTNetHandler.DefaultTTNetHandler();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return iTTNetHandler;
    }

    public static int getWriteBufferSize() {
        int i;
        synchronized (DownloadComponentManager.class) {
            try {
                i = writeBufferSize;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initComponent(DownloaderBuilder downloaderBuilder) {
        synchronized (DownloadComponentManager.class) {
            try {
                if (hasInit) {
                    Logger.e("DownloadComponentManager", "component has init");
                    return;
                }
                boolean z = downloadInMultiProcess;
                setDownloadBuilder(downloaderBuilder);
                if (downloadCache == null) {
                    downloadCache = new DefaultDownloadCache();
                }
                if (downloadServiceHandler == null) {
                    downloadServiceHandler = new DefaultDownloadServiceHandler();
                }
                if (independentDownloadServiceHandler == null && independentHolderCreator != null) {
                    independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();
                }
                if (idGenerator == null) {
                    idGenerator = new DefaultIdGenerator();
                }
                if (downloadEngine == null) {
                    downloadEngine = new DefaultDownloadEngine();
                }
                if (chunkCntCalculator == null) {
                    chunkCntCalculator = new DefaultChunkCntCalculator();
                }
                if (chunkAdjustCalculator == null) {
                    chunkAdjustCalculator = new DefaultChunkAdjustCalculator();
                }
                if (retryDelayTimeCalculator == null) {
                    retryDelayTimeCalculator = new DefaultRetryDelayTimeCalculator();
                }
                if (maxDownloadPoolSize <= 0 || maxDownloadPoolSize > fixedCPUPoolSize) {
                    maxDownloadPoolSize = fixedCPUPoolSize;
                }
                registerDownloadReceiver();
                if (downloadInMultiProcess && !z && !DownloadUtils.isDownloaderProcess()) {
                    DownloadProxy.get(true).startService();
                } else if (DownloadUtils.isMainThread()) {
                    ExecutorService iOThreadExecutor = getIOThreadExecutor();
                    if (iOThreadExecutor != null) {
                        iOThreadExecutor.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Context appContext2 = DownloadComponentManager.getAppContext();
                                if (appContext2 != null) {
                                    DownloadUtils.getCurProcessName(appContext2);
                                }
                            }
                        });
                    }
                } else {
                    Context appContext2 = getAppContext();
                    if (appContext2 != null) {
                        DownloadUtils.getCurProcessName(appContext2);
                    }
                }
                ensureOPPO();
                hasInit = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isDownloadInMultiProcess() {
        boolean z;
        synchronized (DownloadComponentManager.class) {
            try {
                z = downloadInMultiProcess;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static boolean isHttpServiceInit() {
        boolean z;
        synchronized (DownloadComponentManager.class) {
            try {
                z = httpServiceInit;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static boolean isInit() {
        return hasInit;
    }

    private static void needAutoRefreshUnSuccessTask(boolean z) {
        needAutoRefreshUnSuccessTask = z;
    }

    public static boolean needAutoRefreshUnSuccessTask() {
        return needAutoRefreshUnSuccessTask;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static boolean notAutoRebootService() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e0expr(TypeTransformer.java:441)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:710)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void onDownloadCacheSyncCallback(DownloadCacheSyncStatus downloadCacheSyncStatus) {
        synchronized (downloadCacheSyncStatusListeners) {
            for (IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener : downloadCacheSyncStatusListeners) {
                if (iDownloadCacheSyncStatusListener != null) {
                    if (downloadCacheSyncStatus == DownloadCacheSyncStatus.SYNC_START) {
                        iDownloadCacheSyncStatusListener.onStart();
                    } else if (downloadCacheSyncStatus == DownloadCacheSyncStatus.SYNC_SUCCESS) {
                        iDownloadCacheSyncStatusListener.onSuccess();
                    }
                }
            }
            if (downloadCacheSyncStatus == DownloadCacheSyncStatus.SYNC_SUCCESS) {
                downloadCacheSyncStatusListeners.clear();
            }
        }
    }

    public static void onDownloadTaskFinish(DownloadTask downloadTask, int i) {
        synchronized (downloadTaskExecuteListeners) {
            for (IDownloadTaskExecuteListener iDownloadTaskExecuteListener : downloadTaskExecuteListeners) {
                if (iDownloadTaskExecuteListener != null) {
                    iDownloadTaskExecuteListener.onFinish(downloadTask, i);
                }
            }
        }
    }

    public static void onDownloadTaskStart(DownloadTask downloadTask, int i) {
        synchronized (downloadTaskExecuteListeners) {
            for (IDownloadTaskExecuteListener iDownloadTaskExecuteListener : downloadTaskExecuteListeners) {
                if (iDownloadTaskExecuteListener != null) {
                    iDownloadTaskExecuteListener.onStart(downloadTask, i);
                }
            }
        }
    }

    public static void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        synchronized (downloadCacheSyncStatusListeners) {
            if (iDownloadCacheSyncStatusListener != null) {
                if (!downloadCacheSyncStatusListeners.contains(iDownloadCacheSyncStatusListener)) {
                    downloadCacheSyncStatusListeners.add(iDownloadCacheSyncStatusListener);
                }
            }
        }
    }

    private static void registerDownloadReceiver() {
        if (downloadReceiver == null) {
            downloadReceiver = new DownloadReceiver();
        }
        if (isReceiverRegistered) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            appContext.registerReceiver(downloadReceiver, intentFilter);
            isReceiverRegistered = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void registerDownloadTaskExecuteListener(IDownloadTaskExecuteListener iDownloadTaskExecuteListener) {
        synchronized (downloadTaskExecuteListeners) {
            if (iDownloadTaskExecuteListener != null) {
                if (!downloadTaskExecuteListeners.contains(iDownloadTaskExecuteListener)) {
                    downloadTaskExecuteListeners.add(iDownloadTaskExecuteListener);
                }
            }
        }
    }

    public static void removeDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (downloadCompleteHandlers) {
            if (iDownloadCompleteHandler != null) {
                if (downloadCompleteHandlers.contains(iDownloadCompleteHandler)) {
                    downloadCompleteHandlers.remove(iDownloadCompleteHandler);
                }
            }
        }
    }

    public static void setAppContext(Context context) {
        synchronized (DownloadComponentManager.class) {
            if (context != null) {
                try {
                    if (appContext == null) {
                        appContext = context.getApplicationContext();
                        AppStatusManager.getInstance().init(appContext);
                    }
                } finally {
                }
            }
        }
    }

    private static void setCPUThreadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            cpuThreadExecutor = executorService;
        }
    }

    private static void setChunkAdjustCalculator(IChunkAdjustCalculator iChunkAdjustCalculator) {
        if (iChunkAdjustCalculator != null) {
            chunkAdjustCalculator = iChunkAdjustCalculator;
        }
    }

    private static void setChunkCntCalculator(IChunkCntCalculator iChunkCntCalculator) {
        if (iChunkCntCalculator != null) {
            chunkCntCalculator = iChunkCntCalculator;
        }
    }

    public static void setChunkDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            chunkDownloadExecutor = executorService;
        }
    }

    private static void setDBThreadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            dbThreadExecutor = executorService;
        }
    }

    private static void setDownloadBuilder(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                setAppContext(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                setDownloadCache(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                setIdGenerator(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                setChunkCntCalculator(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                setNotificationClickCallback(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                setMaxDownloadPoolSize(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                setHttpService(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                setHeadHttpService(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                setDownloadLaunchHandler(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                setCPUThreadExecutor(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                setIOThreadExecutor(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                setMixDefaultDownloadExecutor(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                setMixFrequentDownloadExecutor(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                setMixApkDownloadExecutor(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                setDBThreadExecutor(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                setChunkDownloadExecutor(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                setOkHttpDispatcherExecutor(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                setDownloadCompleteHandlers(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                monitorConfig = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                writeBufferSize = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                setChunkAdjustCalculator(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                downloadInMultiProcess = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                downloadExpSwitchCode = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                setDownloadSetting(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                downloadDns = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                iTTNetHandler = downloaderBuilder.getTTNetHandler();
                if (iTTNetHandler.isTTNetEnable()) {
                    setHttpService(iTTNetHandler.getTTNetDownloadHttpService());
                    setHeadHttpService(iTTNetHandler.getTTNetDownloadHeadHttpService());
                } else {
                    setHttpService(getDefaultHttpService());
                    setHeadHttpService(getDefaultHeadHttpService());
                }
            }
            needAutoRefreshUnSuccessTask(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                setDownloadMonitorListener(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void setDownloadCache(IDownloadCache iDownloadCache) {
        if (iDownloadCache != null) {
            downloadCache = iDownloadCache;
        }
    }

    private static void setDownloadCompleteHandlers(List<IDownloadCompleteHandler> list) {
        if (downloadCompleteHandlers.isEmpty()) {
            synchronized (downloadCompleteHandlers) {
                downloadCompleteHandlers.addAll(list);
            }
        }
    }

    public static void setDownloadEventListener(InnerEventListener innerEventListener) {
        downloadEventListener = innerEventListener;
    }

    public static void setDownloadInMultiProcess() {
        synchronized (DownloadComponentManager.class) {
            try {
                if (downloadInMultiProcess) {
                    return;
                }
                downloadInMultiProcess = true;
                Intent intent = new Intent(getAppContext(), DownloadHandleService.class);
                intent.setAction(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY);
                getAppContext().startService(intent);
                if (!DownloadUtils.isDownloaderProcess()) {
                    DownloadProxy.get(true).startService();
                }
            } finally {
            }
        }
    }

    public static void setDownloadLaunchHandler(IDownloadLaunchHandler iDownloadLaunchHandler) {
        synchronized (DownloadComponentManager.class) {
            if (iDownloadLaunchHandler != null) {
                try {
                    downloadLaunchHandler = iDownloadLaunchHandler;
                    if (downloadCache instanceof DefaultDownloadCache) {
                        ((DefaultDownloadCache) downloadCache).resumeUnCompleteTaskMayDelayed();
                    }
                } finally {
                }
            }
        }
    }

    private static void setDownloadMonitorListener(IDownloadMonitorListener iDownloadMonitorListener) {
        if (iDownloadMonitorListener != null) {
            downloadMonitorListener = iDownloadMonitorListener;
        }
    }

    public static void setDownloadSetting(IDownloadSettings iDownloadSettings) {
        downloadSettings = iDownloadSettings;
        DownloadSetting.init();
    }

    public static void setHeadHttpService(IDownloadHeadHttpService iDownloadHeadHttpService) {
        if (iDownloadHeadHttpService != null) {
            headHttpService = iDownloadHeadHttpService;
        }
    }

    public static void setHttpService(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            httpService = iDownloadHttpService;
        }
        httpServiceInit = httpService != null;
    }

    private static void setIOThreadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            ioThreadExecutor = executorService;
        }
    }

    private static void setIdGenerator(IDownloadIdGenerator iDownloadIdGenerator) {
        if (iDownloadIdGenerator != null) {
            idGenerator = iDownloadIdGenerator;
        }
    }

    public static void setIndependentServiceCreator(IndependentHolderCreator independentHolderCreator2) {
        Logger.v("wjd", "setIndependentServiceCreator::creator=" + independentHolderCreator2);
        independentHolderCreator = independentHolderCreator2;
    }

    private static void setMaxDownloadPoolSize(int i) {
        if (i > 0) {
            maxDownloadPoolSize = i;
        }
    }

    private static void setMixApkDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            mixApkDownloadExecutor = executorService;
        }
    }

    private static void setMixDefaultDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            mixDefaultDownloadExecutor = executorService;
        }
    }

    private static void setMixFrequentDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            mixFrequentDownloadExecutor = executorService;
        }
    }

    public static void setNotAutoRebootService(boolean z) {
        notAutoRebootService = z;
    }

    public static void setNotificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        if (iNotificationClickCallback != null) {
            notificationClickCallback = iNotificationClickCallback;
        }
    }

    public static void setOkHttpDispatcherExecutor(ExecutorService executorService) {
        if (executorService != null) {
            okHttpDispatcherExecutor = executorService;
        }
    }

    public static void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
    }

    public static void submitCPUTask(Runnable runnable) {
        submitCPUTask(runnable, false);
    }

    public static void submitCPUTask(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || DownloadUtils.isMainThread()) {
            getCPUThreadExecutor().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void submitDBTask(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (DownloadUtils.isMainThread()) {
            getDBThreadExecutorService().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void submitIOTask(Runnable runnable) {
        submitIOTask(runnable, false);
    }

    public static void submitIOTask(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || DownloadUtils.isMainThread()) {
            getIOThreadExecutor().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static boolean supportMultiProc() {
        StringBuilder sb = new StringBuilder();
        sb.append("supportMultiProc::=");
        sb.append(independentHolderCreator != null);
        Logger.v("wjd", sb.toString());
        return independentHolderCreator != null;
    }

    public static void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        synchronized (downloadCacheSyncStatusListeners) {
            if (iDownloadCacheSyncStatusListener != null) {
                if (downloadCacheSyncStatusListeners.contains(iDownloadCacheSyncStatusListener)) {
                    downloadCacheSyncStatusListeners.remove(iDownloadCacheSyncStatusListener);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unRegisterDownloadReceiver() {
        synchronized (DownloadComponentManager.class) {
            try {
                try {
                    if (isReceiverRegistered && downloadReceiver != null && appContext != null) {
                        appContext.unregisterReceiver(downloadReceiver);
                        isReceiverRegistered = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void unRegisterDownloadTaskExecuteListener(IDownloadTaskExecuteListener iDownloadTaskExecuteListener) {
        synchronized (downloadTaskExecuteListeners) {
            if (iDownloadTaskExecuteListener != null) {
                if (downloadTaskExecuteListeners.contains(iDownloadTaskExecuteListener)) {
                    downloadTaskExecuteListeners.remove(iDownloadTaskExecuteListener);
                }
            }
        }
    }
}
