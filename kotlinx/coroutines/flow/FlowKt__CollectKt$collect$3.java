package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3.class */
public final class FlowKt__CollectKt$collect$3<T> implements FlowCollector<T> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> f43097a;

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        Object invoke = this.f43097a.invoke(t, continuation);
        return invoke == IntrinsicsKt.a() ? invoke : Unit.f42314a;
    }
}
