package com.opos.mobad.a.a;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.h;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/a/a/a.class */
public class a implements com.opos.mobad.n.a {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.a.b f11917a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.n.a f11918c;
    private com.opos.mobad.c.d.a d;

    public a(Context context, com.opos.mobad.n.a aVar) {
        this.b = context.getApplicationContext();
        com.opos.mobad.c.d.a aVar2 = new com.opos.mobad.c.d.a(context);
        this.d = aVar2;
        aVar2.a(new a.InterfaceC0508a() { // from class: com.opos.mobad.a.a.a.1
            @Override // com.opos.mobad.c.d.a.InterfaceC0508a
            public void a(boolean z) {
                if (a.this.f11917a != null) {
                    a.this.f11917a.a(z);
                }
            }
        });
        this.f11918c = aVar;
        this.d.addView(aVar.c(), new RelativeLayout.LayoutParams(-1, -2));
        if (Build.VERSION.SDK_INT >= 29) {
            this.d.setForceDarkAllowed(false);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0538a interfaceC0538a) {
        this.f11917a = (com.opos.mobad.a.b) interfaceC0538a;
        this.f11918c.a(interfaceC0538a);
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        com.opos.mobad.n.a aVar;
        if (hVar != null && (aVar = this.f11918c) != null) {
            aVar.a(hVar);
            return;
        }
        com.opos.cmn.an.f.a.b("BannerNewTemplate", "render fail for null =" + this.f11918c);
        com.opos.mobad.a.b bVar = this.f11917a;
        if (bVar != null) {
            bVar.b(1);
        }
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.d;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.mobad.n.a aVar = this.f11918c;
        if (aVar != null) {
            aVar.d();
        }
        this.d.removeAllViews();
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        com.opos.mobad.n.a aVar = this.f11918c;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }
}
