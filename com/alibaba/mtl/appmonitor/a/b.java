package com.alibaba.mtl.appmonitor.a;

import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a/b.class */
public class b extends d {
    public int count;
    public double e;

    @Override // com.alibaba.mtl.appmonitor.a.d
    public JSONObject a() {
        JSONObject a2;
        synchronized (this) {
            a2 = super.a();
            try {
                a2.put("count", this.count);
                a2.put("value", this.e);
            } catch (Exception e) {
            }
        }
        return a2;
    }

    public void a(double d) {
        synchronized (this) {
            this.e += d;
            this.count++;
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        synchronized (this) {
            super.fill(objArr);
            this.e = 0.0d;
            this.count = 0;
        }
    }
}
