package com.zx.a.I8b7;

import com.zx.a.I8b7.u1;
import org.json.JSONArray;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/s.class */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f42194a;

    public s(r rVar) {
        this.f42194a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        r rVar = this.f42194a;
        if (rVar.f42187a != null) {
            rVar.f42187a = new JSONArray();
            u1 u1Var = u1.a.f42208a;
            u1Var.f42207a.getClass();
            u1Var.f42207a.a(23, "", true);
        }
    }
}
