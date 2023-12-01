package com.tencent.rtmp.downloader;

import android.text.TextUtils;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.b.c;
import com.tencent.liteav.txcvodplayer.c.a;
import com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder;
import com.tencent.rtmp.TXPlayInfoParams;
import com.tencent.rtmp.downloader.TXVodDownloadManager;
import com.tencent.rtmp.downloader.a.b;
import com.tencent.rtmp.downloader.a.c;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/downloader/TXVodDownloadManager.class */
public class TXVodDownloadManager {
    public static final int DOWNLOAD_403FORBIDDEN = -5008;
    public static final int DOWNLOAD_AUTH_FAILED = -5001;
    public static final int DOWNLOAD_DISCONNECT = -5005;
    public static final int DOWNLOAD_FORMAT_ERROR = -5004;
    public static final int DOWNLOAD_HLS_KEY_ERROR = -5006;
    public static final int DOWNLOAD_NO_FILE = -5003;
    public static final int DOWNLOAD_PATH_ERROR = -5007;
    public static final int DOWNLOAD_SUCCESS = 0;
    private static final String TAG = "TXVodDownloadManager";
    private static TXVodDownloadManager sInstance;
    private final b mManagerImpl = new b();

    private TXVodDownloadManager() {
    }

    public static TXVodDownloadManager getInstance() {
        synchronized (TXVodDownloadManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = new TXVodDownloadManager();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sInstance;
    }

    @Deprecated
    public boolean deleteDownloadFile(String str) {
        return this.mManagerImpl.a(str);
    }

    public boolean deleteDownloadMediaInfo(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        b bVar = this.mManagerImpl;
        if (bVar.a(tXVodDownloadMediaInfo.getPlayPath())) {
            String b = b.b(tXVodDownloadMediaInfo);
            if (bVar.d != null) {
                bVar.d.clear(b);
                PersistStorage persistStorage = bVar.d;
                persistStorage.clear(b + "_kv");
                bVar.d.commit();
                TXVodDownloadDataSource dataSource = tXVodDownloadMediaInfo.getDataSource();
                if (dataSource != null && !TextUtils.isEmpty(dataSource.getOverlayKey())) {
                    a a2 = a.a();
                    int appId = dataSource.getAppId();
                    String fileId = dataSource.getFileId();
                    if (!TextUtils.isEmpty(fileId)) {
                        a2.b.clear(a.a(appId, fileId));
                        a2.b.commit();
                    }
                }
                LiteavLog.i("TXVodDownloadManagerImpl", "delete DownloadMediaInfo and file complete");
                return true;
            }
            return false;
        }
        return false;
    }

    public TXVodDownloadMediaInfo getDownloadMediaInfo(int i, String str, int i2) {
        return this.mManagerImpl.a(i, str, i2);
    }

    public TXVodDownloadMediaInfo getDownloadMediaInfo(String str) {
        return this.mManagerImpl.b(str);
    }

    public List<TXVodDownloadMediaInfo> getDownloadMediaInfoList() {
        return this.mManagerImpl.a();
    }

    @Deprecated
    public void setDownloadPath(String str) {
        this.mManagerImpl.f38672a.setDownloadPath(str);
    }

    public void setHeaders(Map<String, String> map) {
        this.mManagerImpl.f38672a.setHeaders(map);
    }

    public void setListener(ITXVodDownloadListener iTXVodDownloadListener) {
        this.mManagerImpl.f38673c = iTXVodDownloadListener;
    }

    public TXVodDownloadMediaInfo startDownload(TXVodDownloadDataSource tXVodDownloadDataSource) {
        final b bVar = this.mManagerImpl;
        if (tXVodDownloadDataSource.getAuthBuilder() != null) {
            LiteavLog.w("TXVodDownloadManagerImpl", "startDownloadV2");
            return bVar.a(tXVodDownloadDataSource);
        }
        LiteavLog.w("TXVodDownloadManagerImpl", "startDownloadV4");
        if (tXVodDownloadDataSource == null) {
            return null;
        }
        com.tencent.rtmp.downloader.a.a aVar = new com.tencent.rtmp.downloader.a.a(tXVodDownloadDataSource.getAppId(), tXVodDownloadDataSource.getFileId(), tXVodDownloadDataSource.getQuality(), tXVodDownloadDataSource.getPSign(), tXVodDownloadDataSource.getUserName());
        final c cVar = new c();
        cVar.a(aVar);
        c a2 = bVar.a((TXVodDownloadMediaInfo) cVar);
        if (a2 != null) {
            return a2;
        }
        new com.tencent.liteav.txcvodplayer.b.c(new TXPlayInfoParams(aVar.getAppId(), aVar.getFileId(), aVar.getPSign())).a(new c.a() { // from class: com.tencent.rtmp.downloader.a.b.2
            @Override // com.tencent.liteav.txcvodplayer.b.c.a
            public final void a(int i, String str) {
                LiteavLog.w("TXVodDownloadManagerImpl", "onFail: errorCode = " + i + " message = " + str);
                synchronized (bVar.b) {
                    bVar.b.remove(cVar);
                }
                if (bVar.f38673c != null) {
                    bVar.f38673c.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_AUTH_FAILED, str);
                }
            }

            @Override // com.tencent.liteav.txcvodplayer.b.c.a
            public final void a(com.tencent.liteav.txcvodplayer.b.c cVar2, TXPlayInfoParams tXPlayInfoParams) {
                LiteavLog.i("TXVodDownloadManagerImpl", "onSuccess: protocol params = " + tXPlayInfoParams.toString());
                if (cVar.getDownloadState() == 2) {
                    synchronized (bVar.b) {
                        bVar.b.remove(cVar);
                    }
                    if (bVar.f38673c != null) {
                        bVar.f38673c.onDownloadStop(cVar);
                    }
                    LiteavLog.w("TXVodDownloadManagerImpl", "Download task canceled");
                    return;
                }
                if ("SimpleAES".equalsIgnoreCase(cVar2.d()) && !TextUtils.isEmpty(cVar2.d) && !TextUtils.isEmpty(cVar2.e)) {
                    a aVar2 = (a) cVar.getDataSource();
                    String a3 = TXCHLSEncoder.a(aVar2.getAppId(), aVar2.getUserName(), aVar2.getFileId(), aVar2.getQuality());
                    String a4 = TXCHLSEncoder.a(a3, cVar2.d);
                    String a5 = TXCHLSEncoder.a(a3, cVar2.e);
                    if (TextUtils.isEmpty(a4) || TextUtils.isEmpty(a5)) {
                        LiteavLog.e("TXVodDownloadManagerImpl", "create local key exception!");
                        return;
                    }
                    aVar2.a(a4);
                    aVar2.b(a5);
                    com.tencent.liteav.txcvodplayer.c.a a6 = com.tencent.liteav.txcvodplayer.c.a.a();
                    int appId = tXPlayInfoParams.getAppId();
                    String fileId = tXPlayInfoParams.getFileId();
                    String str = cVar2.d;
                    String str2 = cVar2.e;
                    if (TextUtils.isEmpty(fileId) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        LiteavLog.w("PlayInfoProtocolV4Storage", "put params empty fileId: " + fileId + " overlayKey:" + str + " overlayIv:" + str2);
                    } else {
                        com.tencent.liteav.txcplayer.a.a.a().execute(com.tencent.liteav.txcvodplayer.c.c.a(a6, appId, fileId, str, str2));
                    }
                }
                b.a(bVar, cVar, cVar2);
            }
        });
        return cVar;
    }

    @Deprecated
    public TXVodDownloadMediaInfo startDownloadUrl(String str) {
        return this.mManagerImpl.a(str, "default");
    }

    public TXVodDownloadMediaInfo startDownloadUrl(String str, String str2) {
        return this.mManagerImpl.a(str, str2);
    }

    public void stopDownload(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        b bVar = this.mManagerImpl;
        if (tXVodDownloadMediaInfo != null) {
            if (tXVodDownloadMediaInfo.getTaskId() < 0) {
                LiteavLog.w("TXVodDownloadManagerImpl", "stop download not start task");
                return;
            }
            bVar.f38672a.stop(tXVodDownloadMediaInfo.getTaskId());
            LiteavLog.d("TXVodDownloadManagerImpl", "stop download " + tXVodDownloadMediaInfo.getUrl());
        }
    }
}
