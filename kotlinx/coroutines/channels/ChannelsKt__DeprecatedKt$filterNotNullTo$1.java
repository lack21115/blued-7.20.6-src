package kotlinx.coroutines.channels;

import java.net.HttpURLConnection;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {HttpURLConnection.HTTP_UNSUPPORTED_TYPE}, d = "filterNotNullTo", e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$filterNotNullTo$1.class */
public final class ChannelsKt__DeprecatedKt$filterNotNullTo$1<E, C extends Collection<? super E>> extends ContinuationImpl {
    Object a;
    Object b;
    Object c;
    /* synthetic */ Object d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$filterNotNullTo$1(Continuation<? super ChannelsKt__DeprecatedKt$filterNotNullTo$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a;
        this.d = obj;
        this.e |= Integer.MIN_VALUE;
        a = ChannelsKt__DeprecatedKt.a((ReceiveChannel) null, (Collection) null, (Continuation) this);
        return a;
    }
}
