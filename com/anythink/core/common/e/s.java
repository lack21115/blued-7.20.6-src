package com.anythink.core.common.e;

import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/s.class */
public final class s extends i<u> {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6676a = 1;
    public static final int b = 2;
    public int R;
    public long S;
    String T = "";
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private long ae;
    private int af;
    private String ag;
    private String ah;
    private String ai;
    private String aj;
    private String ak;

    private String Z() {
        return this.ak;
    }

    private int aa() {
        return this.R;
    }

    private long ab() {
        return this.S;
    }

    private long ac() {
        return this.ae;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a5  */
    /* renamed from: b  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> b2(com.anythink.core.common.e.u r7) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.s.b2(com.anythink.core.common.e.u):java.util.List");
    }

    private void b(long j) {
        this.S = j;
    }

    private void g(int i) {
        this.R = i;
    }

    public final void E(String str) {
        this.ah = str;
    }

    public final void F(String str) {
        this.ai = str;
    }

    public final void G(String str) {
        this.aj = str;
    }

    public final void H(String str) {
        this.U = str;
    }

    public final void I(String str) {
        this.V = str;
    }

    public final void J(String str) {
        this.W = str;
    }

    public final void K(String str) {
        this.X = str;
    }

    public final void L(String str) {
        this.Y = str;
    }

    public final void M(String str) {
        this.Z = str;
    }

    public final String N() {
        return this.aj;
    }

    public final void N(String str) {
        this.aa = str;
    }

    public final int O() {
        return this.af;
    }

    public final void O(String str) {
        this.ab = str;
    }

    public final String P() {
        return this.U;
    }

    public final void P(String str) {
        this.ac = str;
    }

    public final String Q() {
        return this.V;
    }

    public final void Q(String str) {
        this.ad = str;
    }

    public final String R() {
        return this.W;
    }

    public final String R(String str) {
        String str2 = str;
        try {
            JSONObject jSONObject = new JSONObject(this.ak);
            Iterator<String> keys = jSONObject.keys();
            while (true) {
                str2 = str;
                if (!keys.hasNext()) {
                    return str;
                }
                String str3 = str;
                String next = keys.next();
                String str4 = str;
                StringBuilder sb = new StringBuilder("\\{");
                String str5 = str;
                sb.append(next);
                String str6 = str;
                sb.append("\\}");
                String str7 = str;
                str = str.replaceAll(sb.toString(), jSONObject.optString(next));
            }
        } catch (Throwable th) {
            return str2;
        }
    }

    public final String S() {
        return this.X;
    }

    public final String T() {
        return this.Y;
    }

    public final String U() {
        return this.Z;
    }

    public final String V() {
        return this.aa;
    }

    public final String W() {
        return this.ab;
    }

    public final String X() {
        return this.ac;
    }

    public final String Y() {
        return this.ad;
    }

    public final String a() {
        return this.ag;
    }

    public final void a(int i) {
        this.af = i;
    }

    public final void a(long j) {
        this.ae = j;
    }

    public final void a(String str) {
        this.ak = str;
    }

    public final boolean a(u uVar) {
        return uVar == null || System.currentTimeMillis() - this.ae > uVar.A();
    }

    public final String b() {
        return this.ah;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ad  */
    @Override // com.anythink.core.common.e.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.util.List b(com.anythink.core.common.e.u r7) {
        /*
            Method dump skipped, instructions count: 848
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.s.b(com.anythink.core.common.e.k):java.util.List");
    }

    public final void b(String str) {
        this.ag = str;
    }

    public final String c() {
        return this.ai;
    }

    @Override // com.anythink.core.common.e.i
    public final int d() {
        return 1;
    }

    @Override // com.anythink.core.common.e.i
    public final String m() {
        return this.T;
    }
}
