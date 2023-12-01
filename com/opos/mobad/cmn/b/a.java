package com.opos.mobad.cmn.b;

import android.os.Parcel;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/b/a.class */
public class a implements b, com.opos.mobad.service.event.c {

    /* renamed from: a  reason: collision with root package name */
    private EventDescription f12216a;
    private b b;

    /* renamed from: com.opos.mobad.cmn.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/b/a$a.class */
    public static class C0514a extends com.opos.mobad.service.event.a implements b {
        public C0514a(EventDescription eventDescription) {
            super(eventDescription);
        }

        public static EventDescription a(EventDescription eventDescription) {
            if (eventDescription == null) {
                return null;
            }
            return new EventDescription(eventDescription.a() + "-finisher");
        }

        @Override // com.opos.mobad.cmn.b.b
        public void b() {
            b(1, null);
        }

        @Override // com.opos.mobad.service.event.a
        public void b(int i, Parcel parcel) {
            if (this.b != null) {
                com.opos.mobad.service.event.c a2 = com.opos.mobad.service.event.b.a().a(this.b);
                if (a2 != null) {
                    a2.a(i, parcel);
                } else {
                    super.b(i, parcel);
                }
            }
        }
    }

    public a(EventDescription eventDescription, b bVar) {
        this.f12216a = eventDescription;
        this.b = bVar;
    }

    public static com.opos.mobad.service.event.c a(EventDescription eventDescription, b bVar) {
        if (eventDescription == null || bVar == null) {
            return null;
        }
        a aVar = new a(eventDescription, bVar);
        com.opos.mobad.service.event.b.a().a(aVar);
        return aVar;
    }

    @Override // com.opos.mobad.service.event.c
    public EventDescription a() {
        return this.f12216a;
    }

    @Override // com.opos.mobad.service.event.c
    public void a(int i, Parcel parcel) {
        b bVar = this.b;
        if (bVar == null) {
            com.opos.cmn.an.f.a.b("VideoEventHandler", "null listener");
        } else if (i != 1) {
        } else {
            bVar.b();
        }
    }

    @Override // com.opos.mobad.cmn.b.b
    public void b() {
        b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.b();
    }
}
