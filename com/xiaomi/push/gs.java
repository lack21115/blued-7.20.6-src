package com.xiaomi.push;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gs.class */
public class gs {

    /* renamed from: a  reason: collision with root package name */
    private static gs f27764a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Object> f481a = new ConcurrentHashMap();
    private Map<String, Object> b = new ConcurrentHashMap();

    private gs() {
        m8777a();
    }

    public static gs a() {
        gs gsVar;
        synchronized (gs.class) {
            try {
                if (f27764a == null) {
                    f27764a = new gs();
                }
                gsVar = f27764a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gsVar;
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    private ClassLoader[] m8775a() {
        ClassLoader classLoader = gs.class.getClassLoader();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader2 = new ClassLoader[]{classLoader, contextClassLoader}[i];
            if (classLoader2 != null) {
                arrayList.add(classLoader2);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m8776a(String str, String str2) {
        return this.f481a.get(a(str, str2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void m8777a() {
        /*
            Method dump skipped, instructions count: 718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.gs.m8777a():void");
    }

    public void a(String str, String str2, Object obj) {
        if (!(obj instanceof gr) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f481a.put(a(str, str2), obj);
    }
}
