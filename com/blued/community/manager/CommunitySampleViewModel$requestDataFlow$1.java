package com.blued.community.manager;

import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.square.model.SignFeedExtra;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
@DebugMetadata(b = "CommunitySampleViewModel.kt", c = {185}, d = "invokeSuspend", e = "com.blued.community.manager.CommunitySampleViewModel$requestDataFlow$1")
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunitySampleViewModel$requestDataFlow$1.class */
final class CommunitySampleViewModel$requestDataFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ CommunitySampleViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    @DebugMetadata(b = "CommunitySampleViewModel.kt", c = {}, d = "invokeSuspend", e = "com.blued.community.manager.CommunitySampleViewModel$requestDataFlow$1$1")
    /* renamed from: com.blued.community.manager.CommunitySampleViewModel$requestDataFlow$1$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunitySampleViewModel$requestDataFlow$1$1.class */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<BluedEntityA<BluedIngSelfFeed>, BluedEntity<BluedIngSelfFeed, SignFeedExtra>, Continuation<? super BluedEntityA<BluedIngSelfFeed>>, Object> {
        int a;
        /* synthetic */ Object b;
        /* synthetic */ Object c;
        final /* synthetic */ CommunitySampleViewModel d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CommunitySampleViewModel communitySampleViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.d = communitySampleViewModel;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object a(BluedEntityA<BluedIngSelfFeed> bluedEntityA, BluedEntity<BluedIngSelfFeed, SignFeedExtra> bluedEntity, Continuation<? super BluedEntityA<BluedIngSelfFeed>> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.d, continuation);
            anonymousClass1.b = bluedEntityA;
            anonymousClass1.c = bluedEntity;
            return anonymousClass1.invokeSuspend(Unit.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.a();
            if (this.a == 0) {
                ResultKt.a(obj);
                BluedEntityA bluedEntityA = (BluedEntityA) this.b;
                BluedEntity bluedEntity = (BluedEntity) this.c;
                if (bluedEntity == null) {
                    LogUtils.c(Intrinsics.a("entityB == null, ", (Object) Boxing.a(Thread.currentThread().getId())));
                    return bluedEntityA;
                }
                LogUtils.c(Intrinsics.a("entityB != null, ", (Object) Boxing.a(Thread.currentThread().getId())));
                this.d.a(bluedEntityA == null ? null : bluedEntityA.data, bluedEntity);
                return bluedEntityA;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommunitySampleViewModel$requestDataFlow$1(CommunitySampleViewModel communitySampleViewModel, Continuation<? super CommunitySampleViewModel$requestDataFlow$1> continuation) {
        super(2, continuation);
        this.b = communitySampleViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommunitySampleViewModel$requestDataFlow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommunitySampleViewModel$requestDataFlow$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a = IntrinsicsKt.a();
        int i = this.a;
        if (i == 0) {
            ResultKt.a(obj);
            Flow a2 = FlowKt.a(FlowKt.a(FlowKt.a((Function2) new CommunitySampleViewModel$requestDataFlow$1$flowFeed$1(this.b, null)), Dispatchers.c()), FlowKt.a(FlowKt.a((Function2) new CommunitySampleViewModel$requestDataFlow$1$flowFloatOp$1(this.b, null)), Dispatchers.c()), new AnonymousClass1(this.b, null));
            final CommunitySampleViewModel communitySampleViewModel = this.b;
            this.a = 1;
            if (a2.a(new FlowCollector<BluedEntityA<BluedIngSelfFeed>>() { // from class: com.blued.community.manager.CommunitySampleViewModel$requestDataFlow$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(BluedEntityA<BluedIngSelfFeed> bluedEntityA, Continuation<? super Unit> continuation) {
                    BluedEntityA<BluedIngSelfFeed> bluedEntityA2 = bluedEntityA;
                    if (bluedEntityA2 != null) {
                        CommunitySampleViewModel.this.loadListSucceed(bluedEntityA2.data, bluedEntityA2.hasMore());
                    } else {
                        CommunitySampleViewModel.this.loadListFailed();
                    }
                    return Unit.a;
                }
            }, this) == a) {
                return a;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        return Unit.a;
    }
}
