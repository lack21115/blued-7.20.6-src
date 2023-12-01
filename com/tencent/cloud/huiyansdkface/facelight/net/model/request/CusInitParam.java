package com.tencent.cloud.huiyansdkface.facelight.net.model.request;

import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/request/CusInitParam.class */
public class CusInitParam {
    public String deviceInfo = Param.getDeviceInfo();
    public String appId = Param.getAppId();
    public String orderNo = Param.getOrderNo();
    public SelectData liveSelectData = new SelectData(35.0f);
}
