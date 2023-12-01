package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.soft.blued.ui.msg_group.api.GroupApiService;
import java.util.List;
import java.util.Map;
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
@DebugMetadata(b = "GroupCreateViewModel.kt", c = {27}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.GroupCreateViewModel$createGroup$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupCreateViewModel$createGroup$1.class */
final class GroupCreateViewModel$createGroup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19150a;
    final /* synthetic */ Map<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ GroupCreateViewModel f19151c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupCreateViewModel$createGroup$1(Map<String, String> map, GroupCreateViewModel groupCreateViewModel, Continuation<? super GroupCreateViewModel$createGroup$1> continuation) {
        super(2, continuation);
        this.b = map;
        this.f19151c = groupCreateViewModel;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupCreateViewModel$createGroup$1(this.b, this.f19151c, continuation);
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f19150a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f19150a = 1;
            Object d = ((GroupApiService) BluedApiProxy.b().a(GroupApiService.class)).d(this.b, (Continuation) this);
            obj = d;
            if (d == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        GroupCreateViewModel groupCreateViewModel = this.f19151c;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                bluedEntityA.hasMore();
                groupCreateViewModel.d().setValue(list.get(0));
            } else {
                groupCreateViewModel.d().setValue(CollectionsKt.b().get(0));
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
