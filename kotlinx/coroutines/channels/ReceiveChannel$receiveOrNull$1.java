package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Channel.kt", c = {349}, d = "receiveOrNull", e = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ReceiveChannel$receiveOrNull$1.class */
public final class ReceiveChannel$receiveOrNull$1<E> extends ContinuationImpl {
    /* synthetic */ Object a;
    int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReceiveChannel$receiveOrNull$1(Continuation<? super ReceiveChannel$receiveOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.a = obj;
        this.b |= Integer.MIN_VALUE;
        return ReceiveChannel.DefaultImpls.a(null, this);
    }
}
