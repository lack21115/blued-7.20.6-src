package com.anythink.expressad.video.dynview.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.dynview.f.b;
import com.anythink.expressad.video.dynview.f.h;
import com.anythink.expressad.video.module.AnythinkBaseView;
import com.anythink.expressad.widget.FeedBackButton;
import com.bytedance.applog.tracker.Tracker;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/widget/AnyThinkOrderCampView.class */
public class AnyThinkOrderCampView extends AnythinkBaseView {
    private AnyThinkOrderCampView n;
    private List<c> o;
    private int p;
    private int q;
    private int r;
    private int s;
    private String t;
    private FeedBackButton u;
    private ImageView v;
    private boolean w;
    private com.anythink.expressad.video.dynview.f.c x;
    private b y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/widget/AnyThinkOrderCampView$3.class */
    public final class AnonymousClass3 implements com.anythink.expressad.foundation.f.a {
        AnonymousClass3() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/widget/AnyThinkOrderCampView$4.class */
    public final class AnonymousClass4 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f5581a;

        AnonymousClass4(String str) {
            this.f5581a = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            l.a(AnyThinkOrderCampView.this.f5600a, this.f5581a);
        }
    }

    public AnyThinkOrderCampView(Context context) {
        super(context);
        this.w = false;
        this.x = new com.anythink.expressad.video.dynview.f.c() { // from class: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView.1
            @Override // com.anythink.expressad.video.dynview.f.c
            public final void a() {
                AnyThinkOrderCampView.a(AnyThinkOrderCampView.this);
            }

            @Override // com.anythink.expressad.video.dynview.f.c
            public final void a(c cVar, int i) {
                if (cVar != null) {
                    try {
                        AnyThinkOrderCampView.this.setCampaign(cVar);
                        AnyThinkOrderCampView.a(AnyThinkOrderCampView.this, cVar, i);
                    } catch (Exception e) {
                        o.d(AnythinkBaseView.TAG, e.getMessage());
                    }
                }
            }
        };
        this.z = false;
    }

