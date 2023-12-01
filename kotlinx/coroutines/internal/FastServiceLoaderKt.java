package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/FastServiceLoaderKt.class */
public final class FastServiceLoaderKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f43535a;

    static {
        Object f;
        try {
            Result.Companion companion = Result.f42293a;
            f = Result.f(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f42293a;
            f = Result.f(ResultKt.a(th));
        }
        f43535a = Result.a(f);
    }

    public static final boolean a() {
        return f43535a;
    }
}
