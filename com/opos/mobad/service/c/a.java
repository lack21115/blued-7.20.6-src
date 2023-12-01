package com.opos.mobad.service.c;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, String> f27312a = new ConcurrentHashMap();

    private boolean b(Map<Integer, String> map) {
        return map != null && map.size() > 0;
    }

    public void a(Map<Integer, String> map) {
        if (map == null || map.size() <= 0) {
            com.opos.cmn.an.f.a.a("Dynamic-Config", "refreshStrategy dynamic but null map");
            return;
        }
        this.f27312a = new ConcurrentHashMap(map);
        com.opos.cmn.an.f.a.b("Dynamic-Config", "refreshStrategy map = " + this.f27312a);
    }

    public boolean a() {
        Map<Integer, String> map = this.f27312a;
        com.opos.cmn.an.f.a.b("Dynamic-Config", "checkConfigEnable ", map);
        return b(map);
    }

    public boolean a(int i) {
        Map<Integer, String> map = this.f27312a;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public String b(int i) {
        Map<Integer, String> map = this.f27312a;
        return (!a(i) || map == null) ? "" : map.get(Integer.valueOf(i));
    }

    public String[] b() {
        Map<Integer, String> map = this.f27312a;
        if (b(map)) {
            String[] strArr = new String[map.size()];
            map.values().toArray(strArr);
            return strArr;
        }
        return null;
    }
}
