package c.t.m.g;

import android.os.Bundle;
import c.t.m.g.d3;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/v1.class */
public class v1 implements u1 {

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/v1$a.class */
    public class a implements d3.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f4020a;
        public final /* synthetic */ t1 b;

        public a(v1 v1Var, Bundle bundle, t1 t1Var) {
            this.f4020a = bundle;
            this.b = t1Var;
        }

        @Override // c.t.m.g.d3.c
        public void a(String str) {
            this.f4020a.putString("msg_fail", str);
            t1 t1Var = this.b;
            if (t1Var != null) {
                t1Var.a(str);
            }
        }

        @Override // c.t.m.g.d3.c
        public void b(String str) {
            this.f4020a.putString("msg_suc", str);
            t1 t1Var = this.b;
            if (t1Var != null) {
                t1Var.b(str);
            }
        }
    }

    @Override // c.t.m.g.u1
    public Bundle a(String str, byte[] bArr, t1 t1Var) {
        Bundle bundle = new Bundle();
        d3.a(str, bArr, new a(this, bundle, t1Var));
        return bundle;
    }
}
