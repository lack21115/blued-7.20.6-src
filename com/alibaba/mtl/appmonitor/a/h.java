package com.alibaba.mtl.appmonitor.a;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a/h.class */
public class h implements com.alibaba.mtl.appmonitor.c.b {
    public int e;
    public Map<String, String> k;
    public String u;
    public String v;
    public String w;
    public String x;

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        this.u = null;
        this.e = 0;
        this.v = null;
        this.w = null;
        this.x = null;
        Map<String, String> map = this.k;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        if (this.k == null) {
            this.k = new HashMap();
        }
    }
}
