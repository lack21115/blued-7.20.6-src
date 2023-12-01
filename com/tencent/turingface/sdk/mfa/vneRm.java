package com.tencent.turingface.sdk.mfa;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/vneRm.class */
public final class vneRm {

    /* renamed from: a  reason: collision with root package name */
    public final String f26311a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final int f26312c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public int h;
    public int i;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/vneRm$spXPg.class */
    public static final class spXPg {

        /* renamed from: a  reason: collision with root package name */
        public String f26313a;
        public long b;

        /* renamed from: c  reason: collision with root package name */
        public String f26314c;
        public String d;
        public String e;
        public String f;

        public static /* synthetic */ int c(spXPg spxpg) {
            spxpg.getClass();
            return 0;
        }
    }

    public vneRm(int i, int i2, int i3) {
        this.f26311a = "";
        this.b = 0L;
        this.f26312c = i;
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = i2;
        this.i = i3;
    }

    public vneRm(spXPg spxpg) {
        this.h = 0;
        this.i = 0;
        this.f26311a = spxpg.f26313a;
        this.b = spxpg.b;
        spXPg.c(spxpg);
        this.f26312c = 0;
        this.d = spxpg.f26314c;
        this.e = spxpg.d;
        this.f = spxpg.e;
        this.g = spxpg.f;
    }

    public static vneRm a(int i) {
        return new vneRm(i, 0, 0);
    }
}
