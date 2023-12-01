package com.tencent.bugly.idasc.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/c.class */
class c {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f21626a = new HashMap<>();
    protected HashMap<String, Object> b = new HashMap<>();
    private HashMap<String, Object> e = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    protected String f21627c = "GBK";
    k d = new k();

    private static void a(ArrayList<String> arrayList, Object obj) {
        while (true) {
            if (obj.getClass().isArray()) {
                if (!obj.getClass().getComponentType().toString().equals("byte")) {
                    throw new IllegalArgumentException("only byte[] is supported");
                }
                if (Array.getLength(obj) <= 0) {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                }
                arrayList.add("java.util.List");
                obj = Array.get(obj, 0);
            } else if (obj instanceof Array) {
                throw new IllegalArgumentException("can not support Array, please use List");
            } else {
                if (obj instanceof List) {
                    arrayList.add("java.util.List");
                    List list = (List) obj;
                    if (list.size() <= 0) {
                        arrayList.add("?");
                        return;
                    }
                    obj = list.get(0);
                } else if (!(obj instanceof Map)) {
                    arrayList.add(obj.getClass().getName());
                    return;
                } else {
                    arrayList.add("java.util.Map");
                    Map map = (Map) obj;
                    if (map.size() <= 0) {
                        arrayList.add("?");
                        arrayList.add("?");
                        return;
                    }
                    Object next = map.keySet().iterator().next();
                    obj = map.get(next);
                    arrayList.add(next.getClass().getName());
                }
            }
        }
    }

    public void a(String str) {
        this.f21627c = str;
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        l lVar = new l();
        lVar.a(this.f21627c);
        lVar.a(t, 0);
        byte[] a2 = n.a(lVar.f21634a);
        HashMap<String, byte[]> hashMap = new HashMap<>(1);
        ArrayList arrayList = new ArrayList(1);
        a(arrayList, t);
        hashMap.put(a.a(arrayList), a2);
        this.e.remove(str);
        this.f21626a.put(str, hashMap);
    }

    public void a(byte[] bArr) {
        this.d.a(bArr);
        this.d.a(this.f21627c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f21626a = this.d.a((Map) hashMap, 0, false);
    }

    public byte[] a() {
        l lVar = new l(0);
        lVar.a(this.f21627c);
        lVar.a((Map) this.f21626a, 0);
        return n.a(lVar.f21634a);
    }
}
