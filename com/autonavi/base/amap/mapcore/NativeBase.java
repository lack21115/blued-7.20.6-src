package com.autonavi.base.amap.mapcore;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/NativeBase.class */
public abstract class NativeBase {
    private static final String CREATE_OVERLAY = "createOverlay";
    private static final int STACK_NUMBER = 3;
    private static final String UPDATE_OPTIONS = "updateOptions";
    private boolean mCalledFuntion = false;
    protected boolean useRunnable = true;
    protected volatile boolean destroy = false;
    ArrayList<Method> methodMap = new ArrayList<>();
    ArrayList<Runnable> runnableArrayList = new ArrayList<>();

    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/NativeBase$Method.class */
    public static class Method {
        private boolean baseClass;
        private Class<?>[] clazz;
        private String methodName;
        private Object object;
        private Object[] param;

        /* JADX WARN: Removed duplicated region for block: B:27:0x00a8 A[Catch: all -> 0x00be, TRY_LEAVE, TryCatch #0 {all -> 0x00be, blocks: (B:4:0x0018, B:6:0x001e, B:9:0x0033, B:12:0x003d, B:17:0x004b, B:18:0x0060, B:23:0x0092, B:25:0x00a0, B:27:0x00a8, B:19:0x0072, B:21:0x007a), top: B:38:0x0018 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00bd A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Method(java.lang.Object r6, java.lang.String r7, boolean r8, java.lang.Object... r9) {
            /*
                Method dump skipped, instructions count: 222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.NativeBase.Method.<init>(java.lang.Object, java.lang.String, boolean, java.lang.Object[]):void");
        }
    }

    public void callAllFunction() {
        Class<?> cls;
        java.lang.reflect.Method declaredMethod;
        synchronized (this) {
            if (isReady() && !this.destroy) {
                if (this.mCalledFuntion) {
                    return;
                }
                try {
                    this.mCalledFuntion = true;
                    if (this.useRunnable) {
                        while (this.runnableArrayList.size() > 0 && !this.destroy) {
                            Runnable runnable = this.runnableArrayList.get(0);
                            if (runnable != null) {
                                runnable.run();
                            }
                            this.runnableArrayList.remove(0);
                        }
                        return;
                    }
                    Iterator<Method> it = this.methodMap.iterator();
                    while (it.hasNext()) {
                        Method next = it.next();
                        if (this.destroy) {
                            break;
                        } else if (next.object != null && (cls = next.object.getClass()) != null && (declaredMethod = cls.getDeclaredMethod(next.methodName, next.clazz)) != null) {
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(next.object, next.param);
                        }
                    }
                    this.methodMap.clear();
                } catch (Throwable th) {
                }
            }
        }
    }

    protected abstract void createNative();

    public void destroy() {
        this.destroy = true;
        synchronized (this) {
            this.runnableArrayList.clear();
            this.methodMap.clear();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            finalizeNative();
        } catch (Throwable th) {
            getClass().getSimpleName();
            th.toString();
        }
    }

    protected abstract void finalizeNative();

    protected abstract long getNative();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isReady() {
        return getNative() != 0;
    }

    public void storeUncallFunction(Object obj, Object obj2, Object... objArr) {
        synchronized (this) {
            try {
                if (!this.useRunnable || obj2 == null) {
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    if (stackTrace != null && stackTrace.length >= 3) {
                        this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                    }
                } else {
                    synchronized (this.runnableArrayList) {
                        this.runnableArrayList.add((Runnable) obj2);
                    }
                }
                this.mCalledFuntion = false;
            } catch (Throwable th) {
            }
        }
    }

    public void storeUncallFunctionArray(Object obj, Object obj2, Object[] objArr) {
        synchronized (this) {
            try {
                if (!this.useRunnable || obj2 == null) {
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    if (stackTrace != null && stackTrace.length >= 3) {
                        this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                    }
                } else {
                    synchronized (this.runnableArrayList) {
                        this.runnableArrayList.add((Runnable) obj2);
                    }
                }
                this.mCalledFuntion = false;
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0097, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void validate() {
        /*
            r4 = this;
            r0 = r4
            java.lang.Class r0 = r0.getClass()
            java.lang.reflect.Method[] r0 = r0.getMethods()
            r10 = r0
            r0 = r10
            if (r0 != 0) goto Lf
            return
        Lf:
            r0 = r10
            int r0 = r0.length
            r7 = r0
            r0 = 0
            r5 = r0
        L15:
            r0 = r5
            r1 = r7
            if (r0 >= r1) goto L9e
            r0 = r10
            r1 = r5
            r0 = r0[r1]
            r9 = r0
            r0 = r9
            java.lang.Class<com.autonavi.base.amap.mapcore.annotations.ParameterIsClass> r1 = com.autonavi.base.amap.mapcore.annotations.ParameterIsClass.class
            boolean r0 = r0.isAnnotationPresent(r1)
            if (r0 == 0) goto L97
            r0 = r9
            java.lang.Class<com.autonavi.base.amap.mapcore.annotations.ParameterIsClass> r1 = com.autonavi.base.amap.mapcore.annotations.ParameterIsClass.class
            java.lang.annotation.Annotation r0 = r0.getAnnotation(r1)
            com.autonavi.base.amap.mapcore.annotations.ParameterIsClass r0 = (com.autonavi.base.amap.mapcore.annotations.ParameterIsClass) r0
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L97
            r0 = r11
            boolean r0 = r0.required()
            if (r0 == 0) goto L97
            r0 = r9
            java.lang.Class[] r0 = r0.getParameterTypes()
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L97
            r0 = r11
            int r0 = r0.length
            r8 = r0
            r0 = 0
            r6 = r0
        L58:
            r0 = r6
            r1 = r8
            if (r0 >= r1) goto L97
            r0 = r11
            r1 = r6
            r0 = r0[r1]
            boolean r0 = r0 instanceof java.lang.Object
            if (r0 == 0) goto L6f
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L58
        L6f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "函数："
            r1.<init>(r2)
            r10 = r0
            r0 = r10
            r1 = r9
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = " 参数不是对象类型"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            r2 = r10
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L97:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L15
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.NativeBase.validate():void");
    }
}
