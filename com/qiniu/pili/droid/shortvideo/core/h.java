package com.qiniu.pili.droid.shortvideo.core;

import com.sobot.network.http.model.SobotProgress;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/core/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public File f27552a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f27553c;
    public long d;
    public long e;
    public int f;
    public int g;

    public h() {
    }

    public h(String str, int i, int i2, long j, long j2, int i3, int i4) {
        this.f27552a = new File(str);
        this.b = i;
        this.f27553c = i2;
        this.d = j;
        this.e = j2;
        this.f = i3;
        this.g = i4;
    }

    public static h a(JSONObject jSONObject) {
        return new h(jSONObject.optString(SobotProgress.FILE_NAME), jSONObject.optInt("audioIndex"), jSONObject.optInt("videoIndex"), jSONObject.optLong("startTimeMs"), jSONObject.optLong("durationMs"), jSONObject.optInt("audioFrameNum"), jSONObject.optInt("videoFrameNum"));
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SobotProgress.FILE_NAME, this.f27552a.getPath());
            jSONObject.put("audioIndex", this.b);
            jSONObject.put("videoIndex", this.f27553c);
            jSONObject.put("startTimeMs", this.d);
            jSONObject.put("durationMs", this.e);
            jSONObject.put("audioFrameNum", this.f);
            jSONObject.put("videoFrameNum", this.g);
            return jSONObject;
        } catch (JSONException e) {
            com.qiniu.pili.droid.shortvideo.f.e.f.e("SectionInfo", "Error on saving to json string");
            return null;
        }
    }
}
