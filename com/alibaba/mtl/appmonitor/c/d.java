package com.alibaba.mtl.appmonitor.c;

import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/c/d.class */
public class d extends JSONArray implements b {
    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length()) {
                return;
            }
            Object opt = opt(i2);
            if (opt != null && (opt instanceof b)) {
                a.a().a((a) ((b) opt));
            }
            i = i2 + 1;
        }
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
    }
}
