package com.anythink.expressad.video.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.video.dynview.a;
import com.anythink.expressad.video.dynview.c.b;
import com.anythink.expressad.video.dynview.f.h;
import com.anythink.expressad.video.module.a.a.e;
import com.anythink.expressad.video.signal.f;
import com.bytedance.applog.tracker.Tracker;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkClickCTAView.class */
public class AnythinkClickCTAView extends AnythinkBaseView implements f {
    private static final String n = "anythink_reward_clickable_cta";
    private ViewGroup o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private String t;
    private float u;
    private float v;
    private int w;
    private ObjectAnimator x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.video.module.AnythinkClickCTAView$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkClickCTAView$1.class */
    public final class AnonymousClass1 implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f5602a;

        AnonymousClass1(ViewGroup viewGroup) {
            this.f5602a = viewGroup;
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(a aVar) {
            this.f5602a.addView(aVar.a());
            AnythinkClickCTAView anythinkClickCTAView = AnythinkClickCTAView.this;
            anythinkClickCTAView.f = anythinkClickCTAView.f();
            AnythinkClickCTAView anythinkClickCTAView2 = AnythinkClickCTAView.this;
            anythinkClickCTAView2.r = (TextView) anythinkClickCTAView2.findViewById(anythinkClickCTAView2.findID("anythink_tv_desc"));
            AnythinkClickCTAView.this.c();
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(b bVar) {
            o.d(AnythinkBaseView.TAG, "errorMsg:" + bVar.b());
        }
    }

    public AnythinkClickCTAView(Context context) {
        super(context);
    }

    public AnythinkClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        int findLayout = findLayout(n);
        if (findLayout >= 0) {
            this.f5601c.inflate(findLayout, this);
            this.f = f();
            c();
            setWrapContent();
        }
    }

    private void a(ViewGroup viewGroup, c cVar) {
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c b = com.anythink.expressad.video.dynview.j.c.b(viewGroup, cVar);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(b, new AnonymousClass1(viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    static /* synthetic */ void b(AnythinkClickCTAView anythinkClickCTAView) {
        JSONObject jSONObject;
        if (anythinkClickCTAView.b != null) {
            anythinkClickCTAView.b.j();
        }
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
            jSONObject = null;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, anythinkClickCTAView.a(0));
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            anythinkClickCTAView.e.a(105, jSONObject);
        }
        anythinkClickCTAView.e.a(105, jSONObject);
    }

    private void e() {
        setWrapContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        this.o = (ViewGroup) findViewById(findID("anythink_viewgroup_ctaroot"));
        this.p = (ImageView) findViewById(findID("anythink_iv_appicon"));
        this.q = (TextView) findViewById(findID("anythink_tv_title"));
        TextView textView = (TextView) findViewById(findID("anythink_tv_install"));
        this.s = textView;
        return isNotNULL(this.o, this.p, this.q, textView);
    }

    private void g() {
        JSONObject jSONObject;
        if (this.b != null) {
            this.b.j();
        }
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
            jSONObject = null;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, a(0));
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            this.e.a(105, jSONObject);
        }
        this.e.a(105, jSONObject);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    protected final void c() {
        super.c();
        if (this.f) {
            if (this.b != null && this.b.j()) {
                setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkClickCTAView.2
                    @Override // com.anythink.expressad.widget.a
                    public final void a(View view) {
                        AnythinkClickCTAView.b(AnythinkClickCTAView.this);
                    }
                });
            }
            this.s.setOnClickListener(new com.anythink.expressad.widget.a() { // from class: com.anythink.expressad.video.module.AnythinkClickCTAView.3
                @Override // com.anythink.expressad.widget.a
                public final void a(View view) {
                    AnythinkClickCTAView.b(AnythinkClickCTAView.this);
                }
            });
            ImageView imageView = this.p;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkClickCTAView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                    }
                });
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.x;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.x;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.u = motionEvent.getRawX();
        this.v = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.w = configuration.orientation;
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        if (this.b != null) {
            if (this.b.j()) {
                c cVar = this.b;
                new com.anythink.expressad.video.dynview.j.c();
                com.anythink.expressad.video.dynview.c b = com.anythink.expressad.video.dynview.j.c.b(this, cVar);
                com.anythink.expressad.video.dynview.b.a();
                com.anythink.expressad.video.dynview.b.a(b, new AnonymousClass1(this));
            } else {
                int findLayout = findLayout(n);
                if (findLayout >= 0) {
                    this.f5601c.inflate(findLayout, this);
                    this.f = f();
                    c();
                    setWrapContent();
                }
            }
            if (this.f) {
                this.s.setText(this.b.cU);
                if (TextUtils.isEmpty(this.b.bd())) {
                    b();
                } else {
                    com.anythink.expressad.foundation.g.d.b.a(this.f5600a.getApplicationContext()).a(this.b.bd(), new e(this.p, this.b, this.t) { // from class: com.anythink.expressad.video.module.AnythinkClickCTAView.5
                        @Override // com.anythink.expressad.video.module.a.a.e, com.anythink.expressad.foundation.g.d.c
                        public final void a(String str, String str2) {
                            super.a(str, str2);
                            AnythinkClickCTAView.this.b();
                        }
                    });
                }
                if (this.q != null && !TextUtils.isEmpty(this.b.bb())) {
                    this.q.setText(this.b.bb());
                }
                if (this.r == null || TextUtils.isEmpty(this.b.bc())) {
                    return;
                }
                this.r.setText(this.b.bc());
            }
        }
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.x = objectAnimator;
    }

    public void setUnitId(String str) {
        this.t = str;
    }
}
