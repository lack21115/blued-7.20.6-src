package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.dr;
import com.huawei.hms.ads.dt;
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
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.splash.R;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.d;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ax;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSSplashView.class */
public class PPSSplashView extends RelativeLayout implements lh, ls {
    private PPSSplashSwipeView A;
    protected fk B;
    protected long C;
    SloganView Code;
    private View D;
    private PPSSplashTwistView E;
    private AdSlotParam F;
    private PPSSplashSwipeClickView G;
    private PPSSplashTwistClickView H;
    PPSSkipButton I;
    private b J;
    private InteractCfg K;
    private int L;
    RelativeLayout V;

    /* renamed from: a  reason: collision with root package name */
    private PPSWLSView f23029a;
    private PPSSplashAdSourceView b;

    /* renamed from: c  reason: collision with root package name */
    private gz f23030c;
    private ki d;
    private com.huawei.openalliance.ad.inter.listeners.b e;
    private com.huawei.openalliance.ad.inter.listeners.a f;
    private boolean g;
    private int h;
    private Bitmap i;
    private View j;
    private lj k;
    private int l;
    private String m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private View t;
    private boolean u;
    private int v;
    private final String w;
    private int x;
    private RewardVerifyConfig y;
    private PPSSplashProView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSSplashView$a.class */
    public static class a implements View.OnClickListener {
        private WeakReference<PPSSplashView> Code;
        private AdContentData V;

