package com.huawei.openalliance.ad.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.ey;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gw;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.jk;
import com.huawei.hms.ads.jw;
import com.huawei.hms.ads.ki;
import com.huawei.hms.ads.lh;
import com.huawei.hms.ads.lj;
import com.huawei.hms.ads.ls;
import com.huawei.hms.ads.lu;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/SmartScreenSplashView.class */
public class SmartScreenSplashView extends RelativeLayout implements lh, ls {
    private AdSlotParam B;
    private com.huawei.openalliance.ad.inter.listeners.b C;
    protected fk Code;
    private ki D;
    private com.huawei.openalliance.ad.inter.listeners.a F;
    private int I;
    private SloganView L;
    private gz S;

    /* renamed from: a  reason: collision with root package name */
    private View f9434a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private lj f9435c;
    private TextView d;
    private PPSCircleProgressBar e;
    private PPSLabelView f;
    private TextView g;
    private int h;
    private RelativeLayout i;
    private RelativeLayout j;
    private long k;
    private int l;
    private final String m;
    private long n;
    private boolean o;
    private boolean p;
    private int q;
    private a r;
    private float s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/SmartScreenSplashView$a.class */
    public static class a extends BroadcastReceiver {
        private WeakReference<lj> Code;

        public a(lj ljVar) {
            this.Code = new WeakReference<>(ljVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            lj ljVar;
            if (intent == null || !"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) || (ljVar = this.Code.get()) == null || !(ljVar instanceof PPSVideoView)) {
                return;
            }
            ((PPSVideoView) ljVar).L();
        }
    }

    public SmartScreenSplashView(Context context) {
        super(context);
        this.I = 0;
        this.h = 0;
        this.l = 0;
        this.m = "skip_btn_delay_id_" + hashCode();
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = 0.18f;
        Code(context);
    }

    public SmartScreenSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 0;
        this.h = 0;
        this.l = 0;
        this.m = "skip_btn_delay_id_" + hashCode();
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = 0.18f;
        Code(context);
    }

