package com.tencent.cloud.huiyansdkface.facelight.net.model.result;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/model/result/GetActResult.class */
public class GetActResult implements Serializable {
    public String activeType;
    public String bizSeqNo;
    public String code;
    public String colorData;
    public String msg;

    public String toString() {
        return "GetActResult{code='" + this.code + "', msg='" + this.msg + "', bizSeqNo='" + this.bizSeqNo + "', activeType='" + this.activeType + "', colorData='" + this.colorData + "'}";
    }
}
