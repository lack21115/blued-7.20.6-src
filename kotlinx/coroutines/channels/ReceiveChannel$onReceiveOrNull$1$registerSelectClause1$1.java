package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [R, E] */
@Metadata
@DebugMetadata(b = "Channel.kt", c = {370}, d = "invokeSuspend", e = "kotlinx.coroutines.channels.ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1.class */
final class ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1<E, R> extends SuspendLambda implements Function2<ChannelResult<? extends E>, Continuation<? super R>, Object> {
    int a;
    /* synthetic */ Object b;
    final /* synthetic */ Function2<E, Continuation<? super R>, Object> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1(Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1> continuation) {
        super(2, continuation);
        this.c = function2;
    }

    public final Object a(Object obj, Continuation<? super R> continuation) {
        return ((ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1) create(ChannelResult.h(obj), continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1 receiveChannel$onReceiveOrNull$1$registerSelectClause1$1 = new ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1(this.c, continuation);
        receiveChannel$onReceiveOrNull$1$registerSelectClause1$1.b = obj;
        return receiveChannel$onReceiveOrNull$1$registerSelectClause1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a(((ChannelResult) obj).a(), (Continuation) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a = IntrinsicsKt.a();
        int i = this.a;
        if (i != 0) {
            if (i == 1) {
                ResultKt.a(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.a(obj);
        Object a2 = ((ChannelResult) this.b).a();
        Throwable d = ChannelResult.d(a2);
        if (d == null) {
            Function2<E, Continuation<? super R>, Object> function2 = this.c;
            Object b = ChannelResult.b(a2);
            this.a = 1;
            Object invoke = function2.invoke(b, this);
            return invoke == a ? a : invoke;
        }
        throw d;
    }
}
