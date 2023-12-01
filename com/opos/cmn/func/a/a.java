package com.opos.cmn.func.a;

import com.opos.cmn.an.g.f;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final f f24796a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24797c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;

    /* renamed from: com.opos.cmn.func.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/a/a$a.class */
    public static class C0635a {

        /* renamed from: a  reason: collision with root package name */
        private f f24798a;
        private String b;
        private String d;
        private String f;
        private String g;

        /* renamed from: c  reason: collision with root package name */
        private int f24799c = -1;
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

        public C0635a a(int i) {
            this.f24799c = i;
            return this;
        }

        public C0635a a(f fVar) {
            this.f24798a = fVar;
            return this;
        }

        public C0635a a(String str) {
            this.b = str;
            return this;
        }

        public a a() {
            if (this.f24798a != null) {
                if (b(this.f24799c)) {
                    if (this.f24799c == 0 && com.opos.cmn.an.c.a.a(this.d)) {
                        throw new NullPointerException("when saveType is SAVE_TYPE_OF_SDCARD.savePath can't be null.");
                    }
                    int i = this.f24799c;
                    if ((1 == i || 2 == i) && com.opos.cmn.an.c.a.a(this.g)) {
                        throw new NullPointerException("when saveType is SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE.fileName can't be null.");
                    }
                    return new a(this);
                }
                throw new Exception("saveType not support!saveType must be SAVE_TYPE_OF_SDCARD or SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE");
            }
            throw new NullPointerException("netRequest is null.");
        }

        public C0635a b(String str) {
            this.d = str;
            return this;
        }
    }

    public a(C0635a c0635a) {
        this.f24796a = c0635a.f24798a;
        this.b = c0635a.b;
        this.f24797c = c0635a.f24799c;
        this.d = c0635a.d;
        this.e = c0635a.e;
        this.f = c0635a.f;
        this.g = c0635a.g;
    }

    public String toString() {
        return "DownloadRequest{netRequest=" + this.f24796a + ", md5='" + this.b + "', saveType=" + this.f24797c + ", savePath='" + this.d + "', mode=" + this.e + ", dir='" + this.f + "', fileName='" + this.g + "'}";
    }
}
