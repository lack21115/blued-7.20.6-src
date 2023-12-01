package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.kwad.components.ad.reward.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl.class */
public final class RewardActionBarControl {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private j qt;
    private b tZ;
    private e uc;
    private c ud;
    private d ue;
    private final long ug;
    private a uf = new a((byte) 0);
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean uh = false;
    private boolean ui = false;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl$ShowActionBarResult.class */
    public enum ShowActionBarResult {
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        TK,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE,
        SHOW_NATIVE_ORIGIN_LIVE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl$a.class */
    public static final class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        private List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> un;
        private ShowActionBarResult uo;

        private a() {
            this.un = new CopyOnWriteArrayList();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view) {
            com.kwad.sdk.core.d.b.d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
            this.uo = showActionBarResult;
            for (com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar : this.un) {
                aVar.a(showActionBarResult, view);
            }
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.un.add(aVar);
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.un.remove(aVar);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl$b.class */
    public interface b {
        void a(boolean z, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl$c.class */
    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl$d.class */
    public interface d {
        void f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/actionbar/RewardActionBarControl$e.class */
    public interface e {
        boolean g(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public RewardActionBarControl(j jVar, Context context, AdTemplate adTemplate) {
        this.qt = jVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        long aQ = !com.kwad.sdk.core.response.a.a.ck(this.mAdInfo) ? com.kwad.sdk.core.response.a.b.aQ(adTemplate) : 1000L;
        this.ug = aQ <= 0 ? 1000L : aQ;
    }

    private ShowActionBarResult T(boolean z) {
        c cVar;
        d dVar;
        if (j.d(this.qt) && (dVar = this.ue) != null) {
            dVar.f(this.uf);
            return ShowActionBarResult.TK;
        } else if (com.kwad.components.ad.reward.kwai.b.j(this.mAdInfo) && (cVar = this.ud) != null) {
            cVar.e(this.uf);
            return ShowActionBarResult.SHOW_ORDER;
        } else if (!com.kwad.sdk.core.response.a.b.aR(this.mAdTemplate) || this.uc == null) {
            U(z);
            return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
        } else {
            com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar success in " + this.ug);
            return this.uc.g(this.uf) ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(boolean z) {
        if (this.tZ != null) {
            com.kwad.sdk.core.d.b.d("ActionBarControl", "showNativeActionBar");
            this.ui = true;
            this.tZ.a(z, this.uf);
        }
    }

    public static void a(final com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, final View view, final ShowActionBarResult showActionBarResult) {
        if (aVar != null) {
            view.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.ad.reward.presenter.platdetail.actionbar.a.this.a(showActionBarResult, view);
                }
            });
        }
    }

    static /* synthetic */ boolean a(RewardActionBarControl rewardActionBarControl, boolean z) {
        rewardActionBarControl.uh = true;
        return true;
    }

    public final void S(boolean z) {
        ShowActionBarResult T = T(z);
        com.kwad.sdk.core.d.b.d("ActionBarControl", "showActionBarOnVideoStart result: " + T);
        if (T != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // java.lang.Runnable
            public final void run() {
                RewardActionBarControl.a(RewardActionBarControl.this, true);
                com.kwad.sdk.core.d.b.d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.uc != null && !RewardActionBarControl.this.ui && RewardActionBarControl.this.uc.g(RewardActionBarControl.this.uf)) {
                    com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.ug);
                    return;
                }
                com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.ug);
                com.kwad.components.core.m.a.pb().e(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.ug);
                com.kwad.components.ad.reward.monitor.a.a(RewardActionBarControl.this.qt.pf, "play_card", com.kwad.sdk.core.response.a.b.aP(RewardActionBarControl.this.qt.mAdTemplate), RewardActionBarControl.this.ug, 1);
                RewardActionBarControl.this.U(true);
            }
        }, this.ug);
    }

    public final void a(b bVar) {
        this.tZ = bVar;
    }

    public final void a(c cVar) {
        this.ud = cVar;
    }

    public final void a(d dVar) {
        this.ue = dVar;
    }

    public final void a(e eVar) {
        this.uc = eVar;
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.uf.c(aVar);
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.uf.d(aVar);
    }

    public final void hZ() {
        if (this.uh) {
            com.kwad.sdk.core.d.b.i("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        T(true);
    }

    public final ShowActionBarResult ia() {
        return this.uf.uo;
    }
}
