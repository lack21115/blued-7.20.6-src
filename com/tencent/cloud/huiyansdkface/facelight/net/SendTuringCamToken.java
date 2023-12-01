package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.CamTokenRequestParam;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/SendTuringCamToken.class */
public class SendTuringCamToken {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/SendTuringCamToken$EnRequestParam.class */
    public static class EnRequestParam {
        public String encryptBody;
        public String encryptKey;
        public String encryptedAESKey;
        public String requestBody;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/SendTuringCamToken$TuringCamTokenResponse.class */
    public static class TuringCamTokenResponse {
        public String code;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, String str, String str2, boolean z, WeReq.Callback<TuringCamTokenResponse> callback) {
        String str3;
        String str4 = WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getTuringCamPath(z) + "?app_id=" + Param.getAppId() + "&version=" + Param.getVersion(z) + "&order_no=" + Param.getOrderNo();
        EnRequestParam enRequestParam = new EnRequestParam();
        CamTokenRequestParam camTokenRequestParam = new CamTokenRequestParam();
        camTokenRequestParam.turingVideoData = Param.getTuringVideoData();
        try {
            str3 = WbCloudNetSecurityManger.base64Encry(z, new WeJson().toJson(camTokenRequestParam), str);
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("TuringCamTokenRquest", "encry request failed:" + e.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z));
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_fail", "encry TuringCamTokenRquest failed!" + e.toString(), properties);
            str3 = null;
        }
        if (z) {
            enRequestParam.encryptKey = str2;
            enRequestParam.encryptBody = str3;
        } else {
            enRequestParam.encryptedAESKey = str2;
            enRequestParam.requestBody = str3;
        }
        weOkHttp.post(str4).bodyJson(enRequestParam).execute(callback);
    }
}
