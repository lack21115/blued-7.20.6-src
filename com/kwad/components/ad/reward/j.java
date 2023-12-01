package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.ad.reward.h.s;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.g.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.a.b.d;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/j.class */
public final class j extends com.kwad.components.core.j.a {
    public boolean fO;
    public com.kwad.components.ad.reward.d.b mAdOpenInteractionListener;
    public com.kwad.components.ad.reward.d.d mAdRewardStepListener;
    public com.kwad.components.core.d.b.c mApkDownloadHelper;
    public boolean mCheckExposureResult;
    private Handler mHandler;
    public long mPageEnterTime;
    public JSONObject mReportExtData;
    private boolean mRewardVerifyCalled;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bh mTimerHelper;
    public KsVideoPlayConfig mVideoPlayConfig;
    public DetailVideoView oM;
    public com.kwad.components.ad.reward.j.b oN;
    public IAdLiveOfflineView oO;
    public com.kwad.components.core.playable.a oP;
    public RewardActionBarControl oQ;
    public l oR;
    public com.kwad.components.ad.i.b oS;
    public com.kwad.components.ad.i.a oT;
    public g oU;
    private final PriorityQueue<com.kwad.components.ad.reward.d.f> oV;
    public final List<com.kwad.components.ad.reward.h.a> oW;
    private final List<s> oX;
    public Set<com.kwad.components.ad.reward.d.e> oY;
    private com.kwad.components.ad.reward.g.c oZ;
    public long pA;
    public long pB;
    public boolean pC;
    private boolean pD;
    private boolean pE;
    public boolean pF;
    public boolean pG;
    public boolean pH;
    public LoadStrategy pI;
    private RewardRenderResult pJ;
    private List<a> pK;
    private List<b> pL;
    private List<a.InterfaceC0353a> pM;
    private com.kwad.components.core.webview.a.d.a pa;
    private e.a pb;
    private boolean pc;
    private boolean pd;
    private boolean pe;
    public boolean pf;
    public boolean pg;
    public boolean ph;
    public boolean pi;
    private boolean pj;
    public boolean pk;
    public boolean pl;
    public List<Integer> pm;
    public int pn;
    public boolean po;
    public com.kwad.components.ad.reward.k.o pp;
    public boolean pq;
    private PlayableSource pr;
    private boolean ps;
    private List<DialogInterface.OnDismissListener> pt;
    public com.kwad.components.ad.reward.d.m pu;
    public boolean pv;
    public com.kwad.components.ad.reward.i.a.a pw;
    public com.kwad.components.ad.reward.i.kwai.a px;
    public int py;
    private int pz;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/j$a.class */
    public interface a {
        void gb();

        void gc();

        void gd();

        void ge();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/j$b.class */
    public interface b {
        boolean interceptPlayCardResume();
    }

    public j(com.kwad.components.core.j.b<?> bVar) {
        super(bVar);
        this.oV = new PriorityQueue<>();
        this.oW = new CopyOnWriteArrayList();
        this.oX = new CopyOnWriteArrayList();
        this.oY = new HashSet();
        this.pc = false;
        this.pd = false;
        this.pe = false;
        this.pg = false;
        this.ph = false;
        this.pi = false;
        this.pj = false;
        this.pk = false;
        this.mRewardVerifyCalled = false;
        this.pl = false;
        this.pm = new ArrayList();
        this.mCheckExposureResult = true;
        this.pn = 0;
        this.po = false;
        this.pq = false;
        this.pr = null;
        this.ps = false;
        this.pt = new CopyOnWriteArrayList();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.pv = false;
        this.pz = 2;
        this.pD = false;
        this.pE = false;
        this.pF = false;
        this.pG = false;
        this.pH = false;
        this.pI = LoadStrategy.FULL_TK;
        this.pK = new CopyOnWriteArrayList();
        this.pL = new CopyOnWriteArrayList();
        this.pM = new CopyOnWriteArrayList();
        this.JT.add(new com.kwad.components.core.j.kwai.a() { // from class: com.kwad.components.ad.reward.j.1
            @Override // com.kwad.components.core.j.kwai.a
            public final void a(com.kwad.components.core.l.d dVar) {
                j.this.fB();
            }

            @Override // com.kwad.components.core.j.kwai.a
            public final void b(com.kwad.components.core.l.d dVar) {
                j.this.fC();
            }

            @Override // com.kwad.components.core.j.kwai.a
            public final void c(com.kwad.components.core.l.d dVar) {
                j.this.fD();
            }

            @Override // com.kwad.components.core.j.kwai.a
            public final void fY() {
                j.this.fA();
            }
        });
    }

