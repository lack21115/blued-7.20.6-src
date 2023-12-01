package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/UnbiasedSelectBuilderImpl$invoke$1.class */
final class UnbiasedSelectBuilderImpl$invoke$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelectClause0 a;
    final /* synthetic */ UnbiasedSelectBuilderImpl<R> b;
    final /* synthetic */ Function1<Continuation<? super R>, Object> c;

    public final void a() {
        this.a.a(this.b.a(), this.c);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* synthetic */ Unit invoke() {
        a();
        return Unit.a;
    }
}
