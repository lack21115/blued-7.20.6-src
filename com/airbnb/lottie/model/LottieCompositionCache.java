package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/LottieCompositionCache.class */
public class LottieCompositionCache {
    private static final LottieCompositionCache a = new LottieCompositionCache();
    private final LruCache<String, LottieComposition> b = new LruCache<>(20);

    LottieCompositionCache() {
    }

    public static LottieCompositionCache a() {
        return a;
    }

    public LottieComposition a(String str) {
        if (str == null) {
            return null;
        }
        return (LottieComposition) this.b.get(str);
    }

    public void a(String str, LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.b.put(str, lottieComposition);
    }
}
