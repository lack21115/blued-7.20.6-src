package com.anythink.expressad.foundation.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.foundation.h.t;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/r.class */
public final class r {
    public static final int A = 22;
    public static final int B = 21;
    public static final int C = 10;
    public static final int D = 11;
    public static final int E = 12;
    public static final String F = "1";
    public static final String G = "2";
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 3;
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;
    public static final int P = 5;
    public static final int Q = 6;
    public static final int R = 1;
    public static final int S = 2;
    public static final int T = 3;
    public static final int U = 4;
    public static final String V = "key";
    public static final String W = "network_type";
    public static final String X = "network_str";
    public static final String Y = "is_complete_view";
    public static final String Z = "watched_millis";

    /* renamed from: a  reason: collision with root package name */
    public static final String f4964a = "2000020";
    public static final String aA = "ad_type";
    public static final String aB = "resource_type";
    public static final String aC = "devid";
    public static final String aD = "creative";
    public static final String aE = "mraid_type";
    public static final String aF = "adspace_t";
    public static final String aG = "1";
    public static final String aH = "2";
    public static final String aI = "1";
    public static final String aJ = "2";
    public static final String aK = "3";
    public static final String aL = "4";
    public static final String aM = "5";
    public static final String aN = "6";
    public static final String aO = "7";
    public static final String aP = "8";
    public static int aQ = 1;
    public static int aR = 0;
    private static final String aS = "VideoReportData";
    public static final String aa = "video_length";
    public static final String ab = "offer_url";
    public static final String ac = "reason";
    public static final String ad = "case";
    public static final String ae = "time";
    public static final String af = "platform";
    public static final String ag = "duration";
    public static final String ah = "result";
    public static final String ai = "video_size";
    public static final String aj = "ctype";
    public static final String ak = "unit_id";
    public static final String al = "cid";
    public static final String am = "endscreen_type";
    public static final String an = "error";
    public static final String ao = "template_url";
    public static final String ap = "template";
    public static final String aq = "aback";

    /* renamed from: ar  reason: collision with root package name */
    public static final String f4965ar = "event";
    public static final String as = "layout";
    public static final String at = "type";
    public static final String au = "endcard_url";
    public static final String av = "video_url";
    public static final String aw = "template_url";
    public static final String ax = "rid";
    public static final String ay = "rid_n";
    public static final String az = "image_url";
    public static final String b = "2000021";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4966c = "2000054";
    public static final String d = "2000022";
    public static final String e = "2000023";
    public static final String f = "2000024";
    public static final String g = "2000025";
    public static final String h = "2000030";
    public static final String i = "2000037";
    public static final String j = "2000039";
    public static final String k = "2000043";
    public static final String l = "2000044";
    public static final String m = "2000045";
    public static final String n = "2000060";
    public static final String o = "2000059";
    public static final String p = "2000063";
    public static final String q = "2000061";
    public static final String r = "2000062";
    public static final String s = "2000073";
    public static final String t = "2000074";
    public static final String u = "2000075";
    public static final String v = "2000076";
    public static final int w = 14;
    public static final int x = 2;
    public static final int y = 3;
    public static final int z = 20;
    private String aT;
    private String aU;
    private String aV;
    private String aW;
    private int aX;
    private String aY;
    private int aZ;
    private String bA;
    private int bB;
    private int bC;
    private int ba;
    private int bb;
    private String bc;
    private String bd;
    private int be;
    private int bf;
    private String bg;
    private long bh;
    private int bi;
    private int bj;
    private String bk;
    private String bl;
    private String bm;
    private String bn;
    private int bo;
    private String bp;
    private String bq;
    private String br;
    private String bs;
    private String bt;
    private String bu;
    private String bv;
    private String bw;
    private String bx;
    private String by;
    private String bz;

    public r() {
        this.bj = 0;
        this.bB = 0;
    }

