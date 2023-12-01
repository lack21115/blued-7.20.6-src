package com.opos.mobad.model.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/p.class */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f12754a = new StringBuilder();

    public p a(String str, int i) {
        this.f12754a.append(str);
        this.f12754a.append(":");
        this.f12754a.append(i);
        this.f12754a.append(com.huawei.openalliance.ad.constant.t.aE);
        return this;
    }

    public p a(String str, String str2) {
        this.f12754a.append(str);
        this.f12754a.append(":");
        this.f12754a.append(str2);
        this.f12754a.append(com.huawei.openalliance.ad.constant.t.aE);
        return this;
    }

    public String a() {
        return this.f12754a.toString();
    }
}
