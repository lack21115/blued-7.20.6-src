package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {137, 140}, d = "singleOrNull", e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$singleOrNull$1.class */
public final class ChannelsKt__DeprecatedKt$singleOrNull$1<E> extends ContinuationImpl {
    Object a;
    Object b;
    /* synthetic */ Object c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$singleOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$singleOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f;
        this.c = obj;
        this.d |= Integer.MIN_VALUE;
        f = ChannelsKt__DeprecatedKt.f(null, this);
        return f;
    }
}
