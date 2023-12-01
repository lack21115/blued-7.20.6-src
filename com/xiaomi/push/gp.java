package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gp.class */
public class gp {

    /* renamed from: a  reason: collision with root package name */
    private int f27760a;

    /* renamed from: a  reason: collision with other field name */
    private String f478a;

    /* renamed from: a  reason: collision with other field name */
    private List<gi> f479a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f27761c;
    private String d;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gp$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f27762a = new a("internal-server-error");
        public static final a b = new a("forbidden");

        /* renamed from: c  reason: collision with root package name */
        public static final a f27763c = new a("bad-request");
        public static final a d = new a("conflict");
        public static final a e = new a("feature-not-implemented");
        public static final a f = new a("gone");
        public static final a g = new a("item-not-found");
        public static final a h = new a("jid-malformed");
        public static final a i = new a("not-acceptable");
        public static final a j = new a("not-allowed");
        public static final a k = new a("not-authorized");
        public static final a l = new a("payment-required");
        public static final a m = new a("recipient-unavailable");
        public static final a n = new a("redirect");
        public static final a o = new a("registration-required");
        public static final a p = new a("remote-server-error");
        public static final a q = new a("remote-server-not-found");
        public static final a r = new a("remote-server-timeout");
        public static final a s = new a("resource-constraint");
        public static final a t = new a("service-unavailable");
        public static final a u = new a("subscription-required");
        public static final a v = new a("undefined-condition");
        public static final a w = new a("unexpected-request");
        public static final a x = new a("request-timeout");

        /* renamed from: a  reason: collision with other field name */
        private String f480a;

        public a(String str) {
            this.f480a = str;
        }

        public String toString() {
            return this.f480a;
        }
    }

    public gp(int i, String str, String str2, String str3, String str4, List<gi> list) {
        this.f479a = null;
        this.f27760a = i;
        this.f478a = str;
        this.f27761c = str2;
        this.b = str3;
        this.d = str4;
        this.f479a = list;
    }

    public gp(Bundle bundle) {
        this.f479a = null;
        this.f27760a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f478a = bundle.getString("ext_err_type");
        }
        this.b = bundle.getString("ext_err_cond");
        this.f27761c = bundle.getString("ext_err_reason");
        this.d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray == null) {
            return;
        }
        this.f479a = new ArrayList(parcelableArray.length);
        int length = parcelableArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            gi a2 = gi.a((Bundle) parcelableArray[i2]);
            if (a2 != null) {
                this.f479a.add(a2);
            }
            i = i2 + 1;
        }
    }

    public gp(a aVar) {
        this.f479a = null;
        a(aVar);
        this.d = null;
    }

    private void a(a aVar) {
        this.b = aVar.f480a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f478a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f27760a);
        String str2 = this.f27761c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<gi> list = this.f479a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (gi giVar : this.f479a) {
                Bundle a2 = giVar.a();
                if (a2 != null) {
                    bundleArr[i] = a2;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8772a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.f27760a);
        sb.append("\"");
        if (this.f478a != null) {
            sb.append(" type=\"");
            sb.append(this.f478a);
            sb.append("\"");
        }
        if (this.f27761c != null) {
            sb.append(" reason=\"");
            sb.append(this.f27761c);
            sb.append("\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.b != null) {
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(this.b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.d);
            sb.append("</text>");
        }
        for (gi giVar : m8773a()) {
            sb.append(giVar.d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<gi> m8773a() {
        synchronized (this) {
            if (this.f479a == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(this.f479a);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.f27760a);
        sb.append(")");
        if (this.d != null) {
            sb.append(" ");
            sb.append(this.d);
        }
        return sb.toString();
    }
}
