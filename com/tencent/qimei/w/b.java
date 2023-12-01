package com.tencent.qimei.w;

import com.tencent.qimei.v.g;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/w/b.class */
public enum b implements com.tencent.qimei.f.a<Integer> {
    KEY_DATA_QM_REPORT_RATE("reportRate", com.tencent.qimei.v.d.f24731a.C()),
    KEY_DATA_QM_JS_TIME("jsTime", com.tencent.qimei.v.d.f24731a.c()),
    KEY_DATA_QM_X5_TIME("x5Time", com.tencent.qimei.v.d.f24731a.k()),
    KEY_DATA_QM_MIN_HID_RUN("minHr", com.tencent.qimei.v.d.f24731a.x()),
    KEY_DATA_QM_ARDT("ardt", com.tencent.qimei.v.d.f24731a.s());
    
    public static final com.tencent.qimei.h.a<Integer> f;
    public final String h;
    public final int i;

    static {
        final com.tencent.qimei.f.a[] aVarArr = new com.tencent.qimei.f.a[0];
        f = new com.tencent.qimei.h.a<Integer>(aVarArr) { // from class: com.tencent.qimei.h.c
            @Override // com.tencent.qimei.h.a
            public Integer a(com.tencent.qimei.f.a<Integer> aVar, String str) {
                String a2 = a(str, a(aVar));
                if (a2 == null || a2.isEmpty()) {
                    return aVar.a();
                }
                try {
                    return Integer.valueOf(Integer.parseInt(a2));
                } catch (Exception e) {
                    e.printStackTrace();
                    return aVar.a();
                }
            }
        };
    }

    b(String str, int i) {
        this.h = str;
        this.i = i;
    }

    public Integer a(String str) {
        return f.a(this, g.a(str));
    }

    @Override // com.tencent.qimei.f.a
    public Integer a() {
        return Integer.valueOf(this.i);
    }

    @Override // com.tencent.qimei.f.a
    public String b() {
        return this.h;
    }
}
