package com.efs.sdk.base.core.f;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.protocol.ILogProtocol;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/f/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public c f8173a;
    public ControllerCenter b;

    /* renamed from: c  reason: collision with root package name */
    public d f8174c;
    public g d;

    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/f/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final f f8175a = new f((byte) 0);

        public static /* synthetic */ f a() {
            return f8175a;
        }
    }

    private f() {
        this.f8173a = new c();
        this.f8174c = new d();
        this.d = new g();
    }

    /* synthetic */ f(byte b) {
        this();
    }

    public final b a(String str, int i) {
        b bVar = new b("efs_core", str, this.f8173a.f8171c);
        bVar.put("cver", Integer.valueOf(i));
        return bVar;
    }

    public final void a(int i) {
        ControllerCenter controllerCenter = this.b;
        if (controllerCenter != null) {
            controllerCenter.send(a("flow_limit", i));
        }
    }

    public final void a(int i, String str) {
        if (this.b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            ILogProtocol a2 = a("flow_limit_type", i);
            a2.put("code", str);
            this.b.send(a2);
        }
    }

    public final void a(String str, String str2, String str3) {
        this.d.a(str, str2, str3);
    }
}
