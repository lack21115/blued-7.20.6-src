package com.blued.android.module.common.face;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.module.common.face.TencentFaceVerify;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.track.trackUtils.EventTrackUtils;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceVerifySdk;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/face/TencentFaceVerify.class */
public final class TencentFaceVerify {
    public static final TencentFaceVerify a = new TencentFaceVerify();
    private static Dialog b;
    private static boolean c;
    private static OnGetFaceVerifyChannelFinish d;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/face/TencentFaceVerify$OnGetFaceVerifyChannelFinish.class */
    public interface OnGetFaceVerifyChannelFinish {
        void a();

        void b();
    }

    private TencentFaceVerify() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final Activity activity, final TencentFaceConfigModel tencentFaceConfigModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("inputData", (Serializable) new WbCloudFaceVerifySdk.InputData(tencentFaceConfigModel.getFace_id(), tencentFaceConfigModel.getOrder_no(), tencentFaceConfigModel.getApp_id(), tencentFaceConfigModel.getApi_version(), tencentFaceConfigModel.getNonce(), EncryptTool.b(UserInfo.getInstance().getLoginUserInfo().uid), tencentFaceConfigModel.getNonce_sign(), FaceVerifyStatus.Mode.GRADE, tencentFaceConfigModel.getLicense()));
        bundle.putString("WBFaceVerifyLanguage", e());
        bundle.putString("colorMode", BluedSkinUtils.c() ? "white" : "black");
        WbCloudFaceVerifySdk.getInstance().initSdk(activity, bundle, new WbCloudFaceVerifyLoginListener() { // from class: com.blued.android.module.common.face.TencentFaceVerify$initFaceVerifySdk$1
            public void onLoginFailed(WbFaceError wbFaceError) {
                Log.e("TencentFaceVerify", "sdk初始化失败！");
                TencentFaceVerify tencentFaceVerify = TencentFaceVerify.a;
                TencentFaceVerify.c = false;
                if (wbFaceError != null) {
                    Log.e("TencentFaceVerify", "登录失败！domain=" + ((Object) wbFaceError.getDomain()) + ", code=" + ((Object) wbFaceError.getCode()) + ", desc=" + ((Object) wbFaceError.getDesc()) + ", reason=" + ((Object) wbFaceError.getReason()));
                } else {
                    Log.e("TencentFaceVerify", "sdk返回error为空！");
                }
                TencentFaceVerify.a.c();
            }

            public void onLoginSuccess() {
                Log.e("TencentFaceVerify", Intrinsics.a("sdk初始化成功！", (Object) Thread.currentThread().getName()));
                TencentFaceVerify.a.b(activity, tencentFaceConfigModel);
            }
        });
    }

    private final void a(BluedUIHttpResponse<?> bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(Intrinsics.a(BluedHttpUrl.q(), (Object) "/passport/is_tencent"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static final void a(TencentFaceConfigModel tencentFaceConfigModel, WbFaceVerifyResult wbFaceVerifyResult) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private final void a(String str, String str2, String str3) {
        EventTrackUtils.a(PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(PersonalProfileProtos.Event.TC_AVATAR_AUTHENTICATE_FAIL).setLiveRate(EventTrackUtils.a(str)).setSimilarity(EventTrackUtils.a(str2)).setCode(EventTrackUtils.a(str3)).build());
    }

    private final void a(String str, String str2, String str3, int i, String str4, BluedUIHttpResponse<?> bluedUIHttpResponse) {
        String a2 = Intrinsics.a(BluedHttpUrl.q(), (Object) "/passport/tencent_success");
        Map<String, Object> params = BluedHttpTools.b();
        Intrinsics.c(params, "params");
        params.put("order_no", str);
        params.put("nonce", str2);
        params.put("nonce_sign", str3);
        params.put("status", Integer.valueOf(i));
        params.put("error_info", str4);
        HttpManager.b(a2, bluedUIHttpResponse, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(params)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        d();
        OnGetFaceVerifyChannelFinish onGetFaceVerifyChannelFinish = d;
        if (onGetFaceVerifyChannelFinish != null) {
            onGetFaceVerifyChannelFinish.b();
        }
        c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final Activity activity, final IRequestHost iRequestHost, OnGetFaceVerifyChannelFinish onGetFaceVerifyChannelFinish) {
        b(new BluedUIHttpResponse<BluedEntityA<TencentFaceConfigModel>>(activity) { // from class: com.blued.android.module.common.face.TencentFaceVerify$getTencentFaceVerifyArguments$1
            final /* synthetic */ Activity b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = activity;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<TencentFaceConfigModel> bluedEntityA) {
                TencentFaceConfigModel singleData;
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    TencentFaceVerify.a.c();
                } else {
                    TencentFaceVerify.a.a(this.b, singleData);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                TencentFaceVerify.a.c();
                return true;
            }
        }, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Activity activity, final TencentFaceConfigModel tencentFaceConfigModel) {
        WbCloudFaceVerifySdk.getInstance().startWbFaceVerifySdk(activity, new WbCloudFaceVerifyResultListener() { // from class: com.blued.android.module.common.face.-$$Lambda$TencentFaceVerify$Rn9g2LswwfhomBP6o5h3Xy-BUbg
            public final void onFinish(WbFaceVerifyResult wbFaceVerifyResult) {
                TencentFaceVerify.a(TencentFaceConfigModel.this, wbFaceVerifyResult);
            }
        });
    }

    private final void b(BluedUIHttpResponse<?> bluedUIHttpResponse, IRequestHost iRequestHost) {
        HttpManager.a(Intrinsics.a(BluedHttpUrl.q(), (Object) "/passport/tencent_face_config"), bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        d();
        OnGetFaceVerifyChannelFinish onGetFaceVerifyChannelFinish = d;
        if (onGetFaceVerifyChannelFinish != null) {
            onGetFaceVerifyChannelFinish.a();
        }
        c = false;
    }

    private final void d() {
        Dialog dialog = b;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        b = null;
    }

    private final String e() {
        String b2 = LocaleUtils.b();
        return Intrinsics.a((Object) b2, (Object) "zh-tw") ? "WBFaceVerifyLanguage_zh_hk" : Intrinsics.a((Object) b2, (Object) "en-us") ? "WBFaceVerifyLanguage_en" : "WBFaceVerifyLanguage_zh_cn";
    }

    public final void a(final Activity activity, final IRequestHost iRequestHost, OnGetFaceVerifyChannelFinish onGetFaceVerifyChannelFinish) {
        Intrinsics.e(activity, "activity");
        d();
        Dialog a2 = DialogUtils.a(activity);
        a2.show();
        b = a2;
        d = onGetFaceVerifyChannelFinish;
        c = true;
        a(new BluedUIHttpResponse<BluedEntityA<ChannelModel>>(activity) { // from class: com.blued.android.module.common.face.TencentFaceVerify$checkFaceVerifyChannel$2
            final /* synthetic */ Activity b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = activity;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ChannelModel> bluedEntityA) {
                ChannelModel singleData;
                TencentFaceVerify.OnGetFaceVerifyChannelFinish onGetFaceVerifyChannelFinish2;
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                Activity activity2 = this.b;
                IRequestHost iRequestHost2 = IRequestHost.this;
                if (singleData.is_tencent() != 1) {
                    TencentFaceVerify.a.c();
                    return;
                }
                TencentFaceVerify tencentFaceVerify = TencentFaceVerify.a;
                onGetFaceVerifyChannelFinish2 = TencentFaceVerify.d;
                tencentFaceVerify.b(activity2, iRequestHost2, onGetFaceVerifyChannelFinish2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                TencentFaceVerify.a.c();
                return true;
            }
        }, iRequestHost);
    }
}
