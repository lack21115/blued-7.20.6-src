package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.m9;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/o9.class */
public final class o9 {

    /* renamed from: a  reason: collision with root package name */
    private cb f23985a = new cb();
    private ConcurrentHashMap<String, Map<String, m9>> b = new ConcurrentHashMap<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/o9$a.class */
    public static class a<D extends n9> extends va<String, D> {
        private m9.b<D> i;

        public a(int i, m9.b<D> bVar) {
            super(i);
            this.i = bVar;
        }

        public int a(String str, D d) {
            if (d != null) {
                return d.a();
            }
            return 0;
        }

        @Override // com.tencent.mapsdk.internal.va
        public void a(boolean z, String str, D d, D d2) {
            m9.b<D> bVar;
            if (!z || (bVar = this.i) == null) {
                return;
            }
            bVar.a(d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mapsdk.internal.va
        public /* synthetic */ int c(String str, Object obj) {
            return a(str, (String) ((n9) obj));
        }
    }

    public <D extends n9, C extends m9<D>> C a(Class<D> cls, m9.a aVar, Class<C> cls2) {
        C c2;
        Constructor<?> constructor;
        Map<String, m9> map = this.b.get(cls2.getName());
        String a2 = q9.a(cls.getName() + aVar.toString());
        String name = cls2.getName();
        Constructor<?> constructor2 = null;
        if (map != null) {
            C c3 = (C) map.get(a2);
            c2 = c3;
            if (c3 != null) {
                return c3;
            }
        } else {
            c2 = null;
        }
        Constructor<?>[] declaredConstructors = cls2.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            constructor = constructor2;
            if (i2 >= length) {
                break;
            }
            Constructor<?> constructor3 = declaredConstructors[i2];
            Class<?>[] parameterTypes = constructor3.getParameterTypes();
            constructor2 = constructor;
            if (parameterTypes.length == 1) {
                constructor2 = constructor;
                if (parameterTypes[0] == aVar.getClass()) {
                    constructor2 = constructor3;
                }
            }
            i = i2 + 1;
        }
        C c4 = c2;
        if (constructor != null) {
            try {
                c4 = (m9) constructor.newInstance(aVar);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                c4 = c2;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                c4 = c2;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                c4 = c2;
            }
        }
        if (c4 != null) {
            HashMap hashMap = map;
            if (map == null) {
                hashMap = new HashMap();
            }
            hashMap.put(a2, c4);
            this.b.put(name, hashMap);
        }
        return c4;
    }

    public String a(String str) {
        return this.f23985a.a(str);
    }
}
