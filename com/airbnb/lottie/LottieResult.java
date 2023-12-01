package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/LottieResult.class */
public final class LottieResult<V> {
    private final V a;
    private final Throwable b;

    public LottieResult(V v) {
        this.a = v;
        this.b = null;
    }

    public LottieResult(Throwable th) {
        this.b = th;
        this.a = null;
    }

    public V a() {
        return this.a;
    }

    public Throwable b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LottieResult) {
            LottieResult lottieResult = (LottieResult) obj;
            if (a() == null || !a().equals(lottieResult.a())) {
                if (b() == null || lottieResult.b() == null) {
                    return false;
                }
                return b().toString().equals(b().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{a(), b()});
    }
}
