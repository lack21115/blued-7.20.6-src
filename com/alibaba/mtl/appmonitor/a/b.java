package com.alibaba.mtl.appmonitor.a;

import com.android.internal.util.cm.SpamFilter;
import com.anythink.core.common.c.d;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a/b.class */
public class b extends d {
    public int count;
    public double e;

    @Override // com.alibaba.mtl.appmonitor.a.d
    public JSONObject a() {
        JSONObject a;
        synchronized (this) {
            a = super.a();
            try {
                a.put(SpamFilter.SpamContract.NotificationTable.COUNT, this.count);
                a.put(d.a.d, this.e);
            } catch (Exception e) {
            }
        }
        return a;
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
