package com.qiniu.android.http;

import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/CompletionHandler.class */
public interface CompletionHandler {
    void complete(ResponseInfo responseInfo, JSONObject jSONObject);
}
