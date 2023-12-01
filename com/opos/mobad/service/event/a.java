package com.opos.mobad.service.event;

import android.os.Parcel;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/event/a.class */
public class a implements c {
    protected final EventDescription b;

    public a(EventDescription eventDescription) {
        this.b = eventDescription;
    }

    @Override // com.opos.mobad.service.event.c
    public EventDescription a() {
        return this.b;
    }

    @Override // com.opos.mobad.service.event.c
    public void a(int i, Parcel parcel) {
        b.a().a(this.b.a(), i, parcel);
    }

    public void b(int i, Parcel parcel) {
        b.a().a(this.b.a(), i, parcel, true);
    }
}
