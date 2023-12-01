package com.zx.a.I8b7;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class<? extends b>, b> f42144a = new HashMap();

    public static <T extends c> T a(Class<? extends b> cls, Class<T> cls2) {
        b bVar = (b) ((HashMap) f42144a).get(cls);
        if (bVar == null) {
            StringBuilder a2 = m2.a("db ");
            a2.append(cls.getSimpleName());
            a2.append(" has not been initialized");
            throw new RuntimeException(a2.toString());
        }
        T t = (T) bVar.f42102a.get(cls2);
        if (t != null) {
            return t;
        }
        StringBuilder a3 = m2.a("table ");
        a3.append(cls2.getSimpleName());
        a3.append(" has not been added to db ");
        a3.append(bVar.a());
        throw new RuntimeException(a3.toString());
    }

    public static void a(Context context, Class<? extends b> cls, Class<? extends c>... clsArr) throws IllegalAccessException, InstantiationException {
        Context applicationContext = context.getApplicationContext();
        b bVar = (b) ((HashMap) f42144a).get(cls);
        b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = cls.newInstance();
            ((HashMap) f42144a).put(cls, bVar2);
        }
        int length = clsArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Class<? extends c> cls2 = clsArr[i2];
            c cVar = bVar2.f42102a.get(cls2);
            c cVar2 = cVar;
            if (cVar == null) {
                cVar2 = cls2.newInstance();
                bVar2.f42102a.put(cls2, cVar2);
            }
            cVar2.f42109a = bVar2;
            i = i2 + 1;
        }
        if (bVar2.f42103c.getAndSet(true)) {
            return;
        }
        bVar2.b = new a(bVar2, applicationContext, bVar2.a(), null, bVar2.c());
        for (Class<? extends c> cls3 : bVar2.f42102a.keySet()) {
            bVar2.f42102a.get(cls3).getClass();
        }
    }
}
