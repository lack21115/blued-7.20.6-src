package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/Channel.class */
public interface Channel<E> extends ReceiveChannel<E>, SendChannel<E> {
    public static final Factory a = Factory.a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/Channel$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/Channel$Factory.class */
    public static final class Factory {
        static final /* synthetic */ Factory a = new Factory();
        private static final int b = SystemPropsKt.a("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private Factory() {
        }

        public final int a() {
            return b;
        }
    }
}
