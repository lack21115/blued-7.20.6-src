package com.xiaomi.push;

import com.xiaomi.push.iy;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/iv.class */
public class iv {

    /* renamed from: a  reason: collision with root package name */
    private final jc f27847a;

    /* renamed from: a  reason: collision with other field name */
    private final jl f830a;

    public iv() {
        this(new iy.a());
    }

    public iv(je jeVar) {
        jl jlVar = new jl();
        this.f830a = jlVar;
        this.f27847a = jeVar.a(jlVar);
    }

    public void a(ir irVar, byte[] bArr) {
        try {
            this.f830a.a(bArr);
            irVar.a(this.f27847a);
        } finally {
            this.f27847a.k();
        }
    }
}
