package com.opos.mobad.h.e.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.o.b.j;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/e/a/b.class */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private j f12517a;
    private com.opos.mobad.h.c.a.a b;

    public b(Context context, com.opos.mobad.h.c.a.a aVar, FrameLayout frameLayout) {
        this.f12517a = new j(context, this, frameLayout);
        this.b = aVar;
    }

    @Override // com.opos.mobad.o.b.d
    public void a() {
    }

    @Override // com.opos.mobad.o.b.d
    public void a(int i, String str) {
        com.opos.mobad.h.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    @Override // com.opos.mobad.o.b.d
    public void a(long j) {
    }

    @Override // com.opos.mobad.o.b.d
    public void a(View view, AdItemData adItemData) {
        com.opos.mobad.h.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(view, adItemData);
        }
    }

    @Override // com.opos.mobad.o.b.d
    public void a(View view, AdItemData adItemData, long j) {
        com.opos.mobad.h.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.a(view, adItemData, j);
        }
    }

    @Override // com.opos.mobad.o.b.d
    public void a(View view, int[] iArr, long j, com.opos.mobad.cmn.a.b.a aVar) {
        com.opos.mobad.h.c.a.a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(view, iArr, j, aVar);
        }
    }

    @Override // com.opos.mobad.h.e.a.a
    public void a(AdItemData adItemData) {
        this.f12517a.b(adItemData);
    }

    @Override // com.opos.mobad.h.e.a.a
    public void a(AdItemData adItemData, String str) {
        this.f12517a.a(adItemData, str);
    }

    @Override // com.opos.mobad.h.e.a.a
    public void b() {
        this.f12517a.b();
    }

    @Override // com.opos.mobad.o.b.d
    public void b(View view, AdItemData adItemData) {
        com.opos.mobad.h.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b(view, adItemData);
        }
    }

    @Override // com.opos.mobad.o.b.d
    public void b(View view, AdItemData adItemData, long j) {
        com.opos.mobad.h.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b(view, adItemData, j);
        }
    }

    @Override // com.opos.mobad.h.e.a.a
    public void b(AdItemData adItemData, String str) {
        this.f12517a.b(adItemData, str);
    }

    @Override // com.opos.mobad.h.e.a.a
    public void c() {
        this.f12517a.Q();
    }

    @Override // com.opos.mobad.o.b.d
    public void c(View view, AdItemData adItemData, long j) {
        com.opos.mobad.h.c.a.a aVar = this.b;
        if (aVar != null) {
            aVar.c(view, adItemData, j);
        }
    }
}
