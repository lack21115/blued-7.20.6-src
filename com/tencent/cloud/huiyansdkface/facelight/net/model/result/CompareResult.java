package com.tencent.cloud.huiyansdkface.facelight.net.model.result;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/result/CompareResult.class */
public class CompareResult implements Serializable {
    public String code;
    public String isRecorded;
    public String liveRate;
    public String msg;
    public String retry;
    public RiskInfo riskInfo;
    public String sign;
    public String similarity;

    public String toString() {
        return "CompareResult{code='" + this.code + "', msg='" + this.msg + "', retry='" + this.retry + "', liveRate='" + this.liveRate + "', similarity='" + this.similarity + "', isRecorded=" + this.isRecorded + ", riskInfo=" + this.riskInfo + '}';
    }
}
