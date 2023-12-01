package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.a.a.a;
import com.kwad.sdk.core.webview.a.b.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/a/a.class */
public class a {
    private static volatile a apJ;
    private Context mContext;
    private long mInitTime;
    private volatile boolean mHasInit = false;
    private final List<com.kwad.sdk.f.kwai.b> apK = new CopyOnWriteArrayList();
    private final List<String> apL = new CopyOnWriteArrayList();
    private final List<String> apM = new CopyOnWriteArrayList();
    private final NetworkMonitor.a apN = new NetworkMonitor.a() { // from class: com.kwad.sdk.core.webview.a.a.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.zc();
            }
        }
    };

    private a() {
    }

    private WebResourceResponse L(String str, String str2) {
        int i;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            b.a aVar = new b.a();
            this.apL.add(str);
            WebResourceResponse a2 = a(str, str2, aVar, false);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a2 != null) {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "load success time:" + currentTimeMillis2 + "--url:" + str2);
                i = 1;
                str3 = "";
            } else {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "load fail errorMsg:" + aVar.msg + "-url:" + str2);
                i = 2;
                str3 = aVar.msg;
            }
            com.kwad.sdk.core.webview.a.b.b.a(str2, str, i, str3, currentTimeMillis2);
            return a2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            com.kwad.sdk.core.webview.a.b.b.a(str2, str, 2, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), System.currentTimeMillis() - currentTimeMillis);
            return null;
        }
    }

    private WebResourceResponse a(String str, String str2, b.a aVar, boolean z) {
        com.kwad.sdk.f.kwai.b df = df(str);
        if (df == null) {
            com.kwad.sdk.f.kwai.b de2 = de(str);
            if (de2 == null) {
                aVar.msg = "配置文件没有下发该zip资源";
                return null;
            }
            aVar.msg = "资源未下载:" + de2.loadType;
            b(de2);
            return null;
        }
        return b.a(this.mContext, str2, df, aVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.f.kwai.b bVar) {
        if (this.apM.contains(bVar.atm)) {
            return;
        }
        com.kwad.sdk.core.webview.a.a.a.a(bVar, new a.InterfaceC0568a() { // from class: com.kwad.sdk.core.webview.a.a.4
            @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0568a
            public final void c(com.kwad.sdk.f.kwai.b bVar2) {
                a.this.apM.add(bVar2.atm);
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "download onStart: " + bVar2.toString());
            }

            @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0568a
            public final void d(com.kwad.sdk.f.kwai.b bVar2) {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "download success: " + bVar2.toString());
                if (com.kwad.sdk.core.webview.a.a.b.a(a.this.mContext, bVar2)) {
                    com.kwad.sdk.core.d.b.d("HybridPackageManager", "install success: " + bVar2.toString());
                    a.this.apK.add(bVar2);
                    a aVar = a.this;
                    aVar.bf(aVar.mContext);
                    com.kwad.sdk.core.webview.a.b.b.a(bVar2, 4);
                }
                a.this.apM.remove(bVar2.atm);
            }

            @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0568a
            public final void e(com.kwad.sdk.f.kwai.b bVar2) {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "download failure: " + bVar2.toString());
                a.this.apM.remove(bVar2.atm);
            }
        });
    }

    private void a(com.kwad.sdk.f.kwai.b bVar, com.kwad.sdk.f.kwai.a aVar) {
        bVar.atm = aVar.sceneId;
        if (TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        String dj = com.kwad.sdk.core.webview.a.b.a.dj(bVar.packageUrl);
        if (TextUtils.isEmpty(dj)) {
            return;
        }
        bVar.atn = dj;
        bVar.ato = com.kwad.sdk.core.webview.a.b.a.y(this.mContext, bVar.atn);
    }

    private void b(final com.kwad.sdk.f.kwai.b bVar) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.webview.a.a.5
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b A[Catch: all -> 0x00a7, TryCatch #2 {, blocks: (B:13:0x003b, B:24:0x0060, B:26:0x0073, B:28:0x007b, B:30:0x008c, B:32:0x009f, B:34:0x00a1, B:35:0x00a6, B:22:0x005c), top: B:47:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bf(android.content.Context r5) {
        /*
            r4 = this;
            r0 = r4
            java.util.List<com.kwad.sdk.f.kwai.b> r0 = r0.apK
            r9 = r0
            r0 = r9
            monitor-enter(r0)
            r0 = 0
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = r8
            r6 = r0
            r0 = r5
            java.io.File r0 = com.kwad.sdk.core.webview.a.b.a.bj(r0)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> Lad
            r5 = r0
            r0 = r8
            r6 = r0
            r0 = r4
            java.util.List<com.kwad.sdk.f.kwai.b> r0 = r0.apK     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> Lad
            org.json.JSONArray r0 = com.kwad.sdk.utils.t.C(r0)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> Lad
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> Lad
            r10 = r0
            r0 = r8
            r6 = r0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> Lad
            r1 = r0
            r2 = r5
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> Lad
            r5 = r0
            r0 = r5
            r1 = r10
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> Lb3
            r0.write(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> Lb3
            r0 = r5
            com.kwad.sdk.crash.utils.b.closeQuietly(r0)     // Catch: java.lang.Throwable -> La7
            goto L5f
        L41:
            r7 = move-exception
            r0 = r5
            r6 = r0
            r0 = r7
            r5 = r0
            goto La1
        L49:
            goto L50
        L4c:
            r5 = move-exception
            goto La1
        L50:
            r0 = r5
            r6 = r0
            java.lang.String r0 = "updatePackageIndexFile"
            java.lang.String r1 = "read packageIndex file error"
            com.kwad.sdk.core.d.b.e(r0, r1)     // Catch: java.lang.Throwable -> L4c
            r0 = r5
            com.kwad.sdk.crash.utils.b.closeQuietly(r0)     // Catch: java.lang.Throwable -> La7
        L5f:
            r0 = r4
            java.util.List<java.lang.String> r0 = r0.apL     // Catch: java.lang.Throwable -> La7
            r0.clear()     // Catch: java.lang.Throwable -> La7
            r0 = r4
            java.util.List<com.kwad.sdk.f.kwai.b> r0 = r0.apK     // Catch: java.lang.Throwable -> La7
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> La7
            r5 = r0
        L72:
            r0 = r5
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> La7
            if (r0 == 0) goto L9d
            r0 = r5
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> La7
            com.kwad.sdk.f.kwai.b r0 = (com.kwad.sdk.f.kwai.b) r0     // Catch: java.lang.Throwable -> La7
            r6 = r0
            r0 = r6
            boolean r0 = r0.atr     // Catch: java.lang.Throwable -> La7
            if (r0 == 0) goto L72
            r0 = r4
            java.util.List<java.lang.String> r0 = r0.apL     // Catch: java.lang.Throwable -> La7
            r1 = r6
            java.lang.String r1 = r1.atm     // Catch: java.lang.Throwable -> La7
            boolean r0 = r0.add(r1)     // Catch: java.lang.Throwable -> La7
            goto L72
        L9d:
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La7
            return
        La1:
            r0 = r6
            com.kwad.sdk.crash.utils.b.closeQuietly(r0)     // Catch: java.lang.Throwable -> La7
            r0 = r5
            throw r0     // Catch: java.lang.Throwable -> La7
        La7:
            r5 = move-exception
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La7
            r0 = r5
            throw r0
        Lad:
            r5 = move-exception
            r0 = r7
            r5 = r0
            goto L50
        Lb3:
            r6 = move-exception
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.a.a.bf(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a A[Catch: all -> 0x00e2, TRY_ENTER, TryCatch #1 {, blocks: (B:14:0x0049, B:26:0x006a, B:28:0x007f, B:30:0x0092, B:32:0x009a, B:34:0x00b5, B:36:0x00c1, B:38:0x00c7, B:40:0x00da, B:22:0x0060, B:42:0x00dc, B:43:0x00e1), top: B:51:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009a A[Catch: all -> 0x00e2, TryCatch #1 {, blocks: (B:14:0x0049, B:26:0x006a, B:28:0x007f, B:30:0x0092, B:32:0x009a, B:34:0x00b5, B:36:0x00c1, B:38:0x00c7, B:40:0x00da, B:22:0x0060, B:42:0x00dc, B:43:0x00e1), top: B:51:0x0010 }] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bg(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.a.a.bg(android.content.Context):void");
    }

    private WebResourceResponse dd(String str) {
        WebResourceResponse a2;
        try {
            b.a aVar = new b.a();
            synchronized (this.apK) {
                Iterator<String> it = this.apL.iterator();
                do {
                    if (!it.hasNext()) {
                        return null;
                    }
                    a2 = a(it.next(), str, aVar, true);
                } while (a2 == null);
                return a2;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private com.kwad.sdk.f.kwai.b de(String str) {
        List<com.kwad.sdk.f.kwai.b> zd = zd();
        if (zd == null || zd.isEmpty()) {
            return null;
        }
        for (com.kwad.sdk.f.kwai.b bVar : zd) {
            if (bb.isEquals(str, bVar.atm)) {
                return bVar;
            }
        }
        return null;
    }

    private com.kwad.sdk.f.kwai.b df(String str) {
        com.kwad.sdk.f.kwai.b next;
        synchronized (this.apK) {
            if (!TextUtils.isEmpty(str) && this.apK.size() > 0) {
                Iterator<com.kwad.sdk.f.kwai.b> it = this.apK.iterator();
                do {
                    if (!it.hasNext()) {
                        return null;
                    }
                    next = it.next();
                } while (!TextUtils.equals(str, next.atm));
                return next;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(List<com.kwad.sdk.f.kwai.b> list) {
        synchronized (this.apK) {
            bg(this.mContext);
            for (com.kwad.sdk.f.kwai.b bVar : this.apK) {
                if (!list.contains(bVar)) {
                    q.V(new File(bVar.ato));
                    this.apK.remove(bVar);
                } else if (q.ew(com.kwad.sdk.core.webview.a.b.a.A(this.mContext, bVar.atn))) {
                    list.remove(bVar);
                }
            }
            bf(this.mContext);
        }
    }

    public static a za() {
        if (apJ == null) {
            synchronized (a.class) {
                try {
                    if (apJ == null) {
                        apJ = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return apJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.kwad.sdk.f.kwai.b> zd() {
        List<com.kwad.sdk.f.kwai.a> list;
        SdkConfigData uu = d.uu();
        if (uu == null || (list = uu.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.kwad.sdk.f.kwai.a aVar : list) {
            for (com.kwad.sdk.f.kwai.b bVar : aVar.atl) {
                a(bVar, aVar);
                if (bVar.isValid()) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public final WebResourceResponse K(String str, String str2) {
        if (this.mHasInit) {
            String di = com.kwad.sdk.core.webview.a.b.a.di(str);
            if (TextUtils.isEmpty(di)) {
                return dd(str);
            }
            com.kwad.sdk.core.webview.a.b.b.b(str2, di, str);
            WebResourceResponse L = L(di, str);
            com.kwad.sdk.core.webview.a.b.b.c(str2, di, str);
            return L;
        }
        return null;
    }

    public final void init(final Context context) {
        synchronized (this) {
            if (this.mHasInit || context == null) {
                return;
            }
            this.mContext = ServiceProvider.CA();
            this.mHasInit = true;
            g.execute(new aw() { // from class: com.kwad.sdk.core.webview.a.a.1
                @Override // com.kwad.sdk.utils.aw
                public final void doTask() {
                    try {
                        if (d.b(c.adb)) {
                            a.this.mInitTime = System.currentTimeMillis();
                            a.this.bg(context);
                            a.this.zc();
                            NetworkMonitor.getInstance().a(a.this.mContext, a.this.apN);
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
                    }
                }
            });
        }
    }

    public final long zb() {
        return this.mInitTime;
    }

    public final void zc() {
        if (d.uD()) {
            g.execute(new Runnable() { // from class: com.kwad.sdk.core.webview.a.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        List<com.kwad.sdk.f.kwai.b> zd = a.this.zd();
                        if (zd == null || zd.isEmpty()) {
                            return;
                        }
                        a.this.t(zd);
                        for (com.kwad.sdk.f.kwai.b bVar : zd) {
                            if (bVar.packageType == 1 && (bVar.loadType == 1 || (bVar.loadType == 2 && ag.isWifiConnected(a.this.mContext)))) {
                                a.this.a(bVar);
                            }
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
                    }
                }
            });
        }
    }
}
