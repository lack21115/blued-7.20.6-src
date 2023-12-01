package com.amap.api.col.p0003sl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: com.amap.api.col.3sl.ei  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ei.class */
public final class ei {
    private boolean b = false;
    ArrayList<a> a = new ArrayList<>();

    /* renamed from: com.amap.api.col.3sl.ei$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ei$a.class */
    public static final class a {
        private String a;
        private Object b;
        private Class<?>[] c;
        private Object[] d;

        public a(Object obj, String str, Object... objArr) {
            this.b = obj;
            this.a = str;
            if (objArr == null || objArr.length <= 0) {
                return;
            }
            this.c = new Class[objArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= objArr.length) {
                    break;
                }
                this.c[i2] = objArr[i2].getClass();
                i = i2 + 1;
            }
            this.d = new Object[objArr.length];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= objArr.length) {
                    return;
                }
                this.d[i4] = objArr[i4];
                i3 = i4 + 1;
            }
        }
    }

    public final void a() {
        Class<?> cls;
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.a.size()) {
                    this.a.clear();
                    return;
                }
                a aVar = this.a.get(i2);
                try {
                    try {
                        try {
                            if (aVar.b != null && (cls = aVar.b.getClass()) != null) {
                                Method method = null;
                                try {
                                    method = cls.getDeclaredMethod(aVar.a, aVar.c);
                                } catch (NoSuchMethodException e) {
                                    if (aVar.c.length > 0) {
                                        Class<?>[] clsArr = new Class[aVar.c.length];
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= aVar.c.length) {
                                                break;
                                            }
                                            if (aVar.c[i4].getInterfaces().length > 0) {
                                                clsArr[i4] = aVar.c[i4].getInterfaces()[0];
                                            }
                                            i3 = i4 + 1;
                                        }
                                        method = cls.getDeclaredMethod(aVar.a, clsArr);
                                    }
                                }
                                if (method != null) {
                                    method.setAccessible(true);
                                    method.invoke(aVar.b, aVar.d);
                                }
                            }
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        } catch (IllegalArgumentException e3) {
                            e3.printStackTrace();
                        }
                    } catch (SecurityException e4) {
                        e4.printStackTrace();
                    } catch (InvocationTargetException e5) {
                        e5.printStackTrace();
                    }
                } catch (NoSuchMethodException e6) {
                    e6.printStackTrace();
                }
                i = i2 + 1;
            }
        }
    }

    public final void a(Object obj, Object... objArr) {
        synchronized (this) {
            try {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.a.add(new a(obj, stackTrace[3].getMethodName(), objArr));
                }
            } catch (Throwable th) {
            }
            this.b = false;
        }
    }
}
