package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/KeyframeParser.class */
class KeyframeParser {
    private static final Interpolator a = new LinearInterpolator();
    private static SparseArrayCompat<WeakReference<Interpolator>> b;

    KeyframeParser() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> a() {
        if (b == null) {
            b = new SparseArrayCompat<>();
        }
        return b;
    }

    private static <T> Keyframe<T> a(JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.b(jsonReader, f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Keyframe<T> a(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z) throws IOException {
        return z ? a(lottieComposition, jsonReader, f, valueParser) : a(jsonReader, f, valueParser);
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0226, code lost:
        if (r10 == null) goto L100;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> com.airbnb.lottie.value.Keyframe<T> a(com.airbnb.lottie.LottieComposition r9, android.util.JsonReader r10, float r11, com.airbnb.lottie.parser.ValueParser<T> r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.KeyframeParser.a(com.airbnb.lottie.LottieComposition, android.util.JsonReader, float, com.airbnb.lottie.parser.ValueParser):com.airbnb.lottie.value.Keyframe");
    }

    private static WeakReference<Interpolator> a(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser.class) {
            try {
                weakReference = (WeakReference) a().get(i);
            } catch (Throwable th) {
                throw th;
            }
        }
        return weakReference;
    }

    private static void a(int i, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            try {
                b.put(i, weakReference);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