    public static long a(long j, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.a.a.X(adInfo), j);
    }

    public static com.kwad.components.core.g.c a(List<com.kwad.components.core.g.c> list, long j) {
        if (j < 0 || list == null) {
            return null;
        }
        for (com.kwad.components.core.g.c cVar : list) {
            if (com.kwad.sdk.core.response.a.d.cl(cVar.getAdTemplate()) == j) {
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.report.i iVar) {
        com.kwad.sdk.core.report.i iVar2 = iVar;
        if (iVar == null) {
            iVar2 = new com.kwad.sdk.core.report.i();
        }
        iVar2.bj(i);
        iVar2.c(this.mRootContainer.getTouchCoords());
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, iVar2.wY(), this.mReportExtData);
        com.kwad.components.ad.reward.b.a.gQ().d(this.mAdTemplate, com.kwad.components.ad.reward.b.b.STATUS_NONE);
        this.mAdOpenInteractionListener.bN();
    }

    public static void a(Activity activity, j jVar) {
        com.kwad.components.ad.reward.h.kwai.b.a(jVar, activity, jVar.oN.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.j.10
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                j.this.d(dialogInterface);
                com.kwad.sdk.core.b.b.vS();
                Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(j.this.getActivity())) {
                    return;
                }
                j.this.oN.resume();
            }
        }, new k.b() { // from class: com.kwad.components.ad.reward.j.2
            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void fZ() {
                j.this.oN.pause();
            }
        });
    }

    public static void a(Context context, j jVar, ViewGroup viewGroup) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        if (aVar != null && aVar.hasLiveCompoReady() && com.kwad.sdk.core.response.a.a.cq(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate))) {
            IAdLiveOfflineView view = aVar.getView(context, com.kwad.sdk.core.response.a.a.aX(cb) == 8 ? 1 : 0);
            View view2 = view.getView();
            jVar.oO = view;
            viewGroup.addView(view2);
            jVar.oN.a(aVar.getAdLivePlayModule(view, KsAdSDKImpl.get().getAppId(), String.valueOf(com.kwad.sdk.core.response.a.a.bN(cb))));
        }
    }

    public static void a(j jVar, final k.c cVar, final k.a aVar) {
        com.kwad.components.ad.reward.h.kwai.b bVar = null;
        com.kwad.components.ad.reward.h.kwai.b bVar2 = null;
        if (!jVar.oN.jF()) {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
            if (com.kwad.components.ad.reward.kwai.b.k(cb) || com.kwad.sdk.core.response.a.a.ci(cb)) {
                bVar2 = f(jVar);
            }
            bVar = bVar2;
            if (bVar2 == null) {
                bVar = g(jVar);
            }
        }
        if (bVar != null) {
            com.kwad.components.ad.reward.h.kwai.b.a(bVar, jVar.getActivity(), jVar.oN.getPlayDuration(), aVar, new d.a() { // from class: com.kwad.components.ad.reward.j.8
                @Override // com.kwad.components.core.webview.a.b.d.a
                public final boolean ga() {
                    j.b(j.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(jVar, cVar, aVar);
        }
    }

    public static <T> void a(List<T> list, com.kwad.sdk.e.a<T> aVar) {
        if (list != null) {
            for (T t : list) {
                aVar.accept(t);
            }
        }
    }

    public static boolean a(j jVar) {
        AdMatrixInfo.FullScreenInfo bJ;
        return com.kwad.sdk.core.config.d.isCanUseTk() && (bJ = com.kwad.sdk.core.response.a.b.bJ(jVar.mAdTemplate)) != null && bJ.renderType == 1 && !com.kwad.sdk.core.response.a.a.aI(jVar.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(j jVar, k.c cVar, k.a aVar) {
        boolean e = e(jVar);
        new StringBuilder("showNativeCloseDialog isCloseDialogShowing: ").append(e);
        if (e) {
            return;
        }
        k.a(jVar.getActivity(), jVar.mAdTemplate, cVar, aVar);
    }

    public static boolean b(j jVar) {
        if (jVar.oN.jF() || !com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class) == null) {
            return false;
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        boolean z = (com.kwad.sdk.core.response.a.a.ck(cb) || (com.kwad.sdk.core.response.a.a.bv(cb) && com.kwad.components.ad.reward.kwai.b.gD()) || com.kwad.sdk.core.response.a.d.cn(jVar.mAdTemplate)) ? false : true;
        jVar.ph = z && !jVar.pG;
        boolean z2 = false;
        if (z) {
            z2 = false;
            if (!jVar.pG) {
                z2 = true;
            }
        }
        jVar.E(z2);
        return z;
    }

    public static boolean c(j jVar) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        if (jVar.oN.jF() || com.kwad.sdk.core.response.a.a.cq(cb) || !com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class) == null || a(jVar)) {
            return false;
        }
        boolean z = com.kwad.components.ad.reward.kwai.b.k(cb) || !(com.kwad.components.ad.reward.kwai.b.j(cb) || com.kwad.sdk.core.response.a.d.co(jVar.mAdTemplate) || com.kwad.sdk.core.response.a.a.ck(cb));
        boolean z2 = false;
        if (z) {
            z2 = false;
            if (!jVar.pG) {
                z2 = true;
            }
        }
        jVar.ph = z2;
        return z;
    }

    public static boolean d(j jVar) {
        if (jVar.oN.jF() || !com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class) == null || jVar.pF) {
            return false;
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.cv(cb)) {
            return true;
        }
        return (o(jVar.mAdTemplate) || p(jVar.mAdTemplate) || !(com.kwad.components.ad.reward.kwai.b.k(cb) || (!com.kwad.components.ad.reward.kwai.b.j(cb) && !com.kwad.sdk.core.response.a.a.ck(cb) && !(com.kwad.sdk.core.response.a.a.bv(cb) && com.kwad.components.ad.reward.kwai.b.gD()) && !com.kwad.sdk.core.response.a.d.co(jVar.mAdTemplate) && !com.kwad.sdk.core.response.a.a.aI(jVar.mAdTemplate)))) ? false : true;
    }

    public static boolean e(j jVar) {
        return jVar.pc;
    }

    private static com.kwad.components.ad.reward.h.kwai.b f(j jVar) {
        d.b bVar = new d.b();
        bVar.setAdTemplate(jVar.mAdTemplate);
        bVar.aP("ksad-video-confirm-card");
        bVar.aQ(false);
        bVar.aR(true);
        return com.kwad.components.ad.reward.h.kwai.b.a(jVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fA() {
        for (a aVar : this.pK) {
            aVar.gb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB() {
        if (this.pd || this.pc || this.pD) {
            return;
        }
        boolean z = false;
        for (b bVar : this.pL) {
            z |= bVar.interceptPlayCardResume();
        }
        if (z) {
            return;
        }
        for (a aVar : this.pK) {
            aVar.gc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fC() {
        for (a aVar : this.pK) {
            aVar.gd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD() {
        for (a aVar : this.pK) {
            aVar.ge();
        }
    }

    private void fG() {
        this.JT.clear();
        this.oV.clear();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        l lVar = this.oR;
        if (lVar != null) {
            lVar.release();
        }
        g gVar = this.oU;
        if (gVar != null) {
            gVar.release();
        }
        Set<com.kwad.components.ad.reward.d.e> set = this.oY;
        if (set != null) {
            set.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI() {
        int size = this.oV.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            com.kwad.components.ad.reward.d.f poll = this.oV.poll();
            if (poll != null) {
                poll.bM();
            }
            i = i2 + 1;
        }
    }

    private static com.kwad.components.ad.reward.h.kwai.b g(j jVar) {
        if (com.kwad.sdk.core.response.a.a.cp(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate)) || com.kwad.sdk.core.response.a.a.cr(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate))) {
            d.b bVar = new d.b();
            bVar.setAdTemplate(jVar.mAdTemplate);
            bVar.aP("ksad-video-confirm-card");
            bVar.aQ(false);
            bVar.aR(true);
            return com.kwad.components.ad.reward.h.kwai.b.a(jVar, bVar);
        }
        return null;
    }

    public static boolean h(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.b.h(adInfo) && !com.kwad.components.ad.reward.kwai.b.l(adInfo);
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean o(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
    }

    public static boolean p(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.p(adTemplate);
    }

    public static boolean q(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.a.a.cv(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            return false;
        }
        return o(adTemplate) || p(adTemplate);
    }

    public final void A(boolean z) {
        this.pd = z;
        if (z) {
            fC();
        } else {
            fB();
        }
    }

    public final void B(boolean z) {
        com.kwad.components.ad.reward.g.c cVar = this.oZ;
        if (cVar == null) {
            return;
        }
        cVar.onPlayAgainClick(z);
    }

    public final void C(boolean z) {
        this.pE = z;
    }

    public final void D(boolean z) {
        this.pe = true;
    }

    public final void E(boolean z) {
        this.pj = z;
    }

    public final void F(boolean z) {
        this.ps = true;
    }

    public final void G(boolean z) {
        this.pD = true;
    }

    public final void H(boolean z) {
        this.pc = z;
    }

    public final void I(final boolean z) {
        if (z != this.mRewardVerifyCalled) {
            a(this.oX, new com.kwad.sdk.e.a<s>() { // from class: com.kwad.components.ad.reward.j.7
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.e.a
                /* renamed from: c */
                public void accept(s sVar) {
                    sVar.af(z);
                }
            });
        }
        this.mRewardVerifyCalled = z;
    }

    public final void N(int i) {
        this.pz = i;
    }

    public final void a(int i, Context context, int i2, int i3) {
        b(i, context, i2, i3);
    }

    public final void a(int i, Context context, int i2, int i3, long j) {
        a(1, context, 40, 1, j, false, null);
    }

    public final void a(int i, Context context, final int i2, int i3, long j, boolean z, final com.kwad.sdk.core.report.i iVar) {
        com.kwad.components.core.d.b.a.a(new a.C0349a(context).I(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).ap(i3).q(j).ao(i2).an(i).ap(fF()).b(this.oN.jG()).a(new a.b() { // from class: com.kwad.components.ad.reward.j.4
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                j.this.a(i2, iVar);
            }
        }));
    }

    public final void a(long j, long j2, int i) {
        for (com.kwad.components.ad.reward.d.e eVar : this.oY) {
            eVar.cg();
        }
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.pt.add(onDismissListener);
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.pJ = rewardRenderResult;
    }

    public final void a(com.kwad.components.ad.reward.d.m mVar) {
        this.pu = mVar;
    }

    public final void a(com.kwad.components.ad.reward.g.c cVar) {
        this.oZ = cVar;
    }

    public final void a(com.kwad.components.ad.reward.h.a aVar) {
        this.oW.add(aVar);
    }

    public final void a(s sVar) {
        this.oX.add(sVar);
    }

    public final void a(a aVar) {
        this.pK.add(aVar);
    }

    public final void a(b bVar) {
        this.pL.add(bVar);
    }

    public final void a(e.a aVar) {
        this.pb = aVar;
    }

    public final void a(a.InterfaceC0353a interfaceC0353a) {
        List<a.InterfaceC0353a> list = this.pM;
        if (list != null) {
            list.add(interfaceC0353a);
        }
    }

    public final void a(final com.kwad.components.core.g.c cVar) {
        final com.kwad.components.core.g.d H = KSRewardVideoActivityProxy.a.H(this.mAdTemplate.getUniqueId());
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.j.5
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.g.d dVar = H;
                if (dVar != null) {
                    dVar.c(cVar);
                }
            }
        });
    }

    public final void a(com.kwad.components.core.webview.a.d.a aVar) {
        this.pa = aVar;
    }

    public final void b(int i, Context context, int i2, int i3) {
        a(i, context, i2, i3, 0L, false, null);
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.pt.remove(onDismissListener);
    }

    public final void b(com.kwad.components.ad.reward.b.b bVar) {
        com.kwad.components.ad.reward.b.a.gQ().a(this.mAdTemplate, bVar);
    }

    public final void b(com.kwad.components.ad.reward.d.f fVar) {
        this.oV.offer(fVar);
    }

    public final void b(com.kwad.components.ad.reward.h.a aVar) {
        this.oW.remove(aVar);
    }

    public final void b(s sVar) {
        this.oX.remove(sVar);
    }

    public final void b(a aVar) {
        this.pK.remove(aVar);
    }

    public final void b(b bVar) {
        this.pL.remove(bVar);
    }

    public final void b(a.InterfaceC0353a interfaceC0353a) {
        List<a.InterfaceC0353a> list = this.pM;
        if (list != null) {
            list.remove(interfaceC0353a);
        }
    }

    public final void b(final com.kwad.components.core.g.c cVar) {
        final com.kwad.components.core.g.d H = KSRewardVideoActivityProxy.a.H(this.mAdTemplate.getUniqueId());
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.j.6
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.g.d dVar = H;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    public final void c(com.kwad.components.ad.reward.d.f fVar) {
        this.oV.remove(fVar);
    }

    public final void c(final boolean z, final boolean z2) {
        if (this.oN.jF()) {
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.j.9
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.oN.jG().setAudioEnabled(z, z2);
                }
            }, 500L);
        }
    }

    public final void d(DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.pt) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public final void d(PlayableSource playableSource) {
        this.pr = playableSource;
    }

    public final boolean fE() {
        return this.pd;
    }

    public final String fF() {
        if (this.mAdTemplate.tkLiveShopItemInfo == null) {
            return null;
        }
        return this.mAdTemplate.tkLiveShopItemInfo.itemId;
    }

    public final void fH() {
        if (isMainThread()) {
            fI();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.reward.j.3
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.fI();
                }
            });
        }
    }

    public final int fJ() {
        return this.pz;
    }

    public final boolean fK() {
        return this.pE;
    }

    public final void fL() {
        com.kwad.components.core.webview.a.d.a aVar = this.pa;
        if (aVar == null) {
            return;
        }
        aVar.cr();
    }

    public final boolean fM() {
        return this.pe;
    }

    public final boolean fN() {
        return this.pj;
    }

    public final PlayableSource fO() {
        return this.pr;
    }

    public final boolean fP() {
        return this.ps;
    }

    public final List<a.InterfaceC0353a> fQ() {
        return this.pM;
    }

    public final e.a fR() {
        return this.pb;
    }

    public final RewardRenderResult fS() {
        return this.pJ;
    }

    public final boolean fT() {
        return RewardRenderResult.NEO_TK.equals(this.pJ);
    }

    public final boolean fU() {
        return RewardRenderResult.LIVE_TK.equals(this.pJ);
    }

    public final boolean fV() {
        return this.pD;
    }

    public final boolean fW() {
        return this.pc;
    }

    public final boolean fX() {
        return this.mRewardVerifyCalled;
    }

    @Override // com.kwad.components.core.j.a, com.kwad.sdk.mvp.a
    public final void release() {
        fG();
        this.oN.release();
    }

    public final void releaseSync() {
        fG();
        this.oN.releaseSync();
    }
}
