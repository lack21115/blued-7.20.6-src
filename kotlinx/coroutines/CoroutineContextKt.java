package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CoroutineContextKt.class */
public final class CoroutineContextKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f42793a;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
        if (r0.equals("on") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r0.equals("") != false) goto L21;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.a(r0)
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L74
            r0 = r6
            int r0 = r0.hashCode()
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L3a
            r0 = r4
            r1 = 3551(0xddf, float:4.976E-42)
            if (r0 == r1) goto L2e
            r0 = r4
            r1 = 109935(0x1ad6f, float:1.54052E-40)
            if (r0 != r1) goto L46
            r0 = r6
            java.lang.String r1 = "off"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L46
            r0 = 0
            r5 = r0
            goto L76
        L2e:
            r0 = r6
            java.lang.String r1 = "on"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L46
            goto L74
        L3a:
            r0 = r6
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L46
            goto L74
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            java.lang.String r1 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = 39
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            r2 = r7
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L74:
            r0 = 1
            r5 = r0
        L76:
            r0 = r5
            kotlinx.coroutines.CoroutineContextKt.f42793a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineContextKt.m13020clinit():void");
    }

    public static final String a(CoroutineContext coroutineContext) {
        CoroutineId coroutineId;
        String a2;
        if (DebugKt.b() && (coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.f42798a)) != null) {
            CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.f42799a);
            String str = "coroutine";
            if (coroutineName != null && (a2 = coroutineName.a()) != null) {
                str = a2;
            }
            return str + '#' + coroutineId.a();
        }
        return null;
    }

    public static final CoroutineContext a(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext plus = coroutineScope.getCoroutineContext().plus(coroutineContext);
        CoroutineContext plus2 = DebugKt.b() ? plus.plus(new CoroutineId(DebugKt.d().incrementAndGet())) : plus;
        Dispatchers dispatchers = Dispatchers.f42810a;
        CoroutineContext coroutineContext2 = plus2;
        if (plus != Dispatchers.a()) {
            coroutineContext2 = plus2;
            if (plus.get(ContinuationInterceptor.f42453a) == null) {
                Dispatchers dispatchers2 = Dispatchers.f42810a;
                coroutineContext2 = plus2.plus(Dispatchers.a());
            }
        }
        return coroutineContext2;
    }

    public static final CoroutineDispatcher a() {
        return (CoroutineDispatcher) (f42793a ? DefaultScheduler.b : CommonPool.b);
    }

    public static final UndispatchedCoroutine<?> a(Continuation<?> continuation, CoroutineContext coroutineContext, Object obj) {
        if (continuation instanceof CoroutineStackFrame) {
            if (coroutineContext.get(UndispatchedMarker.f42861a) != null) {
                UndispatchedCoroutine<?> a2 = a((CoroutineStackFrame) continuation);
                if (a2 == null) {
                    return a2;
                }
                a2.a(coroutineContext, obj);
                return a2;
            }
            return null;
        }
        return null;
    }

    public static final UndispatchedCoroutine<?> a(CoroutineStackFrame coroutineStackFrame) {
        CoroutineStackFrame callerFrame;
        while (!(coroutineStackFrame instanceof DispatchedCoroutine) && (callerFrame = coroutineStackFrame.getCallerFrame()) != null) {
            coroutineStackFrame = callerFrame;
            if (callerFrame instanceof UndispatchedCoroutine) {
                return (UndispatchedCoroutine) callerFrame;
            }
        }
        return null;
    }
}
