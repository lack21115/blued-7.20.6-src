package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/ResultKt.class */
public final class ResultKt {
    public static final Object a(Throwable exception) {
        Intrinsics.e(exception, "exception");
        return new Result.Failure(exception);
    }

    public static final void a(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).f42294a;
        }
    }
}
