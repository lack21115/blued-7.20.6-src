package com.tencent.qimei.w;

import com.huawei.openalliance.ad.constant.ao;
import com.tencent.qimei.v.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/w/a.class */
public enum a implements com.tencent.qimei.f.a<Boolean> {
    KEY_DATA_ENABLE_Q16(com.tencent.qimei.a.b.a(0), com.tencent.qimei.v.d.f24731a.i()),
    KEY_DATA_ENABLE_Q36(com.tencent.qimei.a.b.a(1), com.tencent.qimei.v.d.f24731a.G()),
    KEY_DATA_ENABLE_OD(com.tencent.qimei.a.b.a(5), com.tencent.qimei.v.d.f24731a.h()),
    KEY_DATA_ENABLE_USERID(ao.q, com.tencent.qimei.v.d.f24731a.b()),
    KEY_DATA_ENABLE_EI(com.tencent.qimei.a.b.a(6), com.tencent.qimei.v.d.f24731a.E()),
    KEY_DATA_ENABLE_SI(com.tencent.qimei.a.b.a(7), com.tencent.qimei.v.d.f24731a.F()),
    KEY_DATA_ENABLE_AD(com.tencent.qimei.a.b.a(11), com.tencent.qimei.v.d.f24731a.y()),
    KEY_DATA_ENABLE_MC(com.tencent.qimei.a.b.a(8), com.tencent.qimei.v.d.f24731a.q()),
    KEY_DATA_ENABLE_CD(com.tencent.qimei.a.b.a(9), com.tencent.qimei.v.d.f24731a.n()),
    KEY_DATA_ENABLE_PROCESS_INFO("processInfo", com.tencent.qimei.v.d.f24731a.z()),
    KEY_DATA_ENABLE_AUDIT("audit", com.tencent.qimei.v.d.f24731a.v()),
    KEY_DATA_FORCE_UPDATE_QM(com.tencent.qimei.a.b.a(10), com.tencent.qimei.v.d.f24731a.l()),
    KEY_DATA_ENABLE_REPORT("report", com.tencent.qimei.v.d.f24731a.B()),
    KEY_DATA_ENABLE_BEACON_ID("isBidEnable", com.tencent.qimei.v.d.f24731a.t()),
    KEY_DATA_ENABLE_OZ("oz", com.tencent.qimei.v.d.f24731a.f()),
    KEY_DATA_ENABLE_OO("oo", com.tencent.qimei.v.d.f24731a.w());
    
    public static final com.tencent.qimei.h.a<Boolean> q;
    public final String s;
    public final boolean t;

    static {
        final com.tencent.qimei.f.a[] aVarArr = new com.tencent.qimei.f.a[0];
        q = new com.tencent.qimei.h.a<Boolean>(aVarArr) { // from class: com.tencent.qimei.h.b
            @Override // com.tencent.qimei.h.a
            public Boolean a(com.tencent.qimei.f.a<Boolean> aVar, String str) {
                String a2 = a(str, a(aVar));
                return (a2 == null || a2.isEmpty()) ? aVar.a() : Boolean.valueOf("1".equals(a2));
            }
        };
    }

    a(String str, boolean z) {
        this.s = str;
        this.t = z;
    }

    public Boolean a(String str) {
        return q.a(this, g.a(str));
    }

    @Override // com.tencent.qimei.f.a
    public Boolean a() {
        return Boolean.valueOf(this.t);
    }

    @Override // com.tencent.qimei.f.a
    public String b() {
        return this.s;
    }
}
