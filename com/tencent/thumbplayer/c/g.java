package com.tencent.thumbplayer.c;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/g.class */
public class g implements ITPPreloadProxy {

    /* renamed from: a  reason: collision with root package name */
    private Context f25568a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private ITPDownloadProxy f25569c;
    private boolean f = false;
    private a d = new a();
    private ITPPreloadProxy.IPreloadListener e = new f("TPPreloadProxyImpl");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/g$a.class */
    public class a implements ITPDLProxyLogListener, ITPPreLoadListener {
        private a() {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int d(String str, int i, String str2, String str3) {
            TPLogUtil.d(str2, "[" + str + ":" + i + "] " + str3);
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int e(String str, int i, String str2, String str3) {
            TPLogUtil.e(str2, "[" + str + ":" + i + "] " + str3);
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int i(String str, int i, String str2, String str3) {
            TPLogUtil.i(str2, "[" + str + ":" + i + "] " + str3);
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
        public void onPrepareDownloadProgressUpdate(int i, int i2, long j, long j2, String str) {
            g.this.e.onPrepareDownloadProgressUpdate(i, i2, j, j2);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
        public void onPrepareError(int i, int i2, String str) {
            g.this.e.onPrepareError();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
        public void onPrepareOK() {
            g.this.e.onPrepareSuccess();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int w(String str, int i, String str2, String str3) {
            TPLogUtil.w(str2, "[" + str + ":" + i + "] " + str3);
            return 0;
        }
    }

    public g(Context context, int i) {
        this.f25568a = context;
        this.b = i;
        a();
    }

    private void a() {
        b a2;
        int i = 3;
        while (i > 0 && !this.f) {
            int i2 = i;
            try {
                a2 = i.a().a(this.b);
            } catch (Exception e) {
                i = i2 - 1;
                TPLogUtil.e("TPPreloadProxyImpl", e);
            }
            if (a2 != null && a2.a() != null) {
                int i3 = i;
                ITPDownloadProxy a3 = a2.a();
                int i4 = i;
                this.f25569c = a3;
                int i5 = i;
                a3.setLogListener(this.d);
                int i6 = i;
                this.f25569c.setUserData(TPDownloadProxyEnum.USER_IS_VIP, Boolean.valueOf(TPPlayerConfig.isUserIsVip()));
                int i7 = i;
                if (!TextUtils.isEmpty(TPPlayerConfig.getUserUin())) {
                    int i8 = i;
                    this.f25569c.setUserData(TPDownloadProxyEnum.USER_UIN, TPPlayerConfig.getUserUin());
                }
                int i9 = i;
                if (!TextUtils.isEmpty(TPPlayerConfig.getAppVersionName(this.f25568a))) {
                    int i10 = i;
                    this.f25569c.setUserData("app_version_name", TPPlayerConfig.getAppVersionName(this.f25568a));
                }
                int i11 = i;
                if (TPPlayerConfig.getBuildNumber(this.f25568a) != -1) {
                    int i12 = i;
                    this.f25569c.setUserData("app_version_code", String.valueOf(TPPlayerConfig.getBuildNumber(this.f25568a)));
                }
                int i13 = i;
                this.f25569c.setUserData(TPDownloadProxyEnum.USER_UPC, TPPlayerConfig.getUserUpc());
                int i14 = i;
                this.f25569c.setUserData(TPDownloadProxyEnum.USER_UPC_STATE, Integer.valueOf(TPPlayerConfig.getUserUpcState()));
                int i15 = i;
                this.f25569c.setUserData(TPDownloadProxyEnum.USER_EXTERNAL_NETWORK_IP, TPPlayerConfig.getOutNetIp());
                i2 = i;
                this.f = true;
                return;
            }
            i--;
            TPLogUtil.e("TPPreloadProxyImpl", "p2p so load failed");
        }
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public String getPlayErrorCodeStr(int i) {
        return null;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public boolean isAvailable() {
        return this.f25569c != null && this.f;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public void pushEvent(int i) {
        if (isAvailable()) {
            try {
                this.f25569c.pushEvent(i);
            } catch (Throwable th) {
                TPLogUtil.e("TPPreloadProxyImpl", th);
            }
        }
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public void setPreloadListener(ITPPreloadProxy.IPreloadListener iPreloadListener) {
        if (iPreloadListener == null) {
            this.e = new f("TPPreloadProxyImpl");
        } else {
            this.e = iPreloadListener;
        }
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public int startClipPreload(String str, ArrayList<TPDownloadParamData> arrayList) {
        TPLogUtil.i("TPPreloadProxyImpl", "[startClipPreload] Preloading clips.");
        if (arrayList == null) {
            TPLogUtil.e("TPPreloadProxyImpl", "[startClipPreload] Fail to start clip preload: null download parameter list.");
            return -1;
        }
        if (!isAvailable()) {
            a();
            if (!isAvailable()) {
                TPLogUtil.e("TPPreloadProxyImpl", "[startClipPreload] Fail to initialize proxy.");
                return -1;
            }
        }
        int startClipPreload = this.f25569c.startClipPreload(str, arrayList.size(), this.d);
        if (startClipPreload <= 0) {
            TPLogUtil.e("TPPreloadProxyImpl", "[startClipPreload] Fail to start clip preload: invalid preload ID.");
            stopPreload(startClipPreload);
            return -1;
        }
        Iterator<TPDownloadParamData> it = arrayList.iterator();
        int i = 1;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                try {
                    this.f25569c.startTask(startClipPreload);
                    return startClipPreload;
                } catch (Throwable th) {
                    TPLogUtil.e("TPPreloadProxyImpl", "[startClipPreload] Fail to start task: " + th.toString());
                    stopPreload(startClipPreload);
                    return -1;
                }
            }
            TPDownloadParamData next = it.next();
            if (!this.f25569c.setClipInfo(startClipPreload, i2, next.getDownloadFileID(), k.a(next.getUrl(), next, null))) {
                TPLogUtil.e("TPPreloadProxyImpl", "[startClipPreload] Fail to set clip info.");
                stopPreload(startClipPreload);
                return -1;
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public int startPreload(String str, TPDownloadParamData tPDownloadParamData) {
        return startPreload(str, tPDownloadParamData, null);
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public int startPreload(String str, TPDownloadParamData tPDownloadParamData, Map<String, String> map) {
        if (!isAvailable()) {
            a();
            if (!isAvailable()) {
                return -1;
            }
        }
        if (tPDownloadParamData != null) {
            try {
                return this.f25569c.startPreload(str, k.a(null, tPDownloadParamData, map), this.d);
            } catch (Throwable th) {
                TPLogUtil.e("TPPreloadProxyImpl", th);
                return -1;
            }
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public void stopPreload(int i) {
        ITPDownloadProxy iTPDownloadProxy = this.f25569c;
        if (iTPDownloadProxy == null) {
            return;
        }
        try {
            iTPDownloadProxy.stopPreload(i);
        } catch (Throwable th) {
            TPLogUtil.e("TPPreloadProxyImpl", th);
        }
    }
}
