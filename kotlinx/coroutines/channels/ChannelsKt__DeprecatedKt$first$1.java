package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {60}, d = "first", e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$first$1.class */
public final class ChannelsKt__DeprecatedKt$first$1<E> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f42944a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    /* synthetic */ Object f42945c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$first$1(Continuation<? super ChannelsKt__DeprecatedKt$first$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        this.f42945c = obj;
        this.d |= Integer.MIN_VALUE;
        a2 = ChannelsKt__DeprecatedKt.a(null, this);
        return a2;
    }
}
