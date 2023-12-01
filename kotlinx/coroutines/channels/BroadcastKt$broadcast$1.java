package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/BroadcastKt$broadcast$1.class */
final class BroadcastKt$broadcast$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReceiveChannel<E> f42894a;

    public final void a(Throwable th) {
        ChannelsKt.a((ReceiveChannel<?>) this.f42894a, th);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.f42314a;
    }
}
