package com.tencent.cloud.huiyansdkface.facelight.process.d;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceVerifySdk;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.c.c;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.LoginResult;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private d f35636a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35637c;

    public a(d dVar, c cVar) {
        this.f35636a = dVar;
        this.b = cVar;
    }

    public void a(final Context context, long j, final ProcessCallback<LoginResult> processCallback) {
        WbCloudFaceVerifySdk.InputData i = this.f35636a.x().i();
        WbFaceModeProviders.faceMode().login(i.nonce, i.sign, j, new ProcessCallback<LoginResult>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.d.a.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            /* renamed from: a */
            public void onSuccess(LoginResult loginResult) {
                processCallback.onSuccess(loginResult);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                if (!WbFaceError.WBFaceErrorDomainLoginNetwork.equals(wbFaceInnerError.domain) || a.this.f35637c) {
                    processCallback.onFailed(wbFaceInnerError);
                    return;
                }
                WLogger.d("LoginService", "first login network error,change url retry!");
                a.this.f35637c = true;
                KycWaSDK.getInstance().trackIMSWarnVEvent(context, "faceservice_login_retry_start", wbFaceInnerError.reason, null);
                a.this.b.b(a.this.f35636a.x().X(), a.this.f35636a.x().P(), true);
                a.this.a(context, 14000L, processCallback);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }
}
