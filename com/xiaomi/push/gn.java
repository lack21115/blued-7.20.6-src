package com.xiaomi.push;

import android.os.Bundle;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gn.class */
public class gn extends gl {

    /* renamed from: a  reason: collision with root package name */
    private int f41445a;

    /* renamed from: a  reason: collision with other field name */
    private a f521a;

    /* renamed from: a  reason: collision with other field name */
    private b f522a;
    private String b;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gn$a.class */
    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gn$b.class */
    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public gn(Bundle bundle) {
        super(bundle);
        this.f522a = b.available;
        this.b = null;
        this.f41445a = Integer.MIN_VALUE;
        this.f521a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f522a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f41445a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f521a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public gn(b bVar) {
        this.f522a = b.available;
        this.b = null;
        this.f41445a = Integer.MIN_VALUE;
        this.f521a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.gl
    public Bundle a() {
        Bundle a2 = super.a();
        b bVar = this.f522a;
        if (bVar != null) {
            a2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.b;
        if (str != null) {
            a2.putString("ext_pres_status", str);
        }
        int i = this.f41445a;
        if (i != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", i);
        }
        a aVar = this.f521a;
        if (aVar != null && aVar != a.available) {
            a2.putString("ext_pres_mode", this.f521a.toString());
        }
        return a2;
    }

    @Override // com.xiaomi.push.gl
    /* renamed from: a */
    public String mo11814a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
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
        if (this.f522a != null) {
            sb.append(" type=\"");
            sb.append(this.f522a);
            sb.append("\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.b != null) {
            sb.append("<status>");
            sb.append(gw.a(this.b));
            sb.append("</status>");
        }
        if (this.f41445a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.f41445a);
            sb.append("</priority>");
        }
        a aVar = this.f521a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f521a);
            sb.append("</show>");
        }
        sb.append(o());
        gp a2 = a();
        if (a2 != null) {
            sb.append(a2.m11822a());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    public void a(int i) {
        if (i >= -128 && i <= 128) {
            this.f41445a = i;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
    }

    public void a(a aVar) {
        this.f521a = aVar;
    }

    public void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.f522a = bVar;
    }

    public void a(String str) {
        this.b = str;
    }
}
