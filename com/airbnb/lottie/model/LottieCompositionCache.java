package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/LottieCompositionCache.class */
public class LottieCompositionCache {

    /* renamed from: a  reason: collision with root package name */
    private static final LottieCompositionCache f4324a = new LottieCompositionCache();
    private final LruCache<String, LottieComposition> b = new LruCache<>(20);

    LottieCompositionCache() {
    }

    public static LottieCompositionCache a() {
        return f4324a;
    }

    public LottieComposition a(String str) {
        if (str == null) {
            return null;
        }
        return this.b.get(str);
    }

    public void a(String str, LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.b.put(str, lottieComposition);
    }
}
