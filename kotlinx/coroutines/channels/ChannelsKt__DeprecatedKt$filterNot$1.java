package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata
@DebugMetadata(b = "Deprecated.kt", c = {194}, d = "invokeSuspend", e = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$filterNot$1.class */
final class ChannelsKt__DeprecatedKt$filterNot$1<E> extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {
    int a;
    /* synthetic */ Object b;
    final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$filterNot$1(Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$filterNot$1> continuation) {
        super(2, continuation);
        this.c = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(E e, Continuation<? super Boolean> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterNot$1) create(e, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterNot$1 channelsKt__DeprecatedKt$filterNot$1 = new ChannelsKt__DeprecatedKt$filterNot$1(this.c, continuation);
        channelsKt__DeprecatedKt$filterNot$1.b = obj;
        return channelsKt__DeprecatedKt$filterNot$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            Object obj2 = this.b;
            this.a = 1;
            Object invoke = this.c.invoke(obj2, this);
            obj = invoke;
            if (invoke == a) {
                return a;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        return Boxing.a(!((Boolean) obj).booleanValue());
    }
}
