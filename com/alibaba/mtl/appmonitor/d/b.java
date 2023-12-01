package com.alibaba.mtl.appmonitor.d;

import android.text.TextUtils;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/b.class */
public class b {
    private a a;
    private Set<String> c;

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/b$a.class */
    enum a {
        IN,
        NOT_IN
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.c.contains(str);
        return this.a == a.IN ? contains : !contains;
    }
}
