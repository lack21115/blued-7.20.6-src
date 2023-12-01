package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.group.GroupInfoModel;
import com.soft.blued.ui.msg_group.api.GroupApiService;
import com.soft.blued.ui.msg_group.model.GroupPrivilegeModel;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "MyGroupViewModel.kt", c = {120}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.MyGroupViewModel$initData$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/MyGroupViewModel$initData$1.class */
public final class MyGroupViewModel$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f32864a;
    final /* synthetic */ List<GroupInfoModel> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MyGroupViewModel f32865c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGroupViewModel$initData$1(List<GroupInfoModel> list, MyGroupViewModel myGroupViewModel, Continuation<? super MyGroupViewModel$initData$1> continuation) {
        super(2, continuation);
        this.b = list;
        this.f32865c = myGroupViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MyGroupViewModel$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyGroupViewModel$initData$1(this.b, this.f32865c, continuation);
    }

    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v29, types: [java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f32864a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f32864a = 1;
            Object c2 = ((GroupApiService) BluedApiProxy.b().a(GroupApiService.class)).c(this);
            obj = c2;
            if (c2 == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        List<GroupInfoModel> list = this.b;
        MyGroupViewModel myGroupViewModel = this.f32865c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                bluedEntityA.hasMore();
                if (!data.isEmpty() && ((GroupPrivilegeModel) data.get(0)).getPrivilege() == 1 && ((GroupPrivilegeModel) data.get(0)).getSuper_max_group() - ((GroupPrivilegeModel) data.get(0)).getSuper_group() > 0) {
                    ((GroupPrivilegeModel) data.get(0)).setGroupList(list);
                    myGroupViewModel.g().setValue(data.get(0));
                }
            } else {
                List b = CollectionsKt.b();
                List list2 = b;
                if (!(list2 == null || list2.isEmpty()) && ((GroupPrivilegeModel) b.get(0)).getPrivilege() == 1 && ((GroupPrivilegeModel) b.get(0)).getSuper_max_group() - ((GroupPrivilegeModel) b.get(0)).getSuper_group() > 0) {
                    ((GroupPrivilegeModel) b.get(0)).setGroupList(list);
                    myGroupViewModel.g().setValue(b.get(0));
                }
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