    public SmartScreenSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = 0;
        this.h = 0;
        this.l = 0;
        this.m = "skip_btn_delay_id_" + hashCode();
        this.o = false;
        this.p = false;
        this.q = 1;
        this.s = 0.18f;
        Code(context);
    }

    private void Code(Context context) {
        V(context);
        this.Code = fk.Code(context.getApplicationContext());
        this.D = new jw(context.getApplicationContext(), this);
        this.l = this.Code.ab();
    }

    private void Code(lj ljVar) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        if (this.r == null) {
            this.r = new a(ljVar);
        }
        getContext().registerReceiver(this.r, intentFilter);
    }

    private void S() {
        if (this.d == null || this.e == null) {
            return;
        }
        int i = this.l;
        if (i > 0) {
            ge.V("SmartScreenSplashView", "%d delay, skip btn show", Integer.valueOf(i));
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.SmartScreenSplashView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SmartScreenSplashView.this.d != null) {
                        ge.Code("SmartScreenSplashView", "skip hint show");
                        SmartScreenSplashView.this.d.setVisibility(0);
                    }
                    if (SmartScreenSplashView.this.e != null) {
                        ge.Code("SmartScreenSplashView", "coutDownView show");
                        SmartScreenSplashView.this.e.setVisibility(0);
                    }
                    SmartScreenSplashView.this.p = true;
                }
            }, this.m, this.l);
            return;
        }
        ge.V("SmartScreenSplashView", "direct show skip hint");
        this.p = true;
        this.d.setVisibility(0);
        this.e.setVisibility(0);
    }

    private void V(Context context) {
        inflate(context, v.d(context) ? R.layout.hiad_view_tv_splash_ad_elderly : R.layout.hiad_view_tv_splash_ad, this);
        this.i = (RelativeLayout) findViewById(R.id.rl_splash_container);
        this.j = (RelativeLayout) findViewById(R.id.hiad_logo_container);
        this.d = (TextView) findViewById(R.id.hiad_skip_text);
        this.e = (PPSCircleProgressBar) findViewById(R.id.hiad_count_progress);
        this.f = (PPSLabelView) findViewById(R.id.hiad_ad_label);
        this.g = (TextView) findViewById(R.id.hiad_ad_source);
        setFocusable(true);
    }

    private void V(AdContentData adContentData) {
        MetaData Z;
        if (adContentData == null) {
            return;
        }
        if (this.f != null) {
            String n = adContentData.n();
            if (TextUtils.isEmpty(n)) {
                this.f.setVisibility(8);
            } else {
                MetaData Z2 = adContentData.Z();
                if (Z2 == null || AdSource.Code(Z2.i()) == null) {
                    this.f.setText(n);
                } else {
                    this.f.V(AdSource.Code(Z2.i()), n);
                }
                this.f.setVisibility(0);
            }
        }
        if (this.g == null || (Z = adContentData.Z()) == null) {
            return;
        }
        String V = au.V(Z.F());
        if (TextUtils.isEmpty(V)) {
            this.g.setVisibility(8);
            return;
        }
        this.g.setText(V);
        this.g.setVisibility(0);
    }

    private void setVisibleAndBringToFont(View view) {
        if (view != null) {
            view.setVisibility(0);
            view.bringToFront();
        }
    }

    @Override // com.huawei.hms.ads.lh
    public Integer Code(AdContentData adContentData) {
        return null;
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(int i) {
        gv Code = gw.Code(i, this);
        this.S = Code;
        Code.Code(this.C);
        this.S.Code(this.F);
        this.S.Code(this.I);
        this.S.V(this.k);
        this.S.k();
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(int i, int i2, String str, boolean z, Integer num) {
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(int i, boolean z) {
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(View view) {
    }

    public void Code(View view, int i) {
        this.b = view;
        view.setVisibility(i);
        this.h = i;
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(lj ljVar, Integer num) {
        if (ay.D(getContext())) {
            ge.I("SmartScreenSplashView", "showAdView - activity finished, not add view");
        } else if (ljVar == null || !(ljVar instanceof View)) {
        } else {
            View view = (View) ljVar;
            this.f9435c = ljVar;
            ljVar.setAudioFocusType(this.q);
            Code(this.f9435c);
            ViewParent parent = view.getParent();
            if (parent == this.i) {
                view.setVisibility(0);
                return;
            }
            if (parent != null && (parent instanceof ViewGroup)) {
                ge.V("SmartScreenSplashView", "showAdView, remove adView.");
                ((ViewGroup) parent).removeView(view);
            } else if (parent != null) {
                return;
            }
            setVisibleAndBringToFont(this.j);
            setVisibleAndBringToFont(this.b);
            this.i.addView(view, new RelativeLayout.LayoutParams(-1, -1));
            view.setVisibility(0);
        }
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(lu luVar) {
        View view = this.f9434a;
        if (view != null) {
            view.setVisibility(0);
            new jk(this.Code, luVar).V();
            return;
        }
        SloganView sloganView = this.L;
        if (sloganView == null) {
            ge.V("SmartScreenSplashView", "create default slogan");
            setSloganResId(R.drawable.hiad_default_slogan);
            sloganView = this.L;
            if (sloganView == null) {
                return;
            }
        }
        sloganView.setSloganShowListener(luVar);
        this.L.Code();
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(AdContentData adContentData, int i) {
        ge.Code("SmartScreenSplashView", "showLabelView and logo.");
        if (this.d != null && this.e != null) {
            if (adContentData != null && adContentData.Z() != null && adContentData.h() == 9) {
                long h = adContentData.Z().h();
                this.n = h;
                this.e.Code(0, au.Code(Integer.valueOf((int) ((((float) h) * 1.0f) / 1000.0f))));
            }
            S();
        }
        if (this.j != null && this.b != null) {
            ge.V("SmartScreenSplashView", "show logo, visibility: %s", Integer.valueOf(this.h));
            this.j.addView(this.b);
            this.b.setVisibility(this.h);
        }
        V(adContentData);
    }

    @Override // com.huawei.hms.ads.lh
    public void I(int i) {
        int i2 = 0;
        ge.Code("SmartScreenSplashView", "update left time, total: %s, left: %s", Long.valueOf(this.n), Integer.valueOf(i));
        long j = this.n;
        if (j > 0) {
            i2 = (int) ((1.0d - ag.Code(Double.valueOf(((i - 1) * 1000) / j), 2, 4).doubleValue()) * 100.0d);
        }
        int i3 = i2;
        if (i2 >= 100) {
            i3 = 100;
        }
        PPSCircleProgressBar pPSCircleProgressBar = this.e;
        if (pPSCircleProgressBar != null) {
            pPSCircleProgressBar.Code(i3, au.Code(Integer.valueOf(i)));
        }
    }

    @Override // com.huawei.hms.ads.lh
    public lj V(int i) {
        if (i != 2) {
            if (i != 9) {
                return null;
            }
            PPSVideoView pPSVideoView = new PPSVideoView(getContext(), this.B.V(), 0, this.B.I(), 18);
            pPSVideoView.setHideSoundIcon(true);
            pPSVideoView.setIgnoreSoundCtrl(false);
            pPSVideoView.setStartVol(this.s);
            return pPSVideoView;
        }
        return new PPSImageView(getContext());
    }

    @Override // com.huawei.hms.ads.lh
    public void V() {
        SloganView sloganView = this.L;
        if (sloganView != null) {
            sloganView.V();
        }
        View view = this.f9434a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.huawei.hms.ads.ls
    public void destroyView() {
        ge.V("SmartScreenSplashView", "destroyView ");
        lj ljVar = this.f9435c;
        if (ljVar != null) {
            ljVar.destroyView();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        gz gzVar;
        ge.V("SmartScreenSplashView", "dispatchKeyEvent:" + keyEvent.getKeyCode() + ", " + keyEvent.getAction());
        if (this.p && 4 == keyEvent.getKeyCode() && keyEvent.getAction() == 1 && (gzVar = this.S) != null) {
            gzVar.Code(0, 0);
            return true;
        }
        return true;
    }

    public com.huawei.openalliance.ad.inter.listeners.b getAdListener() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.lh
    public AdSlotParam getAdSlotParam() {
        AdSlotParam adSlotParam = this.B;
        if (adSlotParam != null) {
            adSlotParam.Code(18);
        }
        return this.B;
    }

    @Override // com.huawei.hms.ads.lh
    public int getAdType() {
        return 18;
    }

    @Override // com.huawei.hms.ads.lh
    public int getAudioFocusType() {
        return 0;
    }

    @Override // com.huawei.hms.ads.hr
    public View getOpenMeasureView() {
        return this;
    }

    public float getStartMaxVol() {
        return this.s;
    }

    public String getUniqueId() {
        return null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        gz gzVar;
        ge.V("SmartScreenSplashView", "onKeyDown, keyCode: %s", Integer.valueOf(keyEvent.getKeyCode()));
        if (this.p && 4 == keyEvent.getKeyCode() && keyEvent.getAction() == 1 && (gzVar = this.S) != null) {
            gzVar.Code(0, 0);
            return false;
        }
        return false;
    }

    @Override // com.huawei.hms.ads.ls
    public void pauseView() {
        ge.V("SmartScreenSplashView", "pauseView ");
        lj ljVar = this.f9435c;
        if (ljVar != null) {
            ljVar.pauseView();
        }
        if (getContext() != null) {
            try {
                if (this.r != null) {
                    getContext().unregisterReceiver(this.r);
                    this.r = null;
                }
            } catch (Throwable th) {
                ge.I("SmartScreenSplashView", "unregister err: %s", th.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.ls
    public void resumeView() {
        ge.V("SmartScreenSplashView", "resumeView ");
        lj ljVar = this.f9435c;
        if (ljVar != null) {
            ljVar.resumeView();
        }
    }

    public void setAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.F = aVar;
        gz gzVar = this.S;
        if (gzVar != null) {
            gzVar.Code(aVar);
        }
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.C = bVar;
        this.D.Code(bVar);
        gz gzVar = this.S;
        if (gzVar != null) {
            gzVar.Code(bVar);
        }
    }

    public void setAdSlotParam(AdSlotParam adSlotParam) {
        if (v.Code(getContext())) {
            int B = com.huawei.openalliance.ad.utils.c.B(getContext(), adSlotParam.V());
            int C = com.huawei.openalliance.ad.utils.c.C(getContext(), adSlotParam.V());
            adSlotParam.Z(B);
            adSlotParam.B(C);
            adSlotParam.I(8);
            adSlotParam.L(Integer.valueOf(this.I));
            int i = 0;
            adSlotParam.Z((Integer) 0);
            if (!HiAd.Code(getContext()).isNewProcess() || !com.huawei.openalliance.ad.utils.c.L(getContext())) {
                i = 1;
            }
            adSlotParam.B(Integer.valueOf(i));
            this.B = adSlotParam;
            com.huawei.openalliance.ad.inter.h Code = com.huawei.openalliance.ad.inter.g.Code(getContext());
            if (Code instanceof com.huawei.openalliance.ad.inter.g) {
                ((com.huawei.openalliance.ad.inter.g) Code).I(adSlotParam);
            }
        }
    }

    public void setAudioFocusType(int i) {
        this.q = i;
        lj ljVar = this.f9435c;
        if (ljVar != null) {
            ljVar.setAudioFocusType(i);
        }
    }

    public void setLinkedSupportMode(int i) {
        this.I = i;
    }

    public void setLogo(View view) {
        Code(view, 0);
    }

    public void setSloganResId(int i) {
        if (v.Code(getContext())) {
            if (ay.D(getContext())) {
                ge.I("SmartScreenSplashView", "setSloganResId - activity finished, not add view");
            } else if (this.B == null) {
                throw new ey("Must invoke SplashAdView's setAdSlotParam method before invoke setSloganResId method");
            } else {
                if (this.L == null) {
                    SloganView sloganView = new SloganView(getContext(), this.B.V(), i, 18);
                    this.L = sloganView;
                    this.i.addView(sloganView, new RelativeLayout.LayoutParams(-1, -1));
                    this.L.V();
                }
            }
        }
    }

    public void setSloganView(View view) {
        if (view != null) {
            this.f9434a = view;
            view.setVisibility(8);
        }
    }

    public void setStartMaxVol(float f) {
        if (f < 0.0f || f > 1.0f) {
            ge.I("SmartScreenSplashView", "valid max vol is from 0.0 to 1.0");
            return;
        }
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        ge.V("SmartScreenSplashView", "music max %s, current %s， maxVol： %s", Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f));
        float f2 = streamVolume;
        float f3 = streamMaxVolume * 1.0f * f;
        float floatValue = f2 * 1.0f < f3 ? 1.0f : Float.valueOf(f3 / f2).floatValue();
        if (ge.Code()) {
            ge.Code("SmartScreenSplashView", "maxVol end: %s", Float.valueOf(floatValue));
        }
        this.s = floatValue;
    }
}
