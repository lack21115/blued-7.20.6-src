package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Emitters.kt", c = {216}, d = "invokeSafely$FlowKt__EmittersKt", e = "kotlinx.coroutines.flow.FlowKt__EmittersKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__EmittersKt$invokeSafely$1.class */
public final class FlowKt__EmittersKt$invokeSafely$1<T> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43162a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    int f43163c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__EmittersKt$invokeSafely$1(Continuation<? super FlowKt__EmittersKt$invokeSafely$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b;
        this.b = obj;
        this.f43163c |= Integer.MIN_VALUE;
        b = FlowKt__EmittersKt.b(null, null, null, this);
        return b;
    }
}
