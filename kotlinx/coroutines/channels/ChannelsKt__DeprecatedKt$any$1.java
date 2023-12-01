package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.apache.commons.codec.language.bm.Languages;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {342}, d = Languages.ANY, e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$any$1.class */
public final class ChannelsKt__DeprecatedKt$any$1<E> extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    Object f42916a;
    /* synthetic */ Object b;

    /* renamed from: c  reason: collision with root package name */
    int f42917c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$any$1(Continuation<? super ChannelsKt__DeprecatedKt$any$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object g;
        this.b = obj;
        this.f42917c |= Integer.MIN_VALUE;
        g = ChannelsKt__DeprecatedKt.g(null, this);
        return g;
    }
}
