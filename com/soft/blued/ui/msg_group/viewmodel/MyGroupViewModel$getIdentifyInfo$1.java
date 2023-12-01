package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.utils.ToastUtils;
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
@DebugMetadata(b = "MyGroupViewModel.kt", c = {71}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.MyGroupViewModel$getIdentifyInfo$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/MyGroupViewModel$getIdentifyInfo$1.class */
final class MyGroupViewModel$getIdentifyInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19171a;
    final /* synthetic */ MyGroupViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGroupViewModel$getIdentifyInfo$1(MyGroupViewModel myGroupViewModel, Continuation<? super MyGroupViewModel$getIdentifyInfo$1> continuation) {
        super(2, continuation);
        this.b = myGroupViewModel;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyGroupViewModel$getIdentifyInfo$1(this.b, continuation);
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    public final Object invokeSuspend(Object obj) {
        ApiState apiState;
        Object a2 = IntrinsicsKt.a();
        int i = this.f19171a;
        if (i == 0) {
            ResultKt.a(obj);
            this.f19171a = 1;
            Object a3 = ((GroupApiService) BluedApiProxy.b().a(GroupApiService.class)).a((Continuation) this);
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
        MyGroupViewModel myGroupViewModel = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                bluedEntityA.hasMore();
                myGroupViewModel.f().setValue(list.get(0));
            } else {
                myGroupViewModel.f().setValue(CollectionsKt.b().get(0));
            }
            apiState = (ApiState) Succeed.a;
        } else {
            int i2 = bluedEntityA.code;
            String str = bluedEntityA.message;
            Intrinsics.c(str, "message");
            apiState = (ApiState) new Error(i2, str);
        }
        MyGroupViewModel myGroupViewModel2 = this.b;
        if (apiState instanceof Error) {
            Error error = apiState;
            int a4 = error.a();
            String b = error.b();
            if (40319034 == a4) {
                myGroupViewModel2.i().setValue(b);
            } else {
                ToastUtils.a(b);
            }
        }
        return Unit.a;
    }
}
