package com.tencent.cloud.huiyansdkface.analytics;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/EventSender.class */
public class EventSender {
    private static final String TAG = "EventSender";

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/EventSender$RequestFailParam.class */
    public static class RequestFailParam {
        public String account;
        public String appVersion;
        public long createTime;
        public String deviceId;
        public String deviceInfo;
        public String errorCode;
        public String errorMsg;
        public String openId;
        public String subAppId;
        public String waVersion;
        public String appId = "M188078137";
        public String type = "1";
        public String metricsOs = "android";
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/EventSender$sendEventResponse.class */
    public static class sendEventResponse implements Serializable {
        public String code;
        public String msg;
    }

    public static void requestExec(WeOkHttp weOkHttp, WBSAParam wBSAParam, String str, List<WBSAEvent> list, WeReq.Callback<sendEventResponse> callback) {
        wBSAParam.batch = list;
        weOkHttp.post(str).param("app_id", wBSAParam.app_id).param("sub_app_id", wBSAParam.sub_app_id).param("wa_version", wBSAParam.wa_version).param("metrics_os", wBSAParam.metrics_os).bodyJson(wBSAParam).execute(callback);
    }

    public static void requestFailExec(WeOkHttp weOkHttp, RequestFailParam requestFailParam, String str, WeReq.Callback<sendEventResponse> callback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        weOkHttp.post(str).bodyJson(requestFailParam).execute(callback);
    }
}
