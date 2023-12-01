package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$consumesAll$1.class */
final class ChannelsKt__DeprecatedKt$consumesAll$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ReceiveChannel<?>[] a;

    public final void a(Throwable th) {
        ReceiveChannel<?>[] receiveChannelArr = this.a;
        int length = receiveChannelArr.length;
        Throwable th2 = null;
        int i = 0;
        while (i < length) {
            ReceiveChannel<?> receiveChannel = receiveChannelArr[i];
            i++;
            try {
                ChannelsKt.a(receiveChannel, th);
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    ExceptionsKt.a(th2, th3);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Throwable th) {
        a(th);
        return Unit.a;
    }
}
