package com.ss.android.downloadlib.addownload.model;

import com.ss.android.downloadlib.utils.jb;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/mb.class */
public class mb {
    public long b;
    public String h;
    public String hj;
    public String ko;
    public long mb;
    public long ox;
    public String u;
    public volatile long ww;

    public mb() {
    }

    public mb(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.mb = j;
        this.ox = j2;
        this.b = j3;
        this.hj = str;
        this.h = str2;
        this.u = str3;
        this.ko = str4;
    }

    public static mb mb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        mb mbVar = new mb();
        try {
            mbVar.mb = jb.mb(jSONObject, "mDownloadId");
            mbVar.ox = jb.mb(jSONObject, "mAdId");
            mbVar.b = jb.mb(jSONObject, "mExtValue");
            mbVar.hj = jSONObject.optString("mPackageName");
            mbVar.h = jSONObject.optString("mAppName");
            mbVar.u = jSONObject.optString("mLogExtra");
            mbVar.ko = jSONObject.optString("mFileName");
            mbVar.ww = jb.mb(jSONObject, "mTimeStamp");
            return mbVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject mb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.mb);
            jSONObject.put("mAdId", this.ox);
            jSONObject.put("mExtValue", this.b);
            jSONObject.put("mPackageName", this.hj);
            jSONObject.put("mAppName", this.h);
            jSONObject.put("mLogExtra", this.u);
            jSONObject.put("mFileName", this.ko);
            jSONObject.put("mTimeStamp", this.ww);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
