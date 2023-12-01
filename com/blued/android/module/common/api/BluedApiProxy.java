package com.blued.android.module.common.api;

import com.blued.android.module.common.api.BluedServiceMethod;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/api/BluedApiProxy.class */
public class BluedApiProxy {
    public static boolean a = false;
    private static volatile BluedApiProxy d;
    private Map<String, String> b = new HashMap();
    private final Map<Method, BluedServiceMethod> c = new HashMap();

    private BluedApiProxy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BluedServiceMethod a(Method method) {
        BluedServiceMethod bluedServiceMethod;
        BluedServiceMethod bluedServiceMethod2 = this.c.get(method);
        if (bluedServiceMethod2 != null) {
            return bluedServiceMethod2;
        }
        synchronized (this.c) {
            BluedServiceMethod bluedServiceMethod3 = this.c.get(method);
            bluedServiceMethod = bluedServiceMethod3;
            if (bluedServiceMethod3 == null) {
                bluedServiceMethod = new BluedServiceMethod.Builder(method).j();
                this.c.put(method, bluedServiceMethod);
            }
        }
        return bluedServiceMethod;
    }

    public static BluedApiProxy b() {
        if (d == null) {
            synchronized (BluedApiProxy.class) {
                try {
                    if (d == null) {
                        d = new BluedApiProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public <T extends BluedApiService> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.blued.android.module.common.api.BluedApiProxy.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                BluedServiceMethod a2 = BluedApiProxy.this.a(method);
                return a2.d() ? a2.a(objArr, (Continuation) objArr[objArr.length - 1]) : a2.call(objArr, (Continuation) objArr[objArr.length - 1]);
            }
        });
    }

    public Map<String, String> a() {
        return this.b;
    }

    public void a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.b = map;
        this.c.clear();
    }
}
