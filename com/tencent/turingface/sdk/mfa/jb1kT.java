package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/jb1kT.class */
public final class jb1kT extends CvowV {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/jb1kT$spXPg.class */
    public static final class spXPg {

        /* renamed from: a  reason: collision with root package name */
        public Context f26268a;
        public n6fHX k;
        public ITuringDeviceInfoProvider l;
        public long o;
        public Set<Integer> p;
        public String q;
        public int b = 0;

        /* renamed from: c  reason: collision with root package name */
        public Map<Integer, String> f26269c = new HashMap();
        public boolean d = true;
        public String e = "";
        public String f = "";
        public boolean g = true;
        public String h = "turingfd.cert";
        public boolean i = true;
        public boolean j = true;
        public String m = "";
        public ITuringNetwork n = null;

        public spXPg(Context context, n6fHX n6fhx) {
            this.f26268a = context.getApplicationContext();
            this.k = n6fhx;
        }

        public static /* synthetic */ long C(spXPg spxpg) {
            spxpg.getClass();
            return 60000L;
        }

        public static /* synthetic */ int E(spXPg spxpg) {
            spxpg.getClass();
            return 3;
        }

        public static /* synthetic */ String a(spXPg spxpg) {
            spxpg.getClass();
            return "";
        }

        public static /* synthetic */ String b(spXPg spxpg) {
            spxpg.getClass();
            return "";
        }

        public static /* synthetic */ int c(spXPg spxpg) {
            spxpg.getClass();
            return 0;
        }

        public static /* synthetic */ String d(spXPg spxpg) {
            spxpg.getClass();
            return "";
        }

        public static /* synthetic */ String g(spXPg spxpg) {
            spxpg.getClass();
            return "";
        }

        public static /* synthetic */ boolean o(spXPg spxpg) {
            spxpg.getClass();
            return false;
        }

        public static /* synthetic */ int r(spXPg spxpg) {
            spxpg.getClass();
            return 5000;
        }

        public static /* synthetic */ boolean s(spXPg spxpg) {
            spxpg.getClass();
            return true;
        }

        public static /* synthetic */ ITuringPkgProvider u(spXPg spxpg) {
            spxpg.getClass();
            return null;
        }

        public static /* synthetic */ ITuringIoTFeatureMap v(spXPg spxpg) {
            spxpg.getClass();
            return null;
        }

        public static /* synthetic */ boolean w(spXPg spxpg) {
            spxpg.getClass();
            return false;
        }

        public static /* synthetic */ boolean x(spXPg spxpg) {
            spxpg.getClass();
            return false;
        }
    }

    public jb1kT(spXPg spxpg) {
        this.e = spxpg.f26268a;
        spXPg.g(spxpg);
        this.g = "";
        spXPg.r(spxpg);
        this.u = 5000;
        spXPg.C(spxpg);
        spXPg.E(spxpg);
        this.v = 3;
        spXPg.a(spxpg);
        this.l = "";
        spXPg.b(spxpg);
        this.k = "";
        spXPg.c(spxpg);
        spXPg.d(spxpg);
        this.m = "";
        this.n = spxpg.f26269c;
        this.f = spxpg.b;
        this.h = spxpg.d;
        this.o = spxpg.e;
        this.j = spxpg.f;
        this.r = spxpg.g;
        String unused = spxpg.h;
        this.p = spxpg.i;
        spXPg.o(spxpg);
        this.q = false;
        this.t = spxpg.j;
        this.f26175c = spxpg.k;
        spXPg.s(spxpg);
        this.s = true;
        this.d = spxpg.l;
        spXPg.u(spxpg);
        spXPg.v(spxpg);
        spXPg.w(spxpg);
        spXPg.x(spxpg);
        this.i = spxpg.m;
        this.b = spxpg.n;
        this.w = spxpg.o;
        this.y = spxpg.p;
        this.z = spxpg.q;
        a();
    }
}
