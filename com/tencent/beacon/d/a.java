package com.tencent.beacon.d;

import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Long> f35003a = new HashMap();

    public static void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        f35003a.put(str, Long.valueOf(currentTimeMillis));
        com.tencent.beacon.base.util.c.a("[page] onPageIn cost time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, Long> map = f35003a;
        if (map == null) {
            com.tencent.beacon.base.util.c.e("[page] please call 'onPageIn' first!", new Object[0]);
            return;
        }
        Long l = map.get(str);
        if (l == null) {
            com.tencent.beacon.base.util.c.e("[page] please call 'onPageIn' first!", new Object[0]);
            return;
        }
        ((StatModule) com.tencent.beacon.a.c.c.d().a(ModuleName.STAT)).a(str, currentTimeMillis - l.longValue(), currentTimeMillis);
        f35003a.remove(str);
        com.tencent.beacon.base.util.c.a("[page] onPageOut cost time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
