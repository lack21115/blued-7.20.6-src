package com.opos.mobad.o.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.cmn.a.b.g;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC0721a f27083a;
    private FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f27084c;
    private int[] d = new int[4];
    private volatile boolean e = false;

    /* renamed from: com.opos.mobad.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/c/a$a.class */
    public interface InterfaceC0721a {
        void a_(View view, int[] iArr);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/c/a$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f27087a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f27088c;

        public b(String str, int i, int i2) {
            this.f27087a = str;
            if (i <= 0) {
                this.b = 75;
            } else {
                this.b = i;
            }
            if (i2 <= 0) {
                this.f27088c = 75;
            } else {
                this.f27088c = i2;
            }
        }
    }

    public a(Context context, InterfaceC0721a interfaceC0721a) {
        this.f27083a = interfaceC0721a;
        this.b = new FrameLayout(context);
        ImageView imageView = new ImageView(context);
        this.f27084c = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f27084c.setVisibility(0);
        this.b.addView(this.f27084c, new FrameLayout.LayoutParams(-1, -1));
        this.b.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.d));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (a.this.f27083a != null) {
                    a.this.f27083a.a_(a.this.b, a.this.d);
                }
            }
        });
        this.b.setClickable(true);
        this.b.setVisibility(0);
    }

    public View a() {
        return this.b;
    }

    public void a(final b bVar) {
        if (this.e || TextUtils.isEmpty(bVar.f27087a)) {
            com.opos.cmn.an.f.a.b("Pendant", "hasDestroy or empty img");
        } else {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.o.c.a.2
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap a2;
                    if (a.this.e || (a2 = g.a(bVar.f27087a, bVar.b, bVar.f27088c)) == null) {
                        return;
                    }
                    a.this.f27084c.setImageBitmap(a2);
                }
            });
        }
    }

    public void b() {
        this.e = true;
        this.f27083a = null;
        this.b.removeAllViews();
    }
}
