package com.tencent.tmsbeacon.base.net;

import com.tencent.qcloud.core.http.HttpConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/BodyType.class */
public enum BodyType {
    JSON("application/json; charset=utf-8"),
    FORM("application/x-www-form-urlencoded"),
    DATA(HttpConstants.ContentType.MULTIPART_FORM_DATA);
    
    public String httpType;

    BodyType(String str) {
        this.httpType = str;
    }
}
