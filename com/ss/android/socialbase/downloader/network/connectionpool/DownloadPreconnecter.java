package com.ss.android.socialbase.downloader.network.connectionpool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IFetchHttpHeadInfoListener;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/connectionpool/DownloadPreconnecter.class */
public class DownloadPreconnecter {
    private static final long DEFAULT_CONNECTION_OUTDATE_TIME = 300000;
    private static final long DEFAULT_HEAD_INFO_OUTDATE_TIME = 300000;
    private static Runnable sCancelRunnable;
    static long sConnectionOutdatedTime;
    private static final Handler sHandler;
    static long sHeadInfoOutdatedTime;
    private static final HandlerThread sPreconnectThread = new HandlerThread("Downloader-preconnecter");

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/network/connectionpool/DownloadPreconnecter$CancelRunnable.class */
    static class CancelRunnable implements Runnable {
        private final String mUrl;

        public CancelRunnable(String str) {
            this.mUrl = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DownloadConnectionPool.getInstance().releaseDownloadConnection(this.mUrl);
            } catch (Throwable th) {
            }
        }
    }

    static {
        init();
        sPreconnectThread.start();
        Handler handler = new Handler(sPreconnectThread.getLooper());
        sHandler = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable th) {
                }
            }
        });
    }

    public static void asyncFetchHttpHeadInfo(final String str, final IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener) {
        sHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.2
            @Override // java.lang.Runnable
            public void run() {
                FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection;
                FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection2 = null;
                if (TextUtils.isEmpty(str)) {
                    IFetchHttpHeadInfoListener iFetchHttpHeadInfoListener2 = iFetchHttpHeadInfoListener;
                    if (iFetchHttpHeadInfoListener2 != null) {
                        iFetchHttpHeadInfoListener2.onFetchFinished(null);
                        return;
                    }
                    return;
                }
                FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection3 = null;
                FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection4 = null;
                try {
                    try {
                        List<HttpHeader> extraHeaders = DownloadPreconnecter.getExtraHeaders(0L, null, null);
                        if (DownloadConnectionPool.getInstance().isHeadConnectionExist(str)) {
                            fakeDownloadHeadHttpConnection2 = DownloadConnectionPool.getInstance().getCachedHeadConnection(str, extraHeaders);
                        }
                        FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection5 = fakeDownloadHeadHttpConnection2;
                        if (fakeDownloadHeadHttpConnection2 == null) {
                            FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection6 = new FakeDownloadHeadHttpConnection(str, extraHeaders, 0L);
                            try {
                                fakeDownloadHeadHttpConnection6.execute();
                                if (fakeDownloadHeadHttpConnection6.isSuccessful()) {
                                    DownloadConnectionPool.getInstance().putCachedHeadConnections(str, fakeDownloadHeadHttpConnection6);
                                }
                                fakeDownloadHeadHttpConnection5 = fakeDownloadHeadHttpConnection6;
                            } catch (Exception e) {
                                fakeDownloadHeadHttpConnection4 = fakeDownloadHeadHttpConnection6;
                                e = e;
                                fakeDownloadHeadHttpConnection3 = fakeDownloadHeadHttpConnection4;
                                e.printStackTrace();
                                fakeDownloadHeadHttpConnection = fakeDownloadHeadHttpConnection4;
                                fakeDownloadHeadHttpConnection.cancel();
                            } catch (Throwable th) {
                                fakeDownloadHeadHttpConnection3 = fakeDownloadHeadHttpConnection6;
                                th = th;
                                try {
                                    fakeDownloadHeadHttpConnection3.cancel();
                                } catch (Throwable th2) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> responseHeaders = fakeDownloadHeadHttpConnection5.getResponseHeaders();
                        fakeDownloadHeadHttpConnection = fakeDownloadHeadHttpConnection5;
                        if (iFetchHttpHeadInfoListener != null) {
                            FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection7 = fakeDownloadHeadHttpConnection5;
                            fakeDownloadHeadHttpConnection4 = fakeDownloadHeadHttpConnection5;
                            iFetchHttpHeadInfoListener.onFetchFinished(responseHeaders);
                            fakeDownloadHeadHttpConnection = fakeDownloadHeadHttpConnection5;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    fakeDownloadHeadHttpConnection.cancel();
                } catch (Throwable th4) {
                }
            }
        });
    }

    private static void asyncPreconnect(final int i, final String str, final List<HttpHeader> list, final long j, final boolean z, final boolean z2) {
        sHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.connectionpool.DownloadPreconnecter.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (z2) {
                        DownloadPreconnecter.fetchHeadInfo(str, list, j);
                    }
                    if (z) {
                        DownloadPreconnecter.createConnection(i, str, list, j);
                        Runnable unused = DownloadPreconnecter.sCancelRunnable = new CancelRunnable(str);
                        DownloadPreconnecter.sHandler.postDelayed(DownloadPreconnecter.sCancelRunnable, DownloadPreconnecter.sConnectionOutdatedTime);
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createConnection(int i, String str, List<HttpHeader> list, long j) {
        if (DownloadConnectionPool.getInstance().isDownloadConnectionExist(str)) {
            return;
        }
        FakeDownloadHttpConnection fakeDownloadHttpConnection = new FakeDownloadHttpConnection(i, str, list, j);
        DownloadConnectionPool.getInstance().putCachedDownloadConnections(str, fakeDownloadHttpConnection);
        try {
            fakeDownloadHttpConnection.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchHeadInfo(String str, List<HttpHeader> list, long j) {
        if (DownloadConnectionPool.getInstance().isHeadConnectionExist(str)) {
            return;
        }
        FakeDownloadHeadHttpConnection fakeDownloadHeadHttpConnection = new FakeDownloadHeadHttpConnection(str, list, j);
        DownloadConnectionPool.getInstance().putCachedHeadConnections(str, fakeDownloadHeadHttpConnection);
        try {
            try {
                fakeDownloadHeadHttpConnection.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                fakeDownloadHeadHttpConnection.cancel();
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            try {
                fakeDownloadHeadHttpConnection.cancel();
            } catch (Throwable th3) {
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<HttpHeader> getExtraHeaders(long j, DownloadInfo downloadInfo, List<HttpHeader> list) {
        return DownloadUtils.addRangeHeader(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }

    public static Looper getLooper() {
        return sPreconnectThread.getLooper();
    }

    private static void init() {
        sConnectionOutdatedTime = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_CONNECTION_OUTDATE_TIME, 300000L);
        sHeadInfoOutdatedTime = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_HEAD_INFO_OUTDATE_TIME, 300000L);
        DownloadConnectionPool.getInstance().setMaxCachedDownloadConnectionSize(DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.GLOBAL_KEY_PRECONNECT_MAX_CACHE_SIZE, 3));
    }

    public static void preconnect(int i, String str, String str2, List<HttpHeader> list, boolean z, boolean z2) {
        long j;
        DownloadInfo downloadInfo = Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(str, str2);
        if (downloadInfo == null) {
            j = 0;
        } else if (downloadInfo.isDownloadingStatus() || downloadInfo.isDownloaded() || downloadInfo.getChunkCount() > 1) {
            return;
        } else {
            j = DownloadUtils.getFirstOffset(downloadInfo);
        }
        asyncPreconnect(i, str, getExtraHeaders(j, downloadInfo, list), j, z, z2);
    }

    public static void preconnect(String str, String str2, boolean z) {
        preconnect(-1, str, str2, null, z, true);
    }
}
