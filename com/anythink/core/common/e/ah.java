package com.anythink.core.common.e;

import android.text.TextUtils;
import com.anythink.core.c.d;
import com.anythink.core.common.c.l;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/ah.class */
public abstract class ah {
    public static final String O = "ofm_tid_key";
    public static final int P = 1;
    public static final int Q = 2;
    public static final int R = 3;
    public static final int S = 4;
    public static final int T = 5;
    public static final int U = 6;
    public static final int V = 7;
    public static final int W = 8;
    public static final int X = 10;
    public static final int Y = 0;
    public static final int Z = 1;
    public static final int aa = 2;
    public static final int ab = 3;
    public static final int ac = 4;
    public static final int ad = 5;
    public static final int ae = 8;
    public static final String af = "0";
    public static final String ag = "1";
    public static final String ah = "2";
    public static final String ai = "3";
    public static final String aj = "4";
    private String a;
    protected String ak;
    protected String al;
    protected String am;
    protected String an;
    public String ao;
    public int ap;
    public int aq;
    protected String ar;
    protected int as;
    protected int at;
    protected int au;
    protected int av = -1;
    private String b;
    private int c;

    private int a() {
        return this.au;
    }

    private void a(int i) {
        this.ap = i;
    }

    private void a(String str) {
        this.ao = str;
    }

    private int b() {
        return this.as;
    }

    private void b(int i) {
        this.aq = i;
    }

    private String c() {
        return this.ao;
    }

    private int d() {
        return this.ap;
    }

    private int e() {
        return this.aq;
    }

    public JSONObject A(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i);
            jSONObject.put("pl_id", this.ak);
            jSONObject.put("req_id", this.al);
            if (!TextUtils.isEmpty(this.am)) {
                jSONObject.put(l.a.b, Integer.parseInt(this.am));
            }
            jSONObject.put("ps_id", com.anythink.core.common.b.n.a().r());
            String g = com.anythink.core.common.b.n.a().g(this.ak);
            if (!TextUtils.isEmpty(g)) {
                jSONObject.put("sessionid", g);
            }
            if (this.av != -1) {
                jSONObject.put("traffic_group_id", this.av);
            }
            if (this.au == 1) {
                jSONObject.put("ofm_tid", this.at);
                jSONObject.put("ofm_system", this.as);
                jSONObject.put(com.anythink.core.common.g.c.M, this.au);
            }
            jSONObject.put("asid", this.an);
            jSONObject.put(d.a.U, this.a);
            jSONObject.put(com.anythink.core.common.g.c.am, this.b);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final void B(int i) {
        this.c = i;
    }

    public final void C(int i) {
        this.au = i;
    }

    public final void D(int i) {
        this.at = i;
    }

    public final void E(int i) {
        this.av = i;
    }

    public final int O() {
        return this.c;
    }

    public final String P() {
        return this.a;
    }

    public final String Q() {
        return this.b;
    }

    public final void R() {
        this.as = 1;
    }

    public final int S() {
        return this.at;
    }

    public final String T() {
        return this.ar;
    }

    public final int U() {
        return this.av;
    }

    public final String V() {
        return this.an;
    }

    public final String W() {
        return this.ak;
    }

    public final String X() {
        return this.al;
    }

    public final String Y() {
        return this.am;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String Z() {
        boolean z;
        String str = this.am;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 49:
                if (str.equals("1")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 50:
                if (str.equals("2")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 51:
                if (str.equals("3")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 52:
                if (str.equals("4")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        return z ? !z ? !z ? !z ? !z ? "none" : "splash" : "inter" : "banner" : "reward" : "native";
    }

    public final void t(String str) {
        this.a = str;
    }

    public final void u(String str) {
        this.b = str;
    }

    public final void v(String str) {
        this.ar = str;
    }

    public final void w(String str) {
        this.an = str;
    }

    public final void x(String str) {
        this.ak = str;
    }

    public final void y(String str) {
        this.al = str;
    }

    public final void z(String str) {
        this.am = str;
    }
}
