package com.tencent.cloud.huiyansdkface.facelight.c.b;

import android.app.Activity;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.c;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/b/f.class */
public class f implements c.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f35560a = f.class.getSimpleName();
    private com.tencent.cloud.huiyansdkface.facelight.process.d b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f35561c;
    private FaceVerifyStatus d;

    public f(com.tencent.cloud.huiyansdkface.facelight.process.d dVar, Activity activity, FaceVerifyStatus faceVerifyStatus) {
        this.b = dVar;
        this.f35561c = activity;
        this.d = faceVerifyStatus;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
    public void a() {
        KycWaSDK kycWaSDK;
        Activity activity;
        String str;
        WLogger.e(f35560a, "onHomePressed");
        if (this.b.b()) {
            WLogger.d(f35560a, "inUpload home presssed,dont quit.");
            return;
        }
        if (this.d.b() == 6) {
            kycWaSDK = KycWaSDK.getInstance();
            activity = this.f35561c;
            str = "uploadpage_exit_self";
        } else if (this.d.b() != 5) {
            kycWaSDK = KycWaSDK.getInstance();
            activity = this.f35561c;
            str = "facepage_exit_self";
        } else if (this.b.d()) {
            kycWaSDK = KycWaSDK.getInstance();
            activity = this.f35561c;
            str = "willpage_answer_exit_self";
        } else {
            kycWaSDK = KycWaSDK.getInstance();
            activity = this.f35561c;
            str = "willpage_exit_self";
        }
        kycWaSDK.trackCustomKVEvent(activity, str, "点击home键返回", null);
        this.d.b(9);
        this.b.e(true);
        if (this.b.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.b.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
            wbFaceError.setDesc("用户取消");
            wbFaceError.setReason("home键：用户验证中取消");
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.b.a(this.f35561c, WbFaceError.WBFaceErrorCodeUserCancle, properties);
            this.b.y().onFinish(wbFaceVerifyResult);
        }
        WLogger.d(f35560a, "finish activity");
        this.f35561c.finish();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
    public void b() {
        WLogger.d(f35560a, "onHomeLongPressed");
    }
}
