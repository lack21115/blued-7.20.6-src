package com.anythink.expressad.foundation.f.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.anythink.core.common.b.n;
import com.anythink.expressad.d.a;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.widget.FeedBackButton;
import com.anythink.expressad.widget.FeedbackRadioGroup;
import com.anythink.expressad.widget.a.b;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/f/a/a.class */
public final class a {
    private static int n = -1;
    private static String s;

    /* renamed from: a  reason: collision with root package name */
    private String f7809a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private FeedBackButton f7810c;
    private int d;
    private int e;
    private String j;
    private String k;
    private com.anythink.expressad.widget.a.c p;
    private List<C0144a> q;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private float l = 1.0f;
    private int m = t.b(n.a().g(), 20.0f);
    private int o = n;
    private b r = new b() { // from class: com.anythink.expressad.foundation.f.a.a.1
        @Override // com.anythink.expressad.widget.a.b
        public final void a() {
            a.a(a.this);
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void b() {
            a.b(a.this);
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void c() {
            a.c(a.this);
        }
    };

    /* renamed from: com.anythink.expressad.foundation.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/f/a/a$a.class */
    public static final class C0144a implements b {

        /* renamed from: a  reason: collision with root package name */
        private com.anythink.expressad.foundation.f.a f7816a;
        private String b;

        public C0144a(String str, com.anythink.expressad.foundation.f.a aVar) {
            this.f7816a = aVar;
            this.b = str;
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void a() {
            com.anythink.expressad.foundation.f.b.f7818c = false;
            com.anythink.expressad.foundation.f.a aVar = this.f7816a;
            if (aVar != null) {
                String unused = a.s;
                aVar.c();
            }
        }

        public final void a(boolean z) {
            com.anythink.expressad.foundation.f.b.f7818c = true;
            com.anythink.expressad.foundation.f.a aVar = this.f7816a;
            if (aVar == null || !z) {
                return;
            }
            aVar.a();
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void b() {
            com.anythink.expressad.foundation.f.b.f7818c = false;
            com.anythink.expressad.foundation.f.a aVar = this.f7816a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void c() {
        }
    }

    public a(String str) {
        this.q = new ArrayList();
        this.f7809a = str;
        if (this.q == null) {
            this.q = new ArrayList();
        }
        g();
        n();
        h();
    }

    private static FeedbackRadioGroup a(a.b bVar) {
        JSONArray d = bVar.d();
        Context g = n.a().g();
        if (d == null || d.length() <= 0 || g == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(g);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    private void a(RadioButton radioButton) {
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.anythink.expressad.foundation.f.a.a.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (z) {
                    String unused = a.s = (String) compoundButton.getText();
                }
                if (a.this.p != null) {
                    a.this.p.a(!TextUtils.isEmpty(a.s));
                }
            }
        });
    }

    static /* synthetic */ void a(a aVar) {
        List<C0144a> list = aVar.q;
        if (list != null) {
            for (C0144a c0144a : list) {
                if (c0144a != null) {
                    c0144a.a();
                }
            }
        }
        s = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.anythink.expressad.widget.FeedbackRadioGroup r7, com.anythink.expressad.d.a.b r8) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.f.a.a.a(com.anythink.expressad.widget.FeedbackRadioGroup, com.anythink.expressad.d.a$b):void");
    }

    private void a(boolean z) {
        List<C0144a> list = this.q;
        if (list != null) {
            for (C0144a c0144a : list) {
                if (c0144a != null) {
                    c0144a.a(z);
                }
            }
        }
    }

    private void b(C0144a c0144a) {
        List<C0144a> list = this.q;
        if (list != null) {
            list.remove(c0144a);
        }
    }

    static /* synthetic */ void b(a aVar) {
        List<C0144a> list = aVar.q;
        if (list != null) {
            for (C0144a c0144a : list) {
                if (c0144a != null) {
                    c0144a.b();
                }
            }
        }
        s = "";
    }

    static /* synthetic */ void c(a aVar) {
        List<C0144a> list = aVar.q;
        if (list != null) {
            Iterator<C0144a> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    private void g() {
        if (this.r == null) {
            this.r = new b() { // from class: com.anythink.expressad.foundation.f.a.a.2
                @Override // com.anythink.expressad.widget.a.b
                public final void a() {
                    a.a(a.this);
                }

                @Override // com.anythink.expressad.widget.a.b
                public final void b() {
                    a.b(a.this);
                }

                @Override // com.anythink.expressad.widget.a.b
                public final void c() {
                    a.c(a.this);
                }
            };
        }
    }

    private void h() {
        try {
            com.anythink.expressad.foundation.f.b.a();
            if (com.anythink.expressad.foundation.f.b.a(n.a().g()) != null) {
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.foundation.b.a.b().e();
                com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
                com.anythink.expressad.d.a aVar = b;
                if (b == null) {
                    com.anythink.expressad.d.b.a();
                    aVar = com.anythink.expressad.d.b.c();
                }
                a.b L = aVar.L();
                if (L == null) {
                    o.b("", "feedback fbk is null");
                    return;
                }
                g();
                com.anythink.expressad.foundation.f.b.a();
                this.p = new com.anythink.expressad.widget.a.c(com.anythink.expressad.foundation.f.b.a(n.a().g()), this.r);
                FeedbackRadioGroup a2 = a(L);
                this.p.c(L.c());
                this.p.b(L.b());
                this.p.a(L.a());
                this.p.a(a2);
                this.p.a(!TextUtils.isEmpty(s));
                a(a2, L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void i() {
        List<C0144a> list = this.q;
        if (list != null) {
            for (C0144a c0144a : list) {
                if (c0144a != null) {
                    c0144a.b();
                }
            }
        }
        s = "";
    }

    private void j() {
        List<C0144a> list = this.q;
        if (list != null) {
            for (C0144a c0144a : list) {
                if (c0144a != null) {
                    c0144a.a();
                }
            }
        }
        s = "";
    }

    private void k() {
        List<C0144a> list = this.q;
        if (list != null) {
            Iterator<C0144a> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    private String l() {
        return this.f7809a;
    }

    private void m() {
        FeedBackButton feedBackButton = this.f7810c;
        if (feedBackButton != null) {
            int i = this.f;
            if (i >= 0) {
                feedBackButton.setX(i);
            }
            int i2 = this.g;
            if (i2 >= 0) {
                this.f7810c.setY(i2);
            }
            float f = this.l;
            if (f >= 0.0f) {
                this.f7810c.setAlpha(f);
                this.f7810c.setEnabled(this.l != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.f7810c.getLayoutParams();
            int i3 = this.h;
            if (i3 > 0) {
                this.f7810c.setWidth(i3);
                if (layoutParams != null) {
                    layoutParams.width = this.h;
                }
            }
            int i4 = this.i;
            if (i4 > 0) {
                this.f7810c.setHeight(i4);
                if (layoutParams != null) {
                    layoutParams.height = this.i;
                }
            }
            if (layoutParams != null) {
                this.f7810c.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.j)) {
                    this.f7810c.setTextColor(Color.parseColor(this.j));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i5 = this.m;
            if (i5 > 0) {
                gradientDrawable.setCornerRadius(i5);
            }
            if (TextUtils.isEmpty(this.k)) {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            } else {
                gradientDrawable.setColor(Color.parseColor(this.k));
            }
            try {
                this.f7810c.setBackgroundDrawable(gradientDrawable);
            } catch (Throwable th) {
            }
        }
    }

    private void n() {
        Context g = n.a().g();
        if (g != null) {
            try {
                FeedBackButton feedBackButton = new FeedBackButton(g);
                this.f7810c = feedBackButton;
                int i = 8;
                if (this.o != 8) {
                    i = 0;
                }
                feedBackButton.setVisibility(i);
                this.f7810c.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.foundation.f.a.a.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                        a.this.a();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int o() {
        return this.d;
    }

    private int p() {
        return this.e;
    }

    public final void a() {
        com.anythink.expressad.foundation.f.b.a();
        Activity a2 = com.anythink.expressad.foundation.f.b.a(n.a().g());
        com.anythink.expressad.widget.a.c cVar = this.p;
        if (cVar == null || cVar.getContext() != a2) {
            h();
        }
        Context g = n.a().g();
        FeedBackButton feedBackButton = this.f7810c;
        if (feedBackButton != null) {
            g = feedBackButton.getContext();
        }
        com.anythink.expressad.foundation.f.b.a();
        boolean a3 = com.anythink.expressad.foundation.f.b.a(g, this.p);
        List<C0144a> list = this.q;
        if (list != null) {
            for (C0144a c0144a : list) {
                if (c0144a != null) {
                    c0144a.a(a3);
                }
            }
        }
    }

    public final void a(int i) {
        this.o = i;
        FeedBackButton feedBackButton = this.f7810c;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i);
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, float f, String str, String str2) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = i4;
        this.j = str;
        this.k = str2;
        this.l = f;
        this.m = i5;
        m();
    }

    public final void a(c cVar) {
        this.b = cVar;
    }

    public final void a(C0144a c0144a) {
        if (this.q == null) {
            this.q = new ArrayList();
        }
        this.q.add(c0144a);
    }

    public final void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.f7810c;
        int i = 8;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.l);
            feedBackButton.setEnabled(this.l != 0.0f);
            if (this.o != 8) {
                i = 0;
            }
            feedBackButton.setVisibility(i);
            this.f7810c = feedBackButton;
            c cVar = this.b;
            if (cVar != null && !cVar.j()) {
                m();
            }
            feedBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.foundation.f.a.a.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    a.this.a();
                }
            });
        }
    }

    public final void b() {
        com.anythink.expressad.widget.a.c cVar = this.p;
        if (cVar == null || !cVar.isShowing()) {
            return;
        }
        this.p.cancel();
    }

    public final void b(int i) {
        this.d = i;
    }

    public final FeedBackButton c() {
        if (this.f7810c == null) {
            n();
        }
        return this.f7810c;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final void d() {
        FeedBackButton feedBackButton = this.f7810c;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener(null);
            this.f7810c.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.f7810c.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f7810c);
            }
        }
        com.anythink.expressad.widget.a.c cVar = this.p;
        if (cVar != null) {
            cVar.a((b) null);
        }
        this.p = null;
        this.q = null;
        this.f7810c = null;
        this.r = null;
    }

    public final c e() {
        return this.b;
    }
}
