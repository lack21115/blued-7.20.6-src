package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/internal/PlatformImplementations.class */
public class PlatformImplementations {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/internal/PlatformImplementations$ReflectThrowable.class */
    static final class ReflectThrowable {

        /* renamed from: a  reason: collision with root package name */
        public static final ReflectThrowable f42476a = new ReflectThrowable();
        public static final Method b;

        /* renamed from: c  reason: collision with root package name */
        public static final Method f42477c;

        /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[LOOP:0: B:3:0x0020->B:14:0x0067, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0071 A[EDGE_INSN: B:25:0x0071->B:16:0x0071 ?: BREAK  , SYNTHETIC] */
        static {
            /*
                kotlin.internal.PlatformImplementations$ReflectThrowable r0 = new kotlin.internal.PlatformImplementations$ReflectThrowable
                r1 = r0
                r1.<init>()
                kotlin.internal.PlatformImplementations.ReflectThrowable.f42476a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r0 = r0.getMethods()
                r9 = r0
                r0 = r9
                java.lang.String r1 = "throwableMethods"
                kotlin.jvm.internal.Intrinsics.c(r0, r1)
                r0 = r9
                int r0 = r0.length
                r6 = r0
                r0 = 0
                r5 = r0
                r0 = 0
                r3 = r0
            L20:
                r0 = 0
                r8 = r0
                r0 = r3
                r1 = r6
                if (r0 >= r1) goto L6e
                r0 = r9
                r1 = r3
                r0 = r0[r1]
                r7 = r0
                r0 = r7
                java.lang.String r0 = r0.getName()
                java.lang.String r1 = "addSuppressed"
                boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r1)
                if (r0 == 0) goto L5e
                r0 = r7
                java.lang.Class[] r0 = r0.getParameterTypes()
                r10 = r0
                r0 = r10
                java.lang.String r1 = "it.parameterTypes"
                kotlin.jvm.internal.Intrinsics.c(r0, r1)
                r0 = r10
                java.lang.Object[] r0 = (java.lang.Object[]) r0
                java.lang.Object r0 = kotlin.collections.ArraysKt.b(r0)
                java.lang.Class<java.lang.Throwable> r1 = java.lang.Throwable.class
                boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r1)
                if (r0 == 0) goto L5e
                r0 = 1
                r4 = r0
                goto L60
            L5e:
                r0 = 0
                r4 = r0
            L60:
                r0 = r4
                if (r0 == 0) goto L67
                goto L71
            L67:
                r0 = r3
                r1 = 1
                int r0 = r0 + r1
                r3 = r0
                goto L20
            L6e:
                r0 = 0
                r7 = r0
            L71:
                r0 = r7
                kotlin.internal.PlatformImplementations.ReflectThrowable.b = r0
                r0 = r9
                int r0 = r0.length
                r4 = r0
                r0 = r5
                r3 = r0
            L7c:
                r0 = r8
                r7 = r0
                r0 = r3
                r1 = r4
                if (r0 >= r1) goto La2
                r0 = r9
                r1 = r3
                r0 = r0[r1]
                r7 = r0
                r0 = r7
                java.lang.String r0 = r0.getName()
                java.lang.String r1 = "getSuppressed"
                boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r1)
                if (r0 == 0) goto L9b
                goto La2
            L9b:
                r0 = r3
                r1 = 1
                int r0 = r0 + r1
                r3 = r0
                goto L7c
            La2:
                r0 = r7
                kotlin.internal.PlatformImplementations.ReflectThrowable.f42477c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementations.ReflectThrowable.m12916clinit():void");
        }

        private ReflectThrowable() {
        }
    }

    public Random a() {
        return new FallbackThreadLocalRandom();
    }

    public void a(Throwable cause, Throwable exception) {
        Intrinsics.e(cause, "cause");
        Intrinsics.e(exception, "exception");
        Method method = ReflectThrowable.b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }
}
