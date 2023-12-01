package com.opos.mobad.h.c.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/c/a/b.class */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.h.e.a.a f12507a;
    private com.opos.mobad.h.a.a b;

    public b(Context context, com.opos.mobad.h.a.a aVar, FrameLayout frameLayout) {
        this.f12507a = new com.opos.mobad.h.e.a.b(context, this, frameLayout);
        this.b = aVar;
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a() {
        this.f12507a.b();
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(int i, String str) {
        this.b.a(i, str);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(View view, AdItemData adItemData) {
        this.b.a(view, adItemData);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(View view, AdItemData adItemData, long j) {
        this.b.a(view, adItemData, j);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(View view, int[] iArr, long j, com.opos.mobad.cmn.a.b.a aVar) {
        this.b.a(view, iArr, j, aVar);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(AdItemData adItemData) {
        this.f12507a.a(adItemData);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(AdItemData adItemData, String str) {
        this.f12507a.a(adItemData, str);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void b() {
        this.f12507a.c();
    }

    @Override // com.opos.mobad.h.c.a.a
    public void b(View view, AdItemData adItemData) {
        this.b.b(view, adItemData);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void b(View view, AdItemData adItemData, long j) {
        com.opos.mobad.h.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b(view, adItemData, j);
        }
    }

    @Override // com.opos.mobad.h.c.a.a
    public void b(AdItemData adItemData, String str) {
        this.f12507a.b(adItemData, str);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void c(View view, AdItemData adItemData, long j) {
        this.b.c(view, adItemData, j);
    }
}
