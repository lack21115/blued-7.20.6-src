package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/FastServiceLoaderKt.class */
public final class FastServiceLoaderKt {
    private static final boolean a;

    static {
        Object f;
        try {
            Result.Companion companion = Result.a;
            f = Result.f(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.a;
            f = Result.f(ResultKt.a(th));
        }
        a = Result.a(f);
    }

    public static final boolean a() {
        return a;
    }
}
