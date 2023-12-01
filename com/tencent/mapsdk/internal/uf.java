package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonParser;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/uf.class */
public class uf implements JsonParser {

    /* renamed from: a  reason: collision with root package name */
    public String f38049a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f38050c;
    public int d;
    private String e;
    private String[] f;
    private JSONObject g;
    public boolean h;

    public String a(int i, int i2, int i3) {
        String replace;
        String[] strArr = this.f;
        if (strArr == null || strArr.length == 0) {
            return this.e;
        }
        String str = this.e;
        String replace2 = str.replace("{x}", i + "");
        String replace3 = replace2.replace("{y}", i2 + "");
        String replace4 = replace3.replace("{z}", i3 + "");
        String[] strArr2 = this.f;
        int length = strArr2.length;
        int i4 = 0;
        while (i4 < length) {
            String str2 = strArr2[i4];
            Object opt = this.g.opt(str2);
            if (opt instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) opt;
                String optString = jSONArray.optString(xa.a(0, jSONArray.length()), "");
                replace = replace4.replace("{" + str2 + com.alipay.sdk.util.i.d, optString);
            } else {
                if (!(opt instanceof String)) {
                    replace = replace4;
                    if (!(opt instanceof Number)) {
                    }
                }
                replace = replace4.replace("{" + str2 + com.alipay.sdk.util.i.d, String.valueOf(opt));
            }
            i4++;
            replace4 = replace;
        }
        return replace4;
    }

    @Override // com.tencent.map.tools.json.JsonParser
    public void parse(JSONObject jSONObject) {
        this.g = jSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f38049a = jSONObject.optString("layerid");
        this.b = jSONObject.optString("version");
        this.e = jSONObject.optString("url");
        this.f38050c = jSONObject.optInt("zoom_max", 20);
        this.d = jSONObject.optInt("zoom_min", 1);
        JSONArray optJSONArray = jSONObject.optJSONArray("params");
        if (optJSONArray == null) {
            return;
        }
        this.f = new String[optJSONArray.length()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return;
            }
            this.f[i2] = optJSONArray.optString(i2);
            i = i2 + 1;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CustomLayerModel{");
        stringBuffer.append("mLayerId='");
        stringBuffer.append(this.f38049a);
        stringBuffer.append('\'');
        stringBuffer.append(", mVersion='");
        stringBuffer.append(this.b);
        stringBuffer.append('\'');
        stringBuffer.append(", mMaxZoomLevel=");
        stringBuffer.append(this.f38050c);
        stringBuffer.append(", mMinZoomLevel=");
        stringBuffer.append(this.d);
        stringBuffer.append(", mUrl='");
        stringBuffer.append(this.e);
        stringBuffer.append('\'');
        stringBuffer.append(", mParamsHolders=");
        String[] strArr = this.f;
        stringBuffer.append(strArr == null ? com.igexin.push.core.b.l : Arrays.asList(strArr).toString());
        stringBuffer.append(", mVersionUpdated=");
        stringBuffer.append(this.h);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