        public a(PPSSplashView pPSSplashView, AdContentData adContentData) {
            this.Code = new WeakReference<>(pPSSplashView);
            this.V = adContentData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            final PPSSplashView pPSSplashView = this.Code.get();
            if (pPSSplashView != null) {
                final int[] choiceViewLoc = pPSSplashView.f23029a.getChoiceViewLoc();
                final int[] choiceViewSize = pPSSplashView.f23029a.getChoiceViewSize();
                if (v.Code(choiceViewLoc, 2) && v.Code(choiceViewSize, 2)) {
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pPSSplashView.Code(a.this.V, choiceViewLoc, choiceViewSize);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSSplashView$b.class */
    public class b implements d.b {
        private b() {
        }

        @Override // com.huawei.openalliance.ad.inter.d.b
        public void Code() {
            ge.V("PPSSplashView", "onStart");
            PPSSplashView.this.c();
        }
    }

    public PPSSplashView(Context context) {
        super(context);
        this.L = 8;
        this.g = false;
        this.l = 0;
        this.n = 0;
        this.o = 1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.u = true;
        this.v = 0;
        this.w = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    public PPSSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = 8;
        this.g = false;
        this.l = 0;
        this.n = 0;
        this.o = 1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.u = true;
        this.v = 0;
        this.w = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    public PPSSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.L = 8;
        this.g = false;
        this.l = 0;
        this.n = 0;
        this.o = 1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.u = true;
        this.v = 0;
        this.w = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    private void B() {
        String str;
        int I;
        int i;
        int i2;
        int i3;
        View view;
        try {
            if (this.j == null) {
                View inflate = ((ViewStub) findViewById(R.id.hiad_logo_stub)).inflate();
                this.j = inflate;
                inflate.setId(R.id.hiad_full_logo_region);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            if (1 == this.F.V()) {
                L();
                if (this.p > 0) {
                    ge.Code("PPSSplashView", "left: %s, top: %s, right: %s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin));
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + this.p, layoutParams.rightMargin, layoutParams.bottomMargin);
                    view = this.j;
                }
                D();
                S();
            }
            ge.V("PPSSplashView", "showFullModeLogo, orientation: %s, leftNotchHeight: %s", Integer.valueOf(this.F.V()), Integer.valueOf(this.q));
            ge.Code("PPSSplashView", "left:%s, top:%s, right:%s, leftNotchHeight:%s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin), Integer.valueOf(this.q));
            if (!dt.V(getContext()) || this.q <= 0) {
                if (!dt.V(getContext()) || (dt.V(getContext()) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 && !l.B(getContext()))) {
                    if (layoutParams.isMarginRelative()) {
                        layoutParams.setMarginStart(ay.I(getContext()));
                    } else {
                        I = ay.I(getContext());
                        i = layoutParams.topMargin;
                        i2 = layoutParams.rightMargin;
                        i3 = layoutParams.bottomMargin;
                        layoutParams.setMargins(I, i, i2, i3);
                    }
                }
                layoutParams.topMargin += v.V(getContext(), 12.0f);
                view = this.j;
            } else if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin + this.q);
                layoutParams.topMargin += v.V(getContext(), 12.0f);
                view = this.j;
            } else {
                I = layoutParams.leftMargin + this.q;
                i = layoutParams.topMargin;
                i2 = layoutParams.rightMargin;
                i3 = layoutParams.bottomMargin;
                layoutParams.setMargins(I, i, i2, i3);
                layoutParams.topMargin += v.V(getContext(), 12.0f);
                view = this.j;
            }
            view.setLayoutParams(layoutParams);
            D();
            S();
        } catch (Resources.NotFoundException e) {
            str = "showFullModeLogo res not found";
            ge.I("PPSSplashView", str);
        } catch (Exception e2) {
            str = "showFullModeLogo " + e2.getClass().getSimpleName();
            ge.I("PPSSplashView", str);
        }
    }

    private void C() {
        if (this.j == null) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.1
            @Override // java.lang.Runnable
            public void run() {
                PPSSplashView.this.S();
            }
        });
    }

    private PPSSkipButton Code(String str, int i, String str2, boolean z, float f, int i2) {
        boolean z2;
        PPSSkipButton pPSSkipButton;
        int V = this.F.V();
        int I = this.F.I();
        L();
        if (1 == V) {
            pPSSkipButton = new PPSSkipButton(getContext(), str, V, I, i, str2, z, this.p, f, i2, false);
        } else {
            ge.V("PPSSplashView", "createSkipAdButton, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(V), Integer.valueOf(this.q), Integer.valueOf(this.r));
            int i3 = this.q;
            if (i3 > 0) {
                z2 = true;
            } else {
                i3 = this.r;
                z2 = false;
            }
            pPSSkipButton = new PPSSkipButton(getContext(), str, V, I, i, str2, z, i3, f, i2, z2);
        }
        pPSSkipButton.setAdMediator(this.f23030c);
        return pPSSkipButton;
    }

    private void Code(int i, String str, boolean z) {
        ge.V("PPSSplashView", "showClickButton");
        b();
        this.z.setVisibility(i == 0 ? 4 : 0);
        PPSSplashProView pPSSplashProView = this.z;
        if (!TextUtils.isEmpty(this.B.x())) {
            str = this.B.x();
        }
        pPSSplashProView.setDesc(str);
        this.z.setOrientation(this.F.V());
        this.z.Code(z, i);
    }

    private void Code(Context context) {
        V(context);
        this.d = new jw(context, this);
        this.B = fk.Code(context);
        this.x = l.I(context.getApplicationContext());
        this.J = new b();
        com.huawei.openalliance.ad.inter.d.Code(context.getApplicationContext()).Code(this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, int[] iArr, int[] iArr2) {
        if (v.Code(iArr, 2) && v.Code(iArr2, 2) && adContentData != null) {
            if (ge.Code()) {
                ge.Code("PPSSplashView", "addComplianceDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                ge.Code("PPSSplashView", "addComplianceDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            PPSAdvertiserInfoDialog pPSAdvertiserInfoDialog = new PPSAdvertiserInfoDialog(getContext(), iArr, iArr2);
            addView(pPSAdvertiserInfoDialog, layoutParams);
            pPSAdvertiserInfoDialog.setScreenWidth(getMeasuredWidth());
            pPSAdvertiserInfoDialog.setScreenHeight(getMeasuredHeight());
            pPSAdvertiserInfoDialog.setAdContent(adContentData);
        }
    }

    private void Code(boolean z, int i) {
        PPSSplashSwipeClickView pPSSplashSwipeClickView;
        ge.V("PPSSplashView", "showNewStyle, cfg= %s", Integer.valueOf(i));
        if (1 == i) {
            PPSSplashSwipeView pPSSplashSwipeView = this.A;
            if (pPSSplashSwipeView == null) {
                return;
            }
            pPSSplashSwipeView.setVisibility(0);
            this.A.Code(getSwipeInteractDesc(), getSwipeJumpDesc());
            this.A.setOrientation(this.F.V());
            this.A.setShowLogo(z);
        } else if (2 == i) {
            PPSSplashTwistView pPSSplashTwistView = this.E;
            if (pPSSplashTwistView == null) {
                return;
            }
            pPSSplashTwistView.setVisibility(0);
            this.E.Code(getTwistInteractDesc(), getTwistJumpDesc());
            this.E.setOrientation(this.F.V());
            this.E.setShowLogo(z);
        } else if (3 == i) {
            PPSSplashTwistClickView pPSSplashTwistClickView = this.H;
            if (pPSSplashTwistClickView == null) {
                return;
            }
            pPSSplashTwistClickView.setVisibility(0);
            this.H.Code(getTwistClkInteractDesc(), getTwistJumpDesc());
            this.H.setOrientation(this.F.V());
            this.H.setShowLogo(z);
        } else if (4 != i || (pPSSplashSwipeClickView = this.G) == null) {
        } else {
            pPSSplashSwipeClickView.setVisibility(0);
            this.G.Code(getSwipeClkInteractDesc(), getSwipeJumpDesc());
            this.G.setOrientation(this.F.V());
            this.G.setShowLogo(z);
        }
    }

    private boolean Code(Long l) {
        if (l == null) {
            return false;
        }
        long ag = fk.Code(getContext()).ag();
        return ag == -1 || System.currentTimeMillis() < (ag * 86400000) + l.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        View view = this.j;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.hiad_full_mode_logo);
        int i = this.h;
        if (i > 0) {
            imageView.setImageResource(i);
        } else {
            Bitmap bitmap = this.i;
            if (bitmap == null) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
        imageView.setVisibility(0);
    }

    private void F() {
        if (this.j == null) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.2
            @Override // java.lang.Runnable
            public void run() {
                PPSSplashView.this.D();
            }
        });
    }

    private int I(AdContentData adContentData) {
        return (adContentData.av() == null || adContentData.av().Code() == null) ? this.B.w() : adContentData.av().Code().intValue();
    }

    private static boolean I(Context context) {
        boolean z = true;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            z = true;
            if (!activity.isFinishing()) {
                if (activity.isDestroyed()) {
                    return true;
                }
                z = false;
            }
        }
        return z;
    }

    private void L() {
        if (this.p > 0 || dt.Code(getContext().getApplicationContext()).Code(getContext().getApplicationContext())) {
            return;
        }
        this.p = v.e(getContext().getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        View view = this.j;
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.hiad_media_name);
        int i = this.l;
        if (i > 0) {
            textView.setText(i);
        } else {
            String str = this.m;
            if (str == null) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(str);
        }
        textView.setVisibility(0);
    }

    private void V(Context context) {
        inflate(context, R.layout.hiad_view_splash_ad, this);
        this.V = (RelativeLayout) findViewById(R.id.rl_splash_container);
        this.f23029a = (PPSWLSView) findViewById(R.id.splash_wls_view);
        this.b = (PPSSplashAdSourceView) findViewById(R.id.splash_ad_source_view);
        this.u = dt.Code(context).V();
        this.z = (PPSSplashProView) findViewById(R.id.hiad_splash_pro_view);
        this.A = (PPSSplashSwipeView) findViewById(R.id.hiad_splash_swipe_view);
        this.E = (PPSSplashTwistView) findViewById(R.id.hiad_splash_twist_view);
        this.H = (PPSSplashTwistClickView) findViewById(R.id.hiad_splash_twist_click_view);
        this.G = (PPSSplashSwipeClickView) findViewById(R.id.hiad_splash_swipe_click_view);
    }

    private void V(AdContentData adContentData) {
        int i;
        boolean z;
        PPSSplashAdSourceView pPSSplashAdSourceView;
        boolean z2;
        boolean z3;
        int i2;
        boolean z4;
        PPSWLSView pPSWLSView;
        boolean z5;
        boolean z6;
        if (adContentData != null) {
            int V = this.F.V();
            Integer Code = Code(adContentData);
            InteractCfg av = adContentData.av();
            Integer B = av == null ? null : av.B();
            L();
            if (this.u) {
                this.b.setAdMediator(this.f23030c);
                this.b.Code(Code, B);
                this.b.setVisibility(0);
                if (1 == V) {
                    pPSSplashAdSourceView = this.b;
                    boolean z7 = adContentData.D() == 1;
                    i = this.p;
                    z3 = false;
                    z2 = z7;
                } else {
                    ge.V("PPSSplashView", "showAdLabel, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(V), Integer.valueOf(this.q), Integer.valueOf(this.r));
                    i = this.q;
                    if (i > 0) {
                        z = true;
                    } else {
                        i = this.r;
                        z = false;
                    }
                    pPSSplashAdSourceView = this.b;
                    if (adContentData.D() == 1) {
                        z2 = true;
                        z3 = z;
                    } else {
                        z2 = false;
                        z3 = z;
                    }
                }
                pPSSplashAdSourceView.Code(adContentData, z2, i, V, z3);
                return;
            }
            this.f23029a.setAdMediator(this.f23030c);
            this.f23029a.Code(Code, B);
            this.f23029a.setVisibility(0);
            if (1 == V) {
                pPSWLSView = this.f23029a;
                boolean z8 = adContentData.D() == 1;
                i2 = this.p;
                z6 = false;
                z5 = z8;
            } else {
                ge.V("PPSSplashView", "showAdLabel, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(V), Integer.valueOf(this.q), Integer.valueOf(this.r));
                i2 = this.q;
                if (i2 > 0) {
                    z4 = true;
                } else {
                    i2 = this.r;
                    z4 = false;
                }
                pPSWLSView = this.f23029a;
                if (adContentData.D() == 1) {
                    z5 = true;
                    z6 = z4;
                } else {
                    z5 = false;
                    z6 = z4;
                }
            }
            pPSWLSView.Code(adContentData, z5, i2, V, z6);
            if (aa.Code(adContentData.aG())) {
                return;
            }
            this.f23029a.setChoiceViewOnClickListener(new a(this, adContentData));
        }
    }

    private void V(AdContentData adContentData, int i) {
        String str;
        float f;
        int i2;
        String str2;
        if (I(getContext())) {
            ge.I("PPSSplashView", "addSkipAdButton - activity finished, not add view");
            return;
        }
        boolean z = false;
        if (adContentData != null) {
            if (adContentData.D() == 1) {
                z = true;
            }
            str2 = adContentData.V();
            String l = adContentData.l();
            f = adContentData.ab();
            i2 = adContentData.ac();
            str = l;
        } else {
            str = null;
            z = false;
            f = 0.0f;
            i2 = 0;
            str2 = null;
        }
        PPSSkipButton Code = Code(str2, i, str, z, f, i2);
        this.I = Code;
        Code.setId(R.id.hiad_btn_skip);
        addView(this.I);
        this.I.setVisibility(4);
    }

    private void Z() {
        List<String> Code = this.F.Code();
        this.d.Code(!aa.Code(Code) ? Code.get(0) : null, 1);
        this.d.C();
        com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).Code(false);
    }

    private void a() {
        if (this.I != null) {
            ge.Code("PPSSplashView", "%d delay, skip btn show", Integer.valueOf(this.v));
            if (this.v > 0) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSSplashView.this.I != null) {
                            ge.Code("PPSSplashView", "skip btn show");
                            PPSSplashView.this.I.setVisibility(0);
                        }
                    }
                }, this.w, this.v);
                return;
            }
            ge.Code("PPSSplashView", "skip btn show");
            this.I.setVisibility(0);
        }
    }

