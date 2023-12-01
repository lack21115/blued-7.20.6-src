package com.blued.community.manager;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.community.model.BluedIngSelfFeed;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "CommunitySampleViewModel.kt", c = {35}, d = "invokeSuspend", e = "com.blued.community.manager.CommunitySampleViewModel$requestDataWithContext$1$entityA$1$deferredFeed$1")
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunitySampleViewModel$requestDataWithContext$1$entityA$1$deferredFeed$1.class */
final class CommunitySampleViewModel$requestDataWithContext$1$entityA$1$deferredFeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BluedEntityA<BluedIngSelfFeed>>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19110a;
    final /* synthetic */ CommunitySampleViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunitySampleViewModel$requestDataWithContext$1$entityA$1$deferredFeed$1(CommunitySampleViewModel communitySampleViewModel, Continuation<? super CommunitySampleViewModel$requestDataWithContext$1$entityA$1$deferredFeed$1> continuation) {
        super(2, continuation);
        this.b = communitySampleViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BluedEntityA<BluedIngSelfFeed>> continuation) {
        return ((CommunitySampleViewModel$requestDataWithContext$1$entityA$1$deferredFeed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommunitySampleViewModel$requestDataWithContext$1$entityA$1$deferredFeed$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b;
        Object a2 = IntrinsicsKt.a();
        int i = this.f19110a;
        if (i != 0) {
            if (i == 1) {
                ResultKt.a(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.a(obj);
        this.f19110a = 1;
        b = this.b.b(this);
        return b == a2 ? a2 : b;
    }
}
