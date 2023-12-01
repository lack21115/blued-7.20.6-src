package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/utils/Logger.class */
public class Logger {
    private static LottieLogger a = new LogcatLogger();

    public static void a(String str) {
        a.a(str);
    }

    public static void a(String str, Throwable th) {
        a.a(str, th);
    }

    public static void b(String str) {
        a.b(str);
    }
}
