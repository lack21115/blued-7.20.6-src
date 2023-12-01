package com.ta.utdid2.device;

import com.ta.utdid2.a.a.g;

/* loaded from: source-8457232-dex2jar.jar:com/ta/utdid2/device/e.class */
public class e {
    public String d(String str) {
        return com.ta.utdid2.a.a.a.b(str);
    }

    public String e(String str) {
        String b = com.ta.utdid2.a.a.a.b(str);
        if (g.m9885a(b)) {
            return null;
        }
        try {
            return new String(com.ta.utdid2.a.a.b.decode(b, 0));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
