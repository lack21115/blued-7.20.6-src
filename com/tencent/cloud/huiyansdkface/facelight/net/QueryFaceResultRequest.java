package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.QueryRequestParam;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.Serializable;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/QueryFaceResultRequest.class */
public class QueryFaceResultRequest {
    private static final String TAG = QueryFaceResultRequest.class.getName();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/QueryFaceResultRequest$EnRequestParam.class */
    public static class EnRequestParam {
        public String encryptBody;
        public String encryptKey;
        public String encryptedAESKey;
        public String requestBody;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/QueryFaceResultRequest$QueryResponse.class */
    public static class QueryResponse implements Serializable {
        public String code;
        public String debugMsg;
        public String enMsg;
        public String encryptBody;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, int i, String str, String str2, String str3, boolean z, WeReq.Callback<QueryResponse> callback) {
        String str4 = WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getQueryPath(z) + "?app_id=" + Param.getAppId() + "&version=" + Param.getVersion(z) + "&order_no=" + Param.getOrderNo() + "&retry=" + i;
        QueryRequestParam queryRequestParam = new QueryRequestParam();
        queryRequestParam.faceOrLive = str;
        String str5 = null;
        try {
            str5 = WbCloudNetSecurityManger.base64Encry(z, new WeJson().toJson(queryRequestParam), str2);
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w(TAG, "encry queryRequest failed!" + e.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z));
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry queryRequest failed!" + e.toString(), properties);
        }
        EnRequestParam enRequestParam = new EnRequestParam();
        if (z) {
            enRequestParam.encryptKey = str3;
            enRequestParam.encryptBody = str5;
        } else {
            enRequestParam.encryptedAESKey = str3;
            enRequestParam.requestBody = str5;
        }
        weOkHttp.post(str4).callTimeoutInMillis(d.z().e().ag()).bodyJson(enRequestParam).execute(callback);
    }
}
