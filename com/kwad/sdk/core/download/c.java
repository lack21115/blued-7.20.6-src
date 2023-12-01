package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.ad;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/c.class */
public final class c {
    private static final Map<String, Integer> aeY = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> afb = new LruHashMap(10);
    private final WeakHashMap<d, AdTemplate> aeW;
    private final Map<d, AdTemplate> aeX;
    private final HashMap<String, AdTemplate> aeZ;
    private final Map<String, AdTemplate> afa;
    private final com.kwad.sdk.a.a afc;
    private volatile boolean mHasInit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/c$a.class */
    public static final class a {
        static final c afk = new c((byte) 0);
    }

    private c() {
        WeakHashMap<d, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.aeW = weakHashMap;
        this.aeX = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.aeZ = hashMap;
        this.afa = Collections.synchronizedMap(hashMap);
        this.afc = new com.kwad.sdk.a.a() { // from class: com.kwad.sdk.core.download.c.3
            @Override // com.kwad.sdk.a.a
            public final void X(String str) {
                c.this.bU(str);
            }
        };
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private void a(String str, com.kwad.sdk.e.a<d> aVar) {
        Set<d> keySet = this.aeX.keySet();
        synchronized (this.aeX) {
            for (d dVar : keySet) {
                if (dVar != null && TextUtils.equals(dVar.nc(), str)) {
                    try {
                        aVar.accept(dVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                    }
                }
            }
        }
    }

    public static int bN(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = aeY.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f fVar = new f();
        synchronized (this.aeX) {
            for (d dVar : this.aeX.keySet()) {
                if (dVar != null && !TextUtils.isEmpty(str) && TextUtils.equals(str, dVar.nd())) {
                    dVar.a((String) null, 0, fVar);
                }
            }
        }
        com.ksad.download.d O = com.ksad.download.c.M().O();
        if (O != null) {
            O.n(str);
        }
        synchronized (this.afa) {
            Iterator<Map.Entry<String, AdTemplate>> it = this.afa.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, AdTemplate> next = it.next();
                if (next != null) {
                    String key = next.getKey();
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str, key)) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void f(String str, f fVar) {
        AdTemplate value;
        for (Map.Entry<String, AdTemplate> entry : this.afa.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(value);
                com.kwad.sdk.core.a.tS().c(str, value);
                if (!TextUtils.isEmpty(str) && cb.downloadId.equals(str) && !value.mDownloadFinishReported) {
                    if (fVar.vx()) {
                        com.kwad.sdk.core.download.a.c(1, value);
                        fVar.vw();
                    }
                    value.mDownloadFinishReported = true;
                }
            }
        }
    }

    public static c vu() {
        return a.afk;
    }

    public final void a(d dVar) {
        this.aeX.remove(dVar);
    }

    public final void a(d dVar, AdTemplate adTemplate) {
        this.aeX.put(dVar, adTemplate);
    }

    public final void a(final String str, final int i, final int i2, final int i3) {
        aeY.put(str, 2);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.a(str, i, i2, i3);
            }
        });
    }

    public final void aM(Context context) {
        synchronized (this) {
            if (!this.mHasInit || context == null) {
                return;
            }
            com.kwad.sdk.a.b.tA().b(this.afc);
            this.aeX.clear();
            this.afa.clear();
            this.mHasInit = false;
        }
    }

    public final void al(AdTemplate adTemplate) {
        try {
            String aq = com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            if (TextUtils.isEmpty(aq)) {
                return;
            }
            this.afa.put(aq, adTemplate);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    public final void b(final String str, int i, final String str2) {
        aeY.put(str, 7);
        final f fVar = new f();
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.7
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.a(str, r6, str2, fVar);
            }
        });
    }

    public final void bO(final String str) {
        aeY.put(str, 1);
        final f fVar = new f();
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.a(str, fVar);
            }
        });
    }

    public final void bP(final String str) {
        final f fVar = new f();
        aeY.put(str, 4);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.b(str, fVar);
            }
        });
    }

    public final void bQ(final String str) {
        final f fVar = new f();
        aeY.put(str, 1);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.9
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.c(str, fVar);
            }
        });
    }

    public final void bR(final String str) {
        final f fVar = new f();
        aeY.put(str, 5);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.10
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.d(str, fVar);
            }
        });
    }

    public final void bS(final String str) {
        final f fVar = new f();
        aeY.put(str, 9);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.11
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.e(str, fVar);
            }
        });
    }

    public final void bT(final String str) {
        final f fVar = new f();
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.aq(str);
            }
        });
    }

    public final void init(Context context) {
        synchronized (this) {
            if (this.mHasInit || context == null) {
                return;
            }
            com.ksad.download.c.M().a(new com.ksad.download.b() { // from class: com.kwad.sdk.core.download.c.1
                private static String m(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) c.afb.get(url);
                    String str2 = str;
                    if (TextUtils.isEmpty(str)) {
                        str2 = ad.eC(downloadTask.getUrl());
                        c.afb.put(url, str2);
                    }
                    return str2;
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void a(DownloadTask downloadTask) {
                    c.this.r(m(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void a(DownloadTask downloadTask, int i, int i2) {
                    c.this.a(m(downloadTask), i2 > 0 ? (int) ((i * 100.0f) / i2) : 0, i, i2);
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void a(DownloadTask downloadTask, Throwable th) {
                    String str;
                    if (th == null || th.getStackTrace().length <= 0) {
                        str = "";
                    } else {
                        str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
                    }
                    c.this.b(m(downloadTask), 0, str);
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.b.kwai.a.bI.booleanValue()) {
                            com.kwad.sdk.core.d.b.d("DownloadStatusManager", "onDownloadStart(), id=" + m(downloadTask));
                        }
                        c.this.bO(m(downloadTask));
                    }
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void c(DownloadTask downloadTask) {
                    c.this.bP(m(downloadTask));
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void d(DownloadTask downloadTask) {
                    c.this.bR(m(downloadTask));
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void e(DownloadTask downloadTask) {
                    c.this.bQ(m(downloadTask));
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void f(DownloadTask downloadTask) {
                    c.this.bT(m(downloadTask));
                }
            });
            com.kwad.sdk.a.b.tA().a(this.afc);
            this.mHasInit = true;
        }
    }

    public final void r(final String str, final String str2) {
        final f fVar = new f();
        aeY.put(str, 8);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.6
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.a(str, str2, fVar);
            }
        });
        f(str, fVar);
    }
}
