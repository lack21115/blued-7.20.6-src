package com.opos.mobad.cmn.a;

import com.opos.mobad.service.event.EventDescription;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final EventDescription f25832a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final long f25833c;
    public final String d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b$a.class */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public String f25835c;
        private EventDescription d = null;

        /* renamed from: a  reason: collision with root package name */
        public boolean f25834a = false;
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
            this.f25835c = str;
            return this;
        }

        public a a(boolean z) {
            this.f25834a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f25832a = aVar.d;
        this.b = aVar.f25834a;
        this.f25833c = aVar.b;
        this.d = aVar.f25835c;
    }
}
