package com.zx.a.I8b7;

import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/e1.class */
public class e1 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final b1 f28429a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final String f28430c;
    public final Map<String, List<String>> d;
    public final f1 e;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/e1$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b1 f28431a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public String f28432c;
        public Map<String, List<String>> d;
        public f1 e;

        public a() {
            this.b = -1;
            this.d = new HashMap();
        }

        public a(e1 e1Var) {
            this.b = -1;
            this.f28431a = e1Var.f28429a;
            this.b = e1Var.b;
            this.f28432c = e1Var.f28430c;
            this.d = new HashMap(e1Var.d);
            this.e = e1Var.e;
        }

        public e1 a() {
            if (this.f28431a != null) {
                if (this.b >= 0) {
                    if (this.f28432c != null) {
                        return new e1(this);
                    }
                    throw new IllegalStateException("message == null");
                }
                StringBuilder a2 = m2.a("code < 0: ");
                a2.append(this.b);
                throw new IllegalStateException(a2.toString());
            }
            throw new IllegalStateException("request == null");
        }
    }

    public e1(a aVar) {
        this.f28429a = aVar.f28431a;
        this.b = aVar.b;
        this.f28430c = aVar.f28432c;
        this.d = new HashMap(aVar.d);
        this.e = aVar.e;
    }

    public String a(String str) {
        List<String> list = this.d.get(str);
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : list) {
            sb.append(str2);
            sb.append("; ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        f1 f1Var = this.e;
        if (f1Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        f1Var.close();
    }
}
