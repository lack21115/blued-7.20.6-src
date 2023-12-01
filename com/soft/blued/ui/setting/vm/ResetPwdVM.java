package com.soft.blued.ui.setting.vm;

import android.os.CountDownTimer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.soft.blued.ui.setting.state.ResetPwdState;
import com.soft.blued.ui.setting.state.ResetPwdUiAction;
import com.soft.blued.utils.DeviceUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/vm/ResetPwdVM.class */
public final class ResetPwdVM extends MVIBaseViewModel<ResetPwdState, ResetPwdUiAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f19984a = LazyKt.a(new Function0<CountDownTimer>() { // from class: com.soft.blued.ui.setting.vm.ResetPwdVM$timer$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: a */
        public final CountDownTimer invoke() {
            CountDownTimer c2;
            c2 = ResetPwdVM.this.c();
            return c2;
        }
    });

    private final CountDownTimer a() {
        return (CountDownTimer) this.f19984a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> a(Map<String, String> map) {
        return MapsKt.a(TuplesKt.a("_", AesCrypto2.b(AppInfo.f().toJson(map))));
    }

    private final void a(ResetPwdUiAction.GetCode getCode) {
        Pair a2 = TuplesKt.a("stage", "send");
        String b = getCode.b();
        String str = b;
        if (b == null) {
            str = "";
        }
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new ResetPwdVM$getCode$1(this, MapsKt.a(new Pair[]{a2, TuplesKt.a("token", str), TuplesKt.a("channel", getCode.a()), TuplesKt.a("uid", UserInfo.getInstance().getLoginUserInfo().uid)}), null), 3, (Object) null);
    }

    private final void a(ResetPwdUiAction.ModifyPwd modifyPwd) {
        Pair a2 = TuplesKt.a("stage", "verify");
        String a3 = modifyPwd.a();
        String str = a3;
        if (a3 == null) {
            str = "";
        }
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new ResetPwdVM$modifyPwd$1(this, MapsKt.a(new Pair[]{a2, TuplesKt.a("token", str), TuplesKt.a("passwd", BluedHttpTools.b(modifyPwd.b())), TuplesKt.a("verify_code", modifyPwd.c()), TuplesKt.a("uid", UserInfo.getInstance().getLoginUserInfo().uid)}), null), 3, (Object) null);
    }

    private final void b() {
        BuildersKt.a(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new ResetPwdVM$getPhone$1(this, MapsKt.a(new Pair[]{TuplesKt.a("stage", MonitorConstants.CONNECT_TYPE_GET), TuplesKt.a(UGCDataReportDef.DR_KEY_DEV_ID, DeviceUtils.g()), TuplesKt.a("smid", BluedDeviceIdentity.a().f()), TuplesKt.a("dev_dna", BluedDeviceIdentity.a().d()), TuplesKt.a("dev_dna_label", BluedDeviceIdentity.a().e()), TuplesKt.a("uid", UserInfo.getInstance().getLoginUserInfo().uid)}), null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CountDownTimer c() {
        return new CountDownTimer(60000L) { // from class: com.soft.blued.ui.setting.vm.ResetPwdVM$createTimer$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                BluedStructureExtKt.a(ResetPwdVM.this, new Function1<ResetPwdState, ResetPwdState>() { // from class: com.soft.blued.ui.setting.vm.ResetPwdVM$createTimer$1$onFinish$1
                    /* renamed from: a */
                    public final ResetPwdState invoke(ResetPwdState resetPwdState) {
                        Intrinsics.e(resetPwdState, "$this$setState");
                        return ResetPwdState.copy$default(resetPwdState, null, null, true, null, 11, null);
                    }
                });
            }

            @Override // android.os.CountDownTimer
            public void onTick(final long j) {
                BluedStructureExtKt.a(ResetPwdVM.this, new Function1<ResetPwdState, ResetPwdState>() { // from class: com.soft.blued.ui.setting.vm.ResetPwdVM$createTimer$1$onTick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* renamed from: a */
                    public final ResetPwdState invoke(ResetPwdState resetPwdState) {
                        Intrinsics.e(resetPwdState, "$this$setState");
                        return ResetPwdState.copy$default(resetPwdState, Integer.valueOf((int) (j / 1000)), null, null, null, 14, null);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        BluedStructureExtKt.a(this, new Function1<ResetPwdState, ResetPwdState>() { // from class: com.soft.blued.ui.setting.vm.ResetPwdVM$startCountdown$1
            /* renamed from: a */
            public final ResetPwdState invoke(ResetPwdState resetPwdState) {
                Intrinsics.e(resetPwdState, "$this$setState");
                return ResetPwdState.copy$default(resetPwdState, null, null, false, null, 11, null);
            }
        });
        a().start();
    }

    /* renamed from: a */
    public void dispatchAction(ResetPwdUiAction resetPwdUiAction) {
        Intrinsics.e(resetPwdUiAction, "action");
        if (resetPwdUiAction instanceof ResetPwdUiAction.GetCode) {
            a((ResetPwdUiAction.GetCode) resetPwdUiAction);
        } else if (resetPwdUiAction instanceof ResetPwdUiAction.GetPhone) {
            b();
        } else if (resetPwdUiAction instanceof ResetPwdUiAction.ModifyPwd) {
            a((ResetPwdUiAction.ModifyPwd) resetPwdUiAction);
        }
    }

    public void onCleared() {
        a().cancel();
    }
}
