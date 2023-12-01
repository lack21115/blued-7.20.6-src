package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Channels.kt", c = {51, 62}, d = "emitAllImpl$FlowKt__ChannelsKt", e = "kotlinx.coroutines.flow.FlowKt__ChannelsKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/FlowKt__ChannelsKt$emitAllImpl$1.class */
public final class FlowKt__ChannelsKt$emitAllImpl$1<T> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f43095a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    boolean f43096c;
    /* synthetic */ Object d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ChannelsKt$emitAllImpl$1(Continuation<? super FlowKt__ChannelsKt$emitAllImpl$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b;
        this.d = obj;
        this.e |= Integer.MIN_VALUE;
        b = FlowKt__ChannelsKt.b(null, null, false, this);
        return b;
    }
}
