package com.tencent.tmsbeacon.base.net;

import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/BResponse.class */
public class BResponse {
    public byte[] body;
    public int code;
    public Map<String, List<String>> headers;
    public String msg;

    public BResponse(Map<String, List<String>> map, int i, String str, byte[] bArr) {
        this.headers = map;
        this.code = i;
        this.msg = str;
        this.body = bArr;
    }

    public String toString() {
        return "BResponse{code=" + this.code + ", msg='" + this.msg + "'}";
    }
}
