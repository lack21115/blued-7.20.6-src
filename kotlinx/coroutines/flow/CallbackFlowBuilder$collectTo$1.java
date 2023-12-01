package kotlinx.coroutines.flow;

import com.android.ims.ImsReasonInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "Builders.kt", c = {ImsReasonInfo.CODE_SIP_SERVER_TIMEOUT}, d = "collectTo", e = "kotlinx.coroutines.flow.CallbackFlowBuilder")
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/flow/CallbackFlowBuilder$collectTo$1.class */
public final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {
    Object a;
    /* synthetic */ Object b;
    final /* synthetic */ CallbackFlowBuilder<T> c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder<T> callbackFlowBuilder, Continuation<? super CallbackFlowBuilder$collectTo$1> continuation) {
        super(continuation);
        this.c = callbackFlowBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((ProducerScope) null, this);
    }
}
