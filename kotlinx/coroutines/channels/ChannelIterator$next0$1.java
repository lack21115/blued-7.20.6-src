package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Channel.kt", c = {579}, d = "next", e = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelIterator$next0$1.class */
public final class ChannelIterator$next0$1<E> extends ContinuationImpl {
    Object a;
    /* synthetic */ Object b;
    int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelIterator$next0$1(Continuation<? super ChannelIterator$next0$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.c |= Integer.MIN_VALUE;
        return ChannelIterator.DefaultImpls.a(null, this);
    }
}
