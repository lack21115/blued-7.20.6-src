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

    /* renamed from: a  reason: collision with root package name */
    int f19101a;
    final /* synthetic */ CommunitySampleViewModel b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ Object f19102c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1(CommunitySampleViewModel communitySampleViewModel, Continuation<? super CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1> continuation) {
        super(2, continuation);
        this.b = communitySampleViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(FlowCollector<? super BluedEntity<BluedIngSelfFeed, SignFeedExtra>> flowCollector, Continuation<? super Unit> continuation) {
        return ((CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1) create(flowCollector, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1 communitySampleViewModel$requestDataFlow$1$flowFloatOp$1 = new CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1(this.b, continuation);
        communitySampleViewModel$requestDataFlow$1$flowFloatOp$1.f19102c = obj;
        return communitySampleViewModel$requestDataFlow$1$flowFloatOp$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Object a2;
        Object a3 = IntrinsicsKt.a();
        int i = this.f19101a;
        if (i == 0) {
            ResultKt.a(obj);
            flowCollector = (FlowCollector) this.f19102c;
            this.f19102c = flowCollector;
            this.f19101a = 1;
            a2 = this.b.a(this);
            obj = a2;
            if (a2 == a3) {
                return a3;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.a(obj);
                return Unit.f42314a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.f19102c;
            ResultKt.a(obj);
        }
        this.f19102c = null;
        this.f19101a = 2;
        if (flowCollector.emit(obj, this) == a3) {
            return a3;
        }
        return Unit.f42314a;
    }
}
