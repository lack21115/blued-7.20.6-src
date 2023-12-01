package com.opos.mobad.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.cmn.an.j.b;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.o.b.d;
import com.opos.mobad.o.b.h;
import com.opos.mobad.o.b.k;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/a.class */
public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    protected InterfaceC0500a f11937a;

    /* renamed from: com.opos.mobad.activity.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/a$a.class */
    public interface InterfaceC0500a {
        void a(Bitmap bitmap, String str);
    }

    public a(Context context, d dVar, FrameLayout frameLayout) {
        super(context, dVar, frameLayout, true);
        this.f11937a = new InterfaceC0500a() { // from class: com.opos.mobad.activity.a.1
            @Override // com.opos.mobad.activity.a.InterfaceC0500a
            public void a(final Bitmap bitmap, final String str) {
                if (a.this.l == null || bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                a.this.G.post(new Runnable() { // from class: com.opos.mobad.activity.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.l == null || bitmap.isRecycled() || TextUtils.isEmpty(str) || !str.equals(a.this.l.getTag())) {
                            return;
                        }
                        a.this.l.setImageBitmap(bitmap);
                    }
                });
            }
        };
    }

    @Override // com.opos.mobad.o.b.a
    public void a() {
        l();
    }

    @Override // com.opos.mobad.o.b.e
    public void a(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("MediaCreative", "onErrorRetryClick " + k.a().c(this.A));
        if (com.opos.cmn.an.h.c.a.d(this.b)) {
            aa();
            if (k.a().c(this.A) == -1) {
                k.a().c(this.b, this.A, this.f13354c != null ? this.f13354c.P() : 2, this.n, this, this.E);
            } else {
                k.a().a(this.b, this.A, this.f13354c != null ? this.f13354c.P() : 2, this.n, this, this.E);
            }
        }
    }

    @Override // com.opos.mobad.o.b.a
    public void a(View view, int[] iArr, int i) {
        if (i != 1 && i != 2) {
            if (i == 3 && k.a().c(this.A) == 2) {
                U();
                k.a().b(this.A);
                return;
            }
            return;
        }
        if (k.a().c(this.A) == -1 || k.a().c(this.A) == 0 || k.a().c(this.A) == 5) {
            N();
            k.a().a(this.b, this.A, this.f13354c != null ? this.f13354c.P() : 2, this.n, this, this.E);
        } else {
            k.a().a(this.A, this.n);
        }
        V();
    }

    public void a(AdItemData adItemData, String str) {
        if (adItemData != null) {
            this.f13354c = adItemData;
            this.A = str;
            if (this.D != null) {
                b(!this.f13354c.D());
            }
            com.opos.cmn.an.f.a.b("MediaCreative", "mAdItemData:" + this.f13354c);
            MaterialData materialData = adItemData.i().get(0);
            if (materialData != null) {
                List<MaterialFileData> f = materialData.f();
                if (f != null && f.size() > 0 && f.get(0) != null) {
                    String a2 = f.get(0).a();
                    if (!TextUtils.isEmpty(a2) && (!a2.equals(this.l.getTag()) || this.m == null)) {
                        a(a2);
                    }
                }
                a(this.n, 4);
                if (!com.opos.cmn.an.h.c.a.d(this.b)) {
                    ah();
                    if (this.u != null) {
                        this.u.a(10403, "no net,can't play video.");
                    }
                } else if (!com.opos.cmn.an.h.c.a.e(this.b) && !materialData.X()) {
                    Z();
                } else {
                    Y();
                    k.a().b(this.b, str, this.f13354c != null ? this.f13354c.P() : 2, this.n, this, this.E);
                }
            }
        }
    }

    @Override // com.opos.mobad.o.b.h
    public void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b.c(new Runnable() { // from class: com.opos.mobad.activity.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.l.setTag(str);
                a aVar = a.this;
                aVar.m = g.a(str, com.opos.cmn.an.h.f.a.b(aVar.b), (com.opos.cmn.an.h.f.a.b(a.this.b) * 9) / 16);
                if (a.this.m != null) {
                    a.this.f11937a.a(a.this.m, str);
                }
            }
        });
    }

    public void a(boolean z) {
        if (z) {
            try {
                if (com.opos.cmn.an.h.b.a.b(this.b) == 0) {
                    c(false);
                    return;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MediaCreative", "", (Throwable) e);
                return;
            }
        }
        c(true);
    }

    public void b() {
        this.u = null;
    }

    @Override // com.opos.mobad.o.b.e
    public void b(View view, int[] iArr) {
        if (k.a() != null) {
            aa();
            k.a().a(this.b, this.A, this.f13354c != null ? this.f13354c.P() : 2, this.n, this, this.E);
        }
    }
}
