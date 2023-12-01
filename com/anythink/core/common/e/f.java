package com.anythink.core.common.e;

import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/f.class */
public final class f extends q {

    /* renamed from: a  reason: collision with root package name */
    public int f6657a;
    public ah b;

    /* renamed from: c  reason: collision with root package name */
    public long f6658c;

    @Override // com.anythink.core.common.e.q
    public final JSONObject a() {
        JSONObject A = this.b.A(this.f6657a);
        if (A != null) {
            try {
                A.put("sdk_time", this.f6658c);
                return A;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return A;
    }
}
