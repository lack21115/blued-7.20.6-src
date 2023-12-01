package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ReceiveChannel.class */
public interface ReceiveChannel<E> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ReceiveChannel$DefaultImpls.class */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
        @kotlin.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static <E> java.lang.Object a(kotlinx.coroutines.channels.ReceiveChannel<? extends E> r4, kotlin.coroutines.Continuation<? super E> r5) {
            /*
                r0 = r5
                boolean r0 = r0 instanceof kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                if (r0 == 0) goto L26
                r0 = r5
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = (kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1) r0
                r7 = r0
                r0 = r7
                int r0 = r0.b
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r0 = r0 & r1
                if (r0 == 0) goto L26
                r0 = r7
                r1 = r7
                int r1 = r1.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                int r1 = r1 + r2
                r0.b = r1
                r0 = r7
                r5 = r0
                goto L2f
            L26:
                kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1 r0 = new kotlinx.coroutines.channels.ReceiveChannel$receiveOrNull$1
                r1 = r0
                r2 = r5
                r1.<init>(r2)
                r5 = r0
            L2f:
                r0 = r5
                java.lang.Object r0 = r0.a
                r8 = r0
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
                r7 = r0
                r0 = r5
                int r0 = r0.b
                r6 = r0
                r0 = r6
                if (r0 == 0) goto L62
                r0 = r6
                r1 = 1
                if (r0 != r1) goto L58
                r0 = r8
                kotlin.ResultKt.a(r0)
                r0 = r8
                kotlinx.coroutines.channels.ChannelResult r0 = (kotlinx.coroutines.channels.ChannelResult) r0
                java.lang.Object r0 = r0.a()
                r4 = r0
                goto L7d
            L58:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r0
            L62:
                r0 = r8
                kotlin.ResultKt.a(r0)
                r0 = r5
                r1 = 1
                r0.b = r1
                r0 = r4
                r1 = r5
                java.lang.Object r0 = r0.a(r1)
                r5 = r0
                r0 = r5
                r4 = r0
                r0 = r5
                r1 = r7
                if (r0 != r1) goto L7d
                r0 = r7
                return r0
            L7d:
                r0 = r4
                java.lang.Object r0 = kotlinx.coroutines.channels.ChannelResult.b(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public static /* synthetic */ void a(ReceiveChannel receiveChannel, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            receiveChannel.a(cancellationException);
        }
    }

    Object a(Continuation<? super ChannelResult<? extends E>> continuation);

    void a(CancellationException cancellationException);

    ChannelIterator<E> av_();

    Object aw_();

    SelectClause1<E> j();

    SelectClause1<ChannelResult<E>> k();
}
