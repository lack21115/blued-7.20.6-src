package kotlinx.coroutines.channels;

import com.blued.das.live.LiveProtos;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "AbstractChannel.kt", c = {LiveProtos.Event.LIVE_SET_GIFT_EXPLAIN_PAGE_DETAIL_CLICK_VALUE}, d = "receiveCatching-JP2dKIU", e = "kotlinx.coroutines.channels.AbstractChannel")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/AbstractChannel$receiveCatching$1.class */
public final class AbstractChannel$receiveCatching$1 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ Object f42879a;
    final /* synthetic */ AbstractChannel<E> b;

    /* renamed from: c  reason: collision with root package name */
    int f42880c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractChannel$receiveCatching$1(AbstractChannel<E> abstractChannel, Continuation<? super AbstractChannel$receiveCatching$1> continuation) {
        super(continuation);
        this.b = abstractChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f42879a = obj;
        this.f42880c |= Integer.MIN_VALUE;
        Object a2 = this.b.a(this);
        return a2 == IntrinsicsKt.a() ? a2 : ChannelResult.h(a2);
    }
}
