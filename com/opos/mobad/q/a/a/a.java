package com.opos.mobad.q.a.a;

import android.os.Parcel;
import com.opos.mobad.service.event.EventDescription;
import com.opos.mobad.service.event.b;
import com.opos.mobad.service.event.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/a/a.class */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private EventDescription f27147a;
    private com.opos.mobad.q.a.e.a b;

    /* renamed from: com.opos.mobad.q.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/a/a$a.class */
    public static class C0725a extends com.opos.mobad.q.a.e.a {
        public C0725a(EventDescription eventDescription) {
            super(eventDescription);
        }

        @Override // com.opos.mobad.service.event.a, com.opos.mobad.service.event.c
        public void a(int i, Parcel parcel) {
            c a2;
            if (this.b == null || (a2 = b.a().a(this.b)) == null) {
                super.a(i, parcel);
            } else {
                a2.a(i, parcel);
            }
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i, String str) {
            Parcel obtain = Parcel.obtain();
            obtain.writeInt(i);
            obtain.writeString(str);
            a(6, obtain);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j) {
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j);
            a(4, obtain);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            Parcel obtain = Parcel.obtain();
            obtain.writeString(str);
            a(3, obtain);
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            a(1, (Parcel) null);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
            a(7, (Parcel) null);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j) {
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j);
            a(10, obtain);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
            Parcel obtain = Parcel.obtain();
            obtain.writeString(str);
            a(9, obtain);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
            a(8, (Parcel) null);
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            a(5, (Parcel) null);
        }

        @Override // com.opos.mobad.q.a.e.a
        public void f() {
            a(11, (Parcel) null);
        }

        public void g() {
            a(12, (Parcel) null);
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0724a
        public void j_() {
            a(2, (Parcel) null);
        }
    }

    public a(EventDescription eventDescription, com.opos.mobad.q.a.e.a aVar) {
        this.f27147a = eventDescription;
        this.b = aVar;
    }

    public static a a(EventDescription eventDescription, com.opos.mobad.q.a.e.a aVar) {
        if (eventDescription == null || aVar == null) {
            return null;
        }
        a aVar2 = new a(eventDescription, aVar);
        b.a().a(aVar2);
        return aVar2;
    }

    @Override // com.opos.mobad.service.event.c
    public EventDescription a() {
        return this.f27147a;
    }

    @Override // com.opos.mobad.service.event.c
    public void a(int i, Parcel parcel) {
        String str;
        if (this.b == null) {
            com.opos.cmn.an.f.a.b("VideoEventHandler", "null listener");
            return;
        }
        if (parcel != null) {
            parcel.setDataPosition(0);
        }
        str = "";
        long j = 0;
        switch (i) {
            case 1:
                this.b.a((Object[]) null);
                return;
            case 2:
                this.b.j_();
                return;
            case 3:
                this.b.a(parcel != null ? parcel.readString() : "");
                return;
            case 4:
                if (parcel != null) {
                    j = parcel.readLong();
                }
                this.b.a(j);
                return;
            case 5:
                this.b.d();
                return;
            case 6:
                int i2 = 0;
                if (parcel != null) {
                    i2 = parcel.readInt();
                    str = parcel.readString();
                }
                this.b.a(i2, str);
                return;
            case 7:
                this.b.b();
                return;
            case 8:
                this.b.c();
                return;
            case 9:
                this.b.b(parcel != null ? parcel.readString() : "");
                return;
            case 10:
                if (parcel != null) {
                    j = parcel.readLong();
                }
                this.b.b(j);
                return;
            case 11:
                this.b.f();
                return;
            case 12:
                this.b.e();
                return;
            default:
                return;
        }
    }
}
