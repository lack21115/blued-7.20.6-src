package com.tencent.liteav.thumbplayer.downloader;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.a.b;
import com.tencent.liteav.txcplayer.b.a;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/thumbplayer/downloader/ThumbPlayerDownloader.class */
public class ThumbPlayerDownloader extends a {
    private static final String THUMB_PLAYER_GUID = "liteav_tbplayer_android_";
    private static final int THUMB_PLAYER_PLATFORM_ID = 2330303;
    private static ThumbPlayerDownloader sInstance;
    private ITPDownloadProxy mTpDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(THUMB_PLAYER_PLATFORM_ID);

    private ThumbPlayerDownloader(Context context) {
        File externalFilesDir;
        if (context != null) {
            this.mDownloadPath = b.a();
            try {
                if (TextUtils.isEmpty(this.mDownloadPath) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                    this.mDownloadPath = externalFilesDir.getAbsolutePath() + "/txcache";
                }
                if (!TextUtils.isEmpty(this.mDownloadPath)) {
                    File file = new File(this.mDownloadPath);
                    if (!file.exists() || !file.isDirectory()) {
                        file.mkdirs();
                    }
                }
            } catch (Exception e) {
                String str = TAG;
                LiteavLog.e(str, "downloader init exception: " + e.getLocalizedMessage());
            }
            this.mTpDownloadProxy.init(context, new TPDLProxyInitParam(THUMB_PLAYER_PLATFORM_ID, "1.0.0", THUMB_PLAYER_GUID + context.getPackageName(), this.mDownloadPath));
        }
    }

    public static ThumbPlayerDownloader getInstance(Context context) {
        synchronized (ThumbPlayerDownloader.class) {
            try {
                if (sInstance == null) {
                    sInstance = new ThumbPlayerDownloader(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sInstance;
    }

    @Override // com.tencent.liteav.txcplayer.b.a
    public boolean deleteDownloadFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String substring = str.substring(0, str.indexOf(".hls") + 4);
        String substring2 = substring.substring(substring.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1);
        return !TextUtils.isEmpty(substring2) && this.mTpDownloadProxy.removeStorageCache(substring2) == 0;
    }

    @Override // com.tencent.liteav.txcplayer.b.a
    public int downloadHls(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.contains(".hls")) {
            String substring = str2.substring(0, str2.indexOf(".hls") + 4);
            String substring2 = substring.substring(substring.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            TPDownloadParam tPDownloadParam = new TPDownloadParam(arrayList, 3, null);
            if (this.mHeaders != null && this.mHeaders.size() > 0) {
                HashMap hashMap = new HashMap();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.mHeaders);
                hashMap.put(TPDownloadProxyEnum.DLPARAM_URL_HEADER, arrayList2);
                tPDownloadParam.setExtInfoMap(hashMap);
            }
            final com.tencent.liteav.txcplayer.b.b bVar = new com.tencent.liteav.txcplayer.b.b();
            bVar.b = str;
            int startOfflineDownload = this.mTpDownloadProxy.startOfflineDownload(substring2, tPDownloadParam, new ITPOfflineDownloadListener() { // from class: com.tencent.liteav.thumbplayer.downloader.ThumbPlayerDownloader.1
                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener
                public void onDownloadCdnUrlExpired(Map<String, String> map) {
                    LiteavLog.d(ThumbPlayerDownloader.TAG, "onDownloadCdnUrlExpired!");
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener
                public void onDownloadCdnUrlInfoUpdate(String str3, String str4, String str5, String str6) {
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener
                public void onDownloadCdnUrlUpdate(String str3) {
                    LiteavLog.d(ThumbPlayerDownloader.TAG, "onDownloadCdnUrlUpdate! url:".concat(String.valueOf(str3)));
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener
                public void onDownloadError(int i, int i2, String str3) {
                    String str4 = ThumbPlayerDownloader.TAG;
                    LiteavLog.d(str4, "HLS offline download error! moduleID:" + i + ", errCode:" + i2);
                    if (ThumbPlayerDownloader.this.mDownloadListener != null) {
                        ThumbPlayerDownloader.this.mDownloadListener.a(bVar, i2, str3);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener
                public void onDownloadFinish() {
                    if (ThumbPlayerDownloader.this.mDownloadListener != null) {
                        ThumbPlayerDownloader.this.mDownloadListener.c(bVar);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener
                public void onDownloadProgressUpdate(int i, int i2, long j, long j2, String str3) {
                    int i3;
                    if (j > 1024 && (i3 = (int) j) != bVar.f36476c) {
                        bVar.f36476c = i3;
                    }
                    bVar.d = (int) j2;
                    bVar.e = i2;
                    bVar.h = i;
                    if (bVar.i <= 0 && !TextUtils.isEmpty(str3) && str3.contains("totalDuration")) {
                        String[] split = str3.split(",");
                        int length = split.length;
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= length) {
                                break;
                            }
                            String str4 = split[i5];
                            if (str4.contains("totalDuration")) {
                                bVar.i = Integer.valueOf(str4.split(":")[1]).intValue() * 1000;
                                break;
                            }
                            i4 = i5 + 1;
                        }
                    }
                    if (ThumbPlayerDownloader.this.mDownloadListener != null) {
                        ThumbPlayerDownloader.this.mDownloadListener.d(bVar);
                    }
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener
                public void onDownloadProtocolUpdate(String str3, String str4) {
                    String str5 = ThumbPlayerDownloader.TAG;
                    LiteavLog.d(str5, "onDownloadProtocolUpdate! protocol:" + str3 + ", protocolVer:" + str4);
                }

                @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener
                public void onDownloadStatusUpdate(int i) {
                    LiteavLog.d(ThumbPlayerDownloader.TAG, "onDownloadStatusUpdate! statusCode:".concat(String.valueOf(i)));
                }
            });
            this.mTpDownloadProxy.startTask(startOfflineDownload);
            bVar.f36475a = startOfflineDownload;
            if (this.mDownloadListener != null) {
                this.mDownloadListener.a(bVar);
            }
            return startOfflineDownload;
        }
        return -1;
    }

    @Override // com.tencent.liteav.txcplayer.b.a
    public String makePlayPath(String str) {
        String a2 = b.a();
        if (!TextUtils.equals(this.mDownloadPath, a2)) {
            if (TextUtils.isEmpty(a2)) {
                b.a(this.mDownloadPath);
            } else {
                this.mDownloadPath = a2;
                this.mTpDownloadProxy.updateStoragePath(this.mDownloadPath);
            }
        }
        if (!Uri.parse(str).getPath().endsWith(".m3u8")) {
            LiteavLog.e(TAG, "Unsupported format");
            return null;
        }
        return this.mDownloadPath + BridgeUtil.SPLIT_MARK + com.tencent.liteav.txcplayer.e.a.b(str) + ".hls?" + str;
    }

    @Override // com.tencent.liteav.txcplayer.b.a
    public void setDownloadPath(String str) {
        super.setDownloadPath(str);
        this.mTpDownloadProxy.updateStoragePath(this.mDownloadPath);
    }

    @Override // com.tencent.liteav.txcplayer.b.a
    public void stop(int i) {
        if (this.mTpDownloadProxy.pauseDownload(i) != 0 || this.mDownloadListener == null) {
            return;
        }
        com.tencent.liteav.txcplayer.b.b bVar = new com.tencent.liteav.txcplayer.b.b();
        bVar.f36475a = i;
        this.mDownloadListener.b(bVar);
    }
}
