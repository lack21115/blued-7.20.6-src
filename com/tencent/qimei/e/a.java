package com.tencent.qimei.e;

import com.tencent.qimei.beaconid.U;
import com.tencent.qimei.j.b;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/e/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24633a;

    static {
        String p;
        if (U.f24624a) {
            try {
                p = U.p();
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            f24633a = p;
        }
        p = "";
        f24633a = p;
    }

    public static String a() {
        return b.f24650a ? "https://test.snowflake.qq.com/ola" : "https://snowflake.qq.com/ola";
    }

    public static String b() {
        return f24633a;
    }
}
