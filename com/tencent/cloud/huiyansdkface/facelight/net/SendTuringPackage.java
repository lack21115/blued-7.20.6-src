package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.TuringRequestParam;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.Serializable;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/SendTuringPackage.class */
public class SendTuringPackage {
    private static final String TAG = SendTuringPackage.class.getName();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/SendTuringPackage$EnRequestParam.class */
    public static class EnRequestParam {
        public String encryptBody;
        public String encryptKey;
        public String encryptedAESKey;
        public String requestBody;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/SendTuringPackage$GetFaceCompareTypeResponse.class */
    public static class GetFaceCompareTypeResponse implements Serializable {
        public String code;
        public String enMsg;
        public String encryptBody;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, String str, String str2, boolean z, WeReq.Callback<GetFaceCompareTypeResponse> callback) {
        String str3;
        String str4 = WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getTuringPath(z) + "?app_id=" + Param.getAppId() + "&version=" + Param.getVersion(z) + "&order_no=" + Param.getOrderNo();
        TuringRequestParam turingRequestParam = new TuringRequestParam();
        turingRequestParam.turingPackage = Param.getTuringPackage();
        turingRequestParam.deviceModel = Param.getDeviceModel();
        try {
            str3 = WbCloudNetSecurityManger.base64Encry(z, new WeJson().toJson(turingRequestParam), str);
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w(TAG, "encry request failed:" + e.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z));
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry turing failed!" + e.toString(), properties);
            str3 = null;
        }
        EnRequestParam enRequestParam = new EnRequestParam();
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
