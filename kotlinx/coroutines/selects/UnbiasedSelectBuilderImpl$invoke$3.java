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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SelectClause2<P, Q> f43606a;
    final /* synthetic */ UnbiasedSelectBuilderImpl<R> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ P f43607c;
    final /* synthetic */ Function2<Q, Continuation<? super R>, Object> d;

    public final void a() {
        this.f43606a.a(this.b.a(), this.f43607c, this.d);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* synthetic */ Unit invoke() {
        a();
        return Unit.f42314a;
    }
}
