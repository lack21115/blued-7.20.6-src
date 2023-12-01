package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.utils.ToastUtils;
import com.soft.blued.R;
import com.soft.blued.ui.msg_group.api.GroupApiService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(b = "GroupInfoVM.kt", c = {53}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.GroupInfoVM$degradeGroup$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupInfoVM$degradeGroup$1.class */
final class GroupInfoVM$degradeGroup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19160a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ GroupInfoVM f19161c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInfoVM$degradeGroup$1(String str, GroupInfoVM groupInfoVM, Continuation<? super GroupInfoVM$degradeGroup$1> continuation) {
        super(2, continuation);
        this.b = str;
        this.f19161c = groupInfoVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupInfoVM$degradeGroup$1(this.b, this.f19161c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        ApiState apiState;
        Object a2 = IntrinsicsKt.a();
        int i = this.f19160a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f19160a = 1;
            Object b = ((GroupApiService) BluedApiProxy.b().a(GroupApiService.class)).b(this.b, (Continuation) this);
            obj = b;
            if (b == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        GroupInfoVM groupInfoVM = this.f19161c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                Intrinsics.c(bluedEntityA.data, "data");
                bluedEntityA.hasMore();
            } else {
                CollectionsKt.b();
            }
            ToastUtils.a(AppInfo.d().getString(R.string.group_degrade_succeed_toast));
            groupInfoVM.f().setValue(Boxing.a(2));
            apiState = (ApiState) Succeed.a;
        } else {
            int i2 = bluedEntityA.code;
            String str = bluedEntityA.message;
            Intrinsics.c(str, "message");
            apiState = (ApiState) new Error(i2, str);
        }
        GroupInfoVM groupInfoVM2 = this.f19161c;
        if (apiState instanceof Error) {
            Error error = apiState;
            int a3 = error.a();
            String b2 = error.b();
            if (a3 == 40319046) {
                groupInfoVM2.d().setValue(b2);
            } else {
                ToastUtils.a(b2);
            }
        }
        return Unit.a;
    }
}
