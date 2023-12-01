package com.opos.cmn.e.a.c.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.opos.cmn.e.a.c.d.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/c/a/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f11090a;
    protected c b;

    /* renamed from: c  reason: collision with root package name */
    protected RelativeLayout f11091c;
    protected ImageView d;
    protected int[] e = new int[4];

    public a(Context context, c cVar) {
        this.f11090a = context.getApplicationContext();
        this.b = cVar;
        c();
        b();
    }

    private void c() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f11090a);
        this.f11091c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.b(this.f11090a), com.opos.cmn.an.h.f.a.a(this.f11090a, 90.0f)));
        com.opos.cmn.e.a.d.a.a(this.f11091c, com.opos.cmn.an.d.a.a.c(this.f11090a, "opos_module_biz_ui_cmn_reminder_toast_bg_img.png"));
        d();
    }

    private void d() {
        ImageView imageView = new ImageView(this.f11090a);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11090a, 16.0f), com.opos.cmn.an.h.f.a.a(this.f11090a, 16.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        this.f11091c.addView(this.d, layoutParams);
    }

    public View a() {
        return this.f11091c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        view.setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final View view, final String str) {
        view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.e));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.e.a.c.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                a.this.b.a(view, a.this.e, str, new Object[0]);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final String str) {
        this.d.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.e));
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.e.a.c.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                a.this.b.b(a.this.d, a.this.e, str, new Object[0]);
            }
        });
    }

    public abstract void a(String str, boolean z, Object... objArr);

    public abstract void b();
}
