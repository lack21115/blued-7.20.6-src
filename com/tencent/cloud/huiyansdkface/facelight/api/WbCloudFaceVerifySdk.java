package com.tencent.cloud.huiyansdkface.facelight.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbFaceVerifyInitCusSdkCallback;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import java.io.Serializable;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/WbCloudFaceVerifySdk.class */
public class WbCloudFaceVerifySdk {

    /* renamed from: a  reason: collision with root package name */
    private static volatile WbCloudFaceVerifySdk f21831a;
    private d b = d.z();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/WbCloudFaceVerifySdk$InputData.class */
    public static class InputData implements Serializable {
        public final String appId;
        public String faceId;
        public final String licence;
        public String nonce;
        public final String orderNo;
        public String sign;
        public String userId;
        public FaceVerifyStatus.Mode verifyMode;
        public String version;

        public InputData(String str, String str2, String str3) {
            this.faceId = null;
            this.orderNo = str;
            this.appId = str2;
            this.licence = str3;
        }

        public InputData(String str, String str2, String str3, String str4, String str5, String str6, FaceVerifyStatus.Mode mode, String str7) {
            this.faceId = null;
            this.orderNo = str;
            this.appId = str2;
            this.version = str3;
            this.nonce = str4;
            this.userId = str5;
            this.sign = str6;
            this.verifyMode = mode;
            this.licence = str7;
        }

        public InputData(String str, String str2, String str3, String str4, String str5, String str6, String str7, FaceVerifyStatus.Mode mode, String str8) {
            this.faceId = null;
            this.faceId = str;
            this.orderNo = str2;
            this.appId = str3;
            this.version = str4;
            this.nonce = str5;
            this.userId = str6;
            this.sign = str7;
            this.verifyMode = mode;
            this.licence = str8;
        }

        public String toString() {
            return "InputData{faceId='" + this.faceId + "', orderNo='" + this.orderNo + "', appId='" + this.appId + "', version='" + this.version + "', nonce='" + this.nonce + "', userId='" + this.userId + "', sign='" + this.sign + "', verifyMode=" + this.verifyMode + ", licence='" + this.licence + "'}";
        }
    }

    public static WbCloudFaceVerifySdk getInstance() {
        if (f21831a == null) {
            synchronized (WbCloudFaceVerifySdk.class) {
                try {
                    if (f21831a == null) {
                        f21831a = new WbCloudFaceVerifySdk();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21831a;
    }

    public void initAdvSdk(Context context, Bundle bundle, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        this.b.b(context, bundle, wbCloudFaceVerifyLoginListener);
    }

    public void initCusSdk(Context context, Bundle bundle, WbFaceVerifyInitCusSdkCallback wbFaceVerifyInitCusSdkCallback) {
        this.b.a(context, bundle, wbFaceVerifyInitCusSdkCallback);
    }

    public void initSdk(Context context, Bundle bundle, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        this.b.a(context, bundle, wbCloudFaceVerifyLoginListener);
    }

    public void initWillSdk(Context context, Bundle bundle, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        this.b.c(context, bundle, wbCloudFaceVerifyLoginListener);
    }

    public void release() {
        this.b.A();
    }

    public void startWbCusFaceVerifySdk(Context context, Map<String, Object> map, WbCloudFaceVerifyResultListener wbCloudFaceVerifyResultListener) {
        this.b.a(context, map, wbCloudFaceVerifyResultListener);
    }

    public void startWbFaceVerifySdk(Context context, WbCloudFaceVerifyResultListener wbCloudFaceVerifyResultListener) {
        this.b.a(context, wbCloudFaceVerifyResultListener);
    }
}
