package com.soft.blued.ui.user.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.ui.user.api.UserApiService;
import com.soft.blued.ui.user.state.VipInvisibleToUserAction;
import com.soft.blued.ui.user.state.VipInvisibleToUserState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "VipInvisibleToUserViewModel.kt", c = {37}, d = "invokeSuspend", e = "com.soft.blued.ui.user.viewmodel.VipInvisibleToUserViewModel$getUserInvisibleData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/VipInvisibleToUserViewModel$getUserInvisibleData$1.class */
public final class VipInvisibleToUserViewModel$getUserInvisibleData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f34363a;
    final /* synthetic */ VipInvisibleToUserAction.getInvisibleUserData b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ VipInvisibleToUserViewModel f34364c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipInvisibleToUserViewModel$getUserInvisibleData$1(VipInvisibleToUserAction.getInvisibleUserData getinvisibleuserdata, VipInvisibleToUserViewModel vipInvisibleToUserViewModel, Continuation<? super VipInvisibleToUserViewModel$getUserInvisibleData$1> continuation) {
        super(2, continuation);
        this.b = getinvisibleuserdata;
        this.f34364c = vipInvisibleToUserViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VipInvisibleToUserViewModel$getUserInvisibleData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VipInvisibleToUserViewModel$getUserInvisibleData$1(this.b, this.f34364c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f34363a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f34363a = 1;
            Object a3 = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).a(this.b.a(), this.b.b(), this);
            obj = a3;
            if (a3 == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        VipInvisibleToUserViewModel vipInvisibleToUserViewModel = this.f34364c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                final List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                bluedEntityA.hasMore();
                BluedStructureExtKt.a(vipInvisibleToUserViewModel, new Function1<VipInvisibleToUserState, VipInvisibleToUserState>() { // from class: com.soft.blued.ui.user.viewmodel.VipInvisibleToUserViewModel$getUserInvisibleData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final VipInvisibleToUserState invoke(VipInvisibleToUserState setState) {
                        Intrinsics.e(setState, "$this$setState");
                        return setState.a(data.get(0));
                    }
                });
            } else {
                final List b = CollectionsKt.b();
                BluedStructureExtKt.a(vipInvisibleToUserViewModel, new Function1<VipInvisibleToUserState, VipInvisibleToUserState>() { // from class: com.soft.blued.ui.user.viewmodel.VipInvisibleToUserViewModel$getUserInvisibleData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final VipInvisibleToUserState invoke(VipInvisibleToUserState setState) {
                        Intrinsics.e(setState, "$this$setState");
                        return setState.a(b.get(0));
                    }
                });
            }
            Succeed succeed = Succeed.f10631a;
        } else {
            int i2 = bluedEntityA.code;
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            new Error(i2, message);
        }
        return Unit.f42314a;
    }
}
