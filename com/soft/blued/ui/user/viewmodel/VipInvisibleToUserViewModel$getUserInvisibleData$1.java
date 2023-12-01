package com.soft.blued.ui.user.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
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

@Metadata
@DebugMetadata(b = "VipInvisibleToUserViewModel.kt", c = {37}, d = "invokeSuspend", e = "com.soft.blued.ui.user.viewmodel.VipInvisibleToUserViewModel$getUserInvisibleData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/viewmodel/VipInvisibleToUserViewModel$getUserInvisibleData$1.class */
final class VipInvisibleToUserViewModel$getUserInvisibleData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f20672a;
    final /* synthetic */ VipInvisibleToUserAction.getInvisibleUserData b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ VipInvisibleToUserViewModel f20673c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipInvisibleToUserViewModel$getUserInvisibleData$1(VipInvisibleToUserAction.getInvisibleUserData getinvisibleuserdata, VipInvisibleToUserViewModel vipInvisibleToUserViewModel, Continuation<? super VipInvisibleToUserViewModel$getUserInvisibleData$1> continuation) {
        super(2, continuation);
        this.b = getinvisibleuserdata;
        this.f20673c = vipInvisibleToUserViewModel;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VipInvisibleToUserViewModel$getUserInvisibleData$1(this.b, this.f20673c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f20672a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f20672a = 1;
            Object a3 = ((UserApiService) BluedApiProxy.b().a(UserApiService.class)).a(this.b.a(), this.b.b(), (Continuation) this);
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
        VipInvisibleToUserViewModel vipInvisibleToUserViewModel = this.f20673c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                final List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                bluedEntityA.hasMore();
                BluedStructureExtKt.a(vipInvisibleToUserViewModel, new Function1<VipInvisibleToUserState, VipInvisibleToUserState>() { // from class: com.soft.blued.ui.user.viewmodel.VipInvisibleToUserViewModel$getUserInvisibleData$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final VipInvisibleToUserState invoke(VipInvisibleToUserState vipInvisibleToUserState) {
                        Intrinsics.e(vipInvisibleToUserState, "$this$setState");
                        return vipInvisibleToUserState.a(list.get(0));
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

                    /* renamed from: a */
                    public final VipInvisibleToUserState invoke(VipInvisibleToUserState vipInvisibleToUserState) {
                        Intrinsics.e(vipInvisibleToUserState, "$this$setState");
                        return vipInvisibleToUserState.a(b.get(0));
                    }
                });
            }
            ApiState apiState = Succeed.a;
        } else {
            int i2 = bluedEntityA.code;
            String str = bluedEntityA.message;
            Intrinsics.c(str, "message");
            new Error(i2, str);
        }
        return Unit.a;
    }
}
