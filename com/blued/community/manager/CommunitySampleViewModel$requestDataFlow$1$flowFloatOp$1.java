package com.blued.community.manager;

import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.square.model.SignFeedExtra;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@DebugMetadata(b = "CommunitySampleViewModel.kt", c = {104, 104}, d = "invokeSuspend", e = "com.blued.community.manager.CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1")
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1.class */
final class CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1 extends SuspendLambda implements Function2<FlowCollector<? super BluedEntity<BluedIngSelfFeed, SignFeedExtra>>, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ CommunitySampleViewModel b;
    private /* synthetic */ Object c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1(CommunitySampleViewModel communitySampleViewModel, Continuation<? super CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1> continuation) {
        super(2, continuation);
        this.b = communitySampleViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(FlowCollector<? super BluedEntity<BluedIngSelfFeed, SignFeedExtra>> flowCollector, Continuation<? super Unit> continuation) {
        return ((CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1) create(flowCollector, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1 communitySampleViewModel$requestDataFlow$1$flowFloatOp$1 = new CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1(this.b, continuation);
        communitySampleViewModel$requestDataFlow$1$flowFloatOp$1.c = obj;
        return communitySampleViewModel$requestDataFlow$1$flowFloatOp$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Object a;
        Object a2 = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            flowCollector = (FlowCollector) this.c;
            this.c = flowCollector;
            this.a = 1;
            a = this.b.a(this);
            obj = a;
            if (a == a2) {
                return a2;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.a(obj);
                return Unit.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.c;
            ResultKt.a(obj);
        }
        this.c = null;
        this.a = 2;
        if (flowCollector.emit(obj, this) == a2) {
            return a2;
        }
        return Unit.a;
    }
}
