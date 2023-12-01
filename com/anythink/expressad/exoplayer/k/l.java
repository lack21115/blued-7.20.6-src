package com.anythink.expressad.exoplayer.k;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/l.class */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private String[] f4817a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4818c;

    private l(String... strArr) {
        this.f4817a = strArr;
    }

    private void a(String... strArr) {
        a.b(!this.b, "Cannot set libraries after loading");
        this.f4817a = strArr;
    }

    private boolean a() {
        if (this.b) {
            return this.f4818c;
        }
        this.b = true;
        try {
            String[] strArr = this.f4817a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                System.loadLibrary(strArr[i2]);
                i = i2 + 1;
            }
            this.f4818c = true;
        } catch (UnsatisfiedLinkError e) {
        }
        return this.f4818c;
    }
}
