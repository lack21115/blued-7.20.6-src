package com.opos.cmn.func.a;

import com.opos.cmn.an.g.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final f f11108a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11109c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;

    /* renamed from: com.opos.cmn.func.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/a$a.class */
    public static class C0465a {

        /* renamed from: a  reason: collision with root package name */
        private f f11110a;
        private String b;
        private String d;
        private String f;
        private String g;

        /* renamed from: c  reason: collision with root package name */
        private int f11111c = -1;
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

        public C0465a a(int i) {
            this.f11111c = i;
            return this;
        }

        public C0465a a(f fVar) {
            this.f11110a = fVar;
            return this;
        }

        public C0465a a(String str) {
            this.b = str;
            return this;
        }

        public a a() {
            if (this.f11110a != null) {
                if (b(this.f11111c)) {
                    if (this.f11111c == 0 && com.opos.cmn.an.c.a.a(this.d)) {
                        throw new NullPointerException("when saveType is SAVE_TYPE_OF_SDCARD.savePath can't be null.");
                    }
                    int i = this.f11111c;
                    if ((1 == i || 2 == i) && com.opos.cmn.an.c.a.a(this.g)) {
                        throw new NullPointerException("when saveType is SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE.fileName can't be null.");
                    }
                    return new a(this);
                }
                throw new Exception("saveType not support!saveType must be SAVE_TYPE_OF_SDCARD or SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE");
            }
            throw new NullPointerException("netRequest is null.");
        }

        public C0465a b(String str) {
            this.d = str;
            return this;
        }
    }

    public a(C0465a c0465a) {
        this.f11108a = c0465a.f11110a;
        this.b = c0465a.b;
        this.f11109c = c0465a.f11111c;
        this.d = c0465a.d;
        this.e = c0465a.e;
        this.f = c0465a.f;
        this.g = c0465a.g;
    }

    public String toString() {
        return "DownloadRequest{netRequest=" + this.f11108a + ", md5='" + this.b + "', saveType=" + this.f11109c + ", savePath='" + this.d + "', mode=" + this.e + ", dir='" + this.f + "', fileName='" + this.g + "'}";
    }
}
