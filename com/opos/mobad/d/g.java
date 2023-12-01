package com.opos.mobad.d;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/g.class */
public class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public Context f25985a;

    public g(Context context) {
        this.f25985a = context;
    }

    @Override // com.opos.mobad.d.f
    public File a(String str) {
        if (this.f25985a == null || TextUtils.isEmpty(str) || !com.opos.cmn.an.d.b.a.a()) {
            return null;
        }
        String b = com.opos.cmn.d.c.b(this.f25985a);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        File file = new File(b);
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        String a2 = com.opos.cmn.d.c.a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new File(file, a2);
    }

    @Override // com.opos.mobad.d.f
    public File a(String str, String str2) {
        if (this.f25985a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !com.opos.cmn.an.d.b.a.a()) {
            return null;
        }
        String b = com.opos.cmn.d.c.b(this.f25985a);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        File file = new File(b + File.separator + str2);
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        String a2 = com.opos.cmn.d.c.a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new File(file, a2);
    }
}
