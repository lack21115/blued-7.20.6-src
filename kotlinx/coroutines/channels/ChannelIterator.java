package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelIterator.class */
public interface ChannelIterator<E> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelIterator$DefaultImpls.class */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0094  */
        @kotlin.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static /* synthetic */ java.lang.Object a(kotlinx.coroutines.channels.ChannelIterator r4, kotlin.coroutines.Continuation r5) {
            /*
                r0 = r5
                boolean r0 = r0 instanceof kotlinx.coroutines.channels.ChannelIterator$next0$1
                if (r0 == 0) goto L26
                r0 = r5
                kotlinx.coroutines.channels.ChannelIterator$next0$1 r0 = (kotlinx.coroutines.channels.ChannelIterator$next0$1) r0
                r7 = r0
                r0 = r7
                int r0 = r0.f42902c
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r0 = r0 & r1
                if (r0 == 0) goto L26
                r0 = r7
                r1 = r7
                int r1 = r1.f42902c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                int r1 = r1 + r2
                r0.f42902c = r1
                r0 = r7
                r5 = r0
                goto L2f
            L26:
                kotlinx.coroutines.channels.ChannelIterator$next0$1 r0 = new kotlinx.coroutines.channels.ChannelIterator$next0$1
                r1 = r0
                r2 = r5
                r1.<init>(r2)
                r5 = r0
            L2f:
                r0 = r5
                java.lang.Object r0 = r0.b
                r7 = r0
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.a()
                r8 = r0
                r0 = r5
                int r0 = r0.f42902c
                r6 = r0
                r0 = r6
                if (r0 == 0) goto L62
                r0 = r6
                r1 = 1
                if (r0 != r1) goto L58
                r0 = r5
                java.lang.Object r0 = r0.f42901a
                kotlinx.coroutines.channels.ChannelIterator r0 = (kotlinx.coroutines.channels.ChannelIterator) r0
                r4 = r0
                r0 = r7
                kotlin.ResultKt.a(r0)
                r0 = r7
                r5 = r0
                goto L83
            L58:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r0
            L62:
                r0 = r7
                kotlin.ResultKt.a(r0)
                r0 = r5
                r1 = r4
                r0.f42901a = r1
                r0 = r5
                r1 = 1
                r0.f42902c = r1
                r0 = r4
                r1 = r5
                java.lang.Object r0 = r0.a(r1)
                r7 = r0
                r0 = r7
                r5 = r0
                r0 = r7
                r1 = r8
                if (r0 != r1) goto L83
                r0 = r8
                return r0
            L83:
                r0 = r5
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L94
                r0 = r4
                java.lang.Object r0 = r0.b()
                return r0
            L94:
                kotlinx.coroutines.channels.ClosedReceiveChannelException r0 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
                r1 = r0
                java.lang.String r2 = "Channel was closed"
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelIterator.DefaultImpls.a(kotlinx.coroutines.channels.ChannelIterator, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    Object a(Continuation<? super Boolean> continuation);

    E b();
}
