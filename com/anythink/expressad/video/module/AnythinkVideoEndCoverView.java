package com.anythink.expressad.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.g.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.module.a.a.j;
import com.anythink.expressad.video.signal.f;
import com.anythink.expressad.video.signal.factory.b;
import com.bytedance.applog.tracker.Tracker;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkVideoEndCoverView.class */
public class AnythinkVideoEndCoverView extends AnythinkBaseView implements f {
    private final String n;
    private View o;
    private ImageView p;
    private ImageView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private b u;

    public AnythinkVideoEndCoverView(Context context) {
        super(context);
        this.n = "AnythinkVideoEndCoverView";
    }

    public AnythinkVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = "AnythinkVideoEndCoverView";
    }

    private boolean a(View view) {
        if (view != null) {
            try {
                this.p = (ImageView) view.findViewById(findID("anythink_vec_iv_icon"));
                this.q = (ImageView) view.findViewById(findID("anythink_vec_iv_close"));
                this.r = (TextView) view.findViewById(findID("anythink_vec_tv_title"));
                this.s = (TextView) view.findViewById(findID("anythink_vec_tv_desc"));
                this.t = (TextView) view.findViewById(findID("anythink_vec_btn"));
                return true;
            } catch (Throwable th) {
                o.d("AnythinkVideoEndCoverView", th.getMessage());
                return false;
            }
        }
        return true;
    }

    private void b() {
        View view = this.o;
        if (view == null) {
            init(this.f8440a);
            preLoadData(this.u);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.o.getParent()).removeView(this.o);
        }
        addView(this.o);
        a(this.o);
        c();
    }

    private void e() {
        ImageView imageView;
        if (this.b != null) {
            if (!TextUtils.isEmpty(this.b.bd()) && (imageView = this.p) != null) {
                com.anythink.expressad.foundation.g.d.b.a(this.f8440a.getApplicationContext()).a(this.b.bd(), new j(imageView, t.b(n.a().g(), 8.0f)));
            }
            TextView textView = this.r;
            if (textView != null) {
                textView.setText(this.b.bb());
            }
            TextView textView2 = this.t;
            if (textView2 != null) {
                textView2.setText(this.b.cU);
            }
            TextView textView3 = this.s;
            if (textView3 != null) {
                textView3.setText(this.b.bc());
            }
        }
    }

    protected final void a() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONException e;
        JSONObject jSONObject3;
        try {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(a.cc, t.a(n.a().g(), this.g));
                    jSONObject2.put(a.cd, t.a(n.a().g(), this.h));
                    jSONObject2.put(a.cf, 0);
                    try {
                        this.d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    jSONObject2.put(a.cg, this.d);
                    jSONObject2.put(a.ch, t.c(getContext()));
                    jSONObject3 = jSONObject2;
                } catch (JSONException e3) {
                    e = e3;
                    o.d("AnythinkVideoEndCoverView", e.getMessage());
                    jSONObject3 = jSONObject2;
                    jSONObject = new JSONObject();
                    jSONObject.put(a.ce, jSONObject3);
                    this.e.a(105, jSONObject);
                }
            } catch (JSONException e4) {
                jSONObject2 = jSONObject4;
                e = e4;
            }
            jSONObject = new JSONObject();
        } catch (JSONException e5) {
            e = e5;
            jSONObject = null;
        }
        try {
            jSONObject.put(a.ce, jSONObject3);
        } catch (JSONException e6) {
            e = e6;
            e.printStackTrace();
            this.e.a(105, jSONObject);
        }
        this.e.a(105, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public final void c() {
        super.c();
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoEndCoverView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                AnythinkVideoEndCoverView.this.e.a(104, "");
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoEndCoverView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                AnythinkVideoEndCoverView.this.a();
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.module.AnythinkVideoEndCoverView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                AnythinkVideoEndCoverView.this.a();
            }
        });
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(Context context) {
        int findLayout = findLayout("anythink_reward_videoend_cover");
        if (findLayout >= 0) {
            View inflate = this.f8441c.inflate(findLayout, (ViewGroup) null);
            this.o = inflate;
            if (inflate != null) {
                this.f = a(inflate);
                addView(this.o, -1, -1);
                c();
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.g = motionEvent.getRawX();
        this.h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.d = configuration.orientation;
        removeView(this.o);
        View view = this.o;
        if (view == null) {
            init(this.f8440a);
            preLoadData(this.u);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.o.getParent()).removeView(this.o);
        }
        addView(this.o);
        a(this.o);
        c();
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        this.u = bVar;
        try {
            if (this.b == null || !this.f || this.b == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.b.bd()) && this.p != null) {
                com.anythink.expressad.foundation.g.d.b.a(this.f8440a.getApplicationContext()).a(this.b.bd(), new j(this.p, t.b(n.a().g(), 8.0f)));
            }
            if (this.r != null) {
                this.r.setText(this.b.bb());
            }
            if (this.t != null) {
                this.t.setText(this.b.cU);
            }
            if (this.s != null) {
                this.s.setText(this.b.bc());
            }
        } catch (Throwable th) {
            o.a("AnythinkVideoEndCoverView", th.getMessage());
        }
    }
}
