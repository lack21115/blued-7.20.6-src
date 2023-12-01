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
@DebugMetadata(b = "GroupInfoVM.kt", c = {42}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.GroupInfoVM$upgradeGroup$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupInfoVM$upgradeGroup$1.class */
final class GroupInfoVM$upgradeGroup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19163a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ GroupInfoVM f19164c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInfoVM$upgradeGroup$1(String str, GroupInfoVM groupInfoVM, Continuation<? super GroupInfoVM$upgradeGroup$1> continuation) {
        super(2, continuation);
        this.b = str;
        this.f19164c = groupInfoVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupInfoVM$upgradeGroup$1(this.b, this.f19164c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f19163a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f19163a = 1;
            Object a3 = ((GroupApiService) BluedApiProxy.b().a(GroupApiService.class)).a(this.b, (Continuation) this);
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
        GroupInfoVM groupInfoVM = this.f19164c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                Intrinsics.c(bluedEntityA.data, "data");
                bluedEntityA.hasMore();
            } else {
                CollectionsKt.b();
            }
            ToastUtils.a(AppInfo.d().getString(R.string.group_upgrade_succeed_toast));
            groupInfoVM.f().setValue(Boxing.a(1));
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
