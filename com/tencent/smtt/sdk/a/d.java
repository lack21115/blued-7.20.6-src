package com.tencent.smtt.sdk.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f25136a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private List<b> f25137c;

    private d() {
    }

    public static d a(String str) {
        d dVar;
        JSONException e;
        JSONObject jSONObject;
        d dVar2;
        d dVar3 = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
                dVar2 = new d();
            } catch (JSONException e2) {
                dVar = null;
                e = e2;
            }
            try {
                dVar2.f25136a = jSONObject.optInt("ret_code", -1);
                dVar2.b = jSONObject.optLong("next_req_interval", 1000L);
                JSONArray optJSONArray = jSONObject.optJSONArray("cmds");
                dVar = dVar2;
                if (optJSONArray != null) {
                    dVar2.f25137c = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        dVar = dVar2;
                        if (i2 >= optJSONArray.length()) {
                            break;
                        }
                        b a2 = b.a(optJSONArray.optJSONObject(i2));
                        if (a2 != null) {
                            dVar2.f25137c.add(a2);
                        }
                        i = i2 + 1;
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                dVar = dVar2;
                e.printStackTrace();
                dVar3 = dVar;
                return dVar3;
            }
            dVar3 = dVar;
        }
        return dVar3;
    }

    public int a() {
        return this.f25136a;
    }

    public long b() {
        return this.b;
    }

    public List<b> c() {
        return this.f25137c;
    }
}
