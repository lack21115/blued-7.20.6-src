package com.opos.mobad.q.a.e;

import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.q.a.m;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/e/a.class */
public abstract class a extends com.opos.mobad.service.event.a implements b.InterfaceC0517b, m.a {

    /* renamed from: a  reason: collision with root package name */
    private b.InterfaceC0517b f13486a;

    public a() {
        this(null);
    }

    public a(EventDescription eventDescription) {
        super(eventDescription);
    }

    public void a(b.InterfaceC0517b interfaceC0517b) {
        this.f13486a = interfaceC0517b;
    }

    public void a(AdItemData adItemData, String str) {
        b.InterfaceC0517b interfaceC0517b = this.f13486a;
        if (interfaceC0517b != null) {
            interfaceC0517b.a(adItemData, str);
        }
    }

    public void b(AdItemData adItemData, String str) {
        b.InterfaceC0517b interfaceC0517b = this.f13486a;
        if (interfaceC0517b != null) {
            interfaceC0517b.b(adItemData, str);
        }
    }

    public void c(AdItemData adItemData, String str) {
        b.InterfaceC0517b interfaceC0517b = this.f13486a;
        if (interfaceC0517b != null) {
            interfaceC0517b.c(adItemData, str);
        }
    }

    public void e() {
    }

    public void f() {
    }
}
