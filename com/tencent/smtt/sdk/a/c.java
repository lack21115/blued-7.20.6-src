package com.tencent.smtt.sdk.a;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f25134a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f25135c;
    private String d;
    private String e;
    private Integer f;
    private Integer g;
    private List<Integer> h;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f25134a)) {
                jSONObject2.put("PP", this.f25134a);
            }
            if (!TextUtils.isEmpty(this.b)) {
                jSONObject2.put("PPVN", this.b);
            }
            if (this.f25135c != null) {
                jSONObject2.put("ADRV", this.f25135c);
            }
            if (!TextUtils.isEmpty(this.d)) {
                jSONObject2.put("MODEL", this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                jSONObject2.put("NAME", this.e);
            }
            if (this.f != null) {
                jSONObject2.put("SDKVC", this.f);
            }
            if (this.g != null) {
                jSONObject2.put("COMPVC", this.g);
            }
            jSONObject.put("terminal_params", jSONObject2);
            if (this.h != null) {
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.h.size()) {
                        break;
                    }
                    jSONArray.put(this.h.get(i2));
                    i = i2 + 1;
                }
                jSONObject.put(OapsKey.KEY_IDS, jSONArray);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void a(Integer num) {
        this.f25135c = num;
    }

    public void a(String str) {
        this.f25134a = str;
    }

    public void a(List<Integer> list) {
        this.h = list;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.d = str;
    }
}
