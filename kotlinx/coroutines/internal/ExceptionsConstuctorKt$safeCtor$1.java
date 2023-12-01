package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1.class */
public final class ExceptionsConstuctorKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Function1<Throwable, Throwable> a;

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a */
    public final Throwable invoke(Throwable th) {
        Object f;
        Function1<Throwable, Throwable> function1 = this.a;
        try {
            Result.Companion companion = Result.a;
            f = Result.f(function1.invoke(th));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.a;
            f = Result.f(ResultKt.a(th2));
        }
        Object obj = f;
        if (Result.b(f)) {
            obj = null;
        }
        return (Throwable) obj;
    }
}
