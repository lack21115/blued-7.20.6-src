package com.opos.mobad.service.i;

import com.huawei.openalliance.ad.constant.t;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/i/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f13693a = new StringBuilder();

    public int a() {
        return this.f13693a.length();
    }

    public c a(String str, String str2) {
        if (this.f13693a.length() > 0) {
            this.f13693a.append(t.aE);
        }
        this.f13693a.append(str);
        this.f13693a.append(":");
        this.f13693a.append(str2);
        return this;
    }

    public String b() {
        return this.f13693a.toString();
    }
}
