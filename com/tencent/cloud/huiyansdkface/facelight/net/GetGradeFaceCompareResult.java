package com.tencent.cloud.huiyansdkface.facelight.net;

import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WeOkHttpProvider;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.CompareRequestParam;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.wehttp2.BodyReq;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.Serializable;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/GetGradeFaceCompareResult.class */
public class GetGradeFaceCompareResult {
    private static final String TAG = GetGradeFaceCompareResult.class.getName();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/GetGradeFaceCompareResult$EnRequestParam.class */
    public static class EnRequestParam {
        public String encryptBody;
        public String encryptKey;
        public String encryptedAESKey;
        public String requestBody;
        public String csrfToken = Param.getCsrfToken();
        public String orderNo = Param.getOrderNo();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/GetGradeFaceCompareResult$GetResultReflectModeResponse.class */
    public static class GetResultReflectModeResponse implements Serializable {
        public String code;
        public String debugMsg;
        public String enMsg;
        public String encryptBody;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, String str, String str2, boolean z, byte[] bArr, byte[] bArr2, String str3, String str4, String str5, FlashReq flashReq, int i, WeReq.Callback<GetResultReflectModeResponse> callback) {
        int i2;
        String str6;
        String str7;
        String str8;
        Param.appendRequestRetryInfo(i);
        BodyReq formData = weOkHttp.post(WeOkHttpProvider.getPathEnv() + WeOkHttpProvider.getComparePath(z) + "?Tag_orderNo=" + Param.getOrderNo() + "&app_id=" + Param.getAppId() + "&version=" + Param.getVersion(z) + "&retry=" + i).callTimeoutInMillis(d.z().e().af()).formData();
        CompareRequestParam compareRequestParam = new CompareRequestParam();
        compareRequestParam.activeType = str4;
        compareRequestParam.luxJudge = str5;
        compareRequestParam.flashReqDTO = flashReq;
        compareRequestParam.videoMd5 = str3;
        if (bArr == null || bArr.length == 0) {
            WLogger.d(TAG, "null ytVideo");
            i2 = 0;
        } else {
            WLogger.d(TAG, "has ytVideo");
            i2 = bArr.length;
            formData.addPart("videoFile", "videoFile", bArr, (MediaType) null);
        }
        if (bArr2 == null || bArr2.length == 0) {
            str6 = TAG;
            str7 = "null wbVideo";
        } else {
            compareRequestParam.rotate = Param.getRolateInfo();
            i2 += bArr2.length;
            formData.addPart("wbVideo", "wbVideo", bArr2, (MediaType) null);
            str6 = TAG;
            str7 = "has wbVideo:" + compareRequestParam.rotate;
        }
        WLogger.d(str6, str7);
        WLogger.d(TAG, "param=" + compareRequestParam.toString());
        try {
            str8 = WbCloudNetSecurityManger.base64Encry(z, new WeJson().toJson(compareRequestParam), str);
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w(TAG, "encry request failed:" + e.toString());
            Properties properties = new Properties();
            properties.setProperty("isGm", String.valueOf(z));
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry GetFaceResult failed!" + e.toString(), properties);
            str8 = null;
        }
        EnRequestParam enRequestParam = new EnRequestParam();
        if (z) {
            enRequestParam.encryptKey = str2;
            enRequestParam.encryptBody = str8;
        } else {
            enRequestParam.encryptedAESKey = str2;
            enRequestParam.requestBody = str8;
        }
        int length = enRequestParam.toString().length();
        KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_compare_size", "" + (i2 + length), null);
        formData.body(enRequestParam).execute(callback);
    }
}
