package com.zx.a.I8b7;

import com.zx.a.I8b7.g0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/v0.class */
public class v0 implements g0.a {

    /* renamed from: a  reason: collision with root package name */
    public final int f42216a;
    public final List<g0> b;

    /* renamed from: c  reason: collision with root package name */
    public final b1 f42217c;
    public final HttpURLConnection d;

    public v0(List<g0> list, HttpURLConnection httpURLConnection, int i, b1 b1Var) {
        this.b = list;
        this.d = httpURLConnection;
        this.f42216a = i;
        this.f42217c = b1Var;
    }

    public e1 a(b1 b1Var, HttpURLConnection httpURLConnection) throws IOException {
        if (this.f42216a < this.b.size()) {
            List<g0> list = this.b;
            int i = this.f42216a;
            v0 v0Var = new v0(list, httpURLConnection, i + 1, b1Var);
            g0 g0Var = list.get(i);
            e1 a2 = g0Var.a(v0Var);
            if (a2 == null) {
                throw new NullPointerException("interceptor " + g0Var + " returned null");
            } else if (a2.e != null) {
                return a2;
            } else {
                throw new IllegalStateException("interceptor " + g0Var + " returned a response with no body");
            }
        }
        throw new AssertionError();
    }
}
