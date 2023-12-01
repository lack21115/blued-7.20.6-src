package com.anythink.expressad.video.dynview.i.a;

import android.graphics.Bitmap;
import android.view.View;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.video.dynview.c;
import com.anythink.expressad.video.dynview.g.a;
import com.anythink.expressad.video.dynview.i.b;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/i/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f5533a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f5534c;
    private Bitmap d;

    private a() {
    }

    public static a a() {
        a aVar;
        if (f5533a == null) {
            synchronized (a.class) {
                try {
                    if (f5533a == null) {
                        f5533a = new a();
                    }
                    aVar = f5533a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
        return f5533a;
    }

    private void a(int i, float f, float f2, Bitmap bitmap, Bitmap bitmap2) {
        synchronized (this) {
            a.C0090a a2 = com.anythink.expressad.video.dynview.g.a.a();
            a2.a(i).a(bitmap).b(bitmap2);
            if (i != 2) {
                a2.a(f).b(f2);
            } else if (f > f2) {
                a2.a(f).b(f2);
            } else {
                a2.a(f2).b(f);
            }
            this.b.setBackgroundDrawable(a2.b());
        }
    }

    public final void a(Map map, c cVar, View view) {
        Bitmap bitmap;
        List<com.anythink.expressad.foundation.d.c> g;
        this.b = view;
        int e = cVar.e();
        float d = cVar.d();
        float c2 = cVar.c();
        if (map != null && map.size() > 1 && (g = cVar.g()) != null && g.size() > 1) {
            if (map.get(p.a(g.get(0).be())) != null && (map.get(p.a(g.get(0).be())) instanceof Bitmap)) {
                Bitmap bitmap2 = (Bitmap) map.get(p.a(g.get(0).be()));
                if (g.get(0) != null && bitmap2 != null && !bitmap2.isRecycled()) {
                    b.a();
                    this.f5534c = b.a(bitmap2, 0);
                }
            }
            if (map.get(p.a(g.get(1).be())) != null && (map.get(p.a(g.get(1).be())) instanceof Bitmap)) {
                Bitmap bitmap3 = (Bitmap) map.get(p.a(g.get(1).be()));
                if (g.get(1) != null && !bitmap3.isRecycled()) {
                    b.a();
                    this.d = b.a(bitmap3, 1);
                }
            }
        }
        Bitmap bitmap4 = this.f5534c;
        if (bitmap4 == null || bitmap4.isRecycled() || (bitmap = this.d) == null || bitmap.isRecycled()) {
            return;
        }
        a(e, d, c2, this.f5534c, this.d);
    }

    public final void b() {
        if (this.b != null) {
            this.b = null;
        }
        Bitmap bitmap = this.f5534c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5534c.recycle();
            this.f5534c = null;
        }
        Bitmap bitmap2 = this.d;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.d.recycle();
        this.d = null;
    }
}
