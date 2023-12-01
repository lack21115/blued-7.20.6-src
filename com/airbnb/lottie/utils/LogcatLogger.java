package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/utils/LogcatLogger.class */
public class LogcatLogger implements LottieLogger {
    private static final Set<String> a = new HashSet();

    @Override // com.airbnb.lottie.LottieLogger
    public void a(String str) {
        b(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void a(String str, Throwable th) {
        if (a.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        a.add(str);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void b(String str) {
        a(str, null);
    }

    public void b(String str, Throwable th) {
        if (L.a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
