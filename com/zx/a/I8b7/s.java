package com.zx.a.I8b7;

import com.zx.a.I8b7.u1;
import org.json.JSONArray;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/s.class */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f28503a;

    public s(r rVar) {
        this.f28503a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        r rVar = this.f28503a;
        if (rVar.f28496a != null) {
            rVar.f28496a = new JSONArray();
            u1 u1Var = u1.a.f28517a;
            u1Var.f28516a.getClass();
            u1Var.f28516a.a(23, "", true);
        }
    }
}
