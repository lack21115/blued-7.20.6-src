package com.opos.mobad.d.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f12271a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12272c;
    public final String d;
    public final int e;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f12273a;
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public String f12274c;
        public String d;
        public int e;

        public a a(int i) {
            this.f12273a = i;
            return this;
        }

        public a a(String str) {
            this.f12274c = str;
            return this;
        }

        public a a(boolean z) {
            this.b = z;
            return this;
        }

        public e a() {
            return new e(this);
        }

        public a b(int i) {
            this.e = i;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public String toString() {
            return "Builder{iconId=" + this.f12273a + ", autoCancel=" + this.b + ", notificationChannelId=" + this.f12274c + ", notificationChannelName='" + this.d + "', notificationChannelImportance=" + this.e + '}';
        }
    }

    public e(a aVar) {
        this.f12271a = aVar.f12273a;
        this.b = aVar.b;
        this.f12272c = aVar.f12274c;
        this.d = aVar.d;
        this.e = aVar.e;
    }
}
