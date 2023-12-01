package c.t.m.g;

import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/p5.class */
public class p5 {
    public static final p5 n = new p5();

    /* renamed from: a  reason: collision with root package name */
    public String f3933a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f3934c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public final Bundle m = new Bundle();

    public p5() {
    }

    public p5(p5 p5Var) {
        if (p5Var.m.size() > 0) {
            this.m.putAll(p5Var.m);
            return;
        }
        this.f3933a = p5Var.f3933a;
        this.b = p5Var.b;
        this.f3934c = p5Var.f3934c;
        this.d = p5Var.d;
        this.e = p5Var.e;
        this.f = p5Var.f;
        this.g = p5Var.g;
        this.h = p5Var.h;
        this.i = p5Var.i;
        this.j = p5Var.j;
        this.k = p5Var.k;
        this.l = p5Var.l;
    }

    public p5(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("admin_level_1")) {
            String optString = jSONObject.optString("nation");
            String optString2 = jSONObject.optString("admin_level_1");
            String optString3 = jSONObject.optString("admin_level_2");
            String optString4 = jSONObject.optString("admin_level_3");
            String optString5 = jSONObject.optString("locality");
            String optString6 = jSONObject.optString("sublocality");
            String optString7 = jSONObject.optString("route");
            this.m.putString("nation", optString);
            this.m.putString("admin_level_1", optString2);
            this.m.putString("admin_level_2", optString3);
            this.m.putString("admin_level_3", optString4);
            this.m.putString("locality", optString5);
            this.m.putString("sublocality", optString6);
            this.m.putString("route", optString7);
            return;
        }
        this.b = jSONObject.optString("name", null);
        this.f3934c = jSONObject.optString("code", null);
        this.d = jSONObject.optString("pncode", null);
        this.f3933a = jSONObject.optString("nation", null);
        this.e = jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE, null);
        this.f = jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY, null);
        this.g = jSONObject.optString(DistrictSearchQuery.KEYWORDS_DISTRICT, null);
        this.h = jSONObject.optString("town", null);
        this.i = jSONObject.optString("village", null);
        this.j = jSONObject.optString("street", null);
        this.k = jSONObject.optString("street_no", null);
        String optString8 = jSONObject.optString("mergedname", null);
        String optString9 = jSONObject.optString("mergedaddr", null);
        if (!TextUtils.isEmpty(optString8)) {
            this.b = optString8;
        }
        if (TextUtils.isEmpty(optString9)) {
            return;
        }
        this.l = optString9;
    }

    public static p5 a(p5 p5Var) {
        if (p5Var == null) {
            return null;
        }
        return new p5(p5Var);
    }

    public String toString() {
        return "SubnationData{name=" + this.b + ",address=" + this.l + ",code=" + this.f3934c + ",phCode=" + this.d + ",nation=" + this.f3933a + ",province=" + this.e + ",city=" + this.f + ",district=" + this.g + ",town=" + this.h + ",village=" + this.i + ",street=" + this.j + ",street_no=" + this.k + "," + TTLiveConstants.BUNDLE_KEY + this.m + "," + com.alipay.sdk.util.i.d;
    }
}
