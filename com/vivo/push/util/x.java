package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/x.class */
public final class x implements d {

    /* renamed from: a  reason: collision with root package name */
    private static String f27456a = "SpCache";
    private static String b = "com.vivo.push.cache";

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f27457c;

    @Override // com.vivo.push.util.d
    public final String a(String str, String str2) {
        String string = this.f27457c.getString(str, str2);
        String str3 = f27456a;
        p.d(str3, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor edit = this.f27457c.edit();
        if (edit != null) {
            edit.clear();
            b.a(edit);
        }
        p.d(f27456a, "system cache is cleared");
    }

    @Override // com.vivo.push.util.d
    public final boolean a(Context context) {
        if (this.f27457c == null) {
            this.f27457c = context.getSharedPreferences(b, 0);
            return true;
        }
        return true;
    }

    @Override // com.vivo.push.util.d
    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.f27457c.edit();
        if (edit == null) {
            p.b(f27456a, "putString error by ".concat(String.valueOf(str)));
            return;
        }
        edit.putString(str, str2);
        b.a(edit);
        p.d(f27456a, "putString by ".concat(String.valueOf(str)));
    }
}
