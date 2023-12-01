package com.tencent.cloud.huiyansdkface.facelight.net.model.request;

import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/request/GetActRequestParam.class */
public class GetActRequestParam {
    public SelectData liveSelectData;
    public String version;
    public String deviceInfo = Param.getDeviceInfo();
    public String orderNo = Param.getOrderNo();
    public String faceId = Param.getFaceId();
    public String compareMode = Param.getGradeCompareType();

    public String toString() {
        return "GetActRequestParam{deviceInfo='" + this.deviceInfo + "', version='" + this.version + "', orderNo='" + this.orderNo + "', faceId='" + this.faceId + "', liveSelectData=" + this.liveSelectData + ", compareMode='" + this.compareMode + "'}";
    }
}
