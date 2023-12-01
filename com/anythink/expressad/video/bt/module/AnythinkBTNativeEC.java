package com.anythink.expressad.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.k.l;
import com.anythink.expressad.foundation.g.d.b;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.a.c;
import com.anythink.expressad.video.module.a.a.e;
import com.anythink.expressad.video.signal.a.j;
import com.anythink.expressad.videocommon.view.RoundImageView;
import com.anythink.expressad.videocommon.view.StarLevelView;
import com.anythink.expressad.widget.a;
import com.bytedance.applog.tracker.Tracker;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/module/AnythinkBTNativeEC.class */
public class AnythinkBTNativeEC extends BTBaseView {
    private static final String p = "anythink_reward_endcard_native_hor";
    private static final String q = "anythink_reward_endcard_native_land";
    private TextView A;
    private TextView B;
    private StarLevelView C;
    private boolean D;
    private boolean E;
    private int F;
    private Runnable G;
    private View H;
    private View I;
    private String J;
    private j K;
    private WebView L;
    private ViewGroup r;
    private ViewGroup s;
    private RelativeLayout t;
    private ImageView u;
    private RoundImageView v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private TextView z;

    public AnythinkBTNativeEC(Context context) {
        super(context);
        this.D = false;
        this.E = false;
        this.F = 0;
    }

