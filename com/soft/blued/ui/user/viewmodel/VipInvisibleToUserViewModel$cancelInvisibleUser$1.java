package com.soft.blued.ui.user.viewmodel;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.user.state.VipInvisibleToUserAction;
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
@DebugMetadata(b = "VipInvisibleToUserViewModel.kt", c = {}, d = "invokeSuspend", e = "com.soft.blued.ui.user.viewmodel.VipInvisibleToUserViewModel$cancelInvisibleUser$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/VipInvisibleToUserViewModel$cancelInvisibleUser$1.class */
final class VipInvisibleToUserViewModel$cancelInvisibleUser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f34362a;
    final /* synthetic */ VipInvisibleToUserAction.cancelInvisibleUser b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipInvisibleToUserViewModel$cancelInvisibleUser$1(VipInvisibleToUserAction.cancelInvisibleUser cancelinvisibleuser, Continuation<? super VipInvisibleToUserViewModel$cancelInvisibleUser$1> continuation) {
        super(2, continuation);
        this.b = cancelinvisibleuser;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VipInvisibleToUserViewModel$cancelInvisibleUser$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VipInvisibleToUserViewModel$cancelInvisibleUser$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.a();
        if (this.f34362a == 0) {
            ResultKt.a(obj);
            UserHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.user.viewmodel.VipInvisibleToUserViewModel$cancelInvisibleUser$1.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                }
            }, this.b.a(), (IRequestHost) null);
            return Unit.f42314a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
