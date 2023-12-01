package com.soft.blued.ui.setting.vm;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.soft.blued.ui.setting.api.SettingApiService;
import com.soft.blued.ui.setting.model.FinanceOpenModel;
import java.util.List;
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
@DebugMetadata(b = "HelperCenterVM.kt", c = {21}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.HelperCenterVM$getFinanceOpe$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/HelperCenterVM$getFinanceOpe$1.class */
final class HelperCenterVM$getFinanceOpe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19957a;
    final /* synthetic */ HelperCenterVM b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HelperCenterVM$getFinanceOpe$1(HelperCenterVM helperCenterVM, Continuation<? super HelperCenterVM$getFinanceOpe$1> continuation) {
        super(2, continuation);
        this.b = helperCenterVM;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HelperCenterVM$getFinanceOpe$1(this.b, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = IntrinsicsKt.a();
        int i = this.f19957a;
        boolean z = true;
        if (i == 0) {
            ResultKt.a(obj);
            this.f19957a = 1;
            Object a3 = ((SettingApiService) BluedApiProxy.b().a(SettingApiService.class)).a((Continuation) this);
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
        HelperCenterVM helperCenterVM = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                List list = bluedEntityA.data;
                Intrinsics.c(list, "data");
                bluedEntityA.hasMore();
                if (!list.isEmpty()) {
                    MutableLiveData<Boolean> d = helperCenterVM.d();
                    if (((FinanceOpenModel) list.get(0)).getFinance_open() != 1) {
                        z = false;
                    }
                    d.postValue(Boxing.a(z));
                }
            } else {
                List b = CollectionsKt.b();
                List list2 = b;
                if (!(list2 == null || list2.isEmpty())) {
                    helperCenterVM.d().postValue(Boxing.a(((FinanceOpenModel) b.get(0)).getFinance_open() == 1));
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
