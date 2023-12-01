package com.soft.blued.ui.setting.vm;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.ui.setting.api.SettingApiService;
import com.soft.blued.ui.setting.model.ResetPwdModel;
import com.soft.blued.ui.setting.state.ResetPwdState;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "ResetPwdVM.kt", c = {90}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.ResetPwdVM$getPhone$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/ResetPwdVM$getPhone$1.class */
public final class ResetPwdVM$getPhone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19990a;
    final /* synthetic */ ResetPwdVM b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Map<String, String> f19991c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPwdVM$getPhone$1(ResetPwdVM resetPwdVM, Map<String, String> map, Continuation<? super ResetPwdVM$getPhone$1> continuation) {
        super(2, continuation);
        this.b = resetPwdVM;
        this.f19991c = map;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResetPwdVM$getPhone$1(this.b, this.f19991c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Map<String, String> a2;
        ResetPwdVM resetPwdVM;
        Function1<ResetPwdState, ResetPwdState> function1;
        Object a3 = IntrinsicsKt.a();
        int i = this.f19990a;
        if (i == 0) {
            ResultKt.a(obj);
            SettingApiService settingApiService = (SettingApiService) BluedApiProxy.b().a(SettingApiService.class);
            a2 = this.b.a(this.f19991c);
            this.f19990a = 1;
            Object a4 = settingApiService.a(a2, (Continuation) this);
            obj = a4;
            if (a4 == a3) {
                return a3;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.a(obj);
        }
        BluedEntityA bluedEntityA = (BluedEntityA) obj;
        ResetPwdVM resetPwdVM2 = this.b;
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
                final String a5 = AesCrypto2.a(((ResetPwdModel) list.get(0)).get_());
                resetPwdVM = resetPwdVM2;
                function1 = new Function1<ResetPwdState, ResetPwdState>() { // from class: com.soft.blued.ui.setting.vm.ResetPwdVM$getPhone$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final ResetPwdState invoke(ResetPwdState resetPwdState) {
                        Intrinsics.e(resetPwdState, "$this$setState");
                        return ResetPwdState.copy$default(resetPwdState, null, (ResetPwdModel) AppInfo.f().fromJson(a5, (Class<Object>) ResetPwdModel.class), null, null, 13, null);
                    }
                };
                BluedStructureExtKt.a(resetPwdVM, function1);
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
                final String a6 = AesCrypto2.a(((ResetPwdModel) b.get(0)).get_());
                resetPwdVM = resetPwdVM2;
                function1 = new Function1<ResetPwdState, ResetPwdState>() { // from class: com.soft.blued.ui.setting.vm.ResetPwdVM$getPhone$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final ResetPwdState invoke(ResetPwdState resetPwdState) {
                        Intrinsics.e(resetPwdState, "$this$setState");
                        return ResetPwdState.copy$default(resetPwdState, null, (ResetPwdModel) AppInfo.f().fromJson(a6, (Class<Object>) ResetPwdModel.class), null, null, 13, null);
                    }
                };
                BluedStructureExtKt.a(resetPwdVM, function1);
            }
            ApiState apiState2 = Succeed.a;
        }
        return Unit.a;
    }
}
