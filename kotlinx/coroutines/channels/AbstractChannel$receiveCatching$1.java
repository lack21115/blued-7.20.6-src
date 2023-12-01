package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "AbstractChannel.kt", c = {632}, d = "receiveCatching-JP2dKIU", e = "kotlinx.coroutines.channels.AbstractChannel")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel$receiveCatching$1.class */
public final class AbstractChannel$receiveCatching$1 extends ContinuationImpl {
    /* synthetic */ Object a;
    final /* synthetic */ AbstractChannel<E> b;
    int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractChannel$receiveCatching$1(AbstractChannel<E> abstractChannel, Continuation<? super AbstractChannel$receiveCatching$1> continuation) {
        super(continuation);
        this.b = abstractChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.c |= Integer.MIN_VALUE;
        Object a = this.b.a(this);
        return a == IntrinsicsKt.a() ? a : ChannelResult.h(a);
    }
}
