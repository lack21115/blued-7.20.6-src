package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/DebugStringsKt.class */
public final class DebugStringsKt {
    public static final String a(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String a(Continuation<?> continuation) {
        String f;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.f42293a;
            f = Result.f(continuation + '@' + a((Object) continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f42293a;
            f = Result.f(ResultKt.a(th));
        }
        if (Result.c(f) != null) {
            f = ((Object) continuation.getClass().getName()) + '@' + a((Object) continuation);
        }
        return (String) f;
    }

    public static final String b(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
