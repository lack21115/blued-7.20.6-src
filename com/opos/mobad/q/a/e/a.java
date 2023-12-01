package com.opos.mobad.q.a.e;

import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.q.a.m;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/e/a.class */
public abstract class a extends com.opos.mobad.service.event.a implements b.InterfaceC0687b, m.a {

    /* renamed from: a  reason: collision with root package name */
    private b.InterfaceC0687b f27174a;

    public a() {
        this(null);
    }

    public a(EventDescription eventDescription) {
        super(eventDescription);
    }

    public void a(b.InterfaceC0687b interfaceC0687b) {
        this.f27174a = interfaceC0687b;
    }

    public void a(AdItemData adItemData, String str) {
        b.InterfaceC0687b interfaceC0687b = this.f27174a;
        if (interfaceC0687b != null) {
            interfaceC0687b.a(adItemData, str);
        }
    }

    public void b(AdItemData adItemData, String str) {
        b.InterfaceC0687b interfaceC0687b = this.f27174a;
        if (interfaceC0687b != null) {
            interfaceC0687b.b(adItemData, str);
        }
    }

    public void c(AdItemData adItemData, String str) {
        b.InterfaceC0687b interfaceC0687b = this.f27174a;
        if (interfaceC0687b != null) {
            interfaceC0687b.c(adItemData, str);
        }
    }

    public void e() {
    }

    public void f() {
    }
}
