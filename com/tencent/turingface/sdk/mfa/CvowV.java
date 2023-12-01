package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/CvowV.class */
public class CvowV {

    /* renamed from: a  reason: collision with root package name */
    public static final spXPg f26174a = new spXPg();
    public BfUKf b;

    /* renamed from: c  reason: collision with root package name */
    public n6fHX f26175c;
    public ITuringDeviceInfoProvider d;
    public Context e;
    public int f = 0;
    public String g = "";
    public boolean h = true;
    public String i = "";
    public String j = "";
    public String k = "";
    public String l = "";
    public String m = "";
    public Map<Integer, String> n = new HashMap();
    public String o = "";
    public boolean p = true;
    public boolean q = false;
    public boolean r = true;
    public boolean s = true;
    public boolean t = true;
    public long u = 5000;
    public int v = 3;
    public long w = 5000;
    public boolean x = false;
    public Set<Integer> y;
    public String z;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/CvowV$spXPg.class */
    public final class spXPg implements com.tencent.turingface.sdk.mfa.spXPg {
        @Override // com.tencent.turingface.sdk.mfa.spXPg
        public final boolean a() {
            return false;
        }
    }

    public final void a() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = "https://tdid.m.qq.com?mc=2";
        }
        if (this.b == null) {
            this.b = new kB0t4(this.i);
        } else {
            this.x = true;
        }
    }

    public final String b() {
        return TextUtils.isEmpty(this.o) ? "" : this.o;
    }
}
