package com.qiniu.pili.droid.shortvideo;

import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLUploadResultListener.class */
public interface PLUploadResultListener {
    void onUploadVideoFailed(int i, String str);

    void onUploadVideoSuccess(JSONObject jSONObject);
}
