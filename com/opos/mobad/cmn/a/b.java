package com.opos.mobad.cmn.a;

import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final EventDescription f12144a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final long f12145c;
    public final String d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b$a.class */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public String f12147c;
        private EventDescription d = null;

        /* renamed from: a  reason: collision with root package name */
        public boolean f12146a = false;
        public long b = 0;

        public a a(long j) {
            this.b = j;
            return this;
        }

        public a a(EventDescription eventDescription) {
            this.d = eventDescription;
            return this;
        }

        public a a(String str) {
            this.f12147c = str;
            return this;
        }

        public a a(boolean z) {
            this.f12146a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f12144a = aVar.d;
        this.b = aVar.f12146a;
        this.f12145c = aVar.b;
        this.d = aVar.f12147c;
    }
}
