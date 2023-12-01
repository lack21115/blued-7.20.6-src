package com.airbnb.lottie;

import android.graphics.Bitmap;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieImageAsset.class */
public class LottieImageAsset {
    private final int a;
    private final int b;
    private final String c;
    private final String d;
    private final String e;
    private Bitmap f;

    public LottieImageAsset(int i, int i2, String str, String str2, String str3) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public String a() {
        return this.c;
    }

    public void a(Bitmap bitmap) {
        this.f = bitmap;
    }

    public String b() {
        return this.d;
    }

    public Bitmap c() {
        return this.f;
    }
}
