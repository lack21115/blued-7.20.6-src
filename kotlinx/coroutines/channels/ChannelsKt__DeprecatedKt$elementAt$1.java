package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {36}, d = "elementAt", e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$elementAt$1.class */
public final class ChannelsKt__DeprecatedKt$elementAt$1<E> extends ContinuationImpl {
    int a;
    int b;
    Object c;
    Object d;
    /* synthetic */ Object e;
    int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$elementAt$1(Continuation<? super ChannelsKt__DeprecatedKt$elementAt$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a;
        this.e = obj;
        this.f |= Integer.MIN_VALUE;
        a = ChannelsKt__DeprecatedKt.a((ReceiveChannel) null, 0, this);
        return a;
    }
}
