package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/utils/Logger.class */
public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static LottieLogger f4411a = new LogcatLogger();

    public static void a(String str) {
        f4411a.a(str);
    }

    public static void a(String str, Throwable th) {
        f4411a.a(str, th);
    }

    public static void b(String str) {
        f4411a.b(str);
    }
}
