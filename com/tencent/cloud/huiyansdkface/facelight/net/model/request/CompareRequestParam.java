package com.tencent.cloud.huiyansdkface.facelight.net.model.request;

import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/request/CompareRequestParam.class */
public class CompareRequestParam {
    public String activeType;
    public FlashReq flashReqDTO;
    public String luxJudge;
    public String videoMd5;
    public String deviceInfo = Param.getDeviceInfo();
    public String modeType = Param.getGradeCompareType();
    public String faceId = Param.getFaceId();
    public String turingPackage = Param.getTuringPackage();
    public String turingVideoData = Param.getTuringVideoData();
    public String rotate = "0";
    public String transSwitch = "1";

    public String toString() {
        return "CompareRequestParam{deviceInfo='" + this.deviceInfo + "', rotate='" + this.rotate + "', transSwitch='" + this.transSwitch + "'}";
    }
}
