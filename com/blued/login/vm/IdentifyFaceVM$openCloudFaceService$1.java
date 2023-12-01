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
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/IdentifyFaceVM$openCloudFaceService$1.class */
public final class IdentifyFaceVM$openCloudFaceService$1 implements WbCloudFaceVerifyLoginListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IdentifyFaceVM f20612a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdentifyFaceVM$openCloudFaceService$1(IdentifyFaceVM identifyFaceVM) {
        this.f20612a = identifyFaceVM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IdentifyFaceVM this$0, WbFaceVerifyResult wbFaceVerifyResult) {
        String tag;
        String tag2;
        String tag3;
        String tag4;
        String tag5;
        Intrinsics.e(this$0, "this$0");
        this$0.f20611a = false;
        if (wbFaceVerifyResult == null) {
            tag = this$0.getTAG();
            Logger.e(tag, "sdk返回error为空！");
        } else if (wbFaceVerifyResult.isSuccess()) {
            tag5 = this$0.getTAG();
            Logger.c(tag5, "刷脸成功! Sign=" + ((Object) wbFaceVerifyResult.getSign()) + "; liveRate=" + ((Object) wbFaceVerifyResult.getLiveRate()) + "; similarity=" + ((Object) wbFaceVerifyResult.getSimilarity()) + "userImageString=" + ((Object) wbFaceVerifyResult.getUserImageString()));
            this$0.a();
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                String string = activity.getString(R.string.login_face_identify_succeed);
                Intrinsics.c(string, "it.getString(R.string.login_face_identify_succeed)");
                BluedStructureExtKt.a(this$0, new MviEvent.ToastEvent(string));
            }
        } else {
            WbFaceError error = wbFaceVerifyResult.getError();
            if (error != null) {
                tag3 = this$0.getTAG();
                Logger.c(tag3, "刷脸失败！domain=" + ((Object) error.getDomain()) + " ;code= " + ((Object) error.getCode()) + " ;desc=" + ((Object) error.getDesc()) + ";reason=" + ((Object) error.getReason()));
                if (Intrinsics.a((Object) error.getDomain(), (Object) WbFaceError.WBFaceErrorDomainCompareServer)) {
                    tag4 = this$0.getTAG();
                    Logger.c(tag4, "对比失败，liveRate=" + ((Object) wbFaceVerifyResult.getLiveRate()) + "; similarity=" + ((Object) wbFaceVerifyResult.getSimilarity()));
                }
                String desc = error.getDesc();
                Intrinsics.c(desc, "error.desc");
                BluedStructureExtKt.a(this$0, new MviEvent.ToastEvent(desc));
            } else {
                tag2 = this$0.getTAG();
                Logger.e(tag2, "sdk返回error为空！");
            }
        }
        WbCloudFaceVerifySdk.getInstance().release();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener
    public void onLoginFailed(WbFaceError wbFaceError) {
        String tag;
        String tag2;
        String tag3;
        tag = this.f20612a.getTAG();
        Logger.e(tag, "onLoginFailed!");
        this.f20612a.f20611a = false;
        BluedStructureExtKt.a(this.f20612a, new MviEvent.LoadFinished(false, false, 3, null));
        if (wbFaceError == null) {
            tag2 = this.f20612a.getTAG();
            Logger.e(tag2, "sdk返回error为空！");
            return;
        }
        tag3 = this.f20612a.getTAG();
        Logger.e(tag3, "登录失败！domain=" + ((Object) wbFaceError.getDomain()) + " ;code= " + ((Object) wbFaceError.getCode()) + " ;desc=" + ((Object) wbFaceError.getDesc()) + ";reason=" + ((Object) wbFaceError.getReason()));
        if (Intrinsics.a((Object) wbFaceError.getDomain(), (Object) WbFaceError.WBFaceErrorDomainParams)) {
            BluedStructureExtKt.a(this.f20612a, new MviEvent.ToastEvent(Intrinsics.a("传入参数有误！", (Object) wbFaceError.getDesc())));
        } else {
            BluedStructureExtKt.a(this.f20612a, new MviEvent.ToastEvent(Intrinsics.a("登录刷脸sdk失败！", (Object) wbFaceError.getDesc())));
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener
    public void onLoginSuccess() {
        BluedStructureExtKt.a(this.f20612a, new MviEvent.LoadFinished(false, false, 3, null));
        final IdentifyFaceVM identifyFaceVM = this.f20612a;
        WbCloudFaceVerifySdk.getInstance().startWbFaceVerifySdk(this.f20612a.getActivity(), new WbCloudFaceVerifyResultListener() { // from class: com.blued.login.vm.-$$Lambda$IdentifyFaceVM$openCloudFaceService$1$mIyfAcE1a3JIwE9aayTUQ5LAq58
            @Override // com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener
            public final void onFinish(WbFaceVerifyResult wbFaceVerifyResult) {
                IdentifyFaceVM$openCloudFaceService$1.a(IdentifyFaceVM.this, wbFaceVerifyResult);
            }
        });
    }
}
