package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.GetActRequestParam;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.BaseCallback;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.Serializable;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/GetFaceActiveCompareType.class */
public class GetFaceActiveCompareType {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/GetFaceActiveCompareType$EnRequestParam.class */
    public static class EnRequestParam {
        public String encryptBody;
        public String encryptKey;
        public String encryptedAESKey;
        public String requestBody;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/GetFaceActiveCompareType$GetFaceCompareTypeResponse.class */
    public static class GetFaceCompareTypeResponse implements Serializable {
        public String code;
        public String debugMsg;
        public String enMsg;
        public String encryptBody;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, String str, String str2, boolean z, String str3, SelectData selectData, BaseCallback<GetFaceCompareTypeResponse> baseCallback) {
        String str4;
        String str5 = WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getResPath(z) + "?version=" + Param.getVersion(z) + "&app_id=" + Param.getAppId() + "&csrfToken=" + Param.getCsrfToken() + "&Tag_orderNo=" + Param.getOrderNo();
        GetActRequestParam getActRequestParam = new GetActRequestParam();
        getActRequestParam.version = Param.getVersion(z);
        getActRequestParam.compareMode = str3;
        getActRequestParam.liveSelectData = selectData;
        String json = new WeJson().toJson(getActRequestParam);
        WLogger.d("GetFaceActiveCompareType", "paramStr=" + json);
        try {
            str4 = WbCloudNetSecurityManger.base64Encry(z, json, str);
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("GetFaceActiveCompareType", "encry request failed:" + e.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z));
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry GetActType failed!" + e.toString(), properties);
            str4 = null;
        }
        EnRequestParam enRequestParam = new EnRequestParam();
        if (z) {
            enRequestParam.encryptKey = str2;
            enRequestParam.encryptBody = str4;
        } else {
            enRequestParam.encryptedAESKey = str2;
            enRequestParam.requestBody = str4;
        }
        weOkHttp.post(str5).bodyJson(enRequestParam).execute(baseCallback);
    }
}
