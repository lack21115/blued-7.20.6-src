package com.soft.blued.ui.setting.vm;

import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.soft.blued.ui.setting.api.SettingApiService;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "ResetPwdVM.kt", c = {72}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.ResetPwdVM$getCode$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/ResetPwdVM$getCode$1.class */
public final class ResetPwdVM$getCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19988a;
    final /* synthetic */ ResetPwdVM b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Map<String, String> f19989c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPwdVM$getCode$1(ResetPwdVM resetPwdVM, Map<String, String> map, Continuation<? super ResetPwdVM$getCode$1> continuation) {
        super(2, continuation);
        this.b = resetPwdVM;
        this.f19989c = map;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResetPwdVM$getCode$1(this.b, this.f19989c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Map<String, String> a2;
        Object a3 = IntrinsicsKt.a();
        int i = this.f19988a;
        if (i == 0) {
            ResultKt.a(obj);
            SettingApiService settingApiService = (SettingApiService) BluedApiProxy.b().a(SettingApiService.class);
            a2 = this.b.a(this.f19989c);
            this.f19988a = 1;
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
        ResetPwdVM resetPwdVM = this.b;
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                Intrinsics.c(bluedEntityA.data, "data");
                bluedEntityA.hasMore();
            } else {
                CollectionsKt.b();
            }
            resetPwdVM.d();
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
