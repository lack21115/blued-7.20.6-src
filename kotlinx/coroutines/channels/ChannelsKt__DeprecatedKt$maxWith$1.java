package kotlinx.coroutines.channels;

import com.android.ims.ImsReasonInfo;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {ImsReasonInfo.CODE_SIP_SERVER_VERSION_UNSUPPORTED, ImsReasonInfo.CODE_SIP_SERVER_PRECONDITION_FAILURE}, d = "maxWith", e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$maxWith$1.class */
public final class ChannelsKt__DeprecatedKt$maxWith$1<E> extends ContinuationImpl {
    Object a;
    Object b;
    Object c;
    Object d;
    /* synthetic */ Object e;
    int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$maxWith$1(Continuation<? super ChannelsKt__DeprecatedKt$maxWith$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a;
        this.e = obj;
        this.f |= Integer.MIN_VALUE;
        a = ChannelsKt__DeprecatedKt.a((ReceiveChannel) null, (Comparator) null, (Continuation) this);
        return a;
    }
}
