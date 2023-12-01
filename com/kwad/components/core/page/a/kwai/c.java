package com.kwad.components.core.page.a.kwai;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/kwai/c.class */
public final class c extends a {
    private LinearLayout LN;
    private TextView LO;
    private TextView LP;
    private TextView LQ;
    private TextView LR;
    private int LS;
    private boolean counterPaused = false;
    private boolean LT = false;
    private Runnable LU = new Runnable() { // from class: com.kwad.components.core.page.a.kwai.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.counterPaused) {
                bi.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (c.this.LS <= 0) {
                c.this.LO.setText("任务已完成");
                c.this.LP.setVisibility(8);
                c.this.LQ.setVisibility(8);
                c.this.LR.setVisibility(8);
                com.kwad.components.ad.a.g gVar = (com.kwad.components.ad.a.g) com.kwad.sdk.components.c.f(com.kwad.components.ad.a.g.class);
                if (gVar != null && !c.this.LT) {
                    gVar.notifyRewardVerify();
                }
            } else {
                c.this.on();
                bi.runOnUiThreadDelay(this, 1000L);
            }
            c.i(c.this);
        }
    };
    private final com.kwad.sdk.core.b.c wK = new com.kwad.sdk.core.b.d() { // from class: com.kwad.components.core.page.a.kwai.c.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityPaused(Activity activity) {
            super.onActivityPaused(activity);
            c.this.counterPaused = true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            c.this.counterPaused = false;
        }
    };

    static /* synthetic */ int i(c cVar) {
        int i = cVar.LS;
        cVar.LS = i - 1;
        return i;
    }

    private void om() {
        this.LN.setVisibility(0);
        if (!this.LG.mAdTemplate.mRewardVerifyCalled) {
            on();
            bi.runOnUiThreadDelay(this.LU, 1000L);
            return;
        }
        this.LO.setText("任务已完成");
        this.LP.setVisibility(8);
        this.LQ.setVisibility(8);
        this.LR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on() {
        this.LP.setText(oo());
        this.LR.setText(op());
    }

    private String oo() {
        int i = this.LS / 60;
        StringBuilder sb = i >= 10 ? new StringBuilder() : new StringBuilder("0");
        sb.append(i);
        return sb.toString();
    }

    private String op() {
        int i = this.LS % 60;
        StringBuilder sb = i >= 10 ? new StringBuilder() : new StringBuilder("0");
        sb.append(i);
        return sb.toString();
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(this.wK);
        this.LS = com.kwad.sdk.core.config.d.uA();
        om();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.LN = (LinearLayout) findViewById(R.id.ksad_reward_land_page_open_tip);
        this.LO = (TextView) findViewById(R.id.ksad_reward_land_page_open_desc);
        this.LP = (TextView) findViewById(R.id.ksad_reward_land_page_open_minute);
        this.LQ = (TextView) findViewById(R.id.ksad_reward_land_page_open_colon);
        this.LR = (TextView) findViewById(R.id.ksad_reward_land_page_open_second);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.b(this.wK);
        bi.b(this.LU);
    }
}
