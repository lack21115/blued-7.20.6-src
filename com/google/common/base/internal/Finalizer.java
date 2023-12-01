package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/internal/Finalizer.class */
public class Finalizer implements Runnable {
    private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
    @NullableDecl
    private static final Constructor<Thread> bigThreadConstructor;
    @NullableDecl
    private static final Field inheritableThreadLocals;
    private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;

    static {
        Constructor<Thread> bigThreadConstructor2 = getBigThreadConstructor();
        bigThreadConstructor = bigThreadConstructor2;
        inheritableThreadLocals = bigThreadConstructor2 == null ? getInheritableThreadLocalsField() : null;
    }

    private Finalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.queue = referenceQueue;
        this.finalizableReferenceClassReference = new WeakReference<>(cls);
        this.frqReference = phantomReference;
    }

    private boolean cleanUp(Reference<?> reference) {
        Reference<? extends Object> poll;
        Method finalizeReferentMethod = getFinalizeReferentMethod();
        if (finalizeReferentMethod == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.frqReference) {
                return false;
            }
            try {
                finalizeReferentMethod.invoke(reference, new Object[0]);
            } catch (Throwable th) {
                logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            poll = this.queue.poll();
            reference = poll;
        } while (poll != null);
        return true;
    }

    @NullableDecl
    private static Constructor<Thread> getBigThreadConstructor() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable th) {
            return null;
        }
    }

    @NullableDecl
    private Method getFinalizeReferentMethod() {
        Class<?> cls = this.finalizableReferenceClassReference.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    @NullableDecl
    private static Field getInheritableThreadLocalsField() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:3|(10:20|21|6|(1:8)|9|10|11|(1:13)|15|16)|5|6|(0)|9|10|11|(0)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008a, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008b, code lost:
        com.google.common.base.internal.Finalizer.logger.log(java.util.logging.Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f A[Catch: all -> 0x008a, TRY_LEAVE, TryCatch #1 {all -> 0x008a, blocks: (B:14:0x0079, B:16:0x007f), top: B:25:0x0079 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void startFinalizer(java.lang.Class<?> r7, java.lang.ref.ReferenceQueue<java.lang.Object> r8, java.lang.ref.PhantomReference<java.lang.Object> r9) {
        /*
            r0 = r7
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "com.google.common.base.FinalizableReference"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L9c
            com.google.common.base.internal.Finalizer r0 = new com.google.common.base.internal.Finalizer
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r9
            r1.<init>(r2, r3, r4)
            r9 = r0
            java.lang.Class<com.google.common.base.internal.Finalizer> r0 = com.google.common.base.internal.Finalizer.class
            java.lang.String r0 = r0.getName()
            r10 = r0
            java.lang.reflect.Constructor<java.lang.Thread> r0 = com.google.common.base.internal.Finalizer.bigThreadConstructor
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L5e
            r0 = r7
            r1 = 5
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L51
            r2 = r1
            r3 = 0
            r4 = 0
            java.lang.ThreadGroup r4 = (java.lang.ThreadGroup) r4     // Catch: java.lang.Throwable -> L51
            r2[r3] = r4     // Catch: java.lang.Throwable -> L51
            r2 = r1
            r3 = 1
            r4 = r9
            r2[r3] = r4     // Catch: java.lang.Throwable -> L51
            r2 = r1
            r3 = 2
            r4 = r10
            r2[r3] = r4     // Catch: java.lang.Throwable -> L51
            r2 = r1
            r3 = 3
            r4 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L51
            r2[r3] = r4     // Catch: java.lang.Throwable -> L51
            r2 = r1
            r3 = 4
            r4 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L51
            r2[r3] = r4     // Catch: java.lang.Throwable -> L51
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.Throwable -> L51
            java.lang.Thread r0 = (java.lang.Thread) r0     // Catch: java.lang.Throwable -> L51
            r7 = r0
            goto L60
        L51:
            r7 = move-exception
            java.util.logging.Logger r0 = com.google.common.base.internal.Finalizer.logger
            java.util.logging.Level r1 = java.util.logging.Level.INFO
            java.lang.String r2 = "Failed to create a thread without inherited thread-local values"
            r3 = r7
            r0.log(r1, r2, r3)
        L5e:
            r0 = 0
            r7 = r0
        L60:
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L74
            java.lang.Thread r0 = new java.lang.Thread
            r1 = r0
            r2 = 0
            java.lang.ThreadGroup r2 = (java.lang.ThreadGroup) r2
            r3 = r9
            r4 = r10
            r1.<init>(r2, r3, r4)
            r8 = r0
        L74:
            r0 = r8
            r1 = 1
            r0.setDaemon(r1)
            java.lang.reflect.Field r0 = com.google.common.base.internal.Finalizer.inheritableThreadLocals     // Catch: java.lang.Throwable -> L8a
            if (r0 == 0) goto L97
            java.lang.reflect.Field r0 = com.google.common.base.internal.Finalizer.inheritableThreadLocals     // Catch: java.lang.Throwable -> L8a
            r1 = r8
            r2 = 0
            r0.set(r1, r2)     // Catch: java.lang.Throwable -> L8a
            goto L97
        L8a:
            r7 = move-exception
            java.util.logging.Logger r0 = com.google.common.base.internal.Finalizer.logger
            java.util.logging.Level r1 = java.util.logging.Level.INFO
            java.lang.String r2 = "Failed to clear thread local values inherited by reference finalizer thread."
            r3 = r7
            r0.log(r1, r2, r3)
        L97:
            r0 = r8
            r0.start()
            return
        L9c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "Expected com.google.common.base.FinalizableReference."
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.internal.Finalizer.startFinalizer(java.lang.Class, java.lang.ref.ReferenceQueue, java.lang.ref.PhantomReference):void");
    }

    @Override // java.lang.Runnable
    public void run() {
        while (cleanUp(this.queue.remove())) {
        }
    }
}
