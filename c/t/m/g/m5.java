package c.t.m.g;

import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/m5.class */
public class m5 {

    /* renamed from: a  reason: collision with root package name */
    public String f3836a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f3837c;

    public m5(JSONObject jSONObject) {
        this.f3836a = jSONObject.optString("bid", null);
        this.b = jSONObject.optString("floor", Constants.DEFAULT_UIN);
        this.f3837c = jSONObject.optInt("type", -1);
    }
}
