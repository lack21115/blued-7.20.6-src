package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/selects/UnbiasedSelectBuilderImpl$invoke$3.class */
final class UnbiasedSelectBuilderImpl$invoke$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelectClause2<P, Q> a;
    final /* synthetic */ UnbiasedSelectBuilderImpl<R> b;
    final /* synthetic */ P c;
    final /* synthetic */ Function2<Q, Continuation<? super R>, Object> d;

    public final void a() {
        this.a.a(this.b.a(), this.c, this.d);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* synthetic */ Unit invoke() {
        a();
        return Unit.a;
    }
}