    public AnythinkBTNativeEC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = false;
        this.E = false;
        this.F = 0;
    }

    private static Bitmap a(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
            return null;
        }
    }

    private void a(float f, float f2) {
        if (this.L != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", n);
                jSONObject.put("id", this.d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", String.valueOf(f));
                jSONObject2.put("y", String.valueOf(f2));
                jSONObject.put("data", jSONObject2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(this.L, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception e) {
                c.a();
                c.a(this.L, "onClicked", this.d);
            }
        }
    }

    private void a(View view) {
        if (view == null) {
            init(this.f8335a);
            preLoadData();
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        addView(view);
        b(view);
        a();
    }

    static /* synthetic */ void a(AnythinkBTNativeEC anythinkBTNativeEC, float f, float f2) {
        if (anythinkBTNativeEC.L != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", n);
                jSONObject.put("id", anythinkBTNativeEC.d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", String.valueOf(f));
                jSONObject2.put("y", String.valueOf(f2));
                jSONObject.put("data", jSONObject2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(anythinkBTNativeEC.L, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception e) {
                c.a();
                c.a(anythinkBTNativeEC.L, "onClicked", anythinkBTNativeEC.d);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #2 {all -> 0x001f, blocks: (B:3:0x0003, B:5:0x000c, B:14:0x002c, B:16:0x0032, B:18:0x003b, B:19:0x0043, B:12:0x0027), top: B:24:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC r5, int r6) {
        /*
            r0 = 0
            r9 = r0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L1f org.json.JSONException -> L23
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L1f org.json.JSONException -> L23
            r7 = r0
            r0 = r7
            java.lang.String r1 = com.anythink.expressad.foundation.g.a.ce     // Catch: org.json.JSONException -> L1b java.lang.Throwable -> L1f
            r2 = r5
            r3 = r6
            org.json.JSONObject r2 = r2.a(r3)     // Catch: org.json.JSONException -> L1b java.lang.Throwable -> L1f
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: org.json.JSONException -> L1b java.lang.Throwable -> L1f
            goto L2b
        L1b:
            r8 = move-exception
            goto L27
        L1f:
            r5 = move-exception
            goto L4a
        L23:
            r8 = move-exception
            r0 = r9
            r7 = r0
        L27:
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1f
        L2b:
            r0 = r5
            com.anythink.expressad.video.signal.a.j r0 = r0.K     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L49
            r0 = r5
            com.anythink.expressad.video.signal.a.j r0 = r0.K     // Catch: java.lang.Throwable -> L1f
            r8 = r0
            r0 = r7
            if (r0 == 0) goto L54
            r0 = r7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L1f
            r5 = r0
            goto L43
        L43:
            r0 = r8
            r1 = 1
            r2 = r5
            r0.click(r1, r2)     // Catch: java.lang.Throwable -> L1f
        L49:
            return
        L4a:
            java.lang.String r0 = "BTBaseView"
            r1 = r5
            java.lang.String r1 = r1.getMessage()
            com.anythink.expressad.foundation.h.o.a(r0, r1)
            return
        L54:
            java.lang.String r0 = ""
            r5 = r0
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC, int):void");
    }

    static /* synthetic */ boolean a(AnythinkBTNativeEC anythinkBTNativeEC) {
        anythinkBTNativeEC.E = true;
        return true;
    }

    private int b() {
        return findLayout(isLandscape() ? q : p);
    }

    private boolean b(int i) {
        if (isLandscape()) {
            ViewGroup viewGroup = (ViewGroup) this.f.inflate(i, (ViewGroup) null);
            this.s = viewGroup;
            addView(viewGroup);
            return b(this.s);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f.inflate(i, (ViewGroup) null);
        this.r = viewGroup2;
        addView(viewGroup2);
        return b(this.r);
    }

    private boolean b(View view) {
        try {
            this.t = (RelativeLayout) view.findViewById(findID("anythink_native_ec_layout"));
            this.u = (ImageView) view.findViewById(findID("anythink_iv_adbanner_bg"));
            this.v = (RoundImageView) view.findViewById(findID("anythink_iv_adbanner"));
            this.w = (ImageView) view.findViewById(findID("anythink_iv_icon"));
            this.x = (ImageView) view.findViewById(findID("anythink_iv_flag"));
            this.y = (ImageView) view.findViewById(findID("anythink_iv_link"));
            this.z = (TextView) view.findViewById(findID("anythink_tv_apptitle"));
            this.A = (TextView) view.findViewById(findID("anythink_tv_appdesc"));
            this.B = (TextView) view.findViewById(findID("anythink_tv_nuater"));
            this.C = (StarLevelView) view.findViewById(findID("anythink_sv_starlevel"));
            this.H = view.findViewById(findID("anythink_iv_close"));
            View findViewById = view.findViewById(findID("anythink_tv_cta"));
            this.I = findViewById;
            return isNotNULL(this.u, this.v, this.w, this.z, this.A, this.B, this.C, this.H, findViewById);
        } catch (Throwable th) {
            o.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #2 {all -> 0x001f, blocks: (B:3:0x0003, B:5:0x000c, B:14:0x002c, B:16:0x0032, B:18:0x003b, B:19:0x0043, B:12:0x0027), top: B:24:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(int r6) {
        /*
            r5 = this;
            r0 = 0
            r9 = r0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L1f org.json.JSONException -> L23
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L1f org.json.JSONException -> L23
            r7 = r0
            r0 = r7
            java.lang.String r1 = com.anythink.expressad.foundation.g.a.ce     // Catch: org.json.JSONException -> L1b java.lang.Throwable -> L1f
            r2 = r5
            r3 = r6
            org.json.JSONObject r2 = r2.a(r3)     // Catch: org.json.JSONException -> L1b java.lang.Throwable -> L1f
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: org.json.JSONException -> L1b java.lang.Throwable -> L1f
            goto L2b
        L1b:
            r8 = move-exception
            goto L27
        L1f:
            r7 = move-exception
            goto L4a
        L23:
            r8 = move-exception
            r0 = r9
            r7 = r0
        L27:
            r0 = r8
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1f
        L2b:
            r0 = r5
            com.anythink.expressad.video.signal.a.j r0 = r0.K     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L49
            r0 = r5
            com.anythink.expressad.video.signal.a.j r0 = r0.K     // Catch: java.lang.Throwable -> L1f
            r8 = r0
            r0 = r7
            if (r0 == 0) goto L54
            r0 = r7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L1f
            r7 = r0
            goto L43
        L43:
            r0 = r8
            r1 = 1
            r2 = r7
            r0.click(r1, r2)     // Catch: java.lang.Throwable -> L1f
        L49:
            return
        L4a:
            java.lang.String r0 = "BTBaseView"
            r1 = r7
            java.lang.String r1 = r1.getMessage()
            com.anythink.expressad.foundation.h.o.a(r0, r1)
            return
        L54:
            java.lang.String r0 = ""
            r7 = r0
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.c(int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public final void a() {
        if (this.h) {
            this.t.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    if (AnythinkBTNativeEC.this.D) {
                        AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, 1);
                        AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, view.getX(), view.getY());
                    }
                }
            });
            this.H.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    if (AnythinkBTNativeEC.this.L != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", AnythinkBTNativeEC.this.d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("unitId", AnythinkBTNativeEC.this.J);
                            jSONObject.put("data", jSONObject2);
                            o.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
                        } catch (JSONException e) {
                            o.a(BTBaseView.TAG, e.getMessage());
                        }
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a(AnythinkBTNativeEC.this.L, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }
            });
            this.I.setOnClickListener(new a() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.6
                @Override // com.anythink.expressad.widget.a
                public final void a(View view) {
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, 0);
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.w.setOnClickListener(new a() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.7
                @Override // com.anythink.expressad.widget.a
                public final void a(View view) {
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, 0);
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.v.setOnClickListener(new a() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.8
                @Override // com.anythink.expressad.widget.a
                public final void a(View view) {
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, 0);
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this, view.getX(), view.getY());
                }
            });
        }
    }

    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            RenderScript create = RenderScript.create(this.f8335a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(10.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            bitmap.recycle();
            create.destroy();
            return createBitmap;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(Context context) {
        boolean b;
        int findLayout = findLayout(isLandscape() ? q : p);
        if (findLayout > 0) {
            if (isLandscape()) {
                ViewGroup viewGroup = (ViewGroup) this.f.inflate(findLayout, (ViewGroup) null);
                this.s = viewGroup;
                addView(viewGroup);
                b = b(this.s);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) this.f.inflate(findLayout, (ViewGroup) null);
                this.r = viewGroup2;
                addView(viewGroup2);
                b = b(this.r);
            }
            this.h = b;
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.G == null) {
            this.G = new Runnable() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.1
                @Override // java.lang.Runnable
                public final void run() {
                    AnythinkBTNativeEC.a(AnythinkBTNativeEC.this);
                    if (AnythinkBTNativeEC.this.H != null) {
                        AnythinkBTNativeEC.this.H.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.G;
        if (runnable != null) {
            postDelayed(runnable, this.F * 1000);
        }
        if (!this.h && this.L != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("unitId", this.J);
                jSONObject.put("data", jSONObject2);
                o.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
            } catch (JSONException e) {
                o.a(BTBaseView.TAG, e.getMessage());
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.L, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        if (this.L != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", this.d);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("unitId", this.J);
                jSONObject3.put("data", jSONObject4);
                o.a(BTBaseView.TAG, "NativeEC Call H5 onEndCardShow " + jSONObject3.toString());
            } catch (JSONException e2) {
                o.a(BTBaseView.TAG, e2.getMessage());
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.L, "onNativeECShow", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.G;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.g = configuration.orientation;
        if (this.g == 2) {
            removeView(this.r);
            a(this.s);
            return;
        }
        removeView(this.s);
        a(this.r);
    }

    public void preLoadData() {
        Bitmap blurBitmap;
        try {
            if (this.b == null || !this.h) {
                return;
            }
            if (this.e != null) {
                this.F = this.e.p();
            }
            b.a(this.f8335a.getApplicationContext()).a(this.b.be(), new e(this.v, this.b, this.J));
            b.a(this.f8335a.getApplicationContext()).a(this.b.bd(), new com.anythink.expressad.video.module.a.a.j(this.w, t.b(com.anythink.expressad.foundation.b.a.b().d(), 8.0f)));
            this.z.setText(this.b.bb());
            this.A.setText(this.b.bc());
            this.B.setText(this.b.aY() + ")");
            this.C.removeAllViews();
            double aX = this.b.aX();
            double d = aX;
            if (aX <= 0.0d) {
                d = 5.0d;
            }
            this.C.initScore(d);
            if (Build.VERSION.SDK_INT < 17) {
                this.u.setVisibility(8);
                return;
            }
            Bitmap a2 = a(this.v.getDrawable());
            if (a2 != null && (blurBitmap = blurBitmap(a2)) != null) {
                this.u.setImageBitmap(blurBitmap);
            }
            if (!TextUtils.isEmpty(this.b.I()) && this.b.I().contains("alecfc=1")) {
                this.D = true;
            }
            b.a(this.f8335a.getApplicationContext()).a(TextUtils.isEmpty(this.b.aE()) ? com.anythink.expressad.a.ab : this.b.aE(), new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.2
                @Override // com.anythink.expressad.foundation.g.d.c
                public final void a(Bitmap bitmap, String str) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    try {
                        float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
                        int b = t.b(AnythinkBTNativeEC.this.f8335a, 12.0f);
                        int i = (int) (b * width);
                        AnythinkBTNativeEC.this.x.getLayoutParams().height = b;
                        AnythinkBTNativeEC.this.x.getLayoutParams().width = i;
                        AnythinkBTNativeEC.this.x.setImageBitmap(bitmap);
                        AnythinkBTNativeEC.this.x.setBackgroundColor(1426063360);
                    } catch (Throwable th) {
                    }
                }

                @Override // com.anythink.expressad.foundation.g.d.c
                public final void a(String str, String str2) {
                }
            });
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
            if (b != null) {
                final String J = b.J();
                if (TextUtils.isEmpty(J)) {
                    this.y.setVisibility(8);
                }
                this.y.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                        l.b(AnythinkBTNativeEC.this.f8335a, J);
                    }
                });
            } else {
                this.y.setVisibility(8);
            }
            if (this.E) {
                return;
            }
            this.H.setVisibility(8);
        } catch (Throwable th) {
            o.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void setCreateWebView(WebView webView) {
        this.L = webView;
    }

    public void setJSCommon(j jVar) {
        this.K = jVar;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void setUnitId(String str) {
        this.J = str;
    }
}
