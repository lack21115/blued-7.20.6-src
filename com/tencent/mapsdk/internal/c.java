package com.tencent.mapsdk.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, HashMap<String, byte[]>> f23643a = new HashMap<>();
    public HashMap<String, Object> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, Object> f23644c = new HashMap<>();
    public String d = "GBK";
    public m e = new m();

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            }
            if (Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                a(arrayList, Array.get(obj, 0));
                return;
            }
            arrayList.add("Array");
            arrayList.add("?");
        } else if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        } else {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a(arrayList, list.get(0));
                } else {
                    arrayList.add("?");
                }
            } else if (!(obj instanceof Map)) {
                arrayList.add(a((c) obj));
            } else {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() <= 0) {
                    arrayList.add("?");
                    arrayList.add("?");
                    return;
                }
                Object obj2 = map.get(map.keySet().iterator().next());
                arrayList.add(a((c) obj));
                a(arrayList, obj2);
            }
        }
    }

    private Object b(String str, boolean z, ClassLoader classLoader) {
        String a2 = o.a(str);
        String str2 = str;
        if (a2 != null) {
            str2 = str;
            if (!"".equals(a2)) {
                str2 = a2;
            }
        }
        if (this.b.containsKey(str2)) {
            return this.b.get(str2);
        }
        Object b = a.b(str2, z, classLoader);
        this.b.put(str2, b);
        return b;
    }

    private void b(String str, Object obj) {
        this.f23644c.put(str, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(String str, Object obj, boolean z, ClassLoader classLoader) {
        String str2;
        byte[] bArr;
        if (this.f23643a.containsKey(str)) {
            if (this.f23644c.containsKey(str)) {
                return (T) this.f23644c.get(str);
            }
            Iterator<Map.Entry<String, byte[]>> it = this.f23643a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                str2 = next.getKey();
                bArr = next.getValue();
            } else {
                str2 = "";
                bArr = new byte[0];
            }
            try {
                Object b = b(str2, z, classLoader);
                this.e.b(bArr);
                this.e.a(this.d);
                T t = (T) this.e.a((m) b, 0, true);
                b(str, t);
                return t;
            } catch (Exception e) {
                e.printStackTrace();
                b(str, obj);
                return obj;
            }
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(String str, boolean z, ClassLoader classLoader) throws b {
        String str2 = null;
        if (this.f23643a.containsKey(str)) {
            if (this.f23644c.containsKey(str)) {
                return (T) this.f23644c.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.f23643a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                str2 = next.getKey();
                bArr = next.getValue();
            }
            try {
                Object b = b(str2, z, classLoader);
                this.e.b(bArr);
                this.e.a(this.d);
                T t = (T) this.e.a((m) b, 0, true);
                b(str, t);
                return t;
            } catch (Exception e) {
                e.printStackTrace();
                throw new b(e);
            }
        }
        return null;
    }

    public <T> String a(T t) {
        String className = t instanceof p ? ((p) t).className() : "";
        String str = className;
        if ("".equals(className)) {
            str = t.getClass().getName();
        }
        return str;
    }

    public void a() {
        this.f23644c.clear();
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
        n nVar = new n();
        nVar.a(this.d);
        nVar.a(t, 0);
        byte[] b = q.b(nVar.a());
        HashMap<String, byte[]> hashMap = new HashMap<>(1);
        ArrayList<String> arrayList = new ArrayList<>(1);
        a(arrayList, t);
        hashMap.put(a.a(arrayList), b);
        this.f23644c.remove(str);
        this.f23643a.put(str, hashMap);
    }

    public void a(byte[] bArr) {
        this.e.b(bArr);
        this.e.a(this.d);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f23643a = this.e.a((Map) hashMap, 0, false);
    }

    public boolean a(String str) {
        return this.f23643a.containsKey(str);
    }

    public void b(String str) {
        this.d = str;
    }

    public byte[] b() {
        n nVar = new n(0);
        nVar.a(this.d);
        nVar.a((Map) this.f23643a, 0);
        return q.b(nVar.a());
    }

    public <T> T c(String str, boolean z, ClassLoader classLoader) throws b {
        String str2 = null;
        if (this.f23643a.containsKey(str)) {
            if (this.f23644c.containsKey(str)) {
                return (T) this.f23644c.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.f23643a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                str2 = next.getKey();
                bArr = next.getValue();
            }
            try {
                Object b = b(str2, z, classLoader);
                this.e.b(bArr);
                this.e.a(this.d);
                T t = (T) this.e.a((p) b, 0, true);
                b(str, t);
                return t;
            } catch (Exception e) {
                e.printStackTrace();
                throw new b(e);
            }
        }
        return null;
    }

    public String c() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T d(String str, boolean z, ClassLoader classLoader) throws b {
        String str2;
        byte[] bArr;
        if (this.f23643a.containsKey(str)) {
            Iterator<Map.Entry<String, byte[]>> it = this.f23643a.remove(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                str2 = next.getKey();
                bArr = next.getValue();
            } else {
                str2 = "";
                bArr = new byte[0];
            }
            try {
                Object b = a.b(str2, z, classLoader);
                this.e.b(bArr);
                this.e.a(this.d);
                return (T) this.e.a((m) b, 0, true);
            } catch (Exception e) {
                e.printStackTrace();
                throw new b(e);
            }
        }
        return null;
    }

    public Set<String> d() {
        return Collections.unmodifiableSet(this.f23643a.keySet());
    }

    public boolean e() {
        return this.f23643a.isEmpty();
    }

    public int f() {
        return this.f23643a.size();
    }
}
