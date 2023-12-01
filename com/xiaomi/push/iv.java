package com.xiaomi.push;

import com.xiaomi.push.iy;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/iv.class */
public class iv {

    /* renamed from: a  reason: collision with root package name */
    private final jc f41538a;

    /* renamed from: a  reason: collision with other field name */
    private final jl f877a;

    public iv() {
        this(new iy.a());
    }

    public iv(je jeVar) {
        jl jlVar = new jl();
        this.f877a = jlVar;
        this.f41538a = jeVar.a(jlVar);
    }

    public void a(ir irVar, byte[] bArr) {
        try {
            this.f877a.a(bArr);
            irVar.a(this.f41538a);
        } finally {
            this.f41538a.k();
        }
    }
}
