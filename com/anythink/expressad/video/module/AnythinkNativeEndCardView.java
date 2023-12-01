package com.anythink.expressad.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.foundation.d.d;
import com.anythink.expressad.foundation.f.a;
import com.anythink.expressad.foundation.g.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.shake.MBShakeView;
import com.anythink.expressad.video.dynview.f.h;
import com.anythink.expressad.video.dynview.widget.AnyThinkLevelLayoutView;
import com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView;
import com.anythink.expressad.video.module.a.a.j;
import com.anythink.expressad.video.signal.f;
import com.anythink.expressad.video.signal.factory.b;
import com.anythink.expressad.videocommon.view.RoundImageView;
import com.anythink.expressad.videocommon.view.StarLevelView;
import com.anythink.expressad.widget.FeedBackButton;
import com.bytedance.applog.tracker.Tracker;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkNativeEndCardView.class */
public class AnythinkNativeEndCardView extends AnythinkBaseView implements f {
    private static final String n = "anythink_reward_endcard_native_hor";
    private static final String o = "anythink_reward_endcard_native_land";
    private static final String p = "anythink_reward_endcard_native_half_portrait";
    private static final String q = "anythink_reward_endcard_native_half_landscape";
    private ImageView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private LinearLayout E;
    private FeedBackButton F;
    private Runnable G;
    private RelativeLayout H;
    private b I;
    private boolean J;
    private boolean K;
    private int L;
    private boolean M;
    private boolean N;
    private boolean O;
    private AlphaAnimation P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private View V;
    private TextView W;
    private boolean aa;
    private String ab;
    private d ac;
    private MBShakeView ad;
    private com.anythink.expressad.shake.b ae;
    private AnythinkBaitClickView af;
    private int ag;
    private ViewGroup r;
    private ViewGroup s;
    private RelativeLayout t;
    private RelativeLayout u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private ImageView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$10  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkNativeEndCardView$10.class */
    public final class AnonymousClass10 implements c {
        AnonymousClass10() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            try {
                if (AnythinkNativeEndCardView.this.w != null) {
                    if (AnythinkNativeEndCardView.this.i) {
                        AnythinkNativeEndCardView.this.w.setBackgroundDrawable(null);
                    }
                    AnythinkNativeEndCardView.this.w.setImageBitmap(bitmap);
                }
                Bitmap blurBitmap = AnythinkNativeEndCardView.this.blurBitmap(bitmap);
                if (blurBitmap == null || blurBitmap.isRecycled() || AnythinkNativeEndCardView.this.v == null) {
                    return;
                }
                if (AnythinkNativeEndCardView.this.i) {
                    AnythinkNativeEndCardView.this.v.setBackgroundDrawable(null);
                }
                AnythinkNativeEndCardView.this.v.setImageBitmap(blurBitmap);
            } catch (Throwable th) {
                if (AnythinkNativeEndCardView.this.v != null) {
                    AnythinkNativeEndCardView.this.v.setVisibility(4);
                }
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$11  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkNativeEndCardView$11.class */
    public final class AnonymousClass11 implements c {
        AnonymousClass11() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled() || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            try {
                float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
                int b = t.b(AnythinkNativeEndCardView.this.f5600a, 12.0f);
                int i = (int) (b * width);
                AnythinkNativeEndCardView.this.y.getLayoutParams().height = b;
                AnythinkNativeEndCardView.this.y.getLayoutParams().width = i;
                AnythinkNativeEndCardView.this.y.setImageBitmap(bitmap);
                AnythinkNativeEndCardView.this.y.setBackgroundColor(1426063360);
            } catch (Throwable th) {
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$12  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkNativeEndCardView$12.class */
    public final class AnonymousClass12 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f5627a;

        AnonymousClass12(String str) {
            this.f5627a = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            l.b(AnythinkNativeEndCardView.this.f5600a, this.f5627a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkNativeEndCardView$4.class */
    public final class AnonymousClass4 implements a {
        AnonymousClass4() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            AnythinkNativeEndCardView.this.O = true;
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            AnythinkNativeEndCardView.this.O = false;
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            AnythinkNativeEndCardView.this.O = false;
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkNativeEndCardView$5.class */
    final class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 0);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$6  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkNativeEndCardView$6.class */
    final class AnonymousClass6 extends com.anythink.expressad.shake.b {
        AnonymousClass6(int i, int i2) {
            super(i, i2);
        }

        @Override // com.anythink.expressad.shake.b
        public final void a() {
            if (!AnythinkNativeEndCardView.this.O && AnythinkNativeEndCardView.this.N) {
                AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 4);
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$7  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkNativeEndCardView$7.class */
    final class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 0);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$8  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkNativeEndCardView$8.class */
    final class AnonymousClass8 implements Runnable {
        AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$9  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkNativeEndCardView$9.class */
    public final class AnonymousClass9 implements h {
        AnonymousClass9() {
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            AnythinkNativeEndCardView.this.addView(aVar.a());
            AnythinkNativeEndCardView.this.U = aVar.c();
            AnythinkNativeEndCardView anythinkNativeEndCardView = AnythinkNativeEndCardView.this;
            anythinkNativeEndCardView.f = anythinkNativeEndCardView.b(aVar.a());
            AnythinkNativeEndCardView.this.e();
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            o.d(AnythinkBaseView.TAG, "errorMsg:" + bVar.b());
        }
    }

    public AnythinkNativeEndCardView(Context context) {
        super(context);
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.U = false;
        this.ag = 1;
    }

    public AnythinkNativeEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.U = false;
        this.ag = 1;
    }

    public AnythinkNativeEndCardView(Context context, AttributeSet attributeSet, boolean z, int i, boolean z2, int i2, int i3) {
        super(context, attributeSet, z, i, z2, i2, i3);
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.U = false;
        this.ag = 1;
    }

    private void a() {
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c a2 = com.anythink.expressad.video.dynview.j.c.a(getContext(), this.b, this.j);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(a2, new AnonymousClass9());
    }

    private void a(View view) {
        if (view == null) {
            setLayout();
            preLoadData(this.I);
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
            b(view);
            c();
        }
        h();
    }

    static /* synthetic */ void a(AnythinkNativeEndCardView anythinkNativeEndCardView, int i) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
            jSONObject = null;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, anythinkNativeEndCardView.a(i));
            jSONObject2 = jSONObject;
            if (anythinkNativeEndCardView.b.k() == 5) {
                jSONObject.put("camp_position", 0);
                jSONObject2 = jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            jSONObject2 = jSONObject;
            anythinkNativeEndCardView.e.a(105, jSONObject2);
        }
        anythinkNativeEndCardView.e.a(105, jSONObject2);
    }

    static /* synthetic */ boolean a(AnythinkNativeEndCardView anythinkNativeEndCardView) {
        anythinkNativeEndCardView.K = true;
        return true;
    }

    private void b() {
        boolean b;
        int i = this.ag;
        String str = p;
        if (i == 0) {
            if (!this.aa) {
                str = n;
            }
            if (isLandscape()) {
                if (this.aa) {
                    str = q;
                }
                str = o;
            }
        } else {
            if (i != 1) {
                str = "";
            } else if (!this.aa) {
                str = n;
            }
            if (this.ag == 2) {
                if (this.aa) {
                    str = q;
                }
                str = o;
            }
        }
        int findLayout = findLayout(str);
        if (findLayout > 0) {
            if (isLandscape()) {
                ViewGroup viewGroup = (ViewGroup) this.f5601c.inflate(findLayout, (ViewGroup) null);
                this.s = viewGroup;
                addView(viewGroup);
                b = b(this.s);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) this.f5601c.inflate(findLayout, (ViewGroup) null);
                this.r = viewGroup2;
                addView(viewGroup2);
                b = b(this.r);
            }
            this.f = b;
            e();
        }
    }

    private boolean b(int i) {
        if (isLandscape()) {
            ViewGroup viewGroup = (ViewGroup) this.f5601c.inflate(i, (ViewGroup) null);
            this.s = viewGroup;
            addView(viewGroup);
            return b(this.s);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f5601c.inflate(i, (ViewGroup) null);
        this.r = viewGroup2;
        addView(viewGroup2);
        return b(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(View view) {
        try {
            this.t = (RelativeLayout) view.findViewById(filterFindViewId(this.U, "anythink_native_ec_layout"));
            this.u = (RelativeLayout) view.findViewById(filterFindViewId(this.U, "anythink_native_ec_layer_layout"));
            this.w = (ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_adbanner"));
            this.x = (ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_icon"));
            this.y = (ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_flag"));
            this.z = (ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_link"));
            this.B = (TextView) view.findViewById(filterFindViewId(this.U, "anythink_tv_apptitle"));
            this.E = (LinearLayout) view.findViewById(filterFindViewId(this.U, "anythink_sv_starlevel"));
            this.V = view.findViewById(filterFindViewId(this.U, "anythink_iv_close"));
            View findViewById = view.findViewById(filterFindViewId(this.U, "anythink_tv_cta"));
            if (findViewById != null && (findViewById instanceof TextView)) {
                this.W = (TextView) findViewById;
            }
            this.F = (FeedBackButton) view.findViewById(filterFindViewId(this.U, "anythink_native_endcard_feed_btn"));
            this.H = (RelativeLayout) view.findViewById(filterFindViewId(this.U, "anythink_native_ec_controller"));
            this.v = (ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_adbanner_bg"));
            if (!this.i) {
                this.C = (TextView) view.findViewById(filterFindViewId(this.U, "anythink_tv_appdesc"));
                TextView textView = (TextView) view.findViewById(filterFindViewId(this.U, "anythink_tv_number"));
                this.D = textView;
                return isNotNULL(this.v, this.w, this.x, this.B, this.C, textView, this.E, this.V, this.W);
            }
            if (this.w != null && (this.w instanceof RoundImageView)) {
                ((RoundImageView) this.w).setBorderRadius(10);
            }
            if (this.x != null && (this.x instanceof RoundImageView)) {
                ((RoundImageView) this.x).setBorderRadius(10);
            }
            return isNotNULL(this.v, this.w, this.x, this.B, this.E, this.V);
        } catch (Throwable th) {
            o.b(AnythinkBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    private void c(int i) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
            jSONObject = null;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, a(i));
            jSONObject2 = jSONObject;
            if (this.b.k() == 5) {
                jSONObject.put("camp_position", 0);
                jSONObject2 = jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            jSONObject2 = jSONObject;
            this.e.a(105, jSONObject2);
        }
        this.e.a(105, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        c();
        if (!this.f) {
            this.e.a(104, "");
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.P = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    private void f() {
        ImageView imageView;
        com.anythink.expressad.foundation.g.d.b.a(this.f5600a.getApplicationContext()).a(this.b.be(), new AnonymousClass10());
        com.anythink.expressad.foundation.g.d.b.a(this.f5600a.getApplicationContext()).a(this.b.bd(), new j(this.x, t.b(n.a().g(), 8.0f)));
        this.B.setText(this.b.bb());
        TextView textView = this.W;
        if (textView != null) {
            textView.setText(this.b.cU);
        }
        TextView textView2 = this.C;
        if (textView2 != null) {
            textView2.setText(this.b.bc());
        }
        TextView textView3 = this.D;
        if (textView3 != null) {
            textView3.setText(this.b.aY() + ")");
        }
        this.E.removeAllViews();
        double aX = this.b.aX();
        double d = aX;
        if (aX <= 0.0d) {
            d = 5.0d;
        }
        LinearLayout linearLayout = this.E;
        if (linearLayout instanceof StarLevelView) {
            ((StarLevelView) linearLayout).initScore(d);
        }
        LinearLayout linearLayout2 = this.E;
        if (linearLayout2 instanceof AnyThinkLevelLayoutView) {
            ((AnyThinkLevelLayoutView) linearLayout2).setRatingAndUser(d, this.b.aY());
        }
        if (!TextUtils.isEmpty(this.b.I()) && this.b.I().contains("alecfc=1")) {
            this.J = true;
        }
        com.anythink.expressad.foundation.g.d.b.a(this.f5600a.getApplicationContext()).a(TextUtils.isEmpty(this.b.aE()) ? com.anythink.expressad.a.ab : this.b.aE(), new AnonymousClass11());
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
        if (b != null) {
            String J = b.J();
            if (TextUtils.isEmpty(J)) {
                this.z.setVisibility(8);
            }
            this.z.setOnClickListener(new AnonymousClass12(J));
        } else {
            this.z.setVisibility(8);
        }
        if (!this.K) {
            this.V.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT >= 17 || (imageView = this.v) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    private int g() {
        int i = this.ag;
        String str = p;
        if (i == 0) {
            if (!this.aa) {
                str = n;
            }
            if (isLandscape()) {
                if (this.aa) {
                    str = q;
                }
                str = o;
            }
        } else {
            if (i != 1) {
                str = "";
            } else if (!this.aa) {
                str = n;
            }
            if (this.ag == 2) {
                if (this.aa) {
                    str = q;
                }
                str = o;
            }
        }
        return findLayout(str);
    }

    private void h() {
        RelativeLayout relativeLayout;
        if (!this.f || (relativeLayout = this.H) == null) {
            return;
        }
        relativeLayout.postDelayed(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.3
            @Override // java.lang.Runnable
            public final void run() {
                if (AnythinkNativeEndCardView.this.b != null && !AnythinkNativeEndCardView.this.b.j() && AnythinkNativeEndCardView.this.b.f() != 2) {
                    AnythinkNativeEndCardView.this.H.setPadding(AnythinkNativeEndCardView.this.Q, AnythinkNativeEndCardView.this.S, AnythinkNativeEndCardView.this.R, AnythinkNativeEndCardView.this.T);
                    AnythinkNativeEndCardView.this.H.startAnimation(AnythinkNativeEndCardView.this.P);
                }
                AnythinkNativeEndCardView.this.H.setVisibility(0);
                if (AnythinkNativeEndCardView.this.V.getVisibility() != 0 && AnythinkNativeEndCardView.this.K) {
                    AnythinkNativeEndCardView.this.V.setVisibility(0);
                }
                AnythinkNativeEndCardView.o(AnythinkNativeEndCardView.this);
            }
        }, 200L);
    }

    private void i() {
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            FeedBackButton feedBackButton = this.F;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        this.b.l(this.ab);
        com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
        a2.a(this.ab + "_2", new AnonymousClass4());
        com.anythink.expressad.foundation.f.b a3 = com.anythink.expressad.foundation.f.b.a();
        a3.a(this.ab + "_2", this.b);
        com.anythink.expressad.foundation.f.b a4 = com.anythink.expressad.foundation.f.b.a();
        a4.c(this.ab + "_1");
        com.anythink.expressad.foundation.f.b a5 = com.anythink.expressad.foundation.f.b.a();
        a5.a(this.ab + "_2", this.F);
        if (this.F != null) {
            com.anythink.expressad.foundation.f.b a6 = com.anythink.expressad.foundation.f.b.a();
            a6.a(this.ab + "_2", this.F);
        }
    }

    private void j() {
        try {
            if (this.b == null || !this.b.j()) {
                return;
            }
            String I = this.b.I();
            String str = I;
            if (TextUtils.isEmpty(I)) {
                str = this.b.P();
            }
            String a2 = x.a(str, "shake_show");
            String a3 = x.a(str, "shake_strength");
            String a4 = x.a(str, "shake_time");
            if (!TextUtils.isEmpty(a2) && a2.equals("1") && this.ad == null) {
                if (this.af != null) {
                    this.af.setVisibility(8);
                }
                MBShakeView mBShakeView = new MBShakeView(getContext());
                this.ad = mBShakeView;
                mBShakeView.initView(this.b.cU, true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (isLandscape()) {
                    layoutParams.addRule(13);
                } else {
                    layoutParams.addRule(2, findID("anythink_iv_logo"));
                    layoutParams.addRule(14);
                    this.ad.setPadding(0, 0, 0, t.b(getContext(), 20.0f));
                }
                this.ad.setLayoutParams(layoutParams);
                if (this.t != null && this.t.isShown()) {
                    if (this.W != null) {
                        this.t.addView(this.ad);
                    }
                    this.W.setVisibility(4);
                    this.ad.setOnClickListener(new AnonymousClass5());
                    int i = 10;
                    if (!TextUtils.isEmpty(a3)) {
                        i = Integer.parseInt(a3);
                        if (i < 0) {
                            i = 10;
                        }
                    }
                    int i2 = 5000;
                    if (!TextUtils.isEmpty(a4)) {
                        int parseInt = Integer.parseInt(a4);
                        i2 = parseInt <= 0 ? 5000 : parseInt * 1000;
                    }
                    this.ae = new AnonymousClass6(i, i2);
                    com.anythink.expressad.shake.a.a().a(this.ae);
                }
            }
        } catch (Throwable th) {
            o.d(AnythinkBaseView.TAG, th.getMessage());
        }
    }

    private void k() {
        try {
            if (this.b == null || !this.b.j()) {
                return;
            }
            String I = this.b.I();
            String str = I;
            if (TextUtils.isEmpty(I)) {
                str = this.b.P();
            }
            String a2 = x.a(str, "bait_click");
            int parseInt = Integer.parseInt(a2);
            if (TextUtils.isEmpty(a2) || parseInt == 0 || this.af != null) {
                return;
            }
            AnythinkBaitClickView anythinkBaitClickView = new AnythinkBaitClickView(getContext());
            this.af = anythinkBaitClickView;
            anythinkBaitClickView.init(1342177280, parseInt);
            this.af.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            if (this.u != null) {
                this.u.addView(this.af);
                this.af.startAnimation();
                this.af.setOnClickListener(new AnonymousClass7());
            }
        } catch (Throwable th) {
            o.d(AnythinkBaseView.TAG, th.getMessage());
        }
    }

    private void l() {
        try {
            if (this.b == null || !this.b.j()) {
                return;
            }
            String I = this.b.I();
            String str = I;
            if (TextUtils.isEmpty(I)) {
                str = this.b.P();
            }
            String a2 = x.a(str, "alac");
            if (TextUtils.isEmpty(a2) || !a2.equals("1")) {
                return;
            }
            postDelayed(new AnonymousClass8(), 1000L);
        } catch (Throwable th) {
            o.d(AnythinkBaseView.TAG, th.getMessage());
        }
    }

    static /* synthetic */ void o(AnythinkNativeEndCardView anythinkNativeEndCardView) {
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            FeedBackButton feedBackButton = anythinkNativeEndCardView.F;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        anythinkNativeEndCardView.b.l(anythinkNativeEndCardView.ab);
        com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
        a2.a(anythinkNativeEndCardView.ab + "_2", new AnonymousClass4());
        com.anythink.expressad.foundation.f.b a3 = com.anythink.expressad.foundation.f.b.a();
        a3.a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.b);
        com.anythink.expressad.foundation.f.b a4 = com.anythink.expressad.foundation.f.b.a();
        a4.c(anythinkNativeEndCardView.ab + "_1");
        com.anythink.expressad.foundation.f.b a5 = com.anythink.expressad.foundation.f.b.a();
        a5.a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.F);
        if (anythinkNativeEndCardView.F != null) {
            com.anythink.expressad.foundation.f.b a6 = com.anythink.expressad.foundation.f.b.a();
            a6.a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.F);
        }
    }

    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript create = RenderScript.create(this.f5600a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(25.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public final void c() {
        if (this.f) {
            this.t.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    if (AnythinkNativeEndCardView.this.J) {
                        AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 1);
                    }
                }
            });
            this.V.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    AnythinkNativeEndCardView.this.e.a(104, "");
                }
            });
            TextView textView = this.W;
            if (textView != null) {
                textView.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.15
                    @Override // com.anythink.expressad.widget.a
                    public final void a(View view) {
                        AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 0);
                    }
                });
            }
            this.x.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.16
                @Override // com.anythink.expressad.widget.a
                public final void a(View view) {
                    AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 0);
                }
            });
            this.w.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.2
                @Override // com.anythink.expressad.widget.a
                public final void a(View view) {
                    AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this, 0);
                }
            });
        }
    }

