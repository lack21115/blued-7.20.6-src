package com.tencent.cloud.huiyansdkface.facelight.process.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.c.e.b;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.model.FaceWillResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.record.WeMediaManager;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/process/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private d f35621a;
    private FaceVerifyStatus b;

    public a(d dVar, FaceVerifyStatus faceVerifyStatus) {
        this.f35621a = dVar;
        this.b = faceVerifyStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        WLogger.i("CompareService", "deleteWillVideos");
        b.a(str);
        b.a(str2);
    }

    private void b(boolean z, String str, byte[] bArr, ReflectColorData reflectColorData, YTImageInfo yTImageInfo, YTImageInfo yTImageInfo2, YTImageInfo yTImageInfo3, String str2, String str3, String str4, String str5, String str6, ProcessCallback<FaceWillResult> processCallback) {
        String str7;
        String str8;
        if (TextUtils.isEmpty(str6)) {
            str7 = "null scrnshotImg";
        } else {
            str7 = "" + str6.length();
        }
        WLogger.d("CompareService", "prepareAndStartNetworkUpload:" + str7);
        com.tencent.cloud.huiyansdkface.facelight.a.b.a x = this.f35621a.x();
        String R = x.R();
        String t = this.f35621a.e().t();
        SelectData selectData = new SelectData(Float.valueOf(str).floatValue());
        WLogger.d("CompareService", "selectData=" + selectData.toString());
        byte[] videoByte = WeMediaManager.getInstance().getVideoByte();
        byte[] bArr2 = new byte[0];
        byte[] bArr3 = bArr2;
        if (bArr != null) {
            bArr3 = bArr2;
            if (bArr.length != 0) {
                bArr3 = b.b(bArr);
                StringBuilder sb = new StringBuilder();
                sb.append("ytProguardByte=");
                sb.append(bArr3 == null ? 0 : bArr3.length);
                WLogger.d("CompareService", sb.toString());
            }
        }
        byte[] bArr4 = new byte[0];
        byte[] bArr5 = bArr4;
        if (!z) {
            bArr5 = bArr4;
            if (videoByte != null) {
                bArr5 = b.b(videoByte);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("wbProguardByte=");
                sb2.append(bArr5 == null ? 0 : bArr5.length);
                WLogger.d("CompareService", sb2.toString());
            }
        }
        try {
            str8 = b.a(bArr3, bArr5, d.z().x().W());
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("CompareService", "generateFileMd5 failed:" + e.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_generate_fileMd5_fail", "GetFaceResult generateFileMd5 failed!" + e.toString(), null);
            str8 = null;
        }
        FlashReq flashReq = new FlashReq();
        flashReq.colorData = x.M();
        flashReq.liveSelectData = selectData;
        flashReq.reflectData = reflectColorData;
        flashReq.liveImage = yTImageInfo;
        flashReq.eyeImage = yTImageInfo2;
        flashReq.mouthImage = yTImageInfo3;
        WbFaceModeProviders.faceMode().getFaceResult(this.f35621a.e().ak(), bArr3, bArr5, str8, R, t, flashReq, str2, str3, str4, str5, str6, processCallback);
    }

    public void a(Context context, final boolean z, final File file, final ProcessCallback processCallback) {
        if (this.b.d() == 9) {
            WLogger.d("CompareService", "On finish Step,No more compared!");
            return;
        }
        byte[] b = b.b(b.a(file));
        String str = null;
        try {
            str = b.a(b, null, d.z().x().W());
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("CompareService", "uploadWillVideo generateFileMd5 failed:" + e.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_generate_fileMd5_fail", "uploadWillVideo generateFileMd5 failed!" + e.toString(), null);
        }
        final String a2 = b.a(context, b);
        WLogger.d("CompareService", "videoProguardPath =" + a2);
        WbFaceModeProviders.faceMode().uploadFaceWillVideo(this.f35621a.e().aj(), str, a2, new ProcessCallback() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.a.a.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                if (!z) {
                    a.this.a(file.getAbsolutePath(), a2);
                }
                processCallback.onFailed(wbFaceInnerError);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onSuccess(Object obj) {
                if (!z) {
                    a.this.a(file.getAbsolutePath(), a2);
                }
                processCallback.onSuccess(null);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }

    public void a(boolean z, String str, byte[] bArr, ReflectColorData reflectColorData, YTImageInfo yTImageInfo, YTImageInfo yTImageInfo2, YTImageInfo yTImageInfo3, String str2, String str3, String str4, String str5, String str6, ProcessCallback<FaceWillResult> processCallback) {
        if (this.b.d() == 9) {
            WLogger.d("CompareService", "On finish Step,No more compared!");
        } else {
            b(z, str, bArr, reflectColorData, yTImageInfo, yTImageInfo2, yTImageInfo3, str2, str3, str4, str5, str6, processCallback);
        }
    }
}
