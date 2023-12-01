package com.blued.login.vm;

import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.login.R;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceVerifySdk;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/IdentifyFaceVM$openCloudFaceService$1.class */
public final class IdentifyFaceVM$openCloudFaceService$1 implements WbCloudFaceVerifyLoginListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IdentifyFaceVM f7006a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdentifyFaceVM$openCloudFaceService$1(IdentifyFaceVM identifyFaceVM) {
        this.f7006a = identifyFaceVM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IdentifyFaceVM identifyFaceVM, WbFaceVerifyResult wbFaceVerifyResult) {
        String tag;
        String tag2;
        String tag3;
        String tag4;
        String tag5;
        Intrinsics.e(identifyFaceVM, "this$0");
        identifyFaceVM.f7005a = false;
        if (wbFaceVerifyResult == null) {
            tag = identifyFaceVM.getTAG();
            Logger.e(tag, new Object[]{"sdk返回error为空！"});
        } else if (wbFaceVerifyResult.isSuccess()) {
            tag5 = identifyFaceVM.getTAG();
            Logger.c(tag5, new Object[]{"刷脸成功! Sign=" + ((Object) wbFaceVerifyResult.getSign()) + "; liveRate=" + ((Object) wbFaceVerifyResult.getLiveRate()) + "; similarity=" + ((Object) wbFaceVerifyResult.getSimilarity()) + "userImageString=" + ((Object) wbFaceVerifyResult.getUserImageString())});
            identifyFaceVM.a();
            FragmentActivity activity = identifyFaceVM.getActivity();
            if (activity != null) {
                String string = activity.getString(R.string.login_face_identify_succeed);
                Intrinsics.c(string, "it.getString(R.string.login_face_identify_succeed)");
                BluedStructureExtKt.a(identifyFaceVM, new MviEvent.ToastEvent(string));
            }
        } else {
            WbFaceError error = wbFaceVerifyResult.getError();
            if (error != null) {
                tag3 = identifyFaceVM.getTAG();
                Logger.c(tag3, new Object[]{"刷脸失败！domain=" + ((Object) error.getDomain()) + " ;code= " + ((Object) error.getCode()) + " ;desc=" + ((Object) error.getDesc()) + ";reason=" + ((Object) error.getReason())});
                if (Intrinsics.a(error.getDomain(), WbFaceError.WBFaceErrorDomainCompareServer)) {
                    tag4 = identifyFaceVM.getTAG();
                    Logger.c(tag4, new Object[]{"对比失败，liveRate=" + ((Object) wbFaceVerifyResult.getLiveRate()) + "; similarity=" + ((Object) wbFaceVerifyResult.getSimilarity())});
                }
                String desc = error.getDesc();
                Intrinsics.c(desc, "error.desc");
                BluedStructureExtKt.a(identifyFaceVM, new MviEvent.ToastEvent(desc));
            } else {
                tag2 = identifyFaceVM.getTAG();
                Logger.e(tag2, new Object[]{"sdk返回error为空！"});
            }
        }
        WbCloudFaceVerifySdk.getInstance().release();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener
    public void onLoginFailed(WbFaceError wbFaceError) {
        String tag;
        String tag2;
        String tag3;
        tag = this.f7006a.getTAG();
        Logger.e(tag, new Object[]{"onLoginFailed!"});
        this.f7006a.f7005a = false;
        BluedStructureExtKt.a(this.f7006a, new MviEvent.LoadFinished(false, false, 3, (DefaultConstructorMarker) null));
        if (wbFaceError == null) {
            tag2 = this.f7006a.getTAG();
            Logger.e(tag2, new Object[]{"sdk返回error为空！"});
            return;
        }
        tag3 = this.f7006a.getTAG();
        Logger.e(tag3, new Object[]{"登录失败！domain=" + ((Object) wbFaceError.getDomain()) + " ;code= " + ((Object) wbFaceError.getCode()) + " ;desc=" + ((Object) wbFaceError.getDesc()) + ";reason=" + ((Object) wbFaceError.getReason())});
        if (Intrinsics.a(wbFaceError.getDomain(), WbFaceError.WBFaceErrorDomainParams)) {
            BluedStructureExtKt.a(this.f7006a, new MviEvent.ToastEvent(Intrinsics.a("传入参数有误！", wbFaceError.getDesc())));
        } else {
            BluedStructureExtKt.a(this.f7006a, new MviEvent.ToastEvent(Intrinsics.a("登录刷脸sdk失败！", wbFaceError.getDesc())));
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener
    public void onLoginSuccess() {
        BluedStructureExtKt.a(this.f7006a, new MviEvent.LoadFinished(false, false, 3, (DefaultConstructorMarker) null));
        final IdentifyFaceVM identifyFaceVM = this.f7006a;
        WbCloudFaceVerifySdk.getInstance().startWbFaceVerifySdk(this.f7006a.getActivity(), new WbCloudFaceVerifyResultListener() { // from class: com.blued.login.vm.-$$Lambda$IdentifyFaceVM$openCloudFaceService$1$mIyfAcE1a3JIwE9aayTUQ5LAq58
            @Override // com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener
            public final void onFinish(WbFaceVerifyResult wbFaceVerifyResult) {
                IdentifyFaceVM$openCloudFaceService$1.a(IdentifyFaceVM.this, wbFaceVerifyResult);
            }
        });
    }
}
