package com.qiniu.android.storage;

import com.qiniu.android.http.ResponseInfo;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/UpCompletionHandler.class */
public interface UpCompletionHandler {
    void complete(String str, ResponseInfo responseInfo, JSONObject jSONObject);
}
