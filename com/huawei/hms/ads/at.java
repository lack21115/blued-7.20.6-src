package com.huawei.hms.ads;

import com.huawei.hms.ads.jsb.inner.data.AppDownloadInfo;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/at.class */
public abstract class at extends ap {
    private static final String Z = "JsbOnDownloadChange";

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/at$a.class */
    public static class a implements AppDownloadListener {
        private String Code;
        private String I;
        private String V;
        private Map<String, RemoteCallResultCallback<String>> Z = Collections.synchronizedMap(new c(5));
        private Map<String, RemoteCallResultCallback<String>> B = Collections.synchronizedMap(new c(5));
        private Map<String, RemoteCallResultCallback<String>> C = Collections.synchronizedMap(new c(5));

        public a() {
            ge.Code("jsb", "DownloadListener init");
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.download.app.k kVar, AppInfo appInfo) {
            Map<String, RemoteCallResultCallback<String>> map = this.Z;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (Map.Entry<String, RemoteCallResultCallback<String>> entry : this.Z.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    RemoteCallResultCallback<String> value = entry.getValue();
                    if (value != null) {
                        af.Code(value, this.Code, 1000, com.huawei.openalliance.ad.utils.z.V(new AppDownloadInfo(appInfo, kVar)), false);
                    }
                    if (kVar == com.huawei.openalliance.ad.download.app.k.DOWNLOADFAILED) {
                        AppDownloadTask V = com.huawei.openalliance.ad.download.app.g.I().V(appInfo);
                        Map<String, RemoteCallResultCallback<String>> map2 = this.B;
                        if (map2 != null && map2.size() > 0 && this.B.get(key) != null) {
                            af.Code(this.B.get(key), this.V, 1000, com.huawei.openalliance.ad.utils.z.V(new AppDownloadInfo(appInfo, V != null ? V.S() : 0)), false);
                        }
                    }
                }
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(AppInfo appInfo) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(AppInfo appInfo, int i) {
            AppDownloadTask V = com.huawei.openalliance.ad.download.app.g.I().V(appInfo);
            if (V != null) {
                Code(dp.Code(V), appInfo);
            }
            Map<String, RemoteCallResultCallback<String>> map = this.B;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (RemoteCallResultCallback<String> remoteCallResultCallback : this.B.values()) {
                af.Code(remoteCallResultCallback, this.V, 1000, com.huawei.openalliance.ad.utils.z.V(new AppDownloadInfo(appInfo, i)), false);
            }
        }

        public void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.Z.put(str2, remoteCallResultCallback);
            this.Code = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(String str) {
            Map<String, RemoteCallResultCallback<String>> map = this.C;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (RemoteCallResultCallback<String> remoteCallResultCallback : this.C.values()) {
                if (remoteCallResultCallback != null) {
                    af.Code(remoteCallResultCallback, this.I, 1000, com.huawei.openalliance.ad.utils.z.V(new AppDownloadInfo(str)), false);
                }
            }
        }

        public void I(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.C.put(str2, remoteCallResultCallback);
            this.I = str;
        }

        public void V(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.B.put(str2, remoteCallResultCallback);
            this.V = str;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/at$b.class */
    static class b {
        private static a Code = new a();

        static {
            ge.Code(at.Z, "register global Jsb app download Listener.");
            com.huawei.openalliance.ad.download.a.Code().V(Code);
        }

        private b() {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/at$c.class */
    static class c<K, V> extends LinkedHashMap<K, V> {
        private static final long Code = 8139502072983476335L;
        private final int V;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i) {
            this.V = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.V;
        }
    }

    public at(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a V() {
        return b.Code;
    }
}
