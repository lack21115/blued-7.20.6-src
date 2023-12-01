package com.opos.mobad.activity.webview.b;

import android.os.Parcel;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/b/e.class */
public class e implements com.opos.mobad.service.event.c {

    /* renamed from: a  reason: collision with root package name */
    private EventDescription f11955a;
    private d b;

    /* renamed from: c  reason: collision with root package name */
    private c f11956c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/webview/b/e$a.class */
    public static final class a extends com.opos.mobad.service.event.a implements c {
        public a(EventDescription eventDescription) {
            super(eventDescription);
        }

        @Override // com.opos.mobad.service.event.a, com.opos.mobad.service.event.c
        public void a(int i, Parcel parcel) {
            com.opos.mobad.service.event.c a2;
            if (this.b == null || (a2 = com.opos.mobad.service.event.b.a().a(this.b)) == null) {
                super.a(i, parcel);
            } else {
                a2.a(i, parcel);
            }
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a(int i, String str) {
            Parcel obtain = Parcel.obtain();
            obtain.writeInt(i);
            obtain.writeString(str);
            a(8, obtain);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a(long j) {
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j);
            a(5, obtain);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b() {
            a(4, (Parcel) null);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b(long j) {
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j);
            a(6, obtain);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void c() {
            a(7, (Parcel) null);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void c(long j) {
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j);
            a(9, obtain);
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
            a(1, (Parcel) null);
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            a(2, (Parcel) null);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void f_() {
            a(3, (Parcel) null);
        }
    }

    e(EventDescription eventDescription, d dVar) {
        this.f11955a = eventDescription;
        this.b = dVar;
        if (dVar instanceof c) {
            this.f11956c = (c) dVar;
        }
    }

    public static e a(EventDescription eventDescription, d dVar) {
        if (eventDescription == null || dVar == null) {
            return null;
        }
        e eVar = new e(eventDescription, dVar);
        com.opos.mobad.service.event.b.a().a(eVar);
        return eVar;
    }

    @Override // com.opos.mobad.service.event.c
    public EventDescription a() {
        return this.f11955a;
    }

    @Override // com.opos.mobad.service.event.c
    public void a(int i, Parcel parcel) {
        String str;
        int i2;
        if (this.b == null) {
            com.opos.cmn.an.f.a.b("WebActionEventHandler", "null listener");
            return;
        }
        if (parcel != null) {
            parcel.setDataPosition(0);
        }
        long j = 0;
        switch (i) {
            case 1:
                this.b.d();
                return;
            case 2:
                this.b.e();
                return;
            case 3:
                c cVar = this.f11956c;
                if (cVar != null) {
                    cVar.f_();
                    return;
                }
                return;
            case 4:
                c cVar2 = this.f11956c;
                if (cVar2 != null) {
                    cVar2.b();
                    return;
                }
                return;
            case 5:
                if (this.f11956c != null) {
                    if (parcel != null) {
                        j = parcel.readLong();
                    }
                    this.f11956c.a(j);
                    return;
                }
                return;
            case 6:
                if (this.f11956c != null) {
                    if (parcel != null) {
                        j = parcel.readLong();
                    }
                    this.f11956c.b(j);
                    return;
                }
                return;
            case 7:
                c cVar3 = this.f11956c;
                if (cVar3 != null) {
                    cVar3.c();
                    return;
                }
                return;
            case 8:
                if (this.f11956c != null) {
                    if (parcel != null) {
                        i2 = parcel.readInt();
                        str = parcel.readString();
                    } else {
                        str = "";
                        i2 = 0;
                    }
                    this.f11956c.a(i2, str);
                    return;
                }
                return;
            case 9:
                if (this.f11956c != null) {
                    if (parcel != null) {
                        j = parcel.readLong();
                    }
                    this.f11956c.c(j);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
