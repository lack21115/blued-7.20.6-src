package com.tencent.turingface.sdk.mfa;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/vqARY.class */
public final class vqARY {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, spXPg> f26315a;
    public static OTVRM b;

    /* renamed from: c  reason: collision with root package name */
    public static String f26316c;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/vqARY$spXPg.class */
    public static final class spXPg {

        /* renamed from: a  reason: collision with root package name */
        public Xjpd8 f26317a;
        public int b = 0;

        public spXPg(Xjpd8 xjpd8) {
            this.f26317a = xjpd8;
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.concurrent.ConcurrentHashMap, java.util.Map<java.lang.String, com.tencent.turingface.sdk.mfa.vqARY$spXPg>] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.concurrent.ConcurrentHashMap, java.util.Map<java.lang.String, com.tencent.turingface.sdk.mfa.vqARY$spXPg>] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.concurrent.ConcurrentHashMap, java.util.Map<java.lang.String, com.tencent.turingface.sdk.mfa.vqARY$spXPg>] */
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f26315a = concurrentHashMap;
        concurrentHashMap.put("C892BA2", new spXPg(new cPR64()));
        f26315a.put("43780D5", new spXPg(new cPR64()));
        f26315a.put("7CD3AF2", new spXPg(new cPR64()));
        f26315a.put("22792AF", new spXPg(new usfPi()));
        f26316c = "";
        try {
            f26316c = EQsUZ.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
        } catch (Throwable th) {
        }
    }
}
