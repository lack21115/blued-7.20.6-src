package com.kwad.components.core.b;

import android.util.SparseArray;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/d.class */
public class d implements com.kwad.components.core.b.c {
    private static volatile d HI;
    private static boolean HJ = true;
    private SparseArray<com.kwad.components.core.b.c> HH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/d$a.class */
    public static final class a implements Comparator<AdTemplate> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        private static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int cq = com.kwad.sdk.core.response.a.d.cq(adTemplate2) - com.kwad.sdk.core.response.a.d.cq(adTemplate);
            if (cq != 0) {
                return cq;
            }
            if (adTemplate.fromCache && adTemplate2.fromCache) {
                return 0;
            }
            return adTemplate.fromCache ? 1 : -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/d$b.class */
    static class b extends p<com.kwad.components.core.n.a, AdResultData> {
        private com.kwad.components.core.n.kwai.a HO;

        public b(com.kwad.components.core.n.kwai.a aVar) {
            this.HO = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onSuccess(com.kwad.components.core.n.a aVar, final AdResultData adResultData) {
            super.onSuccess(aVar, adResultData);
            GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.b.d.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b bVar = b.this;
                    b.c(adResultData);
                }
            });
            if (a(this.HO, adResultData)) {
                return;
            }
            com.kwad.components.core.n.kwai.a.a(this.HO, adResultData, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(AdResultData adResultData) {
            List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
            com.kwad.components.core.b.a lW = com.kwad.components.core.b.a.lW();
            if (lW == null || proceedTemplateList.size() <= 0) {
                return;
            }
            AdTemplate adTemplate = proceedTemplateList.get(0);
            com.kwad.components.core.b.e n = com.kwad.components.core.b.e.n(adResultData.getPosId());
            lW.lX();
            lW.f(g.a(n, adResultData));
            lW.a(com.kwad.components.core.b.e.E(adTemplate));
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(com.kwad.components.core.n.a aVar, int i, String str) {
            super.onError(aVar, i, str);
            com.kwad.components.core.n.kwai.a.a(this.HO, i, str, false);
        }

        protected boolean a(com.kwad.components.core.n.kwai.a aVar, AdResultData adResultData) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/d$c.class */
    public interface c {
        void me();
    }

    /* renamed from: com.kwad.components.core.b.d$d  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/d$d.class */
    public static final class C0342d implements com.kwad.components.core.b.c {
        @Override // com.kwad.components.core.b.c
        public final void c(com.kwad.components.core.n.kwai.a aVar) {
            d.a(aVar, new b(aVar));
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/d$e.class */
    public static final class e implements com.kwad.components.core.b.c {
        @Override // com.kwad.components.core.b.c
        public final void c(final com.kwad.components.core.n.kwai.a aVar) {
            GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.b.d.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    AdResultData d = d.d(aVar);
                    if (d != null && !d.isAdResultDataEmpty()) {
                        com.kwad.components.core.n.kwai.a.a(aVar, d, true);
                        return;
                    }
                    com.kwad.components.core.n.kwai.a aVar2 = aVar;
                    d.a(aVar2, new b(aVar2));
                }
            });
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/d$f.class */
    public static final class f implements com.kwad.components.core.b.c {

        /* renamed from: com.kwad.components.core.b.d$f$1  reason: invalid class name */
        /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/d$f$1.class */
        final class AnonymousClass1 extends b {
            final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(com.kwad.components.core.n.kwai.a aVar, com.kwad.components.core.n.kwai.a aVar2) {
                super(aVar);
                this.bN = aVar2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(SceneImpl sceneImpl, AdResultData adResultData, int i, c cVar) {
                AdResultData d = d.d(this.bN);
                if (d == null || d.isAdResultDataEmpty()) {
                    if (cVar != null) {
                        cVar.me();
                        return;
                    }
                    return;
                }
                List a2 = d.a(d.getProceedTemplateList());
                List subList = a2.subList(0, Math.min(i, a2.size()));
                if (subList.size() > 0) {
                    AdResultData adResultData2 = adResultData;
                    if (adResultData == null) {
                        adResultData2 = new AdResultData(sceneImpl);
                    }
                    com.kwad.components.core.n.kwai.a.a(this.bN, new AdResultData(adResultData2, sceneImpl, subList), false);
                }
            }

            @Override // com.kwad.components.core.b.d.b, com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public final void onError(final com.kwad.components.core.n.a aVar, final int i, final String str) {
                GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.b.d.f.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new c() { // from class: com.kwad.components.core.b.d.f.1.2.1
                            @Override // com.kwad.components.core.b.d.c
                            public final void me() {
                                com.kwad.components.core.n.kwai.a.a(AnonymousClass1.this.bN, i, str, false);
                            }
                        });
                    }
                });
            }

            @Override // com.kwad.components.core.b.d.b
            protected final boolean a(final com.kwad.components.core.n.kwai.a aVar, final AdResultData adResultData) {
                AdResultData d;
                List a2;
                List subList;
                final SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
                final int adNum = adScene.getAdNum();
                if (adResultData.isAdResultDataEmpty()) {
                    GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.b.d.f.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1.this.a(adScene, adResultData, adNum, new c() { // from class: com.kwad.components.core.b.d.f.1.1.1
                                @Override // com.kwad.components.core.b.d.c
                                public final void me() {
                                    com.kwad.components.core.n.kwai.a.a(aVar, adResultData, false);
                                }
                            });
                        }
                    });
                    return true;
                } else if (!adResultData.isBidding() || (d = d.d(aVar)) == null || d.isAdResultDataEmpty() || (subList = (a2 = d.a(d.getProceedTemplateList(), adResultData.getProceedTemplateList())).subList(0, Math.min(adNum, a2.size()))) == null || subList.size() <= 0) {
                    return false;
                } else {
                    com.kwad.components.core.n.kwai.a.a(aVar, new AdResultData(adResultData, adScene, subList), true);
                    return true;
                }
            }
        }

        @Override // com.kwad.components.core.b.c
        public final void c(com.kwad.components.core.n.kwai.a aVar) {
            d.a(aVar, new AnonymousClass1(aVar, aVar));
        }
    }

    private d() {
        SparseArray<com.kwad.components.core.b.c> sparseArray = new SparseArray<>();
        this.HH = sparseArray;
        sparseArray.append(1, new f());
        this.HH.append(2, new e());
        this.HH.append(0, new C0342d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends com.kwad.components.core.n.a> T a(com.kwad.sdk.e.c<T> cVar) {
        return cVar.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(List<AdTemplate>... listArr) {
        if (listArr == null) {
            return null;
        }
        ArrayList<AdTemplate> arrayList = new ArrayList();
        int length = listArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            arrayList.addAll(listArr[i2]);
            i = i2 + 1;
        }
        Collections.sort(arrayList, new a((byte) 0));
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : arrayList) {
            long cl = com.kwad.sdk.core.response.a.d.cl(adTemplate);
            if (!hashSet.contains(Long.valueOf(cl))) {
                hashSet.add(Long.valueOf(cl));
                arrayList2.add(adTemplate);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final com.kwad.components.core.n.kwai.a aVar, p<com.kwad.components.core.n.a, AdResultData> pVar) {
        new com.kwad.components.core.k.a(aVar.JW) { // from class: com.kwad.components.core.b.d.1
            @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.m
            /* renamed from: aj */
            public final AdResultData parseData(String str) {
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(KSLoggerReporter.bv(aVar.getAdStyle()), "requestFinish").report();
                return AdResultData.createFromResponseJson(str, aVar.JW.Ow);
            }

            @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.a
            /* renamed from: mc */
            public final com.kwad.components.core.n.a createRequest() {
                return d.a(new com.kwad.sdk.e.c<com.kwad.components.core.n.a>() { // from class: com.kwad.components.core.b.d.1.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.e.c
                    /* renamed from: md */
                    public com.kwad.components.core.n.a get() {
                        if (aVar.getAdStyle() == 4) {
                            aVar.Os = SplashPreloadManager.rV().rW();
                        }
                        return new com.kwad.components.core.n.a(aVar);
                    }
                });
            }
        }.request(pVar);
    }

    static /* synthetic */ boolean a(d dVar) {
        return ma();
    }

    static /* synthetic */ com.kwad.components.core.b.c b(d dVar) {
        return dVar.mb();
    }

    static /* synthetic */ SparseArray c(d dVar) {
        return dVar.HH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AdResultData d(com.kwad.components.core.n.kwai.a aVar) {
        com.kwad.components.core.b.a lW = com.kwad.components.core.b.a.lW();
        if (lW == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<g> b2 = lW.b(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, com.kwad.components.core.b.e.n(aVar.getPosId()).mh());
        if (com.kwad.sdk.core.config.d.uR()) {
            g(b2);
        }
        if (b2 == null || b2.size() <= 0) {
            return null;
        }
        Collections.sort(b2);
        return g.h(b2.subList(0, Math.min(b2.size(), adNum)));
    }

    private static void g(List<g> list) {
        if (list == null) {
            return;
        }
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (com.kwad.components.core.b.f.mk().a(next)) {
                com.kwad.sdk.core.d.b.d("AdCacheFetcherHolder", "filterByMemCached contain: " + next.mr());
                it.remove();
            }
        }
    }

    public static d lZ() {
        if (HI == null) {
            synchronized (d.class) {
                try {
                    if (HI == null) {
                        HI = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return HI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ma() {
        if (HJ) {
            try {
                Class.forName("com.kwad.devTools.PosConfigFetcher");
                HJ = true;
            } catch (ClassNotFoundException e2) {
                HJ = false;
            }
            return HJ;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.b.c mb() {
        return this.HH.get(0);
    }

    @Override // com.kwad.components.core.b.c
    public final void c(final com.kwad.components.core.n.kwai.a aVar) {
        GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.b.d.2
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.components.core.b.d.a(com.kwad.components.core.b.d):boolean
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4483)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // java.lang.Runnable
            public final void run() {
                /*
                    r5 = this;
                    r0 = r5
                    com.kwad.components.core.n.kwai.a r0 = r5
                    long r0 = r0.getPosId()
                    com.kwad.components.core.b.e r0 = com.kwad.components.core.b.e.n(r0)
                    r6 = r0
                    com.kwad.components.core.b.d$2$1 r0 = new com.kwad.components.core.b.d$2$1
                    r1 = r0
                    r2 = r5
                    r3 = r6
                    r1.<init>()
                    com.kwad.sdk.utils.bi.runOnUiThread(r0)
                    r0 = r5
                    com.kwad.components.core.b.d r0 = com.kwad.components.core.b.d.this
                    boolean r0 = com.kwad.components.core.b.d.a(r0)
                    if (r0 != 0) goto L47
                    r0 = r6
                    boolean r0 = r0.isDefault()
                    if (r0 != 0) goto L32
                    r0 = r6
                    boolean r0 = r0.isEnable()
                    if (r0 != 0) goto L32
                    goto L47
                L32:
                    r0 = r5
                    com.kwad.components.core.b.d r0 = com.kwad.components.core.b.d.this
                    android.util.SparseArray r0 = com.kwad.components.core.b.d.c(r0)
                    r1 = r6
                    int r1 = r1.mg()
                    java.lang.Object r0 = r0.get(r1)
                    com.kwad.components.core.b.c r0 = (com.kwad.components.core.b.c) r0
                    r6 = r0
                    goto L4f
                L47:
                    r0 = r5
                    com.kwad.components.core.b.d r0 = com.kwad.components.core.b.d.this
                    com.kwad.components.core.b.c r0 = com.kwad.components.core.b.d.b(r0)
                    r6 = r0
                L4f:
                    r0 = r6
                    r7 = r0
                    r0 = r6
                    if (r0 != 0) goto L64
                    r0 = r5
                    com.kwad.components.core.b.d r0 = com.kwad.components.core.b.d.this
                    android.util.SparseArray r0 = com.kwad.components.core.b.d.c(r0)
                    r1 = 1
                    java.lang.Object r0 = r0.get(r1)
                    com.kwad.components.core.b.c r0 = (com.kwad.components.core.b.c) r0
                    r7 = r0
                L64:
                    r0 = r7
                    r1 = r5
                    com.kwad.components.core.n.kwai.a r1 = r5
                    r0.c(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.b.d.AnonymousClass2.run():void");
            }
        });
    }
}
