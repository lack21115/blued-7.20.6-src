package com.umeng.commonsdk.utils;

import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/utils/JSONArraySortUtil.class */
public class JSONArraySortUtil implements Comparator<JSONObject> {
    private String mCompareKey;

    @Override // java.util.Comparator
    public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            return (int) (jSONObject.getLong(this.mCompareKey) - jSONObject2.getLong(this.mCompareKey));
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void setCompareKey(String str) {
        this.mCompareKey = str;
    }
}
