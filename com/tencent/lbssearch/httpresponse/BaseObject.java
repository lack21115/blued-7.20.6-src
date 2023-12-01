package com.tencent.lbssearch.httpresponse;

import com.tencent.map.tools.json.JsonComposer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/httpresponse/BaseObject.class */
public class BaseObject extends JsonComposer {
    public Exception exception;
    public String message;
    public int status;

    public boolean isStatusOk() {
        return this.status == 0;
    }
}
