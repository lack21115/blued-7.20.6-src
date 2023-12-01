package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/jvm/internal/DebugProbesKt.class */
public final class DebugProbesKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> a(Continuation<? super T> completion) {
        Intrinsics.e(completion, "completion");
        return completion;
    }

    public static final void b(Continuation<?> frame) {
        Intrinsics.e(frame, "frame");
    }

    public static final void c(Continuation<?> frame) {
        Intrinsics.e(frame, "frame");
    }
}
