package kotlinx.coroutines.channels;

import android.telephony.SubscriptionManager;
import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/Channel.class */
public interface Channel<E> extends ReceiveChannel<E>, SendChannel<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final Factory f42899a = Factory.f42900a;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/Channel$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/Channel$Factory.class */
    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Factory f42900a = new Factory();
        private static final int b = SystemPropsKt.a("kotlinx.coroutines.channels.defaultBuffer", 64, 1, (int) SubscriptionManager.MAX_SUBSCRIPTION_ID_VALUE);

        private Factory() {
        }

        public final int a() {
            return b;
        }
    }
}
