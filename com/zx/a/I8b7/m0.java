package com.zx.a.I8b7;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/m0.class */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<c0> f28457a = new ArrayList();

    public void a(int i, String str, String str2, Throwable th) {
        for (c0 c0Var : this.f28457a) {
            try {
                if (c0Var.a(i, null)) {
                    c0Var.a(i, null, str2, th);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void a(c0 c0Var) {
        this.f28457a.add(c0Var);
    }
}
