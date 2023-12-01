package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
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
    int f32863a;
    final /* synthetic */ MyGroupViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGroupViewModel$getMyGroup$1(MyGroupViewModel myGroupViewModel, Continuation<? super MyGroupViewModel$getMyGroup$1> continuation) {
        super(2, continuation);
        this.b = myGroupViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MyGroupViewModel$getMyGroup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyGroupViewModel$getMyGroup$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object a2 = IntrinsicsKt.a();
        int i = this.f32863a;
        if (i == 0) {
            ResultKt.a(obj);
            BluedApiService a3 = BluedApiProxy.b().a(GroupApiService.class);
            Intrinsics.c(a3, "getInstance().create(GroupApiService::class.java)");
            this.f32863a = 1;
            Object a4 = GroupApiService.DefaultImpls.a((GroupApiService) a3, null, this, 1, null);
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
            String message = bluedEntityA.message;
            Intrinsics.c(message, "message");
            new Error(i2, message);
        } else if (bluedEntityA.hasData()) {
            List<T> data = bluedEntityA.data;
            Intrinsics.c(data, "data");
            bluedEntityA.hasMore();
            if (!data.isEmpty()) {
                obj2 = data.get(0);
                myGroupViewModel.a((MyGroupModel) obj2);
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
                obj2 = b.get(0);
                myGroupViewModel.a((MyGroupModel) obj2);
            }
            Succeed succeed2 = Succeed.f10631a;
        }
        return Unit.f42314a;
    }
}
