package com.tencent.rtmp.downloader;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/downloader/TXVodPreloadManager.class */
public class TXVodPreloadManager {
    private static final String TAG = "TXVodPreloadManager";
    private static final String THUMB_PLAYER_GUID = "liteav_tbplayer_android_";
    private static final int THUMB_PLAYER_PLATFORM_ID = 2330303;
    private static Context mAppContext;
    private boolean mInit;
    private ITPDownloadProxy mTpDownloadProxy;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/downloader/TXVodPreloadManager$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        static TXVodPreloadManager f24978a = new TXVodPreloadManager();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/downloader/TXVodPreloadManager$b.class */
    static final class b implements ITPPreLoadListener {

        /* renamed from: a  reason: collision with root package name */
        int f24979a = -1;
        private final ITXVodPreloadListener b;

        /* renamed from: c  reason: collision with root package name */
        private final String f24980c;

        public b(String str, ITXVodPreloadListener iTXVodPreloadListener) {
            this.f24980c = str;
            this.b = iTXVodPreloadListener;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
        public final void onPrepareDownloadProgressUpdate(int i, int i2, long j, long j2, String str) {
            LiteavLog.d(TXVodPreloadManager.TAG, "preload: prepare process:" + i + "," + i2 + "," + j + "," + j2);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
        public final void onPrepareError(int i, int i2, String str) {
            LiteavLog.d(TXVodPreloadManager.TAG, "preload error: moduleId: " + i + ", errorCode: " + i2 + ", extInfo: " + str);
            ITXVodPreloadListener iTXVodPreloadListener = this.b;
            if (iTXVodPreloadListener != null) {
                iTXVodPreloadListener.onError(this.f24979a, this.f24980c, i2, str);
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
        public final void onPrepareOK() {
            LiteavLog.d(TXVodPreloadManager.TAG, "preload: onPrepareOK");
            ITXVodPreloadListener iTXVodPreloadListener = this.b;
            if (iTXVodPreloadListener != null) {
                iTXVodPreloadListener.onComplete(this.f24979a, this.f24980c);
            }
        }
    }

    private TXVodPreloadManager() {
        this.mInit = false;
    }

    private Pair<Integer, String> checkInit() {
        synchronized (this) {
            ITPDownloadProxy tPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(THUMB_PLAYER_PLATFORM_ID);
            this.mTpDownloadProxy = tPDownloadProxy;
            if (tPDownloadProxy == null) {
                return new Pair<>(-3, "Inner error.");
            }
            int b2 = com.tencent.liteav.txcplayer.a.b.b();
            if (b2 < 0) {
                return new Pair<>(-1, "MaxCacheSize not set.");
            }
            String a2 = com.tencent.liteav.txcplayer.a.b.a();
            if (TextUtils.equals(a2, "NO_SET")) {
                return new Pair<>(-2, "CacheFolderPath not set.");
            }
            if (!this.mInit) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("VodCacheReserveSizeMB", b2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mTpDownloadProxy.init(mAppContext, new TPDLProxyInitParam(THUMB_PLAYER_PLATFORM_ID, "1.0.0", THUMB_PLAYER_GUID + mAppContext.getPackageName(), null, a2, jSONObject.toString()));
                this.mInit = true;
            }
            this.mTpDownloadProxy.updateStoragePath(a2);
            this.mTpDownloadProxy.setMaxStorageSizeMB(b2);
            return new Pair<>(0, null);
        }
    }

    public static TXVodPreloadManager getInstance(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            mAppContext = applicationContext;
            ContextUtils.initApplicationContext(applicationContext);
            ContextUtils.setDataDirectorySuffix("liteav");
            return a.f24978a;
        }
        return null;
    }

    public int startPreload(String str, int i, long j, ITXVodPreloadListener iTXVodPreloadListener) {
        Pair<Integer, String> checkInit = checkInit();
        if (checkInit.first.intValue() < 0) {
            if (iTXVodPreloadListener != null) {
                iTXVodPreloadListener.onError(-1, str, checkInit.first.intValue(), checkInit.second);
                return -1;
            }
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        HashMap hashMap = new HashMap();
        hashMap.put(TPDownloadProxyEnum.DLPARAM_PRELOAD_SIZE, Integer.valueOf(i * 1024 * 1024));
        hashMap.put(TPDownloadProxyEnum.DLPARAM_PREFERRED_RESOLUTION, Long.valueOf(j));
        TPDownloadParam tPDownloadParam = new TPDownloadParam(arrayList, 0, hashMap);
        b bVar = new b(str, iTXVodPreloadListener);
        int startPreload = this.mTpDownloadProxy.startPreload(com.tencent.liteav.txcplayer.e.a.d(str), tPDownloadParam, bVar);
        bVar.f24979a = startPreload;
        return startPreload;
    }

    public void stopPreload(int i) {
        if (checkInit().first.intValue() < 0) {
            return;
        }
        this.mTpDownloadProxy.stopPreload(i);
    }
}
