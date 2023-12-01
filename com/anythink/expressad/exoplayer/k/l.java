package com.anythink.expressad.exoplayer.k;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/l.class */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private String[] f7656a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7657c;

    private l(String... strArr) {
        this.f7656a = strArr;
    }

    private void a(String... strArr) {
        a.b(!this.b, "Cannot set libraries after loading");
        this.f7656a = strArr;
    }

    private boolean a() {
        if (this.b) {
            return this.f7657c;
        }
        this.b = true;
        try {
            String[] strArr = this.f7656a;
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
            this.f7657c = true;
        } catch (UnsatisfiedLinkError e) {
        }
        return this.f7657c;
    }
}
