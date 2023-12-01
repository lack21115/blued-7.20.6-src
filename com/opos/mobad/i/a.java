package com.opos.mobad.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final com.opos.cmn.func.b.b.d f12519a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12520c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;

    /* renamed from: com.opos.mobad.i.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a$a.class */
    public static class C0529a {

        /* renamed from: a  reason: collision with root package name */
        private com.opos.cmn.func.b.b.d f12521a;
        private String b;
        private String d;
        private String f;
        private String g;

        /* renamed from: c  reason: collision with root package name */
        private int f12522c = -1;
        private int e = 0;

        private boolean b(int i) {
            boolean z = true;
            if (i != 0) {
                z = true;
                if (1 != i) {
                    if (2 == i) {
                        return true;
                    }
                    z = false;
                }
            }
            return z;
        }

        public C0529a a(int i) {
            this.f12522c = i;
            return this;
        }

        public C0529a a(com.opos.cmn.func.b.b.d dVar) {
            this.f12521a = dVar;
            return this;
        }

        public C0529a a(String str) {
            this.b = str;
            return this;
        }

        public a a() throws Exception {
            if (this.f12521a != null) {
                if (b(this.f12522c)) {
                    if (this.f12522c == 0 && com.opos.cmn.an.c.a.a(this.d)) {
                        throw new NullPointerException("when saveType is SAVE_TYPE_OF_SDCARD.savePath can't be null.");
                    }
                    int i = this.f12522c;
                    if ((1 == i || 2 == i) && com.opos.cmn.an.c.a.a(this.g)) {
                        throw new NullPointerException("when saveType is SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE.fileName can't be null.");
                    }
                    return new a(this);
                }
                throw new Exception("saveType not support!saveType must be SAVE_TYPE_OF_SDCARD or SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE");
            }
            throw new NullPointerException("netRequest is null.");
        }

        public C0529a b(String str) {
            this.d = str;
            return this;
        }
    }

    public a(C0529a c0529a) {
        this.f12519a = c0529a.f12521a;
        this.b = c0529a.b;
        this.f12520c = c0529a.f12522c;
        this.d = c0529a.d;
        this.e = c0529a.e;
        this.f = c0529a.f;
        this.g = c0529a.g;
    }

    public String toString() {
        return "DownloadRequest{netRequest=" + this.f12519a + ", md5='" + this.b + "', saveType=" + this.f12520c + ", savePath='" + this.d + "', mode=" + this.e + ", dir='" + this.f + "', fileName='" + this.g + "'}";
    }
}