    public AnyThinkOrderCampView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = false;
        this.x = new com.anythink.expressad.video.dynview.f.c() { // from class: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView.1
            @Override // com.anythink.expressad.video.dynview.f.c
            public final void a() {
                AnyThinkOrderCampView.a(AnyThinkOrderCampView.this);
            }

            @Override // com.anythink.expressad.video.dynview.f.c
            public final void a(c cVar, int i) {
                if (cVar != null) {
                    try {
                        AnyThinkOrderCampView.this.setCampaign(cVar);
                        AnyThinkOrderCampView.a(AnyThinkOrderCampView.this, cVar, i);
                    } catch (Exception e) {
                        o.d(AnythinkBaseView.TAG, e.getMessage());
                    }
                }
            }
        };
        this.z = false;
    }

    private void a() {
        if (this.e != null) {
            this.e.a(104, "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.anythink.expressad.foundation.d.c r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = r6
            if (r0 == 0) goto L30
            r0 = r6
            boolean r0 = r0.j()
            if (r0 == 0) goto L30
            r0 = r6
            com.anythink.expressad.foundation.d.c$c r0 = r0.M()     // Catch: java.lang.Exception -> L26
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L30
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L26
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L26
            r1 = r6
            int r1 = r1.b()     // Catch: java.lang.Exception -> L26
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L26
            goto L30
        L26:
            r6 = move-exception
            java.lang.String r0 = "AnythinkBaseView"
            r1 = r6
            java.lang.String r1 = r1.getMessage()
            com.anythink.expressad.foundation.h.o.d(r0, r1)
        L30:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L55
            r1 = r0
            r1.<init>()     // Catch: org.json.JSONException -> L55
            r6 = r0
            r0 = r6
            java.lang.String r1 = com.anythink.expressad.foundation.g.a.ce     // Catch: org.json.JSONException -> L50
            r2 = r5
            r3 = r7
            org.json.JSONObject r2 = r2.a(r3)     // Catch: org.json.JSONException -> L50
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: org.json.JSONException -> L50
            r0 = r6
            java.lang.String r1 = "camp_position"
            r2 = r8
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: org.json.JSONException -> L50
            goto L5e
        L50:
            r9 = move-exception
            goto L59
        L55:
            r9 = move-exception
            r0 = 0
            r6 = r0
        L59:
            r0 = r9
            r0.printStackTrace()
        L5e:
            r0 = r5
            com.anythink.expressad.video.module.a.a r0 = r0.e
            if (r0 == 0) goto L71
            r0 = r5
            com.anythink.expressad.video.module.a.a r0 = r0.e
            r1 = 105(0x69, float:1.47E-43)
            r2 = r6
            r0.a(r1, r2)
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView.a(com.anythink.expressad.foundation.d.c, int, int):void");
    }

    static /* synthetic */ void a(AnyThinkOrderCampView anyThinkOrderCampView) {
        if (anyThinkOrderCampView.e != null) {
            anyThinkOrderCampView.e.a(104, "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView r5, com.anythink.expressad.foundation.d.c r6, int r7) {
        /*
            r0 = r6
            if (r0 == 0) goto L30
            r0 = r6
            boolean r0 = r0.j()
            if (r0 == 0) goto L30
            r0 = r6
            com.anythink.expressad.foundation.d.c$c r0 = r0.M()     // Catch: java.lang.Exception -> L26
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L30
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L26
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L26
            r1 = r6
            int r1 = r1.b()     // Catch: java.lang.Exception -> L26
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> L26
            goto L30
        L26:
            r6 = move-exception
            java.lang.String r0 = "AnythinkBaseView"
            r1 = r6
            java.lang.String r1 = r1.getMessage()
            com.anythink.expressad.foundation.h.o.d(r0, r1)
        L30:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L54
            r1 = r0
            r1.<init>()     // Catch: org.json.JSONException -> L54
            r6 = r0
            r0 = r6
            java.lang.String r1 = com.anythink.expressad.foundation.g.a.ce     // Catch: org.json.JSONException -> L50
            r2 = r5
            r3 = 0
            org.json.JSONObject r2 = r2.a(r3)     // Catch: org.json.JSONException -> L50
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: org.json.JSONException -> L50
            r0 = r6
            java.lang.String r1 = "camp_position"
            r2 = r7
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: org.json.JSONException -> L50
            goto L5b
        L50:
            r8 = move-exception
            goto L57
        L54:
            r8 = move-exception
            r0 = 0
            r6 = r0
        L57:
            r0 = r8
            r0.printStackTrace()
        L5b:
            r0 = r5
            com.anythink.expressad.video.module.a.a r0 = r0.e
            if (r0 == 0) goto L6e
            r0 = r5
            com.anythink.expressad.video.module.a.a r0 = r0.e
            r1 = 105(0x69, float:1.47E-43)
            r2 = r6
            r0.a(r1, r2)
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView.a(com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView, com.anythink.expressad.foundation.d.c, int):void");
    }

    private void b() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
        scaleAnimation.setDuration(500L);
        this.n.startAnimation(scaleAnimation);
    }

    private void e() {
        FeedBackButton feedBackButton = this.u;
        if (feedBackButton == null) {
            return;
        }
        List<c> list = this.o;
        if (list == null) {
            feedBackButton.setVisibility(8);
        } else if (list.get(0) == null) {
            this.u.setVisibility(8);
        } else if (!com.anythink.expressad.foundation.f.b.a().b()) {
            this.u.setVisibility(8);
        } else {
            this.t = this.o.get(0).K();
            this.b = this.o.get(0);
            com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
            a2.a(this.t + "_2", new AnonymousClass3());
            com.anythink.expressad.foundation.f.b a3 = com.anythink.expressad.foundation.f.b.a();
            a3.a(this.t + "_2", this.b);
            com.anythink.expressad.foundation.f.b a4 = com.anythink.expressad.foundation.f.b.a();
            a4.a(this.t + "_2", this.u);
        }
    }

    private void f() {
        if (this.v == null) {
            return;
        }
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
        if (b == null) {
            this.v.setVisibility(8);
            return;
        }
        String J = b.J();
        if (TextUtils.isEmpty(J)) {
            this.v.setVisibility(8);
        }
        this.v.setOnClickListener(new AnonymousClass4(J));
    }

    public void createView(final ViewGroup viewGroup) {
        if (this.o == null) {
            b bVar = this.y;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(com.anythink.expressad.video.dynview.a.a.E, this.x);
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c b = com.anythink.expressad.video.dynview.j.c.b(n.a().g(), this.o);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(b, new h() { // from class: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView.2
            @Override // com.anythink.expressad.video.dynview.f.h
            public final void a(com.anythink.expressad.video.dynview.a aVar) {
                try {
                    AnyThinkOrderCampView.this.n.addView(aVar.a());
                    AnyThinkOrderCampView.this.w = aVar.c();
                    viewGroup.removeAllViews();
                    viewGroup.addView(AnyThinkOrderCampView.this.n);
                    AnyThinkOrderCampView.this.setViewStatus();
                    if (AnyThinkOrderCampView.this.y != null) {
                        AnyThinkOrderCampView.this.y.a();
                    }
                } catch (Exception e) {
                    o.d(AnythinkBaseView.TAG, e.getMessage());
                }
            }

            @Override // com.anythink.expressad.video.dynview.f.h
            public final void a(com.anythink.expressad.video.dynview.c.b bVar2) {
                try {
                    if (AnyThinkOrderCampView.this.y != null) {
                        AnyThinkOrderCampView.this.y.b();
                    }
                } catch (Exception e) {
                    o.d(AnythinkBaseView.TAG, e.getMessage());
                }
            }
        }, hashMap);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        this.n = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c A[SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            r0 = r4
            super.onAttachedToWindow()
            r0 = r4
            java.util.List<com.anythink.expressad.foundation.d.c> r0 = r0.o
            if (r0 != 0) goto Lc
            return
        Lc:
            r0 = 0
            r5 = r0
        Le:
            r0 = r5
            r1 = r4
            java.util.List<com.anythink.expressad.foundation.d.c> r1 = r1.o
            int r1 = r1.size()
            if (r0 >= r1) goto L53
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L32
            r1 = r0
            r1.<init>()     // Catch: org.json.JSONException -> L32
            r6 = r0
            r0 = r6
            java.lang.String r1 = "camp_position"
            r2 = r5
            org.json.JSONObject r0 = r0.put(r1, r2)     // Catch: org.json.JSONException -> L2e
            goto L39
        L2e:
            r7 = move-exception
            goto L35
        L32:
            r7 = move-exception
            r0 = 0
            r6 = r0
        L35:
            r0 = r7
            r0.printStackTrace()
        L39:
            r0 = r4
            com.anythink.expressad.video.module.a.a r0 = r0.e
            if (r0 == 0) goto L4c
            r0 = r4
            com.anythink.expressad.video.module.a.a r0 = r0.e
            r1 = 110(0x6e, float:1.54E-43)
            r2 = r6
            r0.a(r1, r2)
        L4c:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto Le
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.dynview.widget.AnyThinkOrderCampView.onAttachedToWindow():void");
    }

    public void setCampOrderViewBuildCallback(b bVar) {
        this.y = bVar;
    }

    public void setCampaignExes(List<c> list) {
        this.o = list;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        this.p = i;
        this.q = i2;
        this.r = i3;
        this.s = i4;
        setViewStatus();
    }

    public void setRewarded(boolean z) {
        this.z = z;
    }

    public void setViewStatus() {
        AnyThinkOrderCampView anyThinkOrderCampView = this.n;
        if (anyThinkOrderCampView == null || !this.z) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) anyThinkOrderCampView.findViewById(filterFindViewId(this.w, "anythink_native_order_camp_controller"));
        this.u = (FeedBackButton) this.n.findViewById(filterFindViewId(this.w, "anythink_native_order_camp_feed_btn"));
        this.v = (ImageView) this.n.findViewById(filterFindViewId(this.w, "anythink_iv_link"));
        if (relativeLayout != null) {
            relativeLayout.setPadding(this.p, this.r, this.q, this.s);
        }
        FeedBackButton feedBackButton = this.u;
        if (feedBackButton != null && feedBackButton != null) {
            try {
                if (this.o == null) {
                    feedBackButton.setVisibility(8);
                } else if (this.o.get(0) == null) {
                    this.u.setVisibility(8);
                } else if (com.anythink.expressad.foundation.f.b.a().b()) {
                    this.t = this.o.get(0).K();
                    this.b = this.o.get(0);
                    com.anythink.expressad.foundation.f.b a2 = com.anythink.expressad.foundation.f.b.a();
                    a2.a(this.t + "_2", new AnonymousClass3());
                    com.anythink.expressad.foundation.f.b a3 = com.anythink.expressad.foundation.f.b.a();
                    a3.a(this.t + "_2", this.b);
                    com.anythink.expressad.foundation.f.b a4 = com.anythink.expressad.foundation.f.b.a();
                    a4.a(this.t + "_2", this.u);
                } else {
                    this.u.setVisibility(8);
                }
            } catch (Exception e) {
                o.d(AnythinkBaseView.TAG, e.getMessage());
            }
        }
        ImageView imageView = this.v;
        if (imageView == null || imageView == null) {
            return;
        }
        try {
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
            if (b == null) {
                this.v.setVisibility(8);
                return;
            }
            String J = b.J();
            if (TextUtils.isEmpty(J)) {
                this.v.setVisibility(8);
            }
            this.v.setOnClickListener(new AnonymousClass4(J));
        } catch (Exception e2) {
            o.d(AnythinkBaseView.TAG, e2.getMessage());
        }
    }

    public void startAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        this.n.startAnimation(alphaAnimation);
    }

    public void startTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(500L);
        this.n.startAnimation(translateAnimation);
    }
}
