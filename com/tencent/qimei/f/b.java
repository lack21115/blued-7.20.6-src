package com.tencent.qimei.f;

import com.tencent.qimei.h.d;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/f/b.class */
public enum b implements a<String> {
    KEY_CODE("code"),
    KEY_DATA("data");
    

    /* renamed from: c  reason: collision with root package name */
    public static final com.tencent.qimei.h.a<String> f38326c = new d(new a[0]);
    public final String e;
    public String f;

    b(String str) {
        this.e = str;
    }

    @Override // com.tencent.qimei.f.a
    public String a() {
        return "0";
    }

    public String a(@Deprecated String str) {
        String str2 = this.f;
        if (str2 != null) {
            return f38326c.a(this, str2);
        }
        throw new RuntimeException("Please set json first: KEY_CODE.json(json).value()");
    }

    @Override // com.tencent.qimei.f.a
    public String b() {
        return this.e;
    }
}
