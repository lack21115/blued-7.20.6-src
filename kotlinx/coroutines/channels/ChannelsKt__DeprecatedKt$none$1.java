package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {381}, d = "none", e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$none$1.class */
public final class ChannelsKt__DeprecatedKt$none$1<E> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f42966a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    int f42967c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$none$1(Continuation<? super ChannelsKt__DeprecatedKt$none$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object i;
        this.b = obj;
        this.f42967c |= Integer.MIN_VALUE;
        i = ChannelsKt__DeprecatedKt.i(null, this);
        return i;
    }
}
