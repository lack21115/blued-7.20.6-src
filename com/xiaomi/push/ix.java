package com.xiaomi.push;

import com.xiaomi.push.iy;
import java.io.ByteArrayOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ix.class */
public class ix {

    /* renamed from: a  reason: collision with root package name */
    private jc f27848a;

    /* renamed from: a  reason: collision with other field name */
    private final jj f831a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f832a;

    public ix() {
        this(new iy.a());
    }

    public ix(je jeVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f832a = byteArrayOutputStream;
        jj jjVar = new jj(byteArrayOutputStream);
        this.f831a = jjVar;
        this.f27848a = jeVar.a(jjVar);
    }

    public byte[] a(ir irVar) {
        this.f832a.reset();
        irVar.b(this.f27848a);
        return this.f832a.toByteArray();
    }
}
