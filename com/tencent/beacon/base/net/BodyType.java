package com.tencent.beacon.base.net;

import com.tencent.qcloud.core.http.HttpConstants;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/BodyType.class */
public enum BodyType {
    JSON("application/json; charset=utf-8"),
    FORM("application/x-www-form-urlencoded"),
    DATA(HttpConstants.ContentType.MULTIPART_FORM_DATA);
    
    public String httpType;

    BodyType(String str) {
        this.httpType = str;
    }
}
