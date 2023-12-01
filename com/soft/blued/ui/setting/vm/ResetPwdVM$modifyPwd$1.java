package com.soft.blued.ui.setting.vm;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.api.ApiState;
import com.blued.android.module.common.api.BluedApiProxy;
import com.blued.android.module.common.api.Error;
import com.blued.android.module.common.api.Succeed;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.soft.blued.R;
import com.soft.blued.ui.setting.api.SettingApiService;
import com.soft.blued.ui.setting.state.ResetPwdState;
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
@DebugMetadata(b = "ResetPwdVM.kt", c = {54}, d = "invokeSuspend", e = "com.soft.blued.ui.setting.vm.ResetPwdVM$modifyPwd$1")
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/ResetPwdVM$modifyPwd$1.class */
public final class ResetPwdVM$modifyPwd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f19993a;
    final /* synthetic */ ResetPwdVM b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Map<String, String> f19994c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPwdVM$modifyPwd$1(ResetPwdVM resetPwdVM, Map<String, String> map, Continuation<? super ResetPwdVM$modifyPwd$1> continuation) {
        super(2, continuation);
        this.b = resetPwdVM;
        this.f19994c = map;
    }

    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.a);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResetPwdVM$modifyPwd$1(this.b, this.f19994c, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Map<String, String> a2;
        ResetPwdVM resetPwdVM;
        MviEvent.ToastEvent toastEvent;
        Object a3 = IntrinsicsKt.a();
        int i = this.f19993a;
        if (i == 0) {
            ResultKt.a(obj);
            SettingApiService settingApiService = (SettingApiService) BluedApiProxy.b().a(SettingApiService.class);
            a2 = this.b.a(this.f19994c);
            this.f19993a = 1;
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
        if (bluedEntityA.code == 200) {
            if (bluedEntityA.hasData()) {
                Intrinsics.c(bluedEntityA.data, "data");
                bluedEntityA.hasMore();
                resetPwdVM = resetPwdVM2;
                String string = AppInfo.d().getString(R.string.modify_success);
                Intrinsics.c(string, "getAppContext().getString(R.string.modify_success)");
                toastEvent = new MviEvent.ToastEvent(string);
            } else {
                CollectionsKt.b();
                resetPwdVM = resetPwdVM2;
                String string2 = AppInfo.d().getString(R.string.modify_success);
                Intrinsics.c(string2, "getAppContext().getString(R.string.modify_success)");
                toastEvent = new MviEvent.ToastEvent(string2);
            }
            BluedStructureExtKt.a(resetPwdVM, toastEvent);
            BluedStructureExtKt.a(resetPwdVM, new Function1<ResetPwdState, ResetPwdState>() { // from class: com.soft.blued.ui.setting.vm.ResetPwdVM$modifyPwd$1$1$1
                /* renamed from: a */
                public final ResetPwdState invoke(ResetPwdState resetPwdState) {
                    Intrinsics.e(resetPwdState, "$this$setState");
                    return ResetPwdState.copy$default(resetPwdState, null, null, null, true, 7, null);
                }
            });
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
