package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {}, d = "invokeSuspend", e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$distinct$1.class */
final class ChannelsKt__DeprecatedKt$distinct$1<E> extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f42922a;
    /* synthetic */ Object b;

    ChannelsKt__DeprecatedKt$distinct$1(Continuation<? super ChannelsKt__DeprecatedKt$distinct$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(E e, Continuation<? super E> continuation) {
        return ((ChannelsKt__DeprecatedKt$distinct$1) create(e, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$distinct$1 channelsKt__DeprecatedKt$distinct$1 = new ChannelsKt__DeprecatedKt$distinct$1(continuation);
        channelsKt__DeprecatedKt$distinct$1.b = obj;
        return channelsKt__DeprecatedKt$distinct$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f42922a == 0) {
            ResultKt.a(obj);
            return this.b;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
