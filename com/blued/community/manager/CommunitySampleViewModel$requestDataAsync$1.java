package com.blued.community.manager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "CommunitySampleViewModel.kt", c = {71, 78}, d = "invokeSuspend", e = "com.blued.community.manager.CommunitySampleViewModel$requestDataAsync$1")
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunitySampleViewModel$requestDataAsync$1.class */
final class CommunitySampleViewModel$requestDataAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19092a;
    final /* synthetic */ CommunitySampleViewModel b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ Object f19093c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommunitySampleViewModel$requestDataAsync$1(CommunitySampleViewModel communitySampleViewModel, Continuation<? super CommunitySampleViewModel$requestDataAsync$1> continuation) {
        super(2, continuation);
        this.b = communitySampleViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommunitySampleViewModel$requestDataAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CommunitySampleViewModel$requestDataAsync$1 communitySampleViewModel$requestDataAsync$1 = new CommunitySampleViewModel$requestDataAsync$1(this.b, continuation);
        communitySampleViewModel$requestDataAsync$1.f19093c = obj;
        return communitySampleViewModel$requestDataAsync$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x016c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.manager.CommunitySampleViewModel$requestDataAsync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
