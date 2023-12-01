package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import com.xiaomi.push.ch;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bv.class */
public class bv {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bv f27600a;

    /* renamed from: a  reason: collision with other field name */
    private Context f180a;

    /* renamed from: a  reason: collision with other field name */
    private ck f182a;

    /* renamed from: a  reason: collision with other field name */
    private cl f183a;
    private String e;
    private String f;

    /* renamed from: a  reason: collision with other field name */
    private final String f184a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    private final String f185b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    private final String f186c = "delete_time";
    private final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    private ai.a f181a = new bw(this);
    private ai.a b = new bx(this);

    /* renamed from: c  reason: collision with root package name */
    private ai.a f27601c = new by(this);

    private bv(Context context) {
        this.f180a = context;
    }

    public static bv a(Context context) {
        if (f27600a == null) {
            synchronized (bv.class) {
                try {
                    if (f27600a == null) {
                        f27600a = new bv(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27600a;
    }

    private boolean a() {
        return com.xiaomi.push.service.ba.a(this.f180a).a(hl.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f180a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        p.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f180a.getDatabasePath(bz.f188a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8508a() {
        return this.e;
    }

    public void a(ch.a aVar) {
        ch.a(this.f180a).a(aVar);
    }

    public void a(hk hkVar) {
        if (a() && com.xiaomi.push.service.bz.a(hkVar.e())) {
            a(ce.a(this.f180a, c(), hkVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cm.a(this.f180a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f182a != null) {
            if (bool.booleanValue()) {
                this.f182a.a(this.f180a, str2, str);
            } else {
                this.f182a.b(this.f180a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
