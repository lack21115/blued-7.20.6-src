package com.xiaomi.push;

import android.os.Bundle;
import com.heytap.mcssdk.constant.IntentConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gj.class */
public class gj extends gl {

    /* renamed from: a  reason: collision with root package name */
    private a f27747a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, String> f466a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gj$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f27748a = new a(MonitorConstants.CONNECT_TYPE_GET);
        public static final a b = new a("set");

        /* renamed from: c  reason: collision with root package name */
        public static final a f27749c = new a("result");
        public static final a d = new a("error");
        public static final a e = new a(IntentConstant.COMMAND);

        /* renamed from: a  reason: collision with other field name */
        private String f467a;

        private a(String str) {
            this.f467a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f27748a.toString().equals(lowerCase)) {
                return f27748a;
            }
            if (b.toString().equals(lowerCase)) {
                return b;
            }
            if (d.toString().equals(lowerCase)) {
                return d;
            }
            if (f27749c.toString().equals(lowerCase)) {
                return f27749c;
            }
            if (e.toString().equals(lowerCase)) {
                return e;
            }
            return null;
        }

        public String toString() {
            return this.f467a;
        }
    }

    public gj() {
        this.f27747a = a.f27748a;
        this.f466a = new HashMap();
    }

    public gj(Bundle bundle) {
        super(bundle);
        this.f27747a = a.f27748a;
        this.f466a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.f27747a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.gl
    public Bundle a() {
        Bundle a2 = super.a();
        a aVar = this.f27747a;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m8763a() {
        return this.f27747a;
    }

    @Override // com.xiaomi.push.gl
    /* renamed from: a  reason: collision with other method in class */
    public String mo8764a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(gw.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(gw.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(gw.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f466a.entrySet()) {
            sb.append(gw.a(entry.getKey()));
            sb.append("=\"");
            sb.append(gw.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.f27747a == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(m8763a());
            str = "\">";
        }
        sb.append(str);
        String b = b();
        if (b != null) {
            sb.append(b);
        }
        sb.append(o());
        gp a2 = a();
        if (a2 != null) {
            sb.append(a2.m8772a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.f27747a = a.f27748a;
        } else {
            this.f27747a = aVar;
        }
    }

    public void a(Map<String, String> map) {
        synchronized (this) {
            this.f466a.putAll(map);
        }
    }

    public String b() {
        return null;
    }
}
