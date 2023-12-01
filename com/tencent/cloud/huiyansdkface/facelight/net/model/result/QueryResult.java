package com.tencent.cloud.huiyansdkface.facelight.net.model.result;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/result/QueryResult.class */
public class QueryResult implements Serializable {
    public String code;
    public String isRecorded;
    public String liveRate;
    public String msg;
    public String orderNo;
    public String retry;
    public RiskInfo riskInfo;
    public String sign;
    public String similarity;

    public String toString() {
        return "QueryResult{code='" + this.code + "', msg='" + this.msg + "', orderNo='" + this.orderNo + "', similarity='" + this.similarity + "', liveRate='" + this.liveRate + "', retry='" + this.retry + "', isRecorded=" + this.isRecorded + ", riskInfo=" + this.riskInfo + '}';
    }
}
