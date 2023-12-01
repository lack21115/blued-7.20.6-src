package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gk.class */
public class gk extends gl {

    /* renamed from: a  reason: collision with root package name */
    private boolean f41441a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f515b;

    /* renamed from: c  reason: collision with root package name */
    private String f41442c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    public gk() {
        this.b = null;
        this.f41442c = null;
        this.f41441a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f515b = false;
    }

    public gk(Bundle bundle) {
        super(bundle);
        this.b = null;
        this.f41442c = null;
        this.f41441a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f515b = false;
        this.b = bundle.getString("ext_msg_type");
        this.d = bundle.getString("ext_msg_lang");
        this.f41442c = bundle.getString("ext_msg_thread");
        this.e = bundle.getString("ext_msg_sub");
        this.f = bundle.getString("ext_msg_body");
        this.g = bundle.getString("ext_body_encode");
        this.h = bundle.getString("ext_msg_appid");
        this.f41441a = bundle.getBoolean("ext_msg_trans", false);
        this.f515b = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.gl
    public Bundle a() {
        Bundle a2 = super.a();
        if (!TextUtils.isEmpty(this.b)) {
            a2.putString("ext_msg_type", this.b);
        }
        String str = this.d;
        if (str != null) {
            a2.putString("ext_msg_lang", str);
        }
        String str2 = this.e;
        if (str2 != null) {
            a2.putString("ext_msg_sub", str2);
        }
        String str3 = this.f;
        if (str3 != null) {
            a2.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.g)) {
            a2.putString("ext_body_encode", this.g);
        }
        String str4 = this.f41442c;
        if (str4 != null) {
            a2.putString("ext_msg_thread", str4);
        }
        String str5 = this.h;
        if (str5 != null) {
            a2.putString("ext_msg_appid", str5);
        }
        if (this.f41441a) {
            a2.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.i)) {
            a2.putString("ext_msg_seq", this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            a2.putString("ext_msg_mseq", this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            a2.putString("ext_msg_fseq", this.k);
        }
        if (this.f515b) {
            a2.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.l)) {
            a2.putString("ext_msg_status", this.l);
        }
        return a2;
    }

    @Override // com.xiaomi.push.gl
    /* renamed from: a */
    public String mo11814a() {
        gp a2;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (this.d != null) {
            sb.append(" xml:lang=\"");
            sb.append(h());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(gw.a(l()));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(d())) {
            sb.append(" seq=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" mseq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" fseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" status=\"");
            sb.append(g());
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(gw.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(gw.a(k()));
            sb.append("\"");
        }
        if (this.f41441a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.h)) {
            sb.append(" appid=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" type=\"");
            sb.append(this.b);
            sb.append("\"");
        }
        if (this.f515b) {
            sb.append(" s=\"1\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.e != null) {
            sb.append("<subject>");
            sb.append(gw.a(this.e));
            sb.append("</subject>");
        }
        if (this.f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.g)) {
                sb.append(" encode=\"");
                sb.append(this.g);
                sb.append("\"");
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            sb.append(gw.a(this.f));
            sb.append("</body>");
        }
        if (this.f41442c != null) {
            sb.append("<thread>");
            sb.append(this.f41442c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.b) && (a2 = a()) != null) {
            sb.append(a2.m11822a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public void a(boolean z) {
        this.f41441a = z;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(boolean z) {
        this.f515b = z;
    }

    public String c() {
        return this.h;
    }

    public void c(String str) {
        this.j = str;
    }

    public String d() {
        return this.i;
    }

    public void d(String str) {
        this.k = str;
    }

    public String e() {
        return this.j;
    }

    public void e(String str) {
        this.l = str;
    }

    @Override // com.xiaomi.push.gl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gk gkVar = (gk) obj;
        if (super.equals(gkVar)) {
            String str = this.f;
            if (str != null) {
                if (!str.equals(gkVar.f)) {
                    return false;
                }
            } else if (gkVar.f != null) {
                return false;
            }
            String str2 = this.d;
            if (str2 != null) {
                if (!str2.equals(gkVar.d)) {
                    return false;
                }
            } else if (gkVar.d != null) {
                return false;
            }
            String str3 = this.e;
            if (str3 != null) {
                if (!str3.equals(gkVar.e)) {
                    return false;
                }
            } else if (gkVar.e != null) {
                return false;
            }
            String str4 = this.f41442c;
            if (str4 != null) {
                if (!str4.equals(gkVar.f41442c)) {
                    return false;
                }
            } else if (gkVar.f41442c != null) {
                return false;
            }
            return this.b == gkVar.b;
        }
        return false;
    }

    public String f() {
        return this.k;
    }

    public void f(String str) {
        this.b = str;
    }

    public String g() {
        return this.l;
    }

    public void g(String str) {
        this.e = str;
    }

    public String h() {
        return this.d;
    }

    public void h(String str) {
        this.f = str;
    }

    @Override // com.xiaomi.push.gl
    public int hashCode() {
        String str = this.b;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.f41442c;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        String str4 = this.d;
        int hashCode4 = str4 != null ? str4.hashCode() : 0;
        String str5 = this.e;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
    }

    public void i(String str) {
        this.f41442c = str;
    }

    public void j(String str) {
        this.d = str;
    }
}
