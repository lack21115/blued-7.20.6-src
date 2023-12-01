package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DebugKt.class */
public final class DebugKt {
    private static final boolean a = CoroutineId.class.desiredAssertionStatus();
    private static final boolean b;
    private static final boolean c;
    private static final AtomicLong d;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r0.equals("auto") != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r0.equals("on") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r0.equals("") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0066, code lost:
        r6 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    static {
        /*
            java.lang.Class<kotlinx.coroutines.CoroutineId> r0 = kotlinx.coroutines.CoroutineId.class
            boolean r0 = r0.desiredAssertionStatus()
            kotlinx.coroutines.DebugKt.a = r0
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.a(r0)
            r9 = r0
            r0 = 0
            r8 = r0
            r0 = r9
            if (r0 == 0) goto L9f
            r0 = r9
            int r0 = r0.hashCode()
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L5c
            r0 = r5
            r1 = 3551(0xddf, float:4.976E-42)
            if (r0 == r1) goto L4f
            r0 = r5
            r1 = 109935(0x1ad6f, float:1.54052E-40)
            if (r0 == r1) goto L40
            r0 = r5
            r1 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r0 != r1) goto L6b
            r0 = r9
            java.lang.String r1 = "auto"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            goto L9f
        L40:
            r0 = r9
            java.lang.String r1 = "off"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            r0 = 0
            r6 = r0
            goto La3
        L4f:
            r0 = r9
            java.lang.String r1 = "on"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            goto L66
        L5c:
            r0 = r9
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
        L66:
            r0 = 1
            r6 = r0
            goto La3
        L6b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            java.lang.String r1 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = r9
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            r1 = 39
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            r2 = r10
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L9f:
            boolean r0 = a()
            r6 = r0
        La3:
            r0 = r6
            kotlinx.coroutines.DebugKt.b = r0
            r0 = r8
            r7 = r0
            r0 = r6
            if (r0 == 0) goto Lba
            r0 = r8
            r7 = r0
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            r1 = 1
            boolean r0 = kotlinx.coroutines.internal.SystemPropsKt.a(r0, r1)
            if (r0 == 0) goto Lba
            r0 = 1
            r7 = r0
        Lba:
            r0 = r7
            kotlinx.coroutines.DebugKt.c = r0
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = r0
            r2 = 0
            r1.<init>(r2)
            kotlinx.coroutines.DebugKt.d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DebugKt.m11939clinit():void");
    }

    public static final boolean a() {
        return a;
    }

    public static final boolean b() {
        return b;
    }

    public static final boolean c() {
        return c;
    }

    public static final AtomicLong d() {
        return d;
    }
}
