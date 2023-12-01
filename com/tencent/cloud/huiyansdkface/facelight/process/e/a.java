package com.tencent.cloud.huiyansdkface.facelight.process.e;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.net.model.WbFaceWillRes;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/e/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private FaceVerifyStatus f21949a;
    private d b;

    public a(d dVar, FaceVerifyStatus faceVerifyStatus) {
        this.f21949a = faceVerifyStatus;
        this.b = dVar;
    }

    public void a(boolean z, String str, final ProcessCallback<WbFaceWillRes> processCallback) {
        String str2;
        boolean z2;
        com.tencent.cloud.huiyansdkface.facelight.a.b.a x = this.b.x();
        String N = x.N();
        if (N.contains("2") || N.contains("3")) {
            if (x.l()) {
                str2 = "simple mode,need flash Resource!";
            } else if (z) {
                str2 = "try again,need flash Resource!";
            } else if ((N.contains("2") && TextUtils.isEmpty(x.R())) || (N.contains("3") && TextUtils.isEmpty(x.M()))) {
                str2 = "Oops! Login didnt get flash Resource!Try again!";
            }
            WLogger.d("ResourceFetcher", str2);
            z2 = true;
            if (!WbFaceModeProviders.isUseWillSdk() || z2) {
                this.f21949a.a(false);
                WbFaceModeProviders.faceMode().getFaceResource(z2, str, new ProcessCallback<WbFaceWillRes>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.e.a.1
                    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
                    /* renamed from: a */
                    public void onSuccess(WbFaceWillRes wbFaceWillRes) {
                        a.this.f21949a.a(true);
                        a.this.f21949a.l();
                        processCallback.onSuccess(wbFaceWillRes);
                    }

                    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
                    public void onFailed(WbFaceInnerError wbFaceInnerError) {
                        processCallback.onFailed(wbFaceInnerError);
                    }

                    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
                    public void onUiNetworkRetryTip() {
                    }
                });
            }
            WLogger.i("ResourceFetcher", "no need to get flash resource");
            processCallback.onSuccess(null);
            return;
        }
        z2 = false;
        if (WbFaceModeProviders.isUseWillSdk()) {
        }
        this.f21949a.a(false);
        WbFaceModeProviders.faceMode().getFaceResource(z2, str, new ProcessCallback<WbFaceWillRes>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.e.a.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            /* renamed from: a */
            public void onSuccess(WbFaceWillRes wbFaceWillRes) {
                a.this.f21949a.a(true);
                a.this.f21949a.l();
                processCallback.onSuccess(wbFaceWillRes);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                processCallback.onFailed(wbFaceInnerError);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }
}
