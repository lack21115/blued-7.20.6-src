package com.opos.cmn.g.b.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.opos.cmn.an.transactivity.api.b;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/g/b/a/a.class */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private String f24966a;

    public a(String str) {
        this.f24966a = "";
        this.f24966a = str;
    }

    @Override // com.opos.cmn.an.transactivity.api.b, com.opos.cmn.an.transactivity.a.a
    public void a(Activity activity, Bundle bundle) {
        try {
            if (activity != null) {
                try {
                    com.opos.cmn.an.f.a.b("MkdlTransLifeCallback", "marketUrl:" + this.f24966a);
                    com.opos.cmn.g.b.b.a.a((Context) activity, this.f24966a);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("MkdlTransLifeCallback", "onCreate", e);
                }
            }
        } finally {
            activity.finish();
        }
    }
}
