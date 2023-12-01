package com.tencent.cloud.huiyansdkface.facelight.net.model.result;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/result/RiskInfo.class */
public class RiskInfo implements Serializable {
    public String deviceInfoLevel;
    public String deviceInfoTag;
    public String riskInfoLevel;
    public String riskInfoTag;

    public String toString() {
        return "RiskInfo{deviceInfoLevel='" + this.deviceInfoLevel + "', deviceInfoTag='" + this.deviceInfoTag + "', riskInfoLevel='" + this.riskInfoLevel + "', riskInfoTag='" + this.riskInfoTag + "'}";
    }
}
