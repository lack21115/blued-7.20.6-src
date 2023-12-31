package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.soft.blued.ui.msg_group.api.GroupApiService;
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
@DebugMetadata(b = "GroupInfoVM.kt", c = {33}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.GroupInfoVM$getPrivilege$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupInfoVM$getPrivilege$1.class */
final class GroupInfoVM$getPrivilege$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19162a;
    final /* synthetic */ GroupInfoVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInfoVM$getPrivilege$1(GroupInfoVM groupInfoVM, Continuation<? super GroupInfoVM$getPrivilege$1> continuation) {
        super(2, continuation);
        this.b = groupInfoVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupInfoVM$getPrivilege$1(this.b, continuation);
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f19162a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f19162a = 1;
            Object c2 = ((GroupApiService) BluedApiProxy.b().a(GroupApiService.class)).c((Continuation) this);
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
        GroupInfoVM groupInfoVM = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                bluedEntityA.hasMore();
                if (!list.isEmpty()) {
                    groupInfoVM.e().setValue(list.get(0));
                }
            } else {
                List b = CollectionsKt.b();
                List list2 = b;
                boolean z = true;
                if (list2 != null) {
                    z = list2.isEmpty();
                }
                if (!z) {
                    groupInfoVM.e().setValue(b.get(0));
                }
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