    private r(Context context, c cVar, int i2, String str, long j2, int i3) {
        this.bj = 0;
        this.bB = 0;
        if (i3 == 1) {
            this.aW = d;
        } else if (i3 == 287 || i3 == 94) {
            this.aW = d;
        } else if (i3 == 95) {
            this.aW = g;
        }
        int a2 = com.anythink.expressad.foundation.h.k.a();
        this.aX = a2;
        this.aY = com.anythink.expressad.foundation.h.k.a(context, a2);
        this.bb = cVar.bi();
        this.bk = cVar.Z();
        this.bl = cVar.aa();
        if (!TextUtils.isEmpty(this.bc)) {
            try {
                this.bc = URLEncoder.encode(cVar.ah() == null ? cVar.ad() : cVar.ah(), "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        this.bf = i2;
        this.bg = str;
        this.bh = j2 == 0 ? cVar.T() : j2;
    }

    private r(String str) {
        this.bj = 0;
        this.bB = 0;
        this.bv = str;
    }

    private r(String str, int i2, int i3, int i4, int i5, String str2, int i6, String str3) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.aY = str3;
        this.aX = i2;
        this.aZ = i3;
        this.ba = i4;
        this.bb = i5;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.bc = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        this.bj = i6;
    }

    private r(String str, int i2, int i3, int i4, int i5, String str2, String str3, int i6, String str4, int i7, String str5) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.aX = i2;
        this.aY = str5;
        this.aZ = i3;
        this.ba = i4;
        this.bb = i5;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.bc = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.bd = str3;
        this.bf = i6;
        this.bg = str4;
        this.bh = i7;
    }

    private r(String str, int i2, int i3, String str2, int i4, int i5, String str3) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.aX = i2;
        this.aY = str3;
        this.bb = i3;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.bc = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        this.bi = i4;
        this.bj = i5;
    }

