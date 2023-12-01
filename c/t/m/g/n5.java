package c.t.m.g;

import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n5.class */
public class n5 {

    /* renamed from: a  reason: collision with root package name */
    public double f3848a;
    public double b;

    /* renamed from: c  reason: collision with root package name */
    public double f3849c;
    public float d;
    public int e;
    public String f;
    public String g;

    public n5() {
    }

    public n5(JSONObject jSONObject) {
        this.f3848a = jSONObject.optDouble("latitude", 0.0d);
        this.b = jSONObject.optDouble("longitude", 0.0d);
        this.f3849c = jSONObject.optDouble("altitude", 0.0d);
        this.d = (float) jSONObject.optDouble("accuracy", 0.0d);
        int optInt = jSONObject.optInt("type", -3);
        this.e = optInt;
        if (optInt == 2) {
            f6.b = System.currentTimeMillis();
        }
        this.f = jSONObject.optString("name", null);
        this.g = jSONObject.optString("addr", null);
    }

    public static n5 a(n5 n5Var) {
        n5 n5Var2 = new n5();
        if (n5Var != null) {
            n5Var2.f3848a = n5Var.f3848a;
            n5Var2.b = n5Var.b;
            n5Var2.f3849c = n5Var.f3849c;
            n5Var2.d = n5Var.d;
            n5Var2.f = n5Var.f;
            n5Var2.g = n5Var.g;
        }
        return n5Var2;
    }
}
