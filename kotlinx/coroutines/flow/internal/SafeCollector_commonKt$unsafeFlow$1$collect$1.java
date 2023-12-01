package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1.class */
public final class SafeCollector_commonKt$unsafeFlow$1$collect$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ Object f43507a;
    final /* synthetic */ SafeCollector_commonKt$unsafeFlow$1 b;

    /* renamed from: c  reason: collision with root package name */
    int f43508c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f43507a = obj;
        this.f43508c |= Integer.MIN_VALUE;
        return this.b.a(null, this);
    }
}
