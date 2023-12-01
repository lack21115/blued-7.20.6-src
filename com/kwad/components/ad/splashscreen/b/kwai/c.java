package com.kwad.components.ad.splashscreen.b.kwai;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/kwai/c.class */
public final class c extends com.kwad.components.ad.splashscreen.b.e implements View.OnClickListener, com.kwad.sdk.widget.c {
    private CloseCountDownView DG;
    private ViewGroup DH;
    private ViewGroup DI;
    private ImageView DJ;
    private TextView DK;
    private TextView DL;
    private CloseCountDownView.a DM = new CloseCountDownView.a() { // from class: com.kwad.components.ad.splashscreen.b.kwai.c.1
        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void dP() {
            y.a aVar = new y.a();
            if (c.this.Cg.mTimerHelper != null) {
                aVar.duration = c.this.Cg.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.report.a.b(c.this.Cg.mAdTemplate, new i().bk(1).a(aVar).bp(6), (JSONObject) null);
            c.this.Cg.ky();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void kJ() {
            y.a aVar = new y.a();
            if (c.this.Cg.mTimerHelper != null) {
                aVar.duration = c.this.Cg.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.report.a.b(c.this.Cg.mAdTemplate, new i().bk(14).a(aVar).bp(6), (JSONObject) null);
            c.this.Cg.kB();
        }
    };

    private void s(View view) {
        if (view == this.DH) {
            this.Cg.c(2, view.getContext(), 104, 2);
        } else if (view == this.DI) {
            this.Cg.c(2, view.getContext(), 26, 1);
        } else if (view == this.DJ) {
            this.Cg.c(2, view.getContext(), 15, 2);
        } else if (view == this.DK) {
            this.Cg.c(2, view.getContext(), 16, 2);
        } else if (view == this.DL) {
            this.Cg.c(2, view.getContext(), 17, 2);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        s(view);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.DG.setOnViewClickListener(this.DM);
        this.DI.setOnClickListener(this);
        new com.kwad.sdk.widget.f(this.DI.getContext(), this.DI, this);
        if (com.kwad.sdk.core.response.a.b.cG(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate))) {
            this.DH.setOnClickListener(this);
            this.DJ.setOnClickListener(this);
            this.DK.setOnClickListener(this);
            this.DL.setOnClickListener(this);
            new com.kwad.sdk.widget.f(this.DI.getContext(), this.DH, this);
            new com.kwad.sdk.widget.f(this.DI.getContext(), this.DJ, this);
            new com.kwad.sdk.widget.f(this.DI.getContext(), this.DK, this);
            new com.kwad.sdk.widget.f(this.DI.getContext(), this.DL, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        s(view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.DG = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
        this.DH = (ViewGroup) findViewById(R.id.ksad_splash_end_card_giftbox_view);
        this.DI = (ViewGroup) findViewById(R.id.ksad_splash_endcard_actionbar);
        this.DJ = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.DK = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.DL = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
    }
}
