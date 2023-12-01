package com.tencent.turingface.sdk.mfa;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/vqARY.class */
public final class vqARY {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, spXPg> f40006a;
    public static OTVRM b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40007c;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/vqARY$spXPg.class */
    public static final class spXPg {

        /* renamed from: a  reason: collision with root package name */
        public Xjpd8 f40008a;
        public int b = 0;

        public spXPg(Xjpd8 xjpd8) {
            this.f40008a = xjpd8;
        }
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f40006a = concurrentHashMap;
        concurrentHashMap.put("C892BA2", new spXPg(new cPR64()));
        f40006a.put("43780D5", new spXPg(new cPR64()));
        f40006a.put("7CD3AF2", new spXPg(new cPR64()));
        f40006a.put("22792AF", new spXPg(new usfPi()));
        f40007c = "";
        try {
            f40007c = EQsUZ.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
        } catch (Throwable th) {
        }
    }
}
