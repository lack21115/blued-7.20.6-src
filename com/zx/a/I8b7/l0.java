package com.zx.a.I8b7;

import com.zx.a.I8b7.b1;
import com.zx.a.I8b7.e1;
import com.zx.a.I8b7.f1;
import com.zx.a.I8b7.g0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/l0.class */
public class l0 implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public k0 f42145a;

    public l0(k0 k0Var, int i) {
        this.f42145a = k0Var;
    }

    @Override // com.zx.a.I8b7.g0
    public e1 a(g0.a aVar) throws IOException {
        v0 v0Var = (v0) aVar;
        b1 b1Var = v0Var.f42217c;
        b1.a aVar2 = new b1.a(b1Var);
        StringBuilder sb = new StringBuilder();
        sb.append(b1Var.b + " " + b1Var.f42104a.toString() + " " + b1Var.e + "\n");
        d1 d1Var = b1Var.d;
        if (d1Var != null && ((c1) d1Var).f42110a.a() != null) {
            if (((c1) b1Var.d).b > 2147483647L) {
                StringBuilder a2 = m2.a("request body content length: ");
                a2.append(((c1) b1Var.d).b);
                a2.append("\n");
                sb.append(a2.toString());
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                c1 c1Var = (c1) b1Var.d;
                byteArrayOutputStream.write(c1Var.f42111c, c1Var.d, c1Var.b);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                sb.append(new String(byteArray, StandardCharsets.UTF_8) + "\n");
                aVar2.d = d1.a(((c1) b1Var.d).f42110a, byteArray);
            }
        }
        this.f42145a.a(sb.toString());
        e1 a3 = v0Var.a(new b1(aVar2), v0Var.d);
        e1.a aVar3 = new e1.a(a3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(a3.b + " " + a3.f42121c + " " + b1Var.f42104a.toString() + " " + b1Var.e + "\n");
        f1 f1Var = a3.e;
        if (f1Var != null && ((f1.a) f1Var).f42127a.a() != null) {
            f1 f1Var2 = a3.e;
            if (((f1.a) f1Var2).b > 2147483647L) {
                StringBuilder a4 = m2.a("response body content length: ");
                a4.append(((f1.a) a3.e).b);
                a4.append("\n");
                sb2.append(a4.toString());
            } else {
                byte[] a5 = f1Var2.a();
                sb2.append("response body size: ");
                sb2.append(a5.length);
                sb2.append(", ");
                sb2.append(new String(a5, StandardCharsets.UTF_8) + "\n");
                aVar3.e = f1.a(((f1.a) a3.e).f42127a, (long) a5.length, new ByteArrayInputStream(a5));
            }
        }
        this.f42145a.a(sb2.toString());
        return aVar3.a();
    }
}