    public boolean canBackPress() {
        View view = this.V;
        return view != null && view.getVisibility() == 0;
    }

    public void clearMoreOfferBitmap() {
        d dVar;
        if (this.b == null || !this.b.j() || (dVar = this.ac) == null || dVar.J == null || this.ac.J.size() <= 0) {
            return;
        }
        Iterator<com.anythink.expressad.foundation.d.c> it = this.ac.J.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.foundation.d.c next = it.next();
            if (!TextUtils.isEmpty(next.bd())) {
                com.anythink.expressad.foundation.g.d.b.a(n.a().g()).c(next.bd());
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
    }

    public boolean isDyXmlSuccess() {
        return this.U;
    }

    public void notifyShowListener() {
        this.e.a(110, "");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.G == null) {
            this.G = new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkNativeEndCardView.1
                @Override // java.lang.Runnable
                public final void run() {
                    AnythinkNativeEndCardView.a(AnythinkNativeEndCardView.this);
                    if (AnythinkNativeEndCardView.this.V != null) {
                        AnythinkNativeEndCardView.this.V.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.G;
        if (runnable != null) {
            postDelayed(runnable, this.L * 1000);
            if (!this.N) {
                this.N = true;
            }
            try {
                if (this.b != null && this.b.j()) {
                    String I = this.b.I();
                    String str = I;
                    if (TextUtils.isEmpty(I)) {
                        str = this.b.P();
                    }
                    String a2 = x.a(str, "alac");
                    if (!TextUtils.isEmpty(a2) && a2.equals("1")) {
                        postDelayed(new AnonymousClass8(), 1000L);
                    }
                }
            } catch (Throwable th) {
                o.d(AnythinkBaseView.TAG, th.getMessage());
            }
        }
        try {
            if (this.b != null && this.b.j()) {
                String I2 = this.b.I();
                String str2 = I2;
                if (TextUtils.isEmpty(I2)) {
                    str2 = this.b.P();
                }
                String a3 = x.a(str2, "bait_click");
                int parseInt = Integer.parseInt(a3);
                if (!TextUtils.isEmpty(a3) && parseInt != 0 && this.af == null) {
                    AnythinkBaitClickView anythinkBaitClickView = new AnythinkBaitClickView(getContext());
                    this.af = anythinkBaitClickView;
                    anythinkBaitClickView.init(1342177280, parseInt);
                    this.af.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    if (this.u != null) {
                        this.u.addView(this.af);
                        this.af.startAnimation();
                        this.af.setOnClickListener(new AnonymousClass7());
                    }
                }
            }
        } catch (Throwable th2) {
            o.d(AnythinkBaseView.TAG, th2.getMessage());
        }
        try {
            if (this.b == null || !this.b.j()) {
                return;
            }
            String I3 = this.b.I();
            String str3 = I3;
            if (TextUtils.isEmpty(I3)) {
                str3 = this.b.P();
            }
            String a4 = x.a(str3, "shake_show");
            String a5 = x.a(str3, "shake_strength");
            String a6 = x.a(str3, "shake_time");
            if (!TextUtils.isEmpty(a4) && a4.equals("1") && this.ad == null) {
                if (this.af != null) {
                    this.af.setVisibility(8);
                }
                MBShakeView mBShakeView = new MBShakeView(getContext());
                this.ad = mBShakeView;
                mBShakeView.initView(this.b.cU, true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (isLandscape()) {
                    layoutParams.addRule(13);
                } else {
                    layoutParams.addRule(2, findID("anythink_iv_logo"));
                    layoutParams.addRule(14);
                    this.ad.setPadding(0, 0, 0, t.b(getContext(), 20.0f));
                }
                this.ad.setLayoutParams(layoutParams);
                if (this.t != null && this.t.isShown()) {
                    if (this.W != null) {
                        this.t.addView(this.ad);
                    }
                    this.W.setVisibility(4);
                    this.ad.setOnClickListener(new AnonymousClass5());
                    int i = 10;
                    if (!TextUtils.isEmpty(a5)) {
                        i = Integer.parseInt(a5);
                        if (i < 0) {
                            i = 10;
                        }
                    }
                    int i2 = 5000;
                    if (!TextUtils.isEmpty(a6)) {
                        int parseInt2 = Integer.parseInt(a6);
                        i2 = parseInt2 <= 0 ? 5000 : parseInt2 * 1000;
                    }
                    this.ae = new AnonymousClass6(i, i2);
                    com.anythink.expressad.shake.a.a().a(this.ae);
                }
            }
        } catch (Throwable th3) {
            o.d(AnythinkBaseView.TAG, th3.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.G;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        if (this.ae != null) {
            com.anythink.expressad.shake.a.a().b(this.ae);
            this.ae = null;
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        if (this.b == null || !this.b.j()) {
            RelativeLayout relativeLayout = this.H;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            this.d = configuration.orientation;
            o.d(AnythinkBaseView.TAG, " native onSelfConfigurationChanged:" + this.d);
            if (this.d == 2) {
                removeView(this.r);
                a(this.s);
                return;
            }
            removeView(this.s);
            a(this.r);
        }
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        this.I = bVar;
        try {
            if (this.b == null || !this.f) {
                return;
            }
            com.anythink.expressad.foundation.g.d.b.a(this.f5600a.getApplicationContext()).a(this.b.be(), new AnonymousClass10());
            com.anythink.expressad.foundation.g.d.b.a(this.f5600a.getApplicationContext()).a(this.b.bd(), new j(this.x, t.b(n.a().g(), 8.0f)));
            this.B.setText(this.b.bb());
            if (this.W != null) {
                this.W.setText(this.b.cU);
            }
            if (this.C != null) {
                this.C.setText(this.b.bc());
            }
            if (this.D != null) {
                this.D.setText(this.b.aY() + ")");
            }
            this.E.removeAllViews();
            double aX = this.b.aX();
            double d = aX;
            if (aX <= 0.0d) {
                d = 5.0d;
            }
            if (this.E instanceof StarLevelView) {
                ((StarLevelView) this.E).initScore(d);
            }
            if (this.E instanceof AnyThinkLevelLayoutView) {
                ((AnyThinkLevelLayoutView) this.E).setRatingAndUser(d, this.b.aY());
            }
            if (!TextUtils.isEmpty(this.b.I()) && this.b.I().contains("alecfc=1")) {
                this.J = true;
            }
            com.anythink.expressad.foundation.g.d.b.a(this.f5600a.getApplicationContext()).a(TextUtils.isEmpty(this.b.aE()) ? com.anythink.expressad.a.ab : this.b.aE(), new AnonymousClass11());
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
            if (b != null) {
                String J = b.J();
                if (TextUtils.isEmpty(J)) {
                    this.z.setVisibility(8);
                }
                this.z.setOnClickListener(new AnonymousClass12(J));
            } else {
                this.z.setVisibility(8);
            }
            if (!this.K) {
                this.V.setVisibility(8);
            }
            if (Build.VERSION.SDK_INT >= 17 || this.v == null) {
                return;
            }
            this.v.setVisibility(8);
        } catch (Throwable th) {
            o.a(AnythinkBaseView.TAG, th.getMessage());
        }
    }

    public void release() {
        try {
            removeAllViews();
            if (this.P != null) {
                this.P.cancel();
            }
            this.ae = null;
            this.G = null;
        } catch (Exception e) {
            o.d(AnythinkBaseView.TAG, e.getMessage());
        }
    }

    public void setCloseBtnDelay(int i) {
        this.L = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setLayout() {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.module.AnythinkNativeEndCardView.setLayout():void");
    }

    public void setMoreOfferCampaignUnit(d dVar) {
        MBShakeView mBShakeView;
        if (this.b == null || !this.b.j()) {
            return;
        }
        this.ac = dVar;
        if (dVar == null || dVar.J == null || this.ac.J.size() <= 5 || (mBShakeView = this.ad) == null) {
            return;
        }
        mBShakeView.setPadding(0, 0, 0, t.b(getContext(), 5.0f));
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        o.d(AnythinkBaseView.TAG, "NOTCH NativeEndCard " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        this.Q = i;
        this.R = i2;
        this.S = i3;
        this.T = i4;
        h();
    }

    public void setOnPause() {
        this.N = false;
    }

    public void setOnResume() {
        this.N = true;
    }

    public void setUnitId(String str) {
        this.ab = str;
    }
}
