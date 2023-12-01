package com.opos.mobad.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final com.opos.cmn.func.b.b.d f26207a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final int f26208c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;

    /* renamed from: com.opos.mobad.i.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/i/a$a.class */
    public static class C0699a {

        /* renamed from: a  reason: collision with root package name */
        private com.opos.cmn.func.b.b.d f26209a;
        private String b;
        private String d;
        private String f;
        private String g;

        /* renamed from: c  reason: collision with root package name */
        private int f26210c = -1;
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

        public C0699a a(int i) {
            this.f26210c = i;
            return this;
        }

        public C0699a a(com.opos.cmn.func.b.b.d dVar) {
            this.f26209a = dVar;
            return this;
        }

        public C0699a a(String str) {
            this.b = str;
            return this;
        }

        public a a() throws Exception {
            if (this.f26209a != null) {
                if (b(this.f26210c)) {
                    if (this.f26210c == 0 && com.opos.cmn.an.c.a.a(this.d)) {
                        throw new NullPointerException("when saveType is SAVE_TYPE_OF_SDCARD.savePath can't be null.");
                    }
                    int i = this.f26210c;
                    if ((1 == i || 2 == i) && com.opos.cmn.an.c.a.a(this.g)) {
                        throw new NullPointerException("when saveType is SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE.fileName can't be null.");
                    }
                    return new a(this);
                }
                throw new Exception("saveType not support!saveType must be SAVE_TYPE_OF_SDCARD or SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE");
            }
            throw new NullPointerException("netRequest is null.");
        }

        public C0699a b(String str) {
            this.d = str;
            return this;
        }
    }

    public a(C0699a c0699a) {
        this.f26207a = c0699a.f26209a;
        this.b = c0699a.b;
        this.f26208c = c0699a.f26210c;
        this.d = c0699a.d;
        this.e = c0699a.e;
        this.f = c0699a.f;
        this.g = c0699a.g;
    }

    public String toString() {
        return "DownloadRequest{netRequest=" + this.f26207a + ", md5='" + this.b + "', saveType=" + this.f26208c + ", savePath='" + this.d + "', mode=" + this.e + ", dir='" + this.f + "', fileName='" + this.g + "'}";
    }
}
