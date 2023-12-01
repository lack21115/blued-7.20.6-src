package com.xiaomi.push;

import com.xiaomi.push.iy;
import java.io.ByteArrayOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ix.class */
public class ix {

    /* renamed from: a  reason: collision with root package name */
    private jc f41539a;

    /* renamed from: a  reason: collision with other field name */
    private final jj f878a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f879a;

    public ix() {
        this(new iy.a());
    }

    public ix(je jeVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f879a = byteArrayOutputStream;
        jj jjVar = new jj(byteArrayOutputStream);
        this.f878a = jjVar;
        this.f41539a = jeVar.a(jjVar);
    }

    public byte[] a(ir irVar) {
        this.f879a.reset();
        irVar.b(this.f41539a);
        return this.f879a.toByteArray();
    }
}
