package com.anythink.core.common.e;

import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/f.class */
public final class f extends q {
    public int a;
    public ah b;
    public long c;

    @Override // com.anythink.core.common.e.q
    public final JSONObject a() {
        JSONObject A = this.b.A(this.a);
        if (A != null) {
            try {
                A.put("sdk_time", this.c);
                return A;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return A;
    }
}