    private void b() {
        int y = this.B.y();
        if (y > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
            int V = v.V(getContext(), y);
            this.z.setPadding(V, V, V, V);
            if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin - V);
                layoutParams.setMarginEnd(layoutParams.rightMargin - V);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin - V, layoutParams.topMargin, layoutParams.rightMargin - V, layoutParams.bottomMargin);
            }
            this.z.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.g || this.F == null) {
            return;
        }
        ge.V("PPSSplashView", " exsplash start, dismiss");
        Z();
    }

    private String getSwipeClkInteractDesc() {
        InteractCfg interactCfg = this.K;
        if (interactCfg != null) {
            return interactCfg.D();
        }
        return null;
    }

    private String getSwipeInteractDesc() {
        InteractCfg interactCfg = this.K;
        if (interactCfg != null) {
            return interactCfg.S();
        }
        return null;
    }

    private String getSwipeJumpDesc() {
        InteractCfg interactCfg = this.K;
        return (interactCfg == null || interactCfg.a() == null) ? this.B.z() : this.K.a();
    }

    private String getTwistClkInteractDesc() {
        InteractCfg interactCfg = this.K;
        if (interactCfg != null) {
            return interactCfg.L();
        }
        return null;
    }

    private String getTwistInteractDesc() {
        InteractCfg interactCfg = this.K;
        if (interactCfg != null) {
            return interactCfg.F();
        }
        return null;
    }

    private String getTwistJumpDesc() {
        InteractCfg interactCfg = this.K;
        return (interactCfg == null || interactCfg.a() == null) ? this.B.E() : this.K.a();
    }

    private void setSkipBtnDelayTime(AdContentData adContentData) {
        if (adContentData == null || adContentData.am() <= 0) {
            return;
        }
        this.v = adContentData.am();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (3 == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
        if (4 == r9) goto L19;
     */
    @Override // com.huawei.hms.ads.lh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Integer Code(com.huawei.openalliance.ad.inter.data.AdContentData r8) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSSplashView.Code(com.huawei.openalliance.ad.inter.data.AdContentData):java.lang.Integer");
    }

    public void Code(int i) {
        gv Code = gw.Code(i, this);
        this.f23030c = Code;
        Code.Code(this.e);
        this.f23030c.Code(this.f);
        this.f23030c.Code(this.s);
        this.f23030c.V(this.C);
        this.f23030c.Code(this.y);
        this.f23030c.k();
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(int i, int i2, String str, boolean z, Integer num) {
        if (this.z == null) {
            return;
        }
        ge.V("PPSSplashView", "set splashpro mode: %d", Integer.valueOf(i));
        ge.V("PPSSplashView", "interactCfg = %s", num);
        if (num == null) {
            this.z.setVisibility(8);
        } else if (num.intValue() == 0) {
            Code(i2, str, z);
        } else {
            Code(z, num.intValue());
        }
        this.z.setMode(i);
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(int i, boolean z) {
        View view = this.D;
        if (view == null) {
            return;
        }
        if (1 == i) {
            view.setVisibility(0);
            return;
        }
        view.setVisibility(8);
        if (z) {
            B();
        }
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(View view) {
        ge.V("PPSSplashView", "showTemplateView");
        if (I(getContext())) {
            ge.I("PPSSplashView", "showAdView - activity finished, not add view");
            return;
        }
        this.V.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(lj ljVar, Integer num) {
        if (I(getContext())) {
            ge.I("PPSSplashView", "showAdView - activity finished, not add view");
        } else if (ljVar == null || !(ljVar instanceof View)) {
        } else {
            View view = (View) ljVar;
            this.k = ljVar;
            ViewParent parent = view.getParent();
            if (parent == this.V) {
                view.setVisibility(0);
                return;
            }
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            } else if (parent != null) {
                return;
            }
            this.V.addView(view, new RelativeLayout.LayoutParams(-1, -1));
            view.setVisibility(0);
            ljVar.setAudioFocusType(this.o);
            ge.V("PPSSplashView", "set splashpro view to adview");
            if (num != null && num.intValue() == 4) {
                ljVar.Code(this.G.getClickAreaView(), num);
            } else if (num == null || num.intValue() != 3) {
                ljVar.Code(this.z, num);
            } else {
                ljVar.Code(this.H.getClickAreaView(), num);
            }
        }
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(lu luVar) {
        View view = this.D;
        if (view != null) {
            view.setVisibility(this.L);
        }
        View view2 = this.t;
        if (view2 != null) {
            view2.setVisibility(0);
            new jk(this.B, luVar).V();
            return;
        }
        SloganView sloganView = this.Code;
        if (sloganView == null) {
            ge.V("PPSSplashView", "create default slogan");
            setSloganResId(R.drawable.hiad_default_slogan);
            sloganView = this.Code;
            if (sloganView == null) {
                return;
            }
        }
        sloganView.setSloganShowListener(luVar);
        this.Code.Code();
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(AdContentData adContentData, int i) {
        if (adContentData != null) {
            this.K = adContentData.av();
        }
        setSkipBtnDelayTime(adContentData);
        if (this.I == null) {
            V(adContentData, i);
        }
        PPSSkipButton pPSSkipButton = this.I;
        if (pPSSkipButton != null) {
            lj ljVar = this.k;
            if (ljVar != null) {
                pPSSkipButton.setShowLeftTime(ljVar.C());
            }
            if (adContentData != null && adContentData.Z() != null && adContentData.h() == 9) {
                this.I.Code((int) ((((float) adContentData.Z().h()) * 1.0f) / 1000.0f));
            }
            a();
        }
        V(adContentData);
    }

    @Override // com.huawei.hms.ads.lh
    public void I(int i) {
        PPSSkipButton pPSSkipButton = this.I;
        if (pPSSkipButton != null) {
            pPSSkipButton.Code(i);
        }
    }

    @Override // com.huawei.hms.ads.lh
    public lj V(int i) {
        if (i != 2) {
            if (i != 9) {
                return null;
            }
            Context context = getContext();
            int V = this.F.V();
            int i2 = this.r;
            if (i2 <= 0) {
                i2 = 0;
            }
            return new PPSVideoView(context, V, i2, this.F.I(), 1);
        }
        return new PPSImageView(getContext());
    }

    @Override // com.huawei.hms.ads.lh
    public void V() {
        SloganView sloganView = this.Code;
        if (sloganView != null) {
            sloganView.V();
        }
        View view = this.t;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void destroyView() {
        lj ljVar = this.k;
        if (ljVar != null) {
            ljVar.destroyView();
        }
        try {
            if (this.z != null) {
                this.z.Code();
            }
            if (this.A != null) {
                this.A.V();
            }
            if (this.G != null) {
                this.G.V();
            }
            com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).V(this.J);
            com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).Code(false);
            if (this.V != null) {
                this.V.removeAllViews();
            }
        } catch (Throwable th) {
            ge.V("PPSSplashView", "destroy err: %s", th.getClass().getSimpleName());
        }
        this.g = false;
    }

    public com.huawei.openalliance.ad.inter.listeners.b getAdListener() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public gz getAdMediator() {
        return this.f23030c;
    }

    @Override // com.huawei.hms.ads.lh
    public AdSlotParam getAdSlotParam() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.lh
    public int getAdType() {
        return 1;
    }

    @Override // com.huawei.hms.ads.lh
    public int getAudioFocusType() {
        return this.o;
    }

    public View getLogo() {
        return this.D;
    }

    public Bitmap getLogoBitmap() {
        return this.i;
    }

    public int getLogoResId() {
        return this.h;
    }

    public int getMediaNameResId() {
        return this.l;
    }

    public String getMediaNameString() {
        return this.m;
    }

    @Override // com.huawei.hms.ads.hr
    public View getOpenMeasureView() {
        return this;
    }

    public View getSloganView() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ki getSplashPresenter() {
        return this.d;
    }

    public String getUniqueId() {
        gz gzVar = this.f23030c;
        if (gzVar != null) {
            return gzVar.j();
        }
        return null;
    }

    public boolean isLoaded() {
        gz gzVar = this.f23030c;
        boolean z = false;
        if (gzVar == null) {
            return false;
        }
        if (gzVar.Code() == com.huawei.openalliance.ad.constant.a.LOADED) {
            z = true;
        }
        return z;
    }

    public boolean isLoading() {
        gz gzVar = this.f23030c;
        return gzVar == null ? this.g : gzVar.Code() == com.huawei.openalliance.ad.constant.a.LOADING;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        DisplayCutout displayCutout;
        ge.V("PPSSplashView", "onApplyWindowInsets");
        if (ay.V() && windowInsets != null && (displayCutout = windowInsets.getDisplayCutout()) != null) {
            List<Rect> boundingRects = displayCutout.getBoundingRects();
            if (!aa.Code(boundingRects)) {
                this.p = boundingRects.get(0).height();
            }
            this.q = displayCutout.getSafeInsetLeft();
            ge.V("PPSSplashView", "notchHeight left:" + this.q);
            this.r = displayCutout.getSafeInsetRight();
            ge.V("PPSSplashView", "notchHeight right:" + this.r);
        }
        if (this.p <= 0 && Build.VERSION.SDK_INT >= 26 && dt.Code(getContext()).Code(getContext())) {
            this.p = Math.max(this.p, dt.Code(getContext()).Code(this));
        }
        ge.V("PPSSplashView", "notchHeight:" + this.p);
        return super.onApplyWindowInsets(windowInsets);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ge.V("PPSSplashView", "onAttachedToWindow");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ba.Code(this.w);
        PPSSplashProView pPSSplashProView = this.z;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.A;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        PPSSplashSwipeClickView pPSSplashSwipeClickView = this.G;
        if (pPSSplashSwipeClickView != null) {
            pPSSplashSwipeClickView.V();
        }
    }

    public void pauseView() {
        lj ljVar = this.k;
        if (ljVar != null) {
            ljVar.pauseView();
        }
        PPSSplashProView pPSSplashProView = this.z;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.A;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        PPSSplashSwipeClickView pPSSplashSwipeClickView = this.G;
        if (pPSSplashSwipeClickView != null) {
            pPSSplashSwipeClickView.V();
        }
    }

    public void resumeView() {
        lj ljVar = this.k;
        if (ljVar != null) {
            ljVar.resumeView();
        }
    }

    public void setAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.f = aVar;
        gz gzVar = this.f23030c;
        if (gzVar != null) {
            gzVar.Code(aVar);
        }
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.e = bVar;
        this.d.Code(bVar);
        gz gzVar = this.f23030c;
        if (gzVar != null) {
            gzVar.Code(bVar);
        }
    }

    public void setAdSlotParam(AdSlotParam adSlotParam) {
        if (v.Code(getContext())) {
            int Code = ax.Code(getContext(), adSlotParam.V());
            int V = ax.V(getContext(), adSlotParam.V());
            adSlotParam.Z(Code);
            adSlotParam.B(V);
            adSlotParam.I(this.x);
            adSlotParam.L(Integer.valueOf(this.s));
            adSlotParam.Code(dr.Code(adSlotParam.B()));
            int i = 0;
            adSlotParam.Z((Integer) 0);
            if (!HiAd.Code(getContext()).isNewProcess() || !com.huawei.openalliance.ad.utils.c.L(getContext())) {
                i = 1;
            }
            adSlotParam.B(Integer.valueOf(i));
            this.F = adSlotParam;
            com.huawei.openalliance.ad.inter.h Code2 = com.huawei.openalliance.ad.inter.g.Code(getContext());
            if (Code2 instanceof com.huawei.openalliance.ad.inter.g) {
                ((com.huawei.openalliance.ad.inter.g) Code2).I(adSlotParam);
            }
        }
    }

    public void setAudioFocusType(int i) {
        this.o = i;
        lj ljVar = this.k;
        if (ljVar != null) {
            ljVar.setAudioFocusType(i);
        }
    }

    public void setLinkedSupportMode(int i) {
        this.s = i;
    }

    public void setLogo(View view) {
        setLogo(view, 8);
    }

    public void setLogo(View view, int i) {
        this.D = view;
        view.setVisibility(i);
        this.L = i;
    }

    public void setLogoBitmap(Bitmap bitmap) {
        this.i = bitmap;
        this.h = 0;
        F();
    }

    public void setLogoResId(int i) {
        this.h = i;
        this.i = null;
        F();
    }

    public void setMediaNameResId(int i) {
        this.l = i;
        this.m = null;
        C();
    }

    public void setMediaNameString(String str) {
        this.m = str;
        this.l = 0;
        C();
    }

    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.y = rewardVerifyConfig;
    }

    public void setSloganResId(int i) {
        if (v.Code(getContext())) {
            if (I(getContext())) {
                ge.I("PPSSplashView", "setSloganResId - activity finished, not add view");
            } else if (this.F == null && !(this instanceof SplashView)) {
                throw new ey("Must invoke SplashAdView's setAdSlotParam method before invoke setSloganResId method");
            } else {
                if (this.Code == null) {
                    SloganView sloganView = new SloganView(getContext(), i, 1);
                    this.Code = sloganView;
                    int i2 = this.n;
                    if (i2 > 0) {
                        sloganView.setWideSloganResId(i2);
                    }
                    this.V.addView(this.Code, new RelativeLayout.LayoutParams(-1, -1));
                    this.Code.V();
                }
            }
        }
    }

    public void setSloganView(View view) {
        if (view != null) {
            this.t = view;
            view.setVisibility(8);
        }
    }

    public void setWideSloganResId(int i) {
        SloganView sloganView = this.Code;
        if (sloganView != null) {
            sloganView.setWideSloganResId(i);
        } else {
            this.n = i;
        }
    }
}
