package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.BluedApiService;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.soft.blued.ui.msg_group.api.GroupApiService;
import com.soft.blued.ui.msg_group.model.MyGroupModel;
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
@DebugMetadata(b = "MyGroupViewModel.kt", c = {87}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.MyGroupViewModel$getMyGroup$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/MyGroupViewModel$getMyGroup$1.class */
public final class MyGroupViewModel$getMyGroup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19172a;
    final /* synthetic */ MyGroupViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGroupViewModel$getMyGroup$1(MyGroupViewModel myGroupViewModel, Continuation<? super MyGroupViewModel$getMyGroup$1> continuation) {
        super(2, continuation);
        this.b = myGroupViewModel;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyGroupViewModel$getMyGroup$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object a2 = IntrinsicsKt.a();
        int i = this.f19172a;
        if (i == 0) {
            ResultKt.a(obj);
            BluedApiService a3 = BluedApiProxy.b().a(GroupApiService.class);
            Intrinsics.c(a3, "getInstance().create(GroupApiService::class.java)");
            this.f19172a = 1;
            Object a4 = GroupApiService.DefaultImpls.a((GroupApiService) a3, null, (Continuation) this, 1, null);
            obj = a4;
            if (a4 == a2) {
                return a2;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        MyGroupViewModel myGroupViewModel = this.b;
        if (bluedEntityA.code != 200) {
            int i2 = bluedEntityA.code;
            String str = bluedEntityA.message;
            Intrinsics.c(str, "message");
            new Error(i2, str);
        } else if (bluedEntityA.hasData()) {
            List list = bluedEntityA.data;
            Intrinsics.c(list, "data");
            bluedEntityA.hasMore();
            if (!list.isEmpty()) {
                obj2 = list.get(0);
                myGroupViewModel.a((MyGroupModel) obj2);
            }
            ApiState apiState = Succeed.a;
        } else {
            List b = CollectionsKt.b();
            List list2 = b;
            boolean z = true;
            if (list2 != null) {
                z = list2.isEmpty();
            }
            if (!z) {
                obj2 = b.get(0);
                myGroupViewModel.a((MyGroupModel) obj2);
            }
            ApiState apiState2 = Succeed.a;
        }
        return Unit.a;
    }
}
