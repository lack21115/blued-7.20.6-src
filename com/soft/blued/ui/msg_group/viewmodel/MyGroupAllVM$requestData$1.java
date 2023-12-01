package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.group.GroupInfoModel;
import com.soft.blued.ui.msg_group.api.GroupApiService;
import com.soft.blued.ui.msg_group.model.MyGroupModel;
import com.soft.blued.ui.msg_group.utils.GroupHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "MyGroupAllVM.kt", c = {24}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.MyGroupAllVM$requestData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/MyGroupAllVM$requestData$1.class */
final class MyGroupAllVM$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f32858a;
    final /* synthetic */ MyGroupAllVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGroupAllVM$requestData$1(MyGroupAllVM myGroupAllVM, Continuation<? super MyGroupAllVM$requestData$1> continuation) {
        super(2, continuation);
        this.b = myGroupAllVM;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MyGroupAllVM$requestData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyGroupAllVM$requestData$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<GroupInfoModel> a2;
        Object a3 = IntrinsicsKt.a();
        int i = this.f32858a;
        if (i == 0) {
            ResultKt.a(obj);
            BluedApiService a4 = BluedApiProxy.b().a(GroupApiService.class);
            Intrinsics.c(a4, "getInstance().create(GroupApiService::class.java)");
            this.f32858a = 1;
            Object a5 = GroupApiService.DefaultImpls.a((GroupApiService) a4, null, this, 1, null);
            obj = a5;
            if (a5 == a3) {
                return a3;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        MyGroupAllVM myGroupAllVM = this.b;
        if (bluedEntityA.code != 200) {
            int i2 = bluedEntityA.code;
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            new Error(i2, message);
        } else if (bluedEntityA.hasData()) {
            List<T> data = bluedEntityA.data;
            Intrinsics.c(data, "data");
            bluedEntityA.hasMore();
            if (!data.isEmpty()) {
                a2 = GroupHelper.f32827a.a((MyGroupModel) data.get(0), false);
                myGroupAllVM.loadListSucceed(a2, false);
            }
            Succeed succeed = Succeed.f10631a;
        } else {
            List b = CollectionsKt.b();
            List list = b;
            boolean z = true;
            if (list != null) {
                z = list.isEmpty();
            }
            if (!z) {
                a2 = GroupHelper.f32827a.a((MyGroupModel) b.get(0), false);
                myGroupAllVM.loadListSucceed(a2, false);
            }
            Succeed succeed2 = Succeed.f10631a;
        }
        return Unit.f42314a;
    }
}
