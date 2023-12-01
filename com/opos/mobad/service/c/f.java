package com.opos.mobad.service.c;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/c/f.class */
public class f implements com.opos.mobad.d.f {

    /* renamed from: a  reason: collision with root package name */
    public Context f27322a;

    public f(Context context) {
        this.f27322a = context;
    }

    public static final File a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        File file2 = new File(b(context));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return new File(file2, file.getName());
    }

    public static final String a(Context context) {
        if (context == null) {
            return null;
        }
        String b = com.opos.cmn.d.c.b(context);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        return b + File.separator + ".dynamic";
    }

    public static final String b(Context context) {
        if (context == null) {
            return null;
        }
        return a(context) + File.separator + ".unzip";
    }

    @Override // com.opos.mobad.d.f
    public File a(String str) {
        if (this.f27322a == null || TextUtils.isEmpty(str) || !com.opos.cmn.an.d.b.a.a()) {
            return null;
        }
        String a2 = a(this.f27322a);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        File file = new File(a2);
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        String a3 = com.opos.cmn.d.c.a(str);
        if (TextUtils.isEmpty(a3)) {
            return null;
        }
        return new File(file, a3);
    }

    @Override // com.opos.mobad.d.f
    public File a(String str, String str2) {
        if (this.f27322a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !com.opos.cmn.an.d.b.a.a()) {
            return null;
        }
        String a2 = a(this.f27322a);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        File file = new File(a2 + File.separator + ".dynamic");
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        String a3 = com.opos.cmn.d.c.a(str);
        if (TextUtils.isEmpty(a3)) {
            return null;
        }
        return new File(file, a3);
    }

    public String b(String str) {
        File a2 = a(str);
        if (a2 != null) {
            return a2.getAbsolutePath();
        }
        return null;
    }
}