    private r(String str, int i2, int i3, String str2, int i4, String str3, int i5, String str4) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.aX = i2;
        this.aY = str4;
        this.bb = i3;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.bc = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        this.bf = i4;
        this.bg = str3;
        this.bh = i5;
    }

    private r(String str, int i2, String str2, String str3, String str4) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.aY = str4;
        this.aX = i2;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.bc = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        this.bd = str3;
    }

    public r(String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.bf = i2;
        this.bg = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.bx = URLEncoder.encode(str3, "utf-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.bn = str4;
        this.bm = str5;
        this.bd = str6;
        this.bw = str7;
        if (Integer.valueOf(str2).intValue() > com.anythink.expressad.foundation.g.a.cq) {
            this.bf = 2;
        }
    }

    private r(String str, String str2, String str3, String str4, int i2, String str5, int i3, String str6) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.bk = str2;
        this.bl = str3;
        this.bm = str4;
        this.aX = i2;
        this.aY = str6;
        this.bn = str5;
        this.bo = i3;
    }

    public r(String str, String str2, String str3, String str4, String str5, int i2) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.bn = str2;
        this.bk = str3;
        this.bl = str4;
        this.bm = str5;
        this.aX = i2;
    }

    public r(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.bn = str2;
        this.bk = str3;
        this.bl = str4;
        this.bm = str5;
        this.aX = i2;
        this.bd = str6;
        this.be = i3;
    }

    public r(String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7) {
        this.bj = 0;
        this.bB = 0;
        this.aW = str;
        this.bt = str2;
        this.bq = str3;
        this.bu = str4;
        this.bm = str5;
        this.bn = str6;
        this.aX = i2;
        this.aY = str7;
    }

    private int A() {
        return this.ba;
    }

    private int B() {
        return this.bb;
    }

    private String C() {
        return this.bc;
    }

    private String D() {
        return TextUtils.isEmpty(this.bd) ? "" : this.bd;
    }

    private String E() {
        return this.bg;
    }

    private long F() {
        return this.bh;
    }

    private int G() {
        return this.aX;
    }

    private String H() {
        return this.aY;
    }

    private int I() {
        return this.aZ;
    }

    private int J() {
        return this.bf;
    }

    private int a() {
        return this.be;
    }

    public static String a(r rVar) {
        String str;
        String str2;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + rVar.aW + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("error=" + t.c(rVar.br) + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("template_url=" + t.c(rVar.bp) + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("unit_id=" + t.c(rVar.bm) + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("cid=" + t.c(rVar.bn) + ContainerUtils.FIELD_DELIMITER);
            if (TextUtils.isEmpty(rVar.aY)) {
                str = "";
            } else {
                str = "network_str=" + rVar.aY + ContainerUtils.FIELD_DELIMITER;
            }
            stringBuffer.append(str);
            if (TextUtils.isEmpty(rVar.aY)) {
                str2 = "";
            } else {
                str2 = "network_type=" + rVar.aX;
            }
            stringBuffer.append(str2);
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(List<r> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (r rVar : list) {
            stringBuffer.append("key=" + rVar.aW + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("result=" + rVar.bf + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("duration=" + rVar.bg + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("endcard_url=" + rVar.bx + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("cid=" + rVar.bn + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("unit_id=" + rVar.bm + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("reason=" + rVar.D() + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("ad_type=" + rVar.bA + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid=" + rVar.bk + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid_n=" + rVar.bl + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("type=" + rVar.bw + ContainerUtils.FIELD_DELIMITER);
            StringBuilder sb = new StringBuilder("adspace_t=");
            sb.append(rVar.bC);
            stringBuffer.append(sb.toString());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    private String b() {
        return this.aT;
    }

    private static String b(r rVar) {
        if (rVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + rVar.aW + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("cid=" + rVar.bn + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("unit_id=" + rVar.bm + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("network_type=" + rVar.aX + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid=" + rVar.bk + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid_n=" + rVar.bl + ContainerUtils.FIELD_DELIMITER);
            StringBuilder sb = new StringBuilder("reason=");
            sb.append(rVar.D());
            stringBuffer.append(sb.toString());
            stringBuffer.append("\n");
            return stringBuffer.toString();
        }
        return null;
    }

    private static String b(List<r> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (r rVar : list) {
                        stringBuffer.append(rVar.bv);
                        stringBuffer.append("\n");
                    }
                    return stringBuffer.toString();
                }
                return null;
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.b(aS, th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    private String c() {
        return this.aU;
    }

    private static String c(r rVar) {
        if (rVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + rVar.aW + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("cid=" + rVar.bn + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("unit_id=" + rVar.bm + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("network_type=" + rVar.aX + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("mraid_type=" + rVar.bB + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid_n=" + rVar.bl + ContainerUtils.FIELD_DELIMITER);
            StringBuilder sb = new StringBuilder("rid=");
            sb.append(rVar.bk);
            stringBuffer.append(sb.toString());
            stringBuffer.append("\n");
            return stringBuffer.toString();
        }
        return null;
    }

    private String d() {
        return this.aV;
    }

    private static String d(r rVar) {
        if (rVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + rVar.aW + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("result=" + rVar.bf + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("duration=" + rVar.bg + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("cid=" + rVar.bn + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("reason=" + rVar.D() + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("ad_type=" + rVar.bA + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("unit_id=" + rVar.bm + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("devid=" + rVar.aU + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("mraid_type=" + rVar.bB + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("network_type=" + rVar.aX + ContainerUtils.FIELD_DELIMITER);
            if (!TextUtils.isEmpty(rVar.bx)) {
                stringBuffer.append("endcard_url=" + rVar.bx + ContainerUtils.FIELD_DELIMITER);
            }
            if (!TextUtils.isEmpty(rVar.bw)) {
                stringBuffer.append("type=" + rVar.bw + ContainerUtils.FIELD_DELIMITER);
            }
            if (rVar.aT != null) {
                stringBuffer.append("resource_type=" + rVar.aT + ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("rid_n=" + rVar.bl + ContainerUtils.FIELD_DELIMITER);
            StringBuilder sb = new StringBuilder("rid=");
            sb.append(rVar.bk);
            stringBuffer.append(sb.toString());
            stringBuffer.append("\n");
            return stringBuffer.toString();
        }
        return null;
    }

    private String e() {
        return this.bz;
    }

    private static String e(r rVar) {
        if (rVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + rVar.aW + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("result=" + rVar.bf + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("duration=" + rVar.bg + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("cid=" + rVar.bn + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("unit_id=" + rVar.bm + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("reason=" + rVar.D() + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("ad_type=" + rVar.bA + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid=" + rVar.bk + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid_n=" + rVar.bl + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("network_type=" + rVar.aX + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("mraid_type=" + rVar.bB + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("devid=" + rVar.aU + ContainerUtils.FIELD_DELIMITER);
            if (rVar.aT != null) {
                stringBuffer.append("resource_type=" + rVar.aT + ContainerUtils.FIELD_DELIMITER);
            }
            if (!TextUtils.isEmpty(rVar.bx)) {
                stringBuffer.append("endcard_url=" + rVar.bx + ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("type=" + rVar.bw);
            return stringBuffer.toString();
        }
        return null;
    }

    private void e(int i2) {
        this.be = i2;
    }

    private String f() {
        return this.by;
    }

    private static String f(r rVar) {
        if (rVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + rVar.aW + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("cid=" + rVar.bn + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid=" + rVar.bk + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid_n=" + rVar.bl + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("unit_id=" + rVar.bm + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("network_type=" + rVar.aX + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("mraid_type=" + rVar.bB + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("platform=1");
            return stringBuffer.toString();
        }
        return "";
    }

    private void f(int i2) {
        this.bj = i2;
    }

    private String g() {
        return this.bx;
    }

    private static String g(r rVar) {
        if (rVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + rVar.aW + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("cid=" + rVar.bn + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid=" + rVar.bk + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("rid_n=" + rVar.bl + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("unit_id=" + rVar.bm + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("reason=" + rVar.D() + ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append("case=" + rVar.be + ContainerUtils.FIELD_DELIMITER);
            StringBuilder sb = new StringBuilder("network_type=");
            sb.append(rVar.aX);
            stringBuffer.append(sb.toString());
            return stringBuffer.toString();
        }
        return "";
    }

    private void g(int i2) {
        this.bi = i2;
    }

    private String h() {
        return this.bw;
    }

    private void h(int i2) {
        this.bo = i2;
    }

    private String i() {
        return this.bA;
    }

    private void i(int i2) {
        this.ba = i2;
    }

    private int j() {
        return this.bj;
    }

    private void j(int i2) {
        this.bb = i2;
    }

    private int k() {
        return this.bi;
    }

    private void k(int i2) {
        this.bh = i2;
    }

    private void k(String str) {
        this.aT = str;
    }

    private String l() {
        return this.bp;
    }

    private void l(int i2) {
        this.aZ = i2;
    }

    private void l(String str) {
        this.aU = str;
    }

    private String m() {
        return this.br;
    }

    private void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.aV = URLEncoder.encode(str);
    }

    private String n() {
        return this.bs;
    }

    private void n(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.bz = URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String o() {
        return this.bq;
    }

    private void o(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.by = URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String p() {
        return this.bt;
    }

    private void p(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.bx = URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String q() {
        return this.bu;
    }

    private void q(String str) {
        this.bw = str;
    }

    private String r() {
        return this.bv;
    }

    private void r(String str) {
        this.bs = str;
    }

    private int s() {
        return this.bB;
    }

    private void s(String str) {
        this.bq = str;
    }

    private int t() {
        return this.bC;
    }

    private void t(String str) {
        this.bt = str;
    }

    private String u() {
        return this.bk;
    }

    private void u(String str) {
        this.bu = str;
    }

    private String v() {
        return this.bl;
    }

    private void v(String str) {
        this.bv = str;
    }

    private String w() {
        return this.bm;
    }

    private void w(String str) {
        this.bc = str;
    }

    private String x() {
        return this.bn;
    }

    private void x(String str) {
        this.bg = str;
    }

    private int y() {
        return this.bo;
    }

    private String z() {
        return this.aW;
    }

    public final void a(int i2) {
        this.bB = i2;
    }

    public final void a(String str) {
        this.bA = str;
    }

    public final void b(int i2) {
        this.bC = i2;
    }

    public final void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.bp = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    public final void c(int i2) {
        this.aX = i2;
    }

    public final void c(String str) {
        this.br = str;
    }

    public final void d(int i2) {
        this.bf = i2;
    }

    public final void d(String str) {
        this.bk = str;
    }

    public final void e(String str) {
        this.bl = str;
    }

    public final void f(String str) {
        this.bm = str;
    }

    public final void g(String str) {
        this.bn = str;
    }

    public final void h(String str) {
        this.aW = str;
    }

    public final void i(String str) {
        this.bd = str;
    }

    public final void j(String str) {
        this.aY = str;
    }

    public final String toString() {
        return "RewardReportData [key=" + this.aW + ", networkType=" + this.aX + ", isCompleteView=" + this.aZ + ", watchedMillis=" + this.ba + ", videoLength=" + this.bb + ", offerUrl=" + this.bc + ", reason=" + this.bd + ", result=" + this.bf + ", duration=" + this.bg + ", videoSize=" + this.bh + "]";
    }
}
