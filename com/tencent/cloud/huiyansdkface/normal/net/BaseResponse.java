package com.tencent.cloud.huiyansdkface.normal.net;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/net/BaseResponse.class */
public class BaseResponse<T extends Serializable> implements Serializable {
    public String bizSeqNo;
    public String code;
    public String csrfToken;
    public String ecifNo;
    public String msg;
    public T result;
    public ArrayList<RetList> retList;
    public String status;
    public String submitKey;
    public String transactionTime;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/net/BaseResponse$RetList.class */
    public static class RetList implements Serializable {
        public String retCode;
        public String retMessage;
    }
}
