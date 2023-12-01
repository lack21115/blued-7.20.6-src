package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.LoginRequestParam;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.Serializable;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/LoginRequest.class */
public class LoginRequest {
    private static final String TAG = LoginRequest.class.getName();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/LoginRequest$EnRequestParam.class */
    public static class EnRequestParam {
        public String encryptBody;
        public String encryptKey;
        public String encryptedAESKey;
        public String requestBody;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/LoginRequest$LoginResponse.class */
    public static class LoginResponse implements Serializable {
        public String code;
        public String debugMsg;
        public String enMsg;
        public String encryptBody;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, String str, long j, String str2, String str3, boolean z, WeReq.Callback<LoginResponse> callback) {
        String str4;
        String str5 = TAG;
        WLogger.d(str5, "connectTimeout:" + j + ",isGm:" + z);
        LoginRequestParam loginRequestParam = new LoginRequestParam();
        loginRequestParam.version = Param.getVersion(z);
        try {
            str4 = WbCloudNetSecurityManger.base64Encry(z, new WeJson().toJson(loginRequestParam), str2);
        } catch (Exception e) {
            e.printStackTrace();
            String str6 = TAG;
            WLogger.w(str6, "encry loginRequest failed!" + e.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z));
            KycWaSDK kycWaSDK = KycWaSDK.getInstance();
            kycWaSDK.trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry loginRequest failed!" + e.toString(), properties);
            str4 = null;
        }
        EnRequestParam enRequestParam = new EnRequestParam();
        if (z) {
            enRequestParam.encryptKey = str3;
            enRequestParam.encryptBody = str4;
        } else {
            enRequestParam.encryptedAESKey = str3;
            enRequestParam.requestBody = str4;
        }
        weOkHttp.post(str + "&Tag_orderNo=" + Param.getOrderNo()).connectTimeoutInMillis(j).bodyJson(enRequestParam).execute(callback);
    }
}
