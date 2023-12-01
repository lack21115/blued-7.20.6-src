package kotlinx.coroutines.channels;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {356, 358}, d = "maxWith", e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$maxWith$1.class */
public final class ChannelsKt__DeprecatedKt$maxWith$1<E> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f42962a;
    Object b;

    /* renamed from: c  reason: collision with root package name */
    Object f42963c;
    Object d;
    /* synthetic */ Object e;
    int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$maxWith$1(Continuation<? super ChannelsKt__DeprecatedKt$maxWith$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        this.e = obj;
        this.f |= Integer.MIN_VALUE;
        a2 = ChannelsKt__DeprecatedKt.a((ReceiveChannel) null, (Comparator) null, (Continuation) this);
        return a2;
    }
}
