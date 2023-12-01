package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/core/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class<?>, Service> f8743a = new HashMap();
    private static Map<Class<?>, Object> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<Class<?>, Service> f8744c = new HashMap();
    private Map<Class<?>, Object> d = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List<Service> list, Context context) {
        a(list, context);
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service) {
        StringBuilder sb;
        String localizedMessage;
        if (service.getInstance() != null) {
            return service.getInstance();
        }
        Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor a2 = a(type, Context.class, AGConnectInstance.class);
            if (a2 != null) {
                return a2.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            Constructor a3 = a(type, Context.class);
            return a3 != null ? a3.newInstance(aGConnectInstance.getContext()) : type.newInstance();
        } catch (IllegalAccessException e) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            localizedMessage = e.getLocalizedMessage();
            sb.append(localizedMessage);
            Log.e("ServiceRepository", sb.toString());
            return null;
        } catch (InstantiationException e2) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            localizedMessage = e2.getLocalizedMessage();
            sb.append(localizedMessage);
            Log.e("ServiceRepository", sb.toString());
            return null;
        } catch (InvocationTargetException e3) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            localizedMessage = e3.getLocalizedMessage();
            sb.append(localizedMessage);
            Log.e("ServiceRepository", sb.toString());
            return null;
        }
    }

    private static Constructor a(Class cls, Class... clsArr) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i = 0;
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (i >= length) {
                return null;
            }
            Constructor<?> constructor = declaredConstructors[i];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            boolean z3 = z2;
            if (parameterTypes.length == clsArr.length) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= clsArr.length) {
                        break;
                    }
                    z2 = parameterTypes[i3] == clsArr[i3];
                    i2 = i3 + 1;
                }
                z3 = z2;
                if (z2) {
                    return constructor;
                }
            }
            i++;
            z = z3;
        }
    }

    private void a(String str, Exception exc) {
        Log.e("ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        StringBuilder sb = new StringBuilder();
        sb.append("cause message:");
        sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        Log.e("ServiceRepository", sb.toString());
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t;
        Service service = this.f8744c.get(cls);
        Service service2 = service;
        if (service == null) {
            Service service3 = f8743a.get(cls);
            service2 = service3;
            if (service3 != null) {
                return (T) b.get(cls);
            }
        }
        if (service2 == null) {
            return null;
        }
        if (!service2.isSingleton() || (t = (T) this.d.get(cls)) == null) {
            T t2 = (T) a(aGConnectInstance, service2);
            if (t2 != null && service2.isSingleton()) {
                this.d.put(cls, t2);
            }
            return t2;
        }
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[Catch: InvocationTargetException -> 0x00ab, InstantiationException -> 0x00b2, IllegalAccessException -> 0x00b9, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IllegalAccessException -> 0x00b9, InstantiationException -> 0x00b2, InvocationTargetException -> 0x00ab, blocks: (B:21:0x006d, B:23:0x0082, B:25:0x009a, B:25:0x009a, B:26:0x009d, B:24:0x0092), top: B:35:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092 A[Catch: InvocationTargetException -> 0x00ab, InstantiationException -> 0x00b2, IllegalAccessException -> 0x00b9, TRY_ENTER, TryCatch #2 {IllegalAccessException -> 0x00b9, InstantiationException -> 0x00b2, InvocationTargetException -> 0x00ab, blocks: (B:21:0x006d, B:23:0x0082, B:25:0x009a, B:25:0x009a, B:26:0x009d, B:24:0x0092), top: B:35:0x006d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<com.huawei.agconnect.core.Service> r7, android.content.Context r8) {
        /*
            r6 = this;
            r0 = r7
            if (r0 != 0) goto L5
            return
        L5:
            r0 = r7
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
        Ld:
            r0 = r10
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lc6
            r0 = r10
            java.lang.Object r0 = r0.next()
            com.huawei.agconnect.core.Service r0 = (com.huawei.agconnect.core.Service) r0
            r9 = r0
            r0 = r9
            boolean r0 = r0.isSharedInstance()
            if (r0 == 0) goto L3f
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r0 = com.huawei.agconnect.core.a.d.f8743a
            r1 = r9
            java.lang.Class r1 = r1.getInterface()
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L50
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r0 = com.huawei.agconnect.core.a.d.f8743a
            r7 = r0
            goto L44
        L3f:
            r0 = r6
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r0 = r0.f8744c
            r7 = r0
        L44:
            r0 = r7
            r1 = r9
            java.lang.Class r1 = r1.getInterface()
            r2 = r9
            java.lang.Object r0 = r0.put(r1, r2)
        L50:
            r0 = r9
            boolean r0 = r0.isAutoCreated()
            if (r0 == 0) goto Ld
            r0 = r9
            java.lang.Class r0 = r0.getType()
            if (r0 == 0) goto Ld
            java.util.Map<java.lang.Class<?>, java.lang.Object> r0 = com.huawei.agconnect.core.a.d.b
            r1 = r9
            java.lang.Class r1 = r1.getInterface()
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto Ld
            r0 = r9
            java.lang.Class r0 = r0.getType()     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            r1 = 1
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            r2 = r1
            r3 = 0
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r2[r3] = r4     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            java.lang.reflect.Constructor r0 = a(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L92
            r0 = r7
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            r2 = r1
            r3 = 0
            r4 = r8
            r2[r3] = r4     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            r7 = r0
            goto L9a
        L92:
            r0 = r9
            java.lang.Class r0 = r0.getType()     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            r7 = r0
        L9a:
            java.util.Map<java.lang.Class<?>, java.lang.Object> r0 = com.huawei.agconnect.core.a.d.b     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9 java.lang.IllegalAccessException -> Lb9
            r1 = r9
            java.lang.Class r1 = r1.getInterface()     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            r2 = r7
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.reflect.InvocationTargetException -> Lab java.lang.InstantiationException -> Lb2 java.lang.IllegalAccessException -> Lb9
            goto Ld
        Lab:
            r7 = move-exception
            java.lang.String r0 = "TargetException"
            r9 = r0
            goto Lbd
        Lb2:
            r7 = move-exception
            java.lang.String r0 = "InstantiationException"
            r9 = r0
            goto Lbd
        Lb9:
            r7 = move-exception
            java.lang.String r0 = "AccessException"
            r9 = r0
        Lbd:
            r0 = r6
            r1 = r9
            r2 = r7
            r0.a(r1, r2)
            goto Ld
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.core.a.d.a(java.util.List, android.content.Context):void");
    }
}
