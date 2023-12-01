package com.tencent.cloud.huiyansdkface.facelight.net.model.request;

import com.tencent.cloud.huiyansdkface.facelight.c.d.d;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/request/TuringRequestParam.class */
public class TuringRequestParam {
    public String deviceModel;
    public String turingPackage;
    public String webankAppId = Param.getAppId();
    public String orderNo = Param.getOrderNo();
    public String userId = Param.getUserId();
    public String h5faceId = Param.getFaceId();
    public String compareType = Param.getCompareMode();
    public String turingSdkVersion = d.b();
    public String osType = "1";
}
