package com.web.library.groups.webviewsdk.a.a;

import com.weimob.library.groups.wjson.WJSON;
import java.io.Serializable;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/a/a/a.class */
public class a implements Serializable {
    public String toJson() {
        return WJSON.toJSONString(this);
    }

    public String toString() {
        return toJson();
    }
}
