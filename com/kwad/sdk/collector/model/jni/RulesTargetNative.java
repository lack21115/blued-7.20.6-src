package com.kwad.sdk.collector.model.jni;

import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.d;
import com.kwad.sdk.service.b;
import com.kwad.sdk.utils.t;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/collector/model/jni/RulesTargetNative.class */
public class RulesTargetNative extends NativeObject implements d {
    private static final long serialVersionUID = -4726982809581153390L;

    public RulesTargetNative() {
        this.mPtr = AppStatusNative.nativeCreateRulesTarget();
    }

    public RulesTargetNative(long j) {
        this.mPtr = j;
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        if (this.mPtr != 0) {
            AppStatusNative.nativeDeleteRulesTarget(this.mPtr);
            this.mPtr = 0L;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            AppStatusNative.rulesTargetSetPackageName(this, jSONObject.optString("packageName"));
            JSONArray optJSONArray = jSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                return;
            }
            int length = optJSONArray.length();
            String[] strArr = new String[length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    AppStatusNative.rulesTargetSetPaths(this, strArr);
                    return;
                } else {
                    strArr[i2] = optJSONArray.getString(i2);
                    i = i2 + 1;
                }
            }
        } catch (Exception e) {
            b.gatherException(e);
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "packageName", AppStatusNative.rulesTargetGetPackageName(this));
        t.putValue(jSONObject, "paths", Arrays.asList(AppStatusNative.rulesTargetGetPaths(this)));
        return jSONObject;
    }
}
