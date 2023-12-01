package com.soft.blued.ui.msg_group;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.BluedApiService;
import com.soft.blued.ui.msg_group.TestService;
import com.soft.blued.ui.user.model.UserInfoEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "TestFragment.kt", c = {67}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.TestFragment$requestApi$1$userInfo$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/TestFragment$requestApi$1$userInfo$1.class */
final class TestFragment$requestApi$1$userInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BluedEntityA<UserInfoEntity>>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f32628a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TestFragment$requestApi$1$userInfo$1(Continuation<? super TestFragment$requestApi$1$userInfo$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BluedEntityA<UserInfoEntity>> continuation) {
        return ((TestFragment$requestApi$1$userInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestFragment$requestApi$1$userInfo$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f32628a;
        if (i != 0) {
            if (i == 1) {
                ResultKt.a(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.a(obj);
        BluedApiService a3 = BluedApiProxy.b().a(TestService.class);
        Intrinsics.c(a3, "getInstance().create(TestService::class.java)");
        this.f32628a = 1;
        Object a4 = TestService.DefaultImpls.a((TestService) a3, (String) null, this, 1, (Object) null);
        return a4 == a2 ? a2 : a4;
    }
}
