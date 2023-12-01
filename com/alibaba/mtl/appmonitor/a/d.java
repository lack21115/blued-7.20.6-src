package com.alibaba.mtl.appmonitor.a;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a/d.class */
public abstract class d implements com.alibaba.mtl.appmonitor.c.b {
    public int e;
    public String o;
    public String p;
    public String s;

    public JSONObject a() {
        JSONObject jSONObject = (JSONObject) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.e.class, new Object[0]);
        try {
            jSONObject.put("page", this.o);
            jSONObject.put("monitorPoint", this.p);
            if (this.s != null) {
                jSONObject.put("arg", this.s);
            }
            return jSONObject;
        } catch (JSONException e) {
            return jSONObject;
        }
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        this.e = 0;
        this.o = null;
        this.p = null;
        this.s = null;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        this.e = ((Integer) objArr[0]).intValue();
        this.o = (String) objArr[1];
        this.p = (String) objArr[2];
        if (objArr.length <= 3 || objArr[3] == null) {
            return;
        }
        this.s = (String) objArr[3];
    }
}
