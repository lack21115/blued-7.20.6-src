package com.amap.api.col.p0003sl;

import com.android.internal.telephony.PhoneConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.mu  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mu.class */
public final class mu {

    /* renamed from: a  reason: collision with root package name */
    public String f5391a;
    public byte[] d;
    public Map<String, String> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    boolean f5392c = true;
    public int e = 10000;

    public static String a() {
        return "lc_" + ((int) mr.a());
    }

    public static String b() {
        return mr.c() + PhoneConstants.APN_TYPE_ALL + mr.f();
    }
}
