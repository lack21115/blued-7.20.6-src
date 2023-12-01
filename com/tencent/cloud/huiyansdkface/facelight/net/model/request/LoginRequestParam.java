package com.tencent.cloud.huiyansdkface.facelight.net.model.request;

import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/request/LoginRequestParam.class */
public class LoginRequestParam {
    public String version;
    public String deviceInfo = Param.getDeviceInfo();
    public String orderNo = Param.getOrderNo();
    public String faceId = Param.getFaceId();
    public String compareType = Param.getCompareMode();
    public SelectData liveSelectData = new SelectData(35.0f);
}
