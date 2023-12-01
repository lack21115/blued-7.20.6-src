package com.soft.blued.ui.msg_group.viewmodel;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.utils.CommonPreferences;
import com.soft.blued.ui.find.model.CityLocation;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "GroupCreateViewModel.kt", c = {38}, d = "invokeSuspend", e = "com.soft.blued.ui.msg_group.viewmodel.GroupCreateViewModel$getCityCode$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/viewmodel/GroupCreateViewModel$getCityCode$1.class */
public final class GroupCreateViewModel$getCityCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f32843a;
    final /* synthetic */ GroupCreateViewModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupCreateViewModel$getCityCode$1(GroupCreateViewModel groupCreateViewModel, Continuation<? super GroupCreateViewModel$getCityCode$1> continuation) {
        super(2, continuation);
        this.b = groupCreateViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupCreateViewModel$getCityCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f42314a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupCreateViewModel$getCityCode$1(this.b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f32843a;
        if (i == 0) {
            ResultKt.a(obj);
            GroupApiService groupApiService = (GroupApiService) BluedApiProxy.b().a(GroupApiService.class);
            String u = CommonPreferences.u();
            Intrinsics.c(u, "getLONGITUDE()");
            String v = CommonPreferences.v();
            Intrinsics.c(v, "getLATITUDE()");
            this.f32843a = 1;
            Object b = groupApiService.b(u, v, this);
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
        GroupCreateViewModel groupCreateViewModel = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List<T> data = bluedEntityA.data;
                Intrinsics.c(data, "data");
                bluedEntityA.hasMore();
                groupCreateViewModel.e().setValue(((CityLocation) data.get(0)).city_code_plus);
            } else {
                groupCreateViewModel.e().setValue(((CityLocation) CollectionsKt.b().get(0)).city_code_plus);
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
